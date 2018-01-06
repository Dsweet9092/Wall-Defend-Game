
package com.gamedev.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;


// the game class that runs the program
public class Game extends Canvas implements Runnable {
    
    private static final long serialVersionUID = 1L;
    public static final int WIDTHW = 800;
    public static final int HEIGHTH = 600;
   
    private Thread thread;
    private boolean running = false;
    
    private Handler handler;
    private GameObject object;    
    private HUD hud;
    static Texture tex;
    
    public MouseInput input;
    
    public int xpos = 100;
    
    private Random rand;
    
    private Spawn spawner;
    private Bullet bullet;
    private CoolDown cd;
    
    private Menu menu;
    
    private Controller c;
    
    private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
    
    private BufferedImage playerTex = null;
    
    public void init() throws IOException {
        
        //WIDTH = getWidth();
        //HEIGHT = getHeight();
        
        tex = new Texture();
        
        ImageLoader loader = new ImageLoader();
        
        playerTex = loader.loadImage("/Cannon.png");
        
        
        
    }
    
    public enum STATE {
        
        Menu,
        Game,
        End,
        Options;
        
    }
    
    public STATE gameState =  STATE.Menu;
    
    
    public Game() {
        
        handler = new Handler();
        hud = new HUD();
        menu = new Menu(this, handler, hud);
        
        if (gameState == STATE.Menu || gameState == STATE.End) 
        this.addMouseListener(menu);
        
        if (gameState == STATE.Options)
            this.addMouseListener(menu);
        //else if (gameState == STATE.Game) 
        
       
        
        new Window(WIDTHW, HEIGHTH, "Wall Defense", this);
        
        
        
        rand = new  Random();
        spawner = new Spawn(handler, hud);
        
        //if (gameState == STATE.Game) {

        /*handler.addObject(new Wall(50, 500, ID.Wall, handler));
        handler.addObject(new Player(400, 500, ID.Player, handler));
        
        handler.addObject(new AssistTurret(0,0, ID.AssistTurret, handler));
        */
        //}
                
    }
    
    synchronized void start() {
        
        if(running)
            return;
        
        running = true;
        
        thread = new Thread(this);
        thread.start();
        
    }
    
    synchronized void stop() {
        
        if(!running)
            return;
        
        running = false;
        
        try {
            thread.join();
        }
        
        catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        
        System.exit(1);
        
    }
    
    public void run() {
        
        this.requestFocus();
        
        long time = System.nanoTime();
        final double amountOfTicks = 60.0;
        
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        
        int updates = 0;
        int frames = 0;
        
        long timer = System.currentTimeMillis();
        
        while(running) {
            
            long now = System.nanoTime();
            delta += (now - time) / ns;
            time = now;
            
            while(delta >= 1) {
                tick();
                updates++;
                delta--;
            }
            if(running)
            render();
            frames++;
           
            if(System.currentTimeMillis() - timer > 1000) {
               timer += 1000;
               //System.out.println(updates + " Ticks, fps " + frames);
               updates = 0;
               frames = 0;
            }
        }
        stop();
    }
    
    private void tick() {
        
        handler.tick();
        
        if (gameState == STATE.Game) {
        hud.tick();
        spawner.tick();
        
        }
        else if (gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Options) {
            
            menu.tick();
            
        }
        
        if (HUD.HEALTH <= 0) {
            
            gameState = STATE.End;
            
            //HUD.HEALTH = 100;   
        }
    }
    
    private void render() {
        
        BufferStrategy buffS = this.getBufferStrategy();
        
        if (buffS == null) {
            
            createBufferStrategy(3);
            return;
                    
        }
        
        Graphics g = buffS.getDrawGraphics();
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTHW, HEIGHTH);
        
        handler.render(g);
        
        if (gameState == STATE.Game) {
        hud.render(g);

        }
        else if (gameState == STATE.Menu || gameState == STATE.End || gameState == STATE.Options) {
            
            menu.render(g);
            
        }
        
        g.dispose();
        buffS.show();
    }
    

    public static int clamp(int var, int min, int max){
        
        if(var >= max)
            return var = max;
        else if (var <= min)
            return var = min;
        else
            return var;
        
    }
    
    private void LoadImageLevel(BufferedImage image) {
        
        int w = image.getWidth();
        
        int h = image.getHeight();
        
        /*for (int xx = 0; xx < h; xx++) {
            for(int yy = 0; yy < w; yy++) {
                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
            }
        }*/
        
    }
    
    public static Texture getInstance() {
        
        return tex;
        
    }
    
    public static void main(String[] args) {
        
        new Game();
        
    }

}

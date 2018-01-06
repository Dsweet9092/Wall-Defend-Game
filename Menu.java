
package com.gamedev.main;

import com.gamedev.main.Game.STATE;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Menu extends MouseAdapter {
    
    private Game game;
    private Handler handler;
    private HUD hud;
    
    public Menu(Game game, Handler handler, HUD hud) {
        
        this.game = game;
        this.handler = handler;
        this.hud = hud;
    }
    
    public void mousePressed(MouseEvent e) {
        
        int xpos = e.getX();
        int ypos = e.getY();
        System.out.println(xpos + " " + ypos);
        if (game.gameState == STATE.Menu) {
            
        if (mouseOver(xpos, ypos, 300, 100, 150, 64 )) {
            game.gameState = STATE.Game;
            if (game.gameState == STATE.Game) {
                handler.addObject(new Wall(50, 500, ID.Wall, handler));
                handler.addObject(new Player(400, 500, ID.Player, handler));
        
                handler.addObject(new AssistTurret(0,0, ID.AssistTurret, handler));
        
                game.addMouseListener(new MouseClick(handler));
                game.addMouseMotionListener(new MouseInput(handler));
            }
        }
        
        if (game.gameState == STATE.Menu) {
            //System.out.println("you are in menu");
        }
        if (mouseOver(xpos, ypos, 300, 300, 150, 64)){
            System.exit(1);
        }
        if (mouseOver(xpos, ypos, 300, 200, 150, 64)) {
            
            game.gameState = STATE.Options;
            
        
        }
    }
        if (game.gameState == STATE.End) {
            
            if (mouseOver(xpos, ypos, 300, 275, 200, 64)) {

                System.exit(1);
            }
        }
    
        
        if (game.gameState == STATE.Options) {
            //System.out.println("you are in options");  
            if (mouseOver(xpos, ypos, 350, 350, 100, 32)){
                //System.out.println("options working");
                game.gameState = STATE.Menu;
                
                //System.out.println(xpos + " " + ypos);
                
            }
            }
        
    }
    
    public void mouseReleased(MouseEvent e) {
        
        
        
    }
    
    private boolean mouseOver(int xpos, int ypos, int x, int y, int width, int height) {
    
    if (xpos > x && xpos < x + width) {
        if(ypos > y && ypos < y + height) {
            return true;
        }
        else return false;
        
    }
    else return false;
    
}
    
    
    public void tick() {
        
        
        
    }
    
    public void render(Graphics g) {
        
        Font font1 = new Font("arial", 1, 50);
        Font font2 = new Font("arial", 1, 30);
        
        if (game.gameState == STATE.Menu) {
        g.setFont(font2);
        g.setColor(Color.white);
        g.drawRect(300, 100, 150, 64);
        g.drawString("Start", 325, 150);
        
        g.setColor(Color.white);
        g.drawRect(300, 200, 150, 64);
        g.drawString("Options", 325, 250);
        
        g.setColor(Color.white);
        g.drawRect(300, 300, 150, 64);
        g.drawString("Quit", 325, 350);
        }
        //else if (game.gameState == STATE.Game) {
            
       // }
        if (game.gameState == STATE.End) {
        
        g.setFont(font2);
        g.setColor(Color.white);
        g.drawRect(350, 275, 95, 50);
        g.drawString("Game Over", 305, 175);
        g.drawString("Your score was: " + hud.getScore(), 290, 225);
        g.drawString("Exit", 375, 310);
            
        }
        if(game.gameState == STATE.Options) {
            
            g.setFont(font2);
            
            g.setColor(Color.WHITE);
            g.drawRect(350, 350, 100, 32);
            g.drawString("Back", 365, 375);
            g.drawString("Click the left mouse button", 10, 200);
            g.drawString("to place the mortar location marker.", 10, 225);
            
        }
    }
    
}

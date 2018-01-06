
package com.gamedev.main;

import com.gamedev.main.GameObject;
import com.gamedev.main.ID;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;



// player class
public class Player extends GameObject {
    
    private Handler handler;
    
    Texture tex = Game.getInstance();
    
    private Bullet bullet;
    private MouseInput input;
    private int spawn;
    
    private int coolDown = 100;
     
    private ImageLoader image;
    
    public Player(int x, int y, ID id, Handler handler) { 
        
    super(x, y, id);   
    
    this.handler = handler;
    
    //ImageLoader image = new ImageLoader("Cannon.png");
   
    }
    
    public Rectangle getBounds() {
        
        return new Rectangle(x, y , 32, 32);
        
    }
    

    
    public void tick() {
        
        x += velX;
        y += velY;
        
    }
    
    public void render(Graphics g) {
       
        
        g.setColor(Color.blue);
        //g.drawImage(tex.player[0], (int)x, (int)y, null);
        g.fillRect(x, y, 32, 32);
        
    }
}

package com.gamedev.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

// shows location of where bullets will go
public class BulletSpot extends GameObject {
    
    private Handler handler;
    
    private HUD hud;

    public BulletSpot(int x, int y, ID id, IDent dent, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        

        
    }
    
    
    
        public Rectangle getBounds() {
        
        return new Rectangle(x, y - 8, 16, 16);
        
    }


    public void tick() {
       

    }

    

        
    
    public void render(Graphics g) {
        
        g.setColor(Color.YELLOW);
        g.drawOval(x, y - 8, 16, 16);
        
    }
    
}
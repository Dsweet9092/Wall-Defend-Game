package com.gamedev.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

// enemy class
public class MediumEnemy extends GameObject {
    
    private Handler handler;
    
    private HUD hud;

    public MediumEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        
        //velX = 5;
        velY = 3;
                
        
    }
    
    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.Explosion){
            if (getBounds().intersects(tempObject.getBounds())) {
                
                
                
                handler.removeObject(this);
                
                
            
            }
            }
        }
        
        for (int i = 0; i < handler.object.size(); i++) {
            
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.Wall){
            if (getBounds().intersects(tempObject.getBounds())) {
                
                
                HUD.HEALTH -= 1;
                handler.removeObject(this);
                
                
                
            
            }
            }
        }
            
        
        
    }
    
        public Rectangle getBounds() {
        
        return new Rectangle(x, y, 16, 16);
        
    }


    public void tick() {
        
        x += velX;
        y += velY;
        
        collision();

    }

    
    public void render(Graphics g) {
        
        g.setColor(Color.WHITE);
        g.fillRect(x, y, 16, 16);
        
    }
    
}

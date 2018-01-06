
package com.gamedev.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Wall extends GameObject{
    
    Handler handler;
    

    public Wall(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
    }

    
    public void tick() {
        
        for (int i = 0; i < handler.object.size(); i++) {
            
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.BasicEnemy){
            if (getBounds().intersects(tempObject.getBounds())) {
                
                //hud.setScore(hud.getScore() + 1);
                
                HUD.HEALTH -=1;
                
                
            
            }
            }
        }
        
    }

    
    public void render(Graphics g) {
        
        g.setColor(Color.GRAY);
        g.fillRect(50, 494, 700, 64);
        g.fillRect(36, 100, 48, 400);
        g.fillRect(716, 100, 48, 400);
        

        
    }

    
    public Rectangle getBounds() {
        
        return new Rectangle(50, 494, 700, 64);
        
    }
    
}

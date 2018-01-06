
package com.gamedev.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

// explosion that destroys enemies
public class Explosion extends GameObject {
    
    private int xGrow;
    private int yGrow;
    
    private Handler handler;
    
    private GameObject object;

    private int timer = 50;
    
    public Explosion(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
    }

    
    public void tick() {
        
        
        xGrow++;
        yGrow++;
        
        x--;
        y--;
        
        timer--;
        
        if(timer == 0) {
            
            handler.removeObject(this);
            
        }
            
        
        
    }

    
    public void render(Graphics g) {
        
        g.setColor(Color.ORANGE);
        g.drawOval(x + 8, y , xGrow * 2 , yGrow * 2 );
        
    }

    
    public Rectangle getBounds() {
        
        return new Rectangle(x + 8, y , xGrow * 2, yGrow * 2);
        
    }
    
}

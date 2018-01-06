
package com.gamedev.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class AssistTurret extends GameObject {
    
    private Handler handler;

    public AssistTurret(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        
    }

    
    public void tick() {
    }

    
    public void render(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.drawRect(43, 450, 32, 32);
        g.drawRect(43, 300, 32, 32);
        g.drawRect(43, 150, 32, 32);
        
        g.drawRect(724, 450, 32, 32);
        g.drawRect(724, 300, 32, 32);
        g.drawRect(724, 150, 32, 32);
    }

    
    public Rectangle getBounds() {
        
        return new Rectangle(43, 450, 32, 32);
        
    }
    
    
    
}

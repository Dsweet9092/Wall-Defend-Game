
package com.gamedev.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class TurretBulletSpot extends GameObject {
        private Handler handler;
        
        private Random rand = new Random();
        
        //int ranged = 200 + rand.nextInt(550);
    
    private HUD hud;

    public TurretBulletSpot(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
        

        
    }
    
    
    
        public Rectangle getBounds() {
        
        return new Rectangle(x, y - 8, 16, 16);
        
    }


    public void tick() {
       
        

    }

    public void render(Graphics g) {
        
        g.setColor(Color.magenta);
        g.drawOval(x, y - 8, 16, 16);
        
    }
}

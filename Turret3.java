
package com.gamedev.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class Turret3 extends GameObject {

    private Handler handler;
    
    private Random rand = new Random();
    
    private int scoreKeep = 0;
    
    public Turret3(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
    }

    
    public void tick() {
        
        scoreKeep++;
        
        if (scoreKeep >= 50) {
            handler.addObject(new TurretBulletSpot(75 + rand.nextInt(500), 305, ID.TurretBulletSpot, handler));
            handler.addObject(new TurretBullet(45, 305, ID.TurretBullet, handler));
            
            scoreKeep = 0;
        }
        
    }

    
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect(45, 302, 28, 28);
        
    }

    
    public Rectangle getBounds() {
        
        return null;
    }
    
}

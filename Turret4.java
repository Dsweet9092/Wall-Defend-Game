
package com.gamedev.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class Turret4 extends GameObject {

    private Handler handler;
    
    private Random rand = new Random();
    
    private int scoreKeep = 0;
    
    public Turret4(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        
        this.handler = handler;
    }

    
    public void tick() {
        
        scoreKeep++;
        
        if (scoreKeep >= 50) {
            handler.addObject(new TurretBulletSpot2(75 + rand.nextInt(500), 305, ID.TurretBulletSpot2, handler));
            handler.addObject(new TurretBullet2(726, 305, ID.TurretBullet, handler));
            
            scoreKeep = 0;
        }
        
    }

    
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(726, 302, 28, 28);
        
    }

    
    public Rectangle getBounds() {
        
        return null;
    }
}

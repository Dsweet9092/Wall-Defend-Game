
package com.gamedev.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class TurretBullet2 extends GameObject {

    
    private Handler handler;
    public TurretBullet2(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        
        velX = 7;
    }

    
    public void tick() {
        
        x -= velX;
        
        collision();
    }

    
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 16, 16);
    }
    
    private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.TurretBulletSpot2){
            if (getBounds().intersects(tempObject.getBounds())) {
                
                if (/*handler.object.get(i) == tempObject && */tempObject.getId() == ID.TurretBulletSpot2) {
                handler.removeObject(handler.object.get(i));
                handler.removeObject(handler.object.get(i));
                
                handler.addObject(new Explosion(tempObject.getX(), tempObject.getY(), ID.Explosion, handler));
                }
            }
            }
        }

        
    }

    
    public Rectangle getBounds() {
        
        return new Rectangle(x, y, 16, 16);
    }
}

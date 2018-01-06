package com.gamedev.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

// creates the bullets
public class Bullet extends GameObject {
    
    private Handler handler;
    
    private Player player;
    
    private MouseClick click;
    
    private Game game;
    
    private BulletSpot spot;

    public Bullet(int x, int y, ID id, IDent dent, Handler handler) {
        super(x, y, id);
        
        
        this.handler = handler;
        
        //velX = 5;
        velY = -5;
                
        
    }
    
        public Rectangle getBounds() {
        
        return new Rectangle(x, y, 16, 16);
        
    }
private void collision() {
        for (int i = 0; i < handler.object.size(); i++) {
            
            GameObject tempObject = handler.object.get(i);
            
            if(tempObject.getId() == ID.BulletSpot){
            if (getBounds().intersects(tempObject.getBounds())) {
                
                if (handler.object.get(i) == tempObject && tempObject.getId() == ID.BulletSpot) {
                handler.removeObject(handler.object.get(i));
                handler.removeObject(this.handler.object.get(i));
                
                handler.addObject(new Explosion(tempObject.getX(), tempObject.getY(), ID.Explosion, handler));
                }
            }
            }
        }

        
    }

    public void tick() {
        
        x += velX;
        y += velY;
        
        collision();
        
    }
    
    

    public void clamp(Game game) {
        
        
    }
    
    public void render(Graphics g) {
        
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 16, 16);
        
    }
    
}

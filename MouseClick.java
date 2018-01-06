
package com.gamedev.main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// click where to shoot bullets
public class MouseClick implements MouseListener{

    
    private Handler handler;
    
    private int ypos;
    private int xpos;
    
    private final int MOVE = 5;
    private final int MAX_X = 700;
    private final int MIN_X = 100;
    
    private int count;
    private int endCount = 150;
    
    private GameObject tempObject;
    
    private CoolDown cd;
    
    private HUD hud;
    
    private boolean cooldown = false;
    
    private boolean click = false;
    
    private CoolDown down;
    
    private IDent dent;
    
    public MouseClick(Handler handler) {
    
    this.handler = handler;
    
}
    
    public void tick() {
        
        
        
    }

    
    public void mouseClicked(MouseEvent e) {
        
        //System.out.println("Click!!!!!!");
        
        ypos = e.getY();
        xpos = e.getX();
            
        count += 50;
        
        
        //if(cd.getCooldown() == true){
        if(xpos >= MAX_X)
            xpos = MAX_X + 16;
        if(xpos <= MIN_X)
            xpos = MIN_X + 16;
            
            while (count >= endCount) {
            //System.out.println(count);
        
        
        
        
                
        handler.addObject(new BulletSpot(xpos - 8, ypos, ID.BulletSpot, dent, handler));
        
        handler.addObject(new Bullet(xpos - 8, 508, ID.Bullet, dent, handler));
        
        count -= 150;
        //cd.setTimer(0);
        break;
            }

    }
    

    
    public void mousePressed(MouseEvent e) {
        
        ypos = e.getY();
        xpos = e.getX();
            

        count += 50;
        
        if(xpos >= MAX_X)
            xpos = MAX_X + 16;
        if(xpos <= MIN_X)
            xpos = MIN_X + 16;
        
        //if(cd.getCooldown() == true){
        while (count >= endCount) {
        //    System.out.println(count);
        
         
        handler.addObject(new BulletSpot(xpos - 8, ypos, ID.BulletSpot, dent, handler));
        
        handler.addObject(new Bullet(xpos - 8, 508, ID.Bullet, dent, handler));
        
        count -= 150;
        //cd.setTimer(0);
        break;
            }
        
    }

    
    public void mouseReleased(MouseEvent e) {
    }

    
    public void mouseEntered(MouseEvent e) {
    }

    
    public void mouseExited(MouseEvent e) {
    }
    
    public int getY() {
        
        return ypos;
        
    }
    
    public int getX() {
        
        return xpos;
    }
    
    public void setEndCount(int end) {
        
        endCount = end;
        
    }
    
    public int getEndCount() {
        
        return endCount;
        
    }
    

    
}

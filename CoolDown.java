
package com.gamedev.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// not used
public class CoolDown implements MouseListener {
    
    private Handler handler;
    
    public int timer ;
    private boolean cooldown = true;
    private int count;
    private int maxCount = 200;
    private int i = 0;

    
    public void setTimer(int time) {
        
        this.timer = time;
        
    }

    public void tick() {
        

        timer++;
        System.out.println(timer + "   ggg   "  + cooldown);
        if(timer >= maxCount) {
            
            timer = 200;
            cooldown = false;
        }
    }


    public void render(Graphics g) {
        //g.setColor(Color.white);
        //g.fillRect(300, 300, count, 16);
        
    }


    public Rectangle getBounds() {
        return null;
    }
    
    public boolean getCooldown() {
        
        return cooldown;
        
    }

    
    public void mouseClicked(MouseEvent e) {
        
        
         
        System.out.println("ASDJFWEPGFEBGOSUOFJG   " + cooldown);    
            i -= 200;
            cooldown = true;
            
        
    }

    public void mousePressed(MouseEvent me) {
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {
    }

    public void mouseExited(MouseEvent me) {
    }
    
    
}

package com.gamedev.main;



import java.awt.event.MouseEvent;

import java.awt.event.MouseMotionListener;
import java.util.Timer;
import java.awt.event.MouseListener;
import java.util.Random;

public class MouseInput implements MouseMotionListener {

    private int xpos;
    private int ypos;
    

    private final int MOVE = 5;
    private final int MAX_X = 700;
    private final int MIN_X = 100;
    
    
    private boolean mouseEnt = true;
    private boolean mouseMove = true;
    
    private boolean mouseClick = false;
    
    private int click = 0;
    
    private Handler handler;
    
    private Timer timer;
    
    private GameObject object;
    
    private Controller c;
    private Random rand;
    
    private Spawn spawn;
    
    public MouseInput(Handler handler) {
    
    this.handler = handler;
    
    
    
    
    
}

public void mouseDragged(MouseEvent e) {

    if (mouseEnt = true)

            xpos = e.getX();
        
                         for (int i = 0; i < handler.object.size(); i++) {
                GameObject tempObject = handler.object.get(i);
                
                if (tempObject.getId() == ID.Player) {

                
                if (xpos > tempObject.getX())
                        tempObject.setX(xpos - 16);
                
                if (xpos < tempObject.getX())
                        tempObject.setX(xpos - 16);
                
                if (tempObject.getX() < MIN_X)
                    tempObject.setX(MIN_X);
                
                if (tempObject.getX() > MAX_X)
                    tempObject.setX(MAX_X);
                

                }
             }
    }
    
    public void mouseMoved(MouseEvent e) {
        
        //System.out.println("MOVED");
        
        if (mouseEnt = true)

            xpos = e.getX();
        
                for (int i = 0; i < handler.object.size(); i++) {
                    GameObject tempObject = handler.object.get(i);
                
                    if (tempObject.getId() == ID.Player) {

                
                if (xpos > tempObject.getX())
                        tempObject.setX(xpos - 16);
                
                if (xpos < tempObject.getX())
                        tempObject.setX(xpos - 16);
                
                if (tempObject.getX() < MIN_X)
                    tempObject.setX(MIN_X);
                
                if (tempObject.getX() > MAX_X)
                    tempObject.setX(MAX_X);
                

                }
             }

    }
  
}

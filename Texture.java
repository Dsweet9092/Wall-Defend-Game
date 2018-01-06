
package com.gamedev.main;

import java.awt.image.BufferedImage;


public class Texture {
    
    SpriteSheet cs;
    
    private BufferedImage cannon = null;
    
    public BufferedImage[] player = new BufferedImage[1];
    
    
    public Texture() {
        
        ImageLoader loader = new ImageLoader();
        
        try { 
            cannon = loader.loadImage("Cannon.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        cs = new SpriteSheet(cannon);
        
        getTexture();
        
    }
    
    public void getTexture(){
        
        player[0] = cs.grabImage(1, 1, 32, 32);
    }
}

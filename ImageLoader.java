
package com.gamedev.main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ImageLoader {
    
    private BufferedImage image;
    
    public BufferedImage loadImage(String path) throws IOException {
        
        try {
        image = ImageIO.read(getClass().getResource(path));
        }catch(Exception e){
            e.printStackTrace();
        }
        return image;
    }
    
}

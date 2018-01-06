
package com.gamedev.main;


import java.awt.Color;
import java.awt.Graphics;

// Displays Health and score of the game
public class HUD {
    
    public static int HEALTH = 10;
    public static int COOLDOWN = 15;
    
    private Game game;
    
    private int greenValue = 255;
    
    private int score = 0;
    private int level = 1;
    
    public void tick() {

        HEALTH = Game.clamp(HEALTH, 0, 100);
        greenValue = Game.clamp(greenValue, 0, 255);
        COOLDOWN = Game.clamp(COOLDOWN, 0, 100);
        greenValue = HEALTH * 10;
        
        if (HEALTH <= 0) {
            
        
            
        }
        
    }
    
    public void render(Graphics g) {
        
        //if (game.gameState == STATE.Game) {
        g.setColor(Color.gray);
        g.fillRect(15, 15, 100, 16);
        g.setColor(new Color(75, greenValue, 0));
        g.fillRect(15, 15, HEALTH * 10, 16);
        g.setColor(Color.white);
        g.drawRect(15, 15, 100, 16);
        
        
        g.drawString("Score: " + score, 700, 40);
        //g.drawString("Wave: " + level, 15, 50);
        //g.setColor(Color.magenta);
        //g.fillRect(400, 500, COOLDOWN * 10, 8);
        //g.setColor(new Color(75, greenValue, 0));
        //}
    }
    
    public void setScore(int score) {
        
        this.score = score;
        
    }
    
    public int getScore() {
        
        return score;
        
    }
    
    public int getLevel() {
        
        return level;
        
    }
    
    public void setLevel(int level) {
        
        this.level = level;
        
    }
}

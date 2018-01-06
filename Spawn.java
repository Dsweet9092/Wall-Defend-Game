
package com.gamedev.main;

import com.gamedev.main.Game.STATE;
import java.util.Random;

public class Spawn {
    
    private Handler handler;
    private HUD hud;
    
    private Game game;
    
    private int scoreKeep = 0;
    private int scoreKeep2 = 0;
    private int scoreKeep3 = 0;
    
    MouseClick mouse;
    
    private Random rand = new Random();
    

    public Spawn(Handler handler, HUD hud) {
        
        this.handler = handler;
        this.hud = hud;
        
    }
    
    public void tick() {
        scoreKeep++;
        scoreKeep2++;
        scoreKeep3++;
        
        if (scoreKeep >= 100) {
        
        scoreKeep = 0;
        hud.setLevel(hud.getLevel() + 1);
        int range = 125 + rand.nextInt(575);
        int range2 = 125 + rand.nextInt(575);
        int range3 = 125 + rand.nextInt(575);

            
            handler.addObject(new BasicEnemy(range, rand.nextInt(1), ID.BasicEnemy, handler ));
            hud.setScore(hud.getScore() + 1);
            
        
            if (hud.getLevel() >= 10) {
            if (scoreKeep2 >= 150) {
                
                scoreKeep2 = 0;
            
                
                handler.addObject(new FastEnemy(range2, rand.nextInt(2), ID.FastEnemy, handler));
                hud.setScore(hud.getScore() + 1);
            }
            }
            
            if (hud.getLevel() >= 20) {
                
                if (scoreKeep3 >= 100) {
                    
                    scoreKeep = 0;
                    
                    handler.addObject(new MediumEnemy(range3, rand.nextInt(3), ID.BasicEnemy, handler));
                    hud.setScore(hud.getScore() + 1);
                }
                
            }
            
            
            if (hud.getScore() == 10) {
                
                handler.addObject(new Turrets(46, 453, ID.Turrets, handler));
                
            }
            
            if (hud.getScore() >= 15 && hud.getScore() <= 16) {
                
                handler.addObject(new TurretTwo(726, 453, ID.Turrets, handler));
                
            }
            
            if (hud.getScore() >= 20 && hud.getScore() <= 21) {
                handler.addObject(new Turret3(46, 353, ID.Turrets, handler));
            }
            
            if (hud.getScore() >= 25 && hud.getScore() <= 26) {
                handler.addObject(new Turret4(46, 303, ID.Turrets, handler));
            }
            
            if (hud.getScore() >= 30 && hud.getScore() <= 31) {
                handler.addObject(new Turret5(46, 303, ID.Turrets, handler));
            }
            
            if (hud.getScore() >= 35 && hud.getScore() <= 36) {
                handler.addObject(new Turret6(46, 303, ID.Turrets, handler));
            }
            
            
            
            
            
        }
        
        }
    }



package com.gamedev.main;


public class IDent {
    
    static int[] arrayInt;
    
    public void setIDent(int t) {
        
        for(int i = 0; i < arrayInt.length; i++) {
            
            arrayInt[i] = t;
            
        }
        
    }
        
        public static int[] getIDent() {
            
            return arrayInt;
            
        }
    }
    


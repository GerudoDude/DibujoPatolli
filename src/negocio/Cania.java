/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Citlali Orduño
 */
public class Cania {
    
    private boolean[] canias;

    public Cania() {
        this.canias =new boolean[5];
    }
    
    
    public boolean[] Roll(){
        for (int i = 0; i < canias.length; i++) {
            canias[i]=Math.random()<0.5;
        }
        return this.canias;
    }
    
    
}
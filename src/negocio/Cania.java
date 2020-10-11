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
        this.canias = new boolean[5];
    }

    public boolean[] Roll() {
        for (int i = 0; i < canias.length; i++) {
            canias[i] = Math.random() < 0.5;
        }
        return this.canias;
    }

    public int getCaniasInt() {
        int num = 0;
        for (boolean cania : canias) {
            num += cania ? 0 : 1;
        }
        if (num == 5) {
            num = 10;
        }
        return num;
    }

}

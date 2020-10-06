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
public class Run {
     public static void main(String[] args) {
        Cania canias=new Cania();
        
        boolean[] ca=canias.Roll();
        
        for (int i = 0; i < ca.length; i++) {
            System.out.println(ca[i]);
        }
        
        
    }
}

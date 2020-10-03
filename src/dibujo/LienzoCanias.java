/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dibujo;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Jorge Eliu
 * 
 */
public class LienzoCanias extends Canvas {
    

    
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);

        Rectangle rect = new Rectangle();
        rect.setBounds(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        g2d.draw(rect);
        
        
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        
        int x = 0, y = 0, ancho = 20, alto = 20;
        boolean[] canias={false,false,false,false,true};
        
        DibujarLanzarcanias(canias, x, y, ancho, alto, g2d);
        
    }
        
        public void DibujarLanzarcanias(boolean[] canias,int x , int y , int ancho , int alto ,Graphics2D g){
            for (int i = 0; i < 5; i++) {
                if(canias[i]==true){
                    dibujarCaniaLisa(x+ancho*3, y+alto, ancho*2, alto*3, g);
                }else{
                    dibujarCaniaPunto(x+ancho*3, y+alto, ancho*2, alto*3, g);
                }
                x+=ancho*3;
                
            }
        }
        
        public void dibujarCaniaLisa(int x , int y , int ancho , int alto ,Graphics2D g){
            Rectangle rect = new Rectangle();
            rect.setBounds(x, y, ancho, alto);
            g.draw(rect);
        }
        
        public void dibujarCaniaPunto(int x , int y , int ancho , int alto ,Graphics2D g){
            Rectangle rect = new Rectangle();
            Ellipse2D.Double ell=new Ellipse2D.Double(x+ancho/3, y+alto/3, ancho/3, alto/4);
            
            rect.setBounds(x, y, ancho, alto);
            g.draw(rect);
            g.fill(ell);
            g.draw(ell);
            
        }

    
}

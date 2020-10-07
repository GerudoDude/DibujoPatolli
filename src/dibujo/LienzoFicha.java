/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dibujo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Jorge Eliu
 */
public class LienzoFicha extends JPanel{
    private ArrayList listaFichas=new ArrayList();
    private Posicion[] posCasillas;
    Graphics2D g2d;
    
    
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        
        Rectangle rect = new Rectangle();
        rect.setBounds(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        g2d.draw(rect);
        g2d.rotate(Math.toRadians(45), rect.getCenterX(), rect.getCenterY());
        
        //Configuracion test
        int x = (int) rect.getCenterX() - 22, y = (int) rect.getCenterY() - 22, ancho = 20, alto = 20;
        
        dibujarficha(x, y, ancho, alto, Color.yellow, g2d);
        dibujarficha(x+ancho, y, ancho, alto, Color.red, g2d);
        //escanearTablero(x, y, ancho, alto);
        
    }
    
     /**
     * Dibuja la ficha
     *
     * @param x Posicion x donde se va crear
     * @param y Posicion y donde se va crear
     * @param ancho Lo ancho que va ser la ficha
     * @param alto Lo alto que va ser la ficha
     * @param color Seleccionas el color de la ficha
     * @param g2d Componente(JFrame) grafico actual
     */
    public void dibujarficha(int x, int y, int ancho, int alto, Color color, Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(color);
        Ellipse2D.Double ficha = new Ellipse2D.Double(x + (ancho / 7), y + (alto / 7), ancho - (ancho / 4), alto - (alto / 4));
        g2d.fill(ficha);
        g2d.setColor(Color.BLACK);
        g2d.draw(ficha);
    }
    
    /**
     * --Aun en pruebas--
     * @param x
     * @param y
     * @param ancho
     * @param alto
     * @return 
     */
    public Posicion[] escanearTablero(int x, int y, int ancho, int alto){
        
        posCasillas=new Posicion[52];
        //izquierda
        for (int i = 0; i < 9; i++) {
            posCasillas[i]=new Posicion(x, y );
            x-=ancho;
            System.out.println("Casilla "+i+" X: "+posCasillas[i].getPosicionX()+" Y:"+posCasillas[i].getPosicionY());
            dibujarficha(posCasillas[i].getPosicionX(), posCasillas[i].getPosicionY(), ancho, alto, Color.yellow, g2d);
        }
        
        return null;
    }
    

    
    
    
}


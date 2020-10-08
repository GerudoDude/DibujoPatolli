/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dibujo;

import java.awt.Color;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Jorge Eliu
 */
public class FichaJugador {
    
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private Color color;

    public FichaJugador(int x, int y, int ancho, int alto,Color color) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.color=color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public Ellipse2D getFigura(){
        
        Ellipse2D.Double ficha = new Ellipse2D.Double(x + (ancho / 7), y + (alto / 7), ancho - (ancho / 4), alto - (alto / 4));
        
        return ficha;
        
    }
    
}

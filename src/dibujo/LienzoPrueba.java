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
 * Clase de prueba, no tomar muy encuenta esta clase
 */
public class LienzoPrueba extends Canvas {
    //Objeto aun pensado en implementarse
    Posicion[] pos = new Posicion[52];
    
    
    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);

        Rectangle rect = new Rectangle();
        rect.setBounds(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        g2d.draw(rect);
        // g2d.rotate(Math.toRadians(45));
        
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(2));
        //x=25 y=225
        
        int x = 25, y = 225, ancho = 20, alto = 20, tam = 8;

        dibujarTableroV2(x, y, ancho, alto, tam, g2d);
        
        dibujarficha(x, y, ancho, alto, alto, g2d);

    }

    void dibujarficha(int x, int y, int ancho, int alto, int cuantos, Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.BLUE);
        Ellipse2D.Double ficha = new Ellipse2D.Double(x + ((ancho) / 7) + (ancho * 8), y + (alto / 7), ancho - (ancho / 4), alto - (alto / 4));
        g2d.fill(ficha);
        g2d.setColor(Color.BLACK);
        g2d.draw(ficha);
    }

    void dibujarTablero(int x, int y, int ancho, int alto, int tam, Graphics2D g2d) {
        //Astilla Izquierda
        g2d.drawArc(x, y, ancho, alto, 90, 90); //Arco
        g2d.drawArc(x, y + alto, ancho, alto, 180, 90); //Arco
        dibujarDerecha(x, y, ancho, alto, tam, g2d);
        dibujarDerecha(x, y + alto, ancho, alto, tam, g2d);
        //Astilla Derecha
        g2d.drawArc(x + (ancho * 10) + (ancho * 7), y, ancho, alto, 0, 90); //Arco
        g2d.drawArc(x + (ancho * 10) + (ancho * 7), y + alto, ancho, alto, 270, 90); //Arco
        dibujarDerecha(x + (ancho * 10), y, ancho, alto, tam, g2d);
        dibujarDerecha(x + (ancho * 10), y + alto, ancho, alto, tam, g2d);
        //Astilla Abajo
        g2d.drawArc(x + (ancho * 8), y - (alto * 8), ancho, alto, 90, 90); //Arco
        g2d.drawArc(x + (ancho * 9), y - (alto * 8), ancho, alto, 0, 90); //Arco
        dibujarAbajo(x + (ancho * 8), y + (alto * 2), ancho, alto, tam, g2d);
        dibujarAbajo(x + (ancho * 9), y + (alto * 2), ancho, alto, tam, g2d);
        //Astilla Arriba
        g2d.drawArc(x + (ancho * 8), y + (alto * 9), ancho, alto, 180, 90); //Arco
        g2d.drawArc(x + (ancho * 9), y + (alto * 9), ancho, alto, 270, 90); //Arco
        dibujarAbajo(x + (ancho * 8), y - (alto * 8), ancho, alto, tam, g2d);
        dibujarAbajo(x + (ancho * 9), y - (alto * 8), ancho, alto, tam, g2d);

        //Centro
        dibujar2x2(x, y, ancho, alto, g2d);

    }
    
    public void dibujarTableroV2(int x, int y, int ancho, int alto, int tam, Graphics2D g2d) {
        //AstillaIzquierda
        dibujarIzquierda(x + (ancho * (tam - 1)), y, ancho, alto, tam, g2d);
        dibujarIzquierda(x + (ancho * (tam - 1)), y + alto, ancho, ancho, tam, g2d);
        //AstillaDerecha
        dibujarDerecha(x + (ancho * (tam + 2)), y, ancho, alto, tam, g2d);
        dibujarDerecha(x + (ancho * (tam + 2)), y + alto, ancho, alto, tam, g2d);
        //AstillaArriba
        dibujarArriba(x + (ancho * 8), y - ancho, ancho, alto, tam, g2d);
        dibujarArriba(x + (ancho * 9), y - ancho, ancho, alto, tam, g2d);
        //AstillaAbajo
        dibujarAbajo(x + (ancho * 8), y + ancho + (alto + 1), ancho, alto, tam, g2d);
        dibujarAbajo(x + (ancho * 9), y + ancho + (alto + 1), ancho, alto, tam, g2d);
        //Final
        dibujar2x2(x, y, ancho, alto, g2d);

    }

    public void dibujarDerecha(int x, int y, int ancho, int alto, int cuantos, Graphics2D g) {

        for (int i = 0; i < cuantos; i++) {
            if(i==cuantos-1){
                dibujarUnCuadroCurva(x-ancho, y, ancho*2, alto, 270, 180, g);
                continue;
            }
            dibujarUnCuadro(x, y, ancho, alto, g);
            x += ancho;
        }
    }

    public void dibujarAbajo(int x, int y, int ancho, int alto, int cuantos, Graphics2D g) {

        for (int i = 0; i < cuantos; i++) {
            if(i==cuantos-1){
                dibujarUnCuadroCurva(x, y-alto, ancho, alto*2, 180, 180, g);
                continue;
            }
            
            dibujarUnCuadro(x, y, ancho, alto, g);
            y += alto;
        }
    }

    public void dibujarIzquierda(int x, int y, int ancho, int alto, int cuantos, Graphics2D g) {
        for (int i = 0; i < cuantos; i++) {
            if(i==cuantos-1){
                dibujarUnCuadroCurva(x, y, ancho*2, alto, 90, 180, g);
                continue;
            }
            
            dibujarUnCuadro(x, y, ancho, alto, g);
            x -= ancho;
        }
    }

    public void dibujarArriba(int x, int y, int ancho, int alto, int cuantos, Graphics2D g) {
        for (int i = 0; i < cuantos; i++) {
            if(i==cuantos-1){
                dibujarUnCuadroCurva(x, y, ancho, alto*2,0, 180, g);
                continue;
            }
            dibujarUnCuadro(x, y, ancho, alto, g);
            y -= alto;
        }
    }
    
    public void dibujar2x2(int x, int y, int ancho, int alto, Graphics2D g) {
        g.setColor(Color.yellow);
        for (int i = 0; i < 2; i++) {
            dibujarUnCuadro(x + (ancho * 8), y, ancho, alto, g);
            dibujarUnCuadro(x + (ancho * 8), y + alto, ancho, alto, g);
            x += ancho;
        }
    }
    
    public void dibujarUnCuadro(int x, int y, int ancho, int alto, Graphics2D g) {
        Rectangle rect = new Rectangle();
        rect.setBounds(x, y, ancho, alto);
        g.draw(rect);
    }
    
    public void dibujarUnCuadroCurva(int x, int y, int ancho, int alto,int startAngle,int grade, Graphics2D g){
        g.drawArc(x, y, ancho, alto, startAngle, grade);
        
    }
}

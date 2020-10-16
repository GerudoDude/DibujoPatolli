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
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Equipo 5
 */
public class LienzoFichas extends JPanel {
    private ArrayList listaFichas = new ArrayList();
    private Posicion[] posCasillas;
    private static int pasos = 0;
    private Graphics2D g2d;
    FichaJugador f1;

    public LienzoFichas() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        this.setOpaque(false);
        g2d = (Graphics2D) g;
        Rectangle rect = new Rectangle();
        rect.setBounds(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        
        g2d.draw(rect);
        g2d.rotate(Math.toRadians(45), rect.getCenterX(), rect.getCenterY());
        int x = (int) rect.getCenterX() - 22, y = (int) rect.getCenterY() - 22, ancho = 20, alto = 20;
        f1 = new FichaJugador(x, y, ancho, alto, Color.yellow);

        if (posCasillas == null) {
            this.posCasillas = escanearTablero(x, y, ancho, alto);
        }

        moverFicha(f1, pasos); //enves de f1, una lista de fichas
    
    
    
    }
    
    
     /**
     * Llama a la ficha actual a moverse
     *
     * @param pas Cuantos movimientos tendra
     */
    public void llamar(int pas) {
        this.pasos += pas;
        moverFicha(f1, pas);
        repaint();
    }

    /**
     * Hace mover la ficha escojida
     *
     * @param ficha Cual ficha se movera
     * @param pasos Cunatos movimientos tendra
     */
    public void moverFicha(FichaJugador ficha, int pasos) {

        g2d.clearRect(ficha.getX(), ficha.getY(), ficha.getAncho(), ficha.getAlto());

        if (this.pasos > 60) {
            this.pasos = 0;
        }

        int x1 = posCasillas[pasos].getPosicionX();
        int y1 = posCasillas[pasos].getPosicionY();
        ficha.setX(x1);
        ficha.setY(y1);
        dibujarficha(ficha, g2d);
        pasos += pasos;

    }

    /**
     * Dibuja la ficha
     *
     * @param ficha
     * @param g2d Componente(JFrame) grafico actual
     */
    public void dibujarficha(FichaJugador ficha, Graphics2D g2d) {
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(ficha.getColor());

        g2d.fill(ficha.getFigura());
        g2d.setColor(Color.BLACK);

        g2d.draw(ficha.getFigura());

    }

    /**
     * Metodo que escanea el tablero con sus coordenadas para las fichas
     *
     * @param x Posicion x
     * @param y Posicion y
     * @param ancho Lo ancho que va ser el cuadro
     * @param alto Lo alto que va ser el cuadro
     * @return regresa todas coordenadas de cada cuadro respetando como es la
     * trayectoria
     */
    public Posicion[] escanearTablero(int x, int y, int ancho, int alto) {
        int cant=LienzoTablero.tamanio+1;
        posCasillas = new Posicion[(cant*9)-3];
        int i = 0;
        // Astilla izquierda-Arriba
        while (i < cant) { /*8*/
            posCasillas[i] = new Posicion(x, y);
            x -= ancho;

            i++;
        }
        y += alto;
        x += ancho;
        //Astilla Izquierda-Abajo
        while (i < cant*2) { /*16*/
            posCasillas[i] = new Posicion(x, y);
            x += ancho;

            i++;
        }
        y += alto;
        x -= ancho;
        //Astilla Abajo-Izquierda
        while (i < (cant*3)-1) { /*23*/
            posCasillas[i] = new Posicion(x, y);
            y += alto;

            i++;
        }
        //Astilla Abajo-Derecha
        x += ancho;
        y -= alto;
        while (i < (cant*4)-1) { /*31*/
            posCasillas[i] = new Posicion(x, y);
            y -= alto;

            i++;
        }
        //Astilla Derecha-Abajo
        x += ancho;
        y += alto;
        while (i < (cant*5)-2) { /*38*/
            posCasillas[i] = new Posicion(x, y);
            x += ancho;

            i++;
        }
        //Astilla Derecha-Arriba
        y -= alto;
        x -= ancho;
        while (i < (cant*6)-2) { /*46*/
            posCasillas[i] = new Posicion(x, y);
            x -= ancho;

            i++;
        }
        //Astilla Arriba-Derecha
        y -= alto;
        x += ancho;
        while (i < (cant*7)-3) { /*53*/
            posCasillas[i] = new Posicion(x, y);
            y -= alto;

            i++;
        }
        //Astilla Arriba-Izquierda
        y += alto;
        x -= ancho;
        while (i < (cant*8)-4) { /*60*/
            posCasillas[i] = new Posicion(x, y);
            y += alto;

            i++;
        }
        return posCasillas;
    }
    
}

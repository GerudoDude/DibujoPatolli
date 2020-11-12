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
import dominio.Casilla;
import dominio.Tablero;

/**
 *
 * @author Equipo 5
 */
public class LienzoFichas extends JPanel {

    private ArrayList<FichaJugador> listaFichas = new ArrayList<FichaJugador>();
    private Posicion[] posCasillas;
    private Tablero tablero;
    private Graphics2D g2d;
    public FichaJugador fActual = null;

    public LienzoFichas(Tablero tablero) {
        this.tablero = tablero;
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

        if (fActual != null) {
            this.fActual.nuevasDimensiones(x, y, ancho, alto);
            moverFicha(this.fActual, this.fActual.getPasos());
        }

        fichasPosicion();

    }

    private void fichasPosicion() {
        listaFichas.forEach((listaFicha) -> {
            dibujarficha(listaFicha, g2d);
        });
    }

    public void fichaActual(FichaJugador fichaj) {
        this.fActual = fichaj;
        if (!listaFichas.contains(fichaj)) {
            listaFichas.add(fichaj);
        }
    }

    /**
     * Llama a la ficha actual a moverse
     *
     * @param pas Cuantos movimientos tendra
     */
    public void lanzar(int pas) {
        this.fActual.setPasos(this.fActual.getPasos() + pas);
        moverFicha(this.fActual, pas);

    }

    /**
     * Hace mover la ficha escojida
     *
     * @param ficha Cual ficha se movera
     * @param pasos Cunatos movimientos tendra
     */
    public void moverFicha(FichaJugador ficha, int pasos) {
        Casilla casillas[] = this.tablero.getCasillas();
        this.g2d.clearRect(ficha.getX(), ficha.getY(), ficha.getAncho(), ficha.getAlto());

        if (ficha.getPasos() > 60) {
            ficha.setPasos(0);
        }
        casillas[pasos].setFichaActual(this.fActual);
        int x1 = casillas[pasos].getPos().getPosicionX();
        int y1 = casillas[pasos].getPos().getPosicionY();
        ficha.setX(x1);
        ficha.setY(y1);
        dibujarficha(ficha, g2d);
        repaint();
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
}

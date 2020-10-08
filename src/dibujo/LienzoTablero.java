package dibujo;

/* Librerias a utilizar */

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author Equipo 5
 */
public class LienzoTablero extends JPanel {

    private Color colorDefault;
    private static boolean sentido;
    private Graphics2D g2d;
    private ArrayList listaFichas = new ArrayList();
    private Posicion[] posCasillas;
    private static int pasos = 0;
    private int x, y, ancho, alto;
    
    FichaJugador f1;

    public LienzoTablero(Color colorDefault) {
        this.colorDefault = colorDefault;
        this.sentido = true;
    }

    /* Metodo que dibuja tablero, la ficha y el rectangulo que los rodea */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);

        Rectangle rect = new Rectangle();
        rect.setBounds(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        g2d.draw(rect);

        g2d.rotate(Math.toRadians(45), rect.getCenterX(), rect.getCenterY());

        g2d.setColor(colorDefault);
        g2d.setStroke(new BasicStroke(2));

        //Configuracion
        int x = (int) rect.getCenterX() - 22, y = (int) rect.getCenterY() - 22, ancho = 20, alto = 20, tam = 7;

        dibujarTablero(x, y, ancho, alto, tam, g2d);
        
        f1 = new FichaJugador(x, y, ancho, alto, Color.yellow);

        if (posCasillas == null) {
            this.posCasillas = escanearTablero(x, y, ancho, alto);
        }

        MoverFicha(f1, pasos); //enves de f1, una lista de fichas

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
     * Dibuja el tablero Posicion
     *
     * @param x Posicion x del tablero (Incluyendo los cuadros)
     * @param y Posicion x del tablero (Incluyendo los cuadros y fichas)
     * Dimensiones
     * @param ancho Lo ancho que va ser el tablero (Incluyendo los cuadros y
     * fichas)
     * @param alto Lo alto que va ser el tablero (Incluyendo los cuadros y
     * fichas) Configuracion General
     * @param tam Cantidad de cuadros que se va generar en todas las astillas
     * @param g2d Componente(JFrame) grafico actual
     */
    public void dibujarTablero(int x, int y, int ancho, int alto, int tam, Graphics2D g2d) {

        //AstillaIzquierda
        dibujarIzquierda(x - (ancho), y, ancho, alto, tam, g2d);
        dibujarIzquierda(x - (ancho), y + alto, ancho, ancho, tam, g2d);
        //AstillaDerecha
        dibujarDerecha(x + (ancho * 2), y, ancho, alto, tam, g2d);
        dibujarDerecha(x + (ancho * 2), y + alto, ancho, alto, tam, g2d);
        //AstillaArriba
        dibujarArriba(x, y - ancho, ancho, alto, tam, g2d);
        dibujarArriba(x + ancho, y - ancho, ancho, alto, tam, g2d);
        //AstillaAbajo
        dibujarAbajo(x, y + ancho + (alto + 1), ancho, alto, tam, g2d);
        dibujarAbajo(x + ancho, y + ancho + (alto + 1), ancho, alto, tam, g2d);
        //Final*/
        dibujar2x2(x, y, ancho, alto, g2d);

    }

    /**
     * Metodo que dibuja desde las coordenas de origen(x,y) a la derecha
     * (cuantos)
     *
     * @param x Posicion x del cuadro de origen
     * @param y Posicion x del cuadro de origen Dimensiones
     * @param ancho Lo ancho que va ser cada cuadro
     * @param alto Lo alto que va ser cada cuadro Configuracion General
     * @param cuantos Cantidad de cuadros que se va generar a la derecha
     * @param g Componente(JFrame) grafico actual
     */
    public void dibujarDerecha(int x, int y, int ancho, int alto, int cuantos, Graphics2D g) {

        for (int i = 0; i < cuantos; i++) {
            if (i == cuantos - 2) {
                if (sentido == true) {
                    dibujarTriangulo(x, y, ancho, alto, Sentido.ABAJO, g);
                    sentido = false;
                } else {
                    dibujarTriangulo(x, y, ancho, alto, Sentido.ARRIBA, g);
                    sentido = true;
                }
            }
            if (i == cuantos - 1) {
                dibujarUnCuadroCurva(x - ancho, y, ancho * 2, alto, 270, 180, g);
                continue;
            }

            dibujarUnCuadro(x, y, ancho, alto, g);
            x += ancho;
        }
    }

    /**
     * Metodo que dibuja Desde las coordenas de origen(x,y) hasta abajo
     * (cuantos)
     *
     * @param x Posicion x del cuadro de origen
     * @param y Posicion x del cuadro de origen Dimensiones
     * @param ancho Lo ancho que va ser cada cuadro
     * @param alto Lo alto que va ser cada cuadro Configuracion General
     * @param cuantos Cantidad de cuadros que se va generar a abajo
     * @param g Componente(JFrame) grafico actual
     */
    public void dibujarAbajo(int x, int y, int ancho, int alto, int cuantos, Graphics2D g) {
        for (int i = 0; i < cuantos; i++) {
            if (i == cuantos - 2) {
                if (sentido == true) {
                    dibujarTriangulo(x, y, ancho, alto, Sentido.DERECHA, g);
                    sentido = false;
                } else {
                    dibujarTriangulo(x, y, ancho, alto, Sentido.IZQUIERDA, g);
                    sentido = true;
                }
            }
            if (i == cuantos - 1) {
                dibujarUnCuadroCurva(x, y - alto, ancho, alto * 2, 180, 180, g);
                continue;
            }
            dibujarUnCuadro(x, y, ancho, alto, g);
            y += alto;
        }
    }

    /**
     * Metodo que dibuja Desde las coordenas de origen(x,y) hasta la izquierda
     * (cuantos)
     *
     * @param x Posicion x del cuadro de origen
     * @param y Posicion x del cuadro de origen Dimensiones
     * @param ancho Lo ancho que va ser cada cuadro
     * @param alto Lo alto que va ser cada cuadro Configuracion General
     * @param cuantos Cantidad de cuadros que se va generar a la izquierda
     * @param g Componente(JFrame) grafico actual
     */
    public void dibujarIzquierda(int x, int y, int ancho, int alto, int cuantos, Graphics2D g) {
        for (int i = 0; i < cuantos; i++) {

            if (i == cuantos - 2) {
                if (sentido == true) {
                    dibujarTriangulo(x, y, ancho, alto, Sentido.ABAJO, g);
                    sentido = false;
                } else {
                    dibujarTriangulo(x, y, ancho, alto, Sentido.ARRIBA, g);
                    sentido = true;
                }
            }
            if (i == cuantos - 1) {
                dibujarUnCuadroCurva(x, y, ancho * 2, alto, 90, 180, g);
                continue;
            }
            dibujarUnCuadro(x, y, ancho, alto, g);
            x -= ancho;
        }
    }

    /**
     * Metodo que dibuja Desde las coordenas de origen(x,y) hasta arriba
     *
     * @param x Posicion x del cuadro de origen
     * @param y Posicion x del cuadro de origen Dimensiones
     * @param ancho Lo ancho que va ser cada cuadro
     * @param alto Lo alto que va ser cada cuadro Configuracion General
     * @param cuantos Cantidad de cuadros que se va generar a abajo
     * @param g Componente(JFrame) grafico actual
     */
    public void dibujarArriba(int x, int y, int ancho, int alto, int cuantos, Graphics2D g) {
        for (int i = 0; i < cuantos; i++) {
            if (i == cuantos - 2) {
                if (sentido == true) {
                    dibujarTriangulo(x, y, ancho, alto, Sentido.DERECHA, g);
                    sentido = false;
                } else {
                    dibujarTriangulo(x, y, ancho, alto, Sentido.IZQUIERDA, g);
                    sentido = true;
                }
            }
            if (i == cuantos - 1) {
                dibujarUnCuadroCurva(x, y, ancho, alto * 2, 0, 180, g);
//                  dibujarUnCuadroCurva(new Arco(x, y, ancho, alto*2,0,180), g);
                continue;
            }
            dibujarUnCuadro(x, y, ancho, alto, g);
            y -= alto;
        }
    }

    /**
     * Metodo que dibuja los cuadros centrales (Punto de origen)
     *
     * @param x Posicion x del cuadro de origen
     * @param y Posicion y del cuadro de origen
     * @param ancho Lo ancho que va ser cada cuadro
     * @param alto Lo alto que va ser cada cuadro
     * @param g Componente(JFrame) grafico actual
     */
    public void dibujar2x2(int x, int y, int ancho, int alto, Graphics2D g) {
        g.setColor(Color.yellow);
        for (int i = 0; i < 2; i++) {
            dibujarUnCuadro(x, y, ancho, alto, g);
            dibujarUnCuadro(x, y + alto, ancho, alto, g);
            x += ancho;
        }
        g.setColor(colorDefault);
    }

    /**
     * Dibuja un Cuadro
     *
     * @param x Posicion x del cuadro
     * @param y Posicion y del cuadro
     * @param ancho Lo ancho que va ser el cuadro
     * @param alto Lo alto que va ser el cuadro
     * @param g Componente(JFrame) grafico actual
     */
    public void dibujarUnCuadro(int x, int y, int ancho, int alto, Graphics2D g) {

        Rectangle rect = new Rectangle();
        rect.setBounds(x, y, ancho, alto);
        g.draw(rect);
    }

    /**
     * Dibuja un cuadro curvado
     *
     * @param x Posicion x del cuadro
     * @param y Posicion y del cuadro
     * @param ancho Lo ancho que va ser el cuadro
     * @param alto Lo alto que va ser el cuadro
     * @param startAngle Angulo inicial del arco
     * @param grade Los grados del arco que se dibujaran
     * @param g Componente(JFrame) grafico actual
     */
    public void dibujarUnCuadroCurva(int x, int y, int ancho, int alto, int startAngle, int grade, Graphics2D g) {

        g.drawArc(x, y, ancho, alto, startAngle, grade);
        g.setColor(colorDefault);
    }

    public void dibujarTriangulo(int x, int y, int ancho, int alto, Sentido sentido, Graphics2D g) {
        Polygon triangulo;
        int x1[];
        int y1[];

        g.setColor(Color.BLACK);

        switch (sentido) {
            case ABAJO:
                x1 = new int[]{x, x + ancho / 2, x + ancho};
                y1 = new int[]{y, y + alto, y};
                triangulo = new Polygon(x1, y1, 3);
                g.fillPolygon(triangulo);
                g.drawPolygon(triangulo);
                break;
            case ARRIBA:
                x1 = new int[]{x, x + ancho / 2, x + ancho};
                y1 = new int[]{y + alto, y, y + alto};
                triangulo = new Polygon(x1, y1, 3);
                g.fillPolygon(triangulo);
                g.drawPolygon(triangulo);
                break;
            case DERECHA:
                x1 = new int[]{x, x + ancho, x};
                y1 = new int[]{y, y + alto / 2, y + alto};
                triangulo = new Polygon(x1, y1, 3);
                g.fillPolygon(triangulo);
                g.drawPolygon(triangulo);
                break;
            case IZQUIERDA:
                x1 = new int[]{x + ancho, x, x + ancho};
                y1 = new int[]{y, y + alto / 2, y + alto};
                triangulo = new Polygon(x1, y1, 3);
                g.fillPolygon(triangulo);
                g.drawPolygon(triangulo);
                break;
        }
        g.setColor(colorDefault);
    }

    public void llamar(int pas) {
        this.pasos += pas;
        MoverFicha(f1, pas);
        repaint();
    }

    public void MoverFicha(FichaJugador ficha, int pasos) {

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
     *
     * @param x
     * @param y
     * @param ancho
     * @param alto
     * @return
     */
    public Posicion[] escanearTablero(int x, int y, int ancho, int alto) {

        posCasillas = new Posicion[60];
        int i = 0;
        // Astilla izquierda-Arriba
        while (i < 8) {
            posCasillas[i] = new Posicion(x, y);
            x -= ancho;
            System.out.println("Casilla " + i + " X: " + posCasillas[i].getPosicionX() + " Y:" + posCasillas[i].getPosicionY());
//            dibujarficha(posCasillas[i].getPosicionX(), posCasillas[i].getPosicionY(), ancho, alto, Color.yellow, g2d);
            i++;
        }
        y += alto;
        x += ancho;
        //Astilla Izquierda-Abajo
        while (i < 16) {
            posCasillas[i] = new Posicion(x, y);
            x += ancho;
            System.out.println("Casilla " + i + " X: " + posCasillas[i].getPosicionX() + " Y:" + posCasillas[i].getPosicionY());
//            dibujarficha(posCasillas[i].getPosicionX(), posCasillas[i].getPosicionY(), ancho, alto, Color.yellow, g2d);
            i++;
        }
        y += alto;
        x -= ancho;
        //Astilla Abajo-Izquierda
        while (i < 23) {
            posCasillas[i] = new Posicion(x, y);
            y += alto;
            System.out.println("Casilla " + i + " X: " + posCasillas[i].getPosicionX() + " Y:" + posCasillas[i].getPosicionY());
//            dibujarficha(posCasillas[i].getPosicionX(), posCasillas[i].getPosicionY(), ancho, alto, Color.yellow, g2d);
            i++;
        }
        //Astilla Abajo-Derecha
        x += ancho;
        y -= alto;
        while (i < 31) {
            posCasillas[i] = new Posicion(x, y);
            y -= alto;
            System.out.println("Casilla " + i + " X: " + posCasillas[i].getPosicionX() + " Y:" + posCasillas[i].getPosicionY());
//            dibujarficha(posCasillas[i].getPosicionX(), posCasillas[i].getPosicionY(), ancho, alto, Color.yellow, g2d);
            i++;
        }
        //Astilla Derecha-Abajo
        x += ancho;
        y += alto;
        while (i < 38) {
            posCasillas[i] = new Posicion(x, y);
            x += ancho;
            System.out.println("Casilla " + i + " X: " + posCasillas[i].getPosicionX() + " Y:" + posCasillas[i].getPosicionY());
//            dibujarficha(posCasillas[i].getPosicionX(), posCasillas[i].getPosicionY(), ancho, alto, Color.yellow, g2d);
            i++;
        }
        //Astilla Derecha-Arriba
        y -= alto;
        x -= ancho;
        while (i < 46) {
            posCasillas[i] = new Posicion(x, y);
            x -= ancho;
            System.out.println("Casilla " + i + " X: " + posCasillas[i].getPosicionX() + " Y:" + posCasillas[i].getPosicionY());
//            dibujarficha(posCasillas[i].getPosicionX(), posCasillas[i].getPosicionY(), ancho, alto, Color.yellow, g2d);
            i++;
        }
        //Astilla Arriba-Derecha
        y -= alto;
        x += ancho;
        while (i < 53) {
            posCasillas[i] = new Posicion(x, y);
            y -= alto;
            System.out.println("Casilla " + i + " X: " + posCasillas[i].getPosicionX() + " Y:" + posCasillas[i].getPosicionY());
//            dibujarficha(posCasillas[i].getPosicionX(), posCasillas[i].getPosicionY(), ancho, alto, Color.yellow, g2d);
            i++;
        }
        //Astilla Arriba-Izquierda
        y += alto;
        x -= ancho;
        while (i < 60) {
            posCasillas[i] = new Posicion(x, y);
            y += alto;
            System.out.println("Casilla " + i + " X: " + posCasillas[i].getPosicionX() + " Y:" + posCasillas[i].getPosicionY());
//            dibujarficha(posCasillas[i].getPosicionX(), posCasillas[i].getPosicionY(), ancho, alto, Color.yellow, g2d);

            i++;
        }
        return posCasillas;
    }
}

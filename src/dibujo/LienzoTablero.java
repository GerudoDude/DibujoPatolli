package dibujo;

/* Librerias a utilizar */
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Equipo 5
 */
public class LienzoTablero extends Canvas {

    /* Metodo que pinta el Jframe que se añadio */
    Color colorDefault = Color.DARK_GRAY; //Se le pone el color gris oscuro
    static boolean sentido = true;

    @Override
    /* Metodo que dibuja tablero, la ficha y el rectangulo que los rodea */
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);

        Rectangle rect = new Rectangle();
        rect.setBounds(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        g2d.draw(rect);
        g2d.rotate(Math.toRadians(45), rect.getCenterX(), rect.getCenterY());

        g2d.setColor(colorDefault);
        g2d.setStroke(new BasicStroke(2));

        //Configuracion
        int x = (int) rect.getCenterX() - 22, y = (int) rect.getCenterY() - 22, ancho = 20, alto = 20, tam = 8;

        dibujarTablero(x, y, ancho, alto, tam, g2d);

        dibujarficha(x, y + (ancho * 0), ancho, alto, Color.ORANGE, g2d);
        dibujarficha(x, y + (ancho * 1), ancho, alto, Color.BLUE, g2d);

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
        //g.setColor(Color.GRAY);
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
}

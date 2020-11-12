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
import javax.swing.JPanel;
import dominio.Casilla;
import dominio.Central;
import dominio.Normal;
import dominio.Semicurva;
import dominio.Tablero;
import dominio.Triangulo;

/**
 *
 * @author Equipo 5
 */
public class LienzoTablero extends JPanel {

    /* Variables a utilizar */
    private Color colorDefault;
    private static boolean sentido;
    private Graphics2D g2d;
    public static Tablero tablero;

    /* Metodo constructor donde se inicializan las variables */
    public LienzoTablero(Tablero tablero) {
        this.tablero = tablero;
        this.colorDefault = Color.BLACK;

        this.sentido = true;
    }

    /* Metodo que dibuja tablero, la ficha y el rectangulo que los rodea */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setOpaque(false);
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
        int x = (int) rect.getCenterX() - 22, y = (int) rect.getCenterY() - 22, ancho = 20, alto = 20;

        escanearTablero(x, y, ancho, alto);
        dibujarTablero(x, y, ancho, alto, this.tablero.getTamanio(), g2d);

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
                    dibujarTriangulo(x - ancho / 2, y, ancho, alto, Sentido.ABAJO, g);
                    sentido = false;
                } else {
                    dibujarTriangulo(x - ancho / 2, y, ancho, alto, Sentido.ARRIBA, g);
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
                    dibujarTriangulo(x, y - alto / 2, ancho, alto, Sentido.DERECHA, g);
                    sentido = false;
                } else {
                    dibujarTriangulo(x, y - alto / 2, ancho, alto, Sentido.IZQUIERDA, g);
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
                    dibujarTriangulo(x + ancho / 2, y, ancho, alto, Sentido.ABAJO, g);
                    sentido = false;
                } else {
                    dibujarTriangulo(x + ancho / 2, y, ancho, alto, Sentido.ARRIBA, g);
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

                    dibujarTriangulo(x, y + alto / 2, ancho, alto, Sentido.DERECHA, g);
                    sentido = false;
                } else {
                    dibujarTriangulo(x, y + alto / 2, ancho, alto, Sentido.IZQUIERDA, g);
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

    public void dibujarUnCuadroCentro(int x, int y, int ancho, int alto, Graphics2D g) {
        g.setColor(Color.yellow);
        Rectangle rect = new Rectangle();
        rect.setBounds(x, y, ancho, alto);
        g.draw(rect);
        g.setColor(colorDefault);
    }

    /**
     * Dibuja un cuadro curvado
     *
     * @param g Componente(JFrame) grafico actual
     */
    public void dibujarUnCuadroCurva(int x, int y, int ancho, int alto, int startAngle, int grade, Graphics2D g) {
        g.drawArc(x, y, ancho, alto, startAngle, grade);
        g.setColor(colorDefault);
    }

    /**
     * Dibuja un triangulo
     *
     * @param fTriangulo
     * @param g Componente(JFrame) grafico actual
     */
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

    public void escanearTablero(int x, int y, int ancho, int alto) {
        Casilla casilla[] = this.tablero.getCasillas();
        int cant = this.tablero.getTamanio() + 1;
        int iCant = 0;

        int i = 0;
        // Astilla izquierda-Arriba
        iCant = cant;
        while (i < iCant) {
            /*8*/

            if (i == 0) {
                casilla[i] = new Central();
            }

            if (i >= 1 && i < iCant - 3) {
                casilla[i] = new Normal();
            }

            if (i == iCant - 2 || i == iCant - 3) {
                casilla[i] = new Triangulo();
            }

            if (i == iCant - 1) {
                casilla[i] = new Semicurva();
            }

            casilla[i].setPos(new Posicion(x, y));
            x -= ancho;

            i++;
        }
        y += alto;
        x += ancho;
        iCant = cant * 2;
        //Astilla Izquierda-Abajo
        while (i < iCant) {
            /*16*/

            if (i == cant) {
                casilla[i] = new Semicurva();
            }
            if (i > cant && i <= cant + 2) {
                casilla[i] = new Triangulo();
            }
            if (i > cant + 2 && i < iCant - 1) {
                casilla[i] = new Normal();
            }
            if (i == iCant - 1) {
                casilla[i] = new Central();
            }

            casilla[i].setPos(new Posicion(x, y));

            x += ancho;

            i++;
        }
        y += alto;
        x -= ancho;
        iCant = (cant * 3) - 1;
        //Astilla Abajo-Izquierda
        while (i < iCant) {
            /*23*/
            if (i < iCant - 3) {
                casilla[i] = new Normal();
            }
            if (i > iCant - 4 && i < iCant - 1) {
                casilla[i] = new Triangulo();
            }
            if (i == iCant - 1) {
                casilla[i] = new Semicurva();
            }
            casilla[i].setPos(new Posicion(x, y));
            y += alto;

            i++;
        }
        //Astilla Abajo-Derecha
        x += ancho;
        y -= alto;
        iCant = (cant * 4) - 1;
        while (i < iCant) {
            /*31*/
            if (i == (cant * 3) - 1) {
                casilla[i] = new Semicurva();
            }
            if (i > (cant * 3) - 1 && i < (cant * 3) + 2) {
                casilla[i] = new Triangulo();
            }
            if (i > (cant * 3) + 1 && i < iCant - 1) {
                casilla[i] = new Normal();
            }
            if (i == iCant - 1) {
                casilla[i] = new Central();
            }
            casilla[i].setPos(new Posicion(x, y));
            y -= alto;
            i++;
        }
        //Astilla Derecha-Abajo
        x += ancho;
        y += alto;
        iCant = (cant * 5) - 2;
        while (i < iCant) {
            /*38*/
            if (i < iCant - 3) {
                casilla[i] = new Normal();
            }
            if (i > iCant - 4 && i < iCant - 1) {
                casilla[i] = new Triangulo();
            }
            if (i == iCant - 1) {
                casilla[i] = new Semicurva();
            }
            casilla[i].setPos(new Posicion(x, y));
            x += ancho;

            i++;
        }
        //Astilla Derecha-Arriba
        y -= alto;
        x -= ancho;
        iCant = (cant * 6) - 2;
        while (i < iCant) {
            /*46*/
            if (i == (cant * 5) - 2) {
                casilla[i] = new Semicurva();
            }
            if (i > (cant * 5) - 2 && i <= (cant * 5)) {
                casilla[i] = new Triangulo();
            }
            if (i > (cant * 5) && i < iCant - 1) {
                casilla[i] = new Normal();
            }
            if (i == iCant - 1) {
                casilla[i] = new Central();
            }
            casilla[i].setPos(new Posicion(x, y));
            x -= ancho;
            i++;
        }
        //Astilla Arriba-Derecha
        y -= alto;
        x += ancho;
        iCant = (cant * 7) - 3;
        while (i < iCant) {
            /*53*/
            if (i < iCant - 3) {
                casilla[i] = new Normal();
            }
            if (i > iCant - 4 && i < iCant - 1) {
                casilla[i] = new Triangulo();
            }
            if (i == iCant - 1) {
                casilla[i] = new Semicurva();
            }
            casilla[i].setPos(new Posicion(x, y));
            y -= alto;

            i++;
        }
        //Astilla Arriba-Izquierda
        y += alto;
        x -= ancho;
        iCant = (cant * 8) - 4;
        while (i < iCant) {
            /*60*/
            if (i == (cant * 7) - 3) {
                casilla[i] = new Semicurva();
            }
            if (i > (cant * 7) - 3 && i <= (cant * 7) - 1) {
                casilla[i] = new Triangulo();
            }
            if (i > (cant * 7) - 1 && i < iCant) {
                casilla[i] = new Normal();
            }
            if (i == iCant - 1) {
                casilla[i] = new Central();
            }
            casilla[i].setPos(new Posicion(x, y));
            y += alto;
            i++;
        }
        this.tablero.setCasillas(casilla);
    }

}

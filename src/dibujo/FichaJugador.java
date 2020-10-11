package dibujo;

/* Librerias a utilizar */
import java.awt.Color;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Equipo 5
 */
public class FichaJugador {

    /* Variables a utilizar */
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private Color color;

    /* Metodo constructor donde inicializa las variables */
    public FichaJugador(int x, int y, int ancho, int alto, Color color) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.color = color;
    }

    /* Get y Sets de las variables */
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

    /* Metodo para obtener la figura de la ficha de cada jugador
       en el tablero */
    public Ellipse2D getFigura() {
        Ellipse2D.Double ficha = new Ellipse2D.Double(x + (ancho / 7), y + (alto / 7), ancho - (ancho / 4), alto - (alto / 4));

        return ficha;
    }
}

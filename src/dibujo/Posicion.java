package dibujo;

/**
 *
 * @author Equipo 5
 */
public class Posicion {
    
    /* Variables a utilizar */
    private int posicionX;
    private int posicionY;

    /* Constructor donde se inicializa las variables */
    public Posicion(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    /* Get y sets de las variables */
    public int getPosicionX() {
        return posicionX;
    }

    public void setPosicionX(int posicionX) {
        this.posicionX = posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    public void setPosicionY(int posicionY) {
        this.posicionY = posicionY;
    }
}


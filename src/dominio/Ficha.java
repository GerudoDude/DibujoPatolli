package dominio;

/* Librerias a utilizar */

/**
 *
 * @author Equipo 5
 */
public class Ficha {
     /* Variables a utilizar */
    private Jugador jugador;
    private FichaJugador fichaJ;

    public Ficha() {
    }

    public Ficha(Jugador jugador) {
        this.jugador = jugador;

    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public FichaJugador getFichaJ() {
        return fichaJ;
    }

    public void setFichaJ(FichaJugador fichaJ) {
        this.fichaJ = fichaJ;
    }

    @Override
    public String toString() {
        return "Ficha{" + "jugador=" + jugador + ", fichaJ=" + fichaJ + '}';
    }
}

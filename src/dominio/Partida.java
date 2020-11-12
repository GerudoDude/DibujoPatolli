package dominio;

/**
 *
 * @author Equipo 5
 */
public class Partida {

    /* Variables a utilizar */
    private Cania cania;
    private Jugador[] jugadores;
    private Jugador jugadorActual;
    private Apuesta apuesta;
    private Tablero tablero;

    /* Metodo constructor */
    public Partida() {
        this.cania = new Cania();
        this.jugadores = jugadores;
        this.jugadorActual = jugadorActual;
        this.apuesta = apuesta;
        this.tablero = tablero;
    }

    /* Metodo constructor que inicializa las variables */
    public Partida(Cania cania, Jugador[] jugadores, Jugador jugadorActual, Apuesta apuesta, Tablero tablero) {
        this.cania = cania;
        this.jugadores = jugadores;
        this.jugadorActual = jugadorActual;
        this.apuesta = apuesta;
        this.tablero = tablero;
    }

    /* Get y sets de las variables */
    public Cania getCania() {
        return cania;
    }

    public void setCania(Cania cania) {
        this.cania = cania;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(Jugador jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public Apuesta getApuesta() {
        return apuesta;
    }

    public void setApuesta(Apuesta apuesta) {
        this.apuesta = apuesta;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
}

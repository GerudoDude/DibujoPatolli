package dominio;

/**
 *
 * @author Equipo 5
 */
public class Tablero {
    
    /* Variable a utilizar */
    private Casilla[] casillas;
    private int tamanio;

    public Tablero(int tamanio) {
        int total = ((tamanio + 1) * 8) - 4;
        this.casillas = new Casilla[total];
        this.tamanio = tamanio;
    }

    public Casilla[] getCasillas() {
        return casillas;
    }

    public void setCasillas(Casilla[] casillas) {
        this.casillas = casillas;
    }

    public int getTamanio() {
        return tamanio;
    }
    
    /* Metodo para posicionar los jugadores */
    public void PosicionarJugadores(Jugador[] jugadores){
    }
    
    
}

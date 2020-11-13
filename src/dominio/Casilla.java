package dominio;

/**
 *
 * @author Equipo 5
 */
public abstract class Casilla {
     /* Variable a utilizar */
    private FichaJugador fichaActual;
    private Posicion pos;

    public Casilla() {
        this.fichaActual=null;
        this.pos=null;
    }

    public FichaJugador getFichaActual() {
        return fichaActual;
    }

    public void setFichaActual(FichaJugador fichaActual) {
        this.fichaActual = fichaActual;
    }


    public Posicion getPos() {
        return pos;
    }

    public void setPos(Posicion pos) {
        this.pos = pos;
    }
    
    /* Metodo del comportamiento de la ficha*/
    public abstract void Comportamiento(Ficha ficha);
}

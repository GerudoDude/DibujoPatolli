package dominio;

import java.awt.Color;

/**
 *
 * @author Equipo 5
 */
public class Jugador {
    
    /* Variables a utilizar */
    private String nombreUsuario;
    private int semillas;
    private Ficha[] fichas;
    
    public Jugador(String nombreUsuario, int semillas) {
        this.nombreUsuario = nombreUsuario;
        this.semillas = semillas;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public int getSemillas() {
        return semillas;
    }

    public void setSemillas(int semillas) {
        this.semillas = semillas;
    }

    public Ficha[] getFichas() {
        return fichas;
    }

    public void ConfigurarFichas(int cant,Color color) {
        Ficha[] f=new Ficha[cant];
        for (Ficha ficha : f) {
            ficha=new Ficha(this);
            ficha.getFichaJ().setColor(color);
        }
        this.fichas=f;
    }

    @Override
    public String toString() {
        return "Jugador[" + "nombreUsuario:" + nombreUsuario + ", semillas:" + semillas + ", fichas:" + fichas + ']';
    }
}

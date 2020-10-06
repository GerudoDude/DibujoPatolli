/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author Citlali Orduño
 */
public class Partida {
    private Cania cania;
    private Jugador[] jugadores;
    private Jugador jugadorActual;
    private Apuesta apuesta;
    private Tablero tablero;

    public Partida() {
        this.cania = new Cania();
        this.jugadores = jugadores;
        this.jugadorActual = jugadorActual;
        this.apuesta = apuesta;
        this.tablero = tablero;
    }
    
    
    
    public Partida(Cania cania, Jugador[] jugadores, Jugador jugadorActual, Apuesta apuesta, Tablero tablero) {
        this.cania = cania;
        this.jugadores = jugadores;
        this.jugadorActual = jugadorActual;
        this.apuesta = apuesta;
        this.tablero = tablero;
    }
    
    
    
    
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

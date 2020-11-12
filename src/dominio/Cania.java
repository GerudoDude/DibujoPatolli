package dominio;

/**
 *
 * @author Equipo 5
 */
public class Cania {

    /* Variable a utilizar */
    private boolean[] canias;

    /* Constructor que inicializa la variable */
    public Cania() {
        this.canias = new boolean[5];
    }

    /* Metodo que hace que la cania salga con o sin bola */
    public boolean[] Roll() {
        for (int i = 0; i < canias.length; i++) {
            canias[i] = Math.random() < 0.5;
        }
        return this.canias;
    }

    /* Metodo para obtener las canias */
    public int getCaniasInt() {
        int num = 0;
        for (boolean cania : canias) {
            num += cania ? 0 : 1;
        }
        if (num == 5) {
            num = 10;
        }
        return num;
    }
}

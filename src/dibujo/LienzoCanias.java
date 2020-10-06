package dibujo;

/* Librerias a utilizar */
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ComponentListener;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author Equipo 5
 *
 */
public class LienzoCanias extends Canvas {
    private Graphics2D g2d;

   
    
    @Override
    /* Metodo que dibuja las canias */
    public void paint(Graphics g) {
       super.paint(g); 
       g2d = (Graphics2D) g;
       g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
       g2d.setColor(Color.BLACK);
       
        Rectangle rect = new Rectangle();
        g2d.clearRect(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        rect.setBounds(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        g2d.draw(rect);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
        
        
        
        
      

        
    }

    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        Rectangle rect = new Rectangle();
        rect.setBounds(0, 0, this.getWidth() - 1, this.getHeight() - 1);
        g2d.draw(rect);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));
    }
    
    
    
   
    

    public void LanzarCanias(boolean[] canias){
        
        int x = 0, y = 0, ancho = 20, alto = 20;
        DibujarLanzarcanias(canias, x, y, ancho, alto, g2d);
       
    }
    
    /* Metodo que dibuja cuando se lanzan las canias */
    public void DibujarLanzarcanias(boolean[] canias, int x, int y, int ancho, int alto, Graphics2D g) {
        for (int i = 0; i < 5; i++) {
            if (canias[i] == true) {
                dibujarCaniaLisa(x + ancho * 3, y + alto, ancho * 2, alto * 3, g);
            } else {
                dibujarCaniaPunto(x + ancho * 3, y + alto, ancho * 2, alto * 3, g);
            }
            x += ancho * 3;
        }
    }

    /* Metodo que dibuja la cania lisa */
    public void dibujarCaniaLisa(int x, int y, int ancho, int alto, Graphics2D g) {
        Rectangle rect = new Rectangle();
        rect.setBounds(x, y, ancho, alto);
        g.draw(rect);
    }

    /* Metodo que dibuja la cania con punto */
    public void dibujarCaniaPunto(int x, int y, int ancho, int alto, Graphics2D g) {
        Rectangle rect = new Rectangle();
        Ellipse2D.Double ell = new Ellipse2D.Double(x + ancho / 3, y + alto / 3, ancho / 3, alto / 4);
        rect.setBounds(x, y, ancho, alto);
        g.draw(rect);
        g.fill(ell);
        g.draw(ell);
    }
}

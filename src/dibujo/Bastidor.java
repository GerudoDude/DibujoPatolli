package dibujo;

/* Librearias a utilizar */
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Equipo 5
 */
public class Bastidor extends javax.swing.JFrame {

    /* Se crean objetos de la clase LienzoTablero */
    LienzoTablero lienzo = new LienzoTablero();
    LienzoCanias lienzo2 = new LienzoCanias();

    /* Metodo que añade los lienzos */
    public Bastidor() {
        lienzo.setBounds(10, 10, 400, 400);
        lienzo2.setBounds(10, 420, 400, 100);
        this.add(lienzo);
        this.add(lienzo2);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLanzarCania = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Patolli");
        setLocation(new java.awt.Point(0, 0));

        btnLanzarCania.setText("Lanzar Cañas");
        btnLanzarCania.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLanzarCaniaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(479, Short.MAX_VALUE)
                .addComponent(btnLanzarCania)
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(458, Short.MAX_VALUE)
                .addComponent(btnLanzarCania, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLanzarCaniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLanzarCaniaActionPerformed
    //Nada por ahora
    }//GEN-LAST:event_btnLanzarCaniaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLanzarCania;
    // End of variables declaration//GEN-END:variables
}

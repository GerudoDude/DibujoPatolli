package dibujo;

/* Librearias a utilizar */
import java.awt.Color;
import javax.swing.JOptionPane;
import negocio.Cania;

/**
 *
 * @author Equipo 5
 */
public class Bastidor extends javax.swing.JFrame {

   /* Se crean objetos de la clase LienzoTablero */
    LienzoTablero lienzoTablero = new LienzoTablero(Color.DARK_GRAY);
    LienzoCanias lienzoCanias = new LienzoCanias();
  //  LienzoFicha lienzoFicha=new LienzoFicha();

    /* Metodo que añade los lienzos */
    public Bastidor() {
        initComponents();
        lienzoTablero.setBounds(10, 10, 400, 400);
        lienzoCanias.setBounds(10, 420, 400, 100);
      //  lienzoFicha.setBounds(10, 10, 400, 400);
        this.add(lienzoTablero);
        this.add(lienzoCanias);
        //this.add(lienzoFicha);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnLanzarCania = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pnlJugador1 = new javax.swing.JPanel();
        lblJugador1 = new javax.swing.JLabel();
        lblFichas1 = new javax.swing.JLabel();
        lblFichas2 = new javax.swing.JLabel();
        lblFichas3 = new javax.swing.JLabel();
        colorJugador1 = new javax.swing.JPanel();
        pnlJugador2 = new javax.swing.JPanel();
        lblJugador2 = new javax.swing.JLabel();
        lblFichas4 = new javax.swing.JLabel();
        lblFichas5 = new javax.swing.JLabel();
        lblFichas6 = new javax.swing.JLabel();
        colorJugador2 = new javax.swing.JPanel();
        pnlJugador3 = new javax.swing.JPanel();
        lblJugador3 = new javax.swing.JLabel();
        lblFichas7 = new javax.swing.JLabel();
        lblFichas8 = new javax.swing.JLabel();
        lblFichas9 = new javax.swing.JLabel();
        colorJugador3 = new javax.swing.JPanel();
        pnlJugador4 = new javax.swing.JPanel();
        lblJugador4 = new javax.swing.JLabel();
        lblFichas10 = new javax.swing.JLabel();
        lblFichas11 = new javax.swing.JLabel();
        lblFichas12 = new javax.swing.JLabel();
        colorJugador4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Patolli");
        setLocation(new java.awt.Point(0, 0));

        btnLanzarCania.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLanzarCania.setText("Lanzar Cañas");
        btnLanzarCania.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLanzarCaniaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Jugadores");

        pnlJugador1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        lblJugador1.setText("Jugador: ");

        lblFichas1.setText("Fichas: ");

        lblFichas2.setText("Semillas:");

        lblFichas3.setText("Color:");

        colorJugador1.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout colorJugador1Layout = new javax.swing.GroupLayout(colorJugador1);
        colorJugador1.setLayout(colorJugador1Layout);
        colorJugador1Layout.setHorizontalGroup(
            colorJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        colorJugador1Layout.setVerticalGroup(
            colorJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlJugador1Layout = new javax.swing.GroupLayout(pnlJugador1);
        pnlJugador1.setLayout(pnlJugador1Layout);
        pnlJugador1Layout.setHorizontalGroup(
            pnlJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJugador1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlJugador1Layout.createSequentialGroup()
                        .addGroup(pnlJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFichas1)
                            .addComponent(lblFichas2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlJugador1Layout.createSequentialGroup()
                        .addComponent(lblJugador1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(lblFichas3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colorJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))))
        );
        pnlJugador1Layout.setVerticalGroup(
            pnlJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJugador1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlJugador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblJugador1)
                        .addComponent(lblFichas3))
                    .addComponent(colorJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFichas1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFichas2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlJugador2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        lblJugador2.setText("Jugador: ");

        lblFichas4.setText("Fichas: ");

        lblFichas5.setText("Semillas:");

        lblFichas6.setText("Color:");

        colorJugador2.setBackground(new java.awt.Color(0, 204, 0));

        javax.swing.GroupLayout colorJugador2Layout = new javax.swing.GroupLayout(colorJugador2);
        colorJugador2.setLayout(colorJugador2Layout);
        colorJugador2Layout.setHorizontalGroup(
            colorJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        colorJugador2Layout.setVerticalGroup(
            colorJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlJugador2Layout = new javax.swing.GroupLayout(pnlJugador2);
        pnlJugador2.setLayout(pnlJugador2Layout);
        pnlJugador2Layout.setHorizontalGroup(
            pnlJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJugador2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlJugador2Layout.createSequentialGroup()
                        .addGroup(pnlJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFichas4)
                            .addComponent(lblFichas5))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlJugador2Layout.createSequentialGroup()
                        .addComponent(lblJugador2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(lblFichas6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colorJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))))
        );
        pnlJugador2Layout.setVerticalGroup(
            pnlJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJugador2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlJugador2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblJugador2)
                        .addComponent(lblFichas6))
                    .addComponent(colorJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFichas4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFichas5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlJugador3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        lblJugador3.setText("Jugador: ");

        lblFichas7.setText("Fichas: ");

        lblFichas8.setText("Semillas:");

        lblFichas9.setText("Color:");

        colorJugador3.setBackground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout colorJugador3Layout = new javax.swing.GroupLayout(colorJugador3);
        colorJugador3.setLayout(colorJugador3Layout);
        colorJugador3Layout.setHorizontalGroup(
            colorJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        colorJugador3Layout.setVerticalGroup(
            colorJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlJugador3Layout = new javax.swing.GroupLayout(pnlJugador3);
        pnlJugador3.setLayout(pnlJugador3Layout);
        pnlJugador3Layout.setHorizontalGroup(
            pnlJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJugador3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlJugador3Layout.createSequentialGroup()
                        .addGroup(pnlJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFichas7)
                            .addComponent(lblFichas8))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlJugador3Layout.createSequentialGroup()
                        .addComponent(lblJugador3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(lblFichas9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colorJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))))
        );
        pnlJugador3Layout.setVerticalGroup(
            pnlJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJugador3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlJugador3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblJugador3)
                        .addComponent(lblFichas9))
                    .addComponent(colorJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFichas7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFichas8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlJugador4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        lblJugador4.setText("Jugador: ");

        lblFichas10.setText("Fichas: ");

        lblFichas11.setText("Semillas:");

        lblFichas12.setText("Color:");

        colorJugador4.setBackground(new java.awt.Color(255, 255, 0));

        javax.swing.GroupLayout colorJugador4Layout = new javax.swing.GroupLayout(colorJugador4);
        colorJugador4.setLayout(colorJugador4Layout);
        colorJugador4Layout.setHorizontalGroup(
            colorJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        colorJugador4Layout.setVerticalGroup(
            colorJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlJugador4Layout = new javax.swing.GroupLayout(pnlJugador4);
        pnlJugador4.setLayout(pnlJugador4Layout);
        pnlJugador4Layout.setHorizontalGroup(
            pnlJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJugador4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlJugador4Layout.createSequentialGroup()
                        .addGroup(pnlJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFichas10)
                            .addComponent(lblFichas11))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlJugador4Layout.createSequentialGroup()
                        .addComponent(lblJugador4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                        .addComponent(lblFichas12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colorJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))))
        );
        pnlJugador4Layout.setVerticalGroup(
            pnlJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJugador4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlJugador4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblJugador4)
                        .addComponent(lblFichas12))
                    .addComponent(colorJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFichas10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblFichas11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Historial");

        btnSalir.setText("Salir del juego");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(431, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnSalir)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(pnlJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pnlJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pnlJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pnlJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(btnLanzarCania, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jScrollPane1)))
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(129, 129, 129))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(190, 190, 190))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlJugador1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlJugador2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlJugador3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlJugador4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(btnLanzarCania, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLanzarCaniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLanzarCaniaActionPerformed
    Cania ca=new Cania();
    boolean[] canias= ca.Roll();
    lienzoCanias.setCanias(canias);
    lienzoCanias.LanzarCanias();
    lienzoTablero.llamar(ca.getCaniasInt());
    }//GEN-LAST:event_btnLanzarCaniaActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
      try {
            int respuesta = JOptionPane.showConfirmDialog(null, "¿Esta  seguro que desea salir del juego?", null,
                    JOptionPane.YES_NO_OPTION);
            if (respuesta == 0) {
                System.exit(0);  
                this.dispose();
            }
          }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLanzarCania;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel colorJugador1;
    private javax.swing.JPanel colorJugador2;
    private javax.swing.JPanel colorJugador3;
    private javax.swing.JPanel colorJugador4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblFichas1;
    private javax.swing.JLabel lblFichas10;
    private javax.swing.JLabel lblFichas11;
    private javax.swing.JLabel lblFichas12;
    private javax.swing.JLabel lblFichas2;
    private javax.swing.JLabel lblFichas3;
    private javax.swing.JLabel lblFichas4;
    private javax.swing.JLabel lblFichas5;
    private javax.swing.JLabel lblFichas6;
    private javax.swing.JLabel lblFichas7;
    private javax.swing.JLabel lblFichas8;
    private javax.swing.JLabel lblFichas9;
    private javax.swing.JLabel lblJugador1;
    private javax.swing.JLabel lblJugador2;
    private javax.swing.JLabel lblJugador3;
    private javax.swing.JLabel lblJugador4;
    private javax.swing.JPanel pnlJugador1;
    private javax.swing.JPanel pnlJugador2;
    private javax.swing.JPanel pnlJugador3;
    private javax.swing.JPanel pnlJugador4;
    // End of variables declaration//GEN-END:variables
}

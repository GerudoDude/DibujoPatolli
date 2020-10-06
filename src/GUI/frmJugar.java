package GUI;

/**
 *
 * @author Equipo 5
 */
public class frmJugar extends javax.swing.JFrame {

    /* Se crea el frame y se ubica en el centro de la pantalla */
    public frmJugar() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel();
        lbImagenPatolli = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnCrearPartida = new javax.swing.JButton();
        btnUnirsePartida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Patolli");

        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));

        lbImagenPatolli.setFont(new java.awt.Font("Oriya MN", 0, 60)); // NOI18N
        lbImagenPatolli.setForeground(new java.awt.Color(3, 74, 166));
        lbImagenPatolli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Patolli.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Oriya MN", 0, 60)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(3, 74, 166));
        jLabel3.setText("Patolli Game");

        btnCrearPartida.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnCrearPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Crear.png"))); // NOI18N
        btnCrearPartida.setText("Crear Partida");
        btnCrearPartida.setIconTextGap(10);

        btnUnirsePartida.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnUnirsePartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Unirse.png"))); // NOI18N
        btnUnirsePartida.setText("Unirse Partida");
        btnUnirsePartida.setIconTextGap(10);

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUnirsePartida, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrearPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(lbImagenPatolli)
                .addGap(24, 24, 24))
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel3)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnCrearPartida, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUnirsePartida, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lbImagenPatolli, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearPartida;
    private javax.swing.JButton btnUnirsePartida;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JLabel lbImagenPatolli;
    // End of variables declaration//GEN-END:variables
}

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

        lbImagenPatolli = new javax.swing.JLabel();
        btnUnirsePartida = new javax.swing.JButton();
        btnCrearPartida = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Patolli");
        setBackground(new java.awt.Color(233, 216, 190));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbImagenPatolli.setFont(new java.awt.Font("Oriya MN", 0, 60)); // NOI18N
        lbImagenPatolli.setForeground(new java.awt.Color(3, 74, 166));
        lbImagenPatolli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/patolli_florentino.jpg"))); // NOI18N
        getContentPane().add(lbImagenPatolli, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, -1, 280));

        btnUnirsePartida.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnUnirsePartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Unirse.png"))); // NOI18N
        btnUnirsePartida.setText("Unirse Partida");
        btnUnirsePartida.setIconTextGap(10);
        getContentPane().add(btnUnirsePartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 200, 54));

        btnCrearPartida.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        btnCrearPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Crear.png"))); // NOI18N
        btnCrearPartida.setText("Crear Partida");
        btnCrearPartida.setIconTextGap(10);
        getContentPane().add(btnCrearPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 203, 53));

        jLabel3.setFont(new java.awt.Font("Oriya MN", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Opciones de partida");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel1.setBackground(new java.awt.Color(233, 216, 190));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 420));

        jPanel1.setBackground(new java.awt.Color(233, 216, 190));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 420, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearPartida;
    private javax.swing.JButton btnUnirsePartida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbImagenPatolli;
    // End of variables declaration//GEN-END:variables
}

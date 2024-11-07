
package grupo3a.tp_diseno.Interfaces;

import grupo3a.tp_diseno.Enumerations.TurnoBedel;
import java.awt.Dimension;


public class RegistrarBedel extends javax.swing.JPanel {

    public interface Listener {
        void back();
        void next();
    }
    
    private Listener listener;
    
    private String nombre = "";
    private String apellido = "";
    private TurnoBedel turno = TurnoBedel.MAÑANA;
    private String contraseña = "";
    private String rContraseña = "";
    
    public RegistrarBedel() {
        initComponents();
        this.setPreferredSize(new Dimension(300,300));
    }

    public void setListener(Listener listener){
        this.listener = listener;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public TurnoBedel getTurno() {
        return turno;
    }

    public String getContraseña() {
        return contraseña;
    }

    public String getrContraseña() {
        return rContraseña;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        lbNombre = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        lbApellido = new javax.swing.JLabel();
        tfApellido = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        lbTurno = new javax.swing.JLabel();
        cbTurno = new javax.swing.JComboBox<>();
        jPanel16 = new javax.swing.JPanel();
        lbContraseña = new javax.swing.JLabel();
        pfContraseña = new javax.swing.JPasswordField();
        jPanel17 = new javax.swing.JPanel();
        lbRContraseña = new javax.swing.JLabel();
        pfContraseñaR = new javax.swing.JPasswordField();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(19, 66, 125));
        jPanel1.setForeground(new java.awt.Color(19, 66, 126));
        jPanel1.setPreferredSize(new java.awt.Dimension(424, 100));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel7.setFont(new java.awt.Font("Montserrat Thin Light", 1, 40)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Registrar Bedel");
        jLabel7.setPreferredSize(new java.awt.Dimension(294, 450));
        jPanel1.add(jLabel7, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(26, 26, 26));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

        jPanel4.setBackground(new java.awt.Color(26, 26, 26));
        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 163));
        jPanel4.setMinimumSize(new java.awt.Dimension(100, 130));
        jPanel4.setPreferredSize(new java.awt.Dimension(37, 120));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Montserrat Thin Light", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Ingrese los datos del bedel");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 815, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addContainerGap(180, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addContainerGap(180, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                    .addGap(50, 50, 50)
                    .addComponent(jLabel1)
                    .addContainerGap(33, Short.MAX_VALUE)))
        );

        jPanel2.add(jPanel4);

        jPanel11.setBackground(new java.awt.Color(26, 26, 26));
        jPanel11.setPreferredSize(new java.awt.Dimension(977, 0));

        jPanel3.setBackground(new java.awt.Color(26, 26, 26));

        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setText("(*)");

        jLabel3.setForeground(new java.awt.Color(255, 0, 51));
        jLabel3.setText("(*)");

        jLabel4.setForeground(new java.awt.Color(255, 0, 51));
        jLabel4.setText("(*)");

        jLabel5.setForeground(new java.awt.Color(255, 0, 51));
        jLabel5.setText("(*)");

        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setText("(*)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel11.add(jPanel3);

        jPanel10.setBackground(new java.awt.Color(26, 26, 26));
        jPanel10.setLayout(new java.awt.GridLayout(0, 1, 0, 5));

        jPanel13.setBackground(new java.awt.Color(26, 26, 26));
        jPanel13.setPreferredSize(new java.awt.Dimension(420, 35));
        jPanel13.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        lbNombre.setForeground(new java.awt.Color(255, 255, 255));
        lbNombre.setText("Nombre");
        lbNombre.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel13.add(lbNombre);

        tfNombre.setBackground(new java.awt.Color(40, 40, 40));
        tfNombre.setForeground(new java.awt.Color(255, 255, 255));
        tfNombre.setPreferredSize(new java.awt.Dimension(64, 20));
        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });
        jPanel13.add(tfNombre);

        jPanel10.add(jPanel13);

        jPanel12.setBackground(new java.awt.Color(26, 26, 26));
        jPanel12.setPreferredSize(new java.awt.Dimension(420, 35));
        jPanel12.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        lbApellido.setForeground(new java.awt.Color(255, 255, 255));
        lbApellido.setText("Apellido");
        lbApellido.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel12.add(lbApellido);

        tfApellido.setBackground(new java.awt.Color(40, 40, 40));
        tfApellido.setForeground(new java.awt.Color(255, 255, 255));
        tfApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfApellidoActionPerformed(evt);
            }
        });
        jPanel12.add(tfApellido);

        jPanel10.add(jPanel12);

        jPanel15.setBackground(new java.awt.Color(26, 26, 26));
        jPanel15.setPreferredSize(new java.awt.Dimension(420, 35));
        jPanel15.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        lbTurno.setForeground(new java.awt.Color(255, 255, 255));
        lbTurno.setText("Turno en el que trabaja");
        lbTurno.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel15.add(lbTurno);

        cbTurno.setBackground(new java.awt.Color(40, 40, 40));
        cbTurno.setForeground(new java.awt.Color(255, 255, 255));
        cbTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mañana", "Tarde", "Noche" }));
        cbTurno.setToolTipText("");
        cbTurno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTurnoActionPerformed(evt);
            }
        });
        jPanel15.add(cbTurno);

        jPanel10.add(jPanel15);

        jPanel16.setBackground(new java.awt.Color(26, 26, 26));
        jPanel16.setPreferredSize(new java.awt.Dimension(420, 35));
        jPanel16.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        lbContraseña.setForeground(new java.awt.Color(255, 255, 255));
        lbContraseña.setText("Contraseña");
        lbContraseña.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel16.add(lbContraseña);

        pfContraseña.setBackground(new java.awt.Color(40, 40, 40));
        pfContraseña.setForeground(new java.awt.Color(255, 255, 255));
        pfContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfContraseñaActionPerformed(evt);
            }
        });
        jPanel16.add(pfContraseña);

        jPanel10.add(jPanel16);

        jPanel17.setBackground(new java.awt.Color(26, 26, 26));
        jPanel17.setPreferredSize(new java.awt.Dimension(420, 35));
        jPanel17.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        lbRContraseña.setForeground(new java.awt.Color(255, 255, 255));
        lbRContraseña.setText("Repetir contraseña");
        lbRContraseña.setPreferredSize(new java.awt.Dimension(70, 20));
        jPanel17.add(lbRContraseña);

        pfContraseñaR.setBackground(new java.awt.Color(40, 40, 40));
        pfContraseñaR.setForeground(new java.awt.Color(255, 255, 255));
        pfContraseñaR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfContraseñaRActionPerformed(evt);
            }
        });
        jPanel17.add(pfContraseñaR);

        jPanel10.add(jPanel17);

        jPanel11.add(jPanel10);

        jPanel2.add(jPanel11);

        jPanel6.setPreferredSize(new java.awt.Dimension(977, 80));

        jPanel7.setBackground(new java.awt.Color(60, 63, 0));
        jPanel7.setPreferredSize(new java.awt.Dimension(100, 80));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jPanel9.setBackground(new java.awt.Color(26, 26, 26));
        jPanel9.setPreferredSize(new java.awt.Dimension(100, 80));

        btnCancelar.setBackground(new java.awt.Color(17, 17, 17));
        btnCancelar.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.setPreferredSize(new java.awt.Dimension(110, 40));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel7.add(jPanel9);

        jPanel8.setBackground(new java.awt.Color(26, 26, 26));
        jPanel8.setPreferredSize(new java.awt.Dimension(100, 80));

        btnRegistrar.setBackground(new java.awt.Color(17, 17, 17));
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("Registrar");
        btnRegistrar.setBorder(new BordesRedondeados(20));
        btnRegistrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRegistrar.setPreferredSize(new java.awt.Dimension(110, 40));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        jPanel7.add(jPanel8);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel2.add(jPanel6);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        nombre = tfNombre.getText();
    }//GEN-LAST:event_tfNombreActionPerformed

    private void tfApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfApellidoActionPerformed
        apellido = tfApellido.getText();
    }//GEN-LAST:event_tfApellidoActionPerformed

    private void cbTurnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTurnoActionPerformed
        
        if (cbTurno.getSelectedIndex() == 0) // mañana
            turno = TurnoBedel.MAÑANA;
        else if (cbTurno.getSelectedIndex() == 1) // tarde
            turno = TurnoBedel.TARDE;
        else  // noche
            turno = TurnoBedel.NOCHE;
        
        
    }//GEN-LAST:event_cbTurnoActionPerformed

    private void pfContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfContraseñaActionPerformed
        contraseña = new String(pfContraseña.getPassword());
    }//GEN-LAST:event_pfContraseñaActionPerformed

    private void pfContraseñaRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfContraseñaRActionPerformed
        rContraseña = new String(pfContraseñaR.getPassword());
    }//GEN-LAST:event_pfContraseñaRActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
        
        nombre = tfNombre.getText();
        apellido = tfApellido.getText();
        contraseña = new String(pfContraseña.getPassword());
        rContraseña = new String(pfContraseñaR.getPassword());
        // la verificacion se hace en el main
//        String regex = "([a-zA-Z])+";
//        String input = "hola";

//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(input);
        
//        System.out.println("" + matcher. matches());

//        if (pattern.matcher(nombre).matches()) ;
//        if (pattern.matcher(apellido).matches()) ;
        
//        if (idBedel.length() > 0);
//        if (contraseña.length() > 0);
        
//        if (!contraseña.equals(rContraseña));
        
        if (listener != null)
            listener.next();
        
        
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (listener != null)
            listener.back();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cbTurno;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbContraseña;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbRContraseña;
    private javax.swing.JLabel lbTurno;
    private javax.swing.JPasswordField pfContraseña;
    private javax.swing.JPasswordField pfContraseñaR;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}

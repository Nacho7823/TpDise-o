/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package grupo3a.tp_diseno.Vista.Bedel;

/**
 *
 * @author mattc
 */
public class MenuBedel extends javax.swing.JPanel {

    public interface Listener {
        void back();
        void registrarReserva();
        void buscarAulas();
        void listarReservasParaUnCurso();
        void listarReservasParaUnDia();
    };
    
    private Listener listener;
    
    public MenuBedel() {
        initComponents();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnListarReservaPorDia = new javax.swing.JButton();
        btnListarReservaPorCurso = new javax.swing.JButton();
        btnBuscarAula = new javax.swing.JButton();
        btnRegistrarReserva = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnCancelar1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(26, 26, 26));
        jPanel1.setForeground(new java.awt.Color(19, 66, 125));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(19, 66, 125));
        jPanel2.setFont(new java.awt.Font("Montserrat Light", 1, 40)); // NOI18N
        jPanel2.setMaximumSize(new java.awt.Dimension(294, 52));
        jPanel2.setPreferredSize(new java.awt.Dimension(685, 100));

        jLabel1.setFont(new java.awt.Font("Montserrat Light", 1, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Menu Bedel");
        jLabel1.setPreferredSize(new java.awt.Dimension(259, 49));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(26, 26, 26));

        btnListarReservaPorDia.setBackground(new java.awt.Color(16, 16, 16));
        btnListarReservaPorDia.setForeground(new java.awt.Color(255, 255, 255));
        btnListarReservaPorDia.setText("Listar reservas por día");
        btnListarReservaPorDia.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnListarReservaPorDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarReservaPorDiaActionPerformed(evt);
            }
        });

        btnListarReservaPorCurso.setBackground(new java.awt.Color(16, 16, 16));
        btnListarReservaPorCurso.setForeground(new java.awt.Color(255, 255, 255));
        btnListarReservaPorCurso.setText("Listar reservas por curso");
        btnListarReservaPorCurso.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        btnListarReservaPorCurso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarReservaPorCursoActionPerformed(evt);
            }
        });

        btnBuscarAula.setBackground(new java.awt.Color(16, 16, 16));
        btnBuscarAula.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscarAula.setText("Buscar aulas");
        btnBuscarAula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAulaActionPerformed(evt);
            }
        });

        btnRegistrarReserva.setBackground(new java.awt.Color(16, 16, 16));
        btnRegistrarReserva.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarReserva.setText("Registrar reserva");
        btnRegistrarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarReservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRegistrarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarAula, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListarReservaPorCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnListarReservaPorDia, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnRegistrarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarAula, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnListarReservaPorCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnListarReservaPorDia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(193, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel7.setBackground(new java.awt.Color(28, 28, 28));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        jPanel9.setBackground(new java.awt.Color(26, 26, 26));
        jPanel9.setPreferredSize(new java.awt.Dimension(0, 80));

        btnCancelar1.setBackground(new java.awt.Color(17, 17, 17));
        btnCancelar1.setForeground(new java.awt.Color(255, 255, 255));
        btnCancelar1.setText("Cerrar sesion");
        btnCancelar1.setName("Cerrar sesion"); // NOI18N
        btnCancelar1.setPreferredSize(new java.awt.Dimension(110, 40));
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(130, 130, 130)
                    .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addContainerGap(20, Short.MAX_VALUE)
                    .addComponent(btnCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(20, 20, 20)))
        );

        jPanel7.add(jPanel9);

        jPanel8.setBackground(new java.awt.Color(26, 26, 26));
        jPanel8.setPreferredSize(new java.awt.Dimension(0, 80));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel7.add(jPanel8);

        jPanel1.add(jPanel7, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnListarReservaPorDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarReservaPorDiaActionPerformed
        if (listener != null)
            listener.listarReservasParaUnCurso();
    }//GEN-LAST:event_btnListarReservaPorDiaActionPerformed

    private void btnListarReservaPorCursoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarReservaPorCursoActionPerformed
        if (listener != null)
            listener.listarReservasParaUnCurso();
    }//GEN-LAST:event_btnListarReservaPorCursoActionPerformed

    private void btnBuscarAulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAulaActionPerformed
        if (listener != null)
            listener.buscarAulas();
    }//GEN-LAST:event_btnBuscarAulaActionPerformed

    private void btnRegistrarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarReservaActionPerformed
        if (listener != null)
            listener.registrarReserva();
    }//GEN-LAST:event_btnRegistrarReservaActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        if (listener != null)
            listener.back();
    }//GEN-LAST:event_btnCancelar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarAula;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JButton btnListarReservaPorCurso;
    private javax.swing.JButton btnListarReservaPorDia;
    private javax.swing.JButton btnRegistrarReserva;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}

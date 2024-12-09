/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package grupo3a.tp_diseno.Vista;

import java.awt.Color;

public class Alerta extends javax.swing.JPanel {

    public interface Listener {
        public void next();
    }

    private Listener listener;
    private Color backColor = new Color(0,0,0,55);
    
    public Alerta() {
        initComponents();
    }
    
    public void setListener(Listener listener) {
        this.listener = listener;
    }
    
    private String[] split(String text, int size){
        
        int arraySize = (int) Math.ceil((double) text.length() / size); // Calcula el tamaño del array
        
        String[] strs = new String[arraySize];
        
        for (int i = 0; i < text.length(); i += size) {
            int fin = Math.min(i + size, text.length());
            strs[i / size] = text.substring(i, fin);
        }
        return strs;
    }

    public void setText(String text) {
//        String txt = "<html>";
//        String[] strs = split(text, 40);
//        for (int i = 0; i < strs.length; i++) {
//            txt += strs[i];
//            if (i != strs.length - 1)
//                txt += "<br>";
//        }
//        lb.setText(txt);
        lb.setText(text);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lb = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();

        setBackground(new Color(0,0,0,0));
        setOpaque(false);
        setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(backColor);
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(815, 500));

        jPanel4.setBackground(new java.awt.Color(157, 154, 111));
        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 163));
        jPanel4.setMinimumSize(new java.awt.Dimension(100, 130));
        jPanel4.setPreferredSize(new java.awt.Dimension(37, 150));

        lb.setFont(new java.awt.Font("Montserrat Thin Light", 1, 18)); // NOI18N
        lb.setForeground(new java.awt.Color(255, 255, 255));
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("seleccione el tipo de reserva");

        jPanel1.setBackground(new java.awt.Color(157, 154, 111));

        jButton2.setBackground(new java.awt.Color(17, 17, 17));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("OK");
        jButton2.setPreferredSize(new java.awt.Dimension(120, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lb)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(193, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(177, Short.MAX_VALUE))
        );

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (listener != null)
            listener.next();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}

package App;


import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class FormRegistro extends javax.swing.JFrame {

    public FormRegistro() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JtextFieldNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JbuttonRegistrarMedicamento = new javax.swing.JButton();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        JTextCrearCategoria = new javax.swing.JTextField();
        JlabelNuevaCat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulario Registro Medicamento");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/IconMediClass.png")));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Formulario Registro Medicamento ");

        JtextFieldNombre.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(java.awt.SystemColor.textHighlight);
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(java.awt.SystemColor.textHighlight);
        jLabel5.setText("Seleccione la categoria");

        JbuttonRegistrarMedicamento.setBackground(new java.awt.Color(9, 60, 41));
        JbuttonRegistrarMedicamento.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        JbuttonRegistrarMedicamento.setForeground(new java.awt.Color(255, 255, 255));
        JbuttonRegistrarMedicamento.setText("Registrar Medicamento");
        JbuttonRegistrarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbuttonRegistrarMedicamentoActionPerformed(evt);
            }
        });

        jComboBoxCategoria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBoxCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCategoriaItemStateChanged(evt);
            }
        });

        JTextCrearCategoria.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JTextCrearCategoria.setEnabled(false);

        JlabelNuevaCat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JTextCrearCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JlabelNuevaCat, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(151, 151, 151))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(JtextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel1)
                                .addComponent(jLabel5))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(JbuttonRegistrarMedicamento)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(JtextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel5)
                .addGap(28, 28, 28)
                .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(JlabelNuevaCat, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTextCrearCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(JbuttonRegistrarMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JbuttonRegistrarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbuttonRegistrarMedicamentoActionPerformed
        // TODO add your handling code here:

        String nombre = JtextFieldNombre.getText();
        String categoria = "";
        
        categoria = JTextCrearCategoria.getText();
        
        if (!categoria.equals("")) {
            //registrar en la base de datos
            try {
                Connection con = conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("INSERT INTO medicamentos (nombre, categoria) VALUES (?,?)");
                ps.setString(1, nombre);
                ps.setString(2, categoria);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Medicamento registrado");
                con.close();
                JtextFieldNombre.setText("");

                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Debe ingresar una categoria");
        }
    }//GEN-LAST:event_JbuttonRegistrarMedicamentoActionPerformed

    private void jComboBoxCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaItemStateChanged
        // TODO add your handling code here:
        String categoria = jComboBoxCategoria.getSelectedItem().toString();
        if (categoria.equals("click para crear una nueva categoria")) {
            JTextCrearCategoria.setEnabled(true);
            JTextCrearCategoria.setText("");
            JlabelNuevaCat.setVisible(true);
            JlabelNuevaCat.setText("Nueva categoria");
        } else {
            JTextCrearCategoria.setEnabled(false);
            JTextCrearCategoria.setText(categoria);
            JlabelNuevaCat.setText("");
        }

    }//GEN-LAST:event_jComboBoxCategoriaItemStateChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField JTextCrearCategoria;
    private javax.swing.JButton JbuttonRegistrarMedicamento;
    private javax.swing.JLabel JlabelNuevaCat;
    public javax.swing.JTextField JtextFieldNombre;
    public javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables


}


package App;

/**
 *
 * @author jonat
 */

import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class FormRegistro extends javax.swing.JFrame {

    /**
     * Creates new form FromRegistro
     */
    public FormRegistro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        JtextFieldNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JbuttonRegistrarMedicamento = new javax.swing.JButton();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        JTextCrearCategoria = new javax.swing.JTextField();
        JlabelNuevaCat = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setText("Formulario Registro Medicamento ");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Seleccione la categoria");

        JbuttonRegistrarMedicamento.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        JbuttonRegistrarMedicamento.setText("Registrar Medicamento");
        JbuttonRegistrarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbuttonRegistrarMedicamentoActionPerformed(evt);
            }
        });

        jComboBoxCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCategoriaItemStateChanged(evt);
            }
        });

        JTextCrearCategoria.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(JTextCrearCategoria, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(JlabelNuevaCat, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(204, 204, 204)
                        .addComponent(JbuttonRegistrarMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addGap(40, 40, 40)
                .addComponent(JtextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(34, 34, 34)
                .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JlabelNuevaCat, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTextCrearCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(JbuttonRegistrarMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
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
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables


}

package App;


import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FormRegistro extends javax.swing.JFrame {

    public FormRegistro() {
        initComponents();

        //jlabel background
        Image background = new ImageIcon(this.getClass().getResource("/images/background3.jpg")).getImage();

        JLabelBackground.setIcon(new ImageIcon(background));

        //bound get frame size
        JLabelBackground.setBounds(0, 0, 641, 768);


        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JLabelBackground = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JtextFieldNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JbuttonRegistrarMedicamento = new javax.swing.JButton();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        JTextCrearCategoria = new javax.swing.JTextField();
        JlabelNuevaCat = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JtextFieldNombreGenerico = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulario Registro Medicamento");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/IconMediClass.png")));
        setResizable(false);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(java.awt.SystemColor.textHighlight);
        jLabel1.setText("Formulario Registro Medicamento ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, 64));

        JtextFieldNombre.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jPanel1.add(JtextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 440, 34));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(java.awt.SystemColor.textHighlight);
        jLabel4.setText("Nombre genérico");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(java.awt.SystemColor.textHighlight);
        jLabel5.setText("Seleccione la categoria");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 303, -1, -1));

        JbuttonRegistrarMedicamento.setBackground(java.awt.SystemColor.textHighlight);
        JbuttonRegistrarMedicamento.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        JbuttonRegistrarMedicamento.setForeground(new java.awt.Color(255, 255, 255));
        JbuttonRegistrarMedicamento.setText("Registrar Medicamento");
        JbuttonRegistrarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbuttonRegistrarMedicamentoActionPerformed(evt);
            }
        });
        jPanel1.add(JbuttonRegistrarMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 600, -1, 51));

        jComboBoxCategoria.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBoxCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCategoriaItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBoxCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 331, 38));

        JTextCrearCategoria.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        JTextCrearCategoria.setEnabled(false);
        jPanel1.add(JTextCrearCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 500, 331, 36));

        JlabelNuevaCat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(JlabelNuevaCat, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 475, 129, 23));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setForeground(java.awt.SystemColor.textHighlight);
        jLabel6.setText("Nombre medicamento");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        JtextFieldNombreGenerico.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jPanel1.add(JtextFieldNombreGenerico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 440, 34));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(JLabelBackground)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(JLabelBackground)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JbuttonRegistrarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbuttonRegistrarMedicamentoActionPerformed
        // TODO add your handling code here:

        String nombre = JtextFieldNombre.getText();
        String generico = JtextFieldNombreGenerico.getText();
        String categoria = "";
        
        categoria = JTextCrearCategoria.getText();
        
        if (!categoria.equals("")) {
            //registrar en la base de datos
            try {
                Connection con = conexion.getConexion();
                PreparedStatement ps = con.prepareStatement("INSERT INTO medicamentos (nombre, categoria, generico) VALUES (?,?,?)");
                ps.setString(1, nombre);
                ps.setString(2, categoria);
                ps.setString(3, generico);
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
        if (categoria.equals("Click para crear una nueva Categoria")) {
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
    private javax.swing.JLabel JLabelBackground;
    public javax.swing.JTextField JTextCrearCategoria;
    private javax.swing.JButton JbuttonRegistrarMedicamento;
    private javax.swing.JLabel JlabelNuevaCat;
    public javax.swing.JTextField JtextFieldNombre;
    public javax.swing.JTextField JtextFieldNombreGenerico;
    public javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables


}

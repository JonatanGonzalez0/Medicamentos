package App;


import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class FormRegistroEnfermero extends javax.swing.JFrame {

    public FormRegistroEnfermero() {
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JtextFieldApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        JbuttonRegistrarEnfermero = new javax.swing.JButton();
        JtextFieldNombre = new javax.swing.JTextField();
        JLabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulario Registro Medicamento");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/IconMediClass.png")));
        setResizable(false);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(java.awt.SystemColor.textHighlight);
        jLabel1.setText("Formulario Registro Enfermero");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 60, -1, 64));

        JtextFieldApellido.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jPanel1.add(JtextFieldApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, 440, 34));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(java.awt.SystemColor.textHighlight);
        jLabel4.setText("Nombres");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(java.awt.SystemColor.textHighlight);
        jLabel5.setText("Apellidos");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, -1, -1));

        JbuttonRegistrarEnfermero.setBackground(java.awt.SystemColor.textHighlight);
        JbuttonRegistrarEnfermero.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        JbuttonRegistrarEnfermero.setForeground(new java.awt.Color(255, 255, 255));
        JbuttonRegistrarEnfermero.setText("Registrar Enfermero");
        JbuttonRegistrarEnfermero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JbuttonRegistrarEnfermeroActionPerformed(evt);
            }
        });
        jPanel1.add(JbuttonRegistrarEnfermero, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 530, -1, 51));

        JtextFieldNombre.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jPanel1.add(JtextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 440, 34));
        jPanel1.add(JLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 740, 780));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 734, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JbuttonRegistrarEnfermeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JbuttonRegistrarEnfermeroActionPerformed
        // TODO add your handling code here:

        String nombre = JtextFieldNombre.getText();
        String apellido = JtextFieldApellido.getText();
        
        if (!nombre.equals("") && !apellido.equals("")) {
            //registrar en la base de datos
            try {
                nombre = nombre + " " + apellido;
                Connection connection = conexion.getConexion();
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM ENFERMEROS WHERE nombre = ?");
                preparedStatement.setString(1, nombre);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next() && resultSet.getInt(1) == 0) {
                    // El nombre no existe, realizar la inserción
                    PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO ENFERMEROS (nombre) VALUES (?)");
                    insertStatement.setString(1, nombre);
                    insertStatement.executeUpdate();
                    if (insertStatement.getUpdateCount() > 0) {
                        //mostrar joption pane solo por 0.5 segundos registro exitoso
                        JOptionPane pane = new JOptionPane("Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                        JDialog dialog = pane.createDialog("Registro exitoso");
                        dialog.setModal(false);
                        dialog.setVisible(true);
                        new Timer(500, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                dialog.setVisible(false);
                            }
                        }).start();
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "No se pudo registrar el doctor/a");
                    }
                } else {
                    // El nombre ya existe, mostrar mensaje de error
                    JOptionPane.showMessageDialog(null, "Ya existe un enfermero/a con ese nombre");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre y apellido");
        }
    }//GEN-LAST:event_JbuttonRegistrarEnfermeroActionPerformed

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
            java.util.logging.Logger.getLogger(FormRegistroEnfermero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormRegistroEnfermero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormRegistroEnfermero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormRegistroEnfermero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormRegistroEnfermero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelBackground;
    private javax.swing.JButton JbuttonRegistrarEnfermero;
    public javax.swing.JTextField JtextFieldApellido;
    public javax.swing.JTextField JtextFieldNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables


}

package App;
import com.mysql.cj.jdbc.CallableStatement;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import java.sql.Statement;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;
import java.util.Date;

public class Home extends javax.swing.JFrame {
    // Variables globales
    public ArrayList registros;
    public int id_medicamento;
    public int id_doctor;
    public int id_paciente;
    public int id_enfermero;
    public String nombre_medicamento;
    public String generico_medicamento;
    public String categoria_medicamento;
    public String nombre_doctor;
    public String nombre_paciente;
    public String nombre_enfermero;
    
    public ArrayList<ItemCarrito> tempCarrito;


    public Home() throws MalformedURLException {
//        try{
//            Registro registro = new Registro(3);
//            registro.imprimir();
//        }catch(FileNotFoundException   e){
//            System.out.println(e);
//        }
//        System.exit(0);
        
        initComponents();
        cargarMedicamentos();
        cargarDoctores();
        cargarPacientes();
        cargarEnfermeros();
        
        // Crea un ImageIcon con la imagen de tu logotipo
        
        ImageIcon imageIcon = new ImageIcon(new ImageIcon(getClass().getResource("/images/IH-LOGO-2.png")).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT));
        jLabelLogo.setIcon(imageIcon);
      
        //jpanel image background
        Image background = new ImageIcon(getClass().getResource("/images/background3.jpg")).getImage();

        //aplicar transparencia al JLabel de fondo
        JlabelBackground.setBackground(new Color(0, 0, 0, 128)); // Establece la opacidad del fondo (128 es semitransparente)
        JlabelBackground.setOpaque(true); // Asegura que el JLabel sea opaco

        //jlabel image background
        JlabelBackground.setIcon(new ImageIcon(background.getScaledInstance(JlabelBackground.getWidth(), JlabelBackground.getHeight(), 1)));
        
        
        // Crear el menú contextual
        JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem deleteMenuItem = new JMenuItem("Eliminar Fila");
        deleteMenuItem.addActionListener((ActionEvent e) -> {
            int selectedRow = JTable_CarritoMedicamentos.getSelectedRow();
            if (selectedRow != -1) {
                DefaultTableModel model = (DefaultTableModel) JTable_CarritoMedicamentos.getModel();
                model.removeRow(selectedRow);
            }
            // eliminar el registro de tempCarrito
            // obtener numero de fila seleccionada y eliminarla de tempCarrito (ArrayList)
            tempCarrito.remove(selectedRow);
        });
        popupMenu.add(deleteMenuItem);
        // Asociar el menú contextual con el JTable
        JTable_CarritoMedicamentos.setComponentPopupMenu(popupMenu);
        JTable_CarritoMedicamentos.setRowHeight(30);

        comprobarCarpetaApp();
        JBusqueda_doctor.requestFocus();
        jNombreMedicamento.setVisible(false);
        jCategoria.setVisible(false);

        // variable global para guardar lista de registros
        registros = new ArrayList<>();
        tempCarrito = new ArrayList<>();
        
        // variable temporal id_medicamento al buscar medicamento cuando cambie jcombo_Medicamento
        id_medicamento = 0;
        id_doctor = 0;
        id_paciente = 0;
        id_enfermero = 0;
        nombre_medicamento = "";
        generico_medicamento ="";
        categoria_medicamento = "";
        nombre_doctor = "";
        nombre_paciente = "";
        nombre_enfermero = "";

        actualizarInfo();
        actualizarMedicamento();
        System.out.println("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpaneForm = new javax.swing.JPanel();
        jcombo_Medicamento = new javax.swing.JComboBox<>();
        JBusqueda_Medicamento = new javax.swing.JTextField();
        jcantidadRegistro = new javax.swing.JTextField();
        jCategoria = new javax.swing.JTextField();
        jNombreMedicamento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonAgregarMedicamento = new javax.swing.JButton();
        jLabelFecha = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        JBusqueda_Paciente = new javax.swing.JTextField();
        jcombo_Paciente = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable_CarritoMedicamentos = new javax.swing.JTable();
        jButtonRegistrar = new javax.swing.JButton();
        jLabelLogo = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        JBusqueda_doctor = new javax.swing.JTextField();
        jcombo_Doctor = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        JBusqueda_Enfermero = new javax.swing.JTextField();
        jcombo_Enfermero = new javax.swing.JComboBox<>();
        JlabelBackground = new javax.swing.JLabel();
        BarraSuperior = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        JmenuActualizar = new javax.swing.JMenu();
        JmenuSalir = new javax.swing.JMenu();
        JmenuReporte = new javax.swing.JMenu();
        JmenuReporteMensual = new javax.swing.JMenu();
        JmenuReporteDoctores = new javax.swing.JMenu();
        JmenuReporteOcupacional = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenuVerRegistros = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MediClass App");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/IconMediClass.png")));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JpaneForm.setForeground(new java.awt.Color(204, 0, 0));
        JpaneForm.setOpaque(false);
        JpaneForm.setPreferredSize(new java.awt.Dimension(1366, 768));
        JpaneForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jcombo_Medicamento.setBackground(new java.awt.Color(102, 153, 255));
        jcombo_Medicamento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jcombo_Medicamento.setForeground(new java.awt.Color(255, 255, 255));
        jcombo_Medicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcombo_MedicamentoActionPerformed(evt);
            }
        });
        JpaneForm.add(jcombo_Medicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 580, 460, 35));

        JBusqueda_Medicamento.setBackground(new java.awt.Color(0, 51, 153));
        JBusqueda_Medicamento.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        JBusqueda_Medicamento.setForeground(new java.awt.Color(255, 255, 255));
        JBusqueda_Medicamento.setNextFocusableComponent(jcantidadRegistro);
        JBusqueda_Medicamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JBusqueda_MedicamentoKeyReleased(evt);
            }
        });
        JpaneForm.add(JBusqueda_Medicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 540, 460, 35));

        jcantidadRegistro.setBackground(new java.awt.Color(0, 51, 153));
        jcantidadRegistro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jcantidadRegistro.setForeground(new java.awt.Color(255, 255, 255));
        jcantidadRegistro.setNextFocusableComponent(jButtonAgregarMedicamento);
        jcantidadRegistro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jcantidadRegistroKeyReleased(evt);
            }
        });
        JpaneForm.add(jcantidadRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 650, 140, 50));

        jCategoria.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jCategoria.setEnabled(false);
        JpaneForm.add(jCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 690, 20, 43));

        jNombreMedicamento.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jNombreMedicamento.setEnabled(false);
        JpaneForm.add(jNombreMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 690, 30, 43));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 128));
        jLabel6.setText("RESUMEN MEDICAMENTOS");
        JpaneForm.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 30, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 128));
        jLabel7.setText("CANTIDAD");
        JpaneForm.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 650, 130, 40));

        jButtonAgregarMedicamento.setBackground(new java.awt.Color(0, 51, 102));
        jButtonAgregarMedicamento.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButtonAgregarMedicamento.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgregarMedicamento.setText("Agregar");
        jButtonAgregarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarMedicamentoActionPerformed(evt);
            }
        });
        JpaneForm.add(jButtonAgregarMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 650, 200, 50));

        jLabelFecha.setBackground(new java.awt.Color(0, 51, 153));
        jLabelFecha.setFont(new java.awt.Font("Unispace", 0, 18)); // NOI18N
        jLabelFecha.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFecha.setText("FECHA");
        jLabelFecha.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        jLabelFecha.setOpaque(true);
        JpaneForm.add(jLabelFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 220, 30));

        jCalendar1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jCalendar1.setDecorationBordersVisible(true);
        jCalendar1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar1PropertyChange(evt);
            }
        });
        JpaneForm.add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 410, 190));

        JBusqueda_Paciente.setBackground(new java.awt.Color(0, 51, 153));
        JBusqueda_Paciente.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        JBusqueda_Paciente.setForeground(new java.awt.Color(255, 255, 255));
        JBusqueda_Paciente.setNextFocusableComponent(JBusqueda_doctor);
        JBusqueda_Paciente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JBusqueda_PacienteKeyReleased(evt);
            }
        });
        JpaneForm.add(JBusqueda_Paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, 460, 35));

        jcombo_Paciente.setBackground(new java.awt.Color(102, 153, 255));
        jcombo_Paciente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jcombo_Paciente.setForeground(new java.awt.Color(255, 255, 255));
        jcombo_Paciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcombo_PacienteActionPerformed(evt);
            }
        });
        JpaneForm.add(jcombo_Paciente, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 460, 35));

        jScrollPane1.setBackground(new java.awt.Color(102, 153, 255));

        JTable_CarritoMedicamentos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        JTable_CarritoMedicamentos.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        JTable_CarritoMedicamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Nombre", "Genérico", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        JTable_CarritoMedicamentos.setColumnSelectionAllowed(true);
        JTable_CarritoMedicamentos.setGridColor(new java.awt.Color(102, 153, 255));
        JTable_CarritoMedicamentos.setSelectionBackground(new java.awt.Color(51, 102, 255));
        JTable_CarritoMedicamentos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        JTable_CarritoMedicamentos.setShowGrid(true);
        jScrollPane1.setViewportView(JTable_CarritoMedicamentos);
        JTable_CarritoMedicamentos.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (JTable_CarritoMedicamentos.getColumnModel().getColumnCount() > 0) {
            JTable_CarritoMedicamentos.getColumnModel().getColumn(0).setPreferredWidth(30);
            JTable_CarritoMedicamentos.getColumnModel().getColumn(1).setPreferredWidth(100);
            JTable_CarritoMedicamentos.getColumnModel().getColumn(2).setPreferredWidth(100);
            JTable_CarritoMedicamentos.getColumnModel().getColumn(3).setPreferredWidth(100);
        }

        JpaneForm.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 90, 570, 540));

        jButtonRegistrar.setBackground(new java.awt.Color(0, 51, 102));
        jButtonRegistrar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButtonRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        JpaneForm.add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 650, 170, 50));

        jLabelLogo.setBackground(new java.awt.Color(0, 0, 0));
        jLabelLogo.setOpaque(true);
        JpaneForm.add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 200, 200));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 128));
        jLabel10.setText("Buscar Medicamento");
        JpaneForm.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 540, 190, 39));

        JBusqueda_doctor.setBackground(new java.awt.Color(0, 51, 153));
        JBusqueda_doctor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        JBusqueda_doctor.setForeground(new java.awt.Color(255, 255, 255));
        JBusqueda_doctor.setNextFocusableComponent(JBusqueda_Enfermero);
        JBusqueda_doctor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JBusqueda_doctorKeyReleased(evt);
            }
        });
        JpaneForm.add(JBusqueda_doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, 460, 35));

        jcombo_Doctor.setBackground(new java.awt.Color(102, 153, 255));
        jcombo_Doctor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jcombo_Doctor.setForeground(new java.awt.Color(255, 255, 255));
        jcombo_Doctor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcombo_DoctorActionPerformed(evt);
            }
        });
        JpaneForm.add(jcombo_Doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 460, 35));

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 128));
        jLabel9.setText("Buscar Enfermero Encargado");
        JpaneForm.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 260, 30));

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 128));
        jLabel11.setText("Buscar Paciente");
        JpaneForm.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 160, 39));

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 128));
        jLabel12.setText("Buscar Dr. / Dra.");
        JpaneForm.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 160, 39));

        JBusqueda_Enfermero.setBackground(new java.awt.Color(0, 51, 153));
        JBusqueda_Enfermero.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        JBusqueda_Enfermero.setForeground(new java.awt.Color(255, 255, 255));
        JBusqueda_Enfermero.setNextFocusableComponent(JBusqueda_Medicamento);
        JBusqueda_Enfermero.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JBusqueda_EnfermeroKeyReleased(evt);
            }
        });
        JpaneForm.add(JBusqueda_Enfermero, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 450, 460, 35));

        jcombo_Enfermero.setBackground(new java.awt.Color(102, 153, 255));
        jcombo_Enfermero.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jcombo_Enfermero.setForeground(new java.awt.Color(255, 255, 255));
        jcombo_Enfermero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcombo_EnfermeroActionPerformed(evt);
            }
        });
        JpaneForm.add(jcombo_Enfermero, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 490, 460, 35));

        getContentPane().add(JpaneForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(3, 6, 1360, 740));

        JlabelBackground.setOpaque(true);
        getContentPane().add(JlabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 750));

        jMenu3.setText("Archivo");

        JmenuActualizar.setText("Actualizar");
        JmenuActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JmenuActualizarMouseClicked(evt);
            }
        });
        jMenu3.add(JmenuActualizar);

        JmenuSalir.setText("Salir");
        JmenuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JmenuSalirMouseClicked(evt);
            }
        });
        jMenu3.add(JmenuSalir);

        BarraSuperior.add(jMenu3);

        JmenuReporte.setText("Reportes");

        JmenuReporteMensual.setText("Reporte Medicamentos");
        JmenuReporteMensual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JmenuReporteMensualMouseClicked(evt);
            }
        });
        JmenuReporte.add(JmenuReporteMensual);

        JmenuReporteDoctores.setText("Reporte Pacientes atendidos por Doctores");
        JmenuReporteDoctores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JmenuReporteDoctoresMouseClicked(evt);
            }
        });
        JmenuReporte.add(JmenuReporteDoctores);

        JmenuReporteOcupacional.setText("Reporte Porcentaje Ocupacional Camas");
        JmenuReporteOcupacional.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JmenuReporteOcupacionalMouseClicked(evt);
            }
        });
        JmenuReporte.add(JmenuReporteOcupacional);

        BarraSuperior.add(JmenuReporte);

        jMenu1.setText("Ver Medicamentos");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        BarraSuperior.add(jMenu1);

        jMenuVerRegistros.setText("Ver Registros");
        jMenuVerRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuVerRegistrosMouseClicked(evt);
            }
        });
        BarraSuperior.add(jMenuVerRegistros);

        setJMenuBar(BarraSuperior);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void JmenuReporteMensualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JmenuReporteMensualMouseClicked

        // Crear un panel con GridLayout para los selectores de fecha y las etiquetas
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10)); // 2 filas, 2 columnas, espaciado horizontal y vertical de 10

        // Etiqueta "Fecha inicio"
        JLabel startDateLabel = new JLabel("Fecha inicio:");
        panel.add(startDateLabel);

        // Selector de fecha para la fecha de inicio
        JDateChooser startDateChooser = new JDateChooser();
        startDateChooser.setDateFormatString("MM/yyyy");
        startDateChooser.setDate(new Date());
        startDateChooser.setPreferredSize(new Dimension(150, 30)); // Ajustar el tamaño del selector de fecha
        panel.add(startDateChooser);

        // Etiqueta "Fecha fin"
        JLabel endDateLabel = new JLabel("Fecha fin:");
        panel.add(endDateLabel);

        // Selector de fecha para la fecha de fin
        JDateChooser endDateChooser = new JDateChooser();
        endDateChooser.setDateFormatString("MM/yyyy");
        endDateChooser.setDate(new Date());
        endDateChooser.setPreferredSize(new Dimension(150, 30)); // Ajustar el tamaño del selector de fecha
        panel.add(endDateChooser);

        // Mostrar el panel con los selectores de fecha y las etiquetas
        int option = JOptionPane.showOptionDialog(null, panel, "Seleccione el intervalo de fechas",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        //inicializar variables mes y anio inicio y fin
        int mesInicio;
        int anioInicio;
        int mesFin;
        int anioFin;
        // Obtener las fechas seleccionadas si se presiona OK
        if (option == JOptionPane.OK_OPTION) {
            // Obtener el mes y el año de la fecha de inicio
            mesInicio = startDateChooser.getCalendar().get(Calendar.MONTH) + 1;
            anioInicio = startDateChooser.getCalendar().get(Calendar.YEAR);

            // Obtener el mes y el año de la fecha de fin
            mesFin = endDateChooser.getCalendar().get(Calendar.MONTH) + 1;
            anioFin = endDateChooser.getCalendar().get(Calendar.YEAR);
        }else{
            return;
        }

        //array para guardar las categorias
        ArrayList<String> categorias = new ArrayList<>();
        int contador = 0;
        try {
            try (Connection con = conexion.getConexion()) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT DISTINCT categoria FROM medicamentos ORDER BY categoria ASC");
                while (rs.next()) {
                    categorias.add(rs.getString("categoria"));
                    contador++;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error al contar las categorias");
        }

        //hacer reporte por cada categoria
        Connection con = conexion.getConexion();
        Statement st = null;
        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }

        //crear archivo excel
        XSSFWorkbook workbook = new XSSFWorkbook();

        //estilo de la cabecera
        XSSFCellStyle style = workbook.createCellStyle();
        //color menta fondo
        style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        style.setAlignment(HorizontalAlignment.CENTER);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);
        style.setBorderTop(BorderStyle.THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());

        //font de la cabecera
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeightInPoints((short) 16);
        //arial
        font.setFontName("Arial");
        font.setColor(IndexedColors.BLACK.getIndex());
        style.setFont(font);

        //estilo de las celdas
        XSSFCellStyle style2 = workbook.createCellStyle();
        style2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //alignment center
        style2.setAlignment(HorizontalAlignment.CENTER);
        style2.setBorderBottom(BorderStyle.THIN);
        style2.setBorderLeft(BorderStyle.THIN);
        style2.setBorderRight(BorderStyle.THIN);
        style2.setBorderTop(BorderStyle.THIN);
        style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style2.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style2.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style2.setTopBorderColor(IndexedColors.BLACK.getIndex());
        //font de los datos
        XSSFFont fontData = workbook.createFont();
        fontData.setFontHeightInPoints((short) 12);
        //arial
        fontData.setFontName("Arial");
        fontData.setColor(IndexedColors.BLACK.getIndex());
        style2.setFont(fontData);

        Object[] headers = {"Medicamento", "Cantidad"};

        for (int i = 0; i < contador; i++) {
            int cantColumnas = headers.length;
            String categoria = categorias.get(i);

            String sql = "SELECT medicamentos.nombre, SUM(detalle_registro.cantidad) AS cantidad " +
                    "FROM registro " +
                    "JOIN detalle_registro ON registro.id = detalle_registro.id_registro " +
                    "JOIN medicamentos ON detalle_registro.id_medicamento = medicamentos.id " +
                    "WHERE (YEAR(registro.fecha) >= '" + anioInicio + "' AND YEAR(registro.fecha) <= '" + anioFin + "') " +
                    "AND (YEAR(registro.fecha) > '" + anioInicio + "' OR (YEAR(registro.fecha) = '" + anioInicio + "' AND MONTH(registro.fecha) >= '" + mesInicio + "')) " +
                    "AND (YEAR(registro.fecha) < '" + anioFin + "' OR (YEAR(registro.fecha) = '" + anioFin + "' AND MONTH(registro.fecha) <= '" + mesFin + "')) " +
                    "AND medicamentos.categoria = '" + categoria + "' " +
                    "GROUP BY medicamentos.nombre " +
                    "ORDER BY cantidad DESC;";

            try {
                ResultSet rs = st.executeQuery(sql);
                //si no hay ningun registro en esa categoria, no se crea el reporte
                if (!rs.next()) {
                    //System.out.println("No hay registros en la categoria " + categoria);
                    // iterar nuevamente en el for
                    continue;
                }

                XSSFSheet sheet = workbook.createSheet(categoria);

                Row row = sheet.createRow(0);

                for (int j = 0; j < cantColumnas; j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue(headers[j].toString());
                    cell.setCellStyle(style);
                }

                //datos
                int index = 1;
                do {
                    row = sheet.createRow(index);
                    Cell nombre = row.createCell(0);
                    nombre.setCellValue(rs.getString("nombre"));
                    nombre.setCellStyle(style2);

                    Cell cantidad = row.createCell(1);
                    cantidad.setCellValue(rs.getInt("cantidad"));
                    cantidad.setCellStyle(style2);

                    index++;
                } while (rs.next());


                //autosize a las columnas
                for (int j = 0; j < cantColumnas; j++) {
                    sheet.autoSizeColumn(j);
                }

                //create bar chart
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                for (int j = 1; j < index; j++) {
                    dataset.setValue(sheet.getRow(j).getCell(1).getNumericCellValue(), sheet.getRow(j).getCell(0).getStringCellValue(), categoria);
                }
                JFreeChart jchart = null;
                //si el mes inicio y fin son iguales, se crea un reporte por mes
                if(mesInicio == mesFin && anioInicio == anioFin){
                    jchart = ChartFactory.createBarChart("Registro de " + categoria + " " + mesInicio + "/" + anioInicio, " Medicamentos", "Cantidad", dataset, PlotOrientation.VERTICAL, true, true, false);

                }else{
                    jchart = ChartFactory.createBarChart("Registro de " + categoria + " " + mesInicio + "/" + anioInicio + " - " + mesFin + "/" + anioFin, " Medicamentos", "Cantidad", dataset, PlotOrientation.VERTICAL, true, true, false);
                }

                // background color white
                jchart.setBackgroundPaint(Color.lightGray);

                //get a reference to the plot for further customisation...
                CategoryPlot plot = (CategoryPlot) jchart.getPlot();
                //gray style
                plot.setBackgroundPaint(Color.lightGray);
                plot.setDomainGridlinePaint(Color.white);
                plot.setRangeGridlinePaint(Color.white);

                //font of the legend
                LegendTitle legend = jchart.getLegend();
                legend.setItemFont(new Font("Arial", Font.PLAIN, 12));

                //font of the axis
                CategoryAxis domainAxis = plot.getDomainAxis();
                domainAxis.setLabelFont(new Font("Arial", Font.PLAIN, 12));
                domainAxis.setTickLabelFont(new Font("Arial", Font.PLAIN, 12));
                ValueAxis rangeAxis = plot.getRangeAxis();
                rangeAxis.setLabelFont(new Font("Arial", Font.PLAIN, 12));
                rangeAxis.setTickLabelFont(new Font("Arial", Font.PLAIN, 12));

                //set the range axis to display integers only...
                rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
                //disable bar outlines...
                BarRenderer renderer = (BarRenderer) plot.getRenderer();
                renderer.setMaximumBarWidth(0.15);
                renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
                renderer.setBaseItemLabelsVisible(true);

                int my_picture_id;
                try ( // Write the chart image to the output stream
                        ByteArrayOutputStream chart_out = new ByteArrayOutputStream()) {
                    ChartUtilities.writeChartAsPNG(chart_out, jchart, 600, 400);
                    my_picture_id = workbook.addPicture(chart_out.toByteArray(), Workbook.PICTURE_TYPE_PNG);
                }
                // Create the drawing patriarch.  This is the top level container for all shapes including cell comments.
                XSSFDrawing drawing2 = sheet.createDrawingPatriarch();
                //add a picture shape
                ClientAnchor my_anchor = new XSSFClientAnchor();
                my_anchor.setCol1(0);
                my_anchor.setRow1(index + 2);
                XSSFPicture my_picture = drawing2.createPicture(my_anchor, my_picture_id);
                // Call resize method, which resizes the image
                my_picture.resize();

                //create a pie chart
                DefaultPieDataset pieDataset = new DefaultPieDataset();
                for (int j = 1; j < index; j++) {
                    pieDataset.setValue(sheet.getRow(j).getCell(0).getStringCellValue(), sheet.getRow(j).getCell(1).getNumericCellValue());
                }
                JFreeChart pieChart = null;
                if(mesInicio == mesFin && anioInicio == anioFin){
                    pieChart = ChartFactory.createPieChart("Registro de " + categoria + " " + mesInicio + "/" + anioInicio, pieDataset, true, true, false);

                }else{
                    pieChart = ChartFactory.createPieChart("Registro de " + categoria + " " + mesInicio + "/" + anioInicio + " - " + mesFin + "/" + anioFin, pieDataset, true, true, false);
                }

                // background color gray
                pieChart.setBackgroundPaint(Color.lightGray);

                //get a reference to the plot for further customisation...
                PiePlot piePlot = (PiePlot) pieChart.getPlot();
                //gray style
                piePlot.setBackgroundPaint(Color.lightGray);
                piePlot.setOutlinePaint(Color.white);
                piePlot.setLabelFont(new Font("Arial", Font.PLAIN, 12));
                piePlot.setNoDataMessage("No data available");
                piePlot.setCircular(true);
                piePlot.setLabelGap(0.02);

                //pie renderer
                PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} = {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
                piePlot.setLabelGenerator(labelGenerator);

                int my_pieChart_id;
                try ( // Write the chart image to the output stream
                        ByteArrayOutputStream pieChart_out = new ByteArrayOutputStream()) {
                    ChartUtilities.writeChartAsPNG(pieChart_out, pieChart, 600, 400);
                    my_pieChart_id = workbook.addPicture(pieChart_out.toByteArray(), Workbook.PICTURE_TYPE_PNG);
                }
                // Create the drawing patriarch.  This is the top level container for all shapes including cell comments.
                XSSFDrawing drawing3 = sheet.createDrawingPatriarch();
                //add a picture shape
                ClientAnchor my_pieChart_anchor = new XSSFClientAnchor();
                my_pieChart_anchor.setCol1(8);
                my_pieChart_anchor.setRow1(index + 2);
                XSSFPicture my_pieChart = drawing3.createPicture(my_pieChart_anchor, my_pieChart_id);
                // Call resize method, which resizes the image
                my_pieChart.resize();

                //crear otra hoja
            } catch (SQLException | IOException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Object[] headersCat = {"Categoria", "Cantidad"};

        XSSFSheet sheetTodasCat = workbook.createSheet("Todas las categorias");

        Row row = sheetTodasCat.createRow(0);

        for (int j = 0; j < headersCat.length; j++) {
            Cell cell = row.createCell(j);
            cell.setCellValue(headersCat[j].toString());
            cell.setCellStyle(style);
        }

        try {
            String query = "SELECT medicamentos.categoria, SUM(detalle_registro.cantidad) AS cantidad " +
                    "FROM registro " +
                    "JOIN detalle_registro ON registro.id = detalle_registro.id_registro " +
                    "JOIN medicamentos ON detalle_registro.id_medicamento = medicamentos.id " +
                    "WHERE (YEAR(registro.fecha) >= '" + anioInicio + "' AND YEAR(registro.fecha) <= '" + anioFin + "') " +
                    "AND (YEAR(registro.fecha) > '" + anioInicio + "' OR (YEAR(registro.fecha) = '" + anioInicio + "' AND MONTH(registro.fecha) >= '" + mesInicio + "')) " +
                    "AND (YEAR(registro.fecha) < '" + anioFin + "' OR (YEAR(registro.fecha) = '" + anioFin + "' AND MONTH(registro.fecha) <= '" + mesFin + "')) " +
                    "GROUP BY medicamentos.categoria " +
                    "ORDER BY cantidad DESC;";
            ResultSet rs = st.executeQuery(query);

            int index = 1;
            int contador_cantidades = 0;
            while (rs.next()) {
                if (rs.getString("categoria").equals("null")) {
                    continue;
                }
                if (rs.getString("categoria").equals("")) {
                    continue;
                }
                if (rs.getString("categoria").equals(" ")) {
                    continue;
                }
                if(rs.getInt("cantidad") == 0){
                    continue;
                }

                row = sheetTodasCat.createRow(index);
                Cell categoria = row.createCell(0);
                System.out.println(rs.getString("categoria"));
                categoria.setCellValue(rs.getString("categoria"));
                categoria.setCellStyle(style2);

                Cell cantidad = row.createCell(1);
                cantidad.setCellValue(rs.getInt("cantidad"));
                System.out.println(rs.getInt("cantidad"));
                cantidad.setCellStyle(style2);
                index++;
                contador_cantidades = contador_cantidades + rs.getInt("cantidad");
            }

            //auto size columns
            for (int i = 0; i < headersCat.length; i++) {
                sheetTodasCat.autoSizeColumn(i);
            }

            //create a bar chart
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (int j = 1; j < index; j++) {
                dataset.setValue(sheetTodasCat.getRow(j).getCell(1).getNumericCellValue(), sheetTodasCat.getRow(j).getCell(0).getStringCellValue(), "");
            }
            JFreeChart jchart = null;
            if (mesInicio == mesFin && anioInicio == anioFin) {
                jchart = ChartFactory.createBarChart("Medicamentos por Categoria " + mesInicio + "/" + anioInicio, "Categorias", "Cantidad", dataset, PlotOrientation.VERTICAL, true, true, false);
            }else{
                jchart = ChartFactory.createBarChart("Medicamentos por Categoria " + mesInicio + "/" + anioInicio + " - " + mesFin + "/" + anioFin, "Categorias", "Cantidad", dataset, PlotOrientation.VERTICAL, true, true, false);
            }

            // background color white
            jchart.setBackgroundPaint(Color.lightGray);

            //get a reference to the plot for further customisation...
            CategoryPlot plot = (CategoryPlot) jchart.getPlot();
            //gray style
            plot.setBackgroundPaint(Color.lightGray);
            plot.setDomainGridlinePaint(Color.white);
            plot.setRangeGridlinePaint(Color.white);

            //font of the legend
            LegendTitle legend = jchart.getLegend();
            legend.setItemFont(new Font("Arial", Font.PLAIN, 12));

            //font of the axis
            CategoryAxis domainAxis = plot.getDomainAxis();
            domainAxis.setLabelFont(new Font("Arial", Font.PLAIN, 12));
            domainAxis.setTickLabelFont(new Font("Arial", Font.PLAIN, 12));
            ValueAxis rangeAxis = plot.getRangeAxis();
            rangeAxis.setLabelFont(new Font("Arial", Font.PLAIN, 12));
            rangeAxis.setTickLabelFont(new Font("Arial", Font.PLAIN, 12));

            //set the range axis to display integers only...
            rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
            //disable bar outlines...
            BarRenderer renderer = (BarRenderer) plot.getRenderer();
            renderer.setMaximumBarWidth(0.15);
            renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            renderer.setBaseItemLabelsVisible(true);

            int my_picture_id;
            try ( // Write the chart image to the output stream
                    ByteArrayOutputStream chart_out = new ByteArrayOutputStream()) {
                ChartUtilities.writeChartAsPNG(chart_out, jchart, 600, 400);
                my_picture_id = workbook.addPicture(chart_out.toByteArray(), Workbook.PICTURE_TYPE_PNG);
            }
            // Create the drawing patriarch.  This is the top level container for all shapes including cell comments.
            XSSFDrawing drawing2 = sheetTodasCat.createDrawingPatriarch();
            //add a picture shape
            ClientAnchor my_anchor = new XSSFClientAnchor();
            my_anchor.setCol1(0);
            my_anchor.setRow1(index + 2);
            XSSFPicture my_picture = drawing2.createPicture(my_anchor, my_picture_id);
            // Call resize method, which resizes the image
            my_picture.resize();

            //create a pie chart
            DefaultPieDataset pieDataset = new DefaultPieDataset();
            for (int j = 1; j < index; j++) {
                pieDataset.setValue(sheetTodasCat.getRow(j).getCell(0).getStringCellValue(), sheetTodasCat.getRow(j).getCell(1).getNumericCellValue());
            }

            JFreeChart pieChart = null;
            if (mesInicio == mesFin && anioInicio == anioFin) {
                pieChart = ChartFactory.createPieChart("Medicamentos por Categoria " + mesInicio + "/" + anioInicio, pieDataset, true, true, false);
            }else{
                pieChart = ChartFactory.createPieChart("Medicamentos por Categoria " + mesInicio + "/" + anioInicio + " - " + mesFin + "/" + anioFin, pieDataset, true, true, false);
            }
            // background color gray
            pieChart.setBackgroundPaint(Color.lightGray);

            //get a reference to the plot for further customisation...
            PiePlot piePlot = (PiePlot) pieChart.getPlot();
            //gray style
            piePlot.setBackgroundPaint(Color.lightGray);
            piePlot.setOutlinePaint(Color.white);
            piePlot.setLabelFont(new Font("Arial", Font.PLAIN, 12));
            piePlot.setNoDataMessage("No data available");
            piePlot.setCircular(true);
            piePlot.setLabelGap(0.02);

            //pie renderer
            PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} = {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
            piePlot.setLabelGenerator(labelGenerator);

            int my_pieChart_id;
            try ( // Write the chart image to the output stream
                    ByteArrayOutputStream pieChart_out = new ByteArrayOutputStream()) {
                ChartUtilities.writeChartAsPNG(pieChart_out, pieChart, 600, 400);
                my_pieChart_id = workbook.addPicture(pieChart_out.toByteArray(), Workbook.PICTURE_TYPE_PNG);
            }
            // Create the drawing patriarch.  This is the top level container for all shapes including cell comments.
            XSSFDrawing drawing3 = sheetTodasCat.createDrawingPatriarch();
            //add a picture shape
            ClientAnchor my_pieChart_anchor = new XSSFClientAnchor();
            my_pieChart_anchor.setCol1(8);
            my_pieChart_anchor.setRow1(index + 2);
            XSSFPicture my_pieChart = drawing3.createPicture(my_pieChart_anchor, my_pieChart_id);
            // Call resize method, which resizes the image
            my_pieChart.resize();
            con.close();
        } catch (IOException | SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            //guardar archivo solictar ruta
            //get document folder
            String userDocuments = System.getProperty("user.home") + "/Documents";

            //fix slashes
            userDocuments = userDocuments.replace("\\", "/");

            String ruta = userDocuments + "/MediClass/Reportes";
            // Definir el arreglo de nombres de los meses
            String[] nombresMeses = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};

            // Supongamos que mesInicio y mesFin son variables enteras que representan los meses (1 para enero, 2 para febrero, etc.)

            // Convertir mesInicio a su nombre correspondiente
            String nombreMesInicio = nombresMeses[mesInicio - 1];

            // Convertir mesFin a su nombre correspondiente
            String nombreMesFin = nombresMeses[mesFin - 1];

            // Concatenar los nombres de los meses en la ruta
            if (mesInicio == mesFin && anioInicio == anioFin) {
                ruta = ruta + "/ReporteMensualDel_" + nombreMesInicio + "_" + anioInicio;
            } else {
                ruta = ruta + "/ReporteMensualDel_" + nombreMesInicio + "_" + anioInicio + "_a_" + nombreMesFin + "_" + anioFin;
            }

            try (FileOutputStream fileOut = new FileOutputStream(ruta + ".xlsx")) {
                workbook.write(fileOut);
            }

            try {
                Desktop.getDesktop().open(new File(ruta + ".xlsx"));
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        } catch (HeadlessException | IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_JmenuReporteMensualMouseClicked

    private void JmenuActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JmenuActualizarMouseClicked

        cargarMedicamentos();
        cargarDoctores();
        cargarPacientes();
        cargarEnfermeros();
        JBusqueda_Medicamento.setText("");
        JOptionPane.showMessageDialog(null, "Medicamentos actualizados");
    }//GEN-LAST:event_JmenuActualizarMouseClicked

    private void JmenuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JmenuSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_JmenuSalirMouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked

        //nueva ventana para mostrar la base de datos de medicamentos
        BaseDatosMedicamentos ventana_base = new BaseDatosMedicamentos(); 

        ventana_base.setVisible(true);

        //cuando se cierre la ventana de base de datos de medicamento cargar medicamentos()
        ventana_base.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                cargarMedicamentos();
                cargarDoctores();
                cargarPacientes();
                cargarEnfermeros();
            }
        });
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jButtonAgregarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarMedicamentoActionPerformed

        String nombreMedicamento = jcombo_Medicamento.getSelectedItem().toString();
        String cantidad = jcantidadRegistro.getText();
        

        if (nombreMedicamento.equals("") || cantidad.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un medicamento y una cantidad");
            return;
        }
        if (nombreMedicamento.equals("!No existe, Crealo!")) {
            JOptionPane.showMessageDialog(null, "Debe crear el medicamento antes de agregarlo a la lista");
            return;
        }
        double cantidadDouble = 0;
        //validar que cantidad sea un numero
        try {
            //si cantidad tiene / hacer split y dividir 2 decimales
            if (cantidad.contains("/")) {
                String[] cantidadSplit = cantidad.split("/");
                int numerador = Integer.parseInt(cantidadSplit[0]);
                int denominador = Integer.parseInt(cantidadSplit[1]);
                cantidadDouble = (double) numerador / denominador;
                cantidad = String.format("%.2f", cantidadDouble);
            }else {
                //validar que cantidad sea un numero 2 decimales
                cantidadDouble = Double.parseDouble(cantidad);
                cantidad = String.format("%.2f", cantidadDouble);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser un numero");
            return;
        }
        String categoria;
        categoria = jCategoria.getText();

        //agregar al la tabla JTable_CarritoMedicamentos el medicamento
        try{
            
            // si el id_medicamento ya existe en el tempCarrito, sumar la cantidad
            for (ItemCarrito item : tempCarrito) {
                if (item.getId_medicamento() == id_medicamento) {
                    item.setCantidad(item.getCantidad() + cantidadDouble);
                    DefaultTableModel modelo = (DefaultTableModel) JTable_CarritoMedicamentos.getModel();
                    for (int i = 0; i < modelo.getRowCount(); i++) {
                        if (modelo.getValueAt(i, 1).equals(nombre_medicamento)) {
                            modelo.setValueAt(item.getCantidad(), i, 0);
                        }
                    }
                    JBusqueda_Medicamento.setText("");
                    jcantidadRegistro.setText("");
                    JBusqueda_Medicamento.requestFocus();
                    return;
                }
            }
            
            // agregar al tempCarrito arraylist cantidad id_medicamento
            tempCarrito.add(new ItemCarrito(cantidadDouble, id_medicamento));
            DefaultTableModel modelo = (DefaultTableModel) JTable_CarritoMedicamentos.getModel();
            Object[] nuevaFila = {cantidadDouble, nombre_medicamento, generico_medicamento, categoria_medicamento};
            modelo.addRow(nuevaFila);

        }catch (NumberFormatException e){
            System.out.println("Error al insertar en tabla "+e);
        }

        JBusqueda_Medicamento.setText("");
        jcantidadRegistro.setText("");
        JBusqueda_Medicamento.requestFocus();

        //cargar datos
        cargarMedicamentos();
    }//GEN-LAST:event_jButtonAgregarMedicamentoActionPerformed

    private void JBusqueda_MedicamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JBusqueda_MedicamentoKeyReleased
        buscarMedicamento();
    }//GEN-LAST:event_JBusqueda_MedicamentoKeyReleased

    private void jcombo_MedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcombo_MedicamentoActionPerformed

        String nombreMedicamento = "";
        try {
            nombreMedicamento = jcombo_Medicamento.getSelectedItem().toString();
        } catch (Exception e) {
        }

        switch (nombreMedicamento) {
            case "Seleccione un medicamento" ->
                jNombreMedicamento.setText("");
            case "Click para crearlo" -> {
                //crear ventana formulario
                FormRegistro formRegistro = new FormRegistro();
                formRegistro.JtextFieldNombre.setText(JBusqueda_Medicamento.getText());
                //obtener todas las categorias distintas de la base de datos mysql
                try {
                    Connection con = conexion.getConexion();
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT DISTINCT categoria FROM medicamentos ORDER BY categoria ASC;");
                    while (rs.next()) {
                        formRegistro.jComboBoxCategoria.addItem(rs.getString("categoria"));
                    }
                    formRegistro.jComboBoxCategoria.addItem("Click para crear una nueva Categoria");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
                formRegistro.setVisible(true);
                //cuando cierre ventana formulario cargarMedicamentos()
                formRegistro.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        cargarMedicamentos();
                        buscarMedicamento();
                    }
                });
            }

            default -> {
                jNombreMedicamento.setText(nombreMedicamento);
                if (nombreMedicamento.contains(" (")) {
                    nombre_medicamento = nombreMedicamento.substring(0, nombreMedicamento.indexOf(" ("));
                }else{
                    nombre_medicamento = nombreMedicamento;
                }
                //obeter categoria del medicamento desde la base de datos
                String categoriaMedicamento = "SELECT id,nombre,categoria,generico FROM medicamentos WHERE nombre = '" + nombre_medicamento + "' ORDER BY categoria ASC;";
                String categoria = "";
                try {
                    try (Connection con = conexion.getConexion()) {
                        Statement st = con.createStatement();
                        ResultSet rs = st.executeQuery(categoriaMedicamento);
                        while (rs.next()) {
                            categoria = rs.getString("categoria");
                            id_medicamento = rs.getInt("id");
                            nombre_medicamento = rs.getString("nombre");
                            categoria_medicamento = rs.getString("categoria");
                            generico_medicamento = rs.getString("generico");
                            
                        }
                        
                        jCategoria.setText(categoria);
                    }
                } catch (SQLException ex) {
                    System.out.println("Error al obtener la categoria del medicamento");

                }
            }
        }
    }//GEN-LAST:event_jcombo_MedicamentoActionPerformed

    private void jcantidadRegistroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jcantidadRegistroKeyReleased

        //cuando se precione enter jbuttonRegistrar.doClick();
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jButtonAgregarMedicamento.doClick();
        }

    }//GEN-LAST:event_jcantidadRegistroKeyReleased

    private void JBusqueda_PacienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JBusqueda_PacienteKeyReleased
        // TODO add your handling code here:
        buscarPaciente();
    }//GEN-LAST:event_JBusqueda_PacienteKeyReleased

    private void jcombo_PacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcombo_PacienteActionPerformed
        // TODO add your handling code here:
        String nombrePaciente = "";
        try{
            nombrePaciente = jcombo_Paciente.getSelectedItem().toString();
        }catch (Exception e) {
        }
        
        try {
            if (nombrePaciente.equals("Click para crearlo")) {
                //crear ventana formulario
                FormRegistroPaciente formPaciente = new FormRegistroPaciente();
                formPaciente.JtextFieldNombre.setText(JBusqueda_Paciente.getText());
                formPaciente.setVisible(true);

                //cuando cierre ventana formulario cargarMedicamentos()
                formPaciente.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        cargarPacientes();
                    }
                });
            }else {
                nombre_paciente =nombrePaciente;
                try{
                     // hacer un call al procedimiento almacenado en la base de datos con el nombre del paciente
                    Connection con = conexion.getConexion();
                    CallableStatement cstmt = (CallableStatement) con.prepareCall("{call obtenerIdPaciente(?)}");
                    cstmt.setString(1, nombrePaciente);
                    ResultSet rs = cstmt.executeQuery();
                    while (rs.next()) {
                        id_paciente = rs.getInt("id_paciente");
                    }
                } catch (SQLException ex) {
                    System.out.println("Error al obtener el id del paciente" + ex);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al obtener el nombre del paciente" + e);
        }
    }//GEN-LAST:event_jcombo_PacienteActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        // TODO add your handling code here:
        //obtener fecha del jcalendar y enviar a sql
        Date fecha = jCalendar1.getDate();
        long d = fecha.getTime();
        java.sql.Date fechaSql = new java.sql.Date(d);

        //obtener doctor
        String doctor = jcombo_Doctor.getSelectedItem().toString();
        if (doctor.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un doctor");
            return;
        }
        //obtener paciente
        String paciente = jcombo_Paciente.getSelectedItem().toString();
        if (paciente.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un paciente");
            return;
        }

        //obtener medicamentos
        int filas = JTable_CarritoMedicamentos.getRowCount();
        if (filas == 0) {
            JOptionPane.showMessageDialog(null, "Debe agregar al menos un medicamento");
            return;
        }
        
        actualizarInfo();
        //obtener datos de cantidad y nombre de medicamentos
        DefaultTableModel modelo = (DefaultTableModel) JTable_CarritoMedicamentos.getModel();

        //guardar registro , donde foreing key id_doctor y id_paciente
        // try prepare statement para insertar en la base de datos y return generated keys
        int id_registro = 0;
        try {
            try (Connection con = conexion.getConexion()) {
                String cmd = "INSERT INTO registro (fecha, id_doctor, id_paciente, id_enfermero) VALUES (?, ?, ?, ?);";
                PreparedStatement pst = con.prepareStatement(cmd, Statement.RETURN_GENERATED_KEYS);
                pst.setDate(1, fechaSql);
                pst.setInt(2, id_doctor);
                pst.setInt(3, id_paciente);
                pst.setInt(4, id_enfermero);
                pst.executeUpdate();
                ResultSet rs = pst.getGeneratedKeys();
                while (rs.next()) {
                    id_registro = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al registrar los medicamentos " + e);
            return;
        }
        if (id_registro == 0) {
            JOptionPane.showMessageDialog(null, "Error al registrar");
            return;
        }

        // recorrer tempCarrito y guardar en la base de datos en detalle_registro con el id_registro
        for (ItemCarrito item : tempCarrito) {
            try {
                try (Connection con = conexion.getConexion()) {
                    String cmd = "INSERT INTO detalle_registro (id_registro, id_medicamento, cantidad) VALUES (?, ?, ?);";
                    PreparedStatement pst = con.prepareStatement(cmd);
                    pst.setInt(1, id_registro);
                    pst.setInt(2, item.getId_medicamento());
                    pst.setDouble(3, item.getCantidad());
                    pst.executeUpdate();
                }
            } catch (SQLException e) {
                System.out.println("Error al registrar el medicamento " + e);
            }
        }

        // Preguntar si desea imprimir el registro en pdf
        int option = JOptionPane.showConfirmDialog(null, "¿Desea imprimir el registro?", "Imprimir registro", JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.YES_OPTION){
            Registro registro = new Registro(id_registro);
            try {
                registro.imprimir();
            } catch (FileNotFoundException | MalformedURLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //mostrar joption pane solo por 0.5 segundos registro exitoso
        JOptionPane pane = new JOptionPane("Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = pane.createDialog("Registro exitoso");
        dialog.setModal(false);
        dialog.setVisible(true);
        new Timer(500, (ActionEvent e) -> {
            dialog.setVisible(false);
        }).start();

        //limpiar campos
        jNombreMedicamento.setText("");
        JBusqueda_doctor.setText("");
        JBusqueda_Paciente.setText("");
        jcantidadRegistro.setText("");


        //limpiar tabla
        modelo.setRowCount(0);
        JTable_CarritoMedicamentos.setModel(modelo);
        JBusqueda_doctor.requestFocus();

        // actualizar informacion
        actualizarInfo();
        actualizarMedicamento();

        // vaciar tempCarrito
        tempCarrito.clear();

    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void JBusqueda_doctorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JBusqueda_doctorKeyReleased
        // TODO add your handling code here:
        buscarDoctor();
    }//GEN-LAST:event_JBusqueda_doctorKeyReleased

    private void jcombo_DoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcombo_DoctorActionPerformed
        // TODO add your handling code here:
        String nombreDoctor = "";
        try{
            nombreDoctor = jcombo_Doctor.getSelectedItem().toString();

        } catch (Exception e) {
        }
        try {
            if (nombreDoctor.equals("Click para crearlo")) {
                //crear ventana formulario
                FormRegistroDoctor formDoctor = new FormRegistroDoctor();
                formDoctor.JtextFieldNombre.setText(JBusqueda_doctor.getText());
                formDoctor.setVisible(true);
                //cuando cierre ventana formulario cargarMedicamentos()
                formDoctor.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        cargarDoctores();
                    }
                });
            }else {
                nombre_doctor = nombreDoctor;
                try{
                    // hacer un call al procedimiento almacenado en la base de datos con el nombre del doctor
                    Connection con = conexion.getConexion();
                    CallableStatement cstmt = (CallableStatement) con.prepareCall("{call obtenerIdDoctor(?)}");
                    cstmt.setString(1, nombreDoctor);
                    ResultSet rs = cstmt.executeQuery();
                    while (rs.next()) {
                        id_doctor = rs.getInt("id_doctor");
                    }
                } catch (SQLException ex) {
                    System.out.println("Error al obtener el id del doctor" + ex);
                }
            }

        } catch (Exception e) {
            
            System.out.println("Error al obtener el nombre del doctor" + e);
        }
    }//GEN-LAST:event_jcombo_DoctorActionPerformed

    private void jCalendar1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar1PropertyChange
        // TODO add your handling code here:

        try {
            String fecha= "FECHA : " + (new SimpleDateFormat("dd/MM/yyyy").format(jCalendar1.getDate()));
            jLabelFecha.setText(fecha);
        } catch (Exception e) {
            System.out.println("Error al obtener la fecha");
        }
    }//GEN-LAST:event_jCalendar1PropertyChange

    private void JmenuReporteDoctoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JmenuReporteDoctoresMouseClicked
        // Crear un panel con GridLayout para los selectores de fecha y las etiquetas
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10)); // 2 filas, 2 columnas, espaciado horizontal y vertical de 10

        // Etiqueta "Fecha inicio"
        JLabel startDateLabel = new JLabel("Fecha inicio:");
        panel.add(startDateLabel);

        // Selector de fecha para la fecha de inicio
        JDateChooser startDateChooser = new JDateChooser();
        startDateChooser.setDateFormatString("MM/yyyy");
        startDateChooser.setDate(new Date());
        startDateChooser.setPreferredSize(new Dimension(150, 30)); // Ajustar el tamaño del selector de fecha
        panel.add(startDateChooser);

        // Etiqueta "Fecha fin"
        JLabel endDateLabel = new JLabel("Fecha fin:");
        panel.add(endDateLabel);

        // Selector de fecha para la fecha de fin
        JDateChooser endDateChooser = new JDateChooser();
        endDateChooser.setDateFormatString("MM/yyyy");
        endDateChooser.setDate(new Date());
        endDateChooser.setPreferredSize(new Dimension(150, 30)); // Ajustar el tamaño del selector de fecha
        panel.add(endDateChooser);

        // Mostrar el panel con los selectores de fecha y las etiquetas
        int option = JOptionPane.showOptionDialog(null, panel, "Seleccione el intervalo de fechas",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        //inicializar variables mes y anio inicio y fin
        int mesInicio;
        int anioInicio;
        int mesFin;
        int anioFin;
        // Obtener las fechas seleccionadas si se presiona OK
        if (option == JOptionPane.OK_OPTION) {
            // Obtener el mes y el año de la fecha de inicio
            mesInicio = startDateChooser.getCalendar().get(Calendar.MONTH) + 1;
            anioInicio = startDateChooser.getCalendar().get(Calendar.YEAR);

            // Obtener el mes y el año de la fecha de fin
            mesFin = endDateChooser.getCalendar().get(Calendar.MONTH) + 1;
            anioFin = endDateChooser.getCalendar().get(Calendar.YEAR);
        }else{
            return;
        }
        
        try{
            //crear conexion
            String sqlComand =  "SELECT d.nombre AS NombreDoctor, " +
                    "COUNT(DISTINCT r.id_paciente) AS PacientesAtendidos " +
                    "FROM doctores d " +
                    "LEFT JOIN registro r ON d.id_doctor = r.id_doctor " +
                    "WHERE (YEAR(fecha) >= '" + anioInicio + "' AND YEAR(fecha) <= '" + anioFin + "') " +
                    "AND (YEAR(fecha) > '" + anioInicio + "' OR (YEAR(fecha) = '" + anioInicio + "' AND MONTH(fecha) >= '" + mesInicio + "')) " +
                    "AND (YEAR(fecha) < '" + anioFin + "' OR (YEAR(fecha) = '" + anioFin + "' AND MONTH(fecha) <= '" + mesFin + "')) " +
                    "GROUP BY d.id_doctor, d.nombre;";
            
            ArrayList<String> nombreDoctores;
            ArrayList<Integer> pacientesAtendidos;
            try (Connection con = conexion.getConexion()) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sqlComand);
                //extraer data de la base de datos nombre - cantidad de pacientes
                nombreDoctores = new ArrayList<>();
                pacientesAtendidos = new ArrayList<>();
                while (rs.next()) {
                    nombreDoctores.add(rs.getString("NombreDoctor"));
                    pacientesAtendidos.add(rs.getInt("PacientesAtendidos"));
                }
            }
            
            //crear workbook
            XSSFWorkbook workbook = new XSSFWorkbook();

            //estilo de la cabecera
            XSSFCellStyle style = workbook.createCellStyle();
            //color menta fondo
            style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            style.setAlignment(HorizontalAlignment.CENTER);
            style.setBorderBottom(BorderStyle.THIN);
            style.setBorderLeft(BorderStyle.THIN);
            style.setBorderRight(BorderStyle.THIN);
            style.setBorderTop(BorderStyle.THIN);
            style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            style.setRightBorderColor(IndexedColors.BLACK.getIndex());
            style.setTopBorderColor(IndexedColors.BLACK.getIndex());

            //font de la cabecera
            XSSFFont font = workbook.createFont();
            font.setBold(true);
            font.setFontHeightInPoints((short) 16);
            //arial
            font.setFontName("Arial");
            font.setColor(IndexedColors.BLACK.getIndex());
            style.setFont(font);

            //estilo de las celdas
            XSSFCellStyle style2 = workbook.createCellStyle();
            style2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //alignment center
            style2.setAlignment(HorizontalAlignment.CENTER);
            style2.setBorderBottom(BorderStyle.THIN);
            style2.setBorderLeft(BorderStyle.THIN);
            style2.setBorderRight(BorderStyle.THIN);
            style2.setBorderTop(BorderStyle.THIN);
            style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            style2.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            style2.setRightBorderColor(IndexedColors.BLACK.getIndex());
            style2.setTopBorderColor(IndexedColors.BLACK.getIndex());
            //font de los datos
            XSSFFont fontData = workbook.createFont();
            fontData.setFontHeightInPoints((short) 12);
            //arial
            fontData.setFontName("Arial");
            fontData.setColor(IndexedColors.BLACK.getIndex());
            style2.setFont(fontData);

            Object[] headers = {"Nombre Dr. o Dra.", "Pacientes Atendidos"};
            XSSFSheet sheet = workbook.createSheet("Reporte Pacientes Referidos");

            //agregar headers
            Row rowhead = sheet.createRow((short) 0);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = rowhead.createCell(i);
                cell.setCellValue(headers[i].toString());
                cell.setCellStyle(style);
            }

            //agregar datos
            int index = 1;
            for (int i = 0; i < nombreDoctores.size(); i++) {
                Row row = sheet.createRow((short) index);

                Cell cell = row.createCell(0);
                cell.setCellValue(nombreDoctores.get(i));
                cell.setCellStyle(style2);

                cell = row.createCell(1);
                cell.setCellValue(pacientesAtendidos.get(i));
                cell.setCellStyle(style2);
                index++;
            }

            //autosize a las columnas
            for (int j = 0; j < headers.length; j++) {
                sheet.autoSizeColumn(j);
            }

            //create bar chart
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for (int j = 1; j < index; j++) {
                dataset.setValue(sheet.getRow(j).getCell(1).getNumericCellValue(), sheet.getRow(j).getCell(0).getStringCellValue(), "");
            }
            JFreeChart jchart = null;
            //si el mes inicio y fin son iguales, se crea un reporte por mes
            if(mesInicio == mesFin && anioInicio == anioFin){
                jchart = ChartFactory.createBarChart("Pacientes referidos " + mesInicio + "/" + anioInicio, " Dr. o Dra.", "Pacientes Atendidos", dataset, PlotOrientation.VERTICAL, true, true, false);
            }else{
                jchart = ChartFactory.createBarChart("Pacientes referidos " + mesInicio + "/" + anioInicio + " - " + mesFin + "/" + anioFin, " Dr. o Dra.", "Pacientes Atendidos", dataset, PlotOrientation.VERTICAL, true, true, false);
            }

            // background color white
            jchart.setBackgroundPaint(Color.lightGray);

            //get a reference to the plot for further customisation...
            CategoryPlot plot = (CategoryPlot) jchart.getPlot();
            //gray style
            plot.setBackgroundPaint(Color.lightGray);
            plot.setDomainGridlinePaint(Color.white);
            plot.setRangeGridlinePaint(Color.white);

            //font of the legend
            LegendTitle legend = jchart.getLegend();
            legend.setItemFont(new Font("Arial", Font.PLAIN, 12));

            //font of the axis
            CategoryAxis domainAxis = plot.getDomainAxis();
            domainAxis.setLabelFont(new Font("Arial", Font.PLAIN, 12));
            domainAxis.setTickLabelFont(new Font("Arial", Font.PLAIN, 12));
            ValueAxis rangeAxis = plot.getRangeAxis();
            rangeAxis.setLabelFont(new Font("Arial", Font.PLAIN, 12));
            rangeAxis.setTickLabelFont(new Font("Arial", Font.PLAIN, 12));

            //set the range axis to display integers only...
            rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
            //disable bar outlines...
            BarRenderer renderer = (BarRenderer) plot.getRenderer();
            renderer.setMaximumBarWidth(0.15);
            renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
            renderer.setBaseItemLabelsVisible(true);

            int my_picture_id;
            try ( // Write the chart image to the output stream
                    ByteArrayOutputStream chart_out = new ByteArrayOutputStream()) {
                ChartUtilities.writeChartAsPNG(chart_out, jchart, 600, 400);
                my_picture_id = workbook.addPicture(chart_out.toByteArray(), Workbook.PICTURE_TYPE_PNG);
            }
            // Create the drawing patriarch.  This is the top level container for all shapes including cell comments.
            XSSFDrawing drawing2 = sheet.createDrawingPatriarch();
            //add a picture shape
            ClientAnchor my_anchor = new XSSFClientAnchor();
            my_anchor.setCol1(0);
            my_anchor.setRow1(index + 2);
            XSSFPicture my_picture = drawing2.createPicture(my_anchor, my_picture_id);
            // Call resize method, which resizes the image
            my_picture.resize();

            //create a pie chart
            DefaultPieDataset pieDataset = new DefaultPieDataset();
            for (int j = 1; j < index; j++) {
                pieDataset.setValue(sheet.getRow(j).getCell(0).getStringCellValue(), sheet.getRow(j).getCell(1).getNumericCellValue());
            }
            JFreeChart pieChart = null;
            if(mesInicio == mesFin && anioInicio == anioFin){
                pieChart = ChartFactory.createPieChart("Pacientes referidos " + mesInicio + "/" + anioInicio, pieDataset, true, true, false);

            }else{
                pieChart = ChartFactory.createPieChart("Pacientes referidos " + mesInicio + "/" + anioInicio + " - " + mesFin + "/" + anioFin, pieDataset, true, true, false);
            }

            // background color gray
            pieChart.setBackgroundPaint(Color.lightGray);

            //get a reference to the plot for further customisation...
            PiePlot piePlot = (PiePlot) pieChart.getPlot();
            //gray style
            piePlot.setBackgroundPaint(Color.lightGray);
            piePlot.setOutlinePaint(Color.white);
            piePlot.setLabelFont(new Font("Arial", Font.PLAIN, 12));
            piePlot.setNoDataMessage("No data available");
            piePlot.setCircular(true);
            piePlot.setLabelGap(0.02);

            //pie renderer
            PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} = {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
            piePlot.setLabelGenerator(labelGenerator);

            int my_pieChart_id;
            try ( // Write the chart image to the output stream
                    ByteArrayOutputStream pieChart_out = new ByteArrayOutputStream()) {
                ChartUtilities.writeChartAsPNG(pieChart_out, pieChart, 600, 400);
                my_pieChart_id = workbook.addPicture(pieChart_out.toByteArray(), Workbook.PICTURE_TYPE_PNG);
            }
            // Create the drawing patriarch.  This is the top level container for all shapes including cell comments.
            XSSFDrawing drawing3 = sheet.createDrawingPatriarch();
            //add a picture shape
            ClientAnchor my_pieChart_anchor = new XSSFClientAnchor();
            my_pieChart_anchor.setCol1(8);
            my_pieChart_anchor.setRow1(index + 2);
            XSSFPicture my_pieChart = drawing3.createPicture(my_pieChart_anchor, my_pieChart_id);
            // Call resize method, which resizes the image
            my_pieChart.resize();

            try {
                //guardar archivo solictar ruta
                //get document folder
                String userDocuments = System.getProperty("user.home") + "/Documents";

                //fix slashes
                userDocuments = userDocuments.replace("\\", "/");

                String ruta = userDocuments + "/MediClass/Reportes";
                // Definir el arreglo de nombres de los meses
                String[] nombresMeses = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};

                // Supongamos que mesInicio y mesFin son variables enteras que representan los meses (1 para enero, 2 para febrero, etc.)

                // Convertir mesInicio a su nombre correspondiente
                String nombreMesInicio = nombresMeses[mesInicio - 1];

                // Convertir mesFin a su nombre correspondiente
                String nombreMesFin = nombresMeses[mesFin - 1];

                // Concatenar los nombres de los meses en la ruta
                if (mesInicio == mesFin && anioInicio == anioFin) {
                    ruta = ruta + "/Rerporte_Pacientes_Referidos_" + nombreMesInicio + "_" + anioInicio;
                } else {
                    ruta = ruta + "/Rerporte_Pacientes_Referidos_" + nombreMesInicio + "_" + anioInicio + "_a_" + nombreMesFin + "_" + anioFin;
                }

                try (FileOutputStream fileOut = new FileOutputStream(ruta + ".xlsx")) {
                    workbook.write(fileOut);
                }

                //cerrar workbook
                workbook.close();
                
                try {
                    Desktop.getDesktop().open(new File(ruta + ".xlsx"));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            } catch (HeadlessException | IOException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JmenuReporteDoctoresMouseClicked

    private void JmenuReporteOcupacionalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JmenuReporteOcupacionalMouseClicked

        // Crear un panel con GridLayout para los selectores de fecha y las etiquetas
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10)); // 2 filas, 2 columnas, espaciado horizontal y vertical de 10

        // Etiqueta "Fecha inicio"
        JLabel startDateLabel = new JLabel("Fecha inicio:");
        panel.add(startDateLabel);

        // Selector de fecha para la fecha de inicio
        JDateChooser startDateChooser = new JDateChooser();
        startDateChooser.setDateFormatString("MM/yyyy");
        startDateChooser.setDate(new Date());
        startDateChooser.setPreferredSize(new Dimension(150, 30)); // Ajustar el tamaño del selector de fecha
        panel.add(startDateChooser);

        // Etiqueta "Fecha fin"
        JLabel endDateLabel = new JLabel("Fecha fin:");
        panel.add(endDateLabel);

        // Selector de fecha para la fecha de fin
        JDateChooser endDateChooser = new JDateChooser();
        endDateChooser.setDateFormatString("MM/yyyy");
        endDateChooser.setDate(new Date());
        endDateChooser.setPreferredSize(new Dimension(150, 30)); // Ajustar el tamaño del selector de fecha
        panel.add(endDateChooser);

        // Mostrar el panel con los selectores de fecha y las etiquetas
        int option = JOptionPane.showOptionDialog(null, panel, "Seleccione el intervalo de fechas",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        //inicializar variables mes y anio inicio y fin
        int mesInicio;
        int anioInicio;
        int mesFin;
        int anioFin;
        // Obtener las fechas seleccionadas si se presiona OK
        if (option == JOptionPane.OK_OPTION) {
            // Obtener el mes y el año de la fecha de inicio
            mesInicio = startDateChooser.getCalendar().get(Calendar.MONTH) + 1;
            anioInicio = startDateChooser.getCalendar().get(Calendar.YEAR);

            // Obtener el mes y el año de la fecha de fin
            mesFin = endDateChooser.getCalendar().get(Calendar.MONTH) + 1;
            anioFin = endDateChooser.getCalendar().get(Calendar.YEAR);
        }else{
            return;
        }

        try {
            String sqlComand = """
                SELECT DAYOFMONTH(fecha) AS Dia,
                    (COUNT(DISTINCT id_paciente) / 17.0) * 100 AS PorcentajeOcupacion
                    FROM registro
                    WHERE (YEAR(fecha) >= '%s' AND YEAR(fecha) <= '%s')
                    AND (YEAR(fecha) > '%s' OR (YEAR(fecha) = '%s' AND MONTH(fecha) >= '%s'))
                    AND (YEAR(fecha) < '%s' OR (YEAR(fecha) = '%s' AND MONTH(fecha) <= '%s'))
                    GROUP BY Dia
                    ORDER BY Dia;
                """.formatted(anioInicio, anioFin, anioInicio, anioInicio, mesInicio, anioFin, anioFin, mesFin);

            ArrayList<String> dias;
            ArrayList<Double> ocupaciones;
            try (Connection con = conexion.getConexion()) {
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sqlComand);
                //extraer data de la base de dia - porcentaje de ocupacion
                dias = new ArrayList<>();
                ocupaciones = new ArrayList<>();
                while (rs.next()) {
                    dias.add(rs.getString("Dia"));
                    //redondear a 2 decimales
                    Double porcentajeOcupacion = rs.getDouble("PorcentajeOcupacion");
                    porcentajeOcupacion = Math.round(porcentajeOcupacion * 100.0) / 100.0;
                    if (porcentajeOcupacion > 100) {
                        porcentajeOcupacion = 100.0;
                    }
                    ocupaciones.add(porcentajeOcupacion);
                }
            }
            //crear workbook
            XSSFWorkbook workbook = new XSSFWorkbook();

            //estilo de la cabecera
            XSSFCellStyle style = workbook.createCellStyle();
            //color menta fondo
            style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            style.setAlignment(HorizontalAlignment.CENTER);
            style.setBorderBottom(BorderStyle.THIN);
            style.setBorderLeft(BorderStyle.THIN);
            style.setBorderRight(BorderStyle.THIN);
            style.setBorderTop(BorderStyle.THIN);
            style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            style.setRightBorderColor(IndexedColors.BLACK.getIndex());
            style.setTopBorderColor(IndexedColors.BLACK.getIndex());

            //font de la cabecera
            XSSFFont font = workbook.createFont();
            font.setBold(true);
            font.setFontHeightInPoints((short) 16);
            //arial
            font.setFontName("Arial");
            font.setColor(IndexedColors.BLACK.getIndex());
            style.setFont(font);

            //estilo de las celdas
            XSSFCellStyle style2 = workbook.createCellStyle();
            style2.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            style2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            //alignment center
            style2.setAlignment(HorizontalAlignment.CENTER);
            style2.setBorderBottom(BorderStyle.THIN);
            style2.setBorderLeft(BorderStyle.THIN);
            style2.setBorderRight(BorderStyle.THIN);
            style2.setBorderTop(BorderStyle.THIN);
            style2.setBottomBorderColor(IndexedColors.BLACK.getIndex());
            style2.setLeftBorderColor(IndexedColors.BLACK.getIndex());
            style2.setRightBorderColor(IndexedColors.BLACK.getIndex());
            style2.setTopBorderColor(IndexedColors.BLACK.getIndex());
            //font de los datos
            XSSFFont fontData = workbook.createFont();
            fontData.setFontHeightInPoints((short) 12);
            //arial
            fontData.setFontName("Arial");
            fontData.setColor(IndexedColors.BLACK.getIndex());
            style2.setFont(fontData);

            Object[] headers = {"Dia", "Porcentaje Ocupacion"};
            XSSFSheet sheet = workbook.createSheet("Reporte Porcentaje Ocupacional");

            //agregar headers
            Row rowhead = sheet.createRow((short) 0);
            for (int i = 0; i < headers.length; i++) {
                Cell cell = rowhead.createCell(i);
                cell.setCellValue(headers[i].toString());
                cell.setCellStyle(style);
            }

            //agregar datos
            int index = 1;
            for (int i = 0; i < dias.size(); i++) {
                Row row = sheet.createRow((short) index);

                Cell cell = row.createCell(0);
                cell.setCellValue(dias.get(i));
                cell.setCellStyle(style2);

                cell = row.createCell(1);
                cell.setCellValue(ocupaciones.get(i));
                cell.setCellStyle(style2);
                index++;
            }

            //autosize a las columnas
            for (int j = 0; j < headers.length; j++) {
                sheet.autoSizeColumn(j);
            }

            //create line chart
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            //data set agregar una sola serie llamada "Porcentaje Ocupacional"
            for (int j = 1; j < index; j++) {
                dataset.setValue(sheet.getRow(j).getCell(1).getNumericCellValue(), "Porcentaje Ocupacional", sheet.getRow(j).getCell(0).getStringCellValue());
            }
            JFreeChart jchart;
            //si el mes inicio y fin son iguales, se crea un reporte por mes
            if(mesInicio == mesFin && anioInicio == anioFin){
                jchart = ChartFactory.createLineChart("Porcentaje Ocupacional " + mesInicio + "/" + anioInicio, "Dia", "Porcentaje Ocupacional", dataset);
            }else{
                jchart = ChartFactory.createLineChart("Porcentaje Ocupacional " + mesInicio + "/" + anioInicio + " - " + mesFin + "/" + anioFin, "Dia", "Porcentaje Ocupacional", dataset);
            }

            // background color white
            jchart.setBackgroundPaint(Color.lightGray);

            //get a reference to the plot for further customisation...
            CategoryPlot plot = (CategoryPlot) jchart.getPlot();
            //gray style
            plot.setBackgroundPaint(Color.lightGray);
            plot.setDomainGridlinePaint(Color.white);
            plot.setRangeGridlinePaint(Color.white);

            //font of the legend
            LegendTitle legend = jchart.getLegend();
            legend.setItemFont(new Font("Arial", Font.PLAIN, 12));

            //font of the axis
            CategoryAxis domainAxis = plot.getDomainAxis();
            domainAxis.setLabelFont(new Font("Arial", Font.PLAIN, 12));
            domainAxis.setTickLabelFont(new Font("Arial", Font.PLAIN, 12));
            ValueAxis rangeAxis = plot.getRangeAxis();
            rangeAxis.setLabelFont(new Font("Arial", Font.PLAIN, 12));
            rangeAxis.setTickLabelFont(new Font("Arial", Font.PLAIN, 12));

            //set the range axis to display integers only...
            rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
            //disable bar outlines...
            LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
            renderer.setBaseShapesVisible(true);
            renderer.setDrawOutlines(true);
            renderer.setUseFillPaint(true);
            renderer.setBaseFillPaint(Color.white);
            renderer.setSeriesStroke(0, new BasicStroke(3.0f));
            renderer.setSeriesOutlineStroke(0, new BasicStroke(2.0f));
            renderer.setSeriesShape(0, new Ellipse2D.Double(-5.0, -5.0, 10.0, 10.0));

            //Rango del eje y , 5 mas que el maximo valor de porcentaje de ocupacion
            rangeAxis.setRange(0, Collections.max(ocupaciones) + 5);

            //mostrar etiqueta de cada dato en el grafico y agregar '%' al final posicion arriba
            renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator("{2}%", new DecimalFormat("0")));
            renderer.setBaseItemLabelsVisible(true);
            renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
            renderer.setItemLabelAnchorOffset(10.0);
            
            int my_picture_id;
            try ( // Write the chart image to the output stream
                    ByteArrayOutputStream chart_out = new ByteArrayOutputStream()) {
                ChartUtilities.writeChartAsPNG(chart_out, jchart, 600, 400);
                my_picture_id = workbook.addPicture(chart_out.toByteArray(), Workbook.PICTURE_TYPE_PNG);
            }

            // Create the drawing patriarch.  This is the top level container for all shapes including cell comments.
            XSSFDrawing drawing2 = sheet.createDrawingPatriarch();
            //add a picture shape
            ClientAnchor my_anchor = new XSSFClientAnchor();
            my_anchor.setCol1(0);
            my_anchor.setRow1(index + 2);
            XSSFPicture my_picture = drawing2.createPicture(my_anchor, my_picture_id);
            // Call resize method, which resizes the image
            my_picture.resize();

            try {
                //guardar archivo solictar ruta
                //get document folder
                String userDocuments = System.getProperty("user.home") + "/Documents";

                //fix slashes
                userDocuments = userDocuments.replace("\\", "/");

                String ruta = userDocuments + "/MediClass/Reportes";
                // Definir el arreglo de nombres de los meses
                String[] nombresMeses = {"ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO",
                    "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"};

                // Supongamos que mesInicio y mesFin son variables enteras que representan los meses (1 para enero, 2 para febrero, etc.)

                // Convertir mesInicio a su nombre correspondiente
                String nombreMesInicio = nombresMeses[mesInicio - 1];

                // Convertir mesFin a su nombre correspondiente
                String nombreMesFin = nombresMeses[mesFin - 1];

                // Concatenar los nombres de los meses en la ruta
                if (mesInicio == mesFin && anioInicio == anioFin) {
                    ruta = ruta + "/Rerporte_Porcentaje_Ocupacional_" + nombreMesInicio + "_" + anioInicio;
                } else {
                    ruta = ruta + "/Rerporte_Porcentaje_Ocupacional_" + nombreMesInicio + "_" + anioInicio + "_a_" + nombreMesFin + "_" + anioFin;
                }

                try (FileOutputStream fileOut = new FileOutputStream(ruta + ".xlsx")) {
                    workbook.write(fileOut);
                }

                //cerrar workbook
                workbook.close();

                try {
                    Desktop.getDesktop().open(new File(ruta + ".xlsx"));
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            } catch (HeadlessException | IOException e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }//GEN-LAST:event_JmenuReporteOcupacionalMouseClicked

    private void JBusqueda_EnfermeroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JBusqueda_EnfermeroKeyReleased
        // TODO add your handling code here:
        buscarEnfermero();
    }//GEN-LAST:event_JBusqueda_EnfermeroKeyReleased

    private void jcombo_EnfermeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcombo_EnfermeroActionPerformed
        // TODO add your handling code here:
        String nombreEnfermero = "";
        try{
            nombreEnfermero = jcombo_Enfermero.getSelectedItem().toString();
        } catch (Exception e) {
        }
        try {
            if (nombreEnfermero.equals("Click para crearlo")) {
                //crear ventana formulario
                FormRegistroEnfermero formEnfermero = new FormRegistroEnfermero();
                formEnfermero.JtextFieldNombre.setText(JBusqueda_Enfermero.getText());
                formEnfermero.setVisible(true);
                //cuando cierre ventana formulario cargarMedicamentos()
                formEnfermero.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        cargarEnfermeros();
                    }
                });
            }else{
                nombre_enfermero = nombreEnfermero;
                try (Connection cn = conexion.getConexion()) {
                    CallableStatement cst = (CallableStatement) cn.prepareCall("{call obtenerIdEnfermero(?)}");
                    cst.setString(1, nombreEnfermero);
                    ResultSet rs = cst.executeQuery();
                    if (rs.next()) {
                        id_enfermero = rs.getInt("id_enfermero");
                    }
                } catch (Exception e) {
                    System.out.println("Error al obtener el id del enfermero" + e);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al obtener el nombre del enfermero" + e);
        }
        
    }//GEN-LAST:event_jcombo_EnfermeroActionPerformed

    private void jMenuVerRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuVerRegistrosMouseClicked
        // TODO add your handling code here:
        BaseRegistros baseReg = new BaseRegistros();
        baseReg.setVisible(true);
    }//GEN-LAST:event_jMenuVerRegistrosMouseClicked

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Home().setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar BarraSuperior;
    private javax.swing.JTextField JBusqueda_Enfermero;
    private javax.swing.JTextField JBusqueda_Medicamento;
    private javax.swing.JTextField JBusqueda_Paciente;
    private javax.swing.JTextField JBusqueda_doctor;
    private javax.swing.JTable JTable_CarritoMedicamentos;
    private javax.swing.JLabel JlabelBackground;
    private javax.swing.JMenu JmenuActualizar;
    private javax.swing.JMenu JmenuReporte;
    private javax.swing.JMenu JmenuReporteDoctores;
    private javax.swing.JMenu JmenuReporteMensual;
    private javax.swing.JMenu JmenuReporteOcupacional;
    private javax.swing.JMenu JmenuSalir;
    private javax.swing.JPanel JpaneForm;
    private javax.swing.JButton jButtonAgregarMedicamento;
    private javax.swing.JButton jButtonRegistrar;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JTextField jCategoria;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenuVerRegistros;
    private javax.swing.JTextField jNombreMedicamento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jcantidadRegistro;
    private javax.swing.JComboBox<String> jcombo_Doctor;
    private javax.swing.JComboBox<String> jcombo_Enfermero;
    private javax.swing.JComboBox<String> jcombo_Medicamento;
    private javax.swing.JComboBox<String> jcombo_Paciente;
    // End of variables declaration//GEN-END:variables

    //START METHODS
    private void comprobarCarpetaApp() {
        //get document folder
        String userDocuments = System.getProperty("user.home") + "/Documents";

        //fix slashes
        userDocuments = userDocuments.replace("\\", "/");

        String ruta = userDocuments + "/MediClass";
        String rutaReportes = userDocuments + "/MediClass/Reportes";



        File carpeta = new File(ruta);
        if (!carpeta.exists()) {
            boolean carpetaCreada= carpeta.mkdir();
            if(carpetaCreada){
                System.out.println("Carpeta creada en "+ruta);
            }else{
                System.out.println("Carpeta no creada");
            }
        }

        File carpetaReportes = new File(rutaReportes);
        if (!carpetaReportes.exists()) {
            boolean carpetaCreada= carpetaReportes.mkdir();
            if(carpetaCreada){
                System.out.println("Carpeta reportes creada en "+rutaReportes);
            }else{
                System.out.println("Carpeta no creada");
            }
        }

    }
    private void cargarMedicamentos() {
        //agregar nombres de medicamentos desde la base de datos
        jcombo_Medicamento.removeAllItems();
        try {
            try (Connection cn = conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select nombre, generico from medicamentos order by nombre");
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String generico = rs.getString("generico");
                    if (generico != null && !generico.isEmpty()) {
                        String item = nombre + " ( " + generico + " )";
                        jcombo_Medicamento.addItem(item);
                    } else {
                        jcombo_Medicamento.addItem(nombre);
                    }
                }
            }
        } catch (SQLException e) {

        }
    }

    private void buscarMedicamento() {
        // buscar palabras parecidas a la que se escribe en el campo de busqueda
        String buscar = JBusqueda_Medicamento.getText();
        if (buscar.equals("")) {
            cargarMedicamentos();
        } else {
            String sql = "SELECT nombre, generico FROM medicamentos WHERE nombre LIKE '%" + buscar + "%' OR generico LIKE '%" + buscar + "%'";
            try {
                busqueda_similar_medicamento_sql(sql, jcombo_Medicamento);
            } catch (SQLException e) {
                System.out.println("Error al buscar medicamento" + e);
            }
        }
    }

    private void cargarDoctores(){
        //agregar nombres de doctores desde la base de datos
        jcombo_Doctor.removeAllItems();
        try {
            try (Connection cn = conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select nombre from doctores order by nombre");
                ResultSet rs = pst.executeQuery();
                
                //jcomboMedicamentos.addItem("Seleccione un medicamento");
                while (rs.next()) {
                    jcombo_Doctor.addItem(rs.getString("nombre"));
                }
            }

        } catch (SQLException e) {

        }
    }

    private void buscarDoctor(){
        //buscar palabras parecidas a la que se escribe en el campo de busqueda
        String buscar = JBusqueda_doctor.getText();

        if (buscar.equals("")) {
            cargarDoctores();
        } else {
            String sql = "SELECT nombre FROM doctores WHERE nombre LIKE '%" + buscar + "%'";
            try {
                busqueda_similar_sql(sql, jcombo_Doctor);
            } catch (SQLException e) {
                System.out.println("Error al buscar doctor");
            }
        }
    }

    private void busqueda_similar_sql(String sql, JComboBox<String> jCombo) throws SQLException {
        try (Connection cn = conexion.getConexion()) {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                try {
                    jCombo.removeAllItems();
                } catch (Exception e) {
                    System.out.println("Error al limpiar el combobox");
                }
                do {
                    jCombo.addItem(rs.getString("nombre"));
                } while (rs.next());
            } else {
                jCombo.removeAllItems();
                jCombo.addItem("!No existe, Crealo!");
                jCombo.addItem("Click para crearlo");
            }
        }
    }

    private void busqueda_similar_medicamento_sql(String sql, JComboBox<String> jCombo) throws SQLException {
        try (Connection cn = conexion.getConexion()) {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                try {
                    jCombo.removeAllItems();
                } catch (Exception e) {
                    System.out.println("Error al limpiar el combobox");
                }
                do {
                    String nombre = rs.getString("nombre");
                    String generico = rs.getString("generico");
                    if (generico != null && !generico.isEmpty()) {
                        String item = nombre + " ( " + generico + " )";
                        jCombo.addItem(item);
                    } else {
                        jCombo.addItem(nombre);
                    }
                } while (rs.next());
            } else {
                jCombo.removeAllItems();
                jCombo.addItem("!No existe, Crealo!");
                jCombo.addItem("Click para crearlo");
            }
        }
    }
    
    private void cargarPacientes() {
        // Agregar nombres de pacientes desde la base de datos
        jcombo_Paciente.removeAllItems();
    
        try {
            try (Connection cn = conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("SELECT nombre FROM pacientes ORDER BY nombre");
                ResultSet rs = pst.executeQuery();
    
                while (rs.next()) {
                    jcombo_Paciente.addItem(rs.getString("nombre"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar pacientes: " + e.getMessage());
        }
    }
    

    private void buscarPaciente(){
        //buscar palabras parecidas a la que se escribe en el campo de busqueda
        String buscar = JBusqueda_Paciente.getText();

        if (buscar.equals("")) {
            cargarPacientes();
        } else {
            String sql = "SELECT nombre FROM pacientes WHERE nombre LIKE '%" + buscar + "%'";
            try {
                busqueda_similar_sql(sql, jcombo_Paciente);
            } catch (SQLException e) {
                System.out.println("Error al buscar paciente");
            }
        }
    }

    private void cargarEnfermeros(){
        //agregar nombres de enfermeros desde la base de datos
        jcombo_Enfermero.removeAllItems();
        try {
            try (Connection cn = conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement("select nombre from enfermeros order by nombre");
                ResultSet rs = pst.executeQuery();
                
                while (rs.next()) {
                    jcombo_Enfermero.addItem(rs.getString("nombre"));
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al cargar enfermeros");
        }
    }

    private void buscarEnfermero(){
        //buscar palabras parecidas a la que se escribe en el campo de busqueda
        String buscar = JBusqueda_Enfermero.getText();

        if (buscar.equals("")) {
            cargarEnfermeros();
        } else {
            String sql = "SELECT nombre FROM enfermeros WHERE nombre LIKE '%" + buscar + "%'";
            try {
                busqueda_similar_sql(sql, jcombo_Enfermero);
            } catch (SQLException e) {
                System.out.println("Error al buscar enfermero");
            }
        }
    }

    private void actualizarInfo() {
        
        String nombrePaciente  = jcombo_Paciente.getSelectedItem().toString();
        String nombreDoctor = jcombo_Doctor.getSelectedItem().toString();
        String nombreEnfermero = jcombo_Enfermero.getSelectedItem().toString();
    
        if (nombrePaciente.equals("!No existe, Crealo!")) {
            JOptionPane.showMessageDialog(null, "El paciente no existe, por favor crealo");
            return;
        }
        if (nombreDoctor.equals("!No existe, Crealo!")) {
            JOptionPane.showMessageDialog(null, "El doctor no existe, por favor crealo");
            return;
        }
        if (nombreEnfermero.equals("!No existe, Crealo!")) {
            JOptionPane.showMessageDialog(null, "El enfermero no existe, por favor crealo");
            return;
        }

        // obtener info de paciente a las variables globales
        String idPaciente = "SELECT id_paciente,nombre FROM pacientes WHERE nombre = '" + nombrePaciente + "';";
        try {
            try (Connection cn = conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement(idPaciente);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    id_paciente = rs.getInt("id_paciente");
                    nombre_paciente = rs.getString("nombre");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el id del paciente" + e);
        }

        // obtener info de doctor a las variables globales
        String idDoctor = "SELECT id_doctor,nombre FROM doctores WHERE nombre = '" + nombreDoctor + "';";
        try {
            try (Connection cn = conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement(idDoctor);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    id_doctor = rs.getInt("id_doctor");
                    nombre_doctor = rs.getString("nombre");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el id del doctor" + e);
        }

        // obtener info de enfermero a las variables globales
        String idEnfermero = "SELECT id_enfermero,nombre FROM enfermeros WHERE nombre = '" + nombreEnfermero + "';";
        try {
            try (Connection cn = conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement(idEnfermero);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    id_enfermero = rs.getInt("id_enfermero");
                    nombre_enfermero = rs.getString("nombre");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el id del enfermero" + e);
        }

    }

    private void actualizarMedicamento(){
        String nombreMedicamento = jcombo_Medicamento.getSelectedItem().toString();
        if (nombreMedicamento.equals("!No existe, Crealo!")) {
            JOptionPane.showMessageDialog(null, "El medicamento no existe, por favor crealo");
            return;
        }
        if (nombreMedicamento.contains("( ")) {
            nombreMedicamento = nombreMedicamento.substring(0, nombreMedicamento.indexOf(" ( "));
        }

        // obtener info de medicamento a las variables globales
        String categoriaMedicamento = "SELECT id,nombre,categoria,generico FROM medicamentos WHERE nombre = '" + nombreMedicamento + "' ORDER BY categoria ASC;";
        try {
            try (Connection cn = conexion.getConexion()) {
                PreparedStatement pst = cn.prepareStatement(categoriaMedicamento);
                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    id_medicamento = rs.getInt("id");
                    nombre_medicamento = rs.getString("nombre");
                    categoria_medicamento = rs.getString("categoria");
                    generico_medicamento = rs.getString("generico");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la categoria del medicamento" + e);
        }
    }
}

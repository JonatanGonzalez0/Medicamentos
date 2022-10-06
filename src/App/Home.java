package App;

import com.toedter.calendar.JDateChooser;
import java.awt.Desktop;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.util.Date;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.chart.AxisCrosses;
import org.apache.poi.xddf.usermodel.chart.AxisPosition;
import org.apache.poi.xddf.usermodel.chart.ChartTypes;
import org.apache.poi.xddf.usermodel.chart.LegendPosition;
import org.apache.poi.xddf.usermodel.chart.XDDFBarChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFCategoryAxis;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFChartLegend;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFValueAxis;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartUtilities;

public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();
        cargarMedicamentos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        JpaneForm = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jNombreMedicamento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jcomboMedicamentos = new javax.swing.JComboBox<>();
        jButtonRegistrar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jcantidadRegistro = new javax.swing.JTextField();
        JBusqueda = new javax.swing.JTextField();
        jButtonVerBaseDatosMedicamentos = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jCategoria = new javax.swing.JTextField();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        JmenuActualizar = new javax.swing.JMenu();
        JmenuReporte = new javax.swing.JMenu();
        JmenuReporteMensual = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 138, 250));
        jLabel1.setText("CLASIFICACION MEDICAMENTOS");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("CATEGORIA");

        jNombreMedicamento.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jNombreMedicamento.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("Nombre Medicamento");

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 102, 255));
        jLabel5.setText("Busqueda");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 102, 255));
        jLabel6.setText("Clasificar ingreso");

        jcomboMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboMedicamentosActionPerformed(evt);
            }
        });

        jButtonRegistrar.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jButtonRegistrar.setText("Clasificar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel7.setText("Cantidad");

        JBusqueda.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        JBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JBusquedaKeyReleased(evt);
            }
        });

        jButtonVerBaseDatosMedicamentos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jButtonVerBaseDatosMedicamentos.setText("Ver Base Datos Medicamentos");
        jButtonVerBaseDatosMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerBaseDatosMedicamentosActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(138, 139, 142));
        jLabel9.setText("Calendario");

        jCalendar1.setForeground(new java.awt.Color(153, 153, 153));

        jCategoria.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jCategoria.setEnabled(false);

        javax.swing.GroupLayout JpaneFormLayout = new javax.swing.GroupLayout(JpaneForm);
        JpaneForm.setLayout(JpaneFormLayout);
        JpaneFormLayout.setHorizontalGroup(
            JpaneFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpaneFormLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(JpaneFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpaneFormLayout.createSequentialGroup()
                        .addGroup(JpaneFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpaneFormLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jcantidadRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(JpaneFormLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JpaneFormLayout.createSequentialGroup()
                        .addGroup(JpaneFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpaneFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpaneFormLayout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(jCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(JpaneFormLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jNombreMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpaneFormLayout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JpaneFormLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel5)
                .addGap(52, 52, 52)
                .addGroup(JpaneFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpaneFormLayout.createSequentialGroup()
                        .addComponent(jcomboMedicamentos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(234, 234, 234))
                    .addGroup(JpaneFormLayout.createSequentialGroup()
                        .addComponent(JBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)))
                .addGroup(JpaneFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVerBaseDatosMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(173, 173, 173))
        );
        JpaneFormLayout.setVerticalGroup(
            JpaneFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JpaneFormLayout.createSequentialGroup()
                .addGroup(JpaneFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JpaneFormLayout.createSequentialGroup()
                        .addGroup(JpaneFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(JpaneFormLayout.createSequentialGroup()
                                .addGroup(JpaneFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(JBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jcomboMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(JpaneFormLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jButtonVerBaseDatosMedicamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jNombreMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel3)
                        .addGap(29, 29, 29)
                        .addComponent(jCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(JpaneFormLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jcantidadRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButtonRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        jMenu3.setText("Archivo");

        JmenuActualizar.setText("Actualizar Datos");
        JmenuActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JmenuActualizarMouseClicked(evt);
            }
        });
        jMenu3.add(JmenuActualizar);

        jMenuBar2.add(jMenu3);

        JmenuReporte.setText("Reportes");

        JmenuReporteMensual.setText("Reporte Mensual");
        JmenuReporteMensual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JmenuReporteMensualMouseClicked(evt);
            }
        });
        JmenuReporte.add(JmenuReporteMensual);

        jMenuBar2.add(JmenuReporte);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JpaneForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(317, 317, 317))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JpaneForm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jcomboMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboMedicamentosActionPerformed
        // TODO add your handling code here:
        String nombreMedicamento = "";
        try {
            nombreMedicamento = jcomboMedicamentos.getSelectedItem().toString();
        } catch (Exception e) {
        }

        if (nombreMedicamento.equals("Seleccione un medicamento")) {
            jNombreMedicamento.setText("");
        } else if (nombreMedicamento.equals("No existe, click para crearlo")) {
            //crear ventana formulario
            FormRegistro formRegistro = new FormRegistro();
            formRegistro.JtextFieldNombre.setText(JBusqueda.getText());

            //obtener todas las categorias distintas de la base de datos mysql
            try {
                Connection con = conexion.getConexion();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT DISTINCT categoria FROM medicamentos;");
                while (rs.next()) {
                    formRegistro.jComboBoxCategoria.addItem(rs.getString("categoria"));
                }
                formRegistro.jComboBoxCategoria.addItem("click para crear una nueva categoria");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            formRegistro.setVisible(true);

            //cuando cierre ventana formulario cargarMedicamentos()
            formRegistro.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    cargarMedicamentos();
                }
            });

        } else {
            jNombreMedicamento.setText(nombreMedicamento);

            //obeter categoria del medicamento desde la base de datos
            String categoriaMedicamento = "SELECT categoria FROM medicamentos WHERE nombre = '" + nombreMedicamento + "'";
            String categoria = "";
            try {
                Connection con = conexion.getConexion();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(categoriaMedicamento);
                while (rs.next()) {
                    categoria = rs.getString("categoria");
                }

                jCategoria.setText(categoria);
                con.close();
            } catch (Exception ex) {
                System.out.println("Error al obtener la categoria del medicamento");

            }
        }

    }//GEN-LAST:event_jcomboMedicamentosActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed

        String nombreMedicamento = jNombreMedicamento.getText();
        String cantidad = jcantidadRegistro.getText();

        //validar que cantidad sea un numero
        try {
            Integer.parseInt(cantidad);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "La cantidad debe ser un numero");
            return;
        }

        //obtener fecha del jcalendar y enviar a sql
        Date fecha = jCalendar1.getDate();
        long d = fecha.getTime();
        java.sql.Date fechaSql = new java.sql.Date(d);

        String categoria = "";
        categoria = jCategoria.getText();

        if (nombreMedicamento.equals("") || cantidad.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        } else {
            try {
                Connection con = conexion.getConexion();
                Statement st = con.createStatement();
                String sql = "INSERT INTO registro (nombre, categoria, cantidad, fecha) VALUES ('" + nombreMedicamento + "', '" + categoria + "', '" + cantidad + "', '" + fechaSql + "')";
                st.executeUpdate(sql);

                JOptionPane.showMessageDialog(null, "Registro exitoso");
                jNombreMedicamento.setText("");
                jcantidadRegistro.setText("");
                jcomboMedicamentos.setSelectedIndex(0);

                con.close();
            } catch (Exception ex) {
                System.out.println("Error al registrar el medicamento");
            }
        }
        JBusqueda.setText("");
        jCategoria.setText("");
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void JBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JBusquedaKeyReleased

        buscarMedicamento();
    }//GEN-LAST:event_JBusquedaKeyReleased

    private void JmenuReporteMensualMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JmenuReporteMensualMouseClicked

        //mostrar date chooser para seleccionar el mes y año
        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("MM/yyyy");
        dateChooser.setDate(new Date());
        JOptionPane.showMessageDialog(null, dateChooser, "Seleccione el mes y año", JOptionPane.PLAIN_MESSAGE);

        int mes = dateChooser.getCalendar().get(Calendar.MONTH) + 1;
        int anio = dateChooser.getCalendar().get(Calendar.YEAR);

        //contar cuantas categorias hay
        //array para guardar las categorias
        ArrayList<String> categorias = new ArrayList<String>();
        int contador = 0;
        try {
            Connection con = conexion.getConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT DISTINCT categoria FROM medicamentos;");
            while (rs.next()) {
                categorias.add(rs.getString("categoria"));
                contador++;
            }
            con.close();
        } catch (Exception ex) {
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
        style.setFillForegroundColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
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

        Object[] headers = {"Medicamento", "Cantidad de unidades registradas"};

        for (int i = 0; i < contador; i++) {
            int cantColumnas = headers.length;
            String categoria = categorias.get(i);
            String sql = "SELECT nombre, sum(cantidad) as cantidad FROM registro WHERE MONTH(fecha) = '" + mes + "' AND YEAR(fecha) = '" + anio + "' AND categoria = '" + categoria + "' GROUP BY nombre;";
            try {
                ResultSet rs = st.executeQuery(sql);
                XSSFSheet sheet = workbook.createSheet(categoria);

                Row row = sheet.createRow(0);

                for (int j = 0; j < cantColumnas; j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue(headers[j].toString());
                    cell.setCellStyle(style);
                }

                //datos
                int index = 1;
                while (rs.next()) {
                    row = sheet.createRow(index);
                    Cell nombre = row.createCell(0);
                    nombre.setCellValue(rs.getString("nombre"));
                    nombre.setCellStyle(style2);

                    Cell cantidad = row.createCell(1);
                    cantidad.setCellValue(rs.getInt("cantidad"));
                    cantidad.setCellStyle(style2);
                    index++;
                }

                //autosize a las columnas
                for (int j = 0; j < cantColumnas; j++) {
                    sheet.autoSizeColumn(j);
                }
                
                //create bar chart
                DefaultCategoryDataset dataset = new DefaultCategoryDataset();
                for (int j = 1; j < index; j++) {
                    dataset.setValue(sheet.getRow(j).getCell(1).getNumericCellValue(), sheet.getRow(j).getCell(0).getStringCellValue(), categoria);
                }
                JFreeChart jchart = ChartFactory.createBarChart(categoria, "Medicamentos", "Cantidad", dataset, PlotOrientation.VERTICAL, true, true, false);

                // Write the chart image to the output stream
                ByteArrayOutputStream chart_out = new ByteArrayOutputStream();
                ChartUtilities.writeChartAsPNG(chart_out, jchart, 500, 300);
                int my_picture_id = workbook.addPicture(chart_out.toByteArray(), Workbook.PICTURE_TYPE_PNG);
                chart_out.close();
                // Create the drawing patriarch.  This is the top level container for all shapes including cell comments.
                XSSFDrawing drawing2 = sheet.createDrawingPatriarch();
                //add a picture shape
                ClientAnchor my_anchor = new XSSFClientAnchor();
                my_anchor.setCol1(0);
                my_anchor.setRow1(5);
                XSSFPicture  my_picture = drawing2.createPicture(my_anchor, my_picture_id);
                // Call resize method, which resizes the image
                my_picture.resize();



            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            //guardar archivo solictar ruta
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar reporte mensual");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int userSelection = fileChooser.showSaveDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                String ruta = fileToSave.getAbsolutePath();
                FileOutputStream fileOut = new FileOutputStream(ruta + "/ReporteMensual_" + String.valueOf(mes) + "-" + String.valueOf(anio) + ".xlsx");
                workbook.write(fileOut);
                fileOut.close();

                try {
                    Desktop.getDesktop().open(new File(ruta + "/ReporteMensual_" + String.valueOf(mes) + "-" + String.valueOf(anio) + ".xlsx"));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {

            /*
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            while (rs.next()) {
                dataset.setValue(rs.getInt("cantidad"), rs.getString("nombre"), rs.getString("nombre"));
            }
            JFreeChart chart = ChartFactory.createBarChart("Reporte Mensual No Generico", "Medicamentos", "Cantidad", dataset, PlotOrientation.VERTICAL, true, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);
            ChartFrame frame = new ChartFrame("Reporte Mensual No Generico", chart);
            frame.setVisible(true);
            frame.setSize(450, 350);*/

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_JmenuReporteMensualMouseClicked

    private void jButtonVerBaseDatosMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerBaseDatosMedicamentosActionPerformed
        // TODO add your handling code here:
        //nueva ventana para mostrar la base de datos de medicamentos
        BaseDatosMedicamentos ventana_base = new BaseDatosMedicamentos();
        //obtener datos de la tabla
        DefaultTableModel modelo = (DefaultTableModel) ventana_base.JTableBaseDatos.getModel();
        //limpiar tabla
        modelo.setRowCount(0);
        //obtener datos de la base de datos
        try {
            Connection con = conexion.getConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM medicamentos;");
            while (rs.next()) {
                Object[] fila = new Object[3];
                fila[0] = rs.getInt("id");
                fila[1] = rs.getString("nombre");
                fila[2] = rs.getString("categoria");
                modelo.addRow(fila);
            }

            //cargar categorias unicas a JFilterCategory
            ResultSet rs2 = st.executeQuery("SELECT DISTINCT categoria FROM medicamentos;");
            while (rs2.next()) {
                ventana_base.JFilterCategory.addItem(rs2.getString("categoria"));
            }
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        ventana_base.setVisible(true);

        //cuando se cierre la ventana de base de datos de medicamento cargar medicamentos()
        ventana_base.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                cargarMedicamentos();
            }
        });


    }//GEN-LAST:event_jButtonVerBaseDatosMedicamentosActionPerformed

    private void JmenuActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JmenuActualizarMouseClicked

        //limpiar jcomboMedicamentos
        jcomboMedicamentos.removeAllItems();
        cargarMedicamentos();

        JBusqueda.setText("");
    }//GEN-LAST:event_JmenuActualizarMouseClicked

    private void cargarMedicamentos() {
        //agregar nombres de medicamentos desde la base de datos
        try {
            Connection cn = conexion.getConexion();
            PreparedStatement pst = cn.prepareStatement("select nombre from medicamentos");
            ResultSet rs = pst.executeQuery();

            jcomboMedicamentos.addItem("Seleccione un medicamento");
            while (rs.next()) {
                jcomboMedicamentos.addItem(rs.getString("nombre"));
            }
            cn.close();

        } catch (Exception e) {

        }
    }

    private void buscarMedicamento() {
        //buscar palabras parecidas a la que se escribe en el campo de busqueda
        String buscar = JBusqueda.getText();
        if (buscar.equals("")) {
            //remover todos items desde el segundo item
            int i = jcomboMedicamentos.getItemCount();
            while (i > 1) {
                jcomboMedicamentos.removeItemAt(i - 1);
                i--;
            }
            cargarMedicamentos();
        } else {
            String sql = "SELECT nombre FROM medicamentos WHERE nombre LIKE '%" + buscar + "%'";
            try {
                Connection cn = conexion.getConexion();
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    try {
                        //remover todos items desde el segundo item
                        int i = jcomboMedicamentos.getItemCount();
                        while (i > 1) {
                            jcomboMedicamentos.removeItemAt(i - 1);
                            i--;
                        }
                    } catch (Exception e) {
                        System.out.println("Error al limpiar el combobox");
                    }
                    do {
                        jcomboMedicamentos.addItem(rs.getString("nombre"));
                    } while (rs.next());
                } else {
                    //remover todos items desde el segundo item
                    int i = jcomboMedicamentos.getItemCount();
                    while (i > 1) {
                        jcomboMedicamentos.removeItemAt(i - 1);
                        i--;
                    }
                    jcomboMedicamentos.addItem("No existe, click para crearlo");
                }
                cn.close();
            } catch (Exception e) {
            }
        }
    }

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
                new Home().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JBusqueda;
    private javax.swing.JMenu JmenuActualizar;
    private javax.swing.JMenu JmenuReporte;
    private javax.swing.JMenu JmenuReporteMensual;
    private javax.swing.JPanel JpaneForm;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JButton jButtonVerBaseDatosMedicamentos;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JTextField jCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JTextField jNombreMedicamento;
    private javax.swing.JTextField jcantidadRegistro;
    private javax.swing.JComboBox<String> jcomboMedicamentos;
    // End of variables declaration//GEN-END:variables
}

package App;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
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
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
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
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.general.DefaultPieDataset;

public class Home extends javax.swing.JFrame {

    public Home() {
        initComponents();
        cargarMedicamentos();
        //colocar imagen logo en jlabel autoscala
        ImageIcon icon = new ImageIcon(getClass().getResource("/images/logo.png"));
        //jLabelLogo.setIcon(new ImageIcon(icon.getImage().getScaledInstance(jLabelLogo.getWidth(), jLabelLogo.getHeight(), 1)));

        //jpanel image background
        Image background = new ImageIcon(getClass().getResource("/images/background3.jpg")).getImage();
        //jlabel image background
        JlabelBackground.setIcon(new ImageIcon(background.getScaledInstance(JlabelBackground.getWidth(), JlabelBackground.getHeight(), 1)));

        comprobarCarpetaApp();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JpaneForm = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jcomboMedicamentos = new javax.swing.JComboBox<>();
        JBusqueda = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jcantidadRegistro = new javax.swing.JTextField();
        jCategoria = new javax.swing.JTextField();
        jNombreMedicamento = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButtonRegistrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jLabel1 = new javax.swing.JLabel();
        JlabelBackground = new javax.swing.JLabel();
        BarraSuperior = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        JmenuActualizar = new javax.swing.JMenu();
        JmenuSalir = new javax.swing.JMenu();
        JmenuReporte = new javax.swing.JMenu();
        JmenuReporteMensual = new javax.swing.JMenu();
        JverTablaRegistros = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MediClass App");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/IconMediClass.png")));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JpaneForm.setForeground(new java.awt.Color(51, 51, 51));
        JpaneForm.setOpaque(false);
        JpaneForm.setPreferredSize(new java.awt.Dimension(1366, 768));
        JpaneForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel5.setForeground(java.awt.SystemColor.textHighlight);
        jLabel5.setText("BUSQUEDA");
        JpaneForm.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 158, 39));

        jcomboMedicamentos.setBackground(new java.awt.Color(102, 153, 255));
        jcomboMedicamentos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jcomboMedicamentos.setForeground(new java.awt.Color(255, 255, 255));
        jcomboMedicamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcomboMedicamentosActionPerformed(evt);
            }
        });
        JpaneForm.add(jcomboMedicamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 470, 36));

        JBusqueda.setBackground(new java.awt.Color(0, 153, 153));
        JBusqueda.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        JBusqueda.setForeground(new java.awt.Color(255, 255, 255));
        JBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JBusquedaKeyReleased(evt);
            }
        });
        JpaneForm.add(JBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 470, 39));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel4.setForeground(java.awt.SystemColor.textHighlight);
        jLabel4.setText("MEDICAMENTO");
        JpaneForm.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel3.setForeground(java.awt.SystemColor.textHighlight);
        jLabel3.setText("CATEGORIA");
        JpaneForm.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 360, 159, -1));

        jcantidadRegistro.setBackground(new java.awt.Color(0, 153, 153));
        jcantidadRegistro.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jcantidadRegistro.setForeground(new java.awt.Color(255, 255, 255));
        jcantidadRegistro.setOpaque(true);
        JpaneForm.add(jcantidadRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 510, 260, -1));

        jCategoria.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jCategoria.setEnabled(false);
        JpaneForm.add(jCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 400, 400, 43));

        jNombreMedicamento.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jNombreMedicamento.setEnabled(false);
        JpaneForm.add(jNombreMedicamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, 400, 43));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 128));
        jLabel6.setText("CLASIFICAR MEDICAMENTO ");
        JpaneForm.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 310, -1, -1));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setForeground(java.awt.SystemColor.textHighlight);
        jLabel7.setText("CANTIDAD");
        JpaneForm.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, -1, -1));

        jButtonRegistrar.setBackground(java.awt.SystemColor.textHighlight);
        jButtonRegistrar.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jButtonRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegistrar.setText("Clasificar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });
        JpaneForm.add(jButtonRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 500, 170, 60));

        jLabel9.setFont(new java.awt.Font("Dubai", 0, 36)); // NOI18N
        jLabel9.setForeground(java.awt.SystemColor.textHighlight);
        jLabel9.setText("Calendario");
        JpaneForm.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(941, 70, 180, 40));

        jCalendar1.setForeground(new java.awt.Color(0, 153, 153));
        JpaneForm.add(jCalendar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 120, 380, 200));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("CLASIFICACION MEDICAMENTOS");
        JpaneForm.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 6, -1, -1));

        getContentPane().add(JpaneForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 36, 1247, 680));
        getContentPane().add(JlabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1366, 768));

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

        JmenuReporteMensual.setText("Reporte Mensual");
        JmenuReporteMensual.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JmenuReporteMensualMouseClicked(evt);
            }
        });
        JmenuReporte.add(JmenuReporteMensual);

        JverTablaRegistros.setText("Ver tabla de registros");
        JverTablaRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JverTablaRegistrosMouseClicked(evt);
            }
        });
        JmenuReporte.add(JverTablaRegistros);

        BarraSuperior.add(JmenuReporte);

        jMenu1.setText("Ver Base Datos");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        BarraSuperior.add(jMenu1);

        setJMenuBar(BarraSuperior);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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

                JFreeChart jchart = ChartFactory.createBarChart("Registro de " + categoria + " " + mes + "/" + anio, "Medicamentos", "Cantidad", dataset, PlotOrientation.VERTICAL, true, true, false);
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

                // Write the chart image to the output stream
                ByteArrayOutputStream chart_out = new ByteArrayOutputStream();
                ChartUtilities.writeChartAsPNG(chart_out, jchart, 600, 400);
                int my_picture_id = workbook.addPicture(chart_out.toByteArray(), Workbook.PICTURE_TYPE_PNG);
                chart_out.close();
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

                JFreeChart pieChart = ChartFactory.createPieChart("Registro de " + categoria + " " + mes + "/" + anio, pieDataset, true, true, false);
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

                // Write the chart image to the output stream
                ByteArrayOutputStream pieChart_out = new ByteArrayOutputStream();
                ChartUtilities.writeChartAsPNG(pieChart_out, pieChart, 600, 400);
                int my_pieChart_id = workbook.addPicture(pieChart_out.toByteArray(), Workbook.PICTURE_TYPE_PNG);
                pieChart_out.close();
                // Create the drawing patriarch.  This is the top level container for all shapes including cell comments.
                XSSFDrawing drawing3 = sheet.createDrawingPatriarch();
                //add a picture shape
                ClientAnchor my_pieChart_anchor = new XSSFClientAnchor();
                my_pieChart_anchor.setCol1(4);
                my_pieChart_anchor.setRow1(index + 2);
                XSSFPicture my_pieChart = drawing3.createPicture(my_pieChart_anchor, my_pieChart_id);
                // Call resize method, which resizes the image
                my_pieChart.resize();

                //crear otra hoja
            } catch (SQLException ex) {
                Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
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
            ResultSet rs = st.executeQuery("SELECT DISTINCT categoria, sum(cantidad) as cantidad FROM registro WHERE MONTH(fecha) = " + mes + " AND YEAR(fecha) = " + anio + " GROUP BY categoria");
            int index = 1;
            while (rs.next()) {
                row = sheetTodasCat.createRow(index);
                Cell categoria = row.createCell(0);
                categoria.setCellValue(rs.getString("categoria"));
                categoria.setCellStyle(style2);

                Cell cantidad = row.createCell(1);
                cantidad.setCellValue(rs.getInt("cantidad"));
                cantidad.setCellStyle(style2);
                index++;
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

            JFreeChart jchart = ChartFactory.createBarChart("Medicamentos por Categoria" + mes + "/" + anio, "Categorias", "Cantidad", dataset, PlotOrientation.VERTICAL, true, true, false);
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

            // Write the chart image to the output stream
            ByteArrayOutputStream chart_out = new ByteArrayOutputStream();
            ChartUtilities.writeChartAsPNG(chart_out, jchart, 600, 400);
            int my_picture_id = workbook.addPicture(chart_out.toByteArray(), Workbook.PICTURE_TYPE_PNG);
            chart_out.close();
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
            JFreeChart pieChart = ChartFactory.createPieChart("Medicamentos por Categoria " + mes + "/" + anio, pieDataset, true, true, false);
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

            // Write the chart image to the output stream
            ByteArrayOutputStream pieChart_out = new ByteArrayOutputStream();
            ChartUtilities.writeChartAsPNG(pieChart_out, pieChart, 600, 400);
            int my_pieChart_id = workbook.addPicture(pieChart_out.toByteArray(), Workbook.PICTURE_TYPE_PNG);
            pieChart_out.close();
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            //guardar archivo solictar ruta
            //get document folder
            String userDocuments = System.getProperty("user.home") + "/Documents";

            //fix slashes
            userDocuments = userDocuments.replace("\\", "/");

            String ruta = userDocuments + "/MediClass/Reportes";

            FileOutputStream fileOut = new FileOutputStream(ruta + "/ReporteMensualDel" + mes + "_" + anio + ".xlsx");
            workbook.write(fileOut);
            fileOut.close();

            try {
                Desktop.getDesktop().open(new File(ruta + "/ReporteMensualDel" + mes + "_" + anio + ".xlsx"));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_JmenuReporteMensualMouseClicked

    private void JmenuActualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JmenuActualizarMouseClicked

        cargarMedicamentos();
        JBusqueda.setText("");
        JOptionPane.showMessageDialog(null, "Medicamentos actualizados");
    }//GEN-LAST:event_JmenuActualizarMouseClicked

    private void JmenuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JmenuSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_JmenuSalirMouseClicked

    private void JverTablaRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JverTablaRegistrosMouseClicked

        BaseRegistros baseReg = new BaseRegistros();
        baseReg.setVisible(true);

        //cuando se cierre actualizar
        baseReg.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                cargarMedicamentos();
            }
        });

    }//GEN-LAST:event_JverTablaRegistrosMouseClicked

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked

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
            ResultSet rs = st.executeQuery("SELECT * FROM medicamentos ORDER BY nombre ASC;");
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
    }//GEN-LAST:event_jMenu1MouseClicked

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

    private void jcomboMedicamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcomboMedicamentosActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String nombreMedicamento = "";
        try {
            nombreMedicamento = jcomboMedicamentos.getSelectedItem().toString();
        } catch (Exception e) {
        }

        switch (nombreMedicamento) {
            case "Seleccione un medicamento" ->
                jNombreMedicamento.setText("");
            case "Click para crearlo" -> {
                //crear ventana formulario
                FormRegistro formRegistro = new FormRegistro();
                formRegistro.JtextFieldNombre.setText(JBusqueda.getText());
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
                //obeter categoria del medicamento desde la base de datos
                String categoriaMedicamento = "SELECT categoria FROM medicamentos WHERE nombre = '" + nombreMedicamento + "' ORDER BY categoria ASC;";
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
        }
    }//GEN-LAST:event_jcomboMedicamentosActionPerformed

    private void cargarMedicamentos() {
        //agregar nombres de medicamentos desde la base de datos
        jcomboMedicamentos.removeAllItems();
        try {
            Connection cn = conexion.getConexion();
            PreparedStatement pst = cn.prepareStatement("select nombre from medicamentos order by nombre");
            ResultSet rs = pst.executeQuery();

            //jcomboMedicamentos.addItem("Seleccione un medicamento");
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
                        jcomboMedicamentos.removeAllItems();
                    } catch (Exception e) {
                        System.out.println("Error al limpiar el combobox");
                    }
                    do {
                        jcomboMedicamentos.addItem(rs.getString("nombre"));
                    } while (rs.next());
                } else {
                    jcomboMedicamentos.removeAllItems();
                    jcomboMedicamentos.addItem("!No existe, Crealo!");
                    jcomboMedicamentos.addItem("Click para crearlo");
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
    private javax.swing.JMenuBar BarraSuperior;
    private javax.swing.JTextField JBusqueda;
    private javax.swing.JLabel JlabelBackground;
    private javax.swing.JMenu JmenuActualizar;
    private javax.swing.JMenu JmenuReporte;
    private javax.swing.JMenu JmenuReporteMensual;
    private javax.swing.JMenu JmenuSalir;
    private javax.swing.JPanel JpaneForm;
    private javax.swing.JMenu JverTablaRegistros;
    private javax.swing.JButton jButtonRegistrar;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JTextField jCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JTextField jNombreMedicamento;
    private javax.swing.JTextField jcantidadRegistro;
    private javax.swing.JComboBox<String> jcomboMedicamentos;
    // End of variables declaration//GEN-END:variables

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
}

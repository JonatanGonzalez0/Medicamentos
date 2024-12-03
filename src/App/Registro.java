/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;



/**
 *
 * @author pcnew
 */
public final class Registro {
    // variables de instancia
    // fecha tipo date en mysql
    public Date fecha;
    public Integer id;
    public String nombre_doctor;    
    public String nombre_paciente;
    public String nombre_enfermero;
    public ArrayList<DetalleRegistro> detalles_registro = new ArrayList<>();

    public Registro(Integer id) {
        this.id = id;
        obtenerDatos(id);
        obtenerDetalles();
    }
    
    // traer los datos de la base de datos
    private void obtenerDatos(Integer id) { 
        try {
            Connection con = conexion.getConexion();
            String query = "SELECT registro.id, registro.fecha, doctores.nombre AS nombre_doctor, pacientes.nombre AS nombre_paciente, enfermeros.nombre AS nombre_enfermero FROM registro LEFT JOIN doctores ON registro.id_doctor = doctores.id_doctor LEFT JOIN pacientes ON registro.id_paciente = pacientes.id_paciente LEFT JOIN enfermeros ON registro.id_enfermero = enfermeros.id_enfermero WHERE registro.id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                this.fecha = rs.getDate("fecha");
                this.nombre_doctor = rs.getString("nombre_doctor");
                this.nombre_paciente = rs.getString("nombre_paciente");
                this.nombre_enfermero = rs.getString("nombre_enfermero");
            }else{
                System.out.println("No se encontraron registros");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        
    }

    // obtener detalles asociados al registro
    public void obtenerDetalles() {
        // de la tabla detalle_registro obtener los registros asociados al id de registro
        ArrayList<Integer> ids_detalle = new ArrayList<>();
        try {
            Connection con = conexion.getConexion();
            String query = "SELECT id_detalle_registro FROM detalle_registro WHERE id_registro = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, this.id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ids_detalle.add(rs.getInt("id_detalle_registro"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        // crear objetos de tipo DetalleRegistro
        for (Integer id_detalle : ids_detalle) {
            DetalleRegistro detalle = new DetalleRegistro(id_detalle);
            this.detalles_registro.add(detalle);
        }

    }
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_doctor() {
        return nombre_doctor;
    }

    public void setNombre_doctor(String nombre_doctor) {
        this.nombre_doctor = nombre_doctor;
    }

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public String getNombre_enfermero() {
        return nombre_enfermero;
    }

    public void setNombre_enfermero(String nombre_enfermero) {
        this.nombre_enfermero = nombre_enfermero;
    }

    public ArrayList<DetalleRegistro> getDetalles_registro() {
        return detalles_registro;
    }

    public void setDetalles_registro(ArrayList<DetalleRegistro> detalles_registro) {
        this.detalles_registro = detalles_registro;
    }
    
    public void imprimir() throws FileNotFoundException, MalformedURLException{
        // Obtiene el directorio de descargas del usuario actual
        
        String nombrePaciente = this.nombre_paciente.replaceAll(" ", "_");
        // fecha en formato dd/mm/yyyy
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String fechaF = sdf.format(this.fecha);

        String nombreArchivo = nombrePaciente + "_" + fechaF + ".pdf";
        File directorio = new File(System.getProperty("user.home") + "\\Downloads"); // Directorio de descargas
        File file = new File(directorio, nombreArchivo);
        
        String path = file.getAbsolutePath();
        try{
            PdfWriter pdfWriter = new PdfWriter(path);
            // Crea un objeto PdfDocument
            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
            pdfDocument.setDefaultPageSize(PageSize.A4);

            Document document = new Document(pdfDocument);
            // document.add(new Paragraph("Registro: " + this.id.toString()));
            // document.add(new Paragraph("Fecha: " + this.fecha.toString()));
            // document.add(new Paragraph("Paciente: " + this.nombre_paciente));
            // document.add(new Paragraph("Doctor: " + this.nombre_doctor));
            // document.add(new Paragraph("Enfermero: " + this.nombre_enfermero));
            // document.add(new Paragraph("Detalles: "));
            
            float forCol = 148f;
            float treecol= 190f;
            float twocol= 285f;
            float twocol150 = twocol + 150f;
            float twocolumWidth[] = {twocol150, twocol};
            float fullwidth[] = {forCol*4};

            Paragraph onesp = new Paragraph("\n");
            // Crear tabla
            Table table = new Table(twocolumWidth);
               
            // Load the logo image
            try {
                Image logo = new Image(ImageDataFactory.create(getClass().getResource("/images/IH-LOGO-11c.png").toExternalForm()));
                logo.scaleToFit(90f, 90f);
                // agregar logo a esquina superior izquierda del documento
                table.addCell(new Cell().add(logo).setBorder(Border.NO_BORDER).setPadding(0f));
            } catch (com.itextpdf.io.IOException e) {
            }         

            Table nestedTable = new Table(new float[]{twocol/2, twocol/2}).setFontSize(14f);
            nestedTable.addCell(getTextCell("Registro No: "));
            nestedTable.addCell(getTextCellValue(this.id.toString()));

            sdf = new SimpleDateFormat("dd/MM/yyyy");
            fechaF = sdf.format(this.fecha);
            nestedTable.addCell(getTextCell("Fecha Registro: "));
            nestedTable.addCell(getTextCellValue(fechaF));
            table.addCell(new Cell().add(nestedTable).setBorder(Border.NO_BORDER));
            document.add(table);

            Border grayBorder = new SolidBorder(Color.GRAY,2f);
            Table divider = new Table(fullwidth);
            divider.setBorder(grayBorder);
            document.add(divider);
            document.add(onesp);

            float infoWidth[] = {twocol-100f, twocol+300f};
            // Datos del paciente
            Table tablep = new Table(infoWidth);
            tablep.addCell(new Cell().add("Datos del Paciente").setBorder(Border.NO_BORDER).setBold().setFontSize(12f));
            nestedTable = new Table(new float[]{twocol-100f/2, twocol+100f/2}).setFontSize(12f);
            nestedTable.addCell(getTextCell("Nombre: "));
            nestedTable.addCell(getTextCellValue(this.nombre_paciente));
            tablep.addCell(new Cell().add(nestedTable).setBorder(Border.NO_BORDER));
            document.add(tablep);
            document.add(onesp);

            // Datos del doctor
            Table tabled = new Table(infoWidth);
            tabled.addCell(new Cell().add("Datos del Doctor").setBorder(Border.NO_BORDER).setBold().setFontSize(12f));
            nestedTable = new Table(new float[]{twocol-100f/2, twocol+100f/2}).setFontSize(12f);
            nestedTable.addCell(getTextCell("Nombre: "));
            nestedTable.addCell(getTextCellValue(this.nombre_doctor));
            tabled.addCell(new Cell().add(nestedTable).setBorder(Border.NO_BORDER));
            document.add(tabled);
            document.add(onesp);

            // Datos del enfermero
            Table tablee = new Table(infoWidth);
            tablee.addCell(new Cell().add("Datos del Enfermero").setBorder(Border.NO_BORDER).setBold().setFontSize(12f));
            nestedTable = new Table(new float[]{twocol-100f/2, twocol+100f/2}).setFontSize(12f);
            nestedTable.addCell(getTextCell("Nombre: "));
            nestedTable.addCell(getTextCellValue(this.nombre_enfermero));
            tablee.addCell(new Cell().add(nestedTable).setBorder(Border.NO_BORDER));
            document.add(tablee);
            document.add(onesp);

            Table divider2 = new Table(fullwidth);
            Border grayBorder2 = new SolidBorder(Color.GRAY,1f);
            divider2.setBorder(grayBorder2);
            document.add(divider2);
            
            // Detalles
            Table tableDetalles = new Table(fullwidth);
            tableDetalles.addCell(new Cell().add("DETALLE DE MEDICAMENTOS").setBorder(Border.NO_BORDER).setBold().setFontSize(18f).setTextAlignment(TextAlignment.CENTER));
            document.add(tableDetalles);
            
            // Crear tabla cantidad - nombre_medicamento - generico - categoria
            Table tableDetalles2 = new Table(new float[]{60f, 200f, 150f, 200f}).setFontSize(11);
            tableDetalles2.addCell(new Cell().add("Cantidad").setBold().setTextAlignment(TextAlignment.CENTER).setBackgroundColor(Color.BLACK, 0.7f).setFontColor(Color.WHITE));
            tableDetalles2.addCell(new Cell().add("Nombre Medicamento").setBold().setTextAlignment(TextAlignment.CENTER).setBackgroundColor(Color.BLACK, 0.7f).setFontColor(Color.WHITE));
            tableDetalles2.addCell(new Cell().add("Genérico").setBold().setTextAlignment(TextAlignment.CENTER).setBackgroundColor(Color.BLACK, 0.7f).setFontColor(Color.WHITE));
            tableDetalles2.addCell(new Cell().add("Categoria").setBold().setTextAlignment(TextAlignment.CENTER).setBackgroundColor(Color.BLACK, 0.7f).setFontColor(Color.WHITE));
            
            for (DetalleRegistro detalle : this.detalles_registro) {
                double cantidad = detalle.getCantidad();
                String cantidadStr = "";
                // si la cantidad no tiene decimales, se muestra como entero
                if (cantidad % 1 == 0) {
                    cantidadStr = String.valueOf((int) cantidad);
                } else {
                    cantidadStr = String.valueOf(cantidad);
                }

                tableDetalles2.addCell(new Cell().add(cantidadStr).setTextAlignment(TextAlignment.CENTER));
                tableDetalles2.addCell(new Cell().add(detalle.getNombre_medicamento()).setTextAlignment(TextAlignment.LEFT));
                tableDetalles2.addCell(new Cell().add(detalle.getGenerico()).setTextAlignment(TextAlignment.LEFT));
                tableDetalles2.addCell(new Cell().add(detalle.getCategoria()).setTextAlignment(TextAlignment.LEFT));
            }
            
            document.add(tableDetalles2);
            document.add(onesp);
            document.add(divider2);
            document.add(onesp);
            document.add(onesp);
            
            // Agregar apartado de firma
            Table tableFirma = new Table(twocolumWidth);
            tableFirma.addCell(new Cell().add("Firma :").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
            tableFirma.addCell(new Cell().add(" ______________________________").setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT));
            document.add(tableFirma);
            document.add(onesp);


            document.add(divider);

            // Cerrar el documento
            document.close();

        
        }catch(FileNotFoundException   e){
            JOptionPane.showMessageDialog(null, "Error al crear el pdf: " + e); 
            return;
        }

        try{
            // Abrir el archivo
            java.awt.Desktop.getDesktop().open(file);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error al abrir el archivo: " + e);
        }
        
    }

    static Cell getTextCell(String text){
        return new Cell().add(text).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT);
    }

    static Cell getTextCellValue(String text){
        return new Cell().add(text).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
    }


}


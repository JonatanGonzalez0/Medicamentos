/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author pcnew
 */
public class DetalleRegistro {
    public Integer id;
    public String nombre_medicamento;
    public String categoria;
    public String generico;
    public Double cantidad;

    public DetalleRegistro(Integer id) {
        this.id = id;
        obtenerDatos(id);
    }
    
    private void obtenerDatos(Integer id) {
        // SELECT detalle_registro.id_detalle_registro, medicamentos.nombre AS nombre_medicamento, medicamentos.categoria, medicamentos.generico, detalle_registro.cantidad FROM detalle_registro LEFT JOIN medicamentos ON detalle_registro.id_medicamento = medicamentos.id WHERE detalle_registro.id_registro = ?;
        try {
            Connection con = conexion.getConexion();
            String query = "SELECT medicamentos.nombre AS nombre_medicamento, medicamentos.categoria, medicamentos.generico, detalle_registro.cantidad FROM detalle_registro LEFT JOIN medicamentos ON detalle_registro.id_medicamento = medicamentos.id WHERE detalle_registro.id_detalle_registro = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                this.nombre_medicamento = rs.getString("nombre_medicamento");
                this.categoria = rs.getString("categoria");
                this.generico = rs.getString("generico");
                this.cantidad = rs.getDouble("cantidad");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_medicamento() {
        return nombre_medicamento;
    }

    public void setNombre_medicamento(String nombre_medicamento) {
        this.nombre_medicamento = nombre_medicamento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getGenerico() {
        return generico;
    }

    public void setGenerico(String generico) {
        this.generico = generico;
    }

    public Double getCantidad() {
        
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }
    
}

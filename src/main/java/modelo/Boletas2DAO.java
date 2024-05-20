/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
    import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import controlador.Boletas2;
/**
 *
 * @author Joseg
 */
public class Boletas2DAO {

    private static final String SQL_INSERT = "INSERT INTO boletas2(codigo_boleta, codigo_maestro, Jornada, seccion, semestre, año) VALUES(?, ?, ?, ?, ?, ?)";

    public int insert(Boletas2 boleta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, boleta.getCodigoBoleta());
            stmt.setString(2, boleta.getCodigoMaestro());
            stmt.setString(3, boleta.getJornada());
            stmt.setString(4, boleta.getSeccion()); 
            stmt.setString(5, boleta.getSemestre());
            stmt.setString(6, boleta.getAño());
            System.out.println("Ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}


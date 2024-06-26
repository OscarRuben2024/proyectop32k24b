package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import controlador.Boletas;
import java.sql.ResultSet;

public class BoletasDAO {

    private static final String SQL_INSERT = "INSERT INTO boletas(codigo_boleta, codigo_maestro, tipo_de_pago, semestre, año, mes) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_QUERY = "SELECT codigo_boleta, codigo_maestro, tipo_de_pago, semestre, año, mes FROM boletas WHERE codigo_boleta = ?";

    public int insert(Boletas boleta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, boleta.getCodigoBoleta());
            stmt.setString(2, boleta.getCodigoMaestro());
            stmt.setString(3, boleta.getTipoDePago());
            stmt.setString(4, boleta.getSemestre());
            stmt.setString(5, boleta.getAño());
            stmt.setString(6, boleta.getMes());
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
    
    public Boletas query(Boletas boleta) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, boleta.getCodigoBoleta());
            rs = stmt.executeQuery();
            if (rs.next()) {
                boleta.setTipoDePago(rs.getString("tipo_de_pago"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return boleta;
    }
}

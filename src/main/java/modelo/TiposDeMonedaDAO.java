/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import controlador.TiposDeMoneda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Kevin
 */
public class TiposDeMonedaDAO {

    private static final String SQL_SELECT = "SELECT id_moneda, nombre_moneda FROM TiposDeMoneda";
    private static final String SQL_INSERT = "INSERT INTO TiposDeMoneda(id_moneda, nombre_moneda) VALUES(?,?)";
    private static final String SQL_UPDATE = "UPDATE TiposDeMoneda SET nombre_moneda=? WHERE id_moneda = ?";
    private static final String SQL_DELETE = "DELETE FROM TiposDeMoneda WHERE id_moneda=?";
    private static final String SQL_QUERY = "SELECT id_moneda, nombre_moneda FROM TiposDeMoneda WHERE id_moneda = ?";

    public List<TiposDeMoneda> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TiposDeMoneda tipoMoneda = null;
        List<TiposDeMoneda> TiposDeMoneda = new ArrayList<TiposDeMoneda>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_moneda");
                String nombre = rs.getString("nombre_moneda");

                tipoMoneda = new TiposDeMoneda();
                tipoMoneda.setIdMoneda(id);
                tipoMoneda.setNombreMoneda(nombre);
                TiposDeMoneda.add(tipoMoneda);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return TiposDeMoneda;
    }

    public int insert(TiposDeMoneda tipoMoneda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt   (1, tipoMoneda.getIdMoneda());
            stmt.setString(2, tipoMoneda.getNombreMoneda());
            System.out.println("ejecutando query:" + SQL_INSERT);
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

    public int update(TiposDeMoneda tipoMoneda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, tipoMoneda.getNombreMoneda());
            stmt.setInt(2, tipoMoneda.getIdMoneda());
            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int delete(TiposDeMoneda tipoMoneda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, tipoMoneda.getIdMoneda());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public TiposDeMoneda query(TiposDeMoneda tipoMoneda) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, tipoMoneda.getIdMoneda());
            rs = stmt.executeQuery();
            if (rs.next()) {
                tipoMoneda.setNombreMoneda(rs.getString("nombre_moneda"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return tipoMoneda;
    }
}

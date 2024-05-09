package modelo;

import controlador.Bancos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BancosDAO {

private static final String SQL_SELECT = "SELECT id_banco, nombre_banco, estatus_legal, direccion_principal FROM bancos";
private static final String SQL_INSERT = "INSERT INTO bancos(nombre_banco, estatus_legal, direccion_principal) VALUES(?, ?, ?)";
private static final String SQL_UPDATE = "UPDATE bancos SET nombre_banco=?, estatus_legal=?, direccion_principal=? WHERE id_banco = ?";
private static final String SQL_DELETE = "DELETE FROM bancos WHERE id_banco = ?;";
private static final String SQL_QUERY = "SELECT id_banco, nombre_banco, estatus_legal, direccion_principal FROM bancos WHERE id_banco = ?";


    public List<Bancos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Bancos banco = null;
        List<Bancos> bancos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id_banco");
                String nombre = rs.getString("nombre_banco");
                String estatusLegal = rs.getString("estatus_legal");
                String direccionPrincipal = rs.getString("direccion_principal");

                banco = new Bancos();
                banco.setIdBanco(id);
                banco.setNombreBanco(nombre);
                banco.setEstatusLegal(estatusLegal);
                banco.setDireccionPrincipal(direccionPrincipal);

                bancos.add(banco);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return bancos;
    }

    public int insert(Bancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, banco.getNombreBanco());
            stmt.setString(2, banco.getEstatusLegal());
            stmt.setString(3, banco.getDireccionPrincipal());
            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

    public int update(Bancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, banco.getNombreBanco());
            stmt.setString(2, banco.getEstatusLegal());
            stmt.setString(3, banco.getDireccionPrincipal());
            stmt.setString(4, banco.getIdBanco());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }

        return rows;
    }

public int delete(Bancos banco) {
    Connection conn = null;
    PreparedStatement stmt = null;
    int rows = 0;

    try {
        conn = Conexion.getConnection();
        stmt = conn.prepareStatement(SQL_DELETE);
        stmt.setString(1, banco.getIdBanco());
        rows = stmt.executeUpdate();
        System.out.println("Registro eliminado exitosamente");
    } catch (SQLException ex) {
        ex.printStackTrace(System.out);
        System.out.println("Error al eliminar el registro: " + ex.getMessage());
    } finally {
        Conexion.close(stmt);
        Conexion.close(conn);
    }

    return rows;
}


    public Bancos query(Bancos banco) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, banco.getIdBanco());
            rs = stmt.executeQuery();
            if (rs.next()) {
                String id = rs.getString("id_banco");
                String nombre = rs.getString("nombre_banco");
                String estatusLegal = rs.getString("estatus_legal");
                String direccionPrincipal = rs.getString("direccion_principal");

                banco = new Bancos();
                banco.setIdBanco(id);
                banco.setNombreBanco(nombre);
                banco.setEstatusLegal(estatusLegal);
                banco.setDireccionPrincipal(direccionPrincipal);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return banco;
    }
}
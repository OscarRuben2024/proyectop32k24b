/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import controlador.ProcesosTiposPagosCursos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Joseg
 */
public class ProcesosTiposPagosCursosDAO {
     private static final String SQL_SELECT = "SELECT proceso_idpago_curso, proceso_codigo_curso FROM ProcesosTiposPagosCursos";
     private static final String SQL_INSERT = "INSERT INTO ProcesosTiposPagosCursos(proceso_idpago_curso,proceso_codigo_curso) VALUES(?, ?)";
     private static final String SQL_UPDATE = "UPDATE ProcesosTiposPagosCursos SET proceso_codigo_curso=? WHERE proceso_idpago_curso = ?";
     private static final String SQL_DELETE = "DELETE FROM ProcesosTiposPagosCursos WHERE proceso_idpago_curso=?";
     private static final String SQL_QUERY = "SELECT proceso_idpago_curso, proceso_codigo_curso FROM ProcesosTiposPagosCursos WHERE proceso_idpago_curso = ?";
     
     public List<ProcesosTiposPagosCursos> select(){
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         ProcesosTiposPagosCursos procesotipopagocurso = null;
         List<ProcesosTiposPagosCursos> procesotipopagocursos = new ArrayList<>();
         
         try {
             conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                String idpago = rs.getString("proceso_idpago_curso");
                String codigomaestro = rs.getString("proceso_codigo_curso");
                
                procesotipopagocurso = new ProcesosTiposPagosCursos();
                procesotipopagocurso.setProcesoIDPagoCurso(idpago);
                procesotipopagocurso.setProcesoCodigoCurso(codigomaestro);
                
                procesotipopagocursos.add(procesotipopagocurso);
            }
         } catch (SQLException ex){
             ex.printStackTrace(System.out);
         } finally {
             Conexion.close(rs);
             Conexion.close(stmt);
             Conexion.close(conn);
             
         }
         
         return procesotipopagocursos;
     }
     
     public int insert(ProcesosTiposPagosCursos procesotipopagocurso){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, procesotipopagocurso.getProcesoIDPagoCurso());
            stmt.setString(2, procesotipopagocurso.getProcesoCodigoCurso());
            System.out.println("ejecución query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
     }
     
     public int update(ProcesosTiposPagosCursos procesotipopagocurso){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
           conn = Conexion.getConnection();
           stmt = conn.prepareStatement(SQL_UPDATE);
           stmt.setString(1, procesotipopagocurso.getProcesoIDPagoCurso());
           stmt.setString(2, procesotipopagocurso.getProcesoCodigoCurso());
           
           rows = stmt.executeUpdate();
           System.out.println("Registros actualizados");
        }catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
     }
        return rows;
    }
     public int delete (ProcesosTiposPagosCursos procesotipopagocurso){
         Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn =Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, procesotipopagocurso.getProcesoIDPagoCurso());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados");
        } catch (SQLException ex){
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
     return rows;
     }  
     
     public ProcesosTiposPagosCursos query(ProcesosTiposPagosCursos procesotipopagocurso){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, procesotipopagocurso.getProcesoIDPagoCurso());
            rs = stmt.executeQuery();
            if (rs.next()) {
                String idpago = rs.getString("proceso_id_tipo_pago");
                String codigomaestro = rs.getString("proceso_codigo_maestro");
                
                procesotipopagocurso = new ProcesosTiposPagosCursos();
                procesotipopagocurso.setProcesoIDPagoCurso(idpago);
                procesotipopagocurso.setProcesoCodigoCurso(codigomaestro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return procesotipopagocurso;
     }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import controlador.ProcesosTiposPagosMaestros;
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
public class ProcesosTiposPagosMaestrosDAO {
     private static final String SQL_SELECT = "SELECT proceso_id_tipo_pago, proceso_codigo_maestro FROM ProcesosTiposPagosMaestros";
     private static final String SQL_INSERT = "INSERT INTO ProcesosTiposPagosMaestros(proceso_id_tipo_pago,proceso_codigo_maestro) VALUES(?, ?)";
     private static final String SQL_UPDATE = "UPDATE ProcesosTiposPagosMaestros SET proceso_codigo_maestro=? WHERE proceso_id_tipo_pago = ?";
     private static final String SQL_DELETE = "DELETE FROM ProcesosTiposPagosMaestros WHERE proceso_id_tipo_pago=?";
     private static final String SQL_QUERY = "SELECT proceso_id_tipo_pago, proceso_codigo_maestro FROM ProcesosTiposPagosMaestros WHERE proceso_id_tipo_pago = ?";
     
     public List<ProcesosTiposPagosMaestros> select(){
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         ProcesosTiposPagosMaestros procesotipopagomaestro = null;
         List<ProcesosTiposPagosMaestros> procesotipopagomaestros = new ArrayList<>();
         
         try {
             conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()){
                String idpago = rs.getString("proceso_id_tipo_pago");
                String codigomaestro = rs.getString("proceso_codigo_maestro");
                
                procesotipopagomaestro = new ProcesosTiposPagosMaestros();
                procesotipopagomaestro.setProcesoIDPago(idpago);
                procesotipopagomaestro.setProcesoCodigoMaestro(codigomaestro);
                
                procesotipopagomaestros.add(procesotipopagomaestro);
            }
         } catch (SQLException ex){
             ex.printStackTrace(System.out);
         } finally {
             Conexion.close(rs);
             Conexion.close(stmt);
             Conexion.close(conn);
             
         }
         
         return procesotipopagomaestros;
     }
     
     public int insert(ProcesosTiposPagosMaestros procesotipopagomaestro){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, procesotipopagomaestro.getProcesoIDPago());
            stmt.setString(2, procesotipopagomaestro.getProcesoCodigoMaestro());
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
     
     public int update(ProcesosTiposPagosMaestros procesotipopagomaestro){
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try{
           conn = Conexion.getConnection();
           stmt = conn.prepareStatement(SQL_UPDATE);
           stmt.setString(1, procesotipopagomaestro.getProcesoIDPago());
           stmt.setString(2, procesotipopagomaestro.getProcesoCodigoMaestro());
           
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
     public int delete (ProcesosTiposPagosMaestros procesotipopagomaestro){
         Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        
        try {
            conn =Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setString(1, procesotipopagomaestro.getProcesoIDPago());
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
     
     public ProcesosTiposPagosMaestros query(ProcesosTiposPagosMaestros procesotipopagomaestro){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setString(1, procesotipopagomaestro.getProcesoIDPago());
            rs = stmt.executeQuery();
            if (rs.next()) {
                String idpago = rs.getString("proceso_id_tipo_pago");
                String codigomaestro = rs.getString("proceso_codigo_maestro");
                
                procesotipopagomaestro = new ProcesosTiposPagosMaestros();
                procesotipopagomaestro.setProcesoIDPago(idpago);
                procesotipopagomaestro.setProcesoCodigoMaestro(codigomaestro);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return procesotipopagomaestro;
     }
}

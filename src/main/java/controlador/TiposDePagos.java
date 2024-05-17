/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Joseg
 */
public class TiposDePagos {

    private String id_tipo_pago;
    private String nombre_tipo_pago; 
    private String cantidad_tipo_pago;
   

    public TiposDePagos() {
    }

    public TiposDePagos(String id_tipo_pago, String nombre_tipo_pago, String cantidad_tipo_pago) {
        this.id_tipo_pago = id_tipo_pago;
        this.nombre_tipo_pago = nombre_tipo_pago;
        this.cantidad_tipo_pago = cantidad_tipo_pago;
      
    }

    public String getIdTipoPago() {
        return id_tipo_pago;
    }

    public void setIdTipoPago(String id_tipo_pago) {
        this.id_tipo_pago = id_tipo_pago;
    }

    public String getNombrePago() {
        return nombre_tipo_pago;
    }

    public void setNombrePago(String nombre_tipo_pago) {
        this.nombre_tipo_pago = nombre_tipo_pago;
    }
    public String getcantidadPago() {
        return cantidad_tipo_pago;
    }
    public void setcantidadPago(String cantidad_tipo_pago){
        this.cantidad_tipo_pago = cantidad_tipo_pago;
    }

    @Override
    public String toString() {
        return "TiposDePagos{" + "id_tipo_pago=" + id_tipo_pago + ", nombre_tipo_pago='" + nombre_tipo_pago + ", cantidad_tipo_pago='"+ cantidad_tipo_pago +'}';
    }  
}

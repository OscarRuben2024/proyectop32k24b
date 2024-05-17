/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Joseg
 */
public class ProcesosTiposPagosMaestros {
    private String proceso_id_tipo_pago;
    private String proceso_codigo_maestro;
    

    

public ProcesosTiposPagosMaestros(){
}

public ProcesosTiposPagosMaestros(String proceso_id_tipo_pago, String proceso_codigo_maestro){
    this.proceso_id_tipo_pago = proceso_id_tipo_pago;
    this.proceso_codigo_maestro = proceso_codigo_maestro;
}
 public String getProcesoIDPago(){
    return proceso_id_tipo_pago;
}
 public void setProcesoIDPago(String proceso_id_tipo_pago){
     this.proceso_id_tipo_pago = proceso_id_tipo_pago;
 }
 public String getProcesoCodigoMaestro(){
     return proceso_codigo_maestro;
 }
 public void setProcesoCodigoMaestro(String proceso_codigo_maestro){
     this.proceso_codigo_maestro = proceso_codigo_maestro;
 }
  @Override
  public String toString(){
      return "ProcesosTiposPagosMaestros{" + "proceso_id_tipo_pago=" + proceso_id_tipo_pago + ", proceso_codigo_maestro='" + proceso_codigo_maestro + '}';
  }
}






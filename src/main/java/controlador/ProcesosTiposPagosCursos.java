/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Joseg
 */
public class ProcesosTiposPagosCursos {
    private String proceso_idpago_curso;
    private String proceso_codigo_curso;
    
    
public ProcesosTiposPagosCursos(){
}

public ProcesosTiposPagosCursos(String proceso_idpago_curso, String proceso_codigo_curso){
    this.proceso_idpago_curso = proceso_idpago_curso;
    this.proceso_codigo_curso = proceso_codigo_curso;
}
    public String getProcesoIDPagoCurso(){
        return proceso_idpago_curso;
    }
    public void setProcesoIDPagoCurso(String proceso_idpago_curso){
        this.proceso_idpago_curso = proceso_idpago_curso;
    }
    public String getProcesoCodigoCurso(){
        return proceso_codigo_curso;
    }
    public void setProcesoCodigoCurso(String proceso_codigo_curso){
        this.proceso_codigo_curso = proceso_codigo_curso;
    }
    @Override
    public String toString(){
        return "ProcesosTiposPagosCursos{" + "proceso_idpago_curso=" + proceso_idpago_curso + ", proceso_codigo_curso'" + proceso_codigo_curso + '}';
    }
    
}

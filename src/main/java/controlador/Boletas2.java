/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Joseg
 */
public class Boletas2 {
    private String codigo_boleta;
    private String codigo_maestro;
    private String jornada;
    private String seccion;
    private String semestre;
    private String año;

    public Boletas2(String codigo_boleta, String codigo_maestro, String jornada,String seccion , String semestre, String año) {
        this.codigo_boleta = codigo_boleta;
        this.codigo_maestro = codigo_maestro;
        this.jornada = jornada;
        this.seccion = seccion;
        this.semestre = semestre;
        this.año = año;
    }

    // Getters y setters
    public String getCodigoBoleta() {
        return codigo_boleta;
    }

    public void setCodigoBoleta(String codigo_boleta) {
        this.codigo_boleta = codigo_boleta;
    }

    public String getCodigoMaestro() {
        return codigo_maestro;
    }

    public void setCodigoMaestro(String codigo_maestro) {
        this.codigo_maestro = codigo_maestro;
    }

    public String getJornada() {
        return jornada;
    }

    public void setJornada(String jornada) {
        this.jornada = jornada;
    }
    public String getSeccion(){
        return seccion;
    }
    public void setSeccion(String seccion){
        this.seccion = seccion;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    @Override
    public String toString(){
        return "Boletas {" + "codigo_boleta=" + codigo_boleta + ", codigo_maestro=" + codigo_maestro + ", jornada=" + jornada + "seccion="+ seccion + ", semestre= " + semestre + ", año= " + año + '}';
    }
}

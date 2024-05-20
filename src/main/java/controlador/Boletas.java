package controlador;

public class Boletas {
    private String codigoBoleta;
    private String codigoMaestro;
    private String tipoDePago;
    private String semestre;
    private String año;
    private String mes;

    public Boletas(String codigoBoleta, String codigoMaestro, String tipoDePago, String semestre, String año, String mes) {
        this.codigoBoleta = codigoBoleta;
        this.codigoMaestro = codigoMaestro;
        this.tipoDePago = tipoDePago;
        this.semestre = semestre;
        this.año = año;
        this.mes = mes;
    }

    // Getters y setters
    public String getCodigoBoleta() {
        return codigoBoleta;
    }

    public void setCodigoBoleta(String codigoBoleta) {
        this.codigoBoleta = codigoBoleta;
    }

    public String getCodigoMaestro() {
        return codigoMaestro;
    }

    public void setCodigoMaestro(String codigoMaestro) {
        this.codigoMaestro = codigoMaestro;
    }

    public String getTipoDePago() {
        return tipoDePago;
    }

    public void setTipoDePago(String tipoDePago) {
        this.tipoDePago = tipoDePago;
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

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
}
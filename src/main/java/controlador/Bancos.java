package controlador;

public class Bancos {
    private String idBanco;
    private String nombreBanco;
    private String estatusLegal;
    private String direccionPrincipal;

    public Bancos() {
    }

    public Bancos(String idBanco, String nombreBanco, String estatusLegal, String direccionPrincipal) {
        this.idBanco = idBanco;
        this.nombreBanco = nombreBanco;
        this.estatusLegal = estatusLegal;
        this.direccionPrincipal = direccionPrincipal;
    }

    public String getIdBanco() {
        return idBanco;
    }

    public void setIdBanco(String idBanco) {
        this.idBanco = idBanco;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getEstatusLegal() {
        return estatusLegal;
    }

    public void setEstatusLegal(String estatusLegal) {
        this.estatusLegal = estatusLegal;
    }

    public String getDireccionPrincipal() {
        return direccionPrincipal;
    }

    public void setDireccionPrincipal(String direccionPrincipal) {
        this.direccionPrincipal = direccionPrincipal;
    }

    @Override
    public String toString() {
        return "Bancos{" +
                "idBanco='" + idBanco + '\'' +
                ", nombreBanco='" + nombreBanco + '\'' +
                ", estatusLegal='" + estatusLegal + '\'' +
                ", direccionPrincipal='" + direccionPrincipal + '\'' +
                '}';
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author Kevin
 */
public class TiposDeMoneda {

    private int id_moneda;
    private String nombre_moneda;

    public TiposDeMoneda() {
    }

    public TiposDeMoneda(int id_moneda, String nombre_moneda) {
        this.id_moneda = id_moneda;
        this.nombre_moneda = nombre_moneda;
    }

    public int getIdMoneda() {
        return id_moneda;
    }

    public void setIdMoneda(int id_moneda) {
        this.id_moneda = id_moneda;
    }

    public String getNombreMoneda() {
        return nombre_moneda;
    }

    public void setNombreMoneda(String nombre_moneda) {
        this.nombre_moneda = nombre_moneda;
    }

    @Override
    public String toString() {
        return "TiposDeMoneda{" + "id_moneda=" + id_moneda + ", nombre_moneda=" + nombre_moneda + '}';
    }
}

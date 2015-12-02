/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Luis Lavado
 */
public class Compra {

    private String id_compra;
    private String fecha;
    private String serie_fac;
    private String subtotal;
    private String descuento;
    private String igv;
    private String total;
    private String id_persona;

    public Compra() {
    }

    public Compra(String id_compra, String fecha, String serie_fac, String subtotal, String descuento, String igv, String total, String id_persona) {
        this.id_compra = id_compra;
        this.fecha = fecha;
        this.serie_fac = serie_fac;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.igv = igv;
        this.total = total;
        this.id_persona = id_persona;
    }

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public String getId_compra() {
        return id_compra;
    }

    public void setId_compra(String id_compra) {
        this.id_compra = id_compra;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSerie_fac() {
        return serie_fac;
    }

    public void setSerie_fac(String serie_fac) {
        this.serie_fac = serie_fac;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getDescuento() {
        return descuento;
    }

    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

    public String getIgv() {
        return igv;
    }

    public void setIgv(String igv) {
        this.igv = igv;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
}

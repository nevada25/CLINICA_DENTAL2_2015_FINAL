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
public class Producto {

    private String id_producto;
    private String id_unidad_medida;
    private String nombre_producto; 

    public Producto() {
    }

    public Producto(String id_producto, String id_unidad_medida, String nombre_producto) {
        this.id_producto = id_producto;
        this.id_unidad_medida = id_unidad_medida;
        this.nombre_producto = nombre_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getId_unidad_medida() {
        return id_unidad_medida;
    }

    public void setId_unidad_medida(String id_unidad_medida) {
        this.id_unidad_medida = id_unidad_medida;
    }
   
    
}

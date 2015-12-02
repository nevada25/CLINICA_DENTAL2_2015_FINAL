/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Producto;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface ProductoDao {
    public boolean  agregarProducto(Producto producto);
    public List<Producto> mostrarProducto();
    public List<Producto> mostrarproductosaedidar(String buscar, String limit);
    public boolean actualizarProducto(Producto producto);
    public boolean eliminarProducto(int idProducto);
}

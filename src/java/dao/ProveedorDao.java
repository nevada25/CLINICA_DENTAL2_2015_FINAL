/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Proveedor;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface ProveedorDao {
     public boolean  agregaruProveedor(Proveedor proveedor);
    public List<Proveedor> mostrarProveedor();
    public boolean actualizarProveedor(Proveedor proveedor);
    public boolean eliminarProveedor(int proveedor);
}

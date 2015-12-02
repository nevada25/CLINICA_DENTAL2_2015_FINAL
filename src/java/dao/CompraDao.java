/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Compra;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface CompraDao {
    public boolean  agregarCompra(Compra compra);
    public List<Compra> mostrarCompra();
    public boolean actualizarCompra(Compra compra);
    public boolean eliminarCompra(int id_compra);
}

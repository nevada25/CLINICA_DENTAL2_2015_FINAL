/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Cliente;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface ClienteDao {
    public boolean agregarcliente(Cliente cliente);
    public List<Cliente> listarclientes();
    public List<Cliente> listarclientesfecha(String fecha_ini, String fecha_fin);
    List<Cliente> buscarclientes(String buscar ,String limit);
    public boolean updatecliente(Cliente cliente);
    public boolean deletecliente(int id_cliente);
}

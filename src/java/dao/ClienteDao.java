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
    List<Cliente> listarclientes();
    public boolean updatecliente(Cliente cliente);
    public boolean deletecliente(int id_cliente);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Contrato;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface ContratoDao {
    public boolean  agregarContrato(Contrato contrato);
    public List<Contrato> mostrarContrato();
    public boolean actualizarContrato(Contrato contrato);
    public boolean eliminarContrato(int id_contrato);
}

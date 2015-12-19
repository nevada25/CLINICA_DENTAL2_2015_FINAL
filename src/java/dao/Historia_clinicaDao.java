/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Historia_clinica;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface Historia_clinicaDao {
    public int fn_crud_historia_clinica(Historia_clinica historia_clinica, int opcion);
    public List<Historia_clinica> listarHistCli(String id_hist_cli);
    public Historia_clinica buscardatos(int id_cliente);
    public List<Historia_clinica> listarHistCla(int id_cliente);
}

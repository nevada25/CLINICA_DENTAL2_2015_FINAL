/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Laboratorios_externos;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface Laboratorios_externosDao {
     public boolean  agregarLaboratoriosExternos(Laboratorios_externos laboratoriosExternos);
    public List<Laboratorios_externos> mostrarLaboratoriosExternos();
    public boolean actualizarLaboratoriosExternos(Laboratorios_externos laboratoriosExternos);
    public boolean eliminarLaboratoriosExternos(int laboratoriosExternos);
}

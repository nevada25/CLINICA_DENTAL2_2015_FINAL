/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Diagnostico_def;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface Diagnostico_defDao {
    public boolean  agregardiagnosticoDef(Diagnostico_def diagnosticoDef);
    public List<Diagnostico_def> mostrardiagnosticoDef();
    public boolean actualizardiagnosticoDef(Diagnostico_def diagnosticoDef);
    public boolean eliminardiagnosticoDef(int id_diagnosticoDef);
}

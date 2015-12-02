/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Diagnostico_pre;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface Diagnostico_preDao {
    public boolean  agregarDiagnosticoPre(Diagnostico_pre diagnosticoPre);
    public List<Diagnostico_pre> mostrarDiagnosticoPre();
    public boolean actualizarDiagnosticoPre(Diagnostico_pre diagnosticoPre);
    public boolean eliminarDiagnosticoPre(int id_diagnosticoPre);
}

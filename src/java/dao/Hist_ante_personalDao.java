/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import bean.Hist_ante_personal;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface Hist_ante_personalDao {
    public boolean  agregarHist_ante_personal(Hist_ante_personal  hist_ante_personal);
    public List<Hist_ante_personal> listarHist_ante_personal();
    public boolean actualizarHist_ante_personalDao(Hist_ante_personal hist_ante_personal);
    public boolean eliminarHist_ante_personalDao(int id_diagnosticoPre);
}

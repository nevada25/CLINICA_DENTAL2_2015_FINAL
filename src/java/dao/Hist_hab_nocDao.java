/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface Hist_hab_nocDao {
    public boolean  agregarHist_hab_nocDao(Hist_hab_nocDao hist_hab_nocDao);
    public List<Hist_hab_nocDao> mostrarHist_hab_nocDao();
    public boolean actualizarHist_hab_nocDao(Hist_hab_nocDao hist_hab_nocDao);
    public boolean eliminarHist_hab_nocDao(int hist_hab_nocDao);
}

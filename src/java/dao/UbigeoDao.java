/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Ubigeo;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface UbigeoDao {
    public boolean  agregarUbigeo(Ubigeo ubigeo);
    public List<Ubigeo> mostrarUbigeo();
    public boolean actualizarUbigeo(Ubigeo ubigeo);
    public boolean eliminarUbigeo(int ubigeo);
}

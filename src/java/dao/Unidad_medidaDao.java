/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Unidad_medida;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface Unidad_medidaDao {
    public boolean  agregaridUnidadMedida(Unidad_medida unidadMedida);
    public List<Unidad_medida> mostrarusuario();
    public boolean actualizaridUnidadMedida(Unidad_medida unidadMedida);
    public boolean eliminaridUnidadMedida(int idUnidadMedida);
}

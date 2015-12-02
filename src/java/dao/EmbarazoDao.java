/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Embarazo;
import java.util.List;

public interface EmbarazoDao {
    public boolean  agregarEmbarazo(Embarazo embarazo);
    public List<Embarazo> mostrarEmbarazo();
    public boolean actualizarEmbarazo(Embarazo embarazo);
    public boolean eliminarEmbarazo(int embarazo);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Grado_instruccion;
import java.util.List;

/**
 *
 * @author Luis Lavado
 */
public interface Grado_instruccionDao {
    public boolean  agregarGradoInstruccion(Grado_instruccion gradoInstruccion);
    public List<Grado_instruccion> mostrarGradoInstruccion();
    public boolean actualizarGradoInstruccion(Grado_instruccion gradoInstruccion);
    public boolean eliminarGradoInstruccion(int gradoInstruccion);
}

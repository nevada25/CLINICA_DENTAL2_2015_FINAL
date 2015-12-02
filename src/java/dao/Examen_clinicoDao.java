package dao;

import bean.Examen_clinico;
import java.util.List;

public interface Examen_clinicoDao {
      public boolean  agregarExamenClinico(Examen_clinico examenClinico);
    public List<Examen_clinico> mostrarExamenClinico();
    public boolean actualizarExamenClinico(Examen_clinico examenClinico);
    public boolean eliminarExamenClinico(int id_examenClinico);
}

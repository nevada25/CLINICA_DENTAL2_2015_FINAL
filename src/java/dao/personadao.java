
package dao;

import bean.Persona;
import java.util.List;

public interface personadao {
public boolean  agregarpersona(Persona person,int opcion);
public List<Persona> mostrarpersona();

public boolean  actualizarpersona(Persona persona);
public boolean  eliminarpersona(int id);
public List<Persona> mostrarpersona(String buscar,String limit);
public Persona datoper(int id);

public List<Persona> mostrarpersonas(int id);
}

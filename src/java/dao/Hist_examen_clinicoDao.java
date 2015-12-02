
package dao;


import bean.Hist_examen_clinico;
import java.util.List;

public interface Hist_examen_clinicoDao {
    public boolean  agregarhis_ex_cli(Hist_examen_clinico  his_ex_cli);
    List<Hist_examen_clinico> listarhistoria();
    public boolean actualizarhis_ex_cli(Hist_examen_clinico  his_ex_cli);
    public boolean eliminarhis_ex_cli(Hist_examen_clinico  his_ex_cli);
}

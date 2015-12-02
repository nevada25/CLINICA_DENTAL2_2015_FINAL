package dao;
import bean.Hist_diagnost_def;
import java.util.List;
public interface Hist_diagnost_defDao {
    public boolean  agregarDiagnosticoDef(Hist_diagnost_def diag_preD);
    public List<Hist_diagnost_def> mostrarDiagnosticoDef();
    public boolean actualizarDiagnosticoDef(Hist_diagnost_def diag_preD);
    public boolean eliminarDiagnosticoDef(int diagnosticoDef);
}

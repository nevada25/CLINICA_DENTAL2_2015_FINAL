
package Controlador;

import bean.Diagnostico_pre;
import bean.Hist_ante_personal;
import bean.Hist_diagnost_def;
import bean.Hist_hab_noc;
import bean.Historia_clinica;
import bean.Persona;
import dao.Diagnostico_preDao;
import dao.Hist_ante_personalDao;
import dao.Hist_diagnost_defDao;
import dao.Hist_hab_nocDao;
import dao.Historia_clinicaDao;
import dao.personadao;
import daoimpl.Diagnostico_preDaoImpl;
import daoimpl.Hist_ante_personalDaoImpl;
import daoimpl.Hist_diagnost_defDaoImpl;
import daoimpl.Hist_hab_nocDaoImpl;
import daoimpl.Historia_clinicaDaoImpl;
import daoimpl.personadaoimpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ControlClienteSVT extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 String opcion = "registrar";

    String Nombres = request.getParameter("Nombres");
    String Apepat = request.getParameter("Apepat");
    String Apemat = request.getParameter("Apemat");
    String Dni = request.getParameter("Dni");
    String Sexo = request.getParameter("Sexo");
    String Fecha_nac = request.getParameter("Fecha_nac");
    String Edad = request.getParameter("Edad");
    String Domicilio = request.getParameter("Domicilio");
    String Telefono = request.getParameter("Telefono");
    String Apoderado = request.getParameter("Apoderado");

    String hist_clinica = "1";
    String Nro_historia = request.getParameter("Nro_historia");
    String Fecha_historia = request.getParameter("Fecha_historia");
    String Mot_consulta = request.getParameter("Mot_consulta");
    String Comentario = request.getParameter("Comentario");
    String Ante_familiar = request.getParameter("Ante_familiar");
    String Peso = request.getParameter("Peso");
    String Talla = request.getParameter("Talla");
    String PA = request.getParameter("PA");
    String Especificaciones = request.getParameter("Especificaciones");
    String Observaciones = request.getParameter("Observaciones");
    String Pronostico = request.getParameter("Pronostico");

    String id_ante_personal[] = null;
    id_ante_personal = request.getParameterValues("id_ante_personal");
    if (id_ante_personal == null) {
        id_ante_personal = new String[0];
    }
    //TABLA EMBARAZO: recibe al id_hist_clinica 
    String estado_embarazada = request.getParameter("embarazo");
    String Nro_semanas = request.getParameter("Nro_semanas");
    String Ult_control = request.getParameter("Ult_control");
    String trata_farm = request.getParameter("trata_farm");
    //TABLA HABITO NOCIVO: recibe al id_hist_clinica
    String id_hab_noc[] = null;
    id_hab_noc = request.getParameterValues("id_hab_noc");
    if (id_hab_noc == null) {
        id_hab_noc = new String[0];
    }
    //diag_pre
    String diag[] = null;
    diag = request.getParameterValues("diag");
    if (diag == null) {
        diag = new String[0];
    }
    //diag_def
    String id_diagmostico_def=request.getParameter("id_diagmostico_def");




    if (!Nombres.equals("")) {
        personadao daoper = new personadaoimpl();
        Persona persona = new Persona();
        persona.setId_grado_instruccion(null);
        persona.setId_ocupacion(null);
        persona.setId_ubigeo_nac(null);
        persona.setId_ubigeo_act(null);
        persona.setNombres(Nombres);
        persona.setApepat(Apepat);
        persona.setApemat(Apemat);
        persona.setFecha_nac(Fecha_nac);
        persona.setCorreo_gmail("");
        persona.setCorreo_hotmail("");
        persona.setCorreo_otros("");
        persona.setCelular("");
        persona.setTelefono(Telefono);
        persona.setSexo(Sexo);
        persona.setDireccion(Domicilio);
        persona.setPagina_web("");
        persona.setFoto_persona("");
        persona.setEstado("1");
        persona.setId_tipo_doc(null);
        persona.setNro_doc(Dni);
        persona.setResponsable_apoderado("");
        int id_persona = daoper.fn_registrar_Persona2(persona, 2);
        if (id_persona > 0) {
            System.out.println("EL ID_PERSONA ES " + id_persona);
            String id = "" + id_persona;
            Historia_clinicaDao daohc = new Historia_clinicaDaoImpl();
            Historia_clinica historia_clinica = new Historia_clinica();
            historia_clinica.setId_historia_clinica(null);
            historia_clinica.setId_cliente(id);
            historia_clinica.setNro_historia(Nro_historia);
            historia_clinica.setComentario(Comentario);
            historia_clinica.setAntecedentes_familiar(Ante_familiar);
            historia_clinica.setFecha_reg(Fecha_historia);
            historia_clinica.setHora_reg("");
            historia_clinica.setResponsable_apoderado(Apoderado);
            historia_clinica.setMotivo_consulta(Mot_consulta);
            historia_clinica.setPeso(Peso);
            historia_clinica.setTalla(Talla);
            historia_clinica.setPa(PA);
            historia_clinica.setEstado("1");
            historia_clinica.setEspecificaciones(Especificaciones);
            historia_clinica.setObservaciones(Observaciones);
            historia_clinica.setPronostico(Pronostico);
            int pid_historia_clinica = daohc.fn_crud_historia_clinica(historia_clinica, 1);
            if (pid_historia_clinica > 0) {
                System.out.println("EL id_historia_clinica ES: " + pid_historia_clinica);
                String idhc = "" + pid_historia_clinica; //este es el id_hist_clinica
                for (int i = 0; i < id_ante_personal.length; i++) {
                    Hist_ante_personalDao hapdao = new Hist_ante_personalDaoImpl();
                    Hist_ante_personal hist_ante_personal = new Hist_ante_personal();
                    hist_ante_personal.setId_historia_clinica(idhc);
                    hist_ante_personal.setId_ante_personal(id_ante_personal[i]);
                    hapdao.fn_hist_ante_personal(hist_ante_personal, 1);
                }
                for (int i = 0; i < id_hab_noc.length; i++) {
                    Hist_hab_nocDao hndao = new Hist_hab_nocDaoImpl();
                    Hist_hab_noc hist_hab_noc = new Hist_hab_noc();
                    hist_hab_noc.setId_historia_clinica(idhc);
                    hist_hab_noc.setId_habito_nocivo(id_hab_noc[i]);
                    hndao.fn_hist_hab_noc(hist_hab_noc, 1);
                }
                /*if (estado_embarazada.equals("Si")) {
                 EmbarazoDao embDao= new EmbarazoDaoImpl();
                 Embarazo embarazo = new Embarazo();
                 embarazo.setId_historia_clinica(idhc);
                 embarazo.setNro_semanas(Nro_semanas);
                 embarazo.setUltimo_control(Ult_control);
                 embarazo.setTrata_farma(trata_farm);
                 if (embDao.agregarEmbarazo(embarazo)) {
                 System.out.println("EL hist_cli de embarazo ES: " + idhc);
                 } else {
                 System.out.println("Ocurrio un error al agregar embarazo");
                 }
                 }*/
                for (int i = 0; i < diag.length; i++) {
                    Diagnostico_preDao daocat = new Diagnostico_preDaoImpl();
                    Diagnostico_pre diagnostico_pre = new Diagnostico_pre();
                    diagnostico_pre.setDescripcion(diag[i]);
                    diagnostico_pre.setId_historia_clinica(idhc);
                    daocat.agregarDiag_pre(diagnostico_pre);
                }
                Hist_diagnost_defDao daodef= new Hist_diagnost_defDaoImpl();
                Hist_diagnost_def hist_diagnost_def= new Hist_diagnost_def();
                hist_diagnost_def.setId_historia_clinica(idhc);
                hist_diagnost_def.setId_diagnostico_def(id_diagmostico_def);
                daodef.agregarHist_diag_daf(hist_diagnost_def);
      response.sendRedirect("servicios/Cliente-Principal.jsp?mensaje=SE AGREGO LA  HISTORIA CLINICA CORRECTAMENTE&alert=success&accion=bien");
                request.getAttribute("alert,success");
                request.getAttribute("estado,bien");
                
            } else {
      response.sendRedirect("servicios/Cliente-Principal.jsp?mensaje=Ocurrio un error al agregar historia clinica&alert=danger&accion=mal");
                request.getAttribute("alert,danger");
                request.getAttribute("estado,mal");
            }
        } else {
            response.sendRedirect("servicios/Cliente-Principal.jsp?mensaje=Ocurrio un error al agregar al cliente&alert=danger&accion=mal");
                request.getAttribute("alert,danger");
                request.getAttribute("estado,mal");
            
        }
    }
    if(opcion.equals("registrar")){
    }
    
    //TABLA EXAMEN CLINICO:
    /*String Facies= request.getParameter("Facies");   
     String Craneo = request.getParameter("Craneo");
     String Cara = request.getParameter("Cara");
     String Atm = request.getParameter("Atm");
     String Ganblios = request.getParameter("Ganblios");
     String Gland_salivales = request.getParameter("Gland_salivales");
     String Apertura_bucal = request.getParameter("Apertura_bucal");
     String Labios = request.getParameter("Labios");    
     String Carrillos = request.getParameter("Carrillos"); 
     String Paladar = request.getParameter("Paladar");
     String Orofaringe = request.getParameter("Orofaringe");
     String Lengua = request.getParameter("Lengua");
     String Piso_boca = request.getParameter("Piso_boca");
     String Encias = request.getParameter("Encias");
     String Oclusion = request.getParameter("Oclusion");*/
    //diagnostico_pre:

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

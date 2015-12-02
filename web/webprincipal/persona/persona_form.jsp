
        <%@page import="bean.Tipo_doc"%>
<%@page import="daoimpl.Tipo_docDaoImpl"%>
<%@page import="dao.Tipo_docDao"%>
<%@page import="java.sql.Date"%>
<%@page import="daoimpl.personadaoimpl"%>
<%@page import="dao.personadao"%>
<%@page import="bean.Persona"%>
<%!
            String id_persona, nombre, apell_pater, apell_mater, direccion, correo, celular, fecha_nac, ruc, nro_doc, tipo_persona, id_tipo_doc, genero, opcion;
        %>
        <%
            id_persona = request.getParameter("id_persona");
            if (id_persona == null) {
                id_persona = "";
            }
            nombre = request.getParameter("nombre");
            if (nombre == null) {
                nombre = "";
            }
            apell_pater = request.getParameter("apell_pater");
            if (apell_pater == null) {
                apell_pater = "";
            }
            apell_mater = request.getParameter("apell_mater");
            if (apell_mater == null) {
                apell_mater = "";
            }
            direccion = request.getParameter("direccion");
            if (direccion == null) {
                direccion = "";
            }
            correo = request.getParameter("correo");
            if (correo == null) {
                correo = "";
            }
            celular = request.getParameter("celular");
            if (celular == null) {
                celular = "";
            }
            celular = request.getParameter("celular");
            if (celular == null) {
                celular = "";
            }
            ruc = request.getParameter("ruc");
            if (ruc == null) {
                ruc = "";
            }
            nro_doc = request.getParameter("nro_doc");
            if (nro_doc == null) {
                nro_doc = "";
            }
            fecha_nac = request.getParameter("fecha_nac");
            if (fecha_nac == null) {
                fecha_nac = "";
            }
            id_tipo_doc = request.getParameter("id_tipo_doc");
            if (id_tipo_doc == null) {
                id_tipo_doc = "";
            }
            genero = request.getParameter("genero");
            if (genero == null) {
                genero = "";
            }
            opcion = request.getParameter("opcion");
            if (opcion == null) {
                opcion = "";
            }


        %>
        <%      if (opcion.equals("Actualizar")) {
                Persona per = new Persona();
                per.setNombre(nombre);
                per.setApepat(apell_pater);
                per.setApemat(apell_mater);
                per.setDireccion(direccion);
                per.setCorreo_gmail(correo);
                per.setCelular(celular);
                per.setNro_doc(nro_doc);
                per.setId_tipo_doc(Integer.parseInt(id_tipo_doc));;
                per.setFecha_nac(Date.valueOf(fecha_nac));
                 per.setSexo(genero);
                personadao dao = new personadaoimpl();
                if (dao.actualizarpersona(per)) {
                   response.sendRedirect("persona_result.jsp?mensaje=Actualizado correctamente");
                } else {
                    response.sendRedirect("persona_result.jsp?mensaje=ERRROR");
                }
            }
            if (opcion.equals("Registrar")) {
                Persona per = new Persona();
                per.setNombre(nombre);
                per.setApepat(apell_pater);
                per.setApemat(apell_mater);
                per.setDireccion(direccion);
                per.setCorreo_gmail(correo);
                per.setCelular(celular);
                per.setNro_doc(nro_doc);
                per.setId_tipo_doc(Integer.parseInt(id_tipo_doc));;
                per.setFecha_nac(Date.valueOf(fecha_nac));
                 per.setSexo(genero);
                                
                personadao dao = new personadaoimpl();
                if (dao.agregarpersona(per,3)) {
                    response.sendRedirect("persona_result.jsp?mensaje=Registrado correctamente");
                } else {
                    out.print("No se pudo registrar");
                }
            }
            if (opcion.equals("Eliminar")) {
                personadao dao = new personadaoimpl();
                if (dao.eliminarpersona(Integer.parseInt(id_persona))) {
                    response.sendRedirect("persona_result.jsp?mensaje=Eliminado correctamente");
                } else {
                    out.print("No se pudo eliminar porque se está usando");
                }
            }
        %>

        <%
            if (!id_persona.equals("")) {
               personadao dao = new personadaoimpl();
               Persona per = dao.datoper(Integer.parseInt(id_persona));
        %>
    <form name="persona" method="post" action="persona_form.jsp" autocomplete="off">
        <input type="hidden" name="id_persona" value="<%=id_persona%>"/>
        <table align="center">
            <tr>
                <td height="28">Nombre:</td>
                <td>
                    <input type="text" name="nombre" value="<%=per.getNombre()%>" maxlength="55" size="30" required=""/>
                </td>
            </tr>
            <tr>
                <td height="28">Apepat:</td>
                <td>
                    <input type="text" name="apell_pater" value="<%=per.getApepat()%>" maxlength="50" size="30"/>
                </td>
            </tr>
            <tr>
                <td height="28">Apemat:</td>
                <td>
                    <input type="text" name="apell_mater" value="<%=per.getApemat()%>" maxlength="50" size="30"/>
                </td>
            </tr>
            <tr>
                <td height="28">FECHA NACIMIENTO:</td>
                <td>
                    <input type="date" class="form-control" name="fecha">
                </td>
            </tr>
            <tr>
                <td height="28">Correo:</td>
                <td>
                    <input type="text" name="correo" value="<%=per.getCorreo_gmail()%>" maxlength="50" size="30"/>
                </td>
            </tr>
            <tr>
                <td height="28">Direccion:</td>
                <td>
                    <input type="text" name="direccion" value="<%=per.getDireccion()%>" maxlength="50" size="30"/>
                </td>
            </tr>
            <tr>
                <td height="28">Celular:</td>
                <td>
                    <input type="text" name="celular" value="<%=per.getCelular()%>" maxlength="10" size="30"/>
                </td>
            </tr>
<tr>
                <td height="28">Genero:</td>
                <td>
                    <input type="radio" name="genero" value="Masculino"/>Masculino
                    <input type="radio" name="genero" value="Femenino"/>Femenino
                </td>
            </tr>
            <tr>
                <td height="28">Tipo documento:</td>
                <td>
                    <select name="tipo_documento">
                        <option value=""></option>
                        <option value="DNI">DNI</option>
                      
                    </select>
                </td>
            </tr>
             
          
             
             <tr>
                <td height="28">Nro DOCUMENTO:</td>
                <td>
                    <input type="text" name="nro_doc" value="<%=per.getNro_doc()%>" maxlength="14" size="30"/>
                </td>
            </tr>
       <tr>
                <td height="28">Numero documento:</td>
                <td>
                    <input type="text" name="nro_documento" value="<%=per.getNro_doc()%>" maxlength="11" size="30"/>
                </td>
            </tr>
            
            
            
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="opcion" value="Actualizar" class="btn btn-primary"/>
                    <a href="persona.jsp" class="btn btn-default">Cancelar</a>
                </td>
            </tr>
        </table>

    </form>
    
    <%} else {%>
    
    <%@include file="../principal/cabeza.jsp" %>
   <form name="persona" method="post" action="persona_form.jsp" autocomplete="off">
        <input type="hidden" name="id_persona" value="<%=id_persona%>"/>
        <table align="center">
            <tr>
                <td height="28">Nombre:</td>
                <td>
                    <input type="text" name="nombre"  maxlength="55" size="30" required=""/>
                </td>
            </tr>
            <tr>
                <td height="28">Apepat:</td>
                <td>
                    <input type="text" name="apell_pater" maxlength="50" size="30"/>
                </td>
            </tr>
            <tr>
                <td height="28">Apemat:</td>
                <td>
                    <input type="text" name="apell_mater"  maxlength="50" size="30"/>
                </td>
            </tr>
            <tr>
                <td height="28">FECHA NACIMIENTO:</td>
                <td>
                    <input type="date" class="form-control" name="fecha">
                </td>
            </tr>
            <tr>
                <td height="28">Correo:</td>
                <td>
                    <input type="text" name="correo"  maxlength="50" size="30"/>
                </td>
            </tr>
            <tr>
                <td height="28">Direccion:</td>
                <td>
                    <input type="text" name="direccion"  maxlength="50" size="30"/>
                </td>
            </tr>
            <tr>
                <td height="28">Celular:</td>
                <td>
                    <input type="text" name="celular"  maxlength="10" size="30"/>
                </td>
            </tr>
<tr>
                <td height="28">Genero:</td>
                <td>
                    <input type="radio" name="genero" value="M"/>Masculino
                    <input type="radio" name="genero" value="F"/>Femenino
                </td>
            </tr>
            <tr>
                <td height="28">Tipo documento:</td>
                <td>
                    <select name="tipo_documento">
                        <%
                            Tipo_docDao daoer=new Tipo_docDaoImpl();
                        for(Tipo_doc dsa:daoer.mostrartipo_doc()){
                        %>
                        <option value="<%=dsa.getId_tipo_doc()%>"><%=dsa.getNombre_tipo_doc()%></option>
                      <%}%>
                    </select>
                </td>
            </tr>
             
          
             
             <tr>
                <td height="28">Nro DOCUMENTO:</td>
                <td>
                    <input type="text" name="nro_doc" placeholder="nro_doc" maxlength="14" size="30"/>
                </td>
            </tr>
       <tr>
                <td height="28">Numero documento:</td>
                <td>
                    <input type="text" name="nro_documento" placeholder="nro_documento" maxlength="11" size="30"/>
                </td>
            </tr>
            
            
            
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" name="opcion=1" value="Registrar">CLIENTE</button>
                        <button type="submit" name="opcion=2" value="Registrar">EMPLEADO</button>
                        <button type="submit" name="opcion=3" value="Registrar">PROVEEDOR</button>
                    <a href="persona.jsp" class="btn btn-default">Cancelar</a>
                </td>
            </tr>
        </table>

    </form>
    <%@include file="../principal/pie.jsp" %>
    <%}%>
</body>
</html>

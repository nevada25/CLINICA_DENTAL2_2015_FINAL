
        <%@page import="bean.Persona"%>
<%@page import="daoimpl.personadaoimpl"%>
<%@page import="dao.personadao"%>
<%
            String buscar, limit;
        %>
        <%
            buscar = request.getParameter("buscar");
            if (buscar == null) {
                buscar = "";
            }
            limit = request.getParameter("limit");
            if (limit == null) {
                limit = "";
            }
            if (limit.equals("")) {
                limit = "10";
            }

        %>
    
        <%@include file="../principal/cabeza.jsp" %>
    <center>Lista de Personas</center>
    <form name="buscar" method="post" action="index3.jsp">
        <table align="center" width="100%">
            <tr>
                <td align="right">
                    <input type="text" name="buscar" value="<%=buscar%>" placeholder="Buscar" size="15"/>
                    <select name="limit" onchange="document.buscar.submit()">
                        <option value="10">10</option>
                        <option value="25">25</option>
                        <option value="50">50</option>
                        <option value="100">100</option>
                        <option value="200">200</option>
                        <option value="500">500</option>
                    </select>
                    <input type="submit" name="" value="Buscar" class="btn btn-default"/>
                    <a href="reporte_persona.jsp" target="_blank" class="btn btn-info">Imprimir</a>
                </td>
                
                </td>
                <td align="right" width="50%">
                    <a href="persona_form.jsp" class="btn btn-info">Nueva persona</a>
                 </td>
                
            </tr>
        </table>
    </form>
    <div class="container">
        <table class="table table-bordered class-hover">
            <tr>
                <th>#</th>
                <th>Nombres</th>
                <th>Apepat</th>
                <th>Apemat</th>
                <th>fecha_nac</th>
                <th>correo_gmail</th>
                <th>Celular</th>
                <th>sexo</th>
                <th>id_tipo_doc</th>
                <th>nro_doc</th>
                <th>fecha_registro_per</th>
                <th colspan="2">Opciones</th>
            </tr>
            <% 
                int i = 0;
                personadao  dao = new personadaoimpl();
                for (Persona per : dao.mostrarpersona(buscar, limit)) {
                    i = i + 1;
                    
            %>
            <tr>
                <td><%=i%></td>
                <td><%=per.getNombre()%></td>
                <td><%=per.getApepat()%></td>
                <td><%=per.getApemat()%></td>
                <td><%=per.getFecha_nac()%></td>
                <td><%=per.getCorreo_gmail()%></td>
                <td><%=per.getDireccion()%></td>
                <td><%=per.getCelular()%></td>
                <td><%=per.getSexo()%></td>
                <td><%=per.getId_tipo_doc()%></td>
                <td><%=per.getNro_doc()%></td>
                <td><a href="persona_form.jsp?id_persona=<%=per.getId_persona()%>&opcion=Editar">Editar</a></td>
                <td><a href="persona_form.jsp?id_persona=<%=per.getId_persona()%>&opcion=Eliminar">Eliminar</a></td>
            </tr>
            <%}%>
        </table>
    </div>
    <script type="text/javascript">
        document.buscar.limit.value='<%=limit%>';
        </script>
        <%@include file="../principal/pie.jsp" %>

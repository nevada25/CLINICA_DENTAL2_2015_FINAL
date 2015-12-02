


<%@page import="Entidad.Persona" %>
<%@page import="DaoImpl.PersonaDaoImpl" %>
<%@page import="Dao.PersonaDao" %>
<html>
    <head>
        <title>Multiservicios El Burbujita</title>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <link rel="stylesheet" type="text/css" href="../../estilos/impresion.css">

    </head>
    <body onload="window.print()">
        <div style="text-align: center;"><h3 onclick="window.print()"><b>Reporte de personas registradas</b></h3></div>
        <table align="center" class="reporte_normal"> <%---Para seleccionar mediante el puntero---%>
            <tr bgcolor="#FAFAFA">
                <th>#</th>
                <th>Apellidos y nombres</th>
                <th>Tipo Persona</th>
                <th>Tipo Documento</th>
                <th>N° Documento</th>
                <th>Direccion</th>
                <th>Correo</th>
                <th>Telefono</th>
                <th>Celular</th>
                <th>Ruc</th>
                <th>Genero</th>
            </tr>
            <% int x=0;
                PersonaDao dao = new PersonaDaoImpl();
                for (Persona persona : dao.ReportePersonas()) {
                    x=x+1;
            %>

            <tr>     
                <td align="center"><%=x%></td>
                <td nowrap=""><%=persona.getApell_pater()%> <%=persona.getApell_mater()%> <%=persona.getNombre()%></td>
                <td nowrap="" align="center"><%=persona.getTipo_persona()%></td>
                <td nowrap="" align="center"><%=persona.getTipo_documento()%></td>
                <td nowrap="" align="center"><%=persona.getNro_documento()%></td>
                <td nowrap="" align="center"><%=persona.getDireccion()%></td> 
                <td nowrap="" align="center"><%=persona.getCorreo()%></td>
                <td nowrap="" align="center"><%=persona.getTelefono()%></td>
                <td nowrap="" align="center"><%=persona.getCelular()%></td>
                <td nowrap="" align="center"><%=persona.getRuc()%></td>
                <td nowrap="" align="center"><%=persona.getGenero()%></td>
            </tr>
            <%}%>
        </table>

    </body>
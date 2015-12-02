<%-- 
    Document   : producto_result
    Created on : 17/11/2015, 07:11:25 PM
    Author     : Liliana
--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>Personas</title>
        <%!
            String mensaje;
        %>
        <%
            mensaje = request.getParameter("mensaje");
            if (mensaje == null) {
                mensaje = "";
            }

        %>
    </head>
    <body>
        <%@include file="../principal/index.jsp" %>
    <center>Resultado</center>
    <META HTTP-EQUIV="Refresh" CONTENT="2;URL=index.jsp"/>
    <table align="center">
        <tr>
            <td align="center">
                <img src="../../img/bien.png"/>
            </td>
        </tr>
        <tr>
            <td align="center"><%=mensaje%></td>
        </tr>
    </table>
</body>
</html>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CATEGORIA SERVICIO</title>
          <%!
            String mensaje,alert;
        %>
        <%
            mensaje = request.getParameter("mensaje");  if (mensaje == null) {mensaje = "";}
            alert=request.getParameter("alert");if(alert==null){alert="";}
        %>
    </head>
    <body>
        <%@include file="../principal/cabeza.jsp" %>
    <center>Resultado</center>
    <META HTTP-EQUIV="Refresh" CONTENT="2;URL=index.jsp"/>
    <table align="center">
        <tr>
            <td align="center">
                <img src="../../img/bien.png"/>
            </td>
        </tr>
        <tr >
        <script>
            alert(mensaje);
        </script>
            <td style="width:100%; height: 250px;" align="center"><div class="alert-<%=alert%>"><%=mensaje%></div></td>
        </tr>
    </table>
            <%@include file="../principal/pie.jsp" %>
    </body>
</html>

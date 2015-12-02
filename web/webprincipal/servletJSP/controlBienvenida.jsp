<%


String opcion=request.getParameter("opcion");opcion = opcion == null ? "" : opcion;



switch(opcion){

    case "INICIO":
        response.sendRedirect("../../webprincipal/principal/index.jsp");
                
        break;
case "Servicios":
        response.sendRedirect("../servicio/index.jsp");
                
        break;
case "cat_ser":
        response.sendRedirect("../cate_ser/index.jsp");
                
        break;
 case "producto":
     response.sendRedirect("../producto/index.jsp");
     break;






}







%>
<img src="">
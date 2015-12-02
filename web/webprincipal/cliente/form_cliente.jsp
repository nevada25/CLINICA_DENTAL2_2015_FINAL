<%@page import="bean.Habito_nocivo"%>
<%@page import="daoimpl.Habito_nocivoDaoImpl"%>
<%@page import="dao.Habito_nocivoDao"%>
<%@page import="bean.Antecente_personal"%>
<%@page import="daoimpl.Antecente_personalDaoImpl"%>
<%@page import="dao.Antecente_personalDao"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<style>input.form-control{
        color: white; 
        background: #03a9f4;
    }
    option.form-control{
        color: white; 
        background: #03a9f4;
    }
    select.form-control{
        color: white; 
        background: #03a9f4;
    }
    textarea.form-control{color: white; 
                          background: #03a9f4;}
    </style>
    <%@include file="../principal/cabeza.jsp" %>
    <hr>
<div style="text-align: center;" ><h1><b>HISTORIA CLINICA</b></h1></div>
<hr>
<form name="form_cliente" action="crud_cliente.jsp" method="get" class="form-inline col-lg-18">

    <div class="form-group col-lg-12">
<div class="col-lg-6">
            <label for="Nro_historia">N° Historia Clinica:</label>
            <input type="text" size="10" name="Nro_historia" class="form-control" id="Nro_historia" placeholder="N° Historia">
        </div>
        
        <div class="col-lg-6">
            <label for="Fecha_historia">Fecha de Historia:</label>
            <input type="date" name="Fecha_historia" class="form-control" id="" placeholder="">
        </div>
        <hr>
    </div>
   
    <div style="margin: 0.5px;" class="form-group">
        <hr>
    <div class="form-group col-lg-6">
        
        <label class="control-label col-lg-6" for="Nombres">Nombres:</label>
        <input type="text" size="28" name="Nombres" class="form-control col-lg-6" id="" placeholder="Nombres">
 
        <label class="control-label col-lg-6" for="Apepat">Apellido Paterno:</label>
        <input type="text" name="Apepat" size="28" class="form-control col-lg-6" id="" placeholder="Apellido Paterno">
 
        <label for="Apemat" class="control-label col-lg-6">Apellido Materno:</label>
        <input type="text" name="Apemat" size="28" class="form-control col-lg-6" id="" placeholder="Apellido Materno">
 
        <label for="Dni" class="control-label col-lg-6">DNI:</label>
        <input type="text" name="Dni" size="28" class="form-control col-lg-6" id="" placeholder="DNI">
 
        <label for="Sexo" class=" control-label col-lg-6">Sexo:</label>
        <input type="text" name="Sexo" size="28" class="form-control col-lg-6" id="" placeholder="'M' o 'F'">
 
        <label for="Fecha_nac" class="control-label col-lg-6"><br>Fecha de Nacimiento:</label>
        <input type="date" name="Fecha_nac" class="form-control col-lg-6" size="50%" id="" placeholder="Fecha de Nacimiento">
</div>
    <div class="form-group col-lg-6">
        <label for="Apoderado" class="control-label col-lg-12 text-center"><br>Nombre del Responsable o Apoderado:</label>
        <input type="text" name="Apoderado" size="65%" class="form-control col-lg-12" id="" placeholder="Nombre del Responsable o Apoderado">

        <label for="Mot_consulta" class="control-label col-lg-12 text-center"><br>Motivo de consulta:</label>
        <input type="text" name="Mot_consulta" size="65%" class="form-control col-lg-12" id="" placeholder="Motivo de consulta">
        
         <label for="Domicilio" class="control-label col-lg-12 text-center"><br>Domicilio:</label>
        <input type="text" name="Domicilio" size="65%" class="form-control col-lg-12" id="" placeholder="Domicilio:">

        <label for="Telefono" class="control-label col-lg-6 text-center"><br>Telefono:</label>
        <input type="text" name="Telefono" size="65%" maxlength="9" class="form-control col-lg-6" id="" placeholder="Telefono">
    </div>
</div>
    <hr>
    <div class="col-lg-12">

        <div style="text-align: center;"><label for="Ante_personales" class="text-primary text-bold"><h1>ANTECEDENTES PRESONALES</h1></label><br><br></div>
        El paciente ha tenido o tiene:
        <br>
    </div> <div class="form-group  col-lg-12"></div><div class="form-group  col-lg-0"></div>
    <div class="form-group col-lg-3">
        <%            Antecente_personalDao apdao = new Antecente_personalDaoImpl();
            for (Antecente_personal antper : apdao.listarAntedente_personal1()) {
        %>
        <br>
        <label>
            <input type="checkbox" name="id_ante_personal" value="<%=antper.getId_ante_personal()%>"><%=antper.getNombre_antecedente()%>
        </label>
        <%}%>
    </div>
    <div class="form-group col-lg-3">
        <%for (Antecente_personal antper : apdao.listarAntedente_personal2()) {%>
        <br>
        <label>
            <input type="checkbox" name="id_ante_personal" value="<%=antper.getId_ante_personal()%>"> <%=antper.getNombre_antecedente()%>
        </label>
        <%}%>
    </div>
    <%-----fin de checkbox---%>
    <div class="form-group col-lg-6">
        <label for="Comentario"><br>Comentario:<br></label>
        <textarea class="form-control" style=" height: 35%; width: 350px;" id="comment"></textarea>
    </div>
    <div class="form-group col-lg-18">
        <label for="Ante_familiar" class="text-center"><br>Antecedentes familiares:</label>
        <textarea class="form-control" rows="2" cols="140" id="comment"></textarea>
    </div>
    <hr>
    <div class="form-group  col-lg-12">
        <div style="text-align: center;"><label for="hab_noc"><h1>Hábitos Nocivos:</h1></label><br></div>
    </div><div class="form-group  col-lg-10"></div>
    <div class="form-group col-lg-4">
        <%
            Habito_nocivoDao hndao = new Habito_nocivoDaoImpl();
            for (Habito_nocivo hn : hndao.listarHabitoNocivo1()) {
        %>
        <br>
        <label>
            <input type="checkbox" name="id_hab_noc" value="<%=hn.getId_habito_nocivo()%>"><%=hn.getNombre_hab_noc()%>
        </label>
        <%}%>
    </div>
    <div class="form-group col-lg-4">
        <%for (Habito_nocivo hn : hndao.listarHabitoNocivo2()) {%>
        <br>
        <label>
            <input type="checkbox"  name="id_hab_noc" value="<%=hn.getId_habito_nocivo()%>"> <%=hn.getNombre_hab_noc()%>
        </label>
        <%}%>
    </div><div class="form-group  col-lg-4"></div>
    <br><br>
    <div class="form-group col-lg-4">
        <label for="Peso"><br>Peso:</label>
        <input type="text" name="Peso" class="form-control" size="20" id="" placeholder="Peso">
    </div>
    <div class="form-group  col-lg-4">
        <label for="Talla"><br>Talla:</label>
        <input type="text" name="Talla" class="form-control" size="20" id="" placeholder="Talla">
    </div>
    <div class="form-group  col-lg-4">
        <label for="PA"><br>PA:<tt>..</tt></label>
        <input type="text" name="PA" class="form-control" id="" placeholder="PA"><br>
    </div>

    <div class="form-group  col-lg-12 text-center">
            <hr>
        <h1><b>ODONTOGRAMA</h1>
    </div>
    <div class="form-group col-lg-12">
    <div class="col-lg-6">
        <label for="Especificaciones"><br>ESPECIFICACIONES:</label>
        <input type="text" name="Especificaciones" class="form-control" id="" placeholder="ESPECIFICACIONES">
    </div>
    <div class="col-lg-6">
        <label for="Observaciones"><br>OBSERVACIONES:</label>
        <input type="text" name="Observaciones" class="form-control" id="" placeholder="OBSERVACIONES"><br>
    </div>
    </div>
    <div class="form-group  col-lg-12 text-center text-bold">
         <hr>
         <h1><b>DIAGNOSTICO PRESUNTIVO:</b></h1>
    </div>
    <center>
    <div class="form-group  col-lg-12">
        <label for=""><br>1.</label>
        <input type="text" class="form-control" size="117%" id="" placeholder="">
    </div>
    <div class="form-group  col-lg-12">
        <label for=""><br>2. </label>
        <input type="text" class="form-control" size="117%" id="" placeholder="">
    </div>
    <div class="form-group  col-lg-12">
        <label for=""><br>3. </label>
        <input type="text" class="form-control" size="117%" id="" placeholder="">
    </div>
    </center>
<div class="form-group text-center col-lg-12">
        <hr>
        <h1><b>DIAGNOSTICO DEFINITIVO:</b></h1>
   </div>
    <center>
    <div class="form-group col-lg-12" >
        
        <select class="form-control  col-lg-12" style="width: 91%;" id="sel1">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
        </select>
        <label for="Pronostico" class="col-lg-12"><br>PRONOSTICO:</label>
        <input type="text" name="Pronostico" size="120" class="form-control col-lg-12" id="" placeholder="">
    </div>
    </center>
    
    <div class="form-group  col-lg-12 text-center" style="margin: 5px; margin-top: 50px;">
        <div class="col-lg-4"></div>
        <button type="submit" class="btn btn-success btn-lg col-lg-4" >Registrar</button>
        <div class="col-lg-4"></div>
    </div>
</form>
<%@include file="../principal/pie.jsp" %>
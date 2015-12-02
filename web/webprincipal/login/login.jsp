<%@include file="top_login.jsp" %>

 <!-- Login -->
        <div class="lc-block toggled" id="l-login">
            <form method="post" action="login_form.jsp?acciones=validar">
            <div class="input-group m-b-20">
                <span class="input-group-addon"><i class="md md-person"></i></span>
                <div class="fg-line">
                    <input type="text" class="form-control" name="usuario" placeholder="INGRESE SU USUARIO">
                </div>
            </div>
            
            <div class="input-group m-b-20">
                <span class="input-group-addon"><i class="md md-accessibility"></i></span>
                <div class="fg-line">
                    <input type="password" name="clave" class="form-control" placeholder="INGRESE CONTRASE&Ntilde;A">
                </div>
            </div>
            
            <div class="clearfix"></div>
            <button type="submit" class="btn btn-login btn-danger btn-float"><i  class="md md-arrow-forward"></i></button>
            <ul class="login-navigation">
                <li data-block="#l-register" class="bgm-red">Registro</li>
            </ul>
</form> 
        </div>
  
        <!-- Register -->
        <div class="lc-block" id="l-register">
            <div class="input-group m-b-20">
                <span class="input-group-addon"><i class="md md-person"></i></span>
                <div class="fg-line">
                    <input type="text" class="form-control" name="usuario" placeholder="INGRESE SU USUARIO">
                </div>
            </div>
            
            <div class="input-group m-b-20">
                <span class="input-group-addon"><i class="md md-mail"></i></span>
                <div class="fg-line">
                    <input type="text" name="correo" class="form-control" placeholder="INGRESE SU CORREO">
                </div>
            </div>
            
            <div class="input-group m-b-20">
                <span class="input-group-addon"><i class="md md-accessibility"></i></span>
                <div class="fg-line">
                    <input type="password" name="clave" class="form-control" placeholder="INGRESE CONTRASE&Ntilde;A">
                </div>
            </div>
            
            <div class="clearfix"></div>
            <a href="#" class="btn btn-login btn-danger btn-float waves-effect waves-button waves-float"><i class="md md-arrow-forward"></i></a>
            
            <ul class="login-navigation">
                <li data-block="#l-login" class="bgm-green">Iniciar sesión</li>
            </ul>
        </div>
      
        
        <%@include file="botton_login.jsp" %>
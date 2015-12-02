$(function (){
$( "#register-form" ).validate({
   rule:{
       username:{
      required:true     
       },
        clave:{
      required:true     
       },
        confi_clave:{
      required:true,
      equalTo:"#clave"
       }
   },   
   messager:{
       username:{
           required :"EL CAMPO DE USUARIO ES OBLIGATORIO"
       }
   }
});
    
});

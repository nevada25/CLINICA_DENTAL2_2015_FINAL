$(document).ready(function() {
		$('#submit').click(function(event) {
                    var id_docVar=$('#id_tipo_doc').val();
                    var  nombreVar= $('# nombre').val();
                    var  apepatVar= $('# apepat').val();
                    var  apematVar= $('# apemat').val();
                    var  fecha_nacVar= $('# fecha_nac').val();
                    var  correoVar= $('# correo').val();
                    var  celularVar= $('# celular').val();
                    var  sexoVar= $('# sexo').val();
                    var  direccionVar= $('# direccion').val();
                    var  nro_docVar= $('# nro_doc').val();
                    var  foto_personaVar= $('# foto_persona').val();
                  $.post('agregardatosSVT', {
		    id_doc : id_docVar,
                    nombre :  nombreVar,
                    apepat :  apepatVar,
                    apemat :  apematVar,
                    fecha_nac :  fecha_nacVar,
                    correo :  correoVar,
                    celular :  celularVar, 
                    sexo :  sexoVar,
                    direccion :  direccionVar,
                    nro_doc :  nro_docVar,
                    foto_persona :foto_personaVar
			}, function(responseText) {
				$('#tabla').html(responseText);
			});
		});
	});
$(document).ready(function() {
		$('#submit').click(function(event) {
                    var  nombre_usuarioVar= $('#nombre_usuario').val();
                    var  passwordVar= $('#password').val();
                $.post('usuarioSVT', {
		    nombre_usuario :  nombre_usuarioVar,
                    password :  passwordVar,
                    }, function(responseText) {
				$('#span').html("USUARIO AGREGADO");
			});
		});
	});
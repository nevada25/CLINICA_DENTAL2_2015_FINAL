
                    <!-- Begin | Register Form -->
                   
                    <!-- End | Register Form -->

                </div>
                <!-- End # DIV Form -->

            </div>

        </div>
    </body>
    
</html>

<script type="text/javascript">
    function editar_usuario(id_usuario)
    {
        $("#usu_resul").hide("slow");
        $("#usu_resul").load("login_form.jsp?id_servicio2=" + id_usuario, "", function () {
            $("#usu_resul").show("slow");
        });
    }
    function usuario()
    {
        $("#usu_resul").hide("slow");
        $("#usu_resul").load("login_form.jsp", function () {
            $("#usu_resul").show("slow");
        });
    }
</script>
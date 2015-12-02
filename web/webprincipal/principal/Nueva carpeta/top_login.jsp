
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
        <link type="text/css" rel="stylesheet" href="../../bootstrap/css/bootstrap.min.css" />
        <link rel="shortcut icon"  href="../../img/1447223990_Login Manager.ico" />
        <script type="text/javascript" src="../../js/jquery-2.1.4.min.js"></script>
        <script type="text/javascript" src="../../bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../../js/TweenLite.min.js"></script>
        <script type="text/javascript" src="../../js/login/jquery.validate.min.js"></script>
        <script type="text/javascript" src="../../js/login/main.js"></script>
        <script>
            $(document).ready(function () {
                $(document).mousemove(function (e) {
                    TweenLite.to($('body'),
                            .5,
                            {css:
                                        {
                                            backgroundPosition: "" + parseInt(event.pageX / 8) + "px " + parseInt(event.pageY / '12') + "px, " + parseInt(event.pageX / '15') + "px " + parseInt(event.pageY / '15') + "px, " + parseInt(event.pageX / '30') + "px " + parseInt(event.pageY / '30') + "px"
                                        }
                            });
                });
            });

 
        </script>
        <style>
            body{
                background: url(../../img/back.png);
                background-color: #444;
                background: url(../../img/pinlayer2.png),url(../../img/pinlayer1.png),url(../../img/back.png);    
            }

            .vertical-offset-100{
                padding-top:100px;
            }

            .vertical-offset-100{
                padding-top:100px;
            }
            .login .user-row{
                text-align: center;
                font-size: 30px;
            }

            .login .img-responsive {
                display: block;
                max-width: 100%;
                height: auto;
                margin: auto;
            }

            .login.panel {
                margin-bottom: 20px;
                background-color: rgba(255, 255, 255, 0.75);
                border: 1px solid transparent;
                border-radius: 4px;
                -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
                box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
            }
            .login label{
                display: block;
                width: 100%;
                color: #449d44;
                text-shadow:#4cae4c;
                text-align: center;
            }
            .login hr{
                margin: 5px;
            }

            #login-modal .modal-dialog {
                width: 350px;
            }

            #login-modal input[type=text], input[type=password] {
                margin-top: 10px;
            }

            #div-login-msg,
            #div-lost-msg,
            #div-register-msg {
                border: 1px solid #dadfe1;
                height: 30px;
                line-height: 28px;
                transition: all ease-in-out 500ms;
            }

            #div-login-msg.success,
            #div-lost-msg.success,
            #div-register-msg.success {
                border: 1px solid #68c3a3;
                background-color: #c8f7c5;
            }

            #div-login-msg.error,
            #div-lost-msg.error,
            #div-register-msg.error {
                border: 1px solid #eb575b;
                background-color: #ffcad1;
            }

            #icon-login-msg,
            #icon-lost-msg,
            #icon-register-msg {
                width: 30px;
                float: left;
                line-height: 28px;
                text-align: center;
                background-color: #dadfe1;
                margin-right: 5px;
                transition: all ease-in-out 500ms;
            }

            #icon-login-msg.success,
            #icon-lost-msg.success,
            #icon-register-msg.success {
                background-color: #68c3a3 !important;
            }

            #icon-login-msg.error,
            #icon-lost-msg.error,
            #icon-register-msg.error {
                background-color: #eb575b !important;
            }

            #img_logo {
                max-height: 100px;
                max-width: 100px;
            }

            /* #########################################
               #    override the bootstrap configs     #
               ######################################### */

            .modal-backdrop.in {
                filter: alpha(opacity=50);
                opacity: .8;
            }

            .modal-content {
                margin-bottom: 20px;
                background-color: rgba(255, 255, 255, 0.75);
                border: 1px solid transparent;
                border-radius: 4px;
                -webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
                box-shadow: 0 1px 1px rgba(0, 0, 0, .05);
                background-color: #ececec;
                border: 1px solid #bdc3c7;
                border-radius:15px;
                outline: 0;

            }

            .modal-header {
                min-height: 16.43px;
                padding: 15px 15px 15px 15px;
                border-bottom: 0px;
            }

            .modal-body {
                position: relative;
                padding: 5px 15px 5px 15px;
            }

            .modal-footer {
                padding: 15px 15px 15px 15px;
                text-align: left;
                border-top: 0px;
            }

            .checkbox {
                margin-bottom: 0px;
            }

            .btn {
                border-radius: 0px;
            }

            .btn:focus,
            .btn:active:focus,
            .btn.active:focus,
            .btn.focus,
            .btn:active.focus,
            .btn.active.focus {
                outline: none;
            }

            .btn-lg, .btn-group-lg>.btn {
                border-radius: 0px;
            }

            .btn-link {
                padding: 5px 10px 0px 0px;
                color: #95a5a6;
            }

            .btn-link:hover, .btn-link:focus {
                color: #2c3e50;
                text-decoration: none;
            }

            .glyphicon {
                top: 0px;
            }

            .form-control {
                border-radius: 0px;
            }

        </style>
        <%

    
%>
    </head>
    <body>
        <div class="modal-dialog" style="margin-top: 150px;">
            <div class="modal-content">
                <div class="modal-header" align="center">
                    <img class="img-circle" id="img_logo" src="../../img/login.ico">
                </div>

                <!-- Begin # DIV Form -->
                <div id="div-forms" style=" border-radius:150px;">
<div class="modal fade" id="agre_usu" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">     

                        <div class="modal-dialog" role="document">
                            <div class="modal-content" style="background: #1b6d85;color: #ffffff; border-radius: 0;">
                                <div class="modal-header" >
                                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                                    <h3 style="text-align: center;"><span class="glyphicon glyphicon-lock"></span><b>AGREGAR USUARIOS</b></h3>
                                </div>
                                <div class="modal-body" style="padding:40px 50px;">  
                                    <div id="usu_resul"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                            
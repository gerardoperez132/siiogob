<%@page import="ve.gob.gobiernoenlinea.modelo.TipoDato"%>
<%--<%@page import="ve.gob.gobiernoenlinea.Controlador.Controladorprueba"%>--%>
<%@page import="ve.gob.gobiernoenlinea.factory.ServiceFactory"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="ve.gob.gobiernoenlinea.modelo.Seccionio" %>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="ve.gob.gobiernoenlinea.Controlador.InteroperarServelet" %>--%>
<%--
    Document   : index
    Created on : 13/05/2012, 04:58:42 PM
    Author     : gerardo
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="es-es">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta name="robots" content="index, follow">
        <meta name="keywords" content="CNTI,cnti,Cnti,centro nacional de tecnologias de informacion,centro nacional de tecnologías de información,Centro Nacional de Tecnologías de Información">
        <meta name="description" content="Institución adscrita al Ministerio del Poder Popular para para Ciencia, Tecnología e Innovación. Portal Desarrollado y Mantenido por el CNTI.">
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" href="css/Style.css">
        <link rel="stylesheet" type="text/css" href="css/StyleUi.css">
        <link rel="stylesheet" type="text/css" href="css/StyleValid.css">
        <!-- JS -->
        <script type="text/javascript" src="js/jQuery 1.2.6.js"></script>
        <script type="text/javascript" src="js/jquery.min.js" ></script>
        <script type="text/javascript" src="js/jquery-ui.js"></script>
        <script type="text/javascript" src="js/validForm.js"></script>
        <script type="text/javascript" src="js/validador.js"></script>
        <script type="text/javascript">
            $(function() {
                $( document ).tooltip();
            });
        </script>
        <style type="text/css">  

            fieldset div {
                margin-bottom: 2em;
            }
            fieldset .help {
                display: inline-block;
            }
            .ui-tooltip {
                width: 210px;
            }
        </style>
        <script type="text/javascript">
            function ValidaSoloNumeros() {
                if ((event.keyCode < 48) || (event.keyCode > 57)) 
                    event.returnValue = false;
            }
        </script>
        <script type="text/javascript">
            $(document).ready(function(){
                $("#Seccionio").load("InteroperarServelet");
            })
        </script>
        <script type="text/javascript"> 
            function showProducts(){
                //obtiene los objetos productCode, 
                var code=$("#Seccionio").val(); //.. y se obtiene el valor
                //llama al servlet con el parametro seleccionado
                $("#tipo_de_datos").load("InteroperarServelet2", {Seccionio:code})
            }
        </script>
        <title>Sistema de Informacion Interoperable</title>    
    </head>
    <body>
        <br>
        <div  class="container">
            <%@include file="Cabecera.jsp"%>

            <h1 align="center"> Bienvenido al Servicio de Información Interoperable </h1>
            <h2 align="center"> <%= new Date()%></h2>
            <h3 align="center"><i>Gestor Administrativo</i></h3>
            <form id="BotImple" name="BotImple" action=InteroperarServelet method="POST">
                <br>
                <br>
                <table align="center" bgcolor="#424242" border="1">
                    <tr>
                        <td>   
                            <table align="center" bgcolor="#848484" border="0" style="border-spacing: 10px 20px; border-collapse: separate">
                                <tr>

                                    <td><b><label for="Seccionio">Sección a Interoperar</label> </b></td>

                                    <td> 
                                        <select  id="Seccionio" name="Seccionio" onchange="showProducts()">
                                            <option></option>
                                        </select> 
                                    </td>
                                </tr>
                                <tr>
                                    <td><b><label for="tipo_de_datos">Tipo de Dato a Interoperar</label></b></td>
                                    <td>   <select id="tipo_de_datos" name="tipo_de_datos"> 
                                            <option></option>
                                        </select>

                                    </td>
                                </tr>      
                                <%-- <body background="imagenes/Nal.jpg"> --%>     
                                <tr>
                                    <td><b><label>Identificador</label></b></td>
                                    <td><input type="text" id="Identificador" name="Identificador" onkeypress="ValidaSoloNumeros()" title="Representa el identificador unico por institución manejado por e CMS de Gobierno en Linea"></td>
                                    <td><span style="color: red; font-size: large">*</span></td>
                                </tr>
                                <tr>
                                    <td><b><label>Url</label></b></td>
                                    <td><input type="text" id="url" name="url" title="Representa la Direccion web donde estan las etiquetas definidas Eje:http://www.cnti.gob.ve/"></td>
                                    <td><span style="color: red; font-size: large">*</span></td>
                                </tr>
                                <tr>
                                    <td><b><label>Etiqueta de Inicio</label></b></td>
                                    <td><div><input type="text" id="CadenaIni" name="CadenaIni" value="" title="Representa id de la Etiqueta <div> de Inicio Eje. gl.Tra.DesTra.CNTI.1.Ini"></div></td>
                                    <td><span style="color: red; font-size: large">*</span></td>
                                </tr>

                                <!--    </tr> -->
                                <tr>
                                    <td ><b><label>Etiqueta Final</label></b></td>
                                    <td><input type="text" id="CadenaFin" name="CadenaFin" title="Representa el id de la Etiqueta <div> Fin Ej. gl.Tra.DesTra.CNTI.1.Fin"></td>
                                    <td><span style="color: red; font-size: large">*</span></td>
                                </tr>
                                <tr>
                                    <td colspan="2" align="center"><br></td>  
                                </tr>
                                <tr>
                                    <td colspan="2" align="center"><input type="submit" value="Integrar/Registrar" name="Insertar"></td>  
                                </tr>

                            </table>
                        </td> 
                    </tr>
                </table>

            </form>
            <%-- </div> --%>      
            <%--<center><img src="logo.png" width="160" height="89" alt="logo"/></center>--%>
            <%--<center><img src="Io.png" width="113" height="149" alt="Io"/></center>--%>
            <%-- Pie de pagina--%>
        </div>
        <div id="footer"> 
            <%-- <div align="center"><img src="logo.png" alt="logo-CNTI"></div> --%>
        </div> 
        <%@include file="finalweb.jsp"%>
        <p align="center">
            <a href="http://validator.w3.org/check?uri=referer"><img
                    src="http://www.w3.org/Icons/valid-html401" alt="Valid HTML 4.01 Transitional" height="31" width="88"></a>

            <a href="http://jigsaw.w3.org/css-validator/check/referer">
                <img style="border:0;width:88px;height:31px"
                     src="http://jigsaw.w3.org/css-validator/images/vcss"
                     alt="¡CSS Válido!">
            </a>
        </p>
    </body>
</html>
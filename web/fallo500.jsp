<%@page import="ve.gob.gobiernoenlinea.modelo.TipoDato"%>
<%--<%@page import="ve.gob.gobiernoenlinea.Controlador.Controladorprueba"%>--%>
<%@page import="ve.gob.gobiernoenlinea.factory.ServiceFactory"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="ve.gob.gobiernoenlinea.modelo.Seccionio" %>

<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="ve.gob.gobiernoenlinea.Controlador.Interoperar" %>
<%@ page import="ve.gob.gobiernoenlinea.Controlador.InteroperarServelet" %>
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
<!-- JS -->
<script type="text/javascript" src="js/jQuery 1.2.6.js"></script>
<script type="text/javascript" src="js/jquery.min.js" ></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>
<script type="text/javascript">
  $(function() {
    $( "#dialog-message" ).dialog({
      modal: true,
      buttons: {
        Ok: function() {
          $( this ).dialog( history.back() );
        }
      }
    });
  });
  </script>
<title>Sistema de Informacion Interoperable</title>    
    </head>
<body> 
<br>
<div  class="container">
        <%@include file="Cabecera.jsp"%>
<h1 align="center"> Bienvenido al Servicio de Información Interoperable </h1>
<h2 align="center"> <%= new Date() %></h2>
<h3 align="center"><i>Gestor Administrativo</i></h3>
<div align="center">
<h1 style="color: red">Error</h1>
<h1 style="color: red">:(</h1>
<img src="img/Io.png" width="200" height="200">
<br>
<button onclick="history.back()">Aceptar</button> 
<div id="dialog-message" title="ERROR">
  <p>
    <span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 50px 0;"></span>
    <b>Oops.</b>
  </p>
  <p>
    <b>Ah ocurrido un Error Rerportelo al administrador</b>
  </p>
</div>
</div>
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
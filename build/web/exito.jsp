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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- CSS -->
<link rel="stylesheet" type="text/css" href="css/Style.css">
<link rel="stylesheet" href="css/StyleUi.css" />
<!--<link href="css/gips.css" rel="stylesheet" type="text/css" />-->
<!-- JS -->
<script type="text/javascript" src="js/jQuery 1.2.6.js"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery-ui.js"></script>
<%--<script type="text/javascript" src="js/jquery.idTabs.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>--%>
<script>
  $(function() {
    $( "#dialog-message" ).dialog({
      modal: true,
      buttons: {
        Ok: function() {
          $( this ).dialog( window.location.href = "index.jsp" );
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
<h1 style="color: green">Operación Exitosa</h1>
<img src="img/Io.png" width="200" height="200">
<br>
<button onclick="history.back()">Aceptar</button> 
<div id="dialog-message" title="El Registro a sido Exitoso">
  <p>
    <span class="ui-icon ui-icon-circle-check" style="float: left; margin: 0 7px 50px 0;"></span>
    <b>Ya a Registrado Los Datos Basico para la integración</b>
  </p>
  <p>
    <b>Si la Data es correcta el sistema en el tiempo determinado por el administrador actualizara la Información</b>
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
            alt="¡CSS Válido!" />
    </a>
  </p>
</body>
</html>
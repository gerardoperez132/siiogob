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
<!--<link href="css/gips.css" rel="stylesheet" type="text/css" />-->
<!-- JS -->
<%--<script type="text/javascript" src="js/funciones_ge.js"></script>--%>
<script type="text/javascript" src="js/jQuery 1.2.6.js"></script>
<script src="js/jquery.min.js" type="text/javascript"></script>
<script src="js/jquery-ui.js"></script>
<%--<script src="js/gips.js" type="text/javascript"></script>--%>
<link rel="stylesheet" href="css/StyleUi.css" />

<title>Sistema de Informacion Interoperable</title>    
    </head>
<body> 
<br>
<div  class="container">
        <%@include file="Cabecera.jsp"%>
   
<h1 align="center"> Bienvenido al Servicio de Información Interoperable </h1>
<h2 align="center"> <%= new Date() %></h2>
<h3 align="center"><i>Paso a Paso de Como Funciona la aplicación</i></h3>
<div>
<iframe height="523px" src="http://dl.dropbox.com/u/88094793/Paso%20A%20Paso%20o%20InstructivoEfecto.svg" width="853px"></iframe>
</div>
<ul>
<li>1. Click derecho para avanzar</li>
<li>2. Usar scroll para Zoom</li>
<li>3. Click sobre el scroll para Indice</li>
</ul>
<div>
    <h2 align="center"><i>¿Una Corrida un poco técnica de como Funciona?</i></h2>
    <iframe allowfullscreen="" frameborder="0" height="523" mozallowfullscreen="" src="http://popcorn.webmadecontent.org/opj_" webkitallowfullscreen="" width="853"></iframe>
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
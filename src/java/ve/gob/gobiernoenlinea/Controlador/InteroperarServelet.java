/*
 * Licencia GPL v3
 * Copyright (C) 2013 Gerardo Perez. All Rights Reserved.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see http://www.gnu.org/licenses
 */
package ve.gob.gobiernoenlinea.Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ve.gob.gobiernoenlinea.Buscador.SncLight;
import ve.gob.gobiernoenlinea.factory.ServiceFactory;
import ve.gob.gobiernoenlinea.modelo.Seccionio;
import ve.gob.gobiernoenlinea.modelo.SiIoGob;

/**
 *
 * @author gerardo
 */
public class InteroperarServelet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductCodeDao dao = DaoFactory.getInstance().getProductCodeDao();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
}
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<option value=''>Seleccione</option>");
        List<Seccionio> listaSecc = ServiceFactory.getServiceSeccion().getSeccionio();
        try {
            for (Seccionio s : listaSecc) {
                out.printf("<option value='%1s'>%2s</option>", s.getId_Structure_inode(), s.getSeccion());
            }
        } catch (Exception e) {
             String nextJSP = "/fallo.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
   
        String identificador = request.getParameter("Identificador");                      
        String url           = request.getParameter("url");
        //String[] ti          = request.getParameterValues("tipo_de_datos");
        String CadenaIni     = request.getParameter("CadenaIni").trim();
        String CadenaFin     = request.getParameter("CadenaFin").trim();
        String tipo_de_datos = request.getParameter("tipo_de_datos");
        String Seccionio = request.getParameter("Seccionio");       

 /**
 * Validando que los campos no vengan nulos
 * @author gerardo
 */
        if (identificador.equals("") || url.equals("") || CadenaIni.equals("") || CadenaFin.equals("") || tipo_de_datos.equals("")){
            String fallo2 = "/fallo2.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(fallo2);
              
        }
 
        
 /**
 * Validando del lado servidor los caracteres de los campos
 * @author gerardo
 */
        String v1 = "false";
        String v2 = "false"; 
        String v3 = "false";
        String v4 = "false";        
	Pattern fullRegexIdentificador = Pattern.compile("[^0-9]+"); //Patron de validacion Del Identificador
	//String fullRegexUrl = "[0-9]";
        Pattern fullRegexEtiquetaInicio = Pattern.compile("[^A-Za-z0-9\\.]+"); //Patron de Validacion de la Etiqueta de Inicio
        //System.out.print(fullRegexEtiquetaInicio);
        
        Pattern fullRegexUrl = Pattern.compile("[^A-Za-z0-9\\.\\: //]+"); //Patron de Validacion de la Etiqueta de Inicio
        
        Pattern fullRegexEtiquetaFin = Pattern.compile("[^A-Za-z0-9\\.]+"); //Patron de Validacion de la Etiqueta de Fin
       
        Matcher m1 = fullRegexIdentificador.matcher(identificador); //Valido que los datos q recibo esten dentro del patron de validacion
        //System.out.print("**M1"+m1.find());
        if (m1.find()) {
             /**
              * True:  Si lo que resibo no se encuentra en el patron de validacion
              * False: Si lo que resibo Se Encuntre dentro del patron de validacion
              */
               v1 = "true";
                  //System.out.print(!identificador.matches(fullRegexIdentificador));
         }
        request.getSession().setAttribute("v1", v1);
        request.getSession().setAttribute("Ide", "El Identificador solo debe contener numeros de 2 a 10 digitos");
        
       Matcher m2 = fullRegexUrl.matcher(url);//Valido que los datos q recibo esten dentro del patron de validacion
       if (m2.find()) {
                  v2 = "true";      
         }
        request.getSession().setAttribute("v2", v2);
        request.getSession().setAttribute("Ur", "Ingrese correctamente la direccion web Eje:\"http://www.cnti.gob.ve/\"");
        
        Matcher m3 = fullRegexEtiquetaInicio.matcher(CadenaIni);//Valido que los datos q recibo esten dentro del patron de validacion
       // System.out.print("**M3"+m3.find());
        if (m3.find()) {
            /**
              * True:  Si lo que resibo no se encuentra en el patron de validacion
              * False: Si lo que resibo Se Encuntre dentro del patron de validacion
              */
                  v3 = "true";
         }
        request.getSession().setAttribute("v3", v3);
        request.getSession().setAttribute("Ei", "El Id de inicio debe Cumplir el Estandar GLv1 que solo Incluye letras y numeros con puntos");
        
        
        Matcher m4 = fullRegexEtiquetaFin.matcher(CadenaFin);//Valido que los datos q recibo esten dentro del patron de validacion
        //System.out.print("**M4"+m4.find());
        if (m4.find()) {
            /**
              * True:  Si lo que resibo no se encuentra en el patron de validacion
              * False: Si lo que resibo Se Encuntre dentro del patron de validacion
              */
                  v4 = "true";
         }
        request.getSession().setAttribute("v4", v4);
        request.getSession().setAttribute("Ef", "El Id de fin debe Cumplir el Estandar GLv1 que solo Incluye letras y numeros con puntos");
        
        if (v1.equalsIgnoreCase("true") || v2.equalsIgnoreCase("true") || v3.equalsIgnoreCase("true") || v4.equalsIgnoreCase("true")) {
        String fallo8 = "/falloValidServer.jsp";
                  RequestDispatcher dispatcher2 = getServletContext().getRequestDispatcher(fallo8);
                  dispatcher2.forward(request,response);
        }
        
/**
 * Validando que la url de la web este Online
 * @author gerardo
 */
        
        String CadenaIniConcatenada = "<div id=\""+CadenaIni+"\"></div>";
        String CadenaFinConcatenda = "<div id=\""+CadenaFin+"\"></div>";
        SncLight snc = new SncLight();    
        try {
        snc.Buscar(CadenaIniConcatenada, CadenaFinConcatenda, url);
        } catch (Exception e) {   
            String fallo = "/fallo1.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(fallo);
            dispatcher.forward(request,response);
        }
        
 /**
 * Validando que las Etiquetas se encuentren en la url especificada
 * @author gerardo
 */
        if (snc.getdatosEncontrados().equalsIgnoreCase("No Encuentro las Etiquetas en la Url especificada")){
              String fallo = "/fallo3.jsp";
              RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(fallo);
              dispatcher.forward(request,response);
            } 
 
 /**
 * Insercion a BD
 * @author gerardo
 */
        try {
            SiIoGob s = new SiIoGob();
            s.setIdentificador(Integer.parseInt(identificador));
            s.setUrl(url);
            //s.setStructure_inode(Integer.parseInt(structure_inode));
            s.setTipo_de_datos(Integer.parseInt(tipo_de_datos));
           
            s.setCadenaFin(CadenaFinConcatenda);
            s.setCadenaInicio(CadenaIniConcatenada);
            
           ServiceFactory.geServiceGen().insertar(s);
                    
            String exito = "/exito.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(exito);
            dispatcher.forward(request,response);
        } catch (Exception e) {   
             String nextJSP = "/fallo.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request,response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

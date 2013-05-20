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
package ve.gob.gobiernoenlinea.Buscador;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author gerardo
 */
public class SncLight {

    String datosEncontrados;

    public SncLight() {
    }

    public void Buscar(String cadenaInicio, String cadenaFin, String urlEnte) throws IOException {


        String FinalHtml = "</html>";
        String FinalBody = "</body>";
        URL url = new URL(urlEnte);


        BufferedReader webEnteGobierno = new BufferedReader(new InputStreamReader(url.openStream()));

        StringBuilder datos = new StringBuilder();//Segun Algunos Articulos de Buenas Practicas el StringBuilder es mas optimo
        while ((datos.append(webEnteGobierno.readLine())) != null) {


            if (datos.indexOf(cadenaFin) > datos.indexOf(cadenaInicio) + cadenaInicio.length()) {
                datosEncontrados = "Si Estas las Etiquetas";
                break;
            }


            if (datos.indexOf(FinalHtml) > datos.indexOf(FinalBody)) {
                System.err.println("\"SIS001E\": No Encuentro las Etiquetas en la Url especificada :" + urlEnte);
                datosEncontrados = "No Encuentro las Etiquetas en la Url especificada";
                //datosEncontrados = "SIS001E";
                break;
            }
        }

        webEnteGobierno.close();
    }

    public String getdatosEncontrados() {
        return datosEncontrados;
    }

    public void setNombreSNC(String datosEncontrados) {
        this.datosEncontrados = datosEncontrados;
    }
}

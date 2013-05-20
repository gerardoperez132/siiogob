/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.gob.gobiernoenlinea.borrarCacheDotcms;

import java.util.Properties;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author gerardo
 */
public class BorrarCacheDotcms {
    
    
    public void BorrarCache () throws ClientProtocolException, IOException {
        
                BorrarCache borrarCache = new BorrarCache();
                HttpClient httpclient = new DefaultHttpClient();
                /*Propiedades*/
                  /*1*/
                String peticionWebLogin = borrarCache.getProperties().getProperty("peticionWebLogin");
                String password = borrarCache.getProperties().getProperty("password");
                String login = borrarCache.getProperties().getProperty("login");
                  /*1*/
                  /*2*/
                String peticionWebProtected = borrarCache.getProperties().getProperty("peticionWebProtected");
                  /*2*/
                  /*3*/
                String peticionWebSecurity = borrarCache.getProperties().getProperty("peticionWebSecurity");
                String j_username = borrarCache.getProperties().getProperty("j_username");
                String j_password = borrarCache.getProperties().getProperty("j_password");
                  /*3*/
                  /*4 = 2*/
                  /*5*/
                String peticionWebGrupo = borrarCache.getProperties().getProperty("peticionWebGrupo");
                  /*5*/
                  /*6*/
                String botonBorrarCache = borrarCache.getProperties().getProperty("botonBorrarCache");       
                  /*6*/      
                /*Propiedades*/
                
		                                     //Link de la web de login
		HttpPost httppost = new HttpPost(peticionWebLogin); // Disparo 1
		List<NameValuePair> formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("my_account_cmd", "auth")); 
		formparams.add(new BasicNameValuePair("password", password ));  //Contraseña 
		formparams.add(new BasicNameValuePair("my_account_login", login)); // Usuario
		
		
		UrlEncodedFormEntity parametros = new UrlEncodedFormEntity(formparams, "UTF-8");
		httppost.setEntity(parametros);		
		HttpResponse response = httpclient.execute(httppost);				
		HttpEntity entity = response.getEntity();
		if (entity != null) {
		    InputStream instream = entity.getContent();
		    try {
		    //	System.out.println(
                                convertStreamToString(instream);
                              //  );
		    } catch (Exception e) {
		    	e.printStackTrace();
			}finally {
		        instream.close();
		    }
		}
		
		System.out.println("PROTECTED****************************************");
		                                 // Link de Protecion luego del login
		HttpGet httpget = new HttpGet(peticionWebProtected);// Disparo 2
		response = httpclient.execute(httpget);
		entity = response.getEntity();
		if (entity != null) {
		    InputStream instream = entity.getContent();
		    try {
		    	//System.out.println(
		    			convertStreamToString(instream);
		    			//);
		    } catch (Exception e) {
		    	e.printStackTrace();
			}finally {
		        instream.close();
		    }
		}
		
		System.out.println("SPRING SECURITY****************************************");
		                           //Link de Chequeo de seguridad luego del link de Proteccion
		httppost = new HttpPost(peticionWebSecurity);// Disparo 3
		formparams = new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("j_username", j_username));// ID del Usuario 	
		formparams.add(new BasicNameValuePair("j_password", j_password));// Clave del Usuario en MD5
		
		parametros = new UrlEncodedFormEntity(formparams, "UTF-8");
		
		httppost.setEntity(parametros);
		
		response = httpclient.execute(httppost);	

		entity = response.getEntity();
		if (entity != null) {
		    InputStream instream = entity.getContent();
		    try {
		    	//System.out.println(
                                convertStreamToString(instream);
                            //    );
		    } catch (Exception e) {
		    	e.printStackTrace();
			}finally {
		        instream.close();
		    }
		}
		
		System.out.println("PROTECTED****************************************");
		                          //Ultimo link de proteccion luego del el chequeo de seguridad
		httpget = new HttpGet(peticionWebProtected); //Disparo 4		
		response = httpclient.execute(httpget);
		entity = response.getEntity();
		if (entity != null) {
		    InputStream instream = entity.getContent();
		    try {
		    //	System.out.println(
		    			convertStreamToString(instream);
		    		//	);
		    } catch (Exception e) {
		    	e.printStackTrace();
			}finally {
		        instream.close();
		    }
		}	
		
		System.out.println("INICIO****************************************");
                                       //link de la primera vista despues del login
		httpget = new HttpGet(peticionWebGrupo); //Disparo 5	
		response = httpclient.execute(httpget);
		entity = response.getEntity();
		if (entity != null) {
		    InputStream instream = entity.getContent();
		    try {
		    //	System.out.println(
		    			convertStreamToString(instream);
		    		//);
		    } catch (Exception e) {
		    	e.printStackTrace();
			}finally {
		        instream.close();
		    }
		}	
		System.out.println("BORRAR CACHE****************************************");
		                      //Link de la peticion del boton para el borrado del cache
		httpget = new HttpGet(botonBorrarCache); //Disparo 6	
		response = httpclient.execute(httpget);
		entity = response.getEntity();
		if (entity != null) {
		    InputStream instream = entity.getContent();
		    try {
		    	//System.out.println(
		    			convertStreamToString(instream);
		    			//);
		    } catch (Exception e) {
		    	e.printStackTrace();
			}finally {
		        instream.close();
	   }
	}				
    }
    public static String convertStreamToString(InputStream is)
            throws IOException {
        /*
         * To convert the InputStream to String we use the
         * Reader.read(char[] buffer) method. We iterate until the
         * Reader return -1 which means there's no more data to
         * read. We use the StringWriter class to produce the string.
         */
        if (is != null) {
            Writer writer = new StringWriter();
 
            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(
                        new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }
            return writer.toString();
        } else {        
            return "";
        }
    }
}



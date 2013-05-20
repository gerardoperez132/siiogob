/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.gob.gobiernoenlinea.dao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import ve.gob.gobiernoenlinea.modelo.Seccionio;
import ve.gob.gobiernoenlinea.modelo.TipoDato;

/**
 *
 * @author gerardo
 */
public interface Dao {
    
   public void guardaroactualizar (Object tabla); //metodo para actualizar
   
   public <T> List <T> encontrarID(String selec); //Metodo para encontrar la id viva

   public Session openSession(); //Para cerrar los hilos de conexion
   
   public int persistencia ();   // Comit-begin
   
   public void inser (Object tabla) ;
   
   public  <T> List<T> ListarAll(Class<T> entityClass);
   
   public <T> T  EncontrarporID(Class<T> entityClass, Serializable id);
   
   public <T> T EncontrarObjectByHQL(String HQL);

   
}

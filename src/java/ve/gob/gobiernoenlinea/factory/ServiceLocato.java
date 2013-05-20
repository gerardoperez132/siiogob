/*
 * Es el que se encarga de buscar el servicio de configuracion
 */
package ve.gob.gobiernoenlinea.factory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author gerardo
 */
public class ServiceLocato {
    
    private ApplicationContext configuracion;
    
    
    private BeanFactory fabrica;
    
    private static ServiceLocato instancia = null ;
    //contructor
    
    private ServiceLocato () { 
      
        try { 
            
            String directorio = "/ve/gob/gobiernoenlinea/config/sprinrgConfig.xml";
         
                   configuracion = new ClassPathXmlApplicationContext (directorio.split(",") );
                   
                   fabrica = (BeanFactory) configuracion ;
                  
           
                           
    }   catch (Exception g) {
   
        g.printStackTrace();
    }   
 
    
    }

    public static ServiceLocato getInstancia() {
        
        if (instancia== null){
            
            instancia = new ServiceLocato();
        
        }
            
            
        return instancia;
    }

    public BeanFactory getFabrica() {
        return fabrica;
    }
    
    public Object getService ( String nombre ) { //metodo con la nomenclatura getter and setter
        
     try {   
         
        return fabrica.getBean(nombre);      
        
        
     } catch (Throwable th) {
 
         throw new IllegalStateException(th.getMessage());
         
    }
    
    
}

}
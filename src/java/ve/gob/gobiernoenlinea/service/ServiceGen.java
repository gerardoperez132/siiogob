/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.gob.gobiernoenlinea.service;

import java.util.List;
import ve.gob.gobiernoenlinea.modelo.SiIoGob;



/**
 *
 * @author gerardo
 */
public interface ServiceGen {

    public List<SiIoGob> encontrar();
    
    public void insertar(SiIoGob siiogob);
    
 
}
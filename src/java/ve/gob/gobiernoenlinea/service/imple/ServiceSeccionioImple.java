/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.gob.gobiernoenlinea.service.imple;

import java.util.List;
import ve.gob.gobiernoenlinea.dao.Dao;
import ve.gob.gobiernoenlinea.modelo.Seccionio;
import ve.gob.gobiernoenlinea.service.ServiceSeccionio;

/**
 *
 * @author gerardo
 */
public class ServiceSeccionioImple implements ServiceSeccionio{
private Dao instDao;

    public Dao getInstDao() {
        return instDao;
    }

    public void setInstDao(Dao instDao) {
        this.instDao = instDao;
    }

    @Override
     public List<Seccionio> getSeccionio() {
        
             String HQL= "SELECT Secc FROM Seccionio Secc" +
		         " ORDER BY Secc.id_Structure_inode ";
             
	     return instDao.encontrarID(HQL);

        
    }
        //throw new UnsupportedOperationException("Not supported yet.");
  }


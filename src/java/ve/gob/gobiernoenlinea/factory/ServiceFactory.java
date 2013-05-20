package ve.gob.gobiernoenlinea.factory;

import java.util.Date;
import ve.gob.gobiernoenlinea.service.ServiceContentlet;
import ve.gob.gobiernoenlinea.service.ServiceGen;
import ve.gob.gobiernoenlinea.service.ServiceTipoDato;
import ve.gob.gobiernoenlinea.service.ServiceSeccionio;
/**
 *
 * @author gerardo
 */

public class ServiceFactory {

    public static ServiceContentlet getServiceCon() {
        ServiceContentlet c = null;


        try {

            c = (ServiceContentlet) ServiceLocato.getInstancia().getService("servicio_contentlet");


        } catch (Exception e) {

            e.printStackTrace();
        }
        return c;

    }

    public static ServiceGen geServiceGen() {
        ServiceGen c = null;


        try {

            c = (ServiceGen) ServiceLocato.getInstancia().getService("servicio_SiIoGob");


        } catch (Exception e) {

            e.printStackTrace();
        }
        return c;

    }

 public static ServiceTipoDato getServiceTipoDato() {
        ServiceTipoDato c = null;
        try {
            c = (ServiceTipoDato) ServiceLocato.getInstancia().getService("servicio_TipoDato");

        } catch (Exception e) {

            System.out.println("ERROR!!!");
        }
        return c;
    }
 
 public static ServiceSeccionio getServiceSeccion() {
        ServiceSeccionio c = null;
        try {
            c = (ServiceSeccionio) ServiceLocato.getInstancia().getService("servicio_Seccionio");

        } catch (Exception e) {

            System.out.println("ERROR!!!");
        }
        return c;


    }
}

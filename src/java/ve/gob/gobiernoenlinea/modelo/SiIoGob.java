/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.gob.gobiernoenlinea.modelo;

import javax.persistence.*;

/**
 *
 * @author gerardo
 */
@Entity
@Table(name="SiIoGob")

public class SiIoGob {

 
 @Id 
 //Implementar el GenerateValue cuando se configure la vista
 //http://www.adictosaltrabajo.com/tutoriales/tutoriales.php?pagina=AnotacionesEJB3
 @GeneratedValue //(strategy = GenerationType.SEQUENCE, generator="prueba")
 @Column (name="id", nullable=false)
 private long id;
 
 @Column (name="id_tipo_de_datos", nullable=false)
 private int tipo_de_datos;
  
//  @Column (name="structure_inode", nullable= false)
// private int structure_inode ;
 
 @Column (name="identificador", nullable=false)
 private int identificador;
 
 @Column (name="url", nullable=false)
 private String url;
 
 @Column (name="cadena_inicio", nullable=false)
 private String cadenaInicio;
 
 @Column (name="cadena_fin", nullable=false)
 private String cadenaFin;

    public String getCadenaFin() {
        return cadenaFin;
    }

    public void setCadenaFin(String cadenaFin) {
        this.cadenaFin = cadenaFin;
    }

    public String getCadenaInicio() {
        return cadenaInicio;
    }

    public void setCadenaInicio(String cadenaInicio) {
        this.cadenaInicio = cadenaInicio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

//    public int getStructure_inode() {
//        return structure_inode;
//    }
//
//    public void setStructure_inode(int structure_inode) {
//        this.structure_inode = structure_inode;
//    }

    public int getTipo_de_datos() {
        return tipo_de_datos;
    }

    public void setTipo_de_datos(int tipo_de_datos) {
        this.tipo_de_datos = tipo_de_datos;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
 
 
}

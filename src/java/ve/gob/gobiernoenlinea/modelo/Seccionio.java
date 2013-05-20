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
@Table(name="seccionio")
public class Seccionio {

@Id 
//@GeneratedValue//(strategy = GenerationType.SEQUENCE, generator="prueba")
@Column (name="id_Structure_inode", nullable=false)
private long id_Structure_inode; //inode de cada seccion

@Column (name="seccion", nullable=false)
private String seccion; //nombre de cada seccion

@Column (name="descripcion", nullable=false)
private String descripcion; 

@Column (name="Estatus", nullable=false)
private String Estatus;

    public String getEstatus() {
        return Estatus;
    }

    public void setEstatus(String Estatus) {
        this.Estatus = Estatus;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getId_Structure_inode() {
        return id_Structure_inode;
    }

    public void setId_Structure_inode(long id_Structure_inode) {
        this.id_Structure_inode = id_Structure_inode;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }



}

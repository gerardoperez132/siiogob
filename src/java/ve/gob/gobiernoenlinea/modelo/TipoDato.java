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
@Table(name="TipoDato")

public class TipoDato {

    


/**
 *
 * @author gerardo
 */
 
 @Id 
 //@GeneratedValue//(strategy = GenerationType.SEQUENCE, generator="prueba")
 @Column (name="id_tipo_datos", nullable=false)
 private long id;
 
 @Column (name="id_Structure_inode", nullable=false)
 private long structure_inode;
 
 @Column (name="descripcion", nullable= false)
 private String descripcion;
  
 @Column (name = "nombre", nullable = false)
 private String nombre;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getStructure_inode() {
        return structure_inode;
    }

    public void setStructure_inode(long structure_inode) {
        this.structure_inode = structure_inode;
    }
 
 
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.gob.gobiernoenlinea.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author gerardo
 */
@Entity
@Table (name="Inode")

public class Inode {
    
@Id
@Column (name="Inode",nullable=false)
private long Inode;

@Column (name="Type",nullable=false)
private String Type;

@Column (name= "Identifier")
private String Identifier;

//getter and setter


    public String getIdentifier() {
        return Identifier;
    }

    public void setIdentifier(String Identifier) {
        this.Identifier = Identifier;
    }

    public long getInode() {
        return Inode;
    }

    public void setInode(long Inode) {
        this.Inode = Inode;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }
}

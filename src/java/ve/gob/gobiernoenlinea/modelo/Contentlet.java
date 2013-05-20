package ve.gob.gobiernoenlinea.modelo;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
 //@ManyToOne
/**
 *
 * @author gerardo
 */

@Entity
@Table(name="Contentlet")

public class Contentlet {
 
 @Id   
 @Column (name="inode", nullable=false) //contine el valor unico de cada institucion
 private long inode;
  
 @Column (name="live", nullable=true)   //Indica que es el registro q esta online o es el q esta viendo el dotcms
 private boolean live;
 
 @Column (name="working",nullable=true) //Indica cual es el registro q esta trabajando
 private boolean working;
 
 @Column (name="locked",nullable=true)  //Bloqueas este registro para q otro usuario no lo modifique facilmente
 private boolean locked;
  
/* @Column (name="show_on_menu",nullable=true)
 private boolean show_on_menu;*/
   
 @Column (name="title",nullable=true)    //nombre 1 de la ints
 private String title;
 
/* @Column (name="mod_date",nullable=true)
 private Date mod_date;*/
 
 @Column (name="friendly_name",nullable=true) //nombre 2 de la ints
 private String friendly_name;
 
 @Column (name="mod_user",nullable=true)      //Usuario q lo modifico
 private String mod_user;
 
 /*@Column (name="last_review",nullable=true)
 private Date last_review;*/
 
 @Column (name="text1",nullable=true)       // nombre 3 de la inst
 private String text1;
 
 @Column (name="text2",nullable=true)
 private String text2;

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }
 
 @Column (name="text_area1",nullable=true)  // Descripcion breve de la Institucion
 private String text1_area1;
 
 @Column (name="text_area2",nullable=true)  // Descripcion larga de la Institucion
 private String text1_area2;

    public String getText1_area2() {
        return text1_area2;
    }

    public void setText1_area2(String text1_area2) {
        this.text1_area2 = text1_area2;
    }
@Column (name = "text_area3", nullable=true) //base legal del tramite
private String text_area3;
    
@Column (name="text_area5",nullable=true) // Direccion de los tramites
private String text_area5;

@Column (name = "text_area4", nullable=true) //Costos de los tramites
private String text_area4;

@Column (name ="text_area6", nullable=true) //Tiempo de Respuesta de tamites
private String text_area6;

@Column (name="text_area7", nullable=true) //Procediemitos de los tramites
private String text_area7;

@Column (name="text_area8", nullable=true) //Requisitos de los tramites
private String text_area8; 

@Column (name="text_area9", nullable=true) //Recaudos de los tramites
private String text_area9;

@Column (name="text6",nullable=true)       //Direccion de la institucion
private String text6;
 
 @Column (name="text7",nullable=true)       //Telefonos de atencion al cliente
 private String text7;
 
 @Column (name="text4",nullable=true)       //Correo de la Inst
 private String text4;

    public String getText4() {
        return text4;
    }

    public void setText4(String text4) {
        this.text4 = text4;
    }
 
 @Column (name="text8",nullable=true)       //Portal Web de la inst
 private String text8;

    public String getText9() {
        return text9;
    }

    public void setText9(String text9) {
        this.text9 = text9;
    }
 
 @Column (name="text9",nullable=true)
 private String text9;

 @Column (name="text3",nullable=true)       //Responsable de la Inst
 private String text3;

 @Column (name="text5",nullable=true)      //Telefono de la institucion
 private String text5;
 
 @Column (name="float1",nullable=true)
 private float float1;

    public float getFloat1() {
        return float1;
    }

    public void setFloat1(float float1) {
        this.float1 = float1;
    }

    public float getFloat2() {
        return float2;
    }

    public void setFloat2(float float2) {
        this.float2 = float2;
    }
 
 @Column (name = "float2", nullable=true)
 private float float2;
 
 @Column (name="structure_inode", nullable=true)     
 private int structure_inode;
 
 //getter and setter

    public int getStructure_inode() {
        return structure_inode;
    }

    public void setStructure_inode(int structure_inode) {
        this.structure_inode = structure_inode;
    }

    public String getText_area3() {
        return text_area3;
    }

    public void setText_area3(String text_area3) {
        this.text_area3 = text_area3;
    }

    public String getText_area4() {
        return text_area4;
    }

    public void setText_area4(String text_area4) {
        this.text_area4 = text_area4;
    }

    public String getText_area5() {
        return text_area5;
    }

    public void setText_area5(String text_area5) {
        this.text_area5 = text_area5;
    }

    public String getText_area6() {
        return text_area6;
    }

    public void setText_area6(String text_area6) {
        this.text_area6 = text_area6;
    }

    public String getText_area7() {
        return text_area7;
    }

    public void setText_area7(String text_area7) {
        this.text_area7 = text_area7;
    }

    public String getText_area8() {
        return text_area8;
    }

    public void setText_area8(String text_area8) {
        this.text_area8 = text_area8;
    }

    public String getText_area9() {
        return text_area9;
    }

    public void setText_area9(String text_area9) {
        this.text_area9 = text_area9;
    }
 
    public String getText5() {
        return text5;
    }

    public void setText5(String text5) {
        this.text5 = text5;
    }
 
    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }




    public String getMod_user() {
        return mod_user;
    }

    public void setMod_user(String mod_user) {
        this.mod_user = mod_user;
    }

    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText6() {
        return text6;
    }

    public void setText6(String text6) {
        this.text6 = text6;
    }

    public String getText7() {
        return text7;
    }

    public void setText7(String text7) {
        this.text7 = text7;
    }

    public String getText8() {
        return text8;
    }

    public void setText8(String text8) {
        this.text8 = text8;
    }


    public String getFriendly_name() {
        return friendly_name;
    }

    public void setFriendly_name(String friendly_name) {
        this.friendly_name = friendly_name;
    }

    public long getInode() {
        return inode;
    }

    public void setInode(long inode) {
        this.inode = inode;
    }

  /*  public Date getLast_review() {
        return last_review;
    }

    public void setLast_review(Date last_review) {
        this.last_review = last_review;
    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Date getMod_date() {
        return mod_date;
    }

    public void setMod_date(Date mod_date) {
        this.mod_date = mod_date;
    }

    public String getMod_user() {
        return mod_user;
    }

    public void setMod_user(String mod_user) {
        this.mod_user = mod_user;
    }

    public boolean isShow_on_menu() {
        return show_on_menu;
    }

    public void setShow_on_menu(boolean show_on_menu) {
        this.show_on_menu = show_on_menu;
    }*/

    public String getText1() {
        return text1;
    }

    public void setText1(String text1) {
        this.text1 = text1;
    }

    public String getText1_area1() {
        return text1_area1;
    }

    public void setText1_area1(String text1_area1) {
        this.text1_area1 = text1_area1;
    }
/*
    public String getText3() {
        return text3;
    }

    public void setText3(String text3) {
        this.text3 = text3;
    }

    public String getText6() {
        return text6;
    }

    public void setText6(String text6) {
        this.text6 = text6;
    }

    public String getText7() {
        return text7;
    }

    public void setText7(String text7) {
        this.text7 = text7;
    }

    public String getText8() {
        return text8;
    }

    public void setText8(String text8) {
        this.text8 = text8;
    }*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

  /*  public boolean isWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }
 
 */
 
 /**live boolean,
  working boolean,
  deleted boolean,
  locked boolean,
  show_on_menu boolean,
  title character varying(255),
  mod_date timestamp without time zone,
  mod_user character varying(100),
  sort_order integer,
  friendly_name character varying(255),
  language_id bigint,
  structure_inode bigint,
  last_review timestamp without time zone,
  next_review timestamp without time zone,
  review_interval character varying(255),
  disabled_wysiwyg character varying(255),
  date1 timestamp without time zone,
  date2 timestamp without time zone,
  date3 timestamp without time zone,
  date4 timestamp without time zone,
  date5 timestamp without time zone,
  date6 timestamp without time zone,
  date7 timestamp without time zone,
  date8 timestamp without time zone,
  date9 timestamp without time zone,
  date10 timestamp without time zone,
  date11 timestamp without time zone,
  date12 timestamp without time zone,
  date13 timestamp without time zone,
  date14 timestamp without time zone,
  date15 timestamp without time zone,
  date16 timestamp without time zone,
  date17 timestamp without time zone,
  date18 timestamp without time zone,
  date19 timestamp without time zone,
  date20 timestamp without time zone,
  date21 timestamp without time zone,
  date22 timestamp without time zone,
  date23 timestamp without time zone,
  date24 timestamp without time zone,
  date25 timestamp without time zone,
  text1 character varying(255),
  text2 character varying(255),
  text3 character varying(255),
  text4 character varying(255),
  text5 character varying(255),
  text6 character varying(255),
  text7 character varying(255),
  text8 character varying(255),
  text9 character varying(255),
  text10 character varying(255),
  text11 character varying(255),
  text12 character varying(255),
  text13 character varying(255),
  text14 character varying(255),
  text15 character varying(255),
  text16 character varying(255),
  text17 character varying(255),
  text18 character varying(255),
  text19 character varying(255),
  text20 character varying(255),
  text21 character varying(255),
  text22 character varying(255),
  text23 character varying(255),
  text24 character varying(255),
  text25 character varying(255),
  text_area1 text,
  text_area2 text,
  text_area3 text,
  text_area4 text,
  text_area5 text,
  text_area6 text,
  text_area7 text,
  text_area8 text,
  text_area9 text,
  text_area10 text,
  text_area11 text,
  text_area12 text,
  text_area13 text,
  text_area14 text,
  text_area15 text,
  text_area16 text,
  text_area17 text,
  text_area18 text,
  text_area19 text,
  text_area20 text,
  text_area21 text,
  text_area22 text,
  text_area23 text,
  text_area24 text,
  text_area25 text,
  integer1 bigint,
  integer2 bigint,
  integer3 bigint,
  integer4 bigint,
  integer5 bigint,
  integer6 bigint,
  integer7 bigint,
  integer8 bigint,
  integer9 bigint,
  integer10 bigint,
  integer11 bigint,
  integer12 bigint,
  integer13 bigint,
  integer14 bigint,
  integer15 bigint,
  integer16 bigint,
  integer17 bigint,
  integer18 bigint,
  integer19 bigint,
  integer20 bigint,
  integer21 bigint,
  integer22 bigint,
  integer23 bigint,
  integer24 bigint,
  integer25 bigint,
  float1 real,
  float2 real,
  float3 real,
  float4 real,
  float5 real,
  float6 real,
  float7 real,
  float8 real,
  float9 real,
  float10 real,
  float11 real,
  float12 real,
  float13 real,
  float14 real,
  float15 real,
  float16 real,
  float17 real,
  float18 real,
  float19 real,
  float20 real,
  float21 real,
  float22 real,
  float23 real,
  float24 real,
  float25 real,
  bool1 boolean,
  bool2 boolean,
  bool3 boolean,
  bool4 boolean,
  bool5 boolean,
  bool6 boolean,
  bool7 boolean,
  bool8 boolean,
  bool9 boolean,
  bool10 boolean,
  bool11 boolean,
  bool12 boolean,
  bool13 boolean,
  bool14 boolean,
  bool15 boolean,
  bool16 boolean,
  bool17 boolean,
  bool18 boolean,
  bool19 boolean,
  bool20 boolean,
  bool21 boolean,
  bool22 boolean,
  bool23 boolean,
  bool24 boolean,
  bool25 boolean,    

**/
    
}

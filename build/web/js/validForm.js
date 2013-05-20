 /*
 * Licencia GPL v3
 * Copyright (C) 2013 Gerardo Perez ->.mail:gerardo.perez132@gmail.com twitter:gerardoperez132 All Rights Reserved.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or any
 * later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see http://www.gnu.org/licenses
 */

 $(document).ready(function(){
                $.validator.addMethod("Ide",function(value,element,regexp){
                    var re= new RegExp(regexp);
                    return this.optional(element) || re.test(value);
                },"Ingrese Identificador correctamente");
                
                
                $.validator.addMethod("linkWeb",function(value,element,regexp){
                    var re= new RegExp(regexp);
                    return this.optional(element) || re.test(value);
                },"Ingrese url correctamente");
                
                
                 $.validator.addMethod("cadIni",function(value,element,regexp){
                    var re= new RegExp(regexp);
                    return this.optional(element) || re.test(value);
                },"Ingrese la Etiqueta de Inicio Correctamente");


                $.validator.addMethod("cadFin",function(value,element,regexp){
                    var re= new RegExp(regexp);
                    return this.optional(element) || re.test(value);
                },"Ingrese la Etiqueta Final Correctamente");
                


                $("#BotImple").validate({
                   
                    rules:{
                            Identificador:{
                                required:true,
                                Ide:"^[1-9][0-9]{2,10}$" //Patron de Validacion Numero y digitos de 2 a 10
                               
                            },
                            url:{
                                required:true,
                                linkWeb:"-?^(http|https|ftp)\://[a-zA-Z0-9\-\.]+\.[a-zA-Z]{2,3}(:[a-zA-Z0-9]*)?/?([a-zA-Z0-9\-\._\?\,\'/\\\+&amp;%\$#\=~])*[^\.\,\)\(\s]$"
                            },
                            CadenaIni:{
                                required:true,
                                cadIni:"^[A-Za-z 0-9 \. ñÑçÇáéíóúüÁÉÍÓÚÜ]+$"
                               
                            },
                            CadenaFin:{
                                required:true,
                                cadFin:"^[A-Za-z 0-9 \. ñÑçÇáéíóúüÁÉÍÓÚÜ]+$"
                               
                            },
                            tipo_de_datos:{
                                required:true
                               
                            },
                            
                            Seccionio:{
                                required:true
                               
                            }
                    },
                    messages:{
                        Identificador:{
                            required:"Este campo es obligatorio",
                            Ide:"El Identificador solo debe contener numeros de 2 a 10 digitos"
                        },
                        url:{
                            required:"Este campo es obligatorio",
                            linkWeb:"Ingrese correctamente la direccion web Eje:\"http://www.cnti.gob.ve/\""
                        },
                        
                        CadenaIni:{
                            required:"Este campo es obligatorio",
                            cadIni:"El Id debe Cumplir el Estandar GLv1 que solo Incluye letras y numeros con puntos"
                        },
                        CadenaFin:{
                            required:"Este campo es obligatorio",
                            cadFin:"El Id debe Cumplir el Estandar GLv1 que solo Incluye letras y numeros con puntos"
                        },
                        
                        tipo_de_datos:{
                            required:"Este campo es obligatorio"
                            
                        },
                        Seccionio:{
                            required:"Este campo es obligatorio"
                           
                        }
    
                    },
          //submitHandler:function(){
            //            alert("Los datos han sido enviados");
      //return true;
        //            }
                });
})

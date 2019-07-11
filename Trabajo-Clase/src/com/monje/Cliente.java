package com.monje;

import com.monje.excepciones.ErrorValidacion;

public class Cliente {
    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    //getters => sirven para devolver informacion.
    //setter => utilizados para modificar el estado de mi objeto

    public Cliente(String id, String nombre, String apellido) {

    }

    public String getId() {
    return id;
    }

    public void setId(String id) throws Exception {
        if (id.length() != 13){
            throw new ErrorValidacion("El numero de identidad debe contener 13 caracteres");
        }
        this.id = id;
    }

    public String getNombre(String Nombre) {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
    return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombreCompleto(){
        return this.nombre +" " + this.apellido;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws ErrorValidacion {
        if (!email.matches("^[a-z0-9._-]+@[a-z0-9-]+(.[a-z0-9-]+)(.[a-z]{2,4})")){
            throw new ErrorValidacion("El correo es invalido");
        }
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono)  throws ErrorValidacion{
        if (!telefono.matches("^(\\+504\\s?)?[0-9]{4}(\\-?)[0-9]{4}")){
            throw new ErrorValidacion("El numero de telefono es invalido");
        }
        this.telefono = telefono;
    }


}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Pulpo
 */
public class Asistente extends Persona{
    private String edad;

    public Asistente(String edad, String codigo, String nombre, String apellido, String cedula) {
        super(codigo, nombre, apellido, cedula);
        this.edad = edad;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
    
    
}

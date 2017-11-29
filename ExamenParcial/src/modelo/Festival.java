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
public class Festival {
    private int codigo;
    private String nombreFestival;
    private String direccion;
    private String horaFestival;

    public Festival(int codigo, String nombreFestival, String direccion, String horaFestival) {
        this.codigo = codigo;
        this.nombreFestival = nombreFestival;
        this.direccion = direccion;
        this.horaFestival = horaFestival;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreFestival() {
        return nombreFestival;
    }

    public void setNombreFestival(String nombreFestival) {
        this.nombreFestival = nombreFestival;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHoraFestival() {
        return horaFestival;
    }

    public void setHoraFestival(String horaFestival) {
        this.horaFestival = horaFestival;
    }

    @Override
    public String toString() {
        return "Festival{" + "codigo=" + codigo + ", nombreFestival=" + nombreFestival + ", direccion=" + direccion + ", horaFestival=" + horaFestival + '}';
    }
    
}

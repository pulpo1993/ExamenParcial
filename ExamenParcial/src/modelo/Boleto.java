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
public class Boleto {
    
    private Asistente asistente;
    private Presentacion presentacion;
    private String numAsisto;

    public Boleto(Asistente asistente, Presentacion presentacion, String numAsisto) {
        this.asistente = asistente;
        this.presentacion = presentacion;
        this.numAsisto = numAsisto;
    }

    public Asistente getAsistente() {
        return asistente;
    }

    public void setAsistente(Asistente asistente) {
        this.asistente = asistente;
    }

    public Presentacion getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(Presentacion presentacion) {
        this.presentacion = presentacion;
    }

    public String getNumAsisto() {
        return numAsisto;
    }

    public void setNumAsisto(String numAsisto) {
        this.numAsisto = numAsisto;
    }

    @Override
    public String toString() {
        return "Boleto{" + "asistente=" + asistente + ", presentacion=" + presentacion + ", numAsisto=" + numAsisto + '}';
    }
    
}

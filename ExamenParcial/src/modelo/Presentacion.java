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
public class Presentacion {
    private Festival festival;
    private Artista artista;
    private int ordenPresentacion;

    public Presentacion(Festival festival, Artista artista, int ordenPresentacion) {
        this.festival = festival;
        this.artista = artista;
        this.ordenPresentacion = ordenPresentacion;
    }

    public Festival getFestival() {
        return festival;
    }

    public void setFestival(Festival festival) {
        this.festival = festival;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public int getOrdenPresentacion() {
        return ordenPresentacion;
    }

    public void setOrdenPresentacion(int ordenPresentacion) {
        this.ordenPresentacion = ordenPresentacion;
    }       
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import controlador.GestionDato;
import java.util.ArrayList;
import java.util.List;
import modelo.Artista;
import modelo.Asistente;
import modelo.Boleto;
import modelo.Festival;
import modelo.Presentacion;

/**
 *
 * @author Pulpo
 */
public class Principal {
    public static void main(String[] args) {
        List<Presentacion> pL= new ArrayList<Presentacion>();
        List<Boleto> bL= new ArrayList<Boleto>();
        List<Festival> fL = new ArrayList<Festival>();
        List<Artista> aL =  new ArrayList<Artista>();
        List<Asistente> asL = new ArrayList<Asistente>();
        GestionDato gd = new GestionDato(aL, asL, bL, fL, pL);
       VentanaPrincipal vp= new VentanaPrincipal("Festival", gd);
       vp.setVisible(true);
    }
    
}


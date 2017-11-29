/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Artista;
import modelo.Festival;
import modelo.Presentacion;
import vista.VentanaPresentacion;

/**
 *
 * @author Pulpo
 */
public class EventoVentanaPresentacion implements ActionListener{
    private VentanaPresentacion vPresentacion;

    public EventoVentanaPresentacion(VentanaPresentacion vPresentacion) {
        this.vPresentacion = vPresentacion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.vPresentacion.getBotonList().get(0)))
            
        {
            System.out.println("hola mundo");
            
            String op=this.vPresentacion.getTxtList().get(0).getText();
            String fest=this.vPresentacion.getCombobox1().getSelectedItem().toString();
            String art=this.vPresentacion.getCombobox2().getSelectedItem().toString();
            
            Festival f=this.vPresentacion.getgD().buscarFestival(fest);
            Artista ar= this.vPresentacion.getgD().buscarArtista(art);
            Presentacion p=new Presentacion(f,ar,op);
            this.vPresentacion.getgD().addPresentacion(p);
            
            Object[][] datoPres = this.vPresentacion.cargaDatosTabla(this.vPresentacion.getgD().getPresentacionList().size(),3);
            this.vPresentacion.setDatos(datoPres);
            this.vPresentacion.getModeloTabla().setDataVector(this.vPresentacion.getDatos(), this.vPresentacion.getEncabezado());
        }
    
    }
    
}

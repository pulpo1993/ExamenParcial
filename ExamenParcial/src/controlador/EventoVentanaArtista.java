
package controlador;

import modelo.Artista;
import vista.VentanaArtista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class EventoVentanaArtista implements ActionListener{
    
    private VentanaArtista ventana;
    
    public EventoVentanaArtista(VentanaArtista ventana){
        
        this.ventana=ventana;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource().equals(this.ventana.getBotonList().get(0))){
            String genero= this.ventana.getTextoList().get(0).getText();
            String experiencia=this.ventana.getTextoList().get(1).getText();
            String codigo = this.ventana.getTextoList().get(2).getText();
            String nombre = this.ventana.getTextoList().get(3).getText();
            String apellido = this.ventana.getTextoList().get(4).getText();
            String cedula = this.ventana.getTextoList().get(5).getText();
            Artista ar= new Artista(genero, experiencia, codigo, nombre, apellido, cedula);
            this.ventana.getgD().addArtista(ar);
            JOptionPane.showMessageDialog(ventana, "Aristista agregado exitosamente!");
                  
        }
        //cargar la tabla
        Object[][] datosArtista = this.ventana.cargarDatos(this.ventana.getgD().getArtistaList().size(),5);
        this.ventana.setDatos(datosArtista);
        this.ventana.getModeloTabla().setDataVector(this.ventana.getDatos(), this.ventana.getEncabezado());
    }
}

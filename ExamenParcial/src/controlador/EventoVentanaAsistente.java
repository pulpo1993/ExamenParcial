
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Asistente;
import vista.VentanaAsistente;

public class EventoVentanaAsistente implements ActionListener{
    
    private VentanaAsistente ventana;
    
    public EventoVentanaAsistente(VentanaAsistente ventana){
        this.ventana=ventana;
    }
    @Override
    public void ActionPerformed(ActionEvent ae){
        if(ae.getSource().equals(this.ventana.getBotonList().get(0))){
            String edad =this.ventana.getTextoList().get(0).getText();
            String codigo = this.ventana.getTextoList().get(1).getText();
            String nombre = this.ventana.getTextoList().get(2).getText();
            String apellido = this.ventana.getTextoList().get(3).getText();
            String cedula = this.ventana.getTextoList().get(4).getText();
            Asistente as = new Asistente(edad, codigo, nombre, apellido, cedula);
            this.ventana.getgD().addAsistente(as);
            JOptionPane.showMessageDialog(ventana, "Asistente agregado exitosamente!");
        }
        //Cargar la tabla
        Object[][] datosAsistente = this.ventana.cargarDatos(this.ventana.getgD().getArtistaList().size(),4);
        this.ventana.setDatos(datosAsistente);
        this.ventana.getModeloTabla().setDataVector(this.ventana.getDatos(), this.ventana.getEncabezado());
        
    }
 

    
}


package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Festival;
import vista.VentanaFestival;
public class EventoVentanaFestival implements ActionListener{
    
    private VentanaFestival ventana;
    
    public EventoVentanaFestival(VentanaFestival ventana){
        this.ventana=ventana;
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource().equals(this.ventana.getBotonList().get(0))){
            
            String nombre = this.ventana.getTextoList().get(0).getText();
            String direccion = this.ventana.getTextoList().get(1).getText();
            String hora= this.ventana.getTextoList().get(2).getText();
            Festival fe = new Festival(nombre, direccion, hora);
            this.ventana.getgD().addFestival(fe);
            JOptionPane.showMessageDialog(ventana, "Festival agregado exitosamente!");
        }
        //Cargar la tabla
        Object[][] datosFestival = this.ventana.cargarDatos(this.ventana.getgD().getFestivalList().size(),3);
        this.ventana.setDatos(datosFestival);
        this.ventana.getModeloTabla().setDataVector(this.ventana.getDatos(), this.ventana.getEncabezado());
    }
    
    
}

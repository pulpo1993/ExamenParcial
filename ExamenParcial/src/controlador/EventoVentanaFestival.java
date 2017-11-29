package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Festival;
import vista.VentanaFestival;

public class EventoVentanaFestival implements ActionListener {

    private VentanaFestival ventana;

    public EventoVentanaFestival(VentanaFestival ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource().equals(this.ventana.getBotonList().get(0))) {
                for (int i = 0; i < this.ventana.getTextoList().size(); i++) {
                    if (this.ventana.getTextoList().get(i).getText().equals("")) {
                        throw new ExcepcionCamposVacios("");
                    }
                }
                int codigo = Integer.parseInt(this.ventana.getTextoList().get(0).getText());
                String nombre = this.ventana.getTextoList().get(1).getText();
                String direccion = this.ventana.getTextoList().get(2).getText();
                String hora = this.ventana.getTextoList().get(3).getText();
                Festival fe = new Festival(codigo, nombre, direccion, hora);
                for (Festival f : this.ventana.getgD().getFestivalList()) {
                    if (fe.getCodigo() == f.getCodigo()) {
                        throw new ExcepcionRepetidos("Dato Repetido");
                    }
                }
                this.ventana.getgD().addFestival(fe);
            }
        } catch (NumberFormatException NFE) {
            JOptionPane.showMessageDialog(ventana, "Ingresar numeros donde se los pide", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ExcepcionCamposVacios ex) {
            JOptionPane.showMessageDialog(ventana, "No dejar los campos vacios");
        } catch (ExcepcionRepetidos ex) {
            JOptionPane.showMessageDialog(ventana, "Festival ya resgistrado");
        }

        if (ae.getSource().equals(this.ventana.getBotonList().get(1))) {
            //Limpiar
            for (int i = 0; i < this.ventana.getTextoList().size(); i++) {
                this.ventana.getTextoList().get(i).setText(null);
            }
        }
        //Cargar la tabla
        Object[][] datosFestival = this.ventana.cargarDatos(this.ventana.getgD().getFestivalList().size(), 4);
        this.ventana.setDatos(datosFestival);
        this.ventana.getModeloTabla().setDataVector(this.ventana.getDatos(), this.ventana.getEncabezado());
    }

}

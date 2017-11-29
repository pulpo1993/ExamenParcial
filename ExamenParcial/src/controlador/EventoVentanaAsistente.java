package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Asistente;
import vista.VentanaAsistente;

public class EventoVentanaAsistente implements ActionListener {

    private VentanaAsistente ventana;

    public EventoVentanaAsistente(VentanaAsistente ventana) {
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
                String edad = this.ventana.getTextoList().get(1).getText();
                String nombre = this.ventana.getTextoList().get(2).getText();
                String apellido = this.ventana.getTextoList().get(3).getText();
                String cedula = this.ventana.getTextoList().get(4).getText();
                Asistente as = new Asistente(codigo, nombre, apellido, cedula, edad);
                for (Asistente a : this.ventana.getgD().getAsistenteList()) {
                    if (a.getCodigo() == a.getCodigo()) {
                        throw new ExcepcionRepetidos("Dato Repetido");
                    }
                }
                this.ventana.getgD().addAsistente(as);
            }
        } catch (NumberFormatException NFE) {
            JOptionPane.showMessageDialog(ventana, "Ingresar numeros donde se los pide", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ExcepcionCamposVacios ex) {
            JOptionPane.showMessageDialog(ventana, "No dejar los campos vacios");
        } catch (ExcepcionRepetidos ex) {
            JOptionPane.showMessageDialog(ventana, "Asistente ya resgistrado");
        }

        if (ae.getSource().equals(this.ventana.getBotonList().get(1))) {
            //Limpiar
            for (int i = 0; i < this.ventana.getTextoList().size(); i++) {
                this.ventana.getTextoList().get(i).setText(null);
            }
        }
        //Cargar la tabla
        Object[][] datosAsistente = this.ventana.cargarDatos(this.ventana.getgD().getAsistenteList().size(), 5);
        this.ventana.setDatos(datosAsistente);
        this.ventana.getModeloTabla().setDataVector(this.ventana.getDatos(), this.ventana.getEncabezado());
    }

}

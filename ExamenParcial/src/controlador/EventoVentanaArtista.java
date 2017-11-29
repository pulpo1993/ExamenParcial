package controlador;

import modelo.Artista;
import vista.VentanaArtista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class EventoVentanaArtista implements ActionListener {

    private VentanaArtista ventana;

    public EventoVentanaArtista(VentanaArtista ventana) {

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
                String apellido = this.ventana.getTextoList().get(2).getText();
                String cedula = this.ventana.getTextoList().get(3).getText();
                String genero = this.ventana.getTextoList().get(4).getText();
                String experiencia = this.ventana.getTextoList().get(5).getText();
                Artista ar = new Artista(codigo, nombre, apellido, cedula, genero, experiencia);
                for (Artista a : this.ventana.getgD().getArtistaList()) {
                    if (a.getCodigo() == a.getCodigo()) {
                        throw new ExcepcionRepetidos("Dato Repetido");
                    }
                }
                this.ventana.getgD().addArtista(ar);

            }
        } catch (NumberFormatException NFE) {
            JOptionPane.showMessageDialog(ventana, "Ingresar numeros donde se los pide", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ExcepcionCamposVacios ex) {
            JOptionPane.showMessageDialog(ventana, "No dejar los campos vacios");
        } catch (ExcepcionRepetidos ex) {
            JOptionPane.showMessageDialog(ventana, "Artista ya resgistrado");
        }
        if (ae.getSource().equals(this.ventana.getBotonList().get(1))) {
            //Limpiar
            for (int i = 0; i < this.ventana.getTextoList().size(); i++) {
                this.ventana.getTextoList().get(i).setText(null);
            }
        }
        //cargar la tabla
        Object[][] datosArtista = this.ventana.cargarDatos(this.ventana.getgD().getArtistaList().size(), 6);
        this.ventana.setDatos(datosArtista);
        this.ventana.getModeloTabla().setDataVector(this.ventana.getDatos(), this.ventana.getEncabezado());
    }
}

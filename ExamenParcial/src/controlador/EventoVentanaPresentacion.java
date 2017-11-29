package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Presentacion;
import vista.VentanaPresentacion;

public class EventoVentanaPresentacion implements ActionListener {

    VentanaPresentacion ventana;

    public EventoVentanaPresentacion(VentanaPresentacion ventana) {
        this.ventana = ventana;
    }
    int cont=0;
    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource().equals(this.ventana.getBotonList().get(0))) {
                if(this.ventana.getTexto().getText().equals("")){
                        throw new ExcepcionCamposVacios("");
                }
                int codF = codigoFestival();
                int codA = codigoArtista();
                int orden = Integer.parseInt(this.ventana.getTexto().getText());
                for (int i = 0; i < this.ventana.getgD().getFestivalList().size(); i++) {
                    if (codF == this.ventana.getgD().getFestivalList().get(i).getCodigo()) {
                        for (int j = 0; j < this.ventana.getgD().getArtistaList().size(); j++) {
                            if (codA == this.ventana.getgD().getArtistaList().get(j).getCodigo()) {
                                Presentacion pr = new Presentacion(this.ventana.getgD().getFestivalList().get(i), this.ventana.getgD().getArtistaList().get(j), orden);
                                for (Presentacion pre : this.ventana.getgD().getPresentacionList()) {
                                    if (pre.getFestival().getCodigo() == pr.getFestival().getCodigo() && pre.getArtista().equals(pr.getArtista())) {
                                        throw new ExcepcionRepetidos("Dato Repetido");
                                    }
                                }
                                this.ventana.getgD().addPresentacion(pr);
                            }
                        }
                    }
                }
            }
        } catch (NumberFormatException NFE) {
            JOptionPane.showMessageDialog(ventana, "No dejar el campos vacio", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException NPE) {
            JOptionPane.showMessageDialog(ventana, "No dejar los ComboBox vacios", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ExcepcionRepetidos ex) {
            JOptionPane.showMessageDialog(ventana, "Presentacion ya registrada");
        } catch (ExcepcionCamposVacios ex) {
            JOptionPane.showMessageDialog(ventana, "No dejar los campos vacios");
        }
        if (ae.getSource().equals(this.ventana.getBoton())) {
            //Actualizar combo
            this.ventana.cargarCombo();
        }
        Object[][] datosInscripcion = this.ventana.cargarDatos(this.ventana.getgD().getPresentacionList().size(), 3);
        this.ventana.setDatos(datosInscripcion);
        this.ventana.getModeloTabla().setDataVector(this.ventana.getDatos(), this.ventana.getEncabezado());
    }

    private int codigoFestival() {
        String datos = this.ventana.getCombo().get(0).getSelectedItem().toString();
        int codF = 0;
        for (int i = 0; i < datos.length(); i++) {
            if (datos.charAt(i) == 124) {
                codF = Integer.parseInt(datos.substring(0, i - 1));
            }
        }
        return codF;
    }

    private int codigoArtista() {
        String datos = this.ventana.getCombo().get(1).getSelectedItem().toString();
        int codA = 0;
        for (int i = 0; i < datos.length(); i++) {
            if (datos.charAt(i) == 124) {
                codA = Integer.parseInt(datos.substring(0, i - 1));
            }
        }
        return codA;
    }
}


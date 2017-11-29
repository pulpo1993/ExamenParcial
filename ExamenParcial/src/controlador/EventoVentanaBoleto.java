package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Boleto;
import vista.VentanaBoleto;

public class EventoVentanaBoleto implements ActionListener {

    VentanaBoleto ventana;

    public EventoVentanaBoleto(VentanaBoleto ventana) {
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
                int codA = codigoAsistente();
                int codP = codigoPresentacion();
                String numasisto = this.ventana.getTexto().getText();
                for (int i = 0; i < this.ventana.getgD().getAsistenteList().size(); i++) {
                    if (codA == this.ventana.getgD().getAsistenteList().get(i).getCodigo()) {
                        for (int j = 0; j < this.ventana.getgD().getPresentacionList().size(); j++) {
                            if (codP == this.ventana.getgD().getPresentacionList().get(j).getFestival().getCodigo()) {
                                Boleto b = new Boleto(this.ventana.getgD().getAsistenteList().get(j), this.ventana.getgD().getPresentacionList().get(i), numasisto);
                                for (Boleto bo : this.ventana.getgD().getBoletoList()) {
                                    if (bo.getAsistente().getCodigo() == b.getAsistente().getCodigo() && bo.getPresentacion().getFestival().getCodigo() == b.getPresentacion().getFestival().getCodigo()) {
                                        throw new ExcepcionRepetidos("Dato Repetido");
                                    }
                                }
                                this.ventana.getgD().addBoleto(b);
                            }
                        }
                    }
                }
            }
        } catch (NumberFormatException NFE) {
            JOptionPane.showMessageDialog(ventana, "Ingresar numeros donde se pide", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NullPointerException NPE) {
            JOptionPane.showMessageDialog(ventana, "No dejar los ComboBox vacios", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ExcepcionRepetidos ex) {
            JOptionPane.showMessageDialog(ventana, "Boleto ya vendido");
        } catch (ExcepcionCamposVacios ex) {
            JOptionPane.showMessageDialog(ventana, "No dejar los campos vacios");
        }
        if (ae.getSource().equals(this.ventana.getBoton())) {
            //Actualizar combo
            this.ventana.cargarCombo();
        }
        Object[][] datosInscripcion = this.ventana.cargarDatos(this.ventana.getgD().getBoletoList().size(), 3);
        this.ventana.setDatos(datosInscripcion);
        this.ventana.getModeloTabla().setDataVector(this.ventana.getDatos(), this.ventana.getEncabezado());
    }

        private int codigoAsistente() {
        String datos = this.ventana.getCombo().get(1).getSelectedItem().toString();
        int codA = 0;
        for (int i = 0; i < datos.length(); i++) {
            if (datos.charAt(i) == 124) {
                codA = Integer.parseInt(datos.substring(0, i - 1));
            }
        }
        return codA;
    }
        
    private int codigoPresentacion() {
        String datos = this.ventana.getCombo().get(0).getSelectedItem().toString();
        int codP = 0;
        for (int i = 0; i < datos.length(); i++) {
            if (datos.charAt(i) == 124) {
                codP = Integer.parseInt(datos.substring(0, i - 1));
            }
        }
        return codP;
    }
    
}


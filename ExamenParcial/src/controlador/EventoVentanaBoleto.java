/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Asistente;
import modelo.Boleto;
import modelo.Presentacion;
import vista.VentanaBoleto;
/**
 *
 * @author Pulpo
 */
public class EventoVentanaBoleto implements ActionListener{
    private VentanaBoleto vBoleto;

    public EventoVentanaBoleto(VentanaBoleto vBoleto) {
        this.vBoleto = vBoleto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.vBoleto.getBotonList().get(0)))
            
        {
            System.out.println("hola mundo");
            String n=this.vBoleto.getTxtList().get(0).getText();
            String asis=this.vBoleto.getCombobox1().getSelectedItem().toString();
            String pres=this.vBoleto.getCombobox2().getSelectedItem().toString();
            Asistente as=this.vBoleto.getgD().buscarAsistente(asis);
            Presentacion p= this.vBoleto.getgD().buscarPresentacion(pres);
            Boleto b=new Boleto(as, p, n);
            this.vBoleto.getgD().addBoleto(b);
            Object[][] datoBoleto = this.vBoleto.cargaDatosTabla(this.vBoleto.getgD().getBoletoList().size(),3);
            this.vBoleto.setDatos(datoBoleto);
            this.vBoleto.getModeloTabla().setDataVector(this.vBoleto.getDatos(), this.vBoleto.getEncabezado());
           
        }
    }
    
}


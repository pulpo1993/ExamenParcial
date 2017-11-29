/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaAsistente;
import vista.VentanaFestival;
import vista.VentanaArtista;
import vista.VentanaPrincipal;
import vista.VentanaBoleto;
import vista.VentanaPresentacion;

public class EventoVentanaPrincipal implements ActionListener {

    private VentanaPrincipal vP;

    public EventoVentanaPrincipal(VentanaPrincipal vP) {
        this.vP = vP;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vP.getMenuItemList().get(0))) {
            VentanaFestival vF = new VentanaFestival("Registro de Festivales", this.vP.getgD());
            vF.setVisible(true);
            this.vP.getEscritorio().add(vF);
        }
        if (e.getSource().equals(this.vP.getMenuItemList().get(1))) {
            VentanaArtista vA = new VentanaArtista("Registro de Artistas", this.vP.getgD());
            vA.setVisible(true);
            this.vP.getEscritorio().add(vA);
        }
        if (e.getSource().equals(this.vP.getMenuItemList().get(2))) {
            VentanaAsistente vAs = new VentanaAsistente("Registro de Asistentes", this.vP.getgD());
            vAs.setVisible(true);
            this.vP.getEscritorio().add(vAs);
        }
        if (e.getSource().equals(this.vP.getMenuItemList().get(3))) {
            VentanaPresentacion vPr = new VentanaPresentacion("Registro de Presentaciones", this.vP.getgD());
            vPr.setVisible(true);
            this.vP.getEscritorio().add(vPr);
        }
        if (e.getSource().equals(this.vP.getMenuItemList().get(4))) {
            VentanaBoleto vB = new VentanaBoleto("Registro de Boletos", this.vP.getgD());
            vB.setVisible(true);
            this.vP.getEscritorio().add(vB);
        }
    }
}


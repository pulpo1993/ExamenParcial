/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;
import controlador.EventoVentanaPresentacion;
import controlador.GestionDato;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Presentacion;

/**
 *
 * @author Pulpo
 */
public class VentanaPresentacion extends JInternalFrame {

    private List<JLabel> etiquetaList;
    private List<JButton> botonList;
    private List<JTextField> txtList;
    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;
    private JComboBox combobox1;
    private JComboBox combobox2;
    private GestionDato gD;
    private ResourceBundle rB;

    public VentanaPresentacion(GestionDato gD) {
        super("Presentacion", true, true, true, true);
        this.setSize(550, 300);
        this.gD = gD;
        iniciaComponente();
    }

    public void iniciaComponente() {
        this.etiquetaList = new ArrayList<JLabel>();
        this.etiquetaList.add(new JLabel("Festival: "));
        this.etiquetaList.add(new JLabel("Artista: "));
        this.etiquetaList.add(new JLabel("Orden Presentacion: "));

        this.txtList = new ArrayList<JTextField>();
        this.txtList.add(new JTextField(15));

        JPanel panel = new JPanel();
        this.botonList = new ArrayList<JButton>();
        this.botonList.add(new JButton("Guardar"));
        this.combobox1 = new JComboBox(this.CargaCombo());
        this.combobox2 = new JComboBox(this.CargaCombo2());
        this.botonList.get(0).addActionListener(new EventoVentanaPresentacion(this));
        this.encabezado = new Object[3];
        this.encabezado[0] = "Festival";
        this.encabezado[1] = "Artista";
        this.encabezado[2] = "Orden Presentacion";

        this.datos = cargaDatosTabla(this.gD.getPresentacionList().size(), 3);

        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);
        panel.add(this.etiquetaList.get(0));
        panel.add(this.combobox1);
        panel.add(this.etiquetaList.get(1));
        panel.add(this.combobox2);
        panel.add(this.etiquetaList.get(2));
        panel.add(this.txtList.get(0));
        panel.add(botonList.get(0));
        panel.add(this.scroll);
        this.add(panel);
    }

    public Object[][] cargaDatosTabla(int h, int w) {
        Object[][] retorno = new Object[h][w];
        int i = 0;
        for (Presentacion p : this.gD.getPresentacionList()) {
            retorno[i][0] = p.getFestival();
            retorno[i][1] = p.getArtista();
            retorno[i][2] = p.getOrdenPresentacion();
            i++;
        }
        return retorno;
    }

    public Object[] CargaCombo() {
        String[] retorno = new String[this.gD.getPresentacionList().size()];
        int i = 0;
        for (Presentacion f : this.gD.getPresentacionList()) {
            retorno[i] = f.getFestival().getNombreFestival();
            i++;
        }
        return retorno;
    }

    public Object[] CargaCombo2() {
        String[] retorno = new String[this.gD.getPresentacionList().size()];
        int i = 0;
        for (Presentacion p : this.gD.getPresentacionList()) {
            retorno[i] = p.getArtista().getNombre();
            i++;
        }
        return retorno;
    }

    public List<JLabel> getEtiquetaList() {
        return etiquetaList;
    }

    public void setEtiquetaList(List<JLabel> etiquetaList) {
        this.etiquetaList = etiquetaList;
    }

    public List<JButton> getBotonList() {
        return botonList;
    }

    public void setBotonList(List<JButton> botonList) {
        this.botonList = botonList;
    }

    public List<JTextField> getTxtList() {
        return txtList;
    }

    public void setTxtList(List<JTextField> txtList) {
        this.txtList = txtList;
    }

    public Object[][] getDatos() {
        return datos;
    }

    public void setDatos(Object[][] datos) {
        this.datos = datos;
    }

    public Object[] getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(Object[] encabezado) {
        this.encabezado = encabezado;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }

    public void setModeloTabla(DefaultTableModel modeloTabla) {
        this.modeloTabla = modeloTabla;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }

    public ResourceBundle getrB() {
        return rB;
    }

    public void setrB(ResourceBundle rB) {
        this.rB = rB;
    }

    public JComboBox getCombobox1() {
        return combobox1;
    }

    public void setCombobox1(JComboBox combobox1) {
        this.combobox1 = combobox1;
    }

    public JComboBox getCombobox2() {
        return combobox2;
    }

    public void setCombobox2(JComboBox combobox2) {
        this.combobox2 = combobox2;
    }

}

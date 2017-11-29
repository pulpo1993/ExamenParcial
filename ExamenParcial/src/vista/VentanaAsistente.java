/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EventoVentanaArtista;
import controlador.GestionDato;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.Asistente;

public class VentanaAsistente extends JInternalFrame {

    private Object[][] datos;
    private Object[] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;
    private JButton boton;
    private JPanel panelInicial;
    private List<JLabel> labelList;
    private List<JTextField> textoList;
    private List<JButton> botonList;
    private JComboBox combo;
    private GestionDato gD;

    public VentanaAsistente(String title, GestionDato gD) {
        super(title, true, true, true, true);
        this.gD = gD;
        this.setSize(500, 400);
        this.setLocation(20, 20);
        this.iniciaCompontente();
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

    public JButton getBoton() {
        return boton;
    }

    public void setBoton(JButton boton) {
        this.boton = boton;
    }

    public JPanel getPanelInicial() {
        return panelInicial;
    }

    public void setPanelInicial(JPanel panelInicial) {
        this.panelInicial = panelInicial;
    }

    public List<JLabel> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<JLabel> labelList) {
        this.labelList = labelList;
    }

    public List<JTextField> getTextoList() {
        return textoList;
    }

    public void setTextoList(List<JTextField> textoList) {
        this.textoList = textoList;
    }

    public List<JButton> getBotonList() {
        return botonList;
    }

    public void setBotonList(List<JButton> botonList) {
        this.botonList = botonList;
    }

    public GestionDato getgD() {
        return gD;
    }

    public void setgD(GestionDato gD) {
        this.gD = gD;
    }

    public JComboBox getCombo() {
        return combo;
    }

    public void setCombo(JComboBox combo) {
        this.combo = combo;
    }

    public void iniciaCompontente() {

        //Ingreso de datos
        this.panelInicial = new JPanel(new BorderLayout());
        JPanel panelNorte = new JPanel(new BorderLayout());

        this.labelList = new ArrayList<JLabel>();
        this.labelList.add(new JLabel("Codigo :"));
        this.labelList.add(new JLabel("Nombre :"));
        this.labelList.add(new JLabel("Apellido :"));
        this.labelList.add(new JLabel("Cedula :"));
        this.labelList.add(new JLabel("Edad :"));
        this.labelList.add(new JLabel("Ingreso de Artistas"));

        this.textoList = new ArrayList<JTextField>();
        for (int i = 0; i < this.labelList.size() - 1; i++) {
            this.textoList.add(new JTextField());
        }

        this.botonList = new ArrayList<JButton>();
        this.botonList.add(new JButton("Guardar"));
        this.botonList.add(new JButton("Limpiar"));
        for (int i = 0; i < this.botonList.size(); i++) {
            //this.botonList.get(i).addActionListener(new EventoVentanaArtista(this));
        }

        LayoutManager disDatos = new GridLayout(6, 2);
        LayoutManager disTitulo = new FlowLayout();

        JPanel panelTitulo = new JPanel(disTitulo);
        JPanel panelIngreso = new JPanel(disDatos);

        for (int i = 0; i < this.labelList.size() - 1; i++) {
            panelIngreso.add(this.labelList.get(i));
            panelIngreso.add(this.textoList.get(i));
        }

        panelTitulo.add(this.labelList.get(5));
        panelIngreso.add(this.botonList.get(0));
        panelIngreso.add(this.botonList.get(1));

        panelNorte.add(panelTitulo, BorderLayout.NORTH);
        panelNorte.add(panelIngreso, BorderLayout.CENTER);

        //Tabla 
        this.encabezado = new Object[5];
        this.encabezado[0] = "Codigo";
        this.encabezado[1] = "Nombre";
        this.encabezado[2] = "Apellido";
        this.encabezado[3] = "Cedula";
        this.encabezado[4] = "Edad";

        //this.datos=cargarDatos(this.gD.getAsistenteList().size(), this.encabezado.length);
        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);

        this.panelInicial.add(panelNorte, BorderLayout.NORTH);
        this.panelInicial.add(this.scroll, BorderLayout.CENTER);

        this.add(this.panelInicial);

    }
    public Object[][] cargarDatos(int f, int c){
        Object[][] retorno=new Object[f][c];
        int i=0;
        for(Asistente a:this.gD.getAsistenteList()){
            retorno[i][0]=a.getCodigo();
            retorno[i][1]=a.getNombre();
            retorno[i][2]=a.getApellido();
            retorno[i][3]=a.getCedula();
            retorno[i][4]=a.getEdad();
            i++;
        }
        return retorno;
    }

}

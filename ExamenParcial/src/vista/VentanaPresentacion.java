package vista;

import controlador.EventoVentanaPresentacion;
import controlador.GestionDato;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Artista;
import modelo.Festival;
import modelo.Presentacion;

public class VentanaPresentacion extends JInternalFrame {

    private Object [][] datos; 
    private Object [] encabezado;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scroll;
    private JButton boton;
    private JPanel panelInicial;
    private List<JLabel> labelList;
    private JTextField texto;
    private List<JButton> botonList;
    private List<JComboBox> combo;
    private GestionDato gD;

    public VentanaPresentacion(String title, GestionDato gD) {
        super(title, true, true, true, true);
        this.setSize(400, 350);
        this.setLocation(100, 300);
        this.gD = gD;
        this.iniciaComponente();
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

    public JTextField getTexto() {
        return texto;
    }

    public void setTexto(JTextField texto) {
        this.texto = texto;
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

    public List<JLabel> getLabelList() {
        return labelList;
    }

    public void setLabelList(List<JLabel> labelList) {
        this.labelList = labelList;
    }

    public List<JComboBox> getCombo() {
        return combo;
    }

    public void setCombo(List<JComboBox> combo) {
        this.combo = combo;
    }



    public void iniciaComponente() {
        this.panelInicial = new JPanel(new BorderLayout());
        JPanel panelNorte = new JPanel(new BorderLayout());

        this.labelList = new ArrayList<JLabel>();
        this.labelList.add(new JLabel("Festival :"));
        this.labelList.add(new JLabel("Artista :"));
        this.labelList.add(new JLabel("Orden :"));
        this.labelList.add(new JLabel("Registro de Presentacion"));

        this.texto = new JTextField();
        this.texto.add(new JTextField());
        
        this.botonList = new ArrayList<JButton>();
        this.botonList.add(new JButton("Guardar"));
        for (int i = 0; i < this.botonList.size(); i++) {
            this.botonList.get(i).addActionListener(new EventoVentanaPresentacion(this));
        }

        LayoutManager disDatos = new GridLayout(4, 2);
        LayoutManager disTitulo = new FlowLayout();

        JPanel panelTitulo = new JPanel(disTitulo);
        JPanel panelIngreso = new JPanel(disDatos);

        this.combo= new ArrayList<JComboBox>();
        this.combo.add(new JComboBox());
        this.combo.add(new JComboBox());
        
        
        panelIngreso.add(this.labelList.get(0));
        panelIngreso.add(this.combo.get(0));
        panelIngreso.add(this.labelList.get(1));
        panelIngreso.add(this.combo.get(1));
        panelIngreso.add(this.labelList.get(2));
        panelIngreso.add(this.texto);
        
       
        panelTitulo.add(this.labelList.get(3));
        panelIngreso.add(this.botonList.get(0));

        panelNorte.add(panelTitulo, BorderLayout.NORTH);
        panelNorte.add(panelIngreso, BorderLayout.CENTER);

        //Tabla 
        this.encabezado = new Object[3];
        this.encabezado[0] = "Aspirante";
        this.encabezado[1] = "Carrera";
        this.encabezado[2] = "Periodo";

        this.datos = cargarDatos(this.gD.getPresentacionList().size(), this.encabezado.length);
        this.modeloTabla = new DefaultTableModel(this.datos, this.encabezado);
        this.tabla = new JTable(this.modeloTabla);
        this.scroll = new JScrollPane(this.tabla);

        this.boton = new JButton("Actualizar");
        this.boton.addActionListener(new EventoVentanaPresentacion(this));

        this.panelInicial.add(panelNorte, BorderLayout.NORTH);
        this.panelInicial.add(this.scroll, BorderLayout.CENTER);
        this.panelInicial.add(this.boton, BorderLayout.SOUTH);

        this.add(this.panelInicial);

    }

    public Object[][] cargarDatos(int f, int k) {
        Object[][] retorno = new Object[f][k];
        int i = 0;
        for (Presentacion pr : this.gD.getPresentacionList()) {
            retorno [i][0]=pr.getFestival().getNombreFestival();
            retorno [i][1]=pr.getArtista().getNombre();
            retorno [i][2]=pr.getOrdenPresentacion();
            i++;
        }
        return retorno;
    }

    public void cargarCombo() {
        this.combo.get(0).removeAllItems();
        this.combo.get(1).removeAllItems();
        for (Festival f : this.gD.getFestivalList()) {
            this.combo.get(0).addItem(f.getCodigo() + " | " + f.getNombreFestival());
        }
        for (Artista c : this.gD.getArtistaList()) {
            this.combo.get(1).addItem(c.getCodigo() + " | " + c.getNombre());
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.EventoVentanaPrincipal;
import controlador.GestionDato;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Pulpo
 */
public class VentanaPrincipal extends JFrame {
      private JMenuBar menu;
    private JDesktopPane escritorio;
    private List<JMenu> menuList;
    private List<JMenuItem> menuItemList; 
    
   private GestionDato gD;
    private ResourceBundle rB;
    
    public VentanaPrincipal(String t , GestionDato gd){
        this.setTitle(t);
        this.setSize(700, 600);
        this.setLocation(300, 100);
        this.setDefaultCloseOperation(3);
        this.gD=gd;
        iniciaComponente();
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setVisible(true);
        
    }
    
    public void iniciaComponente(){
        this.menu= new JMenuBar();
        this.escritorio = new JDesktopPane();
        this.menuList= new ArrayList<JMenu>();
        this.menuList.add(new JMenu("Festival"));
        this.menuList.add(new JMenu("Artista"));
        this.menuList.add(new JMenu("Asistente"));
        this.menuList.add(new JMenu("Presentacion"));
        this.menuList.add(new JMenu("Boleto"));

        
        this.menuItemList=new ArrayList<JMenuItem>();
        this.menuItemList.add(new JMenuItem("Registro Festival"));
        this.menuItemList.add(new JMenuItem("Registro Artista"));
        this.menuItemList.add(new JMenuItem("Registro Asistente"));
        this.menuItemList.add(new JMenuItem("Registro Presentacion"));
        this.menuItemList.add(new JMenuItem("Registro Boleto"));
        
        this.setContentPane(this.escritorio);
        this.setJMenuBar(menu);
        this.menu.add(this.menuList.get(0));
        this.menu.add(this.menuList.get(1));
        this.menu.add(this.menuList.get(2));
        this.menu.add(this.menuList.get(3));
        this.menu.add(this.menuList.get(4));
        
        
        this.menuList.get(0).add(this.menuItemList.get(0));
        this.menuList.get(1).add(this.menuItemList.get(1));
        this.menuList.get(2).add(this.menuItemList.get(2));
        this.menuList.get(3).add(this.menuItemList.get(3));
        this.menuList.get(4).add(this.menuItemList.get(4));
        
        
        //this.menuItemList.get(0).addActionListener(new EventoVentanaPrincipal(this));
        //this.menuItemList.get(1).addActionListener(new EventoVentanaPrincipal(this));
        //this.menuItemList.get(2).addActionListener(new EventoVentanaPrincipal(this));
        //this.menuItemList.get(3).addActionListener(new EventoVentanaPrincipal(this));
        //this.menuItemList.get(4).addActionListener(new EventoVentanaPrincipal(this));
  
    }
    
    

    public JMenuBar getMenu() {
        return menu;
    }

    public void setMenu(JMenuBar menu) {
        this.menu = menu;
    }

    public JDesktopPane getEscritorio() {
        return escritorio;
    }

    public void setEscritorio(JDesktopPane escritorio) {
        this.escritorio = escritorio;
    }

    public List<JMenu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<JMenu> menuList) {
        this.menuList = menuList;
    }

    public List<JMenuItem> getMenuItemList() {
        return menuItemList;
    }

    public void setMenuItemList(List<JMenuItem> menuItemList) {
        this.menuItemList = menuItemList;
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
    

}

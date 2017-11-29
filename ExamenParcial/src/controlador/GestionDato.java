
package controlador;

import java.util.List;
import modelo.Artista;
import modelo.Asistente;
import modelo.Boleto;
import modelo.Festival;
import modelo.Presentacion;

public class GestionDato {
    
    private List<Artista> artistaList;
    private List<Asistente> asistenteList;
    private List<Boleto> boletoList;
    private List<Festival> festivalList;
    private List<Presentacion> presentacionList;

    public GestionDato(List<Artista> artistaList, List<Asistente> asistenteList, List<Boleto> boletoList, List<Festival> festivalList, List<Presentacion> presentacionList) {
        this.artistaList = artistaList;
        this.asistenteList = asistenteList;
        this.boletoList = boletoList;
        this.festivalList = festivalList;
        this.presentacionList = presentacionList;
    }
    
    

    public List<Artista> getArtistaList() {
        return artistaList;
    }

    public void setArtistaList(List<Artista> artistaList) {
        this.artistaList = artistaList;
    }

    public List<Asistente> getAsistenteList() {
        return asistenteList;
    }

    public void setAsistenteList(List<Asistente> asistenteList) {
        this.asistenteList = asistenteList;
    }

    public List<Boleto> getBoletoList() {
        return boletoList;
    }

    public void setBoletoList(List<Boleto> boletoList) {
        this.boletoList = boletoList;
    }

    public List<Festival> getFestivalList() {
        return festivalList;
    }

    public void setFestivalList(List<Festival> festivalList) {
        this.festivalList = festivalList;
    }

    public List<Presentacion> getPresentacionList() {
        return presentacionList;
    }

    public void setPresentacionList(List<Presentacion> presentacionList) {
        this.presentacionList = presentacionList;
    }

   

   
    public boolean addAsistente(Asistente as){
        boolean retorno;
        retorno=this.asistenteList.add(as);
        return retorno;
    }
    public boolean addArtista(Artista ar){
        boolean retorno;
        retorno = this.artistaList.add(ar);
        return retorno;
    }
    public boolean addFestival(Festival f){
        boolean retorno;
        retorno = this.festivalList.add(f);
        return retorno;
    }
    public boolean addBoleto(Boleto b){
        boolean retorno;
        retorno = this.boletoList.add(b);
        return retorno;
    }
    public boolean addPresentacion(Presentacion pr){
        boolean retorno;
        retorno= this.presentacionList.add(pr);
        return retorno;
    }

    @Override
    public String toString() {
        return "GestionDato{" + "artistaList=" + artistaList + ", asistenteList=" + asistenteList + ", boletoList=" + boletoList + ", festivalList=" + festivalList + ", presentacionList=" + presentacionList + '}';
    }
    
    public Asistente buscarAsistente(String txt) {
        Asistente retorno = null;
        int i = 0;
        for (Asistente a : this.asistenteList) {
            if (a.getNombre().equals(txt)) {
                i++;
                return a;
            }
        }
        return retorno;
    }
    
    public Presentacion buscarPresentacion(String txt) {
        Presentacion retorno = null;
        int i = 0;
        for (Presentacion p : this.presentacionList) {
            if (p.getFestival().equals(txt)) {
                i++;
                return p;
            }
        }
        return retorno;
    }
    public Artista buscarArtista(String txt){
        Artista retorno=null;
        int i=0;
        for(Artista ar : this.artistaList){
            if(ar.getNombre().equals(txt)){
                i++;
                return ar;
            }
        }
        return retorno;
    }
    
    public Festival buscarFestival(String txt){
        Festival retorno=null;
        int i=0;
        for(Festival fe : this.festivalList){
            if(fe.getNombreFestival().equals(txt)){
                i++;
                return fe;
            }
        }
        return retorno;
    }
}

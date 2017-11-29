
package controlador;

import java.util.List;
import modelo.Artista;
import modelo.Asistente;
import modelo.Boleto;
import modelo.Festival;
import modelo.Persona;
import modelo.Presentacion;

public class GestionDato {
    
    private List<Artista> artistaList;
    private List<Asistente> asistenteList;
    private List<Boleto> boletoList;
    private List<Festival> festivalList;
    private List<Presentacion> presentacionList;
    private List<Persona> personaList;

    public GestionDato(List<Artista> artistaList, List<Asistente> asistenteList, List<Boleto> boletoList, List<Festival> festivalList, List<Presentacion> presentacionList, List<Persona> personaList) {
        this.artistaList = artistaList;
        this.asistenteList = asistenteList;
        this.boletoList = boletoList;
        this.festivalList = festivalList;
        this.presentacionList = presentacionList;
        this.personaList = personaList;
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

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
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
    
}

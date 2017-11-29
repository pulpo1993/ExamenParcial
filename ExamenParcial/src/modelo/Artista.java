
package modelo;

/**
 *
 * @author Pulpo
 */
public class Artista extends Persona {
    private String generoMusical;
    private String  anioExperiencia;

    public Artista(String generoMusical, String anioExperiencia, String codigo, String nombre, String apellido, String cedula) {
        super(codigo, nombre, apellido, cedula);
        this.generoMusical = generoMusical;
        this.anioExperiencia = anioExperiencia;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public String getAnioExperiencia() {
        return anioExperiencia;
    }

    public void setAnioExperiencia(String anioExperiencia) {
        this.anioExperiencia = anioExperiencia;
    }

  
    
}

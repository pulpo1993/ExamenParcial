
package modelo;

/**
 *
 * @author Pulpo
 */
public class Artista extends Persona {
    private String generoMusical;
    private String  anioExperiencia;

    public Artista(int codigo, String nombre, String apellido, String cedula, String generoMusical, String anioExperiencia) {
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

    @Override
    public String toString() {
        return "Artista{" + "generoMusical=" + generoMusical + ", anioExperiencia=" + anioExperiencia + '}';
    }
    
}

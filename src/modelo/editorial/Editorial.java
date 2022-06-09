
package modelo.editorial;

/**
 *
 * @author Alejandro
 */
public class Editorial {
    private int codigo;
    private String nombre;
    private String direccion;
    
    /**
     * Constructor vacio
     */
    public Editorial() {}
    /**
     * Constructor con parametros
     * @param codigo Editorial
     * @param nombre Editorial
     * @param direccion Editorial
     */
    public Editorial(int codigo, String nombre, String direccion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
    }
    /**
     * Constructor al que le pasas una editorial
     * @param editorial de la clase Editorial
     */
    public Editorial(Editorial editorial) {
        this(editorial.getCodigo(),editorial.getNombre(),editorial.getDireccion());
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s, Codigo: %s, Direccion: %s\n ", nombre,codigo,direccion);
    }
    /**
     * Getters & Setters
     */
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Fin getters & Setters
     */
}

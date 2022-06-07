package modelo.libro;

import java.util.Objects;

/**
 *
 * @author Alejandro
 */
public class Libro {
    private String autor;
    private String nombre;
    private String  isbn;
    private Double precio;
    private String codigoEditorial;
    
    /**
     * Constructor vacio
     */
    public Libro() {}
    
    /**
     * Constructor con parametros
     * @param autor del libro
     * @param nombre del libro
     * @param isbn del libro
     * @param precio del libro
     * @param codigoEditorial del libro (codigo de la editorial del libro)
     */
    public Libro(String autor, String nombre, String isbn, Double precio, String codigoEditorial) {
        this.autor = autor;
        this.nombre = nombre;
        this.isbn = isbn;
        this.precio = precio;
        this.codigoEditorial = codigoEditorial;
    }
    
    /**
     * Constructor al que le pasas un objeto libro
     * @param libro de la clase Libro
     */
    public Libro(Libro libro) {
        this(libro.getAutor(),libro.getNombre(),libro.getIsbn(),libro.getPrecio(),libro.getCodigoEditorial());
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s, Autor: %s, ISBN: %-5s, Precio: %8.2f, CodigoEditorial: %8d\n", nombre,autor,isbn,precio,codigoEditorial);
    }
    /**
     * Getters & Setters
     */
    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCodigoEditorial() {
        return codigoEditorial;
    }

    public void setCodigoEditorial(String codigoEditorial) {
        this.codigoEditorial = codigoEditorial;
    }
    /**
     * Fin Getters & Setters
     */
}

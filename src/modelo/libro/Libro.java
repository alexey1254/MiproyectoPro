package modelo.libro;

import java.util.Objects;

/**
 *
 * @author Alejandro
 */
public class Libro {
    private String autor;
    private String nombre;
    private int  isbn;
    private int cantidad;
    private int codigoEditorial;
    
    /**
     * Constructor vacio
     */
    public Libro() {}
    
    /**
     * Constructor con parametros
     * @param autor del libro
     * @param nombre del libro
     * @param isbn del libro
     * @param cantidad que hay del libro
     * @param codigoEditorial del libro (codigo de la editorial del libro)
     */
    public Libro(String autor, String nombre, int isbn, int cantidad, int codigoEditorial) {
        this.autor = autor;
        this.nombre = nombre;
        this.isbn = isbn;
        this.cantidad = cantidad;
        this.codigoEditorial = codigoEditorial;
    }
    
    /**
     * Constructor al que le pasas un objeto libro
     * @param libro de la clase Libro
     */
    public Libro(Libro libro) {
        this(libro.getAutor(),libro.getNombre(),libro.getIsbn(),libro.getCantidad(),libro.getCodigoEditorial());
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s, Autor: %s, ISBN: %-5s, Cantidad: %d, CodigoEditorial: %8d\n", nombre,autor,isbn,cantidad,codigoEditorial);
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

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigoEditorial() {
        return codigoEditorial;
    }

    public void setCodigoEditorial(int codigoEditorial) {
        this.codigoEditorial = codigoEditorial;
    }
    /**
     * Fin Getters & Setters
     */
}

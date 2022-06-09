package controlador;

import modelo.editorial.*;
import vista.VistaBiblioteca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.EventListenerList;
import modelo.libro.Libro;
import modelo.libro.LibroDAO;
import java.util.*;

/**
 *
 * @author Alejandro
 */
public class ControladorBiblioteca implements ActionListener {

    VistaBiblioteca vista = new VistaBiblioteca();

    /**
     * Constructor que necesita un objeto de la clase VistaBiblioteca
     *
     * @param vista
     */
    public ControladorBiblioteca(VistaBiblioteca vista) {
        this.vista = vista;
    }

    /**
     * TODO: Hacer el metodo bien
     *
     * @return
     */
    //public Editorial getVistaEditorial() {
    //String nombre=this.vista.getEditorial();
    //}
    public void eventoBuscarLibro() {
        try {
            List<Libro> libros = LibroDAO.buscarLibros(vista.getInputBuscarLibro());
            if (libros.size() == 0) { // Si no hay libros
                this.vista.mostrarMensaje("No hay ningun libro con ese nombre");
            } else {
                String librosToString = "";
                for (Libro libro : libros) {
                    librosToString += (libro.toString());
                }
                vista.setOutputTexto(librosToString);
            }
        } catch (Exception e) {
            this.vista.mostrarMensaje(e.getMessage());
        }
    }

    public void eventoBuscarEditorial() {
        try {
            ArrayList<Editorial> editoriales = EditorialDAO.buscarEditorial(vista.getInputBuscarEditorial());
            if (editoriales.size() == 0) { // Si no hay libros
                this.vista.mostrarMensaje("No hay ninguna editorial con ese nombre");
            } else {
                String editorialesToString = "";
                for (Editorial editorial : editoriales) {
                    editorialesToString += (editorial.toString());
                }
                vista.setOutputTextoEditoriales(editorialesToString);
            }
        } catch (Exception e) {
            this.vista.mostrarMensaje(e.getMessage());
        }
    }

    /**
     * Comprueba que haya texto en alguno de los campos de busqueda
     *
     * @return 0 si no hay campos escritos, 1 si buscar libro tiene texto, 2 si
     * buscar editorial tiene texto, 3 si ambos están escritos.
     */
    public int comprobarTextoCamposDeBusqueda() {
        int lengthBuscarEditorial = vista.getInputBuscarEditorial().length();
        int lengthBuscarLibro = vista.getInputBuscarLibro().length();

        if (lengthBuscarEditorial == 0 && lengthBuscarLibro == 0) {
            return 0; // Ningun input está escrito.
        } else if (lengthBuscarLibro > 0 && lengthBuscarEditorial > 0) {
            return 3; // Si ambos campos están escritos
        } else if (lengthBuscarEditorial > 0) {
            return 2; // Si buscar editorial tiene texto
        } else {
            return 1; // Si buscar libro tiene texto
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals("Buscar")) { // Cuando pulse el boton de buscar:
            if (comprobarTextoCamposDeBusqueda() == 0) { // Rellenar con buscar Editorial
                vista.mostrarMensaje("Inserta algo en uno de los campos de búsqueda.");
            } else if(comprobarTextoCamposDeBusqueda()==3) {
                eventoBuscarEditorial();
                eventoBuscarLibro();
            } else if(comprobarTextoCamposDeBusqueda()==2) {
                eventoBuscarEditorial();
            } else if(comprobarTextoCamposDeBusqueda()==1){
                eventoBuscarLibro();
            }
        }
    }

    public void inicia() {
        this.vista.setControlador(this);
        this.vista.setVisible(true);
    }
}

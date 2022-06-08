package main;
import vista.VistaBiblioteca;
import controlador.*;

/**
 *
 * @author Alejandro
 * 
 */
public class BibliotecaApp {
    public static void main(String[] args) {
        VistaBiblioteca vista = new VistaBiblioteca();
        ControladorBiblioteca controlador = new ControladorBiblioteca(vista);
        controlador.inicia();
        
    }
}


package controlador;

import modelo.editorial.Editorial;
import vista.VistaBiblioteca;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.EventListenerList;

/**
 *
 * @author Alejandro
 */
public class ControladorBiblioteca implements ActionListener {
    VistaBiblioteca vista = new VistaBiblioteca();
    
    /**
     * Constructor que necesita un objeto de la clase VistaBiblioteca
     * @param vista 
     */
    public ControladorBiblioteca(VistaBiblioteca vista) {
        this.vista=vista;
    }
    
    /**
     * TODO: Hacer el metodo bien
     * @return 
     */
    public Editorial getVistaEditorial() {
        String nombre=this.vista.getEditorial();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

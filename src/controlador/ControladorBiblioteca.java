
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
    //public Editorial getVistaEditorial() {
        //String nombre=this.vista.getEditorial();
        
    //}

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (evento.getActionCommand().equals("Buscar")) {
            
        } else if(evento.getActionCommand().equals("inputBuscarLibro")){
            
        } else if(evento.getActionCommand().equals("inputBuscarEditorial")) {
            
        }
    }
    public void inicia(){
        this.vista.setControlador(this);
        this.vista.setVisible(true);
    }
}

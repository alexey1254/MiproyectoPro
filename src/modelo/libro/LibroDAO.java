
package modelo.libro;
import modelo.Conexion;
import java.sql.*;
import java.util.*;

/**
 *
 * @author daw
 */
public class LibroDAO {
    /**
     * No necesita instanciarse un objeto de esta clase
     */
    private LibroDAO() {}
    
    /**
     * Convierte un registro de la tabla libros a un objeto Libro
     * @param rs ResulSet obtenido de una consulta
     * @return el objeto que representa al registro obtenido
     * @throws SQLException 
     */
    private static Libro registroLibro(ResultSet rs)  {
        Libro libro=new Libro();
        try {
            libro.setAutor(rs.getString("autor"));
            libro.setCodigoEditorial(rs.getString("codigoEditorial"));
            libro.setIsbn(rs.getString("isbn"));
            libro.setNombre(rs.getString("nombre"));
            libro.setPrecio(rs.getDouble("precio"));
            return libro;
        } catch (SQLException ex) {
        }
        return null;
    }
    
    private static int numeroLibrosEditorial() {
        ResultSet rs=Conexion.consulta("SELECT count(*) AS numeroLibros FROM libros join editoriales as");
    }
    
}

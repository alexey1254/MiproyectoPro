
package modelo.libro;
import modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Alejandro
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
            libro.setCodigoEditorial(rs.getInt("codigoEditorial"));
            libro.setIsbn(rs.getInt("isbn"));
            libro.setNombre(rs.getString("titulo"));
            libro.setCantidad(rs.getInt("cantidad"));
            return libro;
        } catch (SQLException ex) {
        }
        return null;
    }
    
    /**
     * Busca un libro
     * @param nombre del libro
     * @return
     * @throws Exception 
     */
    public static ArrayList<Libro> buscarLibros(String nombreLibro) throws Exception {
        String sql="SELECT * from libros where titulo LIKE '%"+nombreLibro+"%'";
        ArrayList<Libro> libros = new ArrayList<>();
        PreparedStatement ps = Conexion.getPreparedStatement(sql);
                if (!ps.execute()) {
            throw new Exception("buscarLibro: Error accediendo a la tabla libros");
        }
        ResultSet rs=ps.getResultSet();
        while (rs.next()) {
            libros.add(LibroDAO.registroLibro(rs));
        }
        return libros;
    }
    public static void main(String[] args) throws Exception {
        
    }
}

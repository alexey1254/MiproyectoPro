
package modelo.libro;
import modelo.Conexion;
import java.sql.*;

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
            libro.setNombre(rs.getString("nombre"));
            libro.setCantidad(rs.getInt("precio"));
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
    public static Libro buscarLibro(String nombre) throws Exception {
        String sql="SELECT * from libros where nombre LIKE('%?%')";
        PreparedStatement ps = Conexion.getPreparedStatement(sql);
        ps.setString(1, nombre);
                if (!ps.execute()) {
            throw new Exception("buscarLibro: Error accediendo a la tabla libros");
        }
        ResultSet rs=ps.getResultSet();
        if (rs.next()) {
            return LibroDAO.registroLibro(rs);
        }
        return null;
    }
    
}

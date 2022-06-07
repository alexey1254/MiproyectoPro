
package modelo.editorial;
import modelo.Conexion;
import java.sql.*;
/**
 *
 * @author Alejandro
 */
public class EditorialDAO {
    /**
     * Constructor privado, no hace falta instanciar un objeto
     */
    private EditorialDAO() {}
    
    /**
     * Convierte un registro de la tabla editorial a un objeto Editorial
     * @param rs ResulSet obtenido de una consulta
     * @return el objeto que representa al registro obtenido
     * @throws SQLException 
     */
    private static Editorial registroEditorial(ResultSet rs)  {
        Editorial editorial=new Editorial();
        try {
            editorial.setCodigo(rs.getInt("codigo"));
            editorial.setDireccion(rs.getString("direccion"));
            editorial.setNombre(rs.getString("nombre"));
            return editorial;
        } catch (SQLException ex) {
        }
        return null;
    }
    
    /**
     * Número total de registros que hay en la tabla editoriales
     * @return el número de productos que hay en la base de datos
     * @throws Exception 
     */
    public static int numEditoriales() throws Exception {
        ResultSet rs=Conexion.consulta("SELECT count(*) AS numEditoriales FROM editoriales");
        if (rs!=null && rs.next()) {
            return rs.getInt("numEditoriales");
        }
        return -1;
    }
    
     /**
     * Obtiene el registro Editoriales con clave codigo y lo devuelve como
     * un objeto de la clase Editorial
     * @param codigo del producto
     * @return La editorial de la tabla editoriales cuya clave sea codigo, null si no hay éxito //
     * o null si el producto no se encuentra
     * @throws Exception 
     */
    public static Editorial getEditorial(String codigo) throws Exception {
        String sql="SELECT * FROM editoriales WHERE codigo=?";
        PreparedStatement ps=Conexion.getPreparedStatement(sql);
        ps.setString(1, codigo);
        if (!ps.execute()) {
            throw new Exception("getEditorial: Error accediendo a la tabla Editoriales. Código de editorial: "+codigo);
        }
        ResultSet rs=ps.getResultSet();
        if (rs.next()) {
            return EditorialDAO.registroEditorial(rs);
        }
        return null;
    }
    /**
     * 
     * @param editorial a actualizar
     * @return 0 Si hay error, 1 si no hay error (Numero de filas afectadas)
     * @throws Exception 
     */
    public static int actualizarEditorial(Editorial editorial) throws Exception {
        String sql="UPDATE editoriales SET codigo=?, nombre=?, direccion=? WHERE codigo=?";
        PreparedStatement ps=Conexion.getPreparedStatement(sql);
        ps.setInt(1, editorial.getCodigo());
        ps.setString(2, editorial.getNombre());
        ps.setString(3, editorial.getDireccion());
        ps.setInt(4, editorial.getCodigo());
        return ps.executeUpdate();
    }
    
    /**
     * Inserta un nuevo registro con los datos de la editorial
     * @param editorial para insertar
     * @return 0 si da error, 1 si no da error
     * @throws Exception 
     */
    public static int insertarEditorial(Editorial editorial) throws Exception {
        String sql="INSERT INTO editoriales VALUES(?,?,?)";
        PreparedStatement ps = Conexion.getPreparedStatement(sql);
        ps.setInt(1, editorial.getCodigo());
        ps.setString(2, editorial.getNombre());
        ps.setString(3, editorial.getDireccion());
        return ps.executeUpdate();
    }
    
    /**
     * Borra una editorial
     * @param codigo de la editorial
     * @return 0 si da error, 1 si no da error
     * @throws Exception 
     */
    public static int borrarEditorial(String codigo) throws Exception {
        String sql="DELETE FROM producto WHERE codigo=?";
        PreparedStatement ps = Conexion.getPreparedStatement(sql);
        ps.setString(1, codigo);
        return ps.executeUpdate();
    }
    
    /**
     * Busca una editorial
     * @param nombreEditorial
     * @return
     * @throws Exception 
     */
    public static Editorial buscarEditorial(String nombreEditorial) throws Exception {
        String sql="SELECT * from editoriales where nombre LIKE('%?%')";
        PreparedStatement ps = Conexion.getPreparedStatement(sql);
        ps.setString(1,nombreEditorial);
        if (!ps.execute()) {
            throw new Exception("buscarEditorial: Error accediendo a la tabla Editoriales");
        }
        ResultSet rs=ps.getResultSet();
        if (rs.next()) {
            return EditorialDAO.registroEditorial(rs);
        }
        return null;
    }  
}

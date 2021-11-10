
package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.encargado;
/**
 *
 * @author eddie.hernandezusam
 */
public class encargadoDAO extends conexion{
    
     public ArrayList<encargado> llenarEncargado() throws  Exception{
        ArrayList<encargado> lista = new ArrayList<encargado>();
        try {
           this.Conectar();
           String query="SELECT id_encargado,nombre_empleado FROM bdencargado;";
           PreparedStatement smt = this.getCnx().prepareStatement(query);
           ResultSet rt = smt.executeQuery();
           while (rt.next()){
            encargado e = new encargado();
            e.setId_encargado(rt.getInt("id_encargado"));
            e.setNombre_empleado(rt.getString("nombre_empleado"));
           lista.add(e);
           }
           
        } catch (Exception e) {
       }finally{
            this.Desconectar();
        }
        return lista;
   }
}

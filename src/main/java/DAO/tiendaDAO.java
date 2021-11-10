
package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.tienda;
/**
 *
 * @author eddie.hernandezusam
 */
public class tiendaDAO  extends conexion{
    
   public ArrayList<tienda> llenarTienda() throws  Exception{
        ArrayList<tienda> lista = new ArrayList<tienda>();
        try {
           this.Conectar();
           String query="SELECT id_tienda,region,nombre_tienda,giro_comercial,turno FROM bdtienda;";
           PreparedStatement smt = this.getCnx().prepareStatement(query);
           ResultSet rt = smt.executeQuery();
           while (rt.next()){
            tienda t = new tienda();
            t.setId_tienda(rt.getInt("id_tienda"));
            t.setRegion(rt.getString("region"));
            t.setNombre_tienda(rt.getNString("nombre_tienda"));
            t.setGiro_comercial(rt.getString("giro_comercial"));
            t.setTurno(rt.getString("turno"));
           lista.add(t);
           }
           
        } catch (Exception e) {
       }finally{
            this.Desconectar();
        }
        return lista;
   }
}


package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.venta;
/**
 *
 * @author eddie.hernandezusam
 */
public class ventaDAO extends conexion{
    
     public ArrayList<venta> llenarVenta() throws  Exception{
        ArrayList<venta> lista = new ArrayList<venta>();
        try {
           this.Conectar();
           String query="SELECT id_venta, producto , monto_venta FROM bdventa;";
           PreparedStatement smt = this.getCnx().prepareStatement(query);
           ResultSet rt = smt.executeQuery();
           while (rt.next()){
            venta v = new venta();
           v.setId_venta(rt.getInt("id_venta"));
           v.setProducto(rt.getString("producto"));
           v.setMonto_venta(rt.getInt("monto_venta"));
           lista.add(v);
           }
           
        } catch (Exception e) {
       }finally{
            this.Desconectar();
        }
        return lista;
   }
}

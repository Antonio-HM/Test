package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.*;

public class registroDAO extends conexion {
    
    public void eliminar(int id) throws  Exception{
 
        try {
            this.Conectar();
            String query ="delete from registro  where id_registro =?";
            PreparedStatement smt = this.getCnx().prepareStatement(query);
            smt.setInt(1, id);
            smt.executeUpdate();
        } catch (Exception e){
            throw e;
        }finally{
          this.Desconectar();
        }
   }
    
    public void Insertar (registro re) throws Exception{
        try {
            this.Conectar();
            String query ="insert into registro (id_tienda) value (?);";
            PreparedStatement smt =this.getCnx().prepareStatement(query);
            smt.setInt(1,re.getDatatienda().getId_tienda());
            smt.executeUpdate();
        } catch (Exception e) {
         throw e;
        }finally{
        this.Desconectar();
        }
}
           
    public ArrayList<registro> llenarData() throws Exception {

        ArrayList<registro> lista = new ArrayList<registro>();
        try {
            this.Conectar();
            String query = "select  r.id_registro,t.nombre_tienda,t.region,t.giro_comercial,t.turno,e.nombre_empleado,v.producto,v.monto_venta from registro r \n"
                    + "inner join bdtienda t on r.id_tienda = t.id_tienda\n"
                    + "inner join bdencargado e on e.id_encargado = t.id_encargado\n"
                    + "inner join bdventa v on v.id_venta = e.id_venta order by  r.id_registro;";

            PreparedStatement smt = this.getCnx().prepareStatement(query);
            ResultSet rt = smt.executeQuery();

            while (rt.next()) {

                venta v = new venta();
                encargado e = new encargado();
                tienda t = new tienda();
                registro r = new registro();

                r.setId_registro(rt.getInt("r.id_registro"));
                t.setRegion(rt.getString("t.region"));
                t.setNombre_tienda(rt.getString("t.nombre_tienda"));
                t.setGiro_comercial(rt.getString("t.giro_comercial"));
                t.setTurno(rt.getString("t.turno"));
                e.setNombre_empleado(rt.getString("e.nombre_empleado"));
                v.setProducto(rt.getString("v.producto"));
                v.setMonto_venta(rt.getShort("v.monto_venta"));
                t.setDataencargado(e);
                r.setDatatienda(t);
                e.setDataventa(v);
                lista.add(r);
            }

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        } finally {
            this.Desconectar();
        }
        return lista;
    }
}

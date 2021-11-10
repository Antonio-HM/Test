package DAO;
import java.sql.DriverManager;
import java.sql.Connection;

public class conexion {

    private String bd = "nkonoha";
    private String user = "root";
    private String pass = "root";
    private String ruta = "jdbc:mysql://localhost/" + bd + "?useSSL=false";

    private Connection cnx;

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }

    public void Conectar() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.cnx = DriverManager.getConnection(ruta, pass, user);
            if(this.cnx != null){
                System.out.println("conexion exitosa");

            } else {
                System.out.println("conexion fallida");
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    public void Desconectar() throws Exception {
        try {
            this.cnx.close();
        } catch (Exception e) {
        }

    }
}

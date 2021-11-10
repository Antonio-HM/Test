package DAO;

public class testing {

    public static void main(String[] args) {
        try {
            conexion c = new conexion();                                
              c.Conectar();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

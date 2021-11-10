
package model;

public class registro {
 
    private int id_registro;
    private String region;
    private tienda datatienda;

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public tienda getDatatienda() {
        return datatienda;
    }

    public void setDatatienda(tienda datatienda) {
        this.datatienda = datatienda;
    }
    
}

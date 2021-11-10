
package model;

/**
 *
 * @author kamus
 */
public class tienda {
    private int id_tienda;
    private String nombre_tienda;
    private String region; 
    private String giro_comercial;
    private String turno;
    private encargado dataencargado;

    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public String getNombre_tienda() {
        return nombre_tienda;
    }

    public void setNombre_tienda(String nombre_tienda) {
        this.nombre_tienda = nombre_tienda;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGiro_comercial() {
        return giro_comercial;
    }

    public void setGiro_comercial(String giro_comercial) {
        this.giro_comercial = giro_comercial;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public encargado getDataencargado() {
        return dataencargado;
    }

    public void setDataencargado(encargado dataencargado) {
        this.dataencargado = dataencargado;
    }

 
}

   
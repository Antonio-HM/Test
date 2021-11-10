
package model;

/**
 *
 * @author kamus
 */
public class encargado {
     
    private int id_encargado;
    private String nombre_empleado;
    private venta dataventa;

    public int getId_encargado() {
        return id_encargado;
    }

    public void setId_encargado(int id_encargado) {
        this.id_encargado = id_encargado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public venta getDataventa() {
        return dataventa;
    }

    public void setDataventa(venta dataventa) {
        this.dataventa = dataventa;
    }
}
    
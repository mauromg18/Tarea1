import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String rut;
    private Direccion direccion;
    private final ArrayList<OrdenCompra> compras;

    public Cliente(String nombre, String rut, Direccion direccion) {
        this.nombre = nombre;
        this.rut = rut;
        this.direccion = direccion;
        this.compras = new ArrayList<>();
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return this.rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public Direccion getDireccion() {
        return this.direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public void addCompra(OrdenCompra compra) {
        this.compras.add(compra);
    }

    public OrdenCompra getCompra(int i) {
        if (i < 0 || i > this.compras.size() - 1) return null;
        return this.compras.get(i);
    }

    public String toString() {
        return "Cliente " + this.nombre
                + " Rut: " + this.rut
                + " " + this.direccion.toString();
    }
}
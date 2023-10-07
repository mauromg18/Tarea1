import java.util.Date;

public class Factura extends DocTributario {
    public Factura(String numero, String rut, Date fecha, Direccion direccion, OrdenCompra compra) {
        super(numero, rut, fecha, direccion, compra);
    }

    public String toString() {
        return " La Factura " + super.toString();
    }
}
import java.util.Date;

public class Boleta extends DocTributario {
    public Boleta(String numero,String rut,Date fecha, Direccion direccion, OrdenCompra compra) {
        super(numero, rut, fecha, direccion, compra);
    }

    public String toString() {
        return "Boleta " + super.toString();
    }
}
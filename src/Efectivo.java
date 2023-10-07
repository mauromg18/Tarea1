import java.util.Date;

public class Efectivo extends Pago {
    public Efectivo(float monto, Date fecha, OrdenCompra compra) {
        super(monto, fecha, compra);
    }

    public float calcDevolucion() {
        return this.getMonto() - this.getCompra().calcPrecio();
    }

    public String toString() {
        return " En Efectivo " + super.toString();
    }
}
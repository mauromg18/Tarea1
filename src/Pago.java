import java.util.Date;

public abstract class Pago {
    private float monto;
    private Date fecha;
    private OrdenCompra compra;

    public Pago(float monto, Date fecha, OrdenCompra compra) {
        this.monto = monto;
        this.fecha = fecha;
        this.compra = compra;
    }

    public float getMonto() {
        return this.monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public OrdenCompra getCompra() {
        return this.compra;
    }

    public void setCompra(OrdenCompra compra) {
        this.compra = compra;
    }

    public String toString() {
        return "Monto : " + this.monto
                + "Fecha : " + this.fecha.toString();
    }
}
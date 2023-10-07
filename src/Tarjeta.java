import java.util.Date;

public class Tarjeta extends Pago {
    private String tipo;
    private String numTransaccion;

    public Tarjeta(float monto, Date fecha, String tipo, String numTransaccion, OrdenCompra compra) {
        super(monto, fecha, compra);
        this.tipo = tipo;
        this.numTransaccion = numTransaccion;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumTransaccion() {
        return this.numTransaccion;
    }

    public void setNumTransaccion(String numTransaccion) {
        this.numTransaccion = numTransaccion;
    }

    public String toString() {
        return " Con Tarjeta " + this.tipo
                + " Numero Transaccion: " + this.numTransaccion
                + " " + super.toString();
    }
}
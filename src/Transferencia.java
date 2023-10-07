import java.util.Date;

public class Transferencia extends Pago {
    private String banco;
    private String numCuenta;

    public Transferencia(float monto, Date fecha, String banco, String numCuenta, OrdenCompra compra) {
        super(monto, fecha, compra);
        this.banco = banco;
        this.numCuenta = numCuenta;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getNumCuenta() {
        return this.numCuenta;
    }

    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String toString() {
        return "Transferencia"
                + " nombre del Banco: " + this.banco
                + " numero de Cuenta: " + this.numCuenta
                + " " + super.toString();
    }
}
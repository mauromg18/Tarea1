import java.util.ArrayList;
import java.util.Date;

public class OrdenCompra {
    private Date fecha;
    private String estado;
    private Cliente cliente;
    private DocTributario documento;
    private final ArrayList<Pago> pagos;
    private final ArrayList<DetalleOrden> ordenes;

    public OrdenCompra(Date fecha, String estado, Cliente cliente) {
        this.fecha = fecha;
        this.estado = estado;
        this.cliente = cliente;
        this.documento = null;
        this.pagos = new ArrayList<>();
        this.ordenes = new ArrayList<>();
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public DocTributario getDocumento() {
        return this.documento;
    }

    public void setDocumento(DocTributario documento) {
        this.documento = documento;
    }

    public void addPago(Pago pago) {
        this.pagos.add(pago);
    }

    public Pago getPago(int i) {
        if (i < 0 || i > this.pagos.size() - 1) return null;
        return this.pagos.get(i);
    }

    public void addDetalleOrden(Articulo articulo, int cantidad) {
        this.ordenes.add(new DetalleOrden(articulo, cantidad, this));
    }

    public DetalleOrden getOrden(int i) {
        if (i < 0 || i > this.ordenes.size() - 1) return null;
        return this.ordenes.get(i);
    }

    public float calcPrecioSinIVA() {
        float precio = 0;
        for (DetalleOrden orden : this.ordenes) {
            precio += orden.calcPrecioSinIVA();
        }
        return precio;
    }

    public float calcIVA() {
        float iva = 0;
        for (DetalleOrden orden : this.ordenes) {
            iva += orden.calcIVA();
        }
        return iva;
    }

    public float calcPrecio() {
        return this.calcPrecioSinIVA() + this.calcIVA();
    }

    public float calcPeso() {
        float peso = 0;
        for (DetalleOrden orden : this.ordenes) {
            peso += orden.calcPeso();
        }
        return peso;
    }

    public String toString() {
        return "OrdenCompra " + this.fecha
                + " Estado: " + this.estado
                + " $" + this.calcPrecio()
                + " (" + this.calcPeso() + "kilogramo)";
    }
}
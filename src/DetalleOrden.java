public class DetalleOrden {
    private Articulo articulo;
    private int cantidad;
    private OrdenCompra compra;

    public DetalleOrden(Articulo articulo, int cantidad, OrdenCompra compra) {
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.compra = compra;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Articulo getArticulo() {
        return this.articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public OrdenCompra getCompra() {
        return this.compra;
    }

    public void setCompra(OrdenCompra compra) {
        this.compra = compra;
    }

    public float calcPrecio() {
        return this.calcPrecioSinIVA() + calcIVA();
    }

    public float calcPrecioSinIVA() {
        return this.articulo.getPrecio() * this.cantidad;
    }

    public float calcIVA() {
        return this.calcPrecioSinIVA() * 0.19f;
    }

    public float calcPeso() {
        return this.articulo.getPeso() * this.cantidad;
    }

    public String toString() {
        return "DetalleOrden " + this.cantidad
                + "x " + this.articulo.getNombre()
                + " $" + this.calcPrecio()
                + " (" + this.calcPeso() + "kilogramo)";
    }
}
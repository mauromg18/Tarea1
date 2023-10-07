import java.util.Date;

public class Main {
    static final String ESTADO_COMPRANDO = "Comprando";
    static final String ESTADO_PAGANDO = "Pagando";
    static final String ESTADO_PAGADO = "Pagado";

    public static void main(String[] args) {
        final Direccion direccionV = new Direccion("Antonio Varas #576");
        final Direccion direccionI = new Direccion("Pasaje 6 oriente #1341");
        final Direccion direccionJ = new Direccion("Panamericana sur km.410");

        final Cliente Valeska = new Cliente("Valeska", "14.272.660-2", direccionV);
        final Cliente Isidora = new Cliente("Isidora", "21.690.828-7", direccionI);
        final Cliente Juana = new Cliente("Juana", "08.827.172-5", direccionJ);
        Main.printClientes(Valeska, Isidora, Juana);

        final Articulo cereal = new Articulo("Cereal", "Desayuno clasico", 1200, 0.4f);
        final Articulo galletas = new Articulo("Galletas", "Dulce para saciar el antojo dulce", 900, 0.8f);
        final Articulo Proteina  = new Articulo("Proteina", "Ayuda a suplementar alimentos y te ayuda a cumplir tus requerimientos", 2500, 1.5f);
        final Articulo jalea = new Articulo("jalea", "postre blando", 400, 0.1f);
        final Articulo bebida = new Articulo("bebida", "liquido gaseoso tomado como refresco", 1400, 3.0f);
        Main.printArticulos(cereal, galletas, Proteina, jalea, bebida);

        final OrdenCompra compraFinal = new OrdenCompra(new Date(), Main.ESTADO_COMPRANDO, Valeska);
        Valeska.addCompra(compraFinal);

        compraFinal.addDetalleOrden(cereal, 2);
        compraFinal.addDetalleOrden(galletas, 5);
        compraFinal.addDetalleOrden(Proteina, 0);
        compraFinal.addDetalleOrden(jalea, 2);
        compraFinal.addDetalleOrden(bebida, 3);
        Main.printCompra(Valeska.getCompra(0));


        compraFinal.setEstado(Main.ESTADO_PAGANDO);
        final Efectivo pagoEfectivoV = new Efectivo(20000, new Date(), compraFinal);
        compraFinal.addPago(pagoEfectivoV);
        Main.printCompra(Valeska.getCompra(0));


        final Boleta boletaV = new Boleta("26482916", Valeska.getRut(), new Date(), direccionV, compraFinal);
        compraFinal.setDocumento(boletaV);
        compraFinal.setEstado(Main.ESTADO_PAGADO);
        Main.printCompra(Valeska.getCompra(0));

        final OrdenCompra compraI = new OrdenCompra(new Date(), Main.ESTADO_COMPRANDO, Isidora);
        Isidora.addCompra(compraI);

        compraI.addDetalleOrden(cereal, 2);
        compraI.addDetalleOrden(galletas, 5);
        compraI.addDetalleOrden(Proteina, 2);
        compraI.addDetalleOrden(jalea, 3);
        compraI.addDetalleOrden(bebida, 1);
        Main.printCompra(Isidora.getCompra(0));


        compraI.setEstado(Main.ESTADO_PAGANDO);
        final float precioCompraI = compraI.calcPrecio();
        final Tarjeta pagoTarjetaI = new Tarjeta(precioCompraI, new Date(), "Debito", "561487712554791", compraI);
        compraI.addPago(pagoTarjetaI);
        Main.printCompra(Isidora.getCompra(0));


        final Boleta boletaI = new Boleta("64978514", Isidora.getRut(), new Date(), direccionI, compraI);
        compraI.setDocumento(boletaI);
        compraI.setEstado(Main.ESTADO_PAGADO);
        Main.printCompra(Isidora.getCompra(0));

        final OrdenCompra compraJ = new OrdenCompra(new Date(), Main.ESTADO_COMPRANDO, Juana);
        Juana.addCompra(compraJ);

        compraJ.addDetalleOrden(cereal, 4);
        compraJ.addDetalleOrden(galletas, 7);
        compraJ.addDetalleOrden(Proteina, 2);
        compraJ.addDetalleOrden(jalea, 16);
        compraJ.addDetalleOrden(bebida, 10);
        Main.printCompra(Juana.getCompra(0));


        compraJ.setEstado(Main.ESTADO_PAGANDO);
        final float precioCompraJ = compraJ.calcPrecio();
        final Transferencia transferencia1J = new Transferencia(precioCompraJ / 2, new Date(), "bancoestado", "085479123", compraJ);
        final Transferencia transferencia2J = new Transferencia(precioCompraJ / 2, new Date(), "bancoestado", "085479123", compraJ);
        compraJ.addPago(transferencia1J);
        compraJ.addPago(transferencia2J);
        Main.printCompra(Juana.getCompra(0));


        final Factura facturaJ = new Factura("15875496", Juana.getRut(), new Date(), direccionJ, compraJ);
        compraJ.setDocumento(facturaJ);
        compraJ.setEstado(Main.ESTADO_PAGADO);
        Main.printCompra(Juana.getCompra(0));
    }

    static public void printClientes(Cliente... clientes) {
        System.out.println("Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.toString());
        }
        System.out.println();
    }

    static public void printArticulos(Articulo... articulos) {
        System.out.println("Articulos disponibles:");
        for (Articulo articulo : articulos) {
            System.out.println(articulo.toString());
        }
        System.out.println();
    }

    static public void printCompra(OrdenCompra compra) {
        final String estado = compra.getEstado();
        System.out.println(compra.toString());
        System.out.println(compra.getCliente().toString());

        if (estado.equals(Main.ESTADO_COMPRANDO)) {
            System.out.println("En el carro:");
            int i = 0;
            DetalleOrden orden;

            while (true) {
                orden = compra.getOrden(i++);
                if (orden == null) break;
                System.out.println("#" + i + ": " + orden.toString());
            }

            System.out.println();
            return;
        }

        if (estado.equals(Main.ESTADO_PAGANDO)) {
            System.out.println("Pagado:");
            int i = 0;
            Pago pago;

            while (true) {
                pago = compra.getPago(i++);
                if (pago == null) break;
                System.out.println("#" + i + ": " + pago.toString());
            }

            System.out.println();
            return;
        }

        if (estado.equals(Main.ESTADO_PAGADO)) {
            Pago pago = compra.getPago(0);
            if (pago instanceof Efectivo efectivo) {
                System.out.println("Vuelto: " + efectivo.calcDevolucion());
            }

            System.out.println(compra.getDocumento().toString());
            System.out.println();
        }
    }
}
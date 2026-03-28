package Restaurante;

public class Mesa {
    private static long numeroMesa = 0;
    private int capacidad;
    private Pedido pedido;
    private double costoConsumido;
    private Export export;

    public Mesa(int capacidad, Export export) {
        this.capacidad = capacidad;
        this.export = export;
        this.costoConsumido = 0;
        numeroMesa++;
    }

    public double calcularCostoConsumido(TarjetaCredito tarjeta, double propina) {
        if (pedido.getItems().isEmpty()) {
            System.out.println("Error: No hay pedido asignado a la mesa.");
            return 0;
        }

        double costoTotal = pedido.calcularTotal();
        double descuento = tarjeta.calcularDescuento(pedido);
        double costoFinal = (costoTotal - descuento) * (1 + propina / 100);
        this.costoConsumido = Math.round(costoFinal * 100.0) / 100.0;
        export.guardarOperacion(this.costoConsumido);
        return this.costoConsumido;
    }

    public void agregarPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    // Getters y Setters
    public long getNumeroMesa() {
        return numeroMesa;
    }


    public int getCapacidad() {
        return capacidad;
    }

    public void setCostoConsumido(double costoConsumido) {
        this.costoConsumido = costoConsumido;
    }
}

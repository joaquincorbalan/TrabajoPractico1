package Restaurante;

public class ComarcaPlus extends TarjetaCredito {
    public ComarcaPlus(String numeroTarjeta, String titular, String compañia) {
        super(numeroTarjeta, titular, compañia);
    }

    @Override
    double calcularDescuento(Pedido pedido) {
        return pedido.calcularTotal() * 0.02;
    }
}

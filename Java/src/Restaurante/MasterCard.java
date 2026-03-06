package Restaurante;

public class MasterCard extends TarjetaCredito {
    public MasterCard(String numeroTarjeta, String titular, String compañia) {
        super(numeroTarjeta, titular, compañia);
    }

    @Override
    double calcularDescuento(Pedido pedido) {
        return pedido.calcularPlatos() * 0.02;
    }
}

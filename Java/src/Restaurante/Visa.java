package Restaurante;

public class Visa extends TarjetaCredito {

    public Visa(String numeroTarjeta, String titular, String compañia) {
        super(numeroTarjeta, titular, compañia);
    }

    @Override
    double calcularDescuento(Pedido pedido) {
        return pedido.calcularBebidas() * 0.03;
    }
}

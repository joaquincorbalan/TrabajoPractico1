package Restaurante;

public class TarjetaViedma extends TarjetaCredito {
    public TarjetaViedma(String numeroTarjeta, String titular, String compañia) {
        super(numeroTarjeta, titular, compañia);
    }

    @Override
    double calcularDescuento(Pedido pedido) {
        return 0;
    }
}

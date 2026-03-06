package Restaurante;

public abstract class TarjetaCredito {
    private String numeroTarjeta;
    private String titular;
    private String compañia;

    public TarjetaCredito(String numeroTarjeta, String titular, String compañia) {
        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
        this.compañia = compañia;
    }

    abstract double calcularDescuento(Pedido pedido);
}

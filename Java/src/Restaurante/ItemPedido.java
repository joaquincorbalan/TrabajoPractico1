package Restaurante;

public class ItemPedido {
    private Comida comida;
    private int cantidad;

    public ItemPedido(Comida comida, int cantidad) {
        this.comida = comida;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public double calcularPlatos() {
        return comida.calcularPlatos() * this.cantidad;
    }

    public double calcularBebidas() {
        return comida.calcularBebidas() * cantidad;
    }

    public double getPrecio() {
        return comida.getPrecio() * this.cantidad;
    }
}

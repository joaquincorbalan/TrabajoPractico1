package Restaurante;

public class ItemPedido {
    private Comida comida;
    private int cantidad;

    public ItemPedido(Comida comida, int cantidad) {
        this.comida = comida;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public Comida getComida() {
        return comida;
    }


    public double getPrecio() {
        return comida.getPrecio() * this.cantidad;
    }
}

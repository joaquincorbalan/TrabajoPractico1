package Restaurante;

import java.util.List;

public class Pedido {
    private List<ItemPedido> items;
    private boolean confirmado;

    public Pedido() {
        this.items = new java.util.ArrayList<>();
        this.confirmado = false;
    }

    public double calcularBebidas() {
        return items.stream()
                .mapToDouble(item -> item.calcularBebidas())
                .sum();
    }

    public double calcularPlatos() {
        return items.stream()
                .mapToDouble(item -> item.calcularPlatos())
                .sum();
    }

    public double calcularTotal() {
        return items.stream()
                .mapToDouble(ItemPedido::getPrecio)
                .sum();
    }

    public List<ItemPedido> getItems() {
        return items;
    }

    public void añadirItem(ItemPedido item) {
        this.items.add(item);
    }

    public void confirmarPedido() {
        this.confirmado = true;
    }

}

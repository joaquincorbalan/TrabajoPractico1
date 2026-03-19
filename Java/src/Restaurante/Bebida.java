package Restaurante;

public class Bebida extends Comida {
    public Bebida(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public double calcularBebidas() {
        return getPrecio();
    }

    @Override
    public double calcularPlatos() {
        return 0;
    }
}

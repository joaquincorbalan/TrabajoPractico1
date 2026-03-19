package Restaurante;

public class Plato extends Comida {

    public Plato(String nombre, double precio) {
        super(nombre, precio);
    }

    @Override
    public double calcularBebidas() {
        return 0;
    }

    @Override
    public double calcularPlatos() {
        return getPrecio();
    }
}

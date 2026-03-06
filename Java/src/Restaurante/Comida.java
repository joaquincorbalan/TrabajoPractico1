package Restaurante;

public class Comida {
    public static enum TipoComida {
        PLATO, BEBIDA
    }

    private String nombre;
    private TipoComida tipo;
    private double precio;

    public Comida(String nombre, double precio, TipoComida tipo) {
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
    }

    // Getters y Setters
    public TipoComida getTipo() {
        return tipo;
    }


    public double getPrecio() {
        return precio;
    }

}

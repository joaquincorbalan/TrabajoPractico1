package Restaurante;

public abstract class Comida {
    private String nombre;
    private double precio;


    public Comida(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public abstract double calcularBebidas();

    public abstract double calcularPlatos();

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
}

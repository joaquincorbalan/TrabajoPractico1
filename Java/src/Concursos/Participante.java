package Concursos;

public class Participante {
    private static int contadorId = 1;
    private int id;
    private String DNI;
    private String nombre;
    private int puntaje;

    public Participante(String nombre, String DNI) {
        this.id = contadorId++;
        this.nombre = nombre;
        this.puntaje = 0;
        this.DNI = DNI;
    }

    public String getDNI() {
        return DNI;
    }

    public int getId() {
        return this.id;
    }

    public static void resetContador() {
        contadorId = 1;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void aumentarPuntaje(int puntos) {
        this.puntaje += puntos;
    }

}

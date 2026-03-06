package Concursos;

public class Participante {
    private String DNI;
    private String nombre;
    private int puntaje;

    public Participante(String nombre, String DNI) {
        this.nombre = nombre;
        this.puntaje = 0;
        this.DNI = DNI;
    }

    public String getDNI() {
        return DNI;
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

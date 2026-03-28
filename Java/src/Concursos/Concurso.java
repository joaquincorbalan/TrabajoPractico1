package Concursos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private static int contadorId = 1;
    private int id;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private LocalDate fechaActual;
    private final int PUNTAJE_EXTRA = 10;
    private List<Participante> participantes;
    private Export export;

    public Concurso(LocalDate fechaInicial, LocalDate fechaFinal, LocalDate fechaActual, Export export) {
        this.id = contadorId++;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.fechaActual = fechaActual;
        this.participantes = new ArrayList<>();
        this.export = export;
    }

    public void agregarParticipante(Participante participante) throws IllegalStateException {
        if (estaFueraDelPeriodo()) {
            throw new IllegalStateException("No se pueden inscribir participantes fuera del período del concurso.");
        }

        if (participanteYaInscrito(participante)) {
            throw new IllegalStateException("El participante con DNI " + participante.getDNI() + " ya está inscrito en el concurso.");
        }
        if (esLaFechaInicial()) {
            participante.aumentarPuntaje(PUNTAJE_EXTRA);
        }

        participantes.add(participante);
        export.guardarInscripcion(participante.getId(), this.id);
    }

    private boolean participanteYaInscrito(Participante participante) {
        return participantes.stream()
                .anyMatch(p -> p.getDNI().equals(participante.getDNI()));
    }

    private boolean estaFueraDelPeriodo() {
        return this.fechaActual.isAfter(this.fechaFinal);
    }

    private boolean esLaFechaInicial() {
        return this.fechaActual.isEqual(this.fechaInicial);
    }


    public int mostrarPuntosParticipante(Participante participante) {
        return participantes.stream()
                .filter(p -> p.getDNI().equals(participante.getDNI()))
                .findFirst()
                .map(Participante::getPuntaje)
                .orElse(0);
    }

    public static void resetContador() {
        contadorId = 1;
    }
}

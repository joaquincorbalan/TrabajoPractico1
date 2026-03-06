package Concursos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Concurso {
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private LocalDate fechaActual;
    private final int PUNTAJE_EXTRA = 10;
    private List<Participante> participantes;

    public Concurso(LocalDate fechaInicial, LocalDate fechaFinal, LocalDate fechaActual) {
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.fechaActual = fechaActual;
        this.participantes = new ArrayList<>();
    }

    public boolean agregarParticipante(Participante participante) {
        if (estaFueraDelPeriodo()) {
            System.out.println("No se pueden agregar participantes después de la fecha final del concurso.");
            return false;
        }

        if (participantes.stream().anyMatch(p -> p.getDNI().equals(participante.getDNI()))) {
            System.out.println("El participante con DNI " + participante.getDNI() + " yamás está inscrito en el concurso.");
            return false;
        }
        if (esLaFechaInicial()) {
            participante.aumentarPuntaje(PUNTAJE_EXTRA);
        }

        participantes.add(participante);
        return true;
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
}

package Concurso;

import Concursos.Concurso;
import Concursos.Export;
import Concursos.Participante;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ConcursoTest {
    private Export export = new EnMemoriaExportConcurso();
    private Participante p = new Participante("Juan", "12345678");

    @BeforeEach
    void setUp() {
        Participante.resetContador();//Sugerencia de la IA ya que cada test deberia ser individual y no deberia ser influenciado por otro
        Concurso.resetContador();
    }


    @Test
    void testParticipanteYaIncrito() {
        //Inicializar
        LocalDate fechaInicio = LocalDate.of(2026, 2, 10);
        LocalDate fechaFinal = LocalDate.now().plusMonths(2);
        Concurso concurso = new Concurso(fechaInicio, fechaFinal, LocalDate.now(), export);
        //Entrenar
        concurso.agregarParticipante(p);
        //Verificar
        assertThrows(IllegalStateException.class, () -> concurso.agregarParticipante(p));


    }

    @Test
    void testParticipanteInscribeFueraDeFecha() {
        //Inicializar
        LocalDate fechaInicio = LocalDate.of(2026, 2, 10);
        LocalDate fechaFinal = LocalDate.of(2026, 2, 20);
        Concurso concurso = new Concurso(fechaInicio, fechaFinal, LocalDate.now(), export);

        //Entrenar y verificar
        assertThrows(IllegalStateException.class, () -> concurso.agregarParticipante(p));
    }

    @Test
    void testParticipanteIncribeFechaNormal() {
        //Inicializar
        LocalDate fechaInicio = LocalDate.now().minusDays(5);
        LocalDate fechaFinal = LocalDate.now().plusMonths(1);
        Concurso concurso = new Concurso(fechaInicio, fechaFinal, LocalDate.now(), export);
        //Entrenar
        concurso.agregarParticipante(p);
        //Verificar
        assertEquals(0, concurso.mostrarPuntosParticipante(p));
    }

    @Test
    void testParticipanteInscribeFechaInicial() {
        //Inicializar
        LocalDate fechaInicio = LocalDate.now();
        LocalDate fechaFinal = LocalDate.now().plusMonths(2);
        //Pongo dos fechas inicio para que la fecha de inicio y el dia de hoy sea el mismo
        Concurso concurso = new Concurso(fechaInicio, fechaFinal, fechaInicio, export);
        //Entrenar
        concurso.agregarParticipante(p);
        //Verificar
        assertEquals(10, concurso.mostrarPuntosParticipante(p));
    }
}

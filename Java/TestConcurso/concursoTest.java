import Concursos.Concurso;
import Concursos.Participante;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class concursoTest {

    @Test
    void testParticipanteYaIncrito() {
        //Inicializar
        LocalDate fechaInicio = LocalDate.of(2026, 2, 10);
        LocalDate fechaFinal = LocalDate.of(2026, 3, 20);
        Participante p = new Participante("Juan", "12345678");
        Concurso concurso = new Concurso(fechaInicio, fechaFinal, LocalDate.now());
        //Entrenar
        concurso.agregarParticipante(p);
        boolean resultado = concurso.agregarParticipante(p);
        //Verificar
        assertEquals(false, resultado);
    }

    @Test
    void testParticipanteInscribeFueraDeFecha() {
        //Inicializar
        LocalDate fechaInicio = LocalDate.of(2026, 2, 10);
        LocalDate fechaFinal = LocalDate.of(2026, 2, 20);
        Participante p = new Participante("Juan", "12345678");
        Concurso concurso = new Concurso(fechaInicio, fechaFinal, LocalDate.now());

        //Entrenar
        boolean resultado = concurso.agregarParticipante(p);
        //Verificar
        assertEquals(false, resultado);
    }

    @Test
    void testParticipanteIncribeFechaNormal() {
        //Inicializar
        LocalDate fechaInicio = LocalDate.of(2026, 2, 10);
        LocalDate fechaFinal = LocalDate.of(2026, 3, 20);
        Participante p = new Participante("Juan", "12345678");
        Concurso concurso = new Concurso(fechaInicio, fechaFinal, LocalDate.now());
        //Entrenar
        concurso.agregarParticipante(p);
        //Verificar
        assertEquals(0, concurso.mostrarPuntosParticipante(p));
    }

    @Test
    void testParticipanteInscribeFechaInicial() {
        //Inicializar
        LocalDate fechaInicio = LocalDate.of(2026, 3, 9);
        LocalDate fechaFinal = LocalDate.of(2026, 3, 20);
        Participante p = new Participante("Juan", "12345678");
        //Pongo dos fechas inicio para que la fecha de inicio y el dia de hoy sea el mismo
        Concurso concurso = new Concurso(fechaInicio, fechaFinal, fechaInicio);
        //Entrenar
        concurso.agregarParticipante(p);
        //Verificar
        assertEquals(10, concurso.mostrarPuntosParticipante(p));
    }
}

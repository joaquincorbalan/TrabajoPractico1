package Concurso;

import Concursos.Concurso;
import Concursos.Participante;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMemoriaConcurso {

    @Test
    public void test1() {
        var export = new EnMemoriaExportConcurso();
        Concurso concurso = new Concurso(LocalDate.now().minusDays(2), LocalDate.now().plusMonths(1), LocalDate.now(), export);
        concurso.agregarParticipante(new Participante("Joaquin", "44666492"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = LocalDate.now().format(formatter);
        assertEquals(fecha + "," + "1" + "," + "1", export.getData());
    }
}

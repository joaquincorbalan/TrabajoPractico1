package Concurso;

import Concursos.Concurso;
import Concursos.Participante;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEnmemoriaExportMail {
    @Test
    public void prueba() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = LocalDate.now().format(formatter);
        var export = new FakeExportMail();
        Concurso concurso = new Concurso(LocalDate.now().minusMonths(2), LocalDate.now().plusMonths(2),
                LocalDate.now(), export);
        concurso.agregarParticipante(new Participante("Joaquin Corbalan", "44666492"));
        assertEquals(fecha + ": " + "Fuiste registrado en el concurso N°" + 1 + ". Su numero de concunsarte es N°" +
                1, export.getData());
    }

}

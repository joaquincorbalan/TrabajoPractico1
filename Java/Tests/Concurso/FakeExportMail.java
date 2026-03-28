package Concurso;

import Concursos.Export;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FakeExportMail implements Export {
    private String data;

    @Override
    public void guardarInscripcion(int idParticipante, int idConcurso) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = LocalDate.now().format(formatter);
        data = fecha + ": " + "Fuiste registrado en el concurso N°" + idConcurso + ". Su numero de concunsarte es N°" +
                idParticipante;
    }
    

    public String getData() {
        return this.data;

    }
}

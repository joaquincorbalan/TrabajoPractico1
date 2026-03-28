package Concurso;

import Concursos.Export;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EnMemoriaExportConcurso implements Export {
    private String datos;

    @Override
    public void guardarInscripcion(int idParticipante, int idConcurso) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = LocalDate.now().format(formatter);
        this.datos = fecha + "," + idParticipante + "," + idConcurso;
    }

    public String getData() {
        return this.datos;
    }


}

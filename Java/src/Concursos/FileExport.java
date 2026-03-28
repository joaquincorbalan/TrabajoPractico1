package Concursos;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileExport implements Export {
    @Override
    public void guardarInscripcion(int idParticipante, int idConcurso) {
        try {
            FileWriter writer = new FileWriter("inscripciones.txt", true);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fecha = LocalDate.now().format(formatter);
            writer.write(fecha + "," + idParticipante + "," + idConcurso + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar inscripcion");
        }
    }
}

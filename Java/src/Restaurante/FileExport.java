package Restaurante;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FileExport implements Export {

    @Override
    public void guardarOperacion(double monto) {
        try {
            FileWriter writer = new FileWriter("Operaciones.txt", true);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fecha = LocalDate.now().format(formatter);
            writer.write(fecha + " || " + monto + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar inscripcion");
        }
    }
}
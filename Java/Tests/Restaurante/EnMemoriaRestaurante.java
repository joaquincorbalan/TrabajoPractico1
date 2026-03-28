package Restaurante;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EnMemoriaRestaurante implements Export {
    private String datos;


    @Override
    public void guardarOperacion(double monto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = LocalDate.now().format(formatter);
        this.datos = fecha + " || " + monto;
    }

    public String getDatos() {
        return this.datos;
    }
}

package Restaurante;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEnMemoriaRestaurante {
    @Test
    void test1() {
        var export = new EnMemoriaRestaurante();
        Mesa mesa = new Mesa(4, export);
        TarjetaViedma tarjeta = new TarjetaViedma("1234590123456", "Miguel Perez", "Viedma");
        Pedido pedido = new Pedido();
        Comida hamburguesa = new Plato("Milanesa", 1240);
        Comida papasFritas = new Plato("Papas Fritas", 650);
        Comida gaseosa = new Bebida("Gaseosa", 300);
        Comida cerveza = new Bebida("Cerveza", 500);
        pedido.añadirItem(new ItemPedido(hamburguesa, 2));
        pedido.añadirItem(new ItemPedido(papasFritas, 2));
        pedido.añadirItem(new ItemPedido(gaseosa, 1));
        pedido.añadirItem(new ItemPedido(cerveza, 1));
        mesa.agregarPedido(pedido);
        double resultado = mesa.calcularCostoConsumido(tarjeta, 5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = LocalDate.now().format(formatter);
        assertEquals(fecha + " || " + resultado,
                export.getDatos());
    }
}

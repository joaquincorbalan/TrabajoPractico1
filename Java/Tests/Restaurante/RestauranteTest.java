package Restaurante;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RestauranteTest {
    private Export export = new EnMemoriaRestaurante();

    //Metodo hecho a partir de la ultima clase donde se quito codigo repetido
    private static Pedido getPedido() {
        Pedido pedido = new Pedido();
        Comida hamburguesa = new Plato("Hamburguesa", 10.0);
        Comida papasFritas = new Plato("Papas Fritas", 5.0);
        Comida gaseosa = new Bebida("Gaseosa", 3.0);
        Comida cerveza = new Bebida("Cerveza", 4.0);
        //Añadir pedidos
        pedido.añadirItem(new ItemPedido(hamburguesa, 2));
        pedido.añadirItem(new ItemPedido(papasFritas, 2));
        pedido.añadirItem(new ItemPedido(gaseosa, 1));
        pedido.añadirItem(new ItemPedido(cerveza, 1));
        return pedido;
    }

    @Test
    void testCalcularDescuentoTarjetaViedma() throws Exception {
        // Inicializar
        Restaurante restaurante = new Restaurante();
        Mesa mesa = new Mesa(2, export);
        restaurante.agregarMesa(mesa);
        TarjetaViedma tarjeta = new TarjetaViedma("1234567890123456", "Juan Perez", "Viedma");
        //Calculo el resultado para sabe que valor esperar
        double resultado = ((10 * 2) + (5 * 2) + 3 + 4) * 1.05;
        //Entrenar
        restaurante.agregarPedido(mesa.getNumeroMesa(), getPedido());
        //Calcular el costo consumido con la tarjeta Viedma y una propina del 2, 3 o 5%
        double total = restaurante.calcularCostoMesa(mesa.getNumeroMesa(), tarjeta, 5);
        //Verificar
        assertEquals(resultado, total, 0.01);
    }

    @Test
    void testCalcularDescuentoTarjetaVisa() throws Exception {
        Restaurante restaurante = new Restaurante();
        Mesa mesa = new Mesa(2, export);
        restaurante.agregarMesa(mesa);
        Visa tarjeta = new Visa("1234567890123456", "Juan Perez", "Visa");
        //Calculo el resultado para sabe que valor esperar
        double bebidas = (3 + 4) * 0.03;
        double resultado = (((10 * 2) + (5 * 2) + 3 + 4) - bebidas) * 1.05;
        //Entrenar
        restaurante.agregarPedido(mesa.getNumeroMesa(), getPedido());
        //Calcular el costo consumido con la tarjeta Viedma y una propina del 2, 3 o 5%
        double total = restaurante.calcularCostoMesa(mesa.getNumeroMesa(), tarjeta, 5);
        //Verificar
        assertEquals(resultado, total, 0.01);
    }

    @Test
    void testCalcularDescuentoTarjetaMasterCard() throws Exception {
        Restaurante restaurante = new Restaurante();
        Mesa mesa = new Mesa(2, export);
        restaurante.agregarMesa(mesa);
        MasterCard tarjeta = new MasterCard("1234567890123456", "Juan Perez", "Viedma");
        //Calcular el resultado para sabe que valor esperar
        double platos = ((10 * 2) + (5 * 2)) * 0.02;
        double resultado = (((10 * 2) + (5 * 2) + 3 + 4) - platos) * 1.05;
        //Entrenar
        restaurante.agregarPedido(mesa.getNumeroMesa(), getPedido());
        //Calcular el costo consumido con la tarjeta Viedma y una propina del 2, 3 o 5%
        double total = restaurante.calcularCostoMesa(mesa.getNumeroMesa(), tarjeta, 5);
        //Verificar
        assertEquals(resultado, total, 0.01);
    }

    @Test
    void testCalcularDescuentoTarjetaComarcaPlus() throws Exception {
        Restaurante restaurante = new Restaurante();
        Mesa mesa = new Mesa(2, export);
        restaurante.agregarMesa(mesa);
        ComarcaPlus tarjeta = new ComarcaPlus("1234567890123456", "Juan Perez", "Viedma");
        //Calculo el resultado para sabe que valor esperar
        double resultado = ((10 * 2) + (5 * 2) + 3 + 4);
        resultado = ((resultado - (resultado * 0.02)) * 1.05);
        //Agrego el pedido
        restaurante.agregarPedido(mesa.getNumeroMesa(), getPedido());
        //Calcular el costo consumido con la tarjeta Viedma y una propina del 2, 3 o 5%
        double total = restaurante.calcularCostoMesa(mesa.getNumeroMesa(), tarjeta, 5);
        //Verificar
        assertEquals(resultado, total, 0.01);
    }

    @Test
    void testPedidoVacio() throws Exception {
        Restaurante restaurante = new Restaurante();
        Mesa mesa = new Mesa(2, export);
        restaurante.agregarMesa(mesa);
        TarjetaViedma tarjetaCredito = new TarjetaViedma("1234567890123456", "Juan Perez", "Loco");
        Pedido pedido = new Pedido();

        //Entrenar
        restaurante.agregarPedido(mesa.getNumeroMesa(), pedido);
        double total = restaurante.calcularCostoMesa(mesa.getNumeroMesa(), tarjetaCredito, 5);
        //Verificar
        assertEquals(0.0, total);
    }

    @Test
    void testMesaNoEncontrada() throws Exception {
        Restaurante restaurante = new Restaurante();
        TarjetaViedma tarjetaCredito = new TarjetaViedma("1234567890123456", "Juan Perez", "Loco");
        Pedido pedido = new Pedido();

        //Entrenar
        assertThrows(Exception.class, () -> restaurante.agregarPedido(999, pedido));

    }
}

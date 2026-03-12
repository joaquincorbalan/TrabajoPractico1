import Restaurante.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RestauranteTest {
    @Test
    void testCalcularDescuentoTarjetaViedma() throws Exception {
        // Inicializar
        Restaurante restaurante = new Restaurante();
        Mesa mesa = new Mesa(2);
        TarjetaViedma tarjeta = new TarjetaViedma("1234567890123456", "Juan Perez", "Viedma");
        Pedido pedido = new Pedido();
        Comida hamburguesa = new Comida("Hamburguesa", 10.0, Comida.TipoComida.PLATO);
        Comida papasFritas = new Comida("Papas Fritas", 5.0, Comida.TipoComida.PLATO);
        Comida gaseosa = new Comida("Gaseosa", 3.0, Comida.TipoComida.BEBIDA);
        Comida cerveza = new Comida("Cerveza", 4.0, Comida.TipoComida.BEBIDA);

        pedido.añadirItem(new ItemPedido(hamburguesa, 2));
        pedido.añadirItem(new ItemPedido(papasFritas, 2));
        pedido.añadirItem(new ItemPedido(gaseosa, 1));
        pedido.añadirItem(new ItemPedido(cerveza, 1));
        //Entrenar
        restaurante.agregarPedido(mesa.getNumeroMesa(), pedido);
        //Calcular el costo consumido con la tarjeta Viedma y una propina del 2, 3 o 5%
        double total = restaurante.calcularCostoMesa(mesa.getNumeroMesa(), tarjeta, 5);
        //Verificar
        assertEquals(38.85, total);
    }

    @Test
    void testCalcularDescuentoTarjetaVisa() throws Exception {
        Restaurante restaurante = new Restaurante();
        Mesa mesa = new Mesa(2);
        Visa tarjeta = new Visa("1234567890123456", "Juan Perez", "Visa");
        Pedido pedido = new Pedido();
        Comida hamburguesa = new Comida("Hamburguesa", 10.0, Comida.TipoComida.PLATO);
        Comida papasFritas = new Comida("Papas Fritas", 5.0, Comida.TipoComida.PLATO);
        Comida gaseosa = new Comida("Gaseosa", 3.0, Comida.TipoComida.BEBIDA);
        Comida cerveza = new Comida("Cerveza", 4.0, Comida.TipoComida.BEBIDA);
        pedido.añadirItem(new ItemPedido(hamburguesa, 2));
        pedido.añadirItem(new ItemPedido(papasFritas, 2));
        pedido.añadirItem(new ItemPedido(gaseosa, 1));
        pedido.añadirItem(new ItemPedido(cerveza, 1));

        //Entrenar
        restaurante.agregarPedido(mesa.getNumeroMesa(), pedido);
        //Calcular el costo consumido con la tarjeta Viedma y una propina del 2, 3 o 5%
        double total = restaurante.calcularCostoMesa(mesa.getNumeroMesa(), tarjeta, 5);
        //Verificar
        assertEquals(38.63, total);
    }

    @Test
    void testCalcularDescuentoTarjetaMasterCard() throws Exception {
        Restaurante restaurante = new Restaurante();
        Mesa mesa = new Mesa(2);
        MasterCard tarjeta = new MasterCard("1234567890123456", "Juan Perez", "Viedma");
        Pedido pedido = new Pedido();
        Comida hamburguesa = new Comida("Hamburguesa", 10.0, Comida.TipoComida.PLATO);
        Comida papasFritas = new Comida("Papas Fritas", 5.0, Comida.TipoComida.PLATO);
        Comida gaseosa = new Comida("Gaseosa", 3.0, Comida.TipoComida.BEBIDA);
        Comida cerveza = new Comida("Cerveza", 4.0, Comida.TipoComida.BEBIDA);

        pedido.añadirItem(new ItemPedido(hamburguesa, 2));
        pedido.añadirItem(new ItemPedido(papasFritas, 2));
        pedido.añadirItem(new ItemPedido(gaseosa, 1));
        pedido.añadirItem(new ItemPedido(cerveza, 1));
        //Entrenar
        restaurante.agregarPedido(mesa.getNumeroMesa(), pedido);
        //Calcular el costo consumido con la tarjeta Viedma y una propina del 2, 3 o 5%
        double total = restaurante.calcularCostoMesa(mesa.getNumeroMesa(), tarjeta, 5);
        //Verificar
        assertEquals(38.22, total);
    }

    @Test
    void testCalcularDescuentoTarjetaComarcaPlus() throws Exception {
        Restaurante restaurante = new Restaurante();
        Mesa mesa = new Mesa(2);
        ComarcaPlus tarjeta = new ComarcaPlus("1234567890123456", "Juan Perez", "Viedma");
        Pedido pedido = new Pedido();
        Comida hamburguesa = new Comida("Hamburguesa", 10.0, Comida.TipoComida.PLATO);
        Comida papasFritas = new Comida("Papas Fritas", 5.0, Comida.TipoComida.PLATO);
        Comida gaseosa = new Comida("Gaseosa", 3.0, Comida.TipoComida.BEBIDA);
        Comida cerveza = new Comida("Cerveza", 4.0, Comida.TipoComida.BEBIDA);

        pedido.añadirItem(new ItemPedido(hamburguesa, 2));
        pedido.añadirItem(new ItemPedido(papasFritas, 2));
        pedido.añadirItem(new ItemPedido(gaseosa, 1));
        pedido.añadirItem(new ItemPedido(cerveza, 1));
        //Entrenar
        restaurante.agregarPedido(mesa.getNumeroMesa(), pedido);
        //Calcular el costo consumido con la tarjeta Viedma y una propina del 2, 3 o 5%
        double total = restaurante.calcularCostoMesa(mesa.getNumeroMesa(), tarjeta, 5);
        //Verificar
        assertEquals(38.07, total);
    }

    @Test
    void testPedidoVacio() throws Exception {
        Restaurante restaurante = new Restaurante();
        Mesa mesa = new Mesa(2);
        TarjetaViedma tarjetaCredito = new TarjetaViedma("1234567890123456", "Juan Perez", "Loco");
        Pedido pedido = new Pedido();

        //Entrenar
        restaurante.agregarPedido(mesa.getNumeroMesa(), pedido);
        double total = restaurante.calcularCostoMesa(mesa.getNumeroMesa(), tarjetaCredito, 5);
        //Verificar
        assertEquals(0.0, total);
    }

    void testMesaNoEncontrada() throws Exception {
        Restaurante restaurante = new Restaurante();
        TarjetaViedma tarjetaCredito = new TarjetaViedma("1234567890123456", "Juan Perez", "Loco");
        Pedido pedido = new Pedido();

        //Entrenar
        assertThrows(IllegalStateException.class, () -> restaurante.agregarPedido(999, pedido));

    }
}

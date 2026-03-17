package Restaurante;

import java.util.ArrayList;
import java.util.List;

public class Restaurante {
    List<Mesa> mesas;

    public Restaurante() {
        mesas = new ArrayList<>();
    }

    public void agregarMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    public void agregarPedido(long numeroMesa, Pedido pedido) throws Exception {
        Mesa mesa = mesas.stream()
                .filter(m -> m.getNumeroMesa() == numeroMesa)
                .findFirst()
                .orElse(null);
        if (mesa != null) {
            mesa.agregarPedido(pedido);
        } else {
            throw new Exception("Mesa no encontrada.");
        }
    }

    public double calcularCostoMesa(long numeroMesa, TarjetaCredito tarjeta, double propina) {
        Mesa mesa = mesas.stream()
                .filter(m -> m.getNumeroMesa() == numeroMesa)
                .findFirst()
                .orElse(null);
        if (mesa != null) {
            return mesa.calcularCostoConsumido(tarjeta, propina);
        } else {
            System.out.println("Mesa no encontrada.");
            return 0;
        }
    }
}

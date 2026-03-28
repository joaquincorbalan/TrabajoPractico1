package Restaurante;


public class Main {
    public static void main() {
        //Export export = new FileExport();
        Export export = new BdExportRes();
        TarjetaCredito tarjeta = new TarjetaViedma("84653128656", "Rosario Lopez", "Banco Viedma");
        Restaurante restaurante = new Restaurante();
        Mesa mesa = new Mesa(4, export);
        restaurante.agregarMesa(mesa);
        Pedido pedido = new Pedido();
        Comida pancho = new Plato("Pancho", 5500);
        Comida fernet = new Bebida("Fernet 1L", 6000);
        pedido.añadirItem(new ItemPedido(pancho, 2));
        pedido.añadirItem(new ItemPedido(fernet, 2));
        mesa.agregarPedido(pedido);
        restaurante.calcularCostoMesa(mesa.getNumeroMesa(), tarjeta, 5);
    }
}

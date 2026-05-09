package entregador;

public class Bike extends Entregador {
    public Bike(int id, String nome) {
        super(id, nome, 20);
    }
    @Override
    public void mostrarTipo() {
        System.out.println("Entregador de Bicicleta");
    }
}
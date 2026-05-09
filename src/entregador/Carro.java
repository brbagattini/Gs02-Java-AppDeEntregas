package entregador;

public class Carro extends Entregador {
    public Carro(int id, String nome) {
        super(id, nome, 40);
    }
    @Override
    public void mostrarTipo() {
        System.out.println("Entregador de Carro");
    }
}
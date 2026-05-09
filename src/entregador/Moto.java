package entregador;

public class Moto extends Entregador {
    public Moto(int id, String nome) {
        super(id, nome, 60);
    }
    @Override
    public void mostrarTipo() {
        System.out.println("Entregador de Moto");
    }
}
package entregador;

public abstract class Entregador {
    private int id;
    private String nome;
    private double velocidade;
    public Entregador(int id, String nome, double velocidade) {
        this.id = id;
        this.nome = nome;
        this.velocidade = velocidade;
    }
    public abstract void mostrarTipo();
    public double calcularTempo(double distancia) {
        return distancia / velocidade;
    }
    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public double getVelocidade() {
        return velocidade;
    }
}
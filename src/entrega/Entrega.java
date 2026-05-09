package entrega;

import entregador.Entregador;
import interfaceSistema.Entregar;

public class Entrega implements Entregar {
    private int id;
    private String endereco;
    private Status status;
    private Entregador entregador;
    public Entrega(int id, String endereco) {

        this.id = id;
        this.endereco = endereco;
        this.status = Status.PENDENTE;
    }
    @Override
    public void iniciarEntrega() {
        this.status = Status.EM_ROTA;
    }
    public void atualizarStatus(Status status) {
        this.status = status;
    }
    public void atualizarStatus(String status) {

        this.status = Status.valueOf(status);
    }
    public int getId() {
        return id;
    }
    public String getEndereco() {
        return endereco;
    }
    public Status getStatus() {
        return status;
    }
    public Entregador getEntregador() {
        return entregador;
    }
    public void setEntregador(Entregador entregador) {
        this.entregador = entregador;
    }
}
import entrega.Entrega;
import entrega.Status;
import entregador.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Entregador> entregadores = new ArrayList<>();
        ArrayList<Entrega> entregas = new ArrayList<>();
        int opcao = 0;
        int idEntregador = 1;
        int idEntrega = 1;
        while (opcao != 6) {
            System.out.println("\n---- LOGISTICA ----");
            System.out.println("1 - Cadastrar entregador");
            System.out.println("2 - Criar entrega");
            System.out.println("3 - Listar entregas");
            System.out.println("4 - Atribuir entrega");
            System.out.println("5 - Atualizar status");
            System.out.println("6 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Nome do entregador: ");
                    String nome = sc.nextLine();
                    System.out.println("1 - Moto");
                    System.out.println("2 - Bicicleta");
                    System.out.println("3 - Carro");
                    System.out.print("Escolha o tipo: ");
                    int tipo = sc.nextInt();
                    Entregador novoEntregador = null;
                    if (tipo == 1) {
                        novoEntregador = new Moto(idEntregador, nome);
                    } else if (tipo == 2) {
                        novoEntregador = new Bike(idEntregador, nome);
                    } else if (tipo == 3) {
                        novoEntregador = new Carro(idEntregador, nome);
                    } else {
                        System.out.println("Tipo invalido!");
                    }
                    if (novoEntregador != null) {
                        entregadores.add(novoEntregador);
                        System.out.println("Entregador cadastrado!");
                        idEntregador++;
                    }
                    break;
                case 2:
                    System.out.print("Endereco da entrega: ");
                    String endereco = sc.nextLine();
                    Entrega entrega = new Entrega(idEntrega, endereco);
                    entregas.add(entrega);
                    System.out.println("Entrega criada!");
                    idEntrega++;
                    break;
                case 3:
                    if (entregas.isEmpty()) {
                        System.out.println("Nenhuma entrega cadastrada.");
                    } else {
                        for (Entrega e : entregas) {
                            System.out.println("\nID: " + e.getId());
                            System.out.println("Endereco: " + e.getEndereco());
                            System.out.println("Status: " + e.getStatus());
                            if (e.getEntregador() != null) {
                                System.out.println("Entregador: " + e.getEntregador().getNome());
                            } else {
                                System.out.println("Entregador: Nenhum");
                            }
                        }
                    }
                    break;
                case 4:
                    if (entregas.isEmpty() || entregadores.isEmpty()) {
                        System.out.println("Cadastre entregas e entregadores primeiro.");
                        break;
                    }
                    System.out.println("ENTREGAS:");
                    for (Entrega e : entregas) {
                        System.out.println(e.getId() + " - " + e.getEndereco());
                    }
                    System.out.print("Escolha a entrega: ");
                    int idE = sc.nextInt();
                    System.out.println("ENTREGADORES:");
                    for (Entregador ent : entregadores) {
                        System.out.println(ent.getId() + " - " + ent.getNome());
                    }
                    System.out.print("Escolha o entregador: ");
                    int idEnt = sc.nextInt();
                    Entrega entregaSelecionada = null;
                    Entregador entregadorSelecionado = null;
                    for (Entrega e : entregas) {
                        if (e.getId() == idE) {
                            entregaSelecionada = e;
                        }
                    }
                    for (Entregador ent : entregadores) {
                        if (ent.getId() == idEnt) {
                            entregadorSelecionado = ent;
                        }
                    }
                    if (entregaSelecionada != null && entregadorSelecionado != null) {
                        entregaSelecionada.setEntregador(entregadorSelecionado);
                        entregaSelecionada.iniciarEntrega();
                        System.out.println("Entrega atribuida!");
                    } else {
                        System.out.println("Dados invalidos.");
                    }
                    break;
                case 5:
                    if (entregas.isEmpty()) {
                        System.out.println("Nenhuma entrega cadastrada.");
                        break;
                    }
                    for (Entrega e : entregas) {
                        System.out.println(e.getId() + " - " + e.getEndereco());
                    }
                    System.out.print("Escolha a entrega: ");
                    int entregaStatus = sc.nextInt();
                    Entrega entregaAtualizar = null;
                    for (Entrega e : entregas) {
                        if (e.getId() == entregaStatus) {
                            entregaAtualizar = e;
                        }
                    }
                    if (entregaAtualizar != null) {
                        System.out.println("1 - PENDENTE");
                        System.out.println("2 - EM_ROTA");
                        System.out.println("3 - ENTREGUE");
                        System.out.println("4 - CANCELADO");
                        int st = sc.nextInt();
                        switch (st) {
                            case 1:
                                entregaAtualizar.atualizarStatus(Status.PENDENTE);
                                break;
                            case 2:
                                entregaAtualizar.atualizarStatus(Status.EM_ROTA);
                                break;
                            case 3:
                                entregaAtualizar.atualizarStatus(Status.ENTREGUE);
                                break;
                            case 4:
                                entregaAtualizar.atualizarStatus(Status.CANCELADO);
                                break;
                            default:
                                System.out.println("Status invalido.");
                        }
                    } else {
                        System.out.println("Entrega nao encontrada.");
                    }
                    break;
                case 6:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        }
        sc.close();
    }
}
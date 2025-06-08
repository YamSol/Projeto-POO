package view;

import model.*;
import controller.Servidor;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public Scanner scanner;
    private Servidor servidor;

    public Menu(Servidor servidor) {
        this.scanner = new Scanner(System.in);
        this.servidor = servidor;
    }

    public void exibirOpcoes() {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar paciente");
        System.out.println("2 - Ler dados de paciente");
        System.out.println("3 - Apagar paciente");
        System.out.println("4 - Listar pacientes");
        System.out.println("5 - Sair");
        System.out.println();
        System.out.print("Opção: ");
    }

    public void cadastrarPaciente() {
        System.out.print("Digite o nome do paciente: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o ID do paciente: ");
        String id = scanner.nextLine();
        System.out.println();

        // Criação do paciente
        Paciente paciente = new Paciente(nome, id);

        // Pergunta ao usuário quais sensores ele deseja adicionar
        boolean continuar = true;
        while (continuar) {
            System.out.println("Escolha um dispositivo para adicionar ao paciente:");
            System.out.println("1 - Dispositivo de Temperatura");
            System.out.println("2 - Dispositivo de Pressão");
            System.out.println("3 - Dispositivo de Batimento Cardíaco");
            System.out.println("4 - Finalizar cadastro de dispositivos");
            System.out.println();
            System.out.print("Opção: ");

            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    paciente.adicionarDispositivo(new DispositivoDeTemperatura());
                    System.out.println("Dispositivo de Temperatura adicionado com sucesso!");
                    System.out.println();
                    break;
                case 2:
                    paciente.adicionarDispositivo(new DispositivoDePressao());
                    System.out.println("Dispositivo de Pressão adicionado com sucesso!");
                    System.out.println();
                    break;
                case 3:
                    paciente.adicionarDispositivo(new DispositivoDeBatimentoCardiaco());
                    System.out.println("Dispositivo de Batimento Cardíaco adicionado com sucesso!");
                    System.out.println();
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Cadastro dos dispositivos finalizado.");
                    System.out.println();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    System.out.println();
                    break;
            }
        }

        servidor.cadastrarPaciente(paciente);
    }

    public void lerDadosPaciente() {
        System.out.print("Digite o ID do paciente: ");
        String id = scanner.nextLine();
        System.out.println();

        Paciente paciente = servidor.buscarPacientePorId(id);

        System.out.println("Nome do paciente: " + paciente.getNome() + ", ID do paciente: " + paciente.getId());

        for (Dado dado : paciente.getDadosPaciente()) {
            System.out.println(dado.getTipo() + ": " + dado.getValor() + dado.getUnidade()
                    + ", Momento da leitura: " + dado.getTimestamp());
        }

        System.out.println();
    }

    public void apagarPaciente() {
        System.out.print("Digite o ID do paciente: ");
        String id = scanner.nextLine();

        servidor.removerPaciente(id);
    }

    public void listarPacientes() {
        List<Paciente> pacientes = servidor.obterTodosPacientes();

        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente registrado.\n");
        } else {
            System.out.println("Lista de pacientes registrados:\n");
            int contador = 1;
            for (Paciente paciente : pacientes) {
                System.out.println(contador + " - Nome: " + paciente.getNome() + ", ID: " + paciente.getId());
                System.out.println();
                contador++;
            }
        }
    }
}
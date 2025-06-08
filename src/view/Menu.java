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

        String id;
        while (true) {
            System.out.print("Digite o ID do paciente: ");
            id = scanner.nextLine();

            if (servidor.buscarPacientePorId(id) != null) {
                System.out.println("Já existe um paciente com esse ID. Por favor, escolha outro.\n");
            } else {
                break;
            }
        }
        System.out.println();

        Paciente paciente = new Paciente(nome, id);

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

            String tipoDispositivo = null;

            switch (escolha) {
                case 1:
                    tipoDispositivo = "Temperatura";
                    break;
                case 2:
                    tipoDispositivo = "Pressão";
                    break;
                case 3:
                    tipoDispositivo = "Batimento Cardíaco";
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Cadastro dos dispositivos finalizado.\n");
                    continue;
                default:
                    System.out.println("Opção inválida! Tente novamente.\n");
                    continue;
            }

            // Verifica se o dispositivo já foi adicionado
            boolean jaAdicionado = false;
            for (DispositivoDeMonitoramento d : paciente.getDispositivos()) {
                if (d.getTipo().equals(tipoDispositivo)) {
                    jaAdicionado = true;
                    break;
                }
            }

            if (jaAdicionado) {
                System.out.println("Este tipo de dispositivo já foi adicionado!\n");
            } else {
                switch (escolha) {
                    case 1:
                        paciente.adicionarDispositivo(new DispositivoDeTemperatura());
                        System.out.println("Dispositivo de Temperatura adicionado com sucesso!\n");
                        break;
                    case 2:
                        paciente.adicionarDispositivo(new DispositivoDePressao());
                        System.out.println("Dispositivo de Pressão adicionado com sucesso!\n");
                        break;
                    case 3:
                        paciente.adicionarDispositivo(new DispositivoDeBatimentoCardiaco());
                        System.out.println("Dispositivo de Batimento Cardíaco adicionado com sucesso!\n");
                        break;
                }
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
                contador++;
            }

            System.out.println();
        }
    }
}
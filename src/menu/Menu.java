package menu;

import entidades.BatimentoCardiacoMonitoramento;
import entidades.PressaoMonitoramento;
import entidades.TemperaturaMonitoramento;
import logica.Servidor;
import entidades.Paciente;
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
        System.out.println("1. Cadastrar paciente");
        System.out.println("2. Ler dados de paciente");
        System.out.println("3. Apagar paciente");
        System.out.println("4. Listar pacientes");
        System.out.println("5. Sair");
    }

    public void cadastrarPaciente() {
        System.out.println("Digite o nome do paciente:");
        String nome = scanner.nextLine();

        System.out.println("Digite o ID do paciente:");
        String id = scanner.nextLine();

        // Criação do paciente
        Paciente paciente = new Paciente(nome, id);

        // Pergunta ao usuário quais sensores ele deseja adicionar
        boolean continuar = true;
        while (continuar) {
            System.out.println("Escolha um sensor para adicionar ao paciente:");
            System.out.println("1. Temperatura");
            System.out.println("2. Pressão");
            System.out.println("3. Batimento Cardíaco");
            System.out.println("4. Finalizar cadastro");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (escolha) {
                case 1:
                    paciente.adicionarDispositivo(new TemperaturaMonitoramento());
                    System.out.println("Sensor de Temperatura adicionado.");
                    break;
                case 2:
                    paciente.adicionarDispositivo(new PressaoMonitoramento());
                    System.out.println("Sensor de Pressão adicionado.");
                    break;
                case 3:
                    paciente.adicionarDispositivo(new BatimentoCardiacoMonitoramento());
                    System.out.println("Sensor de Batimento Cardíaco adicionado.");
                    break;
                case 4:
                    continuar = false;
                    System.out.println("Cadastro finalizado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        // Cadastro do paciente no servidor
        servidor.cadastrarPaciente(paciente);
    }


    public void lerDadosPaciente() {
        System.out.println("Digite o ID do paciente:");
        String id = scanner.nextLine();
        Paciente paciente = servidor.buscarPaciente(id);
        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
        }
        System.out.println("Paciente: "+paciente.getNome());
        paciente.gerarLeituras().forEach(dado -> System.out.println(dado.getTipo() + ": " + dado.getValor()));

    }

    public void apagarPaciente() {
        System.out.println("Digite o ID do paciente:");
        String id = scanner.nextLine();
        servidor.removerPaciente(id);
    }

    public void listarPacientes() {
        // Simular listagem de pacientes
        System.out.println("Pacientes registrados:");
//        servidor.
    }
}

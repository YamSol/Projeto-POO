package menu;

import logica.Servidor;
import entidades.Paciente;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
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
        Paciente paciente = new Paciente(nome, id);
        servidor.cadastrarPaciente(paciente);
    }

    public void lerDadosPaciente() {
        System.out.println("Digite o ID do paciente:");
        String id = scanner.nextLine();
        Paciente paciente = servidor.buscarPaciente(id);
        if (paciente != null) {
            paciente.gerarLeituras().forEach(dado -> System.out.println(dado.getTipo() + ": " + dado.getValor()));
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public void apagarPaciente() {
        System.out.println("Digite o ID do paciente:");
        String id = scanner.nextLine();
        servidor.removerPaciente(id);
    }

    public void listarPacientes() {
        // Simular listagem de pacientes
        System.out.println("Pacientes registrados:");
        // Aqui você pode implementar um método para listar todos os pacientes
    }
}

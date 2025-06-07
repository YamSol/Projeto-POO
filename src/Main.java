import logica.Servidor;
import logica.ConcentradorDeDados;
import database.BancoDeDados;
import menu.Menu;
import entidades.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Inicializa o banco de dados (simulação de persistência)
        BancoDeDados bancoDeDados = new BancoDeDados();

        // Inicializa o servidor com o banco de dados
        Servidor servidor = new Servidor(bancoDeDados);

        // Inicializa o menu para interação com o médico
        Menu menu = new Menu(servidor);

        // Inicializa o concentrador de dados (para simulação de envio de dados dos dispositivos)
        ConcentradorDeDados concentradorDeDados = new ConcentradorDeDados();

        // Menu interativo para o médico
        while (true) {
            menu.exibirOpcoes();
            int opcao = menu.scanner.nextInt();
            menu.scanner.nextLine(); // Consume the newline character left by nextInt()

            switch (opcao) {
                case 1: // Cadastrar paciente
                    menu.cadastrarPaciente();
                    break;
                case 2: // Ler dados de um paciente
                    menu.lerDadosPaciente();
                    break;
                case 3: // Apagar paciente
                    menu.apagarPaciente();
                    break;
                case 4: // Listar pacientes
                    menu.listarPacientes();
                    break;
                case 5: // Sair
                    System.out.println("Saindo do sistema.");
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
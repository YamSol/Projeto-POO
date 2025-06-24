import controller.Servidor;
import database.BancoDeDados;
import view.Menu;

public class Main {
    public static void main(String[] args) {
        // Inicializa o banco de dados (simulação de persistência)
        BancoDeDados bancoDeDados = new BancoDeDados();

        // Inicializa o servidor com o banco de dados
        Servidor servidor = new Servidor(bancoDeDados);

        // Inicializa o menu para interação com o médico
        Menu menu = new Menu(servidor);

        boolean distanciaRegistrada = false;

        while (true) {
            if (!distanciaRegistrada) {
                System.out.println("Antes de continuar, registre a distância do paciente.");
                menu.distanciaPacientes();
                distanciaRegistrada = true;
                continue;
            }

            menu.exibirOpcoes();
            int opcao = menu.scanner.nextInt();
            menu.scanner.nextLine();

            switch (opcao) {
                case 1:
                    menu.cadastrarPaciente();
                    break;
                case 2:
                    menu.lerDadosPaciente();
                    break;
                case 3:
                    menu.apagarPaciente();
                    break;
                case 4:
                    menu.listarPacientes();
                    break;
                case 5:
                    System.out.println("Saindo do sistema.");
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    System.out.println();
                    break;
            }
        }
    }
}
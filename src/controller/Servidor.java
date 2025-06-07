package controller;

import model.Dado;
import model.Paciente;
import database.BancoDeDados;
import java.util.List;
import java.util.ArrayList;

public class Servidor {

    private BancoDeDados bancoDeDados;
    private List<Paciente> pacientes; // Lista de pacientes cadastrados

    public Servidor(BancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
        this.pacientes = new ArrayList<>(); // Inicializa a lista de pacientes
    }

    // Recebe os dados do Concentrador e os envia para o banco de dados
//    public void receberDadosDoConcentrador(List<Dado> dados) {
//        bancoDeDados.salvarDados(dados);
//    }

    // Método para adicionar um paciente
    public void cadastrarPaciente(Paciente p) {
        pacientes.add(p); // Adiciona o paciente à lista interna
        bancoDeDados.salvarPaciente(p); // Salva o paciente no banco de dados
    }

    // Método para remover um paciente pelo ID
    public void removerPaciente(String id) {
        pacientes.removeIf(p -> p.getId().equals(id)); // Remove o paciente da lista interna
        bancoDeDados.removerPaciente(id); // Remove o paciente do banco de dados
    }

    // Método para buscar um paciente pelo ID
    public Paciente buscarPacientePorId(String id) {
//        return pacientes.stream()
//                .filter(paciente -> paciente.getId().equals(id)) // Filtra pela ID
//                .findFirst() // Retorna o primeiro paciente encontrado
//                .orElse(null); // Retorna null se não encontrado
        return bancoDeDados.buscarPacientePorId(id);
    }

    // Método para listar todos os pacientes cadastrados
    public List<Paciente> obterTodosPacientes() {
        return pacientes; // Retorna a lista de pacientes cadastrados
    }

    // Método para obter os dados de um paciente específico
//    public List<Dado> obterDadosDoPaciente(String id) {
//        Paciente paciente = buscarPaciente(id);
//        if (paciente != null) {
//            return paciente.gerarLeituras(); // Retorna os dados gerados pelos dispositivos do paciente
//        }
//        return new ArrayList<>(); // Retorna uma lista vazia caso o paciente não seja encontrado
//    }


}

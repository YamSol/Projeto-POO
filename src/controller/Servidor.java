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

    // Método para cadastrar um paciente
    public void cadastrarPaciente(Paciente p) {
        pacientes.add(p); // Adiciona o paciente à lista interna
        bancoDeDados.salvarPaciente(p); // Salva o paciente no banco de dados
    }

    // Método para buscar os dados de um paciente específico
    public Paciente buscarPacientePorId(String id) {
        return bancoDeDados.buscarPacientePorId(id);
    }

    // Método para remover um paciente pelo ID
    public void removerPaciente(String id) {
        bancoDeDados.removerPaciente(id); // Remove o paciente do banco de dados
    }

    // Método para listar os pacientes cadastrados
    public List<Paciente> obterTodosPacientes() {
        return bancoDeDados.listarPacientes();
    }
}
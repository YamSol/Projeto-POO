package main.java.controller;

import main.java.model.Paciente;
import main.java.database.BancoDeDados;
import java.util.List;
import java.util.ArrayList;

public class Servidor {
    private BancoDeDados bancoDeDados;
    private List<Paciente> pacientes;

    public Servidor(BancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
        this.pacientes = new ArrayList<>();
    }

    // Método para cadastrar um paciente
    public void cadastrarPaciente(Paciente p) {
        pacientes.add(p);
        bancoDeDados.salvarPaciente(p);
    }

    // Método para buscar os dados de um paciente específico
    public Paciente buscarPacientePorId(String id) {
        return bancoDeDados.buscarPacientePorId(id);
    }

    // Método para remover um paciente pelo ID
    public void removerPaciente(String id) {
        bancoDeDados.removerPaciente(id);
    }

    // Método para listar os pacientes cadastrados
    public List<Paciente> obterTodosPacientes() {
        return bancoDeDados.listarPacientes();
    }
}
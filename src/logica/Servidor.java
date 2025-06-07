package logica;

import entidades.Dado;
import entidades.Paciente;
import database.BancoDeDados;
import java.util.List;

public class Servidor {

    private BancoDeDados bancoDeDados;

    public Servidor(BancoDeDados bancoDeDados) {
        this.bancoDeDados = bancoDeDados;
    }

    // Recebe os dados do Concentrador e os envia para o banco de dados
    public void receberDadosDoConcentrador(List<Dado> dados) {
        bancoDeDados.salvarDados(dados);
    }

    public void cadastrarPaciente(Paciente p) {
        bancoDeDados.salvarPaciente(p);
    }

    public void removerPaciente(String id) {
        bancoDeDados.removerPaciente(id);
    }

    public Paciente buscarPaciente(String id) {
        return bancoDeDados.buscarPaciente(id);
    }

    public List<Dado> obterDadosDoPaciente(String id) {
        return bancoDeDados.obterDadosDoPaciente(id);
    }

//    public List<Paciente> obterPacientes() {}
}

package database;

import entidades.Paciente;
import entidades.Dado;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    private String pastaDeArmazenamento = "dados/pacientes";

    public void salvarDados(List<Dado> dados) {
        // Simulação de gravação de dados
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dados/leituras/dados.txt", true))) {
            for (Dado dado : dados) {
                writer.write(dado.getPacienteId() + "," + dado.getTipo() + "," + dado.getValor() + "," + dado.getTimestamp());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    public void salvarPaciente(Paciente p) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(pastaDeArmazenamento + "/" + p.getId() + ".ser"))) {
            out.writeObject(p);
        } catch (IOException e) {
            System.out.println("Erro ao salvar paciente: " + e.getMessage());
        }
    }

    public Paciente buscarPaciente(String id) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(pastaDeArmazenamento + "/" + id + ".ser"))) {
            return (Paciente) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao buscar paciente: " + e.getMessage());
            return null;
        }
    }

//    public List<Paciente> buscarPacientes() {
//        List<Paciente> pacientes = new ArrayList<>();
//
//    }

    public List<Dado> obterDadosDoPaciente(String id) {
        List<Dado> dados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("dados/leituras/dados.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] partes = line.split(",");
                if (partes[0].equals(id)) {
                    dados.add(new Dado(partes[1], partes[2], java.time.LocalDateTime.parse(partes[3]), id));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao obter dados do paciente: " + e.getMessage());
        }
        return dados;
    }

    public void removerPaciente(String id) {
        File pacienteFile = new File(pastaDeArmazenamento + "/" + id + ".ser");
        if (pacienteFile.exists()) {
            pacienteFile.delete();
        }
    }
}

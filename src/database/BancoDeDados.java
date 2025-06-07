package database;

import model.DispositivoDeMonitoramento;
import model.Paciente;
import model.Dado;
import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BancoDeDados {
    private String pastaDeArmazenamento = "dados/pacientes";

//    public void salvarDados(List<Dado> dados) {
//        // Simulação de gravação de dados
//        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dados/leituras/dados.txt", true))) {
//            for (Dado dado : dados) {
//                writer.write(dado.getPacienteId() + "," + dado.getTipo() + "," + dado.getValor() + "," + dado.getTimestamp());
//                writer.newLine();
//            }
//        } catch (IOException e) {
//            System.out.println("Erro ao salvar dados: " + e.getMessage());
//        }
//    }

    public void salvarPaciente(Paciente p) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("dados/leituras/pacientes.txt", true))) {
            writer.write("PacienteId:" + p.getId() + "," + "Nome: " + p.getNome());
            writer.newLine();
            for (DispositivoDeMonitoramento dispositivoDeMonitoramento : p.getDispositivos()) {
                writer.write(dispositivoDeMonitoramento.getTipo() + ","
                        + dispositivoDeMonitoramento.gerarDadoAleatorio().getValor() + ","
                        + dispositivoDeMonitoramento.gerarDadoAleatorio().getTimestamp());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    public Paciente buscarPacientePorId(String idBuscado) {
        Paciente paciente = null;

        try (BufferedReader reader = new BufferedReader(new FileReader("dados/leituras/pacientes.txt"))) {
            String linha;
            boolean pacienteEncontrado = false;

            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("PacienteId:")) {
                    // Extração do ID
                    String[] partes = linha.split(",");
                    String id = partes[0].split(":")[1];

                    if (idBuscado.equals(id)) {
                        String nome = partes[1].split(":")[1].trim();
                        paciente = new Paciente(nome, id); // Assume que há construtor Paciente(id, nome)
                        pacienteEncontrado = true;
                        continue;
                    } else if (pacienteEncontrado) {
                        // Chegamos a um novo paciente, então paramos a leitura
                        break;
                    }
                } else if (pacienteEncontrado && paciente != null) {
                    // Leitura de dispositivo
                    String[] dados = linha.split(",");
                    if (dados.length == 3) {
                        String tipo = dados[0].trim();
                        String valor = dados[1].trim();
                        LocalDateTime timestamp = LocalDateTime.parse(dados[2].trim());

                        Dado dado = new Dado(tipo,valor,timestamp);

                        paciente.adicionarDadosPaciente(dado);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return paciente;
    }


    public Paciente buscarPaciente(String id) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(pastaDeArmazenamento + "/" + id + ".ser"))) {
            return (Paciente) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao buscar paciente: " + e.getMessage());
            return null;
        }
    }


    public void removerPaciente(String id) {
        File pacienteFile = new File(pastaDeArmazenamento + "/" + id + ".ser");
        if (pacienteFile.exists()) {
            pacienteFile.delete();
        }
    }
}

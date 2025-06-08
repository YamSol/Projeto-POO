package database;

import model.DispositivoDeMonitoramento;
import model.Paciente;
import model.Dado;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
    private final String pastaDeArmazenamento = "dados/leituras/pacientes.txt";

    // Salva os dados de um paciente no arquivo
    public void salvarPaciente(Paciente p) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(pastaDeArmazenamento, true))) {
            writer.write("PacienteId:" + p.getId() + "," + "Nome: " + p.getNome());
            writer.newLine();

            for (DispositivoDeMonitoramento dispositivo : p.getDispositivos()) {
                Dado dado = dispositivo.gerarDadoAleatorio();
                writer.write(dispositivo.getTipo() + "," +
                        dado.getValor() + "," +
                        dado.getUnidade() + "," +
                        dado.getTimestamp());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    // Busca um paciente pelo ID
    public Paciente buscarPacientePorId(String idBuscado) {
        Paciente paciente = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(pastaDeArmazenamento))) {
            String linha;
            boolean pacienteEncontrado = false;

            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("PacienteId:")) {
                    String[] partes = linha.split(",");
                    String id = partes[0].split(":")[1];

                    if (idBuscado.equals(id)) {
                        String nome = partes[1].split(":")[1].trim();
                        paciente = new Paciente(nome, id);
                        pacienteEncontrado = true;
                    } else if (pacienteEncontrado) {
                        break;
                    }
                } else if (pacienteEncontrado && paciente != null) {
                    String[] dados = linha.split(",");
                    if (dados.length == 4) {
                        String tipo = dados[0].trim();
                        String valor = dados[1].trim();
                        String unidade = dados[2].trim();
                        LocalDateTime timestamp = LocalDateTime.parse(dados[3].trim());

                        Dado dado = new Dado(tipo, valor, unidade, timestamp);
                        paciente.adicionarDadosPaciente(dado);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return paciente;
    }

    // Lista todos os pacientes salvos
    public List<Paciente> listarPacientes() {
        List<Paciente> pacientes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(pastaDeArmazenamento))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("PacienteId:")) {
                    String[] partes = linha.split(",");
                    String id = partes[0].split(":")[1];
                    String nome = partes[1].split(":")[1].trim();
                    Paciente paciente = new Paciente(nome, id);
                    pacientes.add(paciente);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }

        return pacientes;
    }

    // Remove um paciente e seus dados do arquivo
    public void removerPaciente(String id) {
        File arquivoOriginal = new File(pastaDeArmazenamento);
        File arquivoTemporario = new File("temp.txt");

        try (
                BufferedReader reader = new BufferedReader(new FileReader(arquivoOriginal));
                BufferedWriter writer = new BufferedWriter(new FileWriter(arquivoTemporario))
        ) {
            String linha;
            boolean dentroDoPaciente = false;

            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("PacienteId:")) {
                    if (linha.contains("PacienteId:" + id)) {
                        dentroDoPaciente = true;
                        continue;
                    } else {
                        dentroDoPaciente = false;
                    }
                }

                if (!dentroDoPaciente) {
                    writer.write(linha);
                    writer.newLine();
                }
            }

        } catch (IOException e) {
            System.out.println("Erro ao processar arquivo: " + e.getMessage());
            return;
        }

        // Substitui o arquivo original pelo temporário
        if (arquivoOriginal.delete()) {
            if (!arquivoTemporario.renameTo(arquivoOriginal)) {
                System.out.println("Erro ao renomear o arquivo temporário.");
            } else {
                System.out.println("Paciente com " + id + " removido com sucesso.");
            }
        } else {
            System.out.println("Erro ao excluir o arquivo original.");
        }

        System.out.println();
    }
}
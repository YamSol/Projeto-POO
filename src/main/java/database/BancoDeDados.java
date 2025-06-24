package database;

import model.Paciente;
import model.Dado;
import model.DispositivoDeMonitoramento;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {

    public void salvarPaciente(Paciente p) {
        try (Connection conn = MySQLConnection.getConnection()) {
            String insertPaciente = "INSERT INTO paciente (id, nome) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertPaciente)) {
                stmt.setString(1, p.getId());
                stmt.setString(2, p.getNome());
                stmt.executeUpdate();
            }

            String insertDado = "INSERT INTO dado (paciente_id, tipo, valor, unidade, timestamp) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertDado)) {
                for (Dado d : p.getDadosPaciente()) {
                    stmt.setString(1, p.getId());
                    stmt.setString(2, d.getTipo());
                    stmt.setString(3, d.getValor());
                    stmt.setString(4, d.getUnidade());
                    stmt.setTimestamp(5, Timestamp.valueOf(d.getTimestamp()));
                    stmt.addBatch();
                }
                stmt.executeBatch();
            }

            String insertDispositivo = "INSERT INTO dispositivo (paciente_id, tipo) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(insertDispositivo)) {
                for (DispositivoDeMonitoramento d : p.getDispositivos()) {
                    stmt.setString(1, p.getId());
                    stmt.setString(2, d.getClass().getSimpleName());
                    stmt.addBatch();
                }
                stmt.executeBatch();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Paciente buscarPacientePorId(String idBuscado) {
        Paciente paciente = null;

        try (Connection conn = MySQLConnection.getConnection()) {
            String queryPaciente = "SELECT nome FROM paciente WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(queryPaciente)) {
                stmt.setString(1, idBuscado);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    paciente = new Paciente(rs.getString("nome"), idBuscado);
                }
            }

            if (paciente != null) {
                String queryDados = "SELECT tipo, valor, unidade, timestamp FROM dado WHERE paciente_id = ?";
                try (PreparedStatement stmt = conn.prepareStatement(queryDados)) {
                    stmt.setString(1, idBuscado);
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        Dado d = new Dado(
                                rs.getString("tipo"),
                                rs.getString("valor"),
                                rs.getString("unidade"),
                                rs.getTimestamp("timestamp").toLocalDateTime()
                        );
                        paciente.adicionarDadosPaciente(d);
                    }
                }

                // Para simplificar, só adicionamos os nomes dos tipos de dispositivos
                String queryDispositivos = "SELECT tipo FROM dispositivo WHERE paciente_id = ?";
                try (PreparedStatement stmt = conn.prepareStatement(queryDispositivos)) {
                    stmt.setString(1, idBuscado);
                    ResultSet rs = stmt.executeQuery();
                    while (rs.next()) {
                        // Poderia usar reflexão ou um factory para criar os dispositivos reais
                        // Aqui apenas printa o tipo, ou você pode mapear por classe
                        System.out.println("Dispositivo encontrado: " + rs.getString("tipo"));
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return paciente;
    }

    public List<Paciente> listarPacientes() {
        List<Paciente> lista = new ArrayList<>();
        try (Connection conn = MySQLConnection.getConnection()) {
            String query = "SELECT id FROM paciente";
            try (Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {
                    Paciente p = buscarPacientePorId(rs.getString("id"));
                    if (p != null) {
                        lista.add(p);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void removerPaciente(String id) {
        try (Connection conn = MySQLConnection.getConnection()) {
            String delete = "DELETE FROM paciente WHERE id = ?";
            try (PreparedStatement stmt = conn.prepareStatement(delete)) {
                stmt.setString(1, id);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

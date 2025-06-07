package entidades;

import java.time.LocalDateTime;

public class Dado {
    private String tipo;
    private String valor;
    private LocalDateTime timestamp;
    private String pacienteId;

    public Dado(String tipo, String valor, LocalDateTime timestamp, String pacienteId) {
        this.tipo = tipo;
        this.valor = valor;
        this.timestamp = timestamp;
        this.pacienteId = pacienteId;
    }

    // Getters
    public String getTipo() { return tipo; }
    public String getValor() { return valor; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getPacienteId() { return pacienteId; }
}

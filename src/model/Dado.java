package model;

import java.time.LocalDateTime;

public class Dado {
    private String tipo;
    private String valor;
    private LocalDateTime timestamp;

    public Dado(String tipo, String valor, LocalDateTime timestamp) {
        this.tipo = tipo;
        this.valor = valor;
        this.timestamp = timestamp;
    }

    // Getters
    public String getTipo() { return tipo; }
    public String getValor() { return valor; }
    public LocalDateTime getTimestamp() { return timestamp; }
}

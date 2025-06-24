package main.java.model;

import java.time.LocalDateTime;

public class Dado {
    private String tipo;
    private String valor;
    private String unidade;
    private LocalDateTime timestamp;

    public Dado(String tipo, String valor, String unidade, LocalDateTime timestamp) {
        this.tipo = tipo;
        this.valor = valor;
        this.unidade = unidade;
        this.timestamp = timestamp;
    }

    // Getters
    public String getTipo() {
        return tipo;
    }

    public String getValor() {
        return valor;
    }

    public String getUnidade() {
        return unidade;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
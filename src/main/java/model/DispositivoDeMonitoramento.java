package main.java.model;

import java.io.Serializable;

public abstract class DispositivoDeMonitoramento implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String tipo;

    public abstract Dado gerarDadoAleatorio();

    // Getter
    public String getTipo() {
        return tipo;
    }
}
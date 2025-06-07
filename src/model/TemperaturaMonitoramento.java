package model;

import java.util.Random;

public class TemperaturaMonitoramento extends DispositivoDeMonitoramento {
    public TemperaturaMonitoramento() {
        this.tipo = "Temperatura";
    }

    @Override
    public Dado gerarDadoAleatorio() {
        Random rand = new Random();
        double temperatura = 36.5 + (39.0 - 36.5) * rand.nextDouble();
        return new Dado("Temperatura", String.format("%.1f", temperatura), java.time.LocalDateTime.now(), "PacienteX");
    }
}

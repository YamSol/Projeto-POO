package main.java.model;

import java.util.Random;

public class DispositivoDeTemperatura extends DispositivoDeMonitoramento {

    public DispositivoDeTemperatura() {
        this.tipo = "Temperatura";
    }

    @Override
    public Dado gerarDadoAleatorio() {
        Random rand = new Random();
        double temperatura = 36.5 + (39.0 - 36.5) * rand.nextDouble();

        return new Dado("Temperatura", String.format("%.1f", temperatura), "[°C]", java.time.LocalDateTime.now());
    }
}
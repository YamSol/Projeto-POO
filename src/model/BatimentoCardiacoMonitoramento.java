package model;

import java.util.Random;

public class BatimentoCardiacoMonitoramento extends DispositivoDeMonitoramento {
    public BatimentoCardiacoMonitoramento() {
        this.tipo = "Batimento Cardíaco";
    }

    @Override
    public Dado gerarDadoAleatorio() {
        Random rand = new Random();
        int batimentos = 50 + rand.nextInt(71); // Entre 50 e 120 bpm
        return new Dado("Batimento Cardíaco", String.valueOf(batimentos), java.time.LocalDateTime.now(), "PacienteZ");
    }
}

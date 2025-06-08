package model;

import java.util.Random;

public class DispositivoDePressao extends DispositivoDeMonitoramento {

    public DispositivoDePressao() {
        this.tipo = "Pressão";
    }

    @Override
    public Dado gerarDadoAleatorio() {
        Random rand = new Random();
        int sistolica = 90 + rand.nextInt(60);    // Valor entre 90 e 149
        int diastolica = 60 + rand.nextInt(40);   // Valor entre 60 e 99

        return new Dado("Pressão", sistolica + "/" + diastolica, "[mmHg]", java.time.LocalDateTime.now());
    }
}
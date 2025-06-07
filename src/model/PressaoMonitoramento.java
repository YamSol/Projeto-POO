
package model;

import java.util.Random;

public class PressaoMonitoramento extends DispositivoDeMonitoramento {
    public PressaoMonitoramento() {
        this.tipo = "Pressão";
    }

    @Override
    public Dado gerarDadoAleatorio() {
        Random rand = new Random();
        int sistolica = 90 + rand.nextInt(60);
        int diastolica = 60 + rand.nextInt(40);
        return new Dado("Pressão", sistolica + "/" + diastolica, java.time.LocalDateTime.now(), "PacienteY");
    }
}

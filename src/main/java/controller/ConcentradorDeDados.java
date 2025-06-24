package main.java.controller;

public class ConcentradorDeDados {
    private String bandaFrequencia;

    public void distanciaPaciente(double km) {
        this.bandaFrequencia = selecionarBanda(km);
        System.out.println("Distância definida: " + km + " km" + ", Banda: " + bandaFrequencia);
        System.out.println();
    }

    private String selecionarBanda(double km) {
        if (km <= 1.0) {
            return "2.4 GHz - Alta taxa";
        } else if (km <= 5.0) {
            return "900 MHz - Taxa média";
        } else {
            return "433 MHz - Baixa taxa";
        }
    }
}
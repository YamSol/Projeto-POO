package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L; // Número de versão da serialização
    private String nome;
    private String id;
    private List<DispositivoDeMonitoramento> dispositivos;

    public Paciente(String nome, String id) {
        this.nome = nome;
        this.id = id;
        this.dispositivos = new ArrayList<>();
    }

    public void adicionarDispositivo(DispositivoDeMonitoramento d) {
        dispositivos.add(d);
    }

    public void removerDispositivo(DispositivoDeMonitoramento d) {
        dispositivos.remove(d);
    }

    public List<Dado> gerarLeituras() {
        List<Dado> leituras = new ArrayList<>();
        for (DispositivoDeMonitoramento dispositivo : dispositivos) {
            leituras.add(dispositivo.gerarDadoAleatorio());
        }
        return leituras;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public String getId() { return id; }
    public List<DispositivoDeMonitoramento> getDispositivos() { return dispositivos; }
}

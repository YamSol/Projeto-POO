package main.java.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Paciente implements Serializable {
    private static final long serialVersionUID = 1L; // Número de versão da serialização

    private String nome;
    private String id;
    private List<Dado> dadosPaciente;
    private List<DispositivoDeMonitoramento> dispositivos;

    public Paciente(String nome, String id) {
        this.nome = nome;
        this.id = id;
        this.dadosPaciente = new ArrayList<>();
        this.dispositivos = new ArrayList<>();
    }

    public void adicionarDadosPaciente(Dado dado) {
        dadosPaciente.add(dado);
    }

    public void adicionarDispositivo(DispositivoDeMonitoramento d) {
        dispositivos.add(d);
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public List<Dado> getDadosPaciente() {
        return dadosPaciente;
    }

    public List<DispositivoDeMonitoramento> getDispositivos() {
        return dispositivos;
    }
}
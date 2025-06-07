package controller;

import model.Dado;

import java.util.ArrayList;
import java.util.List;

public class ConcentradorDeDados {
    List<Dado> dadosRecebidos = new ArrayList<>();

    public void receberDados(List<Dado> dados) {
        dadosRecebidos.addAll(dados);
    }

    public void enviarDados(Servidor servidor) {
        servidor.receberDadosDoConcentrador(dadosRecebidos);
    }
}


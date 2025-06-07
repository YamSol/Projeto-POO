package logica;

import entidades.Dado;
import logica.Servidor;
import java.util.List;

public class ConcentradorDeDados {

    public void receberDados(List<Dado> dados) {
        System.out.println("Dados recebidos pelo concentrador.");
    }

    public void enviarDados(Servidor servidor, List<Dado> dados) {
        servidor.receberDados(dados);
    }
}


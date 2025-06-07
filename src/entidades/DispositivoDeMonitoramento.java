package entidades;

public abstract class DispositivoDeMonitoramento {
    protected String tipo;

    public abstract Dado gerarDadoAleatorio();

    public String getTipo() {
        return tipo;
    }
}


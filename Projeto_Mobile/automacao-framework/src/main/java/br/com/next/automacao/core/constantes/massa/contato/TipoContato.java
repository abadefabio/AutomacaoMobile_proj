package br.com.next.automacao.core.constantes.massa.contato;

public enum TipoContato {

    OUTROS_BANCOS("OUTROS_BANCOS"),
    VAQUINHA("VAQUINHA"),
    NEXT("NEXT"),
    BRADESCO("BRADESCO");

    private final String tipo;

    TipoContato(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

}

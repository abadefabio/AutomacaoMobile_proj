package br.com.next.automacao.core.constantes.massa.adesao;

public enum TipoAdesao {

    ADESAO_RESPONSAVEL_RG ("RG"),
    ADESAO_RESPONSAVEL_CNH ("CNH"),
    ADESAO_JOY ("JOY");

    private final String tipo;

    TipoAdesao(String tipo){
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}

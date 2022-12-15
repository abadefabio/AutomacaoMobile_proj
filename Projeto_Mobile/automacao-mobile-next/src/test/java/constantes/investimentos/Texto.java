package constantes.investimentos;

public enum Texto {

    TERMO_DE_ADESAO_PRODUTO("Termo de ades�o ao produto"),
    TERMO_DE_CIENCIA_E_RISCO("Termo de ci�ncia e risco"),
    SOLICITADO_EM("Solicitado em"),
    AGENDADA_EM("Agendada em"),
    SALDO_DISPONIVEL_EM_CONTA("Saldo dispon�vel em conta"),
    APLICACAO_MENSAL("escolhe um dia e um valor pro seu dinheiro ser aplicado automaticamente."),
    QUAL_VALOR_DA_APLICACAO("Qual o valor da aplica��o?");

    private String value;

    Texto (String value){ this.value = value; }

    @Override
    public String toString(){ return value; }
}

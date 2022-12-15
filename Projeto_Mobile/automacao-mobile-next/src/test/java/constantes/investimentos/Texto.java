package constantes.investimentos;

public enum Texto {

    TERMO_DE_ADESAO_PRODUTO("Termo de adesão ao produto"),
    TERMO_DE_CIENCIA_E_RISCO("Termo de ciência e risco"),
    SOLICITADO_EM("Solicitado em"),
    AGENDADA_EM("Agendada em"),
    SALDO_DISPONIVEL_EM_CONTA("Saldo disponível em conta"),
    APLICACAO_MENSAL("escolhe um dia e um valor pro seu dinheiro ser aplicado automaticamente."),
    QUAL_VALOR_DA_APLICACAO("Qual o valor da aplicação?");

    private String value;

    Texto (String value){ this.value = value; }

    @Override
    public String toString(){ return value; }
}

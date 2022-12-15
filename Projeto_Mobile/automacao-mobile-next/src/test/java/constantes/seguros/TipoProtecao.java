package constantes.seguros;

public enum TipoProtecao {

    // Para o seu dia a dia
    DIA_DIA_TRANQUILIDADE_PARA_QUEM_VOCE_AMA("Tranquilidade para quem você ama"),
    DIA_DIA_TENHA_MAIS_MOTIVOS_PARA_SORRIR("Tenha mais motivos para sorrir"),
    DIA_DIA_SEU_LAR_PROTEGIDO_COM_ASSISTENCIAS_24H("Seu lar protegido com assistências 24h"),

    // Para o seu cartão
    CARTAO_PROTECAO_CONTRA_GASTOS_E_IMPREVISTOS("Proteção contra gastos e imprevistos"),
    CARTAO_PROTECAO_CONTRA_TRANSACOES_INDEVIDAS("Proteção contra transações indevidas"),

    DEBITO("debito"),
    CREDITO("credito"),
    ODONTO("odonto");

    private String value;

    TipoProtecao(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

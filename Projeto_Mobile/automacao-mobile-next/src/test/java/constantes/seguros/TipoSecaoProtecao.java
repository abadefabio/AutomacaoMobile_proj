package constantes.seguros;

public enum TipoSecaoProtecao {
    COBERTURA("Cobertura"),
    CARENCIA("Car�ncia"),
    DADOS_DA_SEGURADORA("Dados da Seguradora"),
    //tela: protecao/detalhes
    INFORMACOES_SEGURO_FROM_DETALHES("INFORMA��ES DO SEGURO"),
    //tela: protecao/contratar/confirmacao de dados
    INFORMACOES_SEGURO_FROM_CONFIRMACAO_DADOS("INFORMA��ES DO SEGURO"),
    //tela: protecao/se��o contratados
    CONTRATACAO("contratacao"),
    CANCELAMENTO("cancelamento"),
    INFORMACOES_SEGURO_FROM_CARD_CONTRATADO("Informa��es do seguro");

    private String value;

    private TipoSecaoProtecao(String value) {
        this.value = value;
    }
}

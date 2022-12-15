package constantes.objetivos;

public enum TituloTela {
    OBJETIVOS("OBJETIVOS"),
    RESGATE_FEITO_EM("Seu resgate foi feito em"),
    CONFIRMAR_CANCELAMENTO("CONFIRMAR CANCELAMENTO"),
    OBJETIVO_CANCELADO("OBJETIVO CANCELADO"),
    SO_ACONTECE_DIAS_UTEIS("Ele s� acontece em dias �teis"),
    SOBRE_RESGATE("Sobre o resgate"),
    COMPROVANTE("COMPROVANTE"),
    SEU_PERFIL("SEU PERFIL"),
    PERFIS_DE_INVESTIDOR("PERFIS DE INVESTIDOR"),
    SOBRE_O_PRODUTO("Sobre o produto"),
    DEMONSTRACAO_DESEMPENHO("Demonstra��o de Desempenho"),
    APLICACAO_NO_OBJETIVO("APLICA��O NO OBJETIVO"),
    DATA_DA_APLICACAO("DATA DA APLICA��O"),
    EDITAR_AGENDAMENTO("EDITAR AGENDAMENTO"),
    DETALHES("Detalhes"),
    ATUALIZACAO_CADASTRAL("ATUALIZA��O CADASTRAL");

    private String value;

    private TituloTela(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

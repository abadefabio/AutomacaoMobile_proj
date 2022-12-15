package constantes.objetivos;

public enum TituloTela {
    OBJETIVOS("OBJETIVOS"),
    RESGATE_FEITO_EM("Seu resgate foi feito em"),
    CONFIRMAR_CANCELAMENTO("CONFIRMAR CANCELAMENTO"),
    OBJETIVO_CANCELADO("OBJETIVO CANCELADO"),
    SO_ACONTECE_DIAS_UTEIS("Ele só acontece em dias úteis"),
    SOBRE_RESGATE("Sobre o resgate"),
    COMPROVANTE("COMPROVANTE"),
    SEU_PERFIL("SEU PERFIL"),
    PERFIS_DE_INVESTIDOR("PERFIS DE INVESTIDOR"),
    SOBRE_O_PRODUTO("Sobre o produto"),
    DEMONSTRACAO_DESEMPENHO("Demonstração de Desempenho"),
    APLICACAO_NO_OBJETIVO("APLICAÇÃO NO OBJETIVO"),
    DATA_DA_APLICACAO("DATA DA APLICAÇÃO"),
    EDITAR_AGENDAMENTO("EDITAR AGENDAMENTO"),
    DETALHES("Detalhes"),
    ATUALIZACAO_CADASTRAL("ATUALIZAÇÃO CADASTRAL");

    private String value;

    private TituloTela(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

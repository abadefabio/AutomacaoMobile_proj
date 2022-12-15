package constantes.investimentos;

public enum TituloTela {

    AGORA_INVESTIMENTOS("�GORA INVESTIMENTOS"),
    APLICACAO_CANCELADA("APLICA��O CANCELADA"),
    APLICACAO_FORA_DO_PERFIL("APLICA��O FORA DO PERFIL"),
    ATUALIZACAO_CADASTRAL("ATUALIZA��O CADASTRAL"),
    COMPROVANTE("COMPROVANTE"),
    DESCOBRINDO_SEU_PERFIL("DESCOBRINDO SEU PERFIL"),
    EXTRATO("EXTRATO"),
    FUNDOS("FUNDOS"),
    INVESTIMENTOS("INVESTIMENTOS"),
    POUPANCA("POUPAN�A"),
    PRODUTO_COM_RISCO("PRODUTO COM RISCO"),
    TERMOS_DE_CONTRATO("TERMOS DE CONTRATO");

    private String value;

    TituloTela(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

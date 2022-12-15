package constantes.investimentos;

public enum TituloTela {

    AGORA_INVESTIMENTOS("ÁGORA INVESTIMENTOS"),
    APLICACAO_CANCELADA("APLICAÇÃO CANCELADA"),
    APLICACAO_FORA_DO_PERFIL("APLICAÇÃO FORA DO PERFIL"),
    ATUALIZACAO_CADASTRAL("ATUALIZAÇÃO CADASTRAL"),
    COMPROVANTE("COMPROVANTE"),
    DESCOBRINDO_SEU_PERFIL("DESCOBRINDO SEU PERFIL"),
    EXTRATO("EXTRATO"),
    FUNDOS("FUNDOS"),
    INVESTIMENTOS("INVESTIMENTOS"),
    POUPANCA("POUPANÇA"),
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

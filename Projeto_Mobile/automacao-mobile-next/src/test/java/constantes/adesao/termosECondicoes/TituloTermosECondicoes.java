package constantes.adesao.termosECondicoes;

public enum TituloTermosECondicoes {

    PROPOSTA_DE_ABERTURA_DE_CONTA("Proposta de Abertura de Conta"),
    REGULAMENTO_DA_FUNCAO_CREDITO_DOS_CARTOES_NEXT("Regulamento da Função Crédito dos Cartões Next"),
    TERMOS_E_CONDICOES_DE_USO_DO_APLICATIVO_NEXT("Termos e Condições de Uso do Aplicativo Next"),
    REGULAMENTO_DO_PROGRAMA_DE_FIDELIDADE_CARTOES_BRADESCO("Regulamento do Programa de Fidelidade Cartões Bradesco - Cartão Next");

    private String value;

    TituloTermosECondicoes(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

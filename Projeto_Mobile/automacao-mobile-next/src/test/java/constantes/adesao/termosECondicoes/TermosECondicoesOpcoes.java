package constantes.adesao.termosECondicoes;

public enum TermosECondicoesOpcoes {

    OPCAO_PROPOSTA_DE_ABERTURA_DE_CONTA("Proposta de Abertura de Conta"),
    OPCAO_TERMO_DE_OPCAO_A_CESTA_DE_SERVIÇOS("Termo de Opção à Cesta de Serviços"),
    OPCAO_TERMO_DE_ADESAO_A_PRODUTOS_E_SERVIÇOS("Termo de Adesão a Produtos e Serviços"),
    OPCAO_INFORMACOES_ESSENCIAIS_CONTA_NEXT("Informações Essenciais Conta Next"),
    OPCAO_TERMOS_E_CONDICOES_DE_USO_DO_APLICATIVO_NEXT("Termos e Condições de Uso do Aplicativo Next"),
    OPCAO_DIRETIVAS_DE_PRIVACIDADE("Diretivas de Privacidade");

    private String opcao;
    TermosECondicoesOpcoes(String opcao) {
        this.opcao = opcao;
    }
    public String retornaOpcao() {
        return opcao;
    }

}

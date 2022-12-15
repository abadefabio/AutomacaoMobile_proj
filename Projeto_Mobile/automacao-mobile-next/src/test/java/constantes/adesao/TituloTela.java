package constantes.adesao;

public enum TituloTela {

    CRIAR_CONTA("CRIAR CONTA"),
    SENHA_DO_APP("SENHA DO APP"),
    ACESSE_O_NEXT("ACESSE O NEXT"),
    COMPLETE_SEU_CADASTRO("COMPLETE SEU CADASTRO"),
    AGORA_AGENTE_VAI_PRECISAR_DADOS_PESSOAIS("Agora, a gente vai precisar de uns dados pessoais. Tenha um documento em m�os pra facilitar :)"),
    VOCE_E_UNIVERSITARIO("Voc� � universit�rio?"),
    ENDERE�O("ENDERE�O"),
    PASSO_6_DE_6("PASSO 6 DE 6"),
    PACOTES("PACOTES"),
    PACOTES_PADRONIZADOS("PACOTES PADRONIZADOS"),
    RESUMO( "RESUMO"),
    ESCOLHA_SEU_CARTAO("ESCOLHA SEU CART�O"),
    ESCOLHA_SEU_CARTAO_IOS("SEU CART�O"),
    SENHA("SENHA"),
    FATURA("FATURA"),
    MAIS_DETALHES("MAIS DETALHES"),
    ESCOLHA_SUA_CESTA("ESCOLHA SUA CESTA"),
    DADOS_PESSOAIS("DADOS PESSOAIS"),
    PODE_TERMINAR_OUTRA_HORA("Pode terminar outra hora.");

    private String value;

    TituloTela(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

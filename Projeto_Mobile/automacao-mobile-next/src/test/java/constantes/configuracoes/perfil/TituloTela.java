package constantes.configuracoes.perfil;

public enum TituloTela {

    EMPRÉSTIMO_PESSOAL("EMPRÉSTIMO PESSOAL"),
    CONFIGURACOES_PAGAMENTO("CONFIGURAÇÕES DE PAGAMENTO"),
    PERFIL("PERFIL"),
    DEBITO_AUTOMATICO("DÉBITO AUTOMÁTICO"),
    TERMOS_CONDICOES("TERMOS E CONDIÇÕES"),
    ENDERECO_RESIDENCIAL( "ENDEREÇO RESIDENCIAL"),
    EDITAR_ENDERECO_RESIDENCIAL( "EDITAR ENDEREÇO RESIDENCIAL"),
    LEI_NUMERO_7115("LEI Nº 7.115"),
    SUCESSO("SUCESSO"),
    CONFIGURACAO_APP("CONFIGURAÇÕES DO APP"),
    TROCAR_SENHA_APP("TROCAR SENHA DO APP"),
    SENHA_ALTERADA("Senha Alterada"),
    CONFIGURACOES_DA_CONTA("CONFIGURAÇÕES DA CONTA"),
    ENCERRAR_CONTA("ENCERRAR CONTA");



    private String value;

    private TituloTela(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

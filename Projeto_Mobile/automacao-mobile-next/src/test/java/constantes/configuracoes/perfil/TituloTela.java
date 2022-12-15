package constantes.configuracoes.perfil;

public enum TituloTela {

    EMPR�STIMO_PESSOAL("EMPR�STIMO PESSOAL"),
    CONFIGURACOES_PAGAMENTO("CONFIGURA��ES DE PAGAMENTO"),
    PERFIL("PERFIL"),
    DEBITO_AUTOMATICO("D�BITO AUTOM�TICO"),
    TERMOS_CONDICOES("TERMOS E CONDI��ES"),
    ENDERECO_RESIDENCIAL( "ENDERE�O RESIDENCIAL"),
    EDITAR_ENDERECO_RESIDENCIAL( "EDITAR ENDERE�O RESIDENCIAL"),
    LEI_NUMERO_7115("LEI N� 7.115"),
    SUCESSO("SUCESSO"),
    CONFIGURACAO_APP("CONFIGURA��ES DO APP"),
    TROCAR_SENHA_APP("TROCAR SENHA DO APP"),
    SENHA_ALTERADA("Senha Alterada"),
    CONFIGURACOES_DA_CONTA("CONFIGURA��ES DA CONTA"),
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

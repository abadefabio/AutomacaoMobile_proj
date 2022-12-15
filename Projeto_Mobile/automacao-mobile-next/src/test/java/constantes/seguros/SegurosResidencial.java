package constantes.seguros;

public enum SegurosResidencial {
    //TODOS

    TITULO_TELA_PRODUTO_RESIDENCIAL("SEGUROS"),
    TITULO_TELA_PRODUTO_SIMULAR_NOVAMENTE_RESIDENCIAL("SEGUROS"),
    TITULO_TELA_DETALHES_COBERTURA("ENTENDA AS COBERTURAS"),
    TITULO_TELA_LISTA_CONDICOES_GERAIS("CONDI��ES GERAIS"),
    TITULO_TELA_CONDICOES_GERAIS("CONDI��ES GERAIS"),
    TITULO_TELA_SAIBA_MAIS_INFO_PARCEIRO("SEGURO RESIDENCIAL"),
    TITULO_TELA_EDITAR_ENDERECO ("SEGUROS"),
    TITULO_TELA_VISAO_GERAL ("VIS�O GERAL"),
    TITULO_TELA_SALDO_INSUFICIENTE ("SEGUROS"),
    TITULO_TELA_TELEFONES_UTEIS ("Telefones �teis"),
    TEXTO_NUMERO_PROTOCOLO ("N�mero do protocolo");

    private String value;

    private SegurosResidencial(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }
}

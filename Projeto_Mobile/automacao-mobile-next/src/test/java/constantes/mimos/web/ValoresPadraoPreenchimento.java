package constantes.mimos.web;

public enum ValoresPadraoPreenchimento {

    CAMPO_BENEFICIO("NOME PADRAO BENEFICIO"),
    CAMPO_TEXTO("VALOR PADRAO PARA O TEXTO"),
    CAMPO_COMO_USAR("VALOR PADRAO COMO USAR PARA TESTE"),
    NOME_BOTAO("TEXTO PADRAO NOME BOTAO"),
    URL_SITE("https://zazcar.com.br/mapa");


    private String value;
    ValoresPadraoPreenchimento(String value) {this.value = value; }

    @Override
    public String toString() {
        return this.value;
    }

}

package constantes.pagamentos;

public enum Pagamentos {
    //TODOS
    PAGAMENTOS("PAGAMENTOS"),
    TITULO_DIGITAR_CODIGO("DIGITAR C�DIGO DE BARRAS"),
    TITULO_BOLETO("BOLETO"),
    DETALHES_TELA_BOLETO("Ops, n�o deu pra ler o c�digo");

    private String value;

    private Pagamentos(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }

}

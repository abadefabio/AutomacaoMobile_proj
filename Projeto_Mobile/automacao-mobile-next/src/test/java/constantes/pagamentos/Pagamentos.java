package constantes.pagamentos;

public enum Pagamentos {
    //TODOS
    PAGAMENTOS("PAGAMENTOS"),
    TITULO_DIGITAR_CODIGO("DIGITAR CÓDIGO DE BARRAS"),
    TITULO_BOLETO("BOLETO"),
    DETALHES_TELA_BOLETO("Ops, não deu pra ler o código");

    private String value;

    private Pagamentos(String value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return value;
    }

}

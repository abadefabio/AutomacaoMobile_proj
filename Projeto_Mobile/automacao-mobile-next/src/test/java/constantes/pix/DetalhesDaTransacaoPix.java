package constantes.pix;

public enum DetalhesDaTransacaoPix {
    TITULO_DETALHES_DA_TRANSACAO("DETALHES DA TRANSA��O");

    private String value;

    DetalhesDaTransacaoPix(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

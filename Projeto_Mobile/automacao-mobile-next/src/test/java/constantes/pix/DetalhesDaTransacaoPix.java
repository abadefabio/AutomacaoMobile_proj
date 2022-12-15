package constantes.pix;

public enum DetalhesDaTransacaoPix {
    TITULO_DETALHES_DA_TRANSACAO("DETALHES DA TRANSAÇÃO");

    private String value;

    DetalhesDaTransacaoPix(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

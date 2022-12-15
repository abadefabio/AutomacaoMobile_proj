package constantes.saldoextrato;

public enum TipoTransacao {

    APLICACAO("Aplicação"),
    APLICACAO_EM_INVESTIMENTO("APLICACAO EM INVESTIMENTO"),
    PIX("Pix"),
    CONTA("Conta");

    private String value;

    private TipoTransacao(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

package constantes.alertas;

public enum AlertaTransferenciaSucesso {

    MENSAGEM_TRANSFERENCIA_COM_SUCESSO("Pronto. A transferência tá feita! Caso precise do comprovante é só entrar em contato com a agência");

    private String value;

    AlertaTransferenciaSucesso(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}

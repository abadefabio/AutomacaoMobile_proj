package constantes.alertas;

public enum AlertaTransferenciaSucesso {

    MENSAGEM_TRANSFERENCIA_COM_SUCESSO("Pronto. A transfer�ncia t� feita! Caso precise do comprovante � s� entrar em contato com a ag�ncia");

    private String value;

    AlertaTransferenciaSucesso(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}

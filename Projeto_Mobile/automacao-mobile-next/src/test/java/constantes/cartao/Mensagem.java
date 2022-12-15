package constantes.cartao;

public enum Mensagem {

    MENSAGEM_CONTRATAR_SEGURO_TELA("Proteja seu cart�o de cr�dito contra perda, furto, roubo ou outros imprevistos e concorra a R$ 12 mil toda semana!"),
    CREDITO_ATIVADO("Cr�dito ativado!"),
    TUDO_CERTO("Tudo certo!"),
    VER_FATURA("VER FATURA"),
    COMPLETE_ACAO_USANDO("Complete a a��o usando"),
    NEXT("next"),
    CANCELAR("Cancelar"),
    MENSAGEM_LIMITE_PRE_APROVADO("Limite pr�-aprovado");

    private String value;

    Mensagem(String value) {
        this.value = value;
    }

    @Override
    public String toString() {

        return value;
    }
}

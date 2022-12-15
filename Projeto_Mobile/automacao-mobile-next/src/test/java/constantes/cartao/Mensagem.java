package constantes.cartao;

public enum Mensagem {

    MENSAGEM_CONTRATAR_SEGURO_TELA("Proteja seu cartão de crédito contra perda, furto, roubo ou outros imprevistos e concorra a R$ 12 mil toda semana!"),
    CREDITO_ATIVADO("Crédito ativado!"),
    TUDO_CERTO("Tudo certo!"),
    VER_FATURA("VER FATURA"),
    COMPLETE_ACAO_USANDO("Complete a ação usando"),
    NEXT("next"),
    CANCELAR("Cancelar"),
    MENSAGEM_LIMITE_PRE_APROVADO("Limite pré-aprovado");

    private String value;

    Mensagem(String value) {
        this.value = value;
    }

    @Override
    public String toString() {

        return value;
    }
}

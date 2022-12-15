package constantes.mimos.web;

public enum FormaDePagamento {
    CARTAO_DEBITO("Cartão de débito"),
    CUPOM_DESCONTO("Cupom de desconto"),
    CUPONS_DESCONTO("Cupons de desconto"),
    DESCONTO("Desconto"),
    GRATIS("Grátis"),
    GRATUITO("Gratuito"),
    VOUCHERS("Vouchers"),
    VOUCHERS_DESCONTO("Vouchers de desconto");

    private String value;

    FormaDePagamento(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}

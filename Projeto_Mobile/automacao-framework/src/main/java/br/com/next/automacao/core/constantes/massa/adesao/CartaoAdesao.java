package br.com.next.automacao.core.constantes.massa.adesao;

public enum CartaoAdesao {

    VISA_NEXT_INTERNACIONAL(6382, "Visa Next Internacional",15),
    VISA_NEXT_GOLD(6381,"Visa Next Gold",20),
    VISA_NEXT_PLATINUM(6380, "Visa Next Platinum",30),
    DEBITO_INTERNACIONAL(0, "Debito",0);

    private int codigoProduto;
    private String descricaoProduto;
    private int valorProduto;

    private CartaoAdesao(int codigoProduto, String descricaoProduto, int valorProduto) {
        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
        this.valorProduto = valorProduto;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }
    public String getDescricaoProduto() {
        return descricaoProduto;
    }
    public int getValorProduto() {
        return valorProduto;
    }

}

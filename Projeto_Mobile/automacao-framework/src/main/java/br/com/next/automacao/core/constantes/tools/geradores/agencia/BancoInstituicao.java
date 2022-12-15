package br.com.next.automacao.core.constantes.tools.geradores.agencia;

public enum BancoInstituicao {
    BRADESCO("BRADESCO"),
    ITAU("ITAU"),
    SANTANDER("SANTANDER"),
    BANCO_DO_BRASIL("BANCO DO BRASIL"),
    CAIXA_ECONOMICA_FEDERAL("CAIXA ECONOMICA FEDERAL");
    String valor;

    BancoInstituicao(String bancoInstituicao) {
        valor = bancoInstituicao;
    }

    public String toString() {
        return this.valor;
    }
}

package br.com.next.automacao.core.constantes.tools.geradores.agencia;

public enum TipoDeContaCaixaEconomicaFederal {

        /*
    Conta corrente de Pessoa Física: 001
    Conta simples de Pessoa Física: 002
    Conta corrente de Pessoa Jurídica: 003
    Entidades públicas: 006
    Depósitos instituições financeiras: 007
    Poupança de Pessoa Física: 013
    Poupança de Pessoa Jurídica: 022
    Conta Caixa Fácil: 023
    Poupança de crédito imobiliário: 028
    Conta Investimento Pessoa Física: 032
    Conta Investimento Pessoa Jurídica: 034
    Conta Salário: 037
    Depósitos lotéricos: 043
    Poupança integrada: 131
    */

    TIPO_001("001"),
    TIPO_002("002"),
    TIPO_003("003"),
    TIPO_006("006"),
    TIPO_007("007"),
    TIPO_013("013"),
    TIPO_022("022"),
    TIPO_023("023"),
    TIPO_028("028"),
    TIPO_032("032"),
    TIPO_034("034"),
    TIPO_037("037"),
    TIPO_043("043"),
    TIPO_131("131");


    private final String valor;

    TipoDeContaCaixaEconomicaFederal(String valorOpcao) {
        valor = valorOpcao;
    }

    public String recuperarTipoDeConta() {
        return valor;
    }
}

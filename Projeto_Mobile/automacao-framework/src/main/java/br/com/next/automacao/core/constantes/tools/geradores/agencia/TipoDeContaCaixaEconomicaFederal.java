package br.com.next.automacao.core.constantes.tools.geradores.agencia;

public enum TipoDeContaCaixaEconomicaFederal {

        /*
    Conta corrente de Pessoa F�sica: 001
    Conta simples de Pessoa F�sica: 002
    Conta corrente de Pessoa Jur�dica: 003
    Entidades p�blicas: 006
    Dep�sitos institui��es financeiras: 007
    Poupan�a de Pessoa F�sica: 013
    Poupan�a de Pessoa Jur�dica: 022
    Conta Caixa F�cil: 023
    Poupan�a de cr�dito imobili�rio: 028
    Conta Investimento Pessoa F�sica: 032
    Conta Investimento Pessoa Jur�dica: 034
    Conta Sal�rio: 037
    Dep�sitos lot�ricos: 043
    Poupan�a integrada: 131
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

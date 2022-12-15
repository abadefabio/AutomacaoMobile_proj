package br.com.next.automacao.core.constantes.tools.geradores.agencia;

public enum TipoDeContaSantander {

    TIPO_01("01"),
    TIPO_02("02"),
    TIPO_03("03"),
    TIPO_05("05"),
    TIPO_07("07"),
    TIPO_09("09"),
    TIPO_13("13"),
    TIPO_27("27"),
    TIPO_35("35"),
    TIPO_37("37"),
    TIPO_43("43"),
    TIPO_45("45"),
    TIPO_46("46"),
    TIPO_48("48"),
    TIPO_50("50"),
    TIPO_53("53"),
    TIPO_60("60"),
    TIPO_92("92");

    String valor;

    TipoDeContaSantander(String valorOpcao) {
        valor = valorOpcao;
    }

    public String recuperarTipoDeConta() {
        return valor;
    }

}

package br.com.next.automacao.core.massa.conta;

public class ModeloConta {
    private String club = null;
    private String dataAbertura = null;
    private String indicadorEncerramento = null;
    private String agencia = null;
    private String digitoAgencia= null;
    private String conta= null;
    private String digitoConta= null;
    private String razaoSgrp= null;
    private String razaoCgrp= null;

    public String getClub() {
        return club;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public String getIndicadorEncerramento() {
        return indicadorEncerramento;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getDigitoAgencia() {
        return digitoAgencia;
    }

    public String getConta() {
        return conta;
    }

    public String getDigitoConta() {
        return digitoConta;
    }

    public String getRazaoSgrp() {
        return razaoSgrp;
    }

    public String getRazaoCgrp() {
        return razaoCgrp;
    }


    public void setClub(String club) {
        this.club = club;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public void setIndicadorEncerramento(String indicadorEncerramento) {
        this.indicadorEncerramento = indicadorEncerramento;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public void setDigitoAgencia(String digitoAgencia) {
        this.digitoAgencia = digitoAgencia;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public void setDigitoConta(String digitoConta) {
        this.digitoConta = digitoConta;
    }

    public void setRazaoSgrp(String razaoSgrp) {
        this.razaoSgrp = razaoSgrp;
    }

    public void setRazaoCgrp(String razaoCgrp) {
        this.razaoCgrp = razaoCgrp;
    }
}

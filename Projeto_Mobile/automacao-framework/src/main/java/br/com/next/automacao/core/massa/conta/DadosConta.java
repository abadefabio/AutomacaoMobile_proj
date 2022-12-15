package br.com.next.automacao.core.massa.conta;

import br.com.next.automacao.core.constantes.massa.conta.Conta;

import static br.com.next.automacao.core.massa.conta.RequisicaoConta.consultaDadosConta;
import static br.com.next.automacao.core.massa.conta.RequisicaoConta.getModeloConta;


public class DadosConta {
    public static String recuperarDadosConta(Conta conta) throws Exception {

        switch (conta) {
            case CLUB:
                return getModeloConta().getClub();
            case DATA_ABERTURA:
                return getModeloConta().getDataAbertura();
            case INDICADOR_ENCERRAMENTO:
                return getModeloConta().getIndicadorEncerramento();
            case AGENCIA:
                return getModeloConta().getAgencia();
            case DIGITO_AGENCIA:
                return getModeloConta().getDigitoAgencia();
            case CONTA:
                return getModeloConta().getConta();
            case DIGITO_CONTA:
                return getModeloConta().getDigitoConta();
            case RAZAO_SGRP:
                return getModeloConta().getRazaoSgrp();
            case RAZAO_CGRP:
                return getModeloConta().getRazaoCgrp();
            default:
                return null;
        }

    }
}

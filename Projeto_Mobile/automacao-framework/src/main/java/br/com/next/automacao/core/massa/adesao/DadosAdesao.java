package br.com.next.automacao.core.massa.adesao;


import br.com.next.automacao.core.constantes.massa.adesao.Adesao;

import static br.com.next.automacao.core.massa.adesao.RequisicaoAdesao.getModeloAdesao;

public class DadosAdesao {
    public static String recuperarDadosAdesao(Adesao dadosAdesao) {

        switch (dadosAdesao) {
            case CPF:
            return getModeloAdesao().getCpf();

            default:
                return null;
        }

    }
}

package br.com.next.automacao.core.massa.portabilidade;


import br.com.next.automacao.core.constantes.massa.Portabilidade.Portabilidade;
import static br.com.next.automacao.core.massa.portabilidade.RequisicaoPortabilidade.getModeloPortabilidade;

public class DadosPortabilidade {
    public static String recuperarDadosPortabilidade(Portabilidade portabilidade) {

        switch (portabilidade) {
            case DATA_CRIACAO:
                return getModeloPortabilidade().getDataCriacaoPortabilidade();
            case CNPJ:
                return getModeloPortabilidade().getCnpjPortabilidade();
            case CPF:
                return getModeloPortabilidade().getCpfPortabilidade();
            case CODIGO_BANCO:
                return getModeloPortabilidade().getCodigoBancoPortabilidade();
            case NOME_BANCO:
                return getModeloPortabilidade().getNomeBancoPortabilidade();
            default:
                return null;
        }

    }
}

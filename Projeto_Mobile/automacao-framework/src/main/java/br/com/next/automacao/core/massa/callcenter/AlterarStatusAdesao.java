package br.com.next.automacao.core.massa.callcenter;

import br.com.next.automacao.core.constantes.massa.callcenter.StatusAdesaoOnboarding;

import static br.com.next.automacao.core.massa.callcenter.requisicaoCallCenter.modificarStatusAdesao;

/**
 * Alterar o status da adesão para status pre definidos no enum statusAdesao
 * @author Rodrigo Benedetti
 * @since 2021-04
 */
public class AlterarStatusAdesao {
    public static void alterarStatusAdesao(StatusAdesaoOnboarding statusAdesao, String cpf) {
        try {
            switch (statusAdesao) {
                case ATIVACAO_DE_INTEGRACAO:
                    modificarStatusAdesao(cpf,statusAdesao.getCodigoOnboarding());
                case EM_SUBLIMISSAO:
                    modificarStatusAdesao(cpf,statusAdesao.getCodigoOnboarding());
                case SOB_ANALISE:
                    modificarStatusAdesao(cpf,statusAdesao.getCodigoOnboarding());
                case REPROVADA:
                    modificarStatusAdesao(cpf,statusAdesao.getCodigoOnboarding());
                case DOCUMENTO_PRENDENTE:
                    modificarStatusAdesao(cpf,statusAdesao.getCodigoOnboarding());
                case APROVADA_NAO_FINALIZADA:
                    modificarStatusAdesao(cpf,statusAdesao.getCodigoOnboarding());
                case APROVADA_FINALIZADA:
                    modificarStatusAdesao(cpf,statusAdesao.getCodigoOnboarding());
                    break;
            }
        } catch (NullPointerException e) {
            e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

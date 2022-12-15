package br.com.next.automacao.core.massa.adesao;


import br.com.next.automacao.core.constantes.massa.adesao.Adesao;
import br.com.next.automacao.core.constantes.massa.adesao.CartaoAdesao;
import br.com.next.automacao.core.constantes.massa.adesao.PlanoAdesao;
import br.com.next.automacao.core.constantes.massa.adesao.TipoAdesao;
import static br.com.next.automacao.core.massa.adesao.RequisicaoAdesao.*;



public class CriarAdesao {

    /**
     * Cria a uma adesão de acordo com as especificação desejadas
     *
     * @return Cpf
     * Exemplo: montarAdesao(TipoAdesao.ADESAO_RESPONSAVEL_RG,PlanoAdesao.SERVICOS_ESSENCIAIS,CartaoAdesao.VISA_NEXT_PLATINUM);
     *      */
    public static void montarAdesao(TipoAdesao tipoAdesao, PlanoAdesao planoAdesao, CartaoAdesao cartaoAdesao) {
        try {
            switch (tipoAdesao) {
                case ADESAO_RESPONSAVEL_CNH:
                    preRegistrationNext();
                    criarUserPassword();
                    loginApp();
                    retornaCustomeId();
                    application(criarCorpoRequisicaoAApplicationUm());
                    requiredDocuments();
                    uploadVideo();
                    uploadCnh();
                    creditAssessment();
                    returnsPlansCard();
                    detailedCustomerInfo();
                    application(criarCorpoRequisicaoAApplicationDois(planoAdesao.getCodigoPlano(),planoAdesao.getDescricaoPlano(),planoAdesao.getValorPlano(),cartaoAdesao.getCodigoProduto(),cartaoAdesao.getDescricaoProduto(),cartaoAdesao.getValorProduto()));
                    cardPassword();
                    termsAndConditions();
                    submitApplicationAndCodes();
                    System.out.println(DadosAdesao.recuperarDadosAdesao(Adesao.CPF));
                    break;
                case ADESAO_RESPONSAVEL_RG:
                    preRegistrationNext();
                    criarUserPassword();
                    loginApp();
                    retornaCustomeId();
                    application(criarCorpoRequisicaoAApplicationUm());
                    requiredDocuments();
                    uploadVideo();
                    uploadRg();
                    creditAssessment();
                    returnsPlansCard();
                    detailedCustomerInfo();
                    application(criarCorpoRequisicaoAApplicationDois(planoAdesao.getCodigoPlano(),planoAdesao.getDescricaoPlano(),planoAdesao.getValorPlano(),cartaoAdesao.getCodigoProduto(),cartaoAdesao.getDescricaoProduto(),cartaoAdesao.getValorProduto()));
                    cardPassword();
                    termsAndConditions();
                    submitApplicationAndCodes();
                    System.out.println(DadosAdesao.recuperarDadosAdesao(Adesao.CPF));
                    break;
                case ADESAO_JOY:
                    System.out.println("EM CONSTRUÇÃO");
                    break;
            }
        } catch (NullPointerException e) {
            e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

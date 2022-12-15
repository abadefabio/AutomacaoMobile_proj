package funcionalidade.web.fnext.n1;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.fnext.n1.CardInformacoesPropostaTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class InformacoesDaPropostaFunc extends FuncionalidadeBase {

    /**
     * Verificar campo Bureau de Face quando Positivo na tela de Consulta da Proposta N1
     *
     */
    public void verificarCampoBureauDeFacePositivoTelaConsultaN1() {
        new CardInformacoesPropostaTela(getWebDriver())
                .validarCampoBureauDeFacePositivoTelaConsultaN1();
    }

    /**
     * Verificar campo Bureau de Face quando Positivo na tela de Edição da Proposta
     *
     */
    public void verificarCampoBureauDeFacePositivoTelaEdicao() {
        new CardInformacoesPropostaTela(getWebDriver())
                .validarCampoBureauDeFacePositivoTelaEdicao();
    }

    /**
     * Verificar campo Bureau de Face quando Negativo
     *
     */
    public void verificarCampoBureauDeFaceNegativo() {
        new CardInformacoesPropostaTela(getWebDriver())
                .validarCampoBureauDeFaceNegativo();
    }

    /**
     * Verificar campo Liveness quando Positivona tela de Consulta da Proposta N1
     *
     */
    public void verificarCampoLivenessPositivoTelaConsultaN1() {
        new CardInformacoesPropostaTela(getWebDriver())
                .validarCampoLivenessPositivoTelaConsultaN1();
    }
}

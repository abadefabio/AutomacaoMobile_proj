package funcionalidade.web.cockpit.atendimento;

import br.com.bradesco.next.test.data.provider.client.api.TestDataOnboardingControllerApi;
import br.com.bradesco.next.test.data.provider.client.invoker.ApiResponse;
import br.com.bradesco.next.test.data.provider.client.model.FNEXTN1ApproveRequest;
import br.com.bradesco.next.test.data.provider.client.model.FNEXTN1ApproveResponse;
import br.com.next.automacao.core.base.FuncionalidadeBase;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.cockpit.Url;
import dados.base.PortalMassasClient;
import pagina.web.cockpit.FrameContainer;
import pagina.web.cockpit.FrameVisao;
import pagina.web.cockpit.atendimento.resumo.ResumoAdesaoTela;
import tools.ContensorTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;
import static dados.base.PortalMassasClient.*;

public class ResumoAdesaoFunc extends FuncionalidadeBase {

    /**
     * Realizar uma adesao com sucesso para cliente Next
     * utilizando o Portal de Massas.
     * Este método deverá substituir os demais em scripts
     * já existentes
     */
    public void aprovarEtapaN1Gerente(String cpf, String nome) throws Exception {
        FNEXTN1ApproveRequest fnextn1ApproveRequest = new FNEXTN1ApproveRequest();
        fnextn1ApproveRequest.document(cpf);
        fnextn1ApproveRequest.fullName(nome);
        FNEXTN1ApproveResponse response = null;
        try {
            response = new PortalMassasClient().testDataOnboardingControllerApi()
                    .fnextN1Approve(
                            getCoreIP(),
                            getCsrUserId(),
                            getCsrUserPassword(),
                            getEsteira(),
                            fnextn1ApproveRequest
                    );

        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    /**
     * Navegar
     */
    private void navegar(String url) {
        getWebDriver().navigate().to(url);
    }

    /**
     * Realizar uma adesao com sucesso para cliente Next
     */
    public void realizarAprovacaoClienteNext(String cpf) throws Exception {
        new ContensorTela(getWebDriver(), FrameVisao.class)
                .executar(new ResumoAdesaoTela(getWebDriver())
                        .validarCpfAdesao(cpf))
                .desfazer();

        new ContensorTela(getWebDriver(), FrameContainer.class)
                .executar(new ResumoAdesaoTela(getWebDriver())
                        .clicarNoBotaoAprovarAdesao())
                .desfazer();

        new ResumoAdesaoTela(getWebDriver())
                .validarAprovacaoComSucesso();
    }

    /**
     * Validar reprovação com sucesso para cliente Next
     */
    public void realizarReprovacaoClienteNext(String cpf) throws Exception {
        new ResumoAdesaoTela(getWebDriver())
                .validarCpfAdesao(cpf)
                .clicarNoBotaoReprovarAdesao()
                .validarCampoJustificativa()
                .clicarBotaoFecharPopup()
                .preencherJustificativaParaAprovacao()
                .clicarNoBotaoReprovarAdesao()
                .clicarBotaoReprovacaoSim()
                .validarConfirmacaoReprovacao();


        new ResumoAdesaoTela(getWebDriver())
                .validarReprovacaoComSucesso();
    }



}


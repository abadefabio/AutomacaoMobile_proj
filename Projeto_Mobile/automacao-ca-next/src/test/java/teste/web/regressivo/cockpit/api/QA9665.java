package teste.web.regressivo.cockpit.api;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.cockpit.AtendimentoEndpoint;
import funcionalidade.api.cockpit.LoginFunc;
import funcionalidade.api.cockpit.atendimento.ListCustomerDocumentsApiFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.tools.ReadProperties.getEsteira;

@Jornada(Jornadas.COCKPIT_DE_ATENDIMENTO)
public class QA9665 extends TesteBase {

    LoginFunc loginFunc = new LoginFunc();
    ListCustomerDocumentsApiFunc docs = new ListCustomerDocumentsApiFunc();

    @Test(description = "List Customer Documents")
    @Description("Objetivo: Validar retorno do micro serviço ListCustomerDocuments\n" +
            "\n" +
            "Pré-requisito:\n" +
            "\n" +
            "Pós-condição:")
    @Severity(SeverityLevel.NORMAL)
    public void QA9665() throws Exception {

        String cpf = recuperarMassa(JSON.CPF);
        loginFunc.obterToken(cpf);
        docs.enviarRequisicaoGet(AtendimentoEndpoint.LIST_DOCUMENTS, loginFunc.getToken(), getEsteira());
        loginFunc.logoffToken(cpf);

        docs.validarVideoMp4(recuperarJSSONMassa("validacaoVideoAceite"));
        docs.validarRegistroGeralCpfEmJpeg(recuperarJSSONMassa("validacaoRgCpfJpeg"));
        docs.validarArquivoInformacoesEssenciaisContaNext(
                recuperarJSSONMassa("validacaoArqInfoEssenciaisContaNext")
        );
        docs.validarTermoAdesaoProdEServPdf(recuperarJSSONMassa("validacaoProdEServPdf"));
        docs.validarArquivoTermoDeCondicao(recuperarJSSONMassa("validacaoTermoCondicaoPdf"));
        docs.validarArquivoDiretivasDePrivacidade(
                recuperarJSSONMassa("validacaoDiretivasPrivacidadePdf")
        );
        docs.validarRetornoPropostaAberturaContaDepPf(
                recuperarJSSONMassa("validacaoPropostaAberturaContaDepPf")
        );
        docs.validarRetornoAberturaContaCestaServico(
                recuperarJSSONMassa("validacaoRetornoAberturaContaCestaServico")
        );

    }
}

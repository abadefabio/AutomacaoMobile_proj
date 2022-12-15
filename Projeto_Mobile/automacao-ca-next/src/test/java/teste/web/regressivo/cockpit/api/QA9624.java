package teste.web.regressivo.cockpit.api;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.cockpit.AtendimentoEndpoint;
import funcionalidade.api.cockpit.LoginFunc;
import funcionalidade.api.cockpit.atendimento.StatusCustomerApiFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.tools.ReadProperties.getEsteira;

@Jornada(Jornadas.COCKPIT_DE_ATENDIMENTO)
public class QA9624 extends TesteBase {

    StatusCustomerApiFunc customerApiFunc = new StatusCustomerApiFunc();
    LoginFunc loginFunc = new LoginFunc();

    @Test(description = "Validar status de uma proposta em Adesao OnboardingStatus_1")
    @Description("Objetivo: validar status de uma proposta em Adesao Onboarding Status 1\n" +
            "\n" +
            "Pr�-requisito: CPF est� com uma ades�o no status 01\n" +
            "\n" +
            "P�s-condi��o:")

    @Severity(SeverityLevel.NORMAL)
    public void QA9624() throws Exception {

        String cpf = recuperarMassa(JSON.CPF);
        loginFunc.obterToken(cpf);

        customerApiFunc.enviarRequisicao(AtendimentoEndpoint.STATUS_COSTUMER, loginFunc.getToken(), getEsteira() );
        loginFunc.logoffToken(cpf);

        customerApiFunc.validarStatusEDadosRequisicao(recuperarJSSONMassa("status_1"),1);
    }
}

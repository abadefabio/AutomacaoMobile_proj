package teste.web.regressivo.cockpit.api;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.cockpit.AtendimentoEndpoint;
import funcionalidade.api.cockpit.LoginFunc;
import funcionalidade.api.cockpit.atendimento.DetailedCustomerInfoApiFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.tools.ReadProperties.getEsteira;

@Jornada(Jornadas.COCKPIT_DE_ATENDIMENTO)
public class QA9528 extends TesteBase {

    LoginFunc loginFunc = new LoginFunc();
    DetailedCustomerInfoApiFunc customerInfo = new DetailedCustomerInfoApiFunc();

    @Test(description = "Validar retorno informações detalhadas da Visão360 - Cliente Next Joy")
    @Description("Objetivo: Validar retorno do micro serviço DetaledCustomerInfo, cliente Next Joy\n" +
            "\n" +
            "Pré-requisito: Possuir um cliente Next joy ativo\n" +
            "\n" +
            "Pós-condição:")
    @Severity(SeverityLevel.NORMAL)
    public void QA9528() throws Throwable {

        String cpf = recuperarMassa(JSON.CPF);
        loginFunc.obterToken(cpf);
        customerInfo.enviarRequisicaoGet(AtendimentoEndpoint.CUSTOMER_INFO, loginFunc.getToken());
        loginFunc.logoffToken(cpf);

        customerInfo.validarInfoVisao360ClienteJoy(cpf, recuperarJSSONMassa("validacaoVisao360"));
        customerInfo.validarEnderecoClienteComumNextJoy(recuperarJSSONMassa("validacaoEndereco"));
    }
}

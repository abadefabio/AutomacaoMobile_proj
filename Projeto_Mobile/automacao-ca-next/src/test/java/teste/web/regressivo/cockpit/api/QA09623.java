package teste.web.regressivo.cockpit.api;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.cockpit.AtendimentoEndpoint;
import funcionalidade.api.cockpit.LoginFunc;
import funcionalidade.api.cockpit.atendimento.ListCustomerDependentsApiFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.tools.ReadProperties.getEsteira;

@Jornada(Jornadas.PERFIL_CONFIGURACOES)
public class QA09623 extends TesteBase {

    ListCustomerDependentsApiFunc listCustomerDependentsApiFunc = new ListCustomerDependentsApiFunc();
    LoginFunc loginFunc = new LoginFunc();

    @Test(description = "Validar retorno das informações dos dependentes - Cliente Next Representante")
    @Description("Objetivo: Validar retorno do micro serviço ListCustomerDependents, cliente Next representante\n" +
            "\n" +
            "Pré-requisito: Possuir um cliente Next representante ativo")
    @Severity(SeverityLevel.NORMAL)

    public void QA09623() throws Exception {

        String cpf = recuperarMassa(JSON.CPF);
        loginFunc.obterToken(cpf);

        listCustomerDependentsApiFunc.enviarRequisicao(AtendimentoEndpoint.LIST_CUSTOMER_DEPENDENTS,loginFunc.getToken(),getEsteira());
        loginFunc.logoffToken(cpf);

        listCustomerDependentsApiFunc.validarNomesDependentes();

        listCustomerDependentsApiFunc.validarCpfsDependentes();

        listCustomerDependentsApiFunc.validarAgenciaDependentes();

        listCustomerDependentsApiFunc.validarNumeroEDigitoDaContaDependentes();
    }
}


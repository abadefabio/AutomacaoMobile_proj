
package teste.web.regressivo.cockpit.web;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.tools.ReadProperties;
import funcionalidade.api.cockpit.LoginFunc;
import funcionalidade.web.cockpit.atendimento.ResumoAdesaoFunc;
import funcionalidade.web.cockpit.login.LoginWebFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.massa.adesao.RequisicaoAdesao.cpf;

@Jornada(Jornadas.COCKPIT_DE_ATENDIMENTO)
public class QA11655 extends TesteBase {

    LoginFunc loginFunc = new LoginFunc();
    LoginWebFunc loginWebFunc = new LoginWebFunc();
    ResumoAdesaoFunc resumoAdesaoFunc = new ResumoAdesaoFunc();

    @Test(description = "Validar no Telas a Reprovação da Proposta de Adesão do Cliente Next")
    @Description("Objetivo: Validar no Telas a Reprovação da Proposta de Adesão proveniente do FNEXT realizada pelo Gerente da Agência.\n" +
            "\n" +
            "Pré-requisito:\n" +
            "- Ter proposta de adesão abertura de conta Next\n" +
            "- Ter proposta concluída no fluxo das etapas (N1 DOC) e (N2 Segurança Corportativa) plataforma Fnext")
    @Severity(SeverityLevel.NORMAL)

    public void QA11655() throws Exception {

        String cpf = recuperarMassa("document");

        loginFunc.obterToken(cpf);
        loginWebFunc.realizarLoginEmuladorADESAO(
                recuperarMassa("funcionalidade"),
                cpf,
                loginFunc.getToken(),
                recuperarMassa("proposal"),
                recuperarMassa("prospect"),
                recuperarMassa("operador"),
                recuperarMassa("nomeOperador"));
        resumoAdesaoFunc.realizarReprovacaoClienteNext(cpf);
    }
}

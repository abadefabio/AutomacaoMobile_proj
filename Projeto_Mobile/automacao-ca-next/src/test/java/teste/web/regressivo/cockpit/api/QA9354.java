package teste.web.regressivo.cockpit.api;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.cockpit.AtendimentoEndpoint;
import funcionalidade.api.cockpit.LoginFunc;
import funcionalidade.api.cockpit.atendimento.AllBallancesApiFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.tools.ReadProperties.getEsteira;

@Jornada(Jornadas.COCKPIT_DE_ATENDIMENTO)
public class QA9354 extends TesteBase {

    LoginFunc loginFunc = new LoginFunc();
    AllBallancesApiFunc allBalances = new AllBallancesApiFunc();

    @Test(description = "Validar retorno informações do resumo de saldo da conta do cliente")
    @Description("Objetivo: Validar informacoes do resumo de saldo da conta do cliente - resumo do saldo, resumo de CreditCard, resumo de Limit;\n" +
            "\n" +
            "Pré-requisito:\n" +
            "\n" +
            "Pós-condição:")
    @Severity(SeverityLevel.NORMAL)
    public void QA9354() throws Exception {

        String cpf = recuperarMassa(JSON.CPF);
        loginFunc.obterToken(cpf);
        allBalances.enviarRequisicaoGet(AtendimentoEndpoint.ALL_BALANCES, loginFunc.getToken(), getEsteira());
        loginFunc.logoffToken(cpf);

        allBalances.validarResumoSaldo(recuperarJSSONMassa("validacaoResumoSaldo"));
        allBalances.validarResumoCreditCard();
        allBalances.validarResumoLimites(recuperarJSSONMassa("validacaoLimites"));
    }
}

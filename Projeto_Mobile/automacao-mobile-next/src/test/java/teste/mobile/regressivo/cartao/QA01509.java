package teste.mobile.regressivo.cartao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import funcionalidade.mobile.cartao.fatura.AtivarCartaoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.CARTOES)
public class QA01509 extends TesteBase {

    LoginFunc loginFunc = new LoginFunc();
    MenuFunc menuFunc = new MenuFunc();
    AtivarCartaoFunc ativarCartaoFunc = new AtivarCartaoFunc();


    @Test(description = "PIB-34741.43706.002 – Ativar o crédito por meio do menu cartão")
    @Description("Eu enquanto cliente quero poder ativar o meu crédito por meio do menu cartão\n" +
                "\n" +
                "sistema não deverá mais apresentar a opção “Pedir cartão de crédito” e deve\n" +
                "passar a apresentar a opção “Ativar cartão de crédito”*Ser cliente Next\n" +
                "*Realizar o login no app next após 48 horas da contratação do cartão de crédito\n" +
                "*Ter acesso ao APP Next\n" +
                "*Estar logado no APP Next")
    @Severity(SeverityLevel.NORMAL)

    public void QA01509() throws Exception{

        loginFunc.efetuarLoginUsuarioExistente(recuperarMassa("cpf"), recuperarMassa("senha"));

        menuFunc.selecionarCartao();

        ativarCartaoFunc.ativarCartaoDeCredito(recuperarMassa("cartao"), recuperarMassa("cvv"));
    }
}

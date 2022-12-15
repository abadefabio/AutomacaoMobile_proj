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


    @Test(description = "PIB-34741.43706.002 � Ativar o cr�dito por meio do menu cart�o")
    @Description("Eu enquanto cliente quero poder ativar o meu cr�dito por meio do menu cart�o\n" +
                "\n" +
                "sistema n�o dever� mais apresentar a op��o �Pedir cart�o de cr�dito� e deve\n" +
                "passar a apresentar a op��o �Ativar cart�o de cr�dito�*Ser cliente Next\n" +
                "*Realizar o login no app next ap�s 48 horas da contrata��o do cart�o de cr�dito\n" +
                "*Ter acesso ao APP Next\n" +
                "*Estar logado no APP Next")
    @Severity(SeverityLevel.NORMAL)

    public void QA01509() throws Exception{

        loginFunc.efetuarLoginUsuarioExistente(recuperarMassa("cpf"), recuperarMassa("senha"));

        menuFunc.selecionarCartao();

        ativarCartaoFunc.ativarCartaoDeCredito(recuperarMassa("cartao"), recuperarMassa("cvv"));
    }
}

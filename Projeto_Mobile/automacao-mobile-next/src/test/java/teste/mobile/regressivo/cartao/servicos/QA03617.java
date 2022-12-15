package teste.mobile.regressivo.cartao.servicos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.cartao.fatura.ApoiarFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

@Jornada(Jornadas.CARTOES)
public class QA03617 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ApoiarFunc apoiar = new ApoiarFunc();

    @Test(description = "REG.CAR.04.10.09 - Apoiar uma Causa disponível")
    @Description("Pré condição: n/a" + "Objetivo: n/a")
    @Severity(SeverityLevel.NORMAL)
    public void QA03617()throws Exception{

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarCartao();

        apoiar.apoiarCausa();

    }

    @AfterMethod
    public void desfazerApoio(ITestResult result) throws Exception{
        if (result.isSuccess()) {
            apoiar.deixarDeApoiar();
        }
    }
}

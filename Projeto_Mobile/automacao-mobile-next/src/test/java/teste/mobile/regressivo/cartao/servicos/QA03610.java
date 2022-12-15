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
public class QA03610 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private ApoiarFunc apoiar = new ApoiarFunc();

    @Test(description = "REG.CAR.04.10.02 - Apoiar uma Instituição disponível")
    @Description("Pré condição: n/a" +
                 "Objetivo: n/a")
    @Severity(SeverityLevel.NORMAL)

    public void QA03610() throws Exception{

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarCartao();

        apoiar.apoiarInstituicao();

    }

    @AfterMethod
    public void desfazerApoio(ITestResult result) throws Exception{
        if (result.isSuccess()) {
            apoiar.deixarDeApoiar();
        }
    }

}

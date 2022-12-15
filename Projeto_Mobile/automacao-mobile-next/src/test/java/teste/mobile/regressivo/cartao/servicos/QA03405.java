package teste.mobile.regressivo.cartao.servicos;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;

import funcionalidade.mobile.cartao.servicos.AvisoViagemFunc;
import funcionalidade.mobile.cartao.fatura.ServicosCartaoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Jornada(Jornadas.CARTOES)
public class QA03405 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private ServicosCartaoFunc servicosCartaoFunc = new ServicosCartaoFunc();
    private AvisoViagemFunc avisoViagemFunc = new AvisoViagemFunc();

    @Test(description = "REG.CAR.04.01.01 - Validar Ativação aviso viagem – Menu Crédito")
    @Description("Pré condição: n/a" +
            "Objetivo: n/a")
    @Severity(SeverityLevel.NORMAL)

    public void QA03405() throws Exception{

        login.efetuarLoginUsuarioExistente(recuperarMassa("cpf"), recuperarMassa("senha"));

        menu.selecionarCartao();

        servicosCartaoFunc.servicosCartao();

        servicosCartaoFunc.criarAvisoViagem(recuperarMassa("texto"));
    }

    @AfterMethod
    public void excluirAvisoViagem(ITestResult result) throws Exception {
        if(result.isSuccess()) {
            avisoViagemFunc.excluirAvisoViagem();
        }
    }
}

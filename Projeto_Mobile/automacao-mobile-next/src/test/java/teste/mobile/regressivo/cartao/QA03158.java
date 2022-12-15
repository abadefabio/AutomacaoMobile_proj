package teste.mobile.regressivo.cartao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.cartao.fatura.ConfiguracoesCartaoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.CARTOES)
public class QA03158 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ConfiguracoesCartaoFunc configuracoesCartaoFunc = new ConfiguracoesCartaoFunc();

    @Test(description = "PBI.34742.73539.001 -Validar exclus�o da op��o Solicitar 2� via do menu d�bito")
    @Description("1. No menu cart�o de d�bito, ao acessar a op��o �Configura��es do cart�o\", remover a op��o �Solicitar 2� via�")

    @Severity(SeverityLevel.NORMAL)
    public void QA03158()throws Exception{

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarCartao();

        configuracoesCartaoFunc.acessarConfiguracoesCartao();

        configuracoesCartaoFunc.validarNaoTerOpcaoSolicitarSegundaVia();
    }
}

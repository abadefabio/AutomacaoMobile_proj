package teste.mobile.regressivo.cartao.cancelar;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.cartao.cancelamento.CancelarCartaoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.CARTOES)
public class QA03157 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    CancelarCartaoFunc cancelarCartaoFunc = new CancelarCartaoFunc();

    @Test(description = "PBI.34742.73538.001 -Validar mudança de endereço no momento do cancelamento do cartão")
    @Description("1. Mudar endereço no momento do cancelamento do cartão")

    @Severity(SeverityLevel.NORMAL)
    public void QA03157()throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarCartao();

        cancelarCartaoFunc.mudarEnderecoCancelamentoCartaoCredito();
    }
}

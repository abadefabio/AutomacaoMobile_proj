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
public class QA03156 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    CancelarCartaoFunc cancelarCartaoFunc = new CancelarCartaoFunc();

    @Test(description = "PBI.34742.73537.001 -Validar cancelamento do cartão de crédito pelo motivo Perda ou roubo")
    @Description("1.Cancelar cartão de crédito pelo motivo “Perda ou roubo”.")

    @Severity(SeverityLevel.NORMAL)
    public void QA03156()throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarCartao();

        cancelarCartaoFunc.cancelarCartaoCredito();
    }
}

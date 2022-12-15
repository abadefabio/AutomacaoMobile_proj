package teste.mobile.regressivo.credito;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.credito.CreditoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.CREDITO)
public class QA03394 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    CreditoFunc credito = new CreditoFunc();

    @Test(description = "REG.LIM.07.08.01 - Validar comprovante, com teimosinha e grana de emergencia" )
    @Description("Cliente deverá estar logado no next na tela do menu Credito\n" +
            "Possuir CHES;\n" +
            "Possuir Crédito Parcelado.")

    @Severity(SeverityLevel.NORMAL)
    public void QA03394() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarEmprestimos();

        credito.creditoComTeimosinha(recuperarMassa("valor"),recuperarMassa("valorMensal"),recuperarMassa("texto"));

    }
}

package teste.mobile.regressivo.mimos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.mimos.MimosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.MIMOS)
public class QA00241 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    MimosFunc mimos = new MimosFunc();

    @Test(description = "REG.MIMO.01.11 - Validação de tutorial já visualizado não é apresentado para o cliente")
    @Description("Validação de tutorial já visualizado;\n " +
            "Validar ausencia do tutorial para o cliente")
    @Severity(SeverityLevel.NORMAL)

    public void QA00241() throws Exception {

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarMimos();

        mimos.validarAusenciaDoTutorialNoSegundoAcessoAoMenuMimos();
    }
}

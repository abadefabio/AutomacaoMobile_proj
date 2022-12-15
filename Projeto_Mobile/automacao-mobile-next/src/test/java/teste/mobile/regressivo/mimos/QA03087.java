
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
public class QA03087 extends TesteBase {
    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    MimosFunc mimos = new MimosFunc();

    @Test(description = "REG.MIM.08.17 Validar Scroll travado ap�s acessar Categorias")
    @Description("Validar trava na scrollagem atrav�s do acesso ao Categorias.")
    @Severity(SeverityLevel.NORMAL)
    public void QA03087() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarMimos();

        mimos.validaLimiteScrollAbaixo();

        mimos.validaLimiteScrollAcima();

    }
}


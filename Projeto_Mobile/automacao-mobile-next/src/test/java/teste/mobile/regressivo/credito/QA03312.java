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

@Jornada(Jornadas.LIMITES)
public class QA03312 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    CreditoFunc credito = new CreditoFunc();


    @Test(description = "REG.LIM.07.07.17 - Validar alteração de op-tins para NÃO usar teimosinha, quando teimosinha vier selecionada")
    @Description("Validar alteração de op-tins para NÃO usar teimosinha, quando teimosinha vier selecionada")

    @Severity(SeverityLevel.NORMAL)
    public void QA03312() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarEmprestimos();

        credito.contratarEmprestimoPessoalTemosinha(recuperarMassa("nome"),recuperarMassa("valor"),recuperarMassa("texto"));

    }
}

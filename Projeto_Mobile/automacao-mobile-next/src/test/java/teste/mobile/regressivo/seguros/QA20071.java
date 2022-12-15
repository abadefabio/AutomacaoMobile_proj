package teste.mobile.regressivo.seguros;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.seguros.ProtecaoFunc;
import funcionalidade.mobile.seguros.SegurosHomeFunc;
import funcionalidade.mobile.seguros.SegurosResidencialAdesaoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.SEGUROS)
public class QA20071 extends TesteBase {
    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    SegurosHomeFunc segurosHome = new SegurosHomeFunc();
    SegurosResidencialAdesaoFunc segurosResidencialAdesaoFunc = new SegurosResidencialAdesaoFunc();

    ProtecaoFunc protecao = new ProtecaoFunc();

    @Test(description = "PBI.120116.US.121487.010 - Validar recontrata��o apartir do card com status CANCELADO - RESIDENCIAL")
    @Description("Eu enquanto cliente\n" +
            "Quero acessar a Jornada de Seguros no App do next\n" +
            "Para validar recontrata��o � partir do card com status CANCELADO \"<\"")
    @Severity(SeverityLevel.NORMAL)
    public void QA20071() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        menu.selecionarSeguros();
        segurosResidencialAdesaoFunc.validarRecontratacao();
    }
}

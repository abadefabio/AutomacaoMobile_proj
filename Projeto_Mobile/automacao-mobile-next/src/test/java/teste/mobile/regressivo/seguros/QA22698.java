package teste.mobile.regressivo.seguros;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.seguros.SegurosDebitoAdesaoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.SEGUROS)
public class QA22698 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    SegurosDebitoAdesaoFunc segurosDebitoAdesao = new SegurosDebitoAdesaoFunc();


    @Test(description = "PBI.120115.US.121485.003 - Validar TELEFONES ?TEIS - D?BITO")
    @Description("Eu enquanto cliente\n" +
            "Quero acessar a Jornada de Seguros no App do next\n" +
            "E validar a tela de telefones uteis\n" +
            "E tocar no ?cone \"<\"")
    @Severity(SeverityLevel.NORMAL)
    public void QA22698() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        menu.selecionarSeguros();
        segurosDebitoAdesao.validarTelefonesUteisDebito();

    }
}

package teste.mobile.regressivo.seguros;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.seguros.ProtecaoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


@Jornada(Jornadas.SEGUROS)
public class QA00202 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ProtecaoFunc protecao = new ProtecaoFunc();

    @Test(description = "REG.PRO.03.03 - Contratar seguro do cartão de débito")
    @Description("Eu enquanto cliente\n" +
            "Quero contratar o Seguro Cartão de Débito\n" +
            "Para estar assegurado caso ocorra uma emergência.")

    @Severity(SeverityLevel.NORMAL)
    public void QA00202() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarSeguros();

        protecao.selecionarCardProtecaoCartaoDebito();

        protecao.selecionarTermoCondicoesCartaoDebito();

        protecao.btnContratarProtecaoCartaoDebito();

        protecao.validarProtecaoCartaoDebito();

        protecao.clicarBotaoConcluirContratacaoProtecaoCartaoDebito();

    }
}

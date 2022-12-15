package teste.mobile.regressivo.ajuda;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import funcionalidade.mobile.ajuda.AtalhosFunc;
import funcionalidade.mobile.ajuda.CotacaoDoDolarFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.login.LoginUsuarioLogadoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


@Jornada(Jornadas.AJUDA_E_AREA_NAO_LOGADA)
public class QA09279 extends TesteBase {

    LoginFunc loginFunc = new LoginFunc();
    LoginUsuarioLogadoFunc loginUsuarioLogadoFunc = new LoginUsuarioLogadoFunc();
    AtalhosFunc atalhosFunc = new AtalhosFunc();
    CotacaoDoDolarFunc cotacaoDoDolarFunc = new CotacaoDoDolarFunc();


    @Test(description = "REG.AJU.01.03 - Validar cotação do dólar por meio da tela de login recorrente")
    @Description("REG.AJU.01.03 - Validar cotação do dólar por meio da tela de login recorrente")
    @Severity(SeverityLevel.NORMAL)

    public void QA09279() throws Exception {

        loginFunc.efetuarLoginUsuarioExistenteOuPrimeiroAcesso
                (recuperarMassa("cpf"),
                 recuperarMassa("senha"));

        loginFunc.logout();

        loginUsuarioLogadoFunc.tocarBotaoAtalhos();

        atalhosFunc.tocarBotaoCotacaoDoDolar();

        cotacaoDoDolarFunc.pesquisarCotacaoParaUmaData
                (recuperarMassa("dataInicio"),
                recuperarMassa("dataFinal"));
    }
}

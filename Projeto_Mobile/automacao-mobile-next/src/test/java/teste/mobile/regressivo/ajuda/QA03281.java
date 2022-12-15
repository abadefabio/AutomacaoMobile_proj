package teste.mobile.regressivo.ajuda;


import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import funcionalidade.mobile.login.LoginFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.AJUDA_E_AREA_NAO_LOGADA)
public class QA03281 extends TesteBase {
    private LoginFunc login = new LoginFunc();
    @Test(description = "REG.AJU.01.01 - Validar senha incorreta �rea n�o logada.")
    @Description("O APP exibe a tela com o v�deo \"Somos um banco digital com\n" +
            "tudo\".\n" +
            "Validar progresso da barra, conforme � reproduzido.\n" +
            "\n" +
            "bot�o <J� TENHO CONTA>\n" +
            "bot�o <CRIAR CONTA>")
    @Severity(SeverityLevel.NORMAL)

    public void QA03281() throws Exception {
        login.loginSenhaInvalida(recuperarMassa("cpf"),recuperarMassa("senha"));
    }

}

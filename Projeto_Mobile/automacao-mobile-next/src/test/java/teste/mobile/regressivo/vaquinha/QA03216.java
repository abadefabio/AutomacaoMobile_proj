package teste.mobile.regressivo.vaquinha;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.vaquinha.VaquinhaFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

;import static br.com.next.automacao.core.tools.Utilitarios.calcularDataRelativaHoje;

@Jornada(Jornadas.VAQUINHA)
public class QA03216 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    VaquinhaFunc vaquinha = new VaquinhaFunc();

    @Test(description = "REG.VAQ.17.02 - Validar cancelamento da vaquinha na tela Sua Vaquinha está pronta")
    @Description("Objetivos: \n" +
            "Validar cancelamento da vaquinha na tela Sua Vaquinha está pronta" +
            "Pré-Requisitos:\n" +
            "1. Possuir pelo menos uma vaquinha cadastrada")

    @Severity(SeverityLevel.NORMAL)
    public void QA03216() throws Exception {
        JSONObject dadosVaquinha = recuperarJSSONMassa("vaquinha");

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarVaquinha();

        vaquinha.cancelarVaquinha(dadosVaquinha, calcularDataRelativaHoje(0));

    }

}

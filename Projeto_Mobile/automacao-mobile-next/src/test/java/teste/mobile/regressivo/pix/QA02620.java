package teste.mobile.regressivo.pix;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pix.AjudaPixFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.PIX)
public class QA02620 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    AjudaPixFunc ajudaPix = new AjudaPixFunc();


    @Test(description = "REG.PIX.21.14.02 - Validar apresentação das perguntas e respostas")
    @Description("Objetivos: \n" +
            "Validar perguntas e respostas, PIX.\n" +
            "Pré-Requisitos:\n" +
            "1. Ter acesso ao Next")

    @Severity(SeverityLevel.NORMAL)
    public void QA02620() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarPix();

        ajudaPix.validarApresentacaoPerguntasRespostas();

    }

}

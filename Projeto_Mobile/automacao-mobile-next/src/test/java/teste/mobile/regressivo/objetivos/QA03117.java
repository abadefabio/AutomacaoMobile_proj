package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.objetivos.ObjetivosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.OBJETIVOS)
public class QA03117 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menuFunc = new MenuFunc();
    ObjetivosFunc objetivosFunc = new ObjetivosFunc();

    @Test(description = "REG.OBJ.09.01.05 - Validar tela de tutorial-  VER MEUS OBJETIVOS")
    @Description("Pré-requisito na massa de teste\n" +
            "Já deve possuir objetivo criado")

    @Severity(SeverityLevel.NORMAL)
    public void QA03117() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menuFunc.selecionarObjetivos();

        objetivosFunc.validarTutorialObjetivos();

        objetivosFunc.tocarBotaoVerMeusObjetivos();

        objetivosFunc.validarObjetivosCriados();
    }
}

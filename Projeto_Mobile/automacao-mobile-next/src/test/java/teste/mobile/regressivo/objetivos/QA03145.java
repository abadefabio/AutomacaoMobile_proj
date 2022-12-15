package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.objetivos.DetalhesFunc;
import funcionalidade.mobile.objetivos.ObjetivosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.OBJETIVOS)
public class QA03145 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    DetalhesFunc detalhes = new DetalhesFunc();
    ObjetivosFunc objetivo = new ObjetivosFunc();

    @Test(description = "REG.OBJ.09.05.02 - Validar que edi��o para valor menor que o minimo permitido na APLICA��O AGENDADA")
    @Description("Descri��o:\n" +
            "Validar que edi��o para valor menor que o minimo permitido\n" +
            "Pr�-Requisitos:\n" +
            "CPF e senha V�lidos")

    @Severity(SeverityLevel.NORMAL)

    public void QA03145() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarObjetivos();

        objetivo.acessarDetalhesCardMeusObjetivos();

        detalhes.editarValorAplicacao();

    }
}

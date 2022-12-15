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

    @Test(description = "REG.OBJ.09.05.02 - Validar que edição para valor menor que o minimo permitido na APLICAÇÃO AGENDADA")
    @Description("Descrição:\n" +
            "Validar que edição para valor menor que o minimo permitido\n" +
            "Pré-Requisitos:\n" +
            "CPF e senha Válidos")

    @Severity(SeverityLevel.NORMAL)

    public void QA03145() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarObjetivos();

        objetivo.acessarDetalhesCardMeusObjetivos();

        detalhes.editarValorAplicacao();

    }
}

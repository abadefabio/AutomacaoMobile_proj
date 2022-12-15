package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.objetivos.DetalhesFunc;
import funcionalidade.mobile.objetivos.NovoObjetivoFunc;
import funcionalidade.mobile.objetivos.ObjetivosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.OBJETIVOS)
public class QA03144 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ObjetivosFunc objetivo = new ObjetivosFunc();
    DetalhesFunc detalhes = new DetalhesFunc();

    @Test(description = "REG.OBJ.09.05.01 - Validar edição do dia e valor de uma aplicação agendada")
    @Description("Descrição: Validar edição do dia e valor de uma aplicação agendadaPré-Requisitos:\n" +
            "CPF e senha Válidos")

    @Severity(SeverityLevel.NORMAL)
    public void QA03144() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarObjetivos();

        objetivo.acessarDetalhesCardMeusObjetivos();

        detalhes.editarValorEDataDaAplicacao();

    }

}

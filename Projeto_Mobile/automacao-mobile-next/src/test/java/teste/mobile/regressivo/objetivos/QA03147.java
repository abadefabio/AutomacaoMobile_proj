package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.objetivos.aporte.MensagemConfirmacaoExclusaoAgedamentoAporte;
import constantes.objetivos.aporte.TituloTelaAplicacaoCancelada;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.objetivos.ObjetivosFunc;
import funcionalidade.mobile.objetivos.aporte.EditarAporteFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.OBJETIVOS)
public class QA03147 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ObjetivosFunc objetivosFunc = new ObjetivosFunc();
    EditarAporteFunc editarAporteFunc = new EditarAporteFunc();

    @Test(description = "REG.OBJ.09.06.01 - Validar exclusão de aplicação agendada")
    @Description("Descrição:\n" +
            "Validar exclusão de aplicação agendada\n" +
            "Pré-Requisitos:\n" +
            "CPF e senha Válidos")

    @Severity(SeverityLevel.NORMAL)
    public void QA03147()throws Exception{

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarObjetivos();

        objetivosFunc.editarAgendamentoAporteObjetivo(recuperarMassa("nomeObjetivo"));

        editarAporteFunc.excluirAgendamentoAporteObjetivo(MensagemConfirmacaoExclusaoAgedamentoAporte.MSG_CONFIRMACAO_EXCLUSAO, recuperarMassa("valorAporte"), TituloTelaAplicacaoCancelada.TITULO_TELA_APLICACAO_CANCELADA.toString());
    }
}

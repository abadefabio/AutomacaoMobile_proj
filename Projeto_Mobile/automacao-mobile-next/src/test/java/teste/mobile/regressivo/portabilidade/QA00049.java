package teste.mobile.regressivo.portabilidade;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.portabilidade.PortabilidadeDados;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.portabilidade.TrazerMeuSalarioFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

;

@Jornada(Jornadas.TRAZER_MEU_SALARIO)
public class QA00049 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    TrazerMeuSalarioFunc trazerMeuSalario = new TrazerMeuSalarioFunc();

    @Test(description = "REG.TMS.01.09 - Validar mensagem de exceção do CSAL quando a portabilidade estiver com contestação de portabilidade em andamento")
    @Description("Objetivo: Garantir que portabilidade com contestação em andamento não é possível efetuar uma nova contestação;\n" +
            "\n" +
            "Dados do teste:\n" +
            "\n" +
            "Pré requisitos:\n" +
            " -Possuir portabilidade com status [concluída com solicitação de contestação no status diferente 7] ;\n" +
            " - Possuir usuário e senha next;\n" +
            "\n" +
            "Dependência: N/A\n" +
            "\n" +
            "Evidencias necessárias: Todo o fluxo até o resultado esperado.")

    @Severity(SeverityLevel.NORMAL)
    public void QA00049() throws Exception {

        //Utilizar este método de recuperar massa de primeiro acesso quando a implementação do mesmo for finalizada!
        //String cpf = recuperarMassa(SQL.CPF_ONBOARDING_STATUS_ID_4);

        String cpf = recuperarMassa(JSON.CPF);

        login.efetuarLoginUsuarioExistente(cpf, recuperarMassa(JSON.SENHA));

        menu.selecionarTrazerSalario();

        trazerMeuSalario.realizarContestacao(recuperarMassa("cnpj"));

        trazerMeuSalario.validarEVisualizarComprovanteBaotaoVisualizaEVoltar(PortabilidadeDados.TEXTO_VALIDAR_CONTESTACAO_PORTABILIDADE);

        trazerMeuSalario.botaoVoltarMenuPrincipal();

        menu.selecionarTrazerSalario();

        trazerMeuSalario.tocarRegistroPortabilidade(recuperarMassa("cnpj"));

        trazerMeuSalario.botaoVerDetalheContestar();

        trazerMeuSalario.verificarComprovanteTocarBotaoFecharComprovante();
    }
}

package teste.mobile.regressivo.portabilidade;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.portabilidade.TrazerMeuSalarioFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRAZER_MEU_SALARIO)
public class QA00047 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    TrazerMeuSalarioFunc trazerMeuSalario = new TrazerMeuSalarioFunc();

    @Test(description = "REG.TMS.01.07 - Validar mensagem de exceção do CSAL quando a portabilidade estiver no Status 61 (Pendente(em processamento))")
    @Description("Objetivo: Garantir que não é possível efetuar o cancelamento de portabilidade em andamento (Status 61).\n" +
            "\n" +
            "Dados do teste:\n" +
            "\n" +
            "Pré requisitos:\n" +
            "Possuir usuário e senha next;\n" +
            "Possuir portabilidade de salário (PENDENTE -61);\n" +
            "\n" +
            "Dependência: N/A\n" +
            "\n" +
            "Evidencias necessárias: Todo o fluxo até o resultado esperado.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00047() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTrazerSalario();

        trazerMeuSalario.tocarVerDetalhesPortabilidade(recuperarMassa("cnpjPortabilidadePendente"));

        trazerMeuSalario.tocarBotaoCancelar(recuperarMassa("cnpjPortabilidadePendente"));

        trazerMeuSalario.validarMensagemPortabilidadeEmAnalise();
    }
}

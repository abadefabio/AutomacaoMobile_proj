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
public class QA00048 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    TrazerMeuSalarioFunc trazerMeuSalario = new TrazerMeuSalarioFunc();

    @Test(description = "REG.TMS.01.08 - Validar compartilhamento da solicitação de contestação de portabilidade concluída com status Aprovada.")
    @Description("Objetivo: Garantir que foi validada a solicitação de contestação de portabilidade e concluída com status Aprovada.\n" +
            "\n" +
            "Dados do teste:\n" +
            "\n" +
            "Pré requisitos:\n" +
            "-Possuir portabilidade com status [concluída com solicitação de contestação no status diferente 7] ;\n" +
            "Possuir usuário e senha next;\n" +
            "\n" +
            "Dependência: N/A\n" +
            "\n" +
            "Evidencias necessárias: Todo o fluxo até o resultado esperado.")

    @Severity(SeverityLevel.NORMAL)

    //Para a execução deste cenario é necessario uma massa especifica, pois trata se da particularidade de um cpf que ja possua portabilidade concluida.
    //
    //Pois após execução a massa queima.

    public void QA00048() throws Exception {

        login.efetuarLoginUsuarioExistente( recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTrazerSalario();

        trazerMeuSalario.realizarContestacao(recuperarMassa("cnpjFormatado"));

        trazerMeuSalario.validarEVisualizarComprovanteBaotaoVisualizaEVoltar(PortabilidadeDados.TEXTO_VALIDAR_CONTESTACAO_PORTABILIDADE);

    }
}

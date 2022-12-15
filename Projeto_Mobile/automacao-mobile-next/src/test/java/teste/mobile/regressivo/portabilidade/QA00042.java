package teste.mobile.regressivo.portabilidade;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
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

@Jornada(Jornadas.TRAZER_MEU_SALARIO)
public class QA00042 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    TrazerMeuSalarioFunc trazerMeuSalario = new TrazerMeuSalarioFunc();

    @Test(description = "REG.TMS.01.03 - Validar Pedido de portabilidade (CPF) para Bradesco com portabilidade em andamento e conclu�da.")
    @Description("Objetivo:\n" +
            "\n" +
            "Garantir a efetiva��o de Solicita��o de portabilidade para outros bancos utilizando CNPJ;\n" +
            "Garantir consist�ncia dos campos CPF DO EMPREGADOR, NOME DO EMPREGADOR e BANCO DA CONTA SAL�RIO;\n" +
            "Garantir que o termo e condi��o apresentado estar com todas as informa��es corretas;\n" +
            "Garantir que a tela informa��es possui o conte�do definido\n" +
            "Dados do teste:\n" +
            "\n" +
            "Pr� requisitos:\n" +
            "\n" +
            "Possuir usu�rio e senha next;\n" +
            "Ter CPF valido;\n" +
            "Ter uma portabilidade j� cadastrada cujo o status seja em andamento e conclu�da;")

    @Severity(SeverityLevel.NORMAL)
    public void QA00042() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTrazerSalario();

        trazerMeuSalario.validarTelaInformacao();

        trazerMeuSalario.tocarBotaoTrazerSalario();

        trazerMeuSalario.preencherCPFEmpregador(recuperarMassa("cpfEmpregador"));

        trazerMeuSalario.tocarBotaoVoltar();

        trazerMeuSalario.tocarBotaoAvancar();

        trazerMeuSalario.selecionarBancoContaSalario(PortabilidadeDados.BRADESCO);

        trazerMeuSalario.tocarBotaoAvancar();

        trazerMeuSalario.tocarCheckboxConfirmoSolicitacao();

        trazerMeuSalario.tocarBotaoContinuar();

        trazerMeuSalario.tocarBotaoFecharComprovante(PortabilidadeDados.BRADESCO);
    }
}

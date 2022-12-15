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

    @Test(description = "REG.TMS.01.03 - Validar Pedido de portabilidade (CPF) para Bradesco com portabilidade em andamento e concluída.")
    @Description("Objetivo:\n" +
            "\n" +
            "Garantir a efetivação de Solicitação de portabilidade para outros bancos utilizando CNPJ;\n" +
            "Garantir consistência dos campos CPF DO EMPREGADOR, NOME DO EMPREGADOR e BANCO DA CONTA SALÁRIO;\n" +
            "Garantir que o termo e condição apresentado estar com todas as informações corretas;\n" +
            "Garantir que a tela informações possui o conteúdo definido\n" +
            "Dados do teste:\n" +
            "\n" +
            "Pré requisitos:\n" +
            "\n" +
            "Possuir usuário e senha next;\n" +
            "Ter CPF valido;\n" +
            "Ter uma portabilidade já cadastrada cujo o status seja em andamento e concluída;")

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

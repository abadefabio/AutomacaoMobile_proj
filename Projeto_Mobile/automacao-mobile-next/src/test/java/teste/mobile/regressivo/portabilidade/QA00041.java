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

@Jornada(Jornadas.TRAZER_MEU_SALARIO)
public class QA00041 extends TesteBase {

    //    @BeforeMethod
//    public void recadastrarContato() throws Exception{
//        String cpf = recuperarMassa(JSON.CPF);
//        massa.alterarStatusPortabilidade(cpf, StatusPortabilidade.CANCELADA_PARTICIPANTE_DESTINO);
//    }

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    TrazerMeuSalarioFunc trazerMeuSalario = new TrazerMeuSalarioFunc();


    @Test(description = "REG.TMS.01.02 - Validar Pedido de portabilidade (CPF) para outros bancos com portabilidade em andamento")
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
            "Ter uma portabilidade já cadastrada cujo o status seja em andamento;")
    @Severity(SeverityLevel.NORMAL)
    public void QA00041() throws Exception {
        String cpf = recuperarMassa(JSON.CPF);

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(cpf, recuperarMassa(JSON.SENHA));

        menu.selecionarTrazerSalario();

        trazerMeuSalario.iniciarPortabilidadeValidandoInformacoes();

        trazerMeuSalario.tocarBotaoTrazerSalario();

        trazerMeuSalario.pedidoPortabilidadeCpf(PortabilidadeDados.FAVORECIDOCPFALEATORIO);

        trazerMeuSalario.tocarBotaoVoltar();

        trazerMeuSalario.pedidoPortabilidadeCpf(PortabilidadeDados.FAVORECIDOCPFALEATORIO);

        trazerMeuSalario.preecherBancoFavorecidoConfirmandoSolicitacao(PortabilidadeDados.FAVORECIDOINSTITUICAO);

        trazerMeuSalario.visualizarComprovanteBaotaoVisualizaEVoltar(PortabilidadeDados.FAVORECIDOINSTITUICAO);

    }
}

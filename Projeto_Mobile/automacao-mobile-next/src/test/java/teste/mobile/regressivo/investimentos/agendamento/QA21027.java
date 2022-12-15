package teste.mobile.regressivo.investimentos.agendamento;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.tools.Utilitarios;
import constantes.investimentos.ConfirmarInformacoesSolicitacao;
import constantes.investimentos.Perfil;
import constantes.investimentos.Produto;
import constantes.investimentos.Segmento;
import constantes.investimentos.Texto;
import constantes.investimentos.TipoSolicitacao;
import constantes.investimentos.Valor;
import funcionalidade.mobile.investimentos.ConfirmarFunc;
import funcionalidade.mobile.investimentos.agendamento.AgendarAplicacaoFunc;
import funcionalidade.mobile.investimentos.meus.investimentos.EmProcessamentoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import static br.com.next.automacao.core.tools.Utilitarios.retornaDataDiaUtil;

@Jornada(Jornadas.INVESTIMENTOS)
public class QA21027 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    AgendarAplicacaoFunc agendarAplicacao = new AgendarAplicacaoFunc();
    ConfirmarFunc confirmar = new ConfirmarFunc();
    EmProcessamentoFunc emProcessamento = new EmProcessamentoFunc();
    ThreadLocal<Integer> solicitacoes = new ThreadLocal<>();

    @Test(description = "[v1] Validar a edição de um agendamento esporádico")
    @Description("COMO Usuário de investimento do NEXT\n"
            + "QUERO poder editar um agendamento esporádico de aplicação em um produto\n"
            + "PARA que eu possa atualizar as informações de um investimento futuro. \n"
            + "\n"
            + "Pré-Condições:\n"
            + "1- Ter o App instalado;\n"
            + "2- Ter conta ativa no Next com aplicação em um produto do segmento CDB ou Fundos;\n"
            + "3- Estar dentro de grade de movimentação do produto;\n"
            + "4- Realizar o agendamento esporádico em um dos produtos com aplicação;")
    @Severity(SeverityLevel.NORMAL)
    public void QA21027() throws Exception {
        String produto = Produto.NEXT_ALOCACAO_ARROJADA;
        String valor = Utilitarios.reformatarValorMonetario(Valor.DE_DOIS_MIL_A_TRES_MIL.toString());
        // TODO Alterar o método retornaDataDiaUtil() para proximoDiaUtil() quando a atividade
        // TODO de ajuste do framework for finalizada
        String data = retornaDataDiaUtil(5);

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarInvestimentos();

        agendarAplicacao.realizarEdicaoAplicacaoAgendada(
                Segmento.FUNDOS,
                produto,
                Utilitarios.reformatarValorMonetario(recuperarMassa("valor")),
                valor,
                data,
                solicitacoes
        );

        confirmar.validarInformacoesAplicacaoOuResgate(
                produto,
                ConfirmarInformacoesSolicitacao.APLICACAO,
                valor,
                data
        );

        confirmar.confirmarAplicacao(
                produto,
                valor,
                data,
                Perfil.SEM_PERFIL_INVESTIDOR,
                false,
                false
        );

        emProcessamento.realizarValidacaoSolicitacoesEmAbertoAposEditarAgendamento(
                produto,
                TipoSolicitacao.APLICACAO,
                valor,
                Texto.AGENDADA_EM,
                recuperarMassa("dataCriacaoAgendamento"),
                solicitacoes
        );
    }
}

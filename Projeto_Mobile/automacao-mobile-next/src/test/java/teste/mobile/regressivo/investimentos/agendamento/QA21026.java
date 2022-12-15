package teste.mobile.regressivo.investimentos.agendamento;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.tools.Utilitarios;
import constantes.investimentos.ConfirmarInformacoesSolicitacao;
import constantes.investimentos.Data;
import constantes.investimentos.Perfil;
import constantes.investimentos.Produto;
import constantes.investimentos.Segmento;
import constantes.investimentos.Texto;
import constantes.investimentos.TipoSolicitacao;
import constantes.investimentos.Valor;
import framework.MobileUtils;
import funcionalidade.mobile.investimentos.ConfirmarFunc;
import funcionalidade.mobile.investimentos.agendamento.AgendarAplicacaoFunc;
import funcionalidade.mobile.investimentos.meus.investimentos.EmProcessamentoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.INVESTIMENTOS)
public class QA21026 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    AgendarAplicacaoFunc agendarAplicacao = new AgendarAplicacaoFunc();
    ConfirmarFunc confirmar = new ConfirmarFunc();
    EmProcessamentoFunc emProcessamento = new EmProcessamentoFunc();
    ThreadLocal<Integer> solicitacoes = new ThreadLocal<>();

    @Test(description = "[v1] Cadastrar e validar um agendamento esporádico")
    @Description("Descrição do cenário\n"
            + "COMO Usuário de investimento do NEXT\n"
            + "QUERO poder realizar o agendamento esporádico de aplicação em um produto\n"
            + "PARA que eu possa realizar um investimento futuro. \n"
            + "\n"
            + "Pré-Condições:\n"
            + "1- Ter o App instalado;\n"
            + "2- Ter conta ativa no Next com aplicação em um produto do segmento CDB ou Fundos;\n"
            + "3- Estar dentro de grade de movimentação do produto;")
    @Severity(SeverityLevel.NORMAL)
    public void QA21026() throws Exception {

        String produto = Produto.NEXT_ALOCACAO_ARROJADA;
        String valor = Utilitarios.reformatarValorMonetario(Valor.DE_DOIS_MIL_A_TRES_MIL.toString());
        String data = Data.PROXIMO_DIA_UTIL;

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarInvestimentos();

        agendarAplicacao.realizarAplicacaoAgendadaNoProdutoJaInvestido(
                Segmento.FUNDOS,
                produto,
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

        emProcessamento.realizarValidacaoSolicitacoesEmAberto(
                produto,
                TipoSolicitacao.APLICACAO,
                valor,
                Texto.AGENDADA_EM,
                MobileUtils.retornaDataAtualFormatada("dd/MM/yy"),
                solicitacoes
        );
    }
}

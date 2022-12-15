package teste.mobile.regressivo.investimentos.exclusao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.investimentos.Produto;
import constantes.investimentos.Segmento;
import funcionalidade.mobile.investimentos.exclusao.ExcluirAplicacaoFunc;
import funcionalidade.mobile.investimentos.meus.investimentos.MeusInvestimentosFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.INVESTIMENTOS)
public class QA21028 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ExcluirAplicacaoFunc excluirAplicacao = new ExcluirAplicacaoFunc();
    MeusInvestimentosFunc meusInvestimentos = new MeusInvestimentosFunc();
    private final ThreadLocal<Integer> solicitacoes = new ThreadLocal<>();

    @Test(description = "[v1] Excluir agendamento esporádico em um produto do segmento CDB")
    @Description("Descrição do cenário\n"
            + "COMO Usuário de investimento do NEXT\n"
            + "QUERO poder realizar a exclusão de uma aplicação agendada\n"
            + "PARA que eu possa investir em outro produto ou desistir da aplicação. \n"
            + "\n"
            + "Pré-Condições:\n"
            + "1- Ter o App instalado;\n"
            + "2- Ter conta ativa no Next;\n"
            + "3- Realizar um agendamento esporádico;\n"
            + "4- Estar dentro de grade de movimentação do produto;")
    @Severity(SeverityLevel.NORMAL)
    public void QA21028() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarInvestimentos();

        excluirAplicacao.excluirAplicacaoAgendadaEsporadico(
                Segmento.CDB,
                Produto.NEXT_CDB,
                recuperarMassa("valorAplicado"),
                solicitacoes);

        meusInvestimentos.validarBlocoEmProcessamentoAposExclusaoAplicacao(solicitacoes);
    }
}

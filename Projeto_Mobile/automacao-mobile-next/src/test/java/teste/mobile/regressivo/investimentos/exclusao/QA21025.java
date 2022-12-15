package teste.mobile.regressivo.investimentos.exclusao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.investimentos.Produto;
import constantes.investimentos.Segmento;
import funcionalidade.mobile.investimentos.exclusao.ExcluirAplicacaoFunc;
import funcionalidade.mobile.investimentos.home.HomeInvestimentosFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.INVESTIMENTOS)
public class QA21025 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ExcluirAplicacaoFunc excluirAplicacao = new ExcluirAplicacaoFunc();
    HomeInvestimentosFunc homeInvestimentos = new HomeInvestimentosFunc();
    private final ThreadLocal<String> totalDisponivel =  new ThreadLocal<>();

    @Test(description = "[v1] Excluir aplicação de um produto do segmento Fundos realizada no mesmo dia")
    @Description("Descrição do cenário\n"
            + "COMO Usuário de investimento do NEXT\n"
            + "QUERO poder realizar a exclusão de uma aplicação realizada no mesmo dia\n"
            + "PARA que eu possa investir em outro produto ou desistir da aplicação. \n"
            + "\n"
            + "Pré-Condições:\n"
            + "1- Ter o App instalado;\n"
            + "2- Ter conta ativa no Next com uma massa de primeiro acesso;\n"
            + "3- Ter realizado uma aplicação em qualquer produto do segmento Fundos no dia atual;\n"
            + "4- Estar dentro de grade de movimentação do produto;")
    @Severity(SeverityLevel.NORMAL)
    public void QA21025() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarInvestimentos();

        excluirAplicacao.excluirPrimeiraAplicacaoDoDia(
                Segmento.FUNDOS,
                Produto.NEXT_ALOCACAO_ARROJADA,
                recuperarMassa("valorAplicado"),
                totalDisponivel
        );

        homeInvestimentos.validarAusenciaBotaoMeusInvestimentos();
    }
}

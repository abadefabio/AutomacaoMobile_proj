package teste.mobile.regressivo.investimentos.exclusao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.investimentos.Produto;
import constantes.investimentos.Segmento;
import funcionalidade.mobile.investimentos.exclusao.ExcluirAplicacaoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.INVESTIMENTOS)
public class QA20340  extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ExcluirAplicacaoFunc excluirAplicacao = new ExcluirAplicacaoFunc();

    @Test(description = "[v1] Cancelar o agendamento recorrente de uma aplicação CDB ou Fundos")
    @Description("Descrição do cenário\n"
            + "COMO Usuário de investimento do NEXT\n"
            + "QUERO poder realizar a exclusão de um de uma aplicação\n"
            + "PARA que eu possa investir em outro produto ou desistir da aplicação. \n"
            + "\n"
            + "Pré-Condições:\n"
            + "1- Ter o App instalado;\n"
            + "2- Ter conta ativa no Next com aplicação em um produto do segmento CDB ou Fundos;\n"
            + "3- Criado uma recorrência para mesmo produto do passo anterior;")
    @Severity(SeverityLevel.NORMAL)
    public void QA20340() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarInvestimentos();

        excluirAplicacao.cancelarAplicacaoAgendadaRecorrente(Segmento.CDB, Produto.NEXT_CDB);
    }
}

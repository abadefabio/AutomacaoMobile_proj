package teste.mobile.regressivo.pix;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.recarga.FormaPagamento;
import constantes.saldoextrato.TipoTransacao;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.saldoextrato.SaldoExtratoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.PIX)
public class QA07367 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    SaldoExtratoFunc saldoExtrato = new SaldoExtratoFunc();

    @Test(description = "PB.1070.US.94377.033 - Excluir um agendamento de Chave - Conta Corrente")
    @Description("Descrição: Eu enquanto cliente NEXT quero consultar o agendamento de transferênciaObjetivo:\n" +
            "Excluir um agendamento de Chave - Conta Corrente\n" +
            "Dados do teste (Massa necessária):\n" +
            "Nenhum requisito\n" +
            "Pré requisitos:\n" +
            "Usuário deve estar logado no menu Next\n" +
            "Possuir uma massa com transferência por chave agendada\n" +
            "Referência:\n" +
            "Código Jira: NEXT2-94377 - UserStory: [US.01] Agendamento de transferência -com chave e agência e conta")

    @Severity(SeverityLevel.NORMAL)
    public void QA07367() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarSaldoExtrato();

        saldoExtrato.excluirAgendamento(FormaPagamento.CONTA_CORRENTE, TipoTransacao.PIX, recuperarMassa("valor"));

    }
}

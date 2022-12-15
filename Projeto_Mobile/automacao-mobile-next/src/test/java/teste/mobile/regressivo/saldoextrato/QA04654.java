package teste.mobile.regressivo.saldoextrato;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.saldoextrato.SaldoExtratoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.SALDO_EXTRATO)
public class QA04654 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private SaldoExtratoFunc saldoExtrato = new SaldoExtratoFunc();

    @Test(description = "REG.SE.18.03 - Validar navegação entre Filtros de transação - Conta Corrente")
    @Description("Pré-requisitos:\n" +
            "\n" +
            "Ter uma conta ativa Next.\n" +
            "Possuir movimentação de entrada, saída e agendamento.")

    @Severity(SeverityLevel.NORMAL)
    public void QA04654() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarSaldoExtrato();

        saldoExtrato.navegarEntreOsFiltrosDaTransacao();
    }
}

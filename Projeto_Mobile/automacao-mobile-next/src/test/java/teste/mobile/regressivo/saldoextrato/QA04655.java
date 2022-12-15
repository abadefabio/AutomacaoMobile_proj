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
public class QA04655 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private SaldoExtratoFunc saldoExtrato = new SaldoExtratoFunc();

    @Test(description = "REG.SE.18.04 - Validar navegação entre Filtros de período - Poupança")
    @Description("Pré-requisitos:\n" +
                 "\n" +
                 "Ter uma conta ativa Next.\n" +
                 "Possuir uma transação dos últimos 15 e 30 dias a partir da conta poupança.\n" +
                 "Opcionalmente, pode ser criado uma transação para cada situação: (entrada e saída). Dentro dos períodos (15 e 30 dias).")

    @Severity(SeverityLevel.NORMAL)
    public void QA04655() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarSaldoExtrato();

        saldoExtrato.navegarEntreOsFiltrosDaTransacaoPoupanca();
    }
}

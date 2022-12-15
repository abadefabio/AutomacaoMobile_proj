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

    @Test(description = "REG.SE.18.04 - Validar navega��o entre Filtros de per�odo - Poupan�a")
    @Description("Pr�-requisitos:\n" +
                 "\n" +
                 "Ter uma conta ativa Next.\n" +
                 "Possuir uma transa��o dos �ltimos 15 e 30 dias a partir da conta poupan�a.\n" +
                 "Opcionalmente, pode ser criado uma transa��o para cada situa��o: (entrada e sa�da). Dentro dos per�odos (15 e 30 dias).")

    @Severity(SeverityLevel.NORMAL)
    public void QA04655() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarSaldoExtrato();

        saldoExtrato.navegarEntreOsFiltrosDaTransacaoPoupanca();
    }
}

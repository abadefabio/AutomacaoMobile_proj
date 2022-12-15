package teste.mobile.regressivo.pagamentos.comprovante;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.comprovantes.ConsultaServico;
import constantes.comprovantes.ConsultaTransacao;
import funcionalidade.mobile.comprovantes.ComprovantesExtratosFunc;
import funcionalidade.mobile.comprovantes.ComprovantesFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.PAGAMENTOS_E_COMPROVANTES)
public class QA02888 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ComprovantesExtratosFunc comprovantesExtratos = new ComprovantesExtratosFunc();
    ComprovantesFunc comprovantesFunc = new ComprovantesFunc();

    @Test(description = "REG.PAG.10.02.05 - Validar Compartilhamento da 2ª via de Conta de Consumo - Conta Corrente")
    @Description("Eu enquanto cliente\n" +
            "Quero acessar a jornada pagamento para realzar pagamento de conta consumo\n" +
            "\n" +
            "Ser cliente Next\n" +
            "Ter acesso ao APP Next\n" +
            "Estar logado no APP Next\n" +
            "Relizar pagamento de Conta de Consumo")

    @Severity(SeverityLevel.NORMAL)
    public void QA02888() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarComprovantes();

        comprovantesExtratos.menuComprovantes();

        comprovantesFunc.consultaComprovante(
                ConsultaServico.PAGAMENTOS,
                ConsultaTransacao.CONTA_DE_CONSUMO,
                "01/03/2022",
                "31/03/2022");

        comprovantesFunc.compartilharComprovantePagamentos();

    }
}

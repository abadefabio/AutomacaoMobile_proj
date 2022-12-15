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
public class QA02880 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ComprovantesExtratosFunc comprovantesExtratos = new ComprovantesExtratosFunc();
    ComprovantesFunc comprovantesFunc = new ComprovantesFunc();

    @Test(description = "REG.PAG.10.02.05 - Validar Consulta e compartilhamento da 2ª via do comprovante de pagamento de boleto Bradesco pela conta poupança.")
    @Description("Eu enquanto cliente\n" +
            "Quero acessar a jornada Pagamentos e realizar o pagamento do Boleto\n" +
            "Estar logado no next")

    @Severity(SeverityLevel.NORMAL)
    public void QA02880() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarComprovantes();

        comprovantesExtratos.menuComprovantes();

        comprovantesFunc.consultaComprovante(

                ConsultaServico.PAGAMENTOS,
                ConsultaTransacao.BOLETO_DE_COBRANCA,
                recuperarMassa("dataInicial"),
                recuperarMassa("dataFinal"));

        comprovantesFunc.compartilharComprovantePagamentos();

    }
}

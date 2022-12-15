package teste.mobile.regressivo.transferencia.comprovante;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.comprovantes.ConsultaServico;
import constantes.comprovantes.ConsultaTransacao;
import constantes.comprovantes.DataComprovantes;
import funcionalidade.mobile.comprovantes.ComprovantesExtratosFunc;
import funcionalidade.mobile.comprovantes.ComprovantesFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import static br.com.next.automacao.core.tools.Utilitarios.calcularDataRelativaHoje;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA20197 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private ComprovantesFunc comprovantesFunc = new ComprovantesFunc();
    private ComprovantesExtratosFunc comprovantesExtratosFunc = new ComprovantesExtratosFunc();

        @Test(description = "PBI-129441.001.001 - Validar segunda via de comprovante pagamentos de tributos")
        @Description("Descrição (Objetivo):\n" +
                "\n" +
                "Validar presença do PDF 2 via de pagamento de tributo  \n" +
                ".\n" +
                "Dados do teste (Massa necessária):\n" +
                "Deve ter um tributo pago no período selecionado\n" +
                "\n" +
                "Pré requisitos:\n" +
                "\n" +
                "Ser cliente Next\n" +
                "Ter acesso ao APP Next\n" +
                "Estar logado no APP Next\n" +
                "\n" +
                "Dependências:\n" +
                "\n" +
                "N/A.")

        @Severity(SeverityLevel.NORMAL)
        public void QA20197() throws Exception {

            login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

            menu.validarTelaMenu();

            menu.selecionarComprovantes();

            comprovantesExtratosFunc.menuComprovantes();

            comprovantesFunc.consultaComprovante(ConsultaServico.PAGAMENTOS,ConsultaTransacao.TRIBUTOS,calcularDataRelativaHoje(-1),DataComprovantes.HOJE.toString());

            comprovantesFunc.compartilharComprovantePagamentos();
        }
}

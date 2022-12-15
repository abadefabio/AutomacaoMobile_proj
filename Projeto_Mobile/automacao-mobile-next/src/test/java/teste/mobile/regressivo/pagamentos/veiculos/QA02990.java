package teste.mobile.regressivo.pagamentos.veiculos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.pagamentos.veiculos.TipoPagamento;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pagamentos.veiculos.DebitoDeVeiculosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.PAGAMENTOS_E_COMPROVANTES)
public class QA02990 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private DebitoDeVeiculosFunc veiculos = new DebitoDeVeiculosFunc();

    private static ThreadLocal<String> valor = new ThreadLocal<>();

    @Test(description = "REG.PAG.10.06.12 - Pagamento de Licenciamento - Exibindo tela de analise")
    @Description("Cliente deverá está logado next na tela do menu principal\n" +
            "\n" +
            "Possuir uma massa para pagamento de Licenciamento Pagos Após da data de corte do sistema de gestão\n" +
            "-O fluxo pode ser diferente se o RENAVAM nunca foi utilizado no Next, Exibindo a \"Tela análise\" após o pagamento")
    @Severity(SeverityLevel.NORMAL)

    public void QA02990() throws Exception {

        login.efetuarLoginUsuarioPrimeiroAcesso(recuperarMassa("cpf"), recuperarMassa("senha"));

        veiculos.escolherTipoPagamentoPreenchendoRenavam(recuperarMassa("estado"), recuperarMassa("renavam"), TipoPagamento.LICENCIAMENTO_REPETIDO, valor);

        veiculos.efetuarPagamentoRevavamJaUtilizado(TipoPagamento.LICENCIAMENTO_REPETIDO, recuperarMassa("valor"), recuperarMassa("renavam"), recuperarMassa("tipoConta"));

        veiculos.escolherTipoPagamentoPreenchendoRenavam(recuperarMassa("estado"), recuperarMassa("renavam"), TipoPagamento.LICENCIAMENTO_REPETIDO, valor);

        veiculos.efetuarPagamentoRevavamJaUtilizado(TipoPagamento.LICENCIAMENTO_REPETIDO, recuperarMassa("valor"), recuperarMassa("renavam"), recuperarMassa("tipoConta"));
    }
}

package teste.mobile.regressivo.pagamentos.veiculos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.pagamentos.FluxoPagamento;
import constantes.pagamentos.veiculos.TipoPagamento;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pagamentos.PagamentosFunc;
import funcionalidade.mobile.pagamentos.veiculos.DebitoDeVeiculosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.PAGAMENTOS_E_COMPROVANTES)
public class QA02988 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private PagamentosFunc pagamentos = new PagamentosFunc();
    private DebitoDeVeiculosFunc veiculos = new DebitoDeVeiculosFunc();

    private static ThreadLocal<String> valor = new ThreadLocal<>();

    @Test(description = "REG.PAG.10.06.10 - Pagamento de IPVA Atual - Exibindo tela de analise")
    @Description("Cliente deverá está logado next na tela do menu principal"+
            "Possuir uma massa para pagamento de IPVA Atual Pagos Após da data de corte do sistema de gestão"+
            "-O fluxo pode ser diferente se o RENAVAM nunca foi utilizado no Next, Exibindo a Tela análise após o pagamento")
    @Severity(SeverityLevel.NORMAL)

    public void QA02988() throws Exception {

        login.efetuarLoginUsuarioPrimeiroAcesso(recuperarMassa("cpf"), recuperarMassa("senha"));

        menu.selecionarPagamentos();

        pagamentos.selecionarFluxoPagamento(FluxoPagamento.DEBITO_VEICULOS);

        veiculos.escolherTipoPagamentoPreenchendoRenavam(recuperarMassa("estado"), recuperarMassa("renavam"), TipoPagamento.IPVA_ATUAL);

        veiculos.efetuarPagamentoRevavamJaUtilizado(TipoPagamento.IPVA_ATUAL, recuperarMassa("valor"), recuperarMassa("renavam"), recuperarMassa("tipoConta"));

        veiculos.escolherTipoPagamentoPreenchendoRenavam(recuperarMassa("estado"), recuperarMassa("renavam"), TipoPagamento.IPVA_ATUAL);

        pagamentos.selecionarFluxoPagamento(FluxoPagamento.DEBITO_VEICULOS);

        veiculos.escolherTipoPagamentoPreenchendoRenavam(recuperarMassa("estado"), recuperarMassa("renavam2"), TipoPagamento.DPVAT_ATUAL);

        veiculos.efetuarPagamentoRevavamJaUtilizado(TipoPagamento.TRANSACAO_REPETIDA, recuperarMassa("valor"), recuperarMassa("renavam2"), recuperarMassa("tipoConta"));

    }
}

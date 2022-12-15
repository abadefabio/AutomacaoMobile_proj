package teste.mobile.regressivo.pagamentos.codigo.barras.boleto;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.pagamentos.FluxoPagamento;
import constantes.pagamentos.TipoConta;
import constantes.pagamentos.codigo.barras.TipoPagamento;
import funcionalidade.mobile.comprovantes.ComprovantesFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pagamentos.PagamentosFunc;
import funcionalidade.mobile.pagamentos.codigo.barras.CodigoDeBarrasFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.PAGAMENTOS_E_COMPROVANTES)
public class QA02879 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private PagamentosFunc pagamentosFunc = new PagamentosFunc();
    private CodigoDeBarrasFunc codigoDeBarrasFunc = new CodigoDeBarrasFunc();
    private ComprovantesFunc comprovantesFunc = new ComprovantesFunc();

    private static ThreadLocal<String> valor = new ThreadLocal<>();

    @Test(description = "REG.PAG.10.01.06 - Realizar pagamento de boleto - Conta Poupança - Outro banco.")
    @Description("Eu enquanto cliente\n" +
            "Quero acessar a jornada Pagamentos e realizar o pagamento do Boleto\n" +
            "Estar logado no next")

    @Severity(SeverityLevel.NORMAL)

    public void QA02879() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa("cpf"), recuperarMassa("senha"));

        menu.selecionarPagamentos();

        pagamentosFunc.selecionarFluxoPagamento(FluxoPagamento.CODIGO_BARRAS);

        codigoDeBarrasFunc.pagarComCodigoDeBarras(TipoPagamento.BOLETO, TipoConta.CONTA_POUPANCA, recuperarMassa("codigoDeBarras"), recuperarMassa("dataVencimento"), recuperarMassa("dataPagamento"), recuperarMassa("banco"), recuperarMassa("valor"), valor, recuperarMassa("descricao"));

    }
}

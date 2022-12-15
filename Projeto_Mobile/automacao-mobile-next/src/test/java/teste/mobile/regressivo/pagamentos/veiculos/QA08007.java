package teste.mobile.regressivo.pagamentos.veiculos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.pagamentos.FluxoPagamento;
import constantes.pagamentos.TipoConta;
import constantes.pagamentos.veiculos.TipoPagamento;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pagamentos.PagamentosFunc;
import funcionalidade.mobile.pagamentos.comprovante.ComprovanteFunc;
import funcionalidade.mobile.pagamentos.veiculos.DebitoDeVeiculosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

@Jornada(Jornadas.PAGAMENTOS_E_COMPROVANTES)
public class QA08007 extends TesteBase {

    private static ThreadLocal<String> valor = new ThreadLocal<>();
    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private PagamentosFunc pagamentos = new PagamentosFunc();
    private DebitoDeVeiculosFunc debitoVeiculos = new DebitoDeVeiculosFunc();
    private ComprovanteFunc comprovante = new ComprovanteFunc();

    @Test(description = "REG.PAG.10.06.05 - Pagamento transferência ")
    @Description("Cliente deverá está logado next na tela do menu principal\n" +
            "\n" +
            "Possuir uma massa para pagamento de Licenciamento Pagos Após da data de corte do sistema de gestão\n" +
            "\n" +
            "-O fluxo pode ser diferente se o RENAVAM nunca foi utilizado no Next, Exibindo a \"Tela análise\" após o pagamento")
    @Severity(SeverityLevel.NORMAL)
    public void QA08007() throws Exception{

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarPagamentos();

        pagamentos.selecionarFluxoPagamento(FluxoPagamento.DEBITO_VEICULOS);

        debitoVeiculos.escolherTipoPagamentoPreenchendoRenavam(recuperarJSSONMassa("dadosRenavam"),TipoPagamento.TRANSFERENCIA, valor);
        comprovante.exibirCompartilhamentoComprovante();
    }
}

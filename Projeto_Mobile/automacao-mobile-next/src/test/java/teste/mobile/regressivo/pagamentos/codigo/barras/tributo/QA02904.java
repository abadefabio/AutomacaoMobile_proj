package teste.mobile.regressivo.pagamentos.codigo.barras.tributo;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.pagamentos.FluxoPagamento;
import constantes.pagamentos.TipoConta;
import constantes.pagamentos.codigo.barras.TipoPagamento;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pagamentos.PagamentosFunc;
import funcionalidade.mobile.pagamentos.codigo.barras.CodigoDeBarrasFunc;
import funcionalidade.mobile.pagamentos.comprovante.ComprovanteFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.PAGAMENTOS_E_COMPROVANTES)
public class QA02904 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private PagamentosFunc pagamentosFunc = new PagamentosFunc();
    private CodigoDeBarrasFunc codigoDeBarrasFunc = new CodigoDeBarrasFunc();
    private ComprovanteFunc comprovantesFunc = new ComprovanteFunc();

    private static ThreadLocal<String> valor = new ThreadLocal<>();

    @Test(description = "REG.PAG.10.03.05 - Validar comprovante de pagamento de tributo GARE ICMS GERAL - Após corte")
    @Description("Pré requisitos: - Cliente deverá está logado next na tela do menu principal\n" +
            "\n" +
            "Boleto com a posição 2 do código de barra igual a 5\n" +
            "Boleto com a posição de 16 a 19 igual a 0489.\n" +
            "A data de vencimento deve vim preenchida e não editavel de acordo com a regra abaixo:\n +" +
            "Posições 20 a 27 da barra no formato AAAAMMDD")

    @Severity(SeverityLevel.NORMAL)

    public void QA02904() throws Exception {

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa("cpf"), recuperarMassa("senha"));

        menu.selecionarPagamentos();

        pagamentosFunc.selecionarFluxoPagamento(FluxoPagamento.CODIGO_BARRAS);

        codigoDeBarrasFunc.pagarComCodigoDeBarras(
                TipoPagamento.TRIBUTO,
                TipoConta.CONTA_CORRENTE,
                recuperarMassa("codigoDeBarras"),
                recuperarMassa("dataVencimento"),
                recuperarMassa("dataPagamento"),
                recuperarMassa("banco"),
                recuperarMassa("valor"),
                valor, recuperarMassa("descricao"));

        comprovantesFunc.exibirCompartilhamentoComprovante();
    }
}

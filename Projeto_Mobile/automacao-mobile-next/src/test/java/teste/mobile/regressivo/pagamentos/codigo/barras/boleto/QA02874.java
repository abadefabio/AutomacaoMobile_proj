package teste.mobile.regressivo.pagamentos.codigo.barras.boleto;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.pagamentos.Data;
import constantes.pagamentos.FluxoPagamento;
import constantes.pagamentos.TipoConta;
import constantes.pagamentos.codigo.barras.TipoPagamento;
import constantes.saldoextrato.Aba;
import constantes.saldoextrato.CategoriaTransacao;
import constantes.saldoextrato.TipoTransacao;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pagamentos.PagamentosFunc;
import funcionalidade.mobile.pagamentos.codigo.barras.CodigoDeBarrasFunc;
import funcionalidade.mobile.pagamentos.comprovante.ComprovanteFunc;
import funcionalidade.mobile.saldoextrato.SaldoExtratoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.PAGAMENTOS_E_COMPROVANTES)
public class QA02874 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    PagamentosFunc pagamento = new PagamentosFunc();
    CodigoDeBarrasFunc codigo = new CodigoDeBarrasFunc();
    ComprovanteFunc comprovante = new ComprovanteFunc();
    SaldoExtratoFunc extrato = new SaldoExtratoFunc();

    private static ThreadLocal<String> valor = new ThreadLocal<>();

    @Test(description = "REG.PAG.10.01.01 - Validar  Comprovante e Pagamento - Bradesco - Conta Corrente")
    @Description("Eu enquanto cliente\n" +
            "Quero acessar a jornada Pagamentos e realizar o pagamento do Boleto\n" +
            "Estar logado no next")
    @Severity(SeverityLevel.NORMAL)

    public void QA02874() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        menu.selecionarPagamentos();
        pagamento.selecionarFluxoPagamento(FluxoPagamento.CODIGO_BARRAS);
        codigo.pagarComCodigoDeBarras(
                TipoPagamento.BOLETO,
                TipoConta.CONTA_CORRENTE,
                recuperarMassa("codigoBarras"),
                recuperarMassa(JSON.VENCIMENTO),
                Data.HOJE,
                recuperarMassa(JSON.INSTITUICAO_FAVORECIDO),
                recuperarMassa(JSON.VALOR), valor,
                recuperarMassa(JSON.DESCRICAO));
        comprovante.verComprovante(valor.get(), Data.HOJE_FORMATADO_DD_MMM_YYYY);
        comprovante.voltarDeComprovantePDFAteMenuInicial();
        menu.selecionarSaldoExtrato();
        extrato.validarTransacao(
                Aba.TODAS,
                valor,
                CategoriaTransacao.OUTROS_GASTOS,
                TipoTransacao.CONTA,
                Data.HOJE);
    }
}

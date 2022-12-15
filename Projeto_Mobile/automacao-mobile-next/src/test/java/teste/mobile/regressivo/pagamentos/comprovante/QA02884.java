package teste.mobile.regressivo.pagamentos.comprovante;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.pagamentos.FluxoPagamento;
import constantes.pagamentos.JSONPagamentos;
import constantes.pagamentos.Mensagem;
import constantes.pagamentos.TipoConta;
import constantes.saldoextrato.JSONSaldoExtrato;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pagamentos.PagamentosFunc;
import funcionalidade.mobile.pagamentos.codigo.barras.CodigoDeBarrasFunc;
import funcionalidade.mobile.pagamentos.comprovante.ComprovanteFunc;
import funcionalidade.mobile.pagamentos.contadecomsumo.ContaDeConsumoFunc;
import funcionalidade.mobile.saldoextrato.SaldoExtratoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


@Jornada(Jornadas.PAGAMENTOS_E_COMPROVANTES)
public class QA02884 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    PagamentosFunc pagamentos = new PagamentosFunc();
    CodigoDeBarrasFunc codigoDeBarras = new CodigoDeBarrasFunc();
    ContaDeConsumoFunc contaDeConsumo = new ContaDeConsumoFunc();
    ComprovanteFunc comprovante = new ComprovanteFunc();
    SaldoExtratoFunc saldoExtrato = new SaldoExtratoFunc();

    @Test(description = "REG.PAG.10.02.01 - Validar Comprovante pagamento Segundo digito 4 (Telefonica) - Conta Corrente")
    @Description("Eu enquanto cliente\n" +
            "Quero acessar a jornada pagamento para realzar pagamento de conta consumo\n" +
            "\n" +
            "Ser cliente Next\n" +
            "Ter acesso ao APP Next\n" +
            "Estar logado no APP Next\n" +
            "Relizar pagamento de Conta de Consumo")

    @Severity(SeverityLevel.NORMAL)
    public void QA02884() throws Exception {

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarPagamentos();

        pagamentos.selecionarFluxoPagamento(FluxoPagamento.CODIGO_BARRAS);

        codigoDeBarras.preencherCodigoDeBarra(recuperarMassa(JSONPagamentos.CODIGO_DE_BARRA.getValue()));

        contaDeConsumo.efetuarPagamendoContaDeConsumo(recuperarMassa(JSONPagamentos.DESCRICAO.getValue()), TipoConta.CONTA_CORRENTE, Mensagem.SUCESSO_ANDROID);

        comprovante.visualizarComprovante();
    }
}

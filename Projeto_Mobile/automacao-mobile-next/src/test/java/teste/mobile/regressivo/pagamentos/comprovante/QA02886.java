package teste.mobile.regressivo.pagamentos.comprovante;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.pagamentos.Data;
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

import static br.com.next.automacao.core.constantes.massa.JSON.DESCRICAO;
import static br.com.next.automacao.core.constantes.massa.JSON.INSTITUICAO_FAVORECIDO;
import static br.com.next.automacao.core.constantes.massa.JSON.VALOR;
import static br.com.next.automacao.core.constantes.massa.JSON.VENCIMENTO;

@Jornada(Jornadas.PAGAMENTOS_E_COMPROVANTES)
public class QA02886 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    PagamentosFunc pagamento = new PagamentosFunc();
    CodigoDeBarrasFunc codigo = new CodigoDeBarrasFunc();

    ComprovanteFunc comprovante = new ComprovanteFunc();

    private static ThreadLocal<String> valor = new ThreadLocal<>();
    @Test(description = "REG.PAG.10.02.03 - Validar Compartilhar comprovante de pagamento Segundo digito 3 (Eletropaulo) - Conta Poupança")
    @Description("Eu enquanto cliente" +
            "Quero acessar a jornada pagamento para realzar pagamento de conta consumo" +
            "Ser cliente Next" +
            "Ter acesso ao APP Next" +
            "Estar logado no APP Next" +
            "Relizar pagamento de Conta de Consumo")

    @Severity(SeverityLevel.NORMAL)
    public void QA02886() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        menu.selecionarPagamentos();
        pagamento.selecionarFluxoPagamento(FluxoPagamento.CODIGO_BARRAS);
        codigo.pagarComCodigoDeBarras(
                TipoPagamento.CONTA_CONSUMO,
                TipoConta.CONTA_POUPANCA,
                recuperarMassa("codigoBarras"),
                recuperarMassa(VENCIMENTO),
                Data.DIA_UTIL_FORMATADO_ANO_MES_DIA,
                recuperarMassa(INSTITUICAO_FAVORECIDO),
                recuperarMassa(VALOR), valor,
                recuperarMassa(DESCRICAO));
    }
}

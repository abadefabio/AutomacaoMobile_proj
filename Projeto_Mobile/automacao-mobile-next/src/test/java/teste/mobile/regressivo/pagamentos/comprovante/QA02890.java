package teste.mobile.regressivo.pagamentos.comprovante;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.comprovantes.ConsultaServico;
import constantes.comprovantes.ConsultaTransacao;
import constantes.pagamentos.Data;
import constantes.pagamentos.FluxoPagamento;
import constantes.pagamentos.TipoConta;
import constantes.pagamentos.codigo.barras.TipoPagamento;
import funcionalidade.mobile.comprovantes.ComprovantesExtratosFunc;
import funcionalidade.mobile.comprovantes.ComprovantesFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.pagamentos.PagamentosFunc;
import funcionalidade.mobile.pagamentos.codigo.barras.CodigoDeBarrasFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static br.com.next.automacao.core.constantes.massa.JSON.DESCRICAO;
import static br.com.next.automacao.core.constantes.massa.JSON.INSTITUICAO_FAVORECIDO;
import static br.com.next.automacao.core.constantes.massa.JSON.VALOR;
import static br.com.next.automacao.core.constantes.massa.JSON.VENCIMENTO;

@Jornada(Jornadas.PAGAMENTOS_E_COMPROVANTES)
public class QA02890 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    PagamentosFunc pagamento = new PagamentosFunc();
    CodigoDeBarrasFunc codigo = new CodigoDeBarrasFunc();

    private static ThreadLocal<String> valor = new ThreadLocal<>();

    @Test(description = "REG.PAG.10.02.07 - Validar agendamento e compartilhar comprovante (Telefone) - Conta Corrente")

    @Description("Eu enquanto cliente\n" +
            "Quero acessar a jornada pagamento para realizar agendamento do pagamento de conta consumo\n" +
            "Ser cliente Next\n" +
            "Ter acesso ao APP Next\n" +
            "Estar logado no APP Next\n" +
            "Realizar o agendamento do pagamento de Conta de Consumo")

    @Severity(SeverityLevel.NORMAL)
    public void QA02890() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        menu.selecionarPagamentos();
        pagamento.selecionarFluxoPagamento(FluxoPagamento.CODIGO_BARRAS);
        codigo.agendarComCodigoDeBarras(
                TipoPagamento.CONTA_CONSUMO,
                TipoConta.CONTA_CORRENTE,
                recuperarMassa("codigoBarras"),
                recuperarMassa(VENCIMENTO),
                Data.DIA_UTIL_FORMATADO_ANO_MES_DIA,
                recuperarMassa(INSTITUICAO_FAVORECIDO),
                recuperarMassa(VALOR), valor,
                recuperarMassa(DESCRICAO));

    }
}

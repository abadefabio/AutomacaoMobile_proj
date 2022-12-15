package teste.mobile.regressivo.pagamentos.comprovante;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.pagamentos.FluxoPagamento;
import constantes.pagamentos.TipoConta;
import constantes.pagamentos.codigo.barras.TipoPagamento;
import constantes.pagamentos.comprovante.TextosComprovante;
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
public class QA17848 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    PagamentosFunc pagamentos = new PagamentosFunc();
    CodigoDeBarrasFunc codigoDeBarras = new CodigoDeBarrasFunc();
    ComprovanteFunc comprovante = new ComprovanteFunc();

    private static ThreadLocal<String> valor = new ThreadLocal<>();

    @Test(description = "[Transações Cotidianas] PBI - 110302 Validar dados do pagamento GARE 120")
    @Description("Descrição (Objetivo):\n" +
            "\n" +
            "Validar comprovante de pagamento GARE 120\n" +
            ".\n" +
            "Dados do teste (Massa necessária):\n" +
            "Ter um cod. barras do tributo GARE 120\n" +
            "Pré requisitos:\n" +
            "\n" +
            "Ser cliente Next\n" +
            "Ter acesso ao APP Next\n" +
            "Estar logado no APP Next")

    @Severity(SeverityLevel.NORMAL)
    public void QA17848() throws Exception {

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarPagamentos();

        pagamentos.selecionarFluxoPagamento(FluxoPagamento.CODIGO_BARRAS);

        codigoDeBarras.pagarComCodigoDeBarras(
                TipoPagamento.TRIBUTO,
                TipoConta.CONTA_CORRENTE,
                recuperarMassa("codigoDeBarras"),
                recuperarMassa("valor"),
                valor,
                recuperarMassa("descricao"));

        comprovante.validarDadosComprovante(TextosComprovante.GARE, recuperarMassa("valor"));
    }
}


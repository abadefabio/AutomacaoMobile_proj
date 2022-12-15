package teste.mobile.regressivo.investimentos.resgate;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import constantes.investimentos.ConfirmarInformacoesSolicitacao;
import constantes.investimentos.Produto;
import constantes.investimentos.Segmento;
import constantes.investimentos.Texto;
import constantes.investimentos.TipoSolicitacao;
import framework.MobileUtils;
import funcionalidade.mobile.investimentos.ConfirmarFunc;
import funcionalidade.mobile.investimentos.meus.investimentos.EmProcessamentoFunc;
import funcionalidade.mobile.investimentos.resgate.ResgateFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import static br.com.next.automacao.core.constantes.massa.JSON.CPF;
import static br.com.next.automacao.core.constantes.massa.JSON.SENHA;

@Jornada(Jornadas.INVESTIMENTOS)
public class QA27624 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ResgateFunc resgate = new ResgateFunc();
    ConfirmarFunc confirmar = new ConfirmarFunc();
    EmProcessamentoFunc emProcessamento = new EmProcessamentoFunc();
    private final ThreadLocal<Integer> solicitacoes = new ThreadLocal<>();
    private final ThreadLocal<String> totalDisponivelParaResgate = new ThreadLocal<>();
    private final ThreadLocal<String> valorResgate = new ThreadLocal<>();

    @Test(description = "[v2] Validar o resgate total de uma aplicação do segmento CDB")
    @Description("Descrição do cenário\n"
            + "COMO Usuário de investimento do NEXT\n"
            + "QUERO acessar os meus investimentos\n"
            + "PARA para realizar o resgate de aplicação. \n"
            + "\n"
            + "Pré-Condições:\n"
            + "1- Ter o App instalado;\n"
            + "2- Ter conta ativa no Next;\n"
            + "3- Possuir investimento com saldo para realizar o resgate total em um produto do segmento CDB;")
    @Severity(SeverityLevel.NORMAL)
    public void QA27624() throws Exception {

        String produto = Produto.NEXT_CDB;
        String data = MobileUtils.retornaDataAtualFormatada("dd/MM/yyyy");

        login.efetuarLoginUsuarioExistente(recuperarMassa(CPF), recuperarMassa(SENHA));

        menu.selecionarInvestimentos();

        resgate.realizarResgateTotal(Segmento.CDB, produto, solicitacoes, valorResgate, totalDisponivelParaResgate);

        confirmar.validarInformacoesAplicacaoOuResgate(
                produto,
                ConfirmarInformacoesSolicitacao.RESGATE,
                totalDisponivelParaResgate.get(),
                data,
                MobileUtils.retornaSubtracaoValoresMonetarios(totalDisponivelParaResgate.get(), valorResgate.get())
        );

        confirmar.confirmarResgate(
                produto,
                totalDisponivelParaResgate.get(),
                data,
                true
        );

        emProcessamento.realizarValidacaoSolicitacoesEmAberto(
                produto,
                TipoSolicitacao.RESGATE,
                valorResgate.get(),
                Texto.SOLICITADO_EM,
                MobileUtils.retornaDataAtualFormatada("dd/MM/yy"),
                solicitacoes
        );
    }
}

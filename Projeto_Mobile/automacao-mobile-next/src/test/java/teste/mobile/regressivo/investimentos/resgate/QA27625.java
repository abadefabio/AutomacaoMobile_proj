package teste.mobile.regressivo.investimentos.resgate;

import static br.com.next.automacao.core.constantes.massa.JSON.CPF;
import static br.com.next.automacao.core.constantes.massa.JSON.SENHA;
import org.testng.annotations.Test;
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

@Jornada(Jornadas.INVESTIMENTOS)
public class QA27625 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ResgateFunc resgate = new ResgateFunc();
    ConfirmarFunc confirmar = new ConfirmarFunc();
    EmProcessamentoFunc emProcessamento = new EmProcessamentoFunc();
    private final ThreadLocal<Integer> solicitacoes = new ThreadLocal<>();
    private final ThreadLocal<String> totalDisponivelParaResgate = new ThreadLocal<>();

    @Test(description = "[v1] Validar o resgate parcial de uma aplica��o do segmento CDB")
    @Description("Descri��o do cen�rio\n"
            + "COMO Usu�rio de investimento do NEXT\n"
            + "QUERO acessar os meus investimentos\n"
            + "PARA para realizar o resgate de aplica��o. \n"
            + "\n"
            + "Pr�-Condi��es:\n"
            + "1- Ter o App instalado;\n"
            + "2- Ter conta ativa no Next;\n"
            + "3- Possuir investimento com saldo para realizar o resgate parcial em um produto do segmento CDB;")
    @Severity(SeverityLevel.NORMAL)
    public void QA27625() throws Exception {

        String produto = Produto.NEXT_CDB;
        String data = MobileUtils.retornaDataAtualFormatada("dd/MM/yyyy");

        login.efetuarLoginUsuarioExistente(recuperarMassa(CPF), recuperarMassa(SENHA));

        menu.selecionarInvestimentos();

        resgate.validarPopUpAoRealizarResgateParcialValorMaiorMinimo(
                Segmento.CDB,
                produto,
                solicitacoes,
                totalDisponivelParaResgate);

        confirmar.validarInformacoesAplicacaoOuResgate(
                produto,
                ConfirmarInformacoesSolicitacao.RESGATE,
                totalDisponivelParaResgate.get(),
                data,
                MobileUtils.retornaSubtracaoValoresMonetarios(totalDisponivelParaResgate.get(), totalDisponivelParaResgate.get())
        );

        confirmar.confirmarResgate(
                produto,
                totalDisponivelParaResgate.get(),
                data,
                false
        );

        emProcessamento.realizarValidacaoSolicitacoesEmAberto(
                produto,
                TipoSolicitacao.RESGATE,
                totalDisponivelParaResgate.get(),
                Texto.SOLICITADO_EM,
                MobileUtils.retornaDataAtualFormatada("dd/MM/yy"),
                solicitacoes
        );
    }
}

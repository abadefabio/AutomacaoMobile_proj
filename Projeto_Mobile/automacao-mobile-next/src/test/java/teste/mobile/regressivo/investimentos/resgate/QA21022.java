package teste.mobile.regressivo.investimentos.resgate;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.tools.Utilitarios;
import constantes.investimentos.ConfirmarInformacoesSolicitacao;
import constantes.investimentos.Produto;
import constantes.investimentos.Segmento;
import constantes.investimentos.Texto;
import constantes.investimentos.TipoSolicitacao;
import constantes.investimentos.Valor;
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
public class QA21022 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ResgateFunc resgate = new ResgateFunc();
    ConfirmarFunc confirmar = new ConfirmarFunc();
    EmProcessamentoFunc emProcessamento = new EmProcessamentoFunc();
    private final ThreadLocal<Integer> solicitacoes = new ThreadLocal<>();
    private final ThreadLocal<String> totalDisponivelParaResgate = new ThreadLocal<>();

    @Test(description = "[v1] Validar o resgate de uma aplicação do segmento Fundos pelos detalhes da aplicação")
    @Description("Descrição do cenário\n"
            + "COMO Usuário de investimento do NEXT\n"
            + "QUERO acessar os meus investimentos\n"
            + "PARA para realizar o resgate de aplicação. \n"
            + "\n"
            + "Pré-Condições:\n"
            + "1- Ter o App instalado;\n"
            + "2- Ter conta ativa no Next;\n"
            + "3- Possuir investimento com saldo para resgate em um produto do segmento Fundos;")
    @Severity(SeverityLevel.NORMAL)
    public void QA21022() throws Exception {

        String produto = Produto.NEXT_ALOCACAO_ARROJADA;
        String valor = Utilitarios.reformatarValorMonetario(Valor.DE_CEM_A_DUZENTOS_E_CINQUENTA.toString());
        String data = MobileUtils.retornaDataAtualFormatada("dd/MM/yyyy");

        login.efetuarLoginUsuarioExistente(recuperarMassa(CPF), recuperarMassa(SENHA));

        menu.selecionarInvestimentos();

        resgate.realizarResgateParcialBotaoVerMais(Segmento.FUNDOS, produto, solicitacoes, valor, totalDisponivelParaResgate);

        confirmar.validarInformacoesAplicacaoOuResgate(
                produto,
                ConfirmarInformacoesSolicitacao.RESGATE,
                valor,
                data,
                MobileUtils.retornaSubtracaoValoresMonetarios(totalDisponivelParaResgate.get(), valor)
        );

        confirmar.confirmarResgate(produto, valor, data, false);

        emProcessamento.realizarValidacaoSolicitacoesEmAberto(
                produto,
                TipoSolicitacao.RESGATE,
                valor,
                Texto.SOLICITADO_EM,
                MobileUtils.retornaDataAtualFormatada("dd/MM/yy"),
                solicitacoes
        );
    }
}

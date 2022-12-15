package teste.mobile.regressivo.investimentos.resgate;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.tools.Utilitarios;
import constantes.investimentos.Produto;
import constantes.investimentos.Segmento;
import constantes.investimentos.ValidarInformacoesComprovante;
import constantes.investimentos.Valor;
import framework.MobileUtils;
import funcionalidade.mobile.investimentos.ComprovantePoupancaFunc;
import funcionalidade.mobile.investimentos.meus.investimentos.MeusInvestimentosFunc;
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
public class QA21024 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ResgateFunc resgate = new ResgateFunc();
    ComprovantePoupancaFunc comprovante = new ComprovantePoupancaFunc();
    MeusInvestimentosFunc meusInvestimentos = new MeusInvestimentosFunc();
    private final ThreadLocal<String> totalDisponivelParaResgate = new ThreadLocal<>();

    @Test(description = "[v1] Validar o resgate de uma aplicação do segmento Poupança pelos detalhes da aplicação")
    @Description("Descrição do cenário\n"
            + "COMO Usuário de investimento do NEXT\n"
            + "QUERO acessar os meus investimentos\n"
            + "PARA para realizar o resgate de aplicação. \n"
            + "\n"
            + "Pré-Condições:\n"
            + "1- Ter o App instalado;\n"
            + "2- Ter conta ativa no Next;\n"
            + "3- Possuir investimento \"APENAS\" em Poupança com saldo para resgate;")
    @Severity(SeverityLevel.NORMAL)
    public void QA21024() throws Exception {

        String produto = Produto.NEXT_POUPANCA;
        String valor = Utilitarios.reformatarValorMonetario(Valor.DE_CEM_A_DUZENTOS_E_CINQUENTA.toString());

        login.efetuarLoginUsuarioExistente(recuperarMassa(CPF), recuperarMassa(SENHA));

        menu.selecionarInvestimentos();

        resgate.realizarResgateParcialPoupancaBotaoVerMais(Segmento.POUPANCA, produto,  valor, totalDisponivelParaResgate);

        comprovante.validarComprovante(
                false,
                valor,
                ValidarInformacoesComprovante.RESGATE,
                Produto.NEXT_POUPANCA,
                MobileUtils.retornaSubtracaoValoresMonetarios(totalDisponivelParaResgate.get(), valor)
        );

        meusInvestimentos.validarAusenciaBlocoEmProcessamento();
    }
}

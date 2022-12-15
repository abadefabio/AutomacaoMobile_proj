package teste.mobile.regressivo.investimentos.resgate;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.tools.Utilitarios;
import constantes.investimentos.Produto;
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
public class QA21023 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ResgateFunc resgate = new ResgateFunc();
    ComprovantePoupancaFunc comprovante = new ComprovantePoupancaFunc();
    MeusInvestimentosFunc meusInvestimentos = new MeusInvestimentosFunc();
    private final ThreadLocal<String> totalDisponivelParaResgate = new ThreadLocal<>();

    @Test(description = "[v1] Validar o resgate de uma aplicação em Poupança pelo Menu de Investimentos")
    @Description("Descrição do cenário\n"
            + "COMO Usuário de investimento NEXT\n"
            + "QUERO acessar meus investimentos\n"
            + "PARA realizar o resgate da aplicação em Poupança \n"
            + "\n"
            + "Pré-Condições:\n"
            + "1- Ter o App instalado;\n"
            + "2- Ter conta ativa no Next;\n"
            + "3- Possuir investimentos em Poupança que possa ser resgatado;")
    @Severity(SeverityLevel.NORMAL)
    public void QA21023() throws Exception {

        String valor = Utilitarios.reformatarValorMonetario(Valor.DE_CEM_A_DUZENTOS_E_CINQUENTA.toString());

        login.efetuarLoginUsuarioExistente(recuperarMassa(CPF), recuperarMassa(SENHA));

        menu.selecionarInvestimentos();

        resgate.realizarResgateParcialPoupanca(valor, totalDisponivelParaResgate);

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

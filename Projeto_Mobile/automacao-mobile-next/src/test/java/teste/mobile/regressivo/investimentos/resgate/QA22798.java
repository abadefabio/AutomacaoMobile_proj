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
import funcionalidade.mobile.investimentos.MovimentacoesFunc;
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
public class QA22798 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ResgateFunc resgate = new ResgateFunc();
    ComprovantePoupancaFunc comprovante = new ComprovantePoupancaFunc();
    MovimentacoesFunc movimentacoes = new MovimentacoesFunc();
    private final ThreadLocal<String> saldoPoupanca = new ThreadLocal<>();

    @Test(description = "[v1] Validar resgate da Poupança através do próprio menu na home do app")
    @Description("Descrição do cenário\n"
            + "COMO Usuário de investimento do NEXT\n"
            + "QUERO acessar a poupança\n"
            + "PARA para realizar um resgate. \n"
            + "\n"
            + "Pré-Condições:\n"
            + "1- Ter o App instalado;\n"
            + "2- Ter conta ativa no Next;\n"
            + "3- Possuir investimento em Poupança;")
    @Severity(SeverityLevel.NORMAL)
    public void QA22798() throws Exception {
        String valor = Utilitarios.reformatarValorMonetario(Valor.DE_CEM_A_DUZENTOS_E_CINQUENTA.toString());

        login.efetuarLoginUsuarioExistente(recuperarMassa(CPF), recuperarMassa(SENHA));

        menu.selecionarPoupanca();

        resgate.realizarResgateParcialMenuPoupanca(valor, saldoPoupanca);

        comprovante.validarComprovante(
                false,
                valor,
                ValidarInformacoesComprovante.RESGATE,
                Produto.NEXT_POUPANCA,
                MobileUtils.retornaSubtracaoValoresMonetarios(saldoPoupanca.get(), valor)
        );

        movimentacoes.validarMovimentacoesPoupanca(valor);
    }
}

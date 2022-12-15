package teste.mobile.regressivo.investimentos.aplicacao;

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
import funcionalidade.mobile.investimentos.aplicacao.AplicacaoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import static br.com.next.automacao.core.constantes.massa.JSON.CPF;
import static br.com.next.automacao.core.constantes.massa.JSON.SENHA;

@Jornada(Jornadas.INVESTIMENTOS)
public class QA21029 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    AplicacaoFunc aplicacao = new AplicacaoFunc();
    ComprovantePoupancaFunc comprovante = new ComprovantePoupancaFunc();
    MovimentacoesFunc movimentacoes = new MovimentacoesFunc();

    @Test(description = "[v1] Validar primeira aplica��o em Poupan�a atrav�s do Menu Poupan�a na Home do Next")
    @Description("Descri��o do cen�rio\n"
            + "COMO Usu�rio de investimento do NEXT\n"
            + "QUERO realizar a primeira aplica��o na Poupan�a\n"
            + "PARA que eu possa guardar meu dinheiro. \n"
            + "\n"
            + "Pr�-Condi��es:\n"
            + "1- Ter o App instalado;\n"
            + "2- Ter conta ativa no Next;\n"
            + "3- N�o possuir aplica��o em Poupan�a;")
    @Severity(SeverityLevel.NORMAL)
    public void QA21029() throws Exception {

        String valor = Utilitarios.reformatarValorMonetario(Valor.DE_CEM_A_NOVECENTOS_E_NOVENTA_E_NOVE.toString());

        login.efetuarLoginUsuarioExistente(recuperarMassa(CPF), recuperarMassa(SENHA));

        menu.selecionarPoupanca();

        aplicacao.realizarNovaAplicacaoMenuPoupanca(valor);

        comprovante.validarComprovante(
                false,
                valor,
                ValidarInformacoesComprovante.APLICACAO,
                valor,
                MobileUtils.retornaDataAtualFormatada("dd/MM/yyyy"),
                Produto.NEXT_POUPANCA
        );

        movimentacoes.validarMovimentacoesPoupanca(valor);
    }
}

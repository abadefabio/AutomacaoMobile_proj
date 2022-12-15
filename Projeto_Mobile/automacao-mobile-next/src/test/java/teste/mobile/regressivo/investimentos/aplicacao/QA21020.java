package teste.mobile.regressivo.investimentos.aplicacao;

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
import funcionalidade.mobile.investimentos.aplicacao.AplicacaoFunc;
import funcionalidade.mobile.investimentos.meus.investimentos.MeusInvestimentosFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import static br.com.next.automacao.core.constantes.massa.JSON.CPF;
import static br.com.next.automacao.core.constantes.massa.JSON.SENHA;

@Jornada(Jornadas.INVESTIMENTOS)
public class QA21020 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    AplicacaoFunc aplicacao = new AplicacaoFunc();
    ComprovantePoupancaFunc comprovante = new ComprovantePoupancaFunc();
    MeusInvestimentosFunc meusInvestimentos = new MeusInvestimentosFunc();
    ThreadLocal<String> saldoInvestido = new ThreadLocal<>();

    @Test(description = "[v1] Validar aplicação pelo botão INVESTIR através dos detalhes de uma aplicação em Poupança")
    @Description("Descrição do cenário\n"
            + "COMO Usuário do NEXT\n"
            + "QUERO acessar meus investimentos\n"
            + "PARA adicionar valores a aplicação Poupança \n"
            + "\n"
            + "Pré-Condições:\n"
            + "1- Ter o App instalado;\n"
            + "2- Ter conta ativa no Next;\n"
            + "3- Possuir um investimento em Poupança;\n"
            + "4- Ter saldo em conta;")
    @Severity(SeverityLevel.NORMAL)
    public void QA21020() throws Exception {

        String produto =  Produto.NEXT_POUPANCA;
        String valor = Utilitarios.reformatarValorMonetario(Valor.DE_UM_A_NOVENTA_E_NOVE.toString());

        login.efetuarLoginUsuarioExistente(recuperarMassa(CPF), recuperarMassa(SENHA));

        menu.selecionarInvestimentos();

        aplicacao.realizarAplicacaoPoupancaBotaoVerMais(Segmento.POUPANCA, produto, valor, saldoInvestido);

        comprovante.validarComprovante(
                false,
                valor,
                ValidarInformacoesComprovante.APLICACAO,
                MobileUtils.retornaSomaValoresMonetarios(saldoInvestido.get(), valor),
                MobileUtils.retornaDataAtualFormatada("dd/MM/yyyy"),
                produto
        );

        meusInvestimentos.validarAusenciaBlocoEmProcessamento();
    }
}

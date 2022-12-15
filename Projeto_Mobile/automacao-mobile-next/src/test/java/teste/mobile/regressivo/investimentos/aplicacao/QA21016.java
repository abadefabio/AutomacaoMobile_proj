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
public class QA21016 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    AplicacaoFunc aplicacao = new AplicacaoFunc();
    ComprovantePoupancaFunc comprovante = new ComprovantePoupancaFunc();
    MeusInvestimentosFunc meusInvestimentos = new MeusInvestimentosFunc();

    @Test(description = "[v1] Validar primeira aplicação no segmento Poupança pelo menu Investimentos")
    @Description("Descrição do cenário\n"
            + "COMO Usuário do NEXT\n"
            + "QUERO realizar a primeira aplicação em Poupança através do menu Investimentos\n"
            + "PARA que eu possa guardar meu dinheiro. \n"
            + "\n"
            + "Pré-Condições:\n"
            + "1- Ter o App instalado;\n"
            + "2- Ter conta ativa no Next;\n"
            + "3- Não possuir investimentos;\n"
            + "4- Não possuir perfil de investidor;\n"
            + "5- Ter saldo em conta;")
    @Severity(SeverityLevel.NORMAL)
    public void QA21016() throws Exception {

        String produto = Produto.NEXT_POUPANCA;
        String valor = Utilitarios.reformatarValorMonetario(Valor.DE_CEM_A_NOVECENTOS_E_NOVENTA_E_NOVE.toString());

        login.efetuarLoginUsuarioExistente(recuperarMassa(CPF), recuperarMassa(SENHA));

        menu.selecionarInvestimentos();

        aplicacao.tocarBotaoInvestirPorProdutoDoSegmento(Segmento.POUPANCA, produto);

        aplicacao.realizarNovaAplicacaoSemPerfilInvestidor(produto, valor);

        comprovante.validarComprovante(
                false,
                valor,
                ValidarInformacoesComprovante.APLICACAO,
                valor,
                MobileUtils.retornaDataAtualFormatada("dd/MM/yyyy"),
                produto
        );

        meusInvestimentos.validarAusenciaBlocoEmProcessamento();
    }
}

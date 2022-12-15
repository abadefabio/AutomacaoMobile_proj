package teste.mobile.regressivo.investimentos.aplicacao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.tools.Utilitarios;
import constantes.investimentos.ConfirmarInformacoesSolicitacao;
import constantes.investimentos.Perfil;
import constantes.investimentos.Produto;
import constantes.investimentos.Segmento;
import constantes.investimentos.Texto;
import constantes.investimentos.TipoSolicitacao;
import constantes.investimentos.Valor;
import framework.MobileUtils;
import funcionalidade.mobile.investimentos.ConfirmarFunc;
import funcionalidade.mobile.investimentos.aplicacao.AplicacaoFunc;
import funcionalidade.mobile.investimentos.meus.investimentos.EmProcessamentoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import static br.com.next.automacao.core.constantes.massa.JSON.CPF;
import static br.com.next.automacao.core.constantes.massa.JSON.SENHA;

@Jornada(Jornadas.INVESTIMENTOS)
public class QA21018 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    AplicacaoFunc aplicacao = new AplicacaoFunc();
    ConfirmarFunc confirmar = new ConfirmarFunc();
    EmProcessamentoFunc emProcessamento = new EmProcessamentoFunc();
    ThreadLocal<Integer> solicitacoes = new ThreadLocal<>();

    @Test(description = "[v1] Validar aplicação pelo botão INVESTIR através dos detalhes de uma aplicação")
    @Description("Descrição do cenário\n"
            + "COMO Usuário do NEXT\n"
            + "QUERO acessar meus investimentos\n"
            + "PARA adicionar valores a uma aplicação em andamento através dos detalhes da aplicação \n"
            + "\n"
            + "Pré-Condições:\n"
            + "1- Ter o App instalado;\n"
            + "2- Ter conta ativa no Next;\n"
            + "3- Possuir um investimento em CDB ou Fundos;\n"
            + "4- Ter saldo em conta;")
    @Severity(SeverityLevel.NORMAL)
    public void QA21018() throws Exception {

        String produto = Produto.NEXT_ALOCACAO_ARROJADA;
        String valor = Utilitarios.reformatarValorMonetario(Valor.DE_DOIS_MIL_A_TRES_MIL.toString());
        String data = MobileUtils.retornaDataAtualFormatada("dd/MM/yyyy");

        login.efetuarLoginUsuarioExistente(recuperarMassa(CPF), recuperarMassa(SENHA));

        menu.selecionarInvestimentos();

        aplicacao.realizarAplicacaoBotaoVerMais(Segmento.FUNDOS, produto, valor, solicitacoes);

        confirmar.validarInformacoesAplicacaoOuResgate(
                produto,
                ConfirmarInformacoesSolicitacao.APLICACAO,
                valor,
                data
        );

        confirmar.confirmarAplicacao(
                produto,
                valor,
                data,
                Perfil.TEM_PERFIL_INVESTIDOR,
                false,
                false
        );

        emProcessamento.realizarValidacaoSolicitacoesEmAberto(
                produto,
                TipoSolicitacao.APLICACAO,
                valor,
                Texto.SOLICITADO_EM,
                MobileUtils.retornaDataAtualFormatada("dd/MM/yy"),
                solicitacoes
        );
    }
}

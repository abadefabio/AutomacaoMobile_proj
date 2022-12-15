package teste.mobile.regressivo.investimentos.aplicacao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.tools.Utilitarios;
import constantes.investimentos.ConfirmarInformacoesSolicitacao;
import constantes.investimentos.Perfil;
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
public class QA21015 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    AplicacaoFunc aplicacao = new AplicacaoFunc();
    ConfirmarFunc confirmar = new ConfirmarFunc();
    EmProcessamentoFunc emProcessamento = new EmProcessamentoFunc();
    ThreadLocal<String> produto = new ThreadLocal<>();
    ThreadLocal<Integer> solicitacoes = new ThreadLocal<>();

    @Test(description = "[v1] Validar primeira aplicação em um produto do segmento Fundos")
    @Description("Descrição do cenário\n"
            + "COMO Usuário de investimento do NEXT\n"
            + "QUERO realizar a primeira aplicação em um produto do seguimento Fundos\n"
            + "PARA que eu possa investir meu dinheiro.\n"
            + "\n"
            + "Pré-Condições:\n"
            + "1- Ter o App instalado;\n"
            + "2- Ter conta ativa no Next;\n"
            + "3- Não possuir investimentos;\n"
            + "4- Ter saldo em conta;")
    @Severity(SeverityLevel.NORMAL)
    public void QA21015() throws Exception {

        String valor = Utilitarios.reformatarValorMonetario(Valor.DE_DOIS_MIL_A_TRES_MIL.toString());
        String data = MobileUtils.retornaDataAtualFormatada("dd/MM/yyyy");

        login.efetuarLoginUsuarioExistente(recuperarMassa(CPF), recuperarMassa(SENHA));

        menu.selecionarInvestimentos();

        aplicacao.tocarBotaoInvestirPrimeiroProduto(Segmento.FUNDOS, produto);

        aplicacao.realizarNovaAplicacaoSemPerfilInvestidor(produto.get(), valor);

        confirmar.validarInformacoesAplicacaoOuResgate(
                produto.get(),
                ConfirmarInformacoesSolicitacao.APLICACAO,
                valor,
                data
        );

        confirmar.confirmarAplicacao(
                produto.get(),
                valor,
                data,
                Perfil.SEM_PERFIL_INVESTIDOR,
                true,
                false
        );

        emProcessamento.realizarValidacaoSolicitacoesEmAberto(
                produto.get(),
                TipoSolicitacao.APLICACAO,
                valor,
                Texto.SOLICITADO_EM,
                MobileUtils.retornaDataAtualFormatada("dd/MM/yy"),
                solicitacoes
        );
    }
}

package teste.mobile.regressivo.investimentos.aplicacao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.tools.Utilitarios;

import constantes.investimentos.ConfirmarInformacoesSolicitacao;
import constantes.investimentos.Perfil;
import constantes.investimentos.Segmento;
import constantes.investimentos.Produto;
import framework.MobileUtils;
import funcionalidade.mobile.investimentos.ConfirmarFunc;
import funcionalidade.mobile.investimentos.aplicacao.AplicacaoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import static constantes.investimentos.Decisao.JA_ACESSOU_COM_INVESTIMENTOS;

@Jornada(Jornadas.INVESTIMENTOS)
public class QA20329 extends TesteBase {
    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    AplicacaoFunc aplicacao = new AplicacaoFunc();
    ConfirmarFunc confirmar = new ConfirmarFunc();

    @Test(description = "PBI.153634.153652.015 Validar o fluxo de\n" +
            "investimento na vitrine com desenquadramento de perfil de investidor")
    @Description("Pré-Condições:" +
            "1- Ter perfil de investidor ULTRACONSERVADOR" +
            "2- Ter saldo em conta" +
            "3- Massa que não tenha investimentos de alocação arrojada")
    @Severity(SeverityLevel.NORMAL)
    public void QA20329() throws Exception {

        String produto = Produto.NEXT_ALOCACAO_ARROJADA;
        String valor = recuperarMassa("valorAplicacao");
        String data = MobileUtils.retornaDataAtualFormatada("dd/MM/yyyy");

        login.efetuarLoginUsuarioExistente(recuperarMassa("cpf"), recuperarMassa("senha"));

        menu.selecionarInvestimentos(JA_ACESSOU_COM_INVESTIMENTOS);

        aplicacao.tocarBotaoInvestirPorProdutoDoSegmento(Segmento.FUNDOS, produto);

        aplicacao.realizarNovaAplicacao(produto, valor,true);

        confirmar.validarInformacoesAplicacaoOuResgate(
                produto,
                ConfirmarInformacoesSolicitacao.APLICACAO,
                valor,
                data
        );

        confirmar.confirmarAplicacao(
                produto,
                Utilitarios.reformatarValorMonetario(valor),
                data,
                Perfil.PERFIL_DESENQUADRADO,
                false,
                false
        );
    }
}

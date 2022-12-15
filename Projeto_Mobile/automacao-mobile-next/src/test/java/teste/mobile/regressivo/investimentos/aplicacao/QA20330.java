package teste.mobile.regressivo.investimentos.aplicacao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.tools.Utilitarios;
import constantes.investimentos.ConfirmarInformacoesSolicitacao;
import constantes.investimentos.Decisao;
import constantes.investimentos.Perfil;
import constantes.investimentos.Segmento;
import constantes.investimentos.json.JSONInvestimento;
import framework.MobileUtils;
import funcionalidade.mobile.investimentos.ConfirmarFunc;
import funcionalidade.mobile.investimentos.aplicacao.AplicacaoFunc;
import funcionalidade.mobile.investimentos.perfil.PerfilVencidoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.perfil.investidor.DescobrindoPerfilFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.INVESTIMENTOS)
public class QA20330 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    AplicacaoFunc aplicacao = new AplicacaoFunc();
    PerfilVencidoFunc perfilVencido = new PerfilVencidoFunc();
    DescobrindoPerfilFunc descobrindoPerfil = new DescobrindoPerfilFunc();
    ConfirmarFunc confirmar = new ConfirmarFunc();

    @Test(description = "PBI.153634.153652.016 Validar o fluxo de investimento na vitrine com perfil de investidor vencido")
    @Description("COMO usuário de investimento NEXT\n" +
            "QUERO poder visualizar na home de investimentos as segmentações de produtos e poder clicar em uma das opções\n" +
            "PARA que eu possa consultar e conhecer os produtos de investimentos comercializados pelo next e poder clicar nos botões de ações existentes e ser direcionado para as páginas as -is.Ter o app instalado;\n" +
            "Ter conta ativa no Next\n" +
            "Ter investimentos no app\n" +
            "Ter o perfil de investidor vencido\n")
    @Severity(SeverityLevel.NORMAL)
    public void QA20330() throws Exception {

        String produto = recuperarMassa("produto");
        String valor = Utilitarios.reformatarValorMonetario(recuperarMassa(JSONInvestimento.VALOR_APLICACAO));
        String data = MobileUtils.retornaDataAtualFormatada("dd/MM/yyyy");

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarInvestimentos(Decisao.JA_ACESSOU_COM_INVESTIMENTOS);

        aplicacao.tocarBotaoInvestirPorProdutoDoSegmento(Segmento.FUNDOS, produto);

        perfilVencido.refazerPerfilInvestidor();

        descobrindoPerfil.responderQuestionarioPrimeirasOpcoes();

        descobrindoPerfil.continuarAplicacao();

        aplicacao.realizarNovaAplicacao(produto, valor,false);

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
                Perfil.TEM_PERFIL_INVESTIDOR,
                false,
                true
        );
    }
}

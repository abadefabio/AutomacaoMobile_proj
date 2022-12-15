package teste.mobile.regressivo.vaquinha;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;

import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.vaquinha.VaquinhaFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Jornada(Jornadas.VAQUINHA)
public class QA00118 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    VaquinhaFunc vaquinha = new VaquinhaFunc();

    @Test(description = "REG.VAQ.01.03 - Validação de: cancelamento da vaquinha através da tela \"Sua Vaquinha está pronta\" e alteração de todos os campos da Vaquinha")
    @Description("Efetuar a alteração dos status dos participantes da Vaquinha (1) e realizar alteração de todos os campos da vaquinha.")

    @Severity(SeverityLevel.NORMAL)
    public void QA00118() throws Exception {

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarVaquinha();

        vaquinha.acessarCriarVaquinha();

        vaquinha.aceitarCheckTermoCondicoes();

        vaquinha.preencherNomedaVaquinha(recuperarMassa("nomeVaquinha"));

        vaquinha.inserirValorSelecionarDataCriarVaquinha(recuperarMassa("valorVaquinha"));

        vaquinha.tocarBotaoPerfil();

        vaquinha.acessarExcluirVaquinha();

        vaquinha.tocarBotaoConfirmaExclusaoVaquinha();

        vaquinha.acessarCriarVaquinha();

        vaquinha.aceitarCheckTermoCondicoes();

        vaquinha.preencherNomedaVaquinha(recuperarMassa("nomeVaquinha"));

        vaquinha.inserirValorSelecionarDataCriarVaquinha(recuperarMassa("valorVaquinha"));

        vaquinha.tocarBotaoPerfil();

        vaquinha.tocarBotaoEditarPerfil();

        vaquinha.tocarBotaoEditarImagem();

        vaquinha.tocarBotaoEditarNome(recuperarMassa("nomeVaquinhaAlterada"));

        vaquinha.tocarBotaoEditarData();

        login.logout();

        login.loginSemEscolhaEsteira(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarNotificacoes();

    }

    @AfterMethod
    public void excluirVaquinha(ITestResult result) throws Exception {

        if (result.isSuccess()) {
            vaquinha.retornarAoMenu();
            menu.selecionarVaquinha();
            vaquinha.excluirMultiplasVaquinhas(1);
            vaquinha.excluirMultiplosCards(2);

        }
    }
}

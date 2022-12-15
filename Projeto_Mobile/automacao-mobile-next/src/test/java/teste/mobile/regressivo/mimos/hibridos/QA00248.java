package teste.mobile.regressivo.mimos.hibridos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.tools.ReadProperties;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.mimos.MimosFunc;
import funcionalidade.web.sistemadegestao.login.SistemaDeGestaoLoginFunc;
import funcionalidade.web.sistemadegestao.menu.SistemaDeGestaoMenuFunc;
import funcionalidade.web.sistemadegestao.mimos.hub.SistemaDeGestaoMenuHubFunc;
import funcionalidade.web.sistemadegestao.mimos.hub.SistemaDeGestaoOfertasFunc;
import funcionalidade.web.sistemadegestao.mimos.menu.SistemaDeGestaoMenuMimosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

@Jornada(Jornadas.MIMOS)
public class QA00248 extends TesteBase{

    SistemaDeGestaoLoginFunc loginSistemaDeGestao = new SistemaDeGestaoLoginFunc();
    SistemaDeGestaoMenuFunc menuSistemaDeGestao = new SistemaDeGestaoMenuFunc();
    SistemaDeGestaoMenuMimosFunc menuMimosSistemaDeGestao = new SistemaDeGestaoMenuMimosFunc();
    SistemaDeGestaoMenuHubFunc menuHubSistemaDeGestao = new SistemaDeGestaoMenuHubFunc();
    SistemaDeGestaoOfertasFunc ofertasHubSistemaDeGestao = new SistemaDeGestaoOfertasFunc();
    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    MimosFunc mimos = new MimosFunc();

    @Test(description = "REG.MIM.08.07 - Vencimento da oferta favoritada")
    @Description("Objetivos:\n" +
            "Objetivos: \n" +
            "Validar vencimento de oferta.\n" +
            " \n" +
            "Pré-Requisitos:\n" +
            "Possuir o aplicativo do Next instalado no celular;\n" +
            "Ter conta next;\n" +
            "Logar no app;\n" +
            "Possuir uma oferta favoritada válida.\n" +
            " \n" +
            "Pós-Condições:\n" +
            "Obter oferta vencida, no sistema de gestão.\n" +
            " \n" +
            "Evidencias necessárias:\n" +
            "Todo o fluxo até as telas.")
    @Severity(SeverityLevel.NORMAL)

    public void QA00248() throws Exception{

        String cpf = recuperarMassa(JSON.CPF);
        String senha = recuperarMassa(JSON.SENHA);

        login.efetuarLoginUsuarioExistente(cpf, senha);

        menu.selecionarMimos();

        mimos.validarOfertaNaCategoria(recuperarMassa("categoria"),recuperarMassa("parceiro"));

        loginSistemaDeGestao.realizarLogin(ReadProperties.getGestaoUser(),ReadProperties.getGestaoPass(), ReadProperties.getAmbiente());

        menuSistemaDeGestao.clicarLinkMIMOS();

        menuMimosSistemaDeGestao.clicarLinkHub();

        menuHubSistemaDeGestao.clicarLinkOfertas();

        ofertasHubSistemaDeGestao.clicarEditarOferta(recuperarMassa("oferta"));

        ofertasHubSistemaDeGestao.editarCampoValidoAteHoraAtualMaisDoisMin();

        ofertasHubSistemaDeGestao.clicarBotaoAlterar();

        ofertasHubSistemaDeGestao.clicarBotaoSim();

        ofertasHubSistemaDeGestao.clicarBotaoOK();

        ofertasHubSistemaDeGestao.clicarEditandoOferta(recuperarMassa("oferta"));

        ofertasHubSistemaDeGestao.clicarBotaoAprovar();

        ofertasHubSistemaDeGestao.clicarBotaoSim();

        ofertasHubSistemaDeGestao.clicarBotaoOK();

        login.recarregarAppNext();

        login.efetuarLoginUsuarioExistente(cpf, senha);

        menu.selecionarMimos();

        mimos.voltarParaMenuPrincipal();

        menu.selecionarMimos();

        mimos.validarExibicaoCarrossel();

        mimos.validarOfertaNaoPresenteNaCategoria(recuperarMassa("categoria"),recuperarMassa("oferta"));

    }

    @AfterMethod
    public void alterarOferaRemovendoDataValidade(ITestResult result) throws Exception {
        if(result.isSuccess()) {
            ofertasHubSistemaDeGestao.clicarEditarOferta(recuperarMassa("oferta"));
            ofertasHubSistemaDeGestao.editarCampoValidoAteComoVazio(); ofertasHubSistemaDeGestao.clicarBotaoAlterar();
            ofertasHubSistemaDeGestao.clicarBotaoSim();
            ofertasHubSistemaDeGestao.clicarBotaoOK();
            ofertasHubSistemaDeGestao.clicarEditandoOferta(recuperarMassa("oferta"));
            ofertasHubSistemaDeGestao.clicarBotaoAprovar();
            ofertasHubSistemaDeGestao.clicarBotaoSim();
            ofertasHubSistemaDeGestao.clicarBotaoOK();
        }
    }

}

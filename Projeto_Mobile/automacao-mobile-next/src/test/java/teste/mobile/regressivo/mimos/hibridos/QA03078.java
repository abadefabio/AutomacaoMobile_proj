package teste.mobile.regressivo.mimos.hibridos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.tools.ReadProperties;
import constantes.mimos.web.BaseDeCupons;
import constantes.mimos.web.TipoDeLink;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

@Jornada(Jornadas.MIMOS)
public class QA03078 extends TesteBase{

    SistemaDeGestaoLoginFunc loginSistemaDeGestao = new SistemaDeGestaoLoginFunc();
    SistemaDeGestaoMenuFunc menuSistemaDeGestao = new SistemaDeGestaoMenuFunc();
    SistemaDeGestaoMenuMimosFunc menuMimosSistemaDeGestao = new SistemaDeGestaoMenuMimosFunc();
    SistemaDeGestaoMenuHubFunc menuHubSistemaDeGestao = new SistemaDeGestaoMenuHubFunc();
    SistemaDeGestaoOfertasFunc ofertasHubSistemaDeGestao = new SistemaDeGestaoOfertasFunc();
    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    MimosFunc mimos = new MimosFunc();

    @Test(description = "REG.MIM.08.06 - Cadastrar oferta hub")
    @Description("Objetivos: \n" +
            "Validar cadastro de oferta.\n" +
            "\n" +
            "Pré-Requisitos:\n" +
            "Possuir o aplicativo do Next instalado no celular;\n" +
            "Ter conta next;\n" +
            "Logar no app;\n" +
            "Ter arquivo excel gerado com base de voucher para cadastramento no Sistema de gestão.\n" +
            " \n" +
            "Pós-Condições:\n" +
            "Cadastro de oferta do hub realizado.\n" +
            " \n" +
            "Evidencias necessárias:\n" +
            "Todo o fluxo até as telas.")
    @Severity(SeverityLevel.NORMAL)

    public void QA03078() throws Exception{

        loginSistemaDeGestao.realizarLogin(ReadProperties.getGestaoUser(),ReadProperties.getGestaoPass(), ReadProperties.getAmbiente());

        menuSistemaDeGestao.clicarLinkMIMOS();

        menuMimosSistemaDeGestao.clicarLinkHub();

        menuHubSistemaDeGestao.clicarLinkOfertas();

        ofertasHubSistemaDeGestao.preencherInfoOferta(recuperarMassa("valorNomeOferta"),
                                                      recuperarMassa("categoria"),
                                                      recuperarMassa("parceiro"),
                                                      recuperarMassa("texto"),
                                                      recuperarMassa("pathArquivoImagem"));

        ofertasHubSistemaDeGestao.preencherInfoDadosEComoUsar(recuperarMassa("beneficio"),
                                                              recuperarMassa("formaDePagamento"),
                                                              recuperarMassa("comoUsar"));

        ofertasHubSistemaDeGestao.selecionarBaseDeCupons(BaseDeCupons.BASE_DE_VOUCHER,
                                                         recuperarMassa("pathArquivoImagem"),
                                                         recuperarMassa(JSON.VALOR));

        ofertasHubSistemaDeGestao.informarTipoDeLink(recuperarMassa("nomeBotao"),
                                                     TipoDeLink.SITE,
                                                     recuperarMassa("link"),
                                                     null,
                                                     null,
                                                     null);

        ofertasHubSistemaDeGestao.cadastrarVoucher(recuperarMassa("pathArquivoVoucher"));

        ofertasHubSistemaDeGestao.ativarOferta();

        login.efetuarLoginUsuarioExistente(recuperarMassa("loginApp"), recuperarMassa("senhaApp"));

        menu.validarTelaMenu();

        menu.selecionarMimos();

        mimos.selecionarCategoriaeOferta(recuperarMassa("categoriaApp"), recuperarMassa("valorNomeOferta" ));
    }

    @AfterMethod
    public void deletarOferta() throws Exception{
        ofertasHubSistemaDeGestao.desativarOferta();
        ofertasHubSistemaDeGestao.deletarOferta();
    }

}

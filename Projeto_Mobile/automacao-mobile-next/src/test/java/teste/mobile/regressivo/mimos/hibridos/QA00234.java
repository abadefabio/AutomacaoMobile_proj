package teste.mobile.regressivo.mimos.hibridos;

import br.com.next.automacao.core.tools.ReadProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;

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

@Jornada(Jornadas.MIMOS)
public class QA00234 extends TesteBase {

    @AfterMethod
    public void deletarOferta() throws Exception{
        ofertasHubSistemaDeGestao.desativarOferta();
        ofertasHubSistemaDeGestao.deletarOferta();
    }

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    MimosFunc mimos = new MimosFunc();
    private SistemaDeGestaoLoginFunc loginSistemaDeGestao = new SistemaDeGestaoLoginFunc();
    private SistemaDeGestaoMenuFunc menuSistemaDeGestao = new SistemaDeGestaoMenuFunc();
    private SistemaDeGestaoMenuMimosFunc menuMimosSistemaDeGestao = new SistemaDeGestaoMenuMimosFunc();
    private SistemaDeGestaoMenuHubFunc menuHubSistemaDeGestao = new SistemaDeGestaoMenuHubFunc();
    private SistemaDeGestaoOfertasFunc ofertasHubSistemaDeGestao = new SistemaDeGestaoOfertasFunc();


    @Test(description = "REG.MIMO.01.04 - Validação de: Meus cupons com cupom gerado e Geração e cópia de código do Voucher - Loja")
    @Description("Validação dos Meus cupons com cupom gerado;\n" +
            "Validação da Geração e cópia de código do Voucher - Loja OnLine;\n" +
            "Validação da Geração e cópia de código do Voucher - Loja OnLine;\n " +
            "Objetivos: \n" +
            "Validar cadastramento de uma oferta HUB com base de voucher - Loja Online.\n" +
            "Validação dos Meus cupons com cupom gerado;\n" +
            "Validação da Geração e cópia de código do Voucher - Loja OnLine.\n" +
            " \n" +
            "Pré-Requisitos:\n" +
            "\n" +
            "Ter acesso a internet;\n" +
            "Ter acesso ao APP Next;\n" +
            "Ter usuário e senha do Sistema de Gestão;\n" +
            "Ter arquivo excel gerado com base de voucher para cadastramento no Sistema de gestão.\n" +
            "Acessar o APP do Next, com CPF e senha;\n" +
            "Executar etapas de \"Meus cupons com cupom gerado\", com sucesso.\n" +
            " \n" +
            "Pós-Condições:\n" +
            "\n" +
            "Possuir cupom.;\n" +
            "Gerar código do voucher .")

    @Severity(SeverityLevel.NORMAL)

    public void QA00234() throws Exception {

        loginSistemaDeGestao.realizarLogin(ReadProperties.getGestaoUser(),ReadProperties.getGestaoPass(), ReadProperties.getAmbiente());

        menuSistemaDeGestao.clicarLinkMIMOS();

        menuMimosSistemaDeGestao.clicarLinkHub();

        menuHubSistemaDeGestao.clicarLinkOfertas();

        ofertasHubSistemaDeGestao.preencherInfoOferta(recuperarMassa("ofertaNome"),
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

        login.efetuarLoginUsuarioExistenteOuPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarMimos();

        mimos.avancarTutorialCasoExista();

        mimos.selecionarOfertaPorBusca(recuperarMassa("oferta"), recuperarMassa("texto"), true);

        mimos.retornarTelaCategoriaOuMimo();

        mimos.retornarCarrossel();

        mimos.retornarMenu();

        menu.selecionarMimos();

        mimos.selecionarOfertaPorBusca(recuperarMassa("oferta"), recuperarMassa("texto"), false);

        mimos.tocarIconeComoUsar();

        mimos.tocarBotaoGerarCupomDeDesconto(true);

        mimos.retornarTelaCategoriaOuMimo();

        mimos.tocarBotaoCopiarCodigoIrParaLoja(recuperarMassa("link"));

    }
}

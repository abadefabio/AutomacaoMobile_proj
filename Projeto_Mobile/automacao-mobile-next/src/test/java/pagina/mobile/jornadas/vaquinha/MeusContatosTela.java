package pagina.mobile.jornadas.vaquinha;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;

import constantes.vaquinha.Vaquinha;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MeusContatosTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/img_user_photo")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeImage['label == \"Foto\"']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[contains(@name,\"Selecionar.\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"Foto\"]")
    private MobileElement contatoCirculo;

    @iOSXCUITFindBy(accessibility = "Ag�ncia sem d�gito")
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_agency")
    private MobileElement agencia;

    //botao voltar
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement voltar;

    //botao confirmar envio
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_finish_select")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Adicionar contatos selecionados']")
    private MobileElement confirmarEnvio;

    //botao excluir contato
    @AndroidFindBy(id = "br.com.bradesco.next:id/rl_button_remove")
    private MobileElement botaoExcluir;

    //botao ok
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_ok")
    private MobileElement botaoOk;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "/*[contains(@text,'fechar')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Fechar\"]")
    private MobileElement botaoHeaderFechar;

    public MeusContatosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar o nome do contato no c�rculo do contato ap�s a pesquisa na barra de pesquisas
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar o primeiro contato presente na tela")
    public MeusContatosTela tocarPrimeiroContatoCirculo() throws Exception {
        salvarEvidencia("Tocar primeiro contato vis�vel na tela");
        tocarElemento(contatoCirculo, "N�o foi poss�vel tocar o contato no �cone do c�rculo.");
        return this;
    }

    /**
     * Tocar o nome do contato no c�rculo do contato ap�s a pesquisa na barra de pesquisas
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar o primeiro contato presente na tela")
    public MeusContatosTela validarContaSelecao(String agenciaP) throws Exception {
        aguardarCarregamentoElemento(agencia);
        salvarEvidencia("Tocar primeiro contato vis�vel na tela");
        return this;
    }

    /**
     * Clicar no campo voltar
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar botao voltar")
    public MeusContatosTela tocarVoltar() throws Exception {
        aguardarCarregamentoElemento(voltar);
        salvarEvidencia("Tocar botao voltar");
        tocarElemento(voltar, "N�o foi poss�vel clicar no bot�o voltar");
        return this;
    }

    /**
     * Clicar no campo Fechar
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Tocar botao confirmar")
    public MeusContatosTela confirmarEnviar() throws Exception {
        aguardarCarregamentoElemento(confirmarEnvio);
        salvarEvidencia("Tocar botao confirmar");
        tocarElemento(confirmarEnvio, "N�o foi poss�vel clicar no bot�o confirmar");
        return this;
    }

    /**
     * Manter pressionado o contato
     *
     * @return MeusContatosTela
     * @throws Exception
     */
    @Step("Manter pressionado contato")
    public MeusContatosTela manterPressionadoContato() throws NextException {
        aguardarCarregamentoElemento(contatoCirculo);
        salvarEvidencia("Manter pressionado contato");
        manterPressionado(contatoCirculo, 2000, "N�o foi poss�vel manter pressionado por 2 segundos o contato");
        return this;
    }

    /**
     * Clicar no bot�o excluir
     *
     * @return MeusContatosTela
     * @throws NextException
     */
    @Step("Tocar bot�o excluir")
    public MeusContatosTela tocarBotaoExcluir() throws NextException {
        aguardarCarregamentoElemento(botaoExcluir);
        salvarEvidencia("Tocar botao excluir");
        tocarElemento(botaoExcluir, "N�o foi poss�vel tocar no bot�o excluir");
        return this;
    }

    /**
     * Validar exibi��o da tela de 'Pronto t� deletado ;)'
     * @return MeusContatosTela
     */
    @Step("Validar exibi��o da tela de 'Pronto t� deletado ;)'")
    public MeusContatosTela validarTelaContatoDeletado(){
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(String.valueOf(Vaquinha.MENSAGEM_EXCLUSAO_CONTATO)),
                MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a exibi��o da tela 'Pronto, t� deletado ;)'");
        salvarEvidencia("Validou exibi��o da tela de 'Pronto, t� deletado ;)'");
        return this;
    }

    /**
     * Tocar no bot�o OK
     *
     * @return MeusContatosTela
     * @throws NextException
     */
    public MeusContatosTela tocarBotaoOk() throws NextException {
        aguardarCarregamentoElemento(botaoOk);
        salvarEvidencia("Tocar bot�o Ok");
        tocarElemento(botaoOk, "N�o foi poss�vel tocar no bot�o Ok");
        return this;
    }

    /**
     * Tocar no bot�o do 'header' Fechar (x)
     * @return MeusContatosTela
     * @throws NextException
     */
    @Step("Tocar no bot�o do 'header' Fechar (x)")
    public MeusContatosTela tocarBotaoHeaderFechar() throws NextException {
        salvarEvidencia("Tocar no bot�o do 'header' Fechar (x)");
        tocarElemento(botaoHeaderFechar,"Erro ao tocar no bot�o do 'header' Fechar (x)");
        return this;
    }

    /**
     * Verifica Existencia do Contato
     * @return boolean
     */
    @Step("Verifica Existencia do Contato")
    public boolean contatoCirculoExiste(){
        return verificarPresencaElemento(contatoCirculo);
    }
}

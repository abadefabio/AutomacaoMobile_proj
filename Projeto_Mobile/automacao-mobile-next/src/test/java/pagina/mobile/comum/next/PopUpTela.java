package pagina.mobile.comum.next;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PopUpTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_text")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_description")
    @AndroidFindBy(xpath = "//*[contains(@content-desc, 'Você atingiu o valor máximo pra recargas')]")
    private MobileElement mensagemPopUpAndroid;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_title")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntv_title")
    private MobileElement tituloPopUpAndroid;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_right")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_positive")
    @AndroidFindBy(xpath = "//*[contains(@text,'Sim')]")
    @AndroidFindBy(xpath = "//*[contains(@text,'SIM')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'SIM')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Sim\"]")
    private MobileElement botaoSim;

    @AndroidFindBy(xpath = "//*[@text='NÃO']")
    @iOSXCUITFindBy(xpath = "//*[@value='NÃO']")
    private MobileElement botaoNao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_ok")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_confirm")
    @AndroidFindBy(xpath = "//*[contains(@text,'OK')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='OK']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Ok! Valeu']")
    @iOSXCUITFindBy(accessibility = "OK, ENTENDI.")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'OK')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continuar no chat']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Editar valor']")
    private MobileElement botaoOk;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_ok")
    @AndroidFindBy(xpath = "//*[@text=\"EXCLUIR\"]")
    @iOSXCUITFindBy(accessibility = "Excluir")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Excluir']")
    private MobileElement botaoExcluir;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_cancel")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_negative")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Voltar']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name='Voltar'])[2]")
    private MobileElement botaoVoltar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_ok")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar no chat\"]")
    private MobileElement botaoPopUpContinuarNoChat;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_title")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Você já criou 5 vaquinhas')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Você já criou 5 vaquinhas')]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Você já criou 5 vaquinhas. Esse é o número máximo']")
    private MobileElement mensagemNumeroMaximoDeVaquinhas;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_title")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Contato criado com sucesso ;)')]")
    private MobileElement mensagemContatoCriadoComSucesso;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_title")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Contato atualizado com sucesso ;)')]")
    private MobileElement mensagemContatoAtualizadoComSucesso;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_title")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Tudo certo com seu pagamento')]")
    private MobileElement mensagemPagamentoVaquinhaComSucesso;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_title")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Email enviado com sucesso')]")
    private MobileElement mensagemEmailVaquinhaComSucesso;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_text")
    @AndroidFindBy(xpath = "//*[contains(@text, 'Você não vai mais')]")
    private MobileElement mensagemConviteRecusado;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_primary_button")
    @AndroidFindBy(xpath = "//*[contains(@text, 'SAIR DO NEXT')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'SAIR DO NEXT')]")
    private MobileElement botaoSairDoNext;

    @iOSXCUITFindBy(xpath = "//*[contains(@value, 'Pode terminar outra hora')]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_message_title")
    @iOSXCUITFindBy(xpath = "//*[contains(@text, 'Pode terminar outra hora')]")
    private MobileElement mensagemPodeTerminarOutraHora;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_ok")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Continuar']")
    private MobileElement botaoContinuar;

    public PopUpTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar mensagem exibida no popup
     *
     * @param textoEsperadoPopUp Mensagem a ser validada no PopUp
     * @return PopUpTela
     * @throws Exception
     */
    @Step("Validar mensagem exibida no popup")
    public PopUpTela validarMensagem(String textoEsperadoPopUp) throws Exception {
        esperarCarregando();
        if (android) {
            aguardarCarregamentoElemento(mensagemPopUpAndroid);
            compararElementoTexto(mensagemPopUpAndroid, textoEsperadoPopUp, MetodoComparacao.CONTEM);
        } else { // Em iOS Titulo e Textos estão concatenados no mesmo elemento.
            By mensagemPopUpIos = By.xpath(String.format("//*[contains(@value, '%s')]", textoEsperadoPopUp));
            aguardarCarregamentoElemento(mensagemPopUpIos);
            compararElementoTexto(mensagemPopUpIos, textoEsperadoPopUp, MetodoComparacao.CONTEM);
        }
        salvarEvidencia("Validada a exibição da mensagem: '" + textoEsperadoPopUp + "' no PopUp");
        return this;
    }

    /**
     * Validar título exibido no popup
     *
     * @param tituloEsperadoPopUp Título a ser validado no PopUp
     * @return PopUpTela
     * @throws Exception
     */
    @Step("Validar título exibido no popup")
    public PopUpTela validarTitulo(String tituloEsperadoPopUp) throws Exception {
        esperarCarregando();
        if (android) {
            aguardarCarregamentoElemento(tituloPopUpAndroid);
            compararElementoTexto(tituloPopUpAndroid, tituloEsperadoPopUp, MetodoComparacao.CONTEM);
        } else { // Em iOS Titulo e Textos estão concatenados no mesmo elemento.
            By tituloPopUpIos = By.xpath(String.format("//*[contains(@value, '%s')]", tituloEsperadoPopUp));
            aguardarCarregamentoElemento(tituloPopUpIos);
            compararElementoTexto(tituloPopUpIos, tituloEsperadoPopUp, MetodoComparacao.CONTEM);
        }
        salvarEvidencia("Validou exibição título: '" + tituloEsperadoPopUp + "' no PopUp");
        return this;
    }

    /**
     * Tocar botão 'Sim' do popup
     *
     * @return PopUpTela
     * @throws Exception
     */
    @Step("Tocar botão 'Sim'")
    public PopUpTela tocarBotaoSim() throws Exception {
        aguardarCarregamentoElemento(botaoSim);
        tocarElemento(botaoSim, "Não foi possível tocar no botão 'Sim'");
        salvarEvidencia("Tocar no botão 'Sim'");
        return this;
    }

    /**
     * Tocar botão 'Não' do popup
     *
     * @return PopUpTela
     * @throws Exception
     */
    @Step("Tocar botão 'Nao'")
    public PopUpTela tocarBotaoNao() throws Exception {
        aguardarCarregamentoElemento(botaoNao);
        salvarEvidencia("Tocar no botão 'Não'");
        tocarElemento(botaoNao, "Não foi possível tocar no botão 'Não'");
        return this;
    }

    /**
     * Tocar botão 'Ok' do popup
     *
     * @return PopUpTela
     * @throws Exception
     */
    @Step("Tocar botão 'Ok'")
    public PopUpTela tocarBotaoOk() throws Exception {
        aguardarCarregamentoElemento(botaoOk);
        salvarEvidencia("Tocar no botão 'Ok'");
        tocarElemento(botaoOk, "Não foi possível tocar no botão 'Ok'");
        return this;
    }

    /**
     * Tocar botão 'Excluir' do popup
     *
     * @return PopUpTela
     * @throws Exception
     */
    @Step("Tocar botão 'Excluir'")
    public PopUpTela tocarBotaoExcluir() throws Exception {
        aguardarCarregamentoElemento(botaoExcluir);
        salvarEvidencia("Tocar no botão 'Excluir'");
        tocarElemento(botaoExcluir, "Não foi possível tocar no botão 'Excluir'");
        return this;
    }

    /**
     * Tocar botão 'Voltar' do popup
     *
     * @return PopUpTela
     * @throws Exception
     */
    @Step("Tocar botão 'Voltar'")
    public PopUpTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Tocar no botão 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar'");
        return this;
    }

    /**
     * Tocar no botão: 'Continuar No Chat' do PopUp
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão: 'Continuar No Chat' do PopUp")
    public PopUpTela tocarBotaoPopUpContinuarNoChat() throws Exception {
        salvarEvidencia("Tocar no botão: 'Continuar No Chat' do PopUp");
        tocarElemento(botaoPopUpContinuarNoChat, "Erro ao tocar no botão do PopUp: 'Continuar No Chat'");
        return this;
    }

    /**
     * Validar mensagem exibida do contato criado com sucesso
     *
     * @param textoEsperadoPopUp
     * @return PopUpTela
     * @throws Exception
     */
    @Step("Validar mensagem exibida do contato criado com sucesso")
    public PopUpTela validarContatoCriadoComSucesso(String textoEsperadoPopUp) throws Exception {
        if (android) {
            aguardarCarregamentoElemento(mensagemContatoCriadoComSucesso);
            validarCondicaoBooleana(verificarPresencaElemento(mensagemContatoCriadoComSucesso), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar mensagem exibida do contato criado com sucesso");
        } else {
            By mensagemPopUpIos = By.xpath(String.format("//*[contains(@value, '%s')]", textoEsperadoPopUp));
            aguardarCarregamentoElemento(mensagemPopUpIos);
            compararElementoTexto(mensagemPopUpIos, textoEsperadoPopUp, MetodoComparacao.CONTEM);
        }
        salvarEvidencia("Validar mensagem exibida do contato criado com sucesso");
        return this;
    }

    /**
     * Validar mensagem exibida de pagamento feito com sucesso
     *
     * @param textoEsperadoPopUp
     * @return PopUpTela
     * @throws Exception
     */
    @Step("Validar mensagem exibida do pagamento da vaquinha com sucesso")
    public PopUpTela validarPagamentoVaquinhaFeitoComSucesso(String textoEsperadoPopUp) throws Exception {
        if (android) {
            aguardarCarregamentoElemento(mensagemPagamentoVaquinhaComSucesso);
            validarCondicaoBooleana(verificarPresencaElemento(mensagemPagamentoVaquinhaComSucesso), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar mensagem exibida do pagamento da vaquinha com sucesso");
        } else {
            By mensagemPopUpIos = By.xpath(String.format("//*[contains(@value, '%s')]", textoEsperadoPopUp));
            aguardarCarregamentoElemento(mensagemPopUpIos);
            compararElementoTexto(mensagemPopUpIos, textoEsperadoPopUp, MetodoComparacao.CONTEM);
        }
        salvarEvidencia("Validar mensagem exibida do contato criado do pagamento da vaquinha com sucesso");
        return this;
    }

    /**
     * Validar mensagem exibida de email de vaquinha enviado com sucesso
     *
     * @param textoEsperadoPopUp
     * @return PopUpTela
     * @throws Exception
     */
    @Step("Validar mensagem exibida de email de vaquinha enviado com sucesso")
    public PopUpTela validarEmailVaquinhaFeitoComSucesso(String textoEsperadoPopUp) throws Exception {
        if (android) {
            aguardarCarregamentoElemento(mensagemEmailVaquinhaComSucesso);
            validarCondicaoBooleana(verificarPresencaElemento(mensagemEmailVaquinhaComSucesso), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar mensagem exibida de email de vaquinha enviado com sucesso");
        } else {
            By mensagemPopUpIos = By.xpath(String.format("//*[contains(@value, '%s')]", textoEsperadoPopUp));
            aguardarCarregamentoElemento(mensagemPopUpIos);
            compararElementoTexto(mensagemPopUpIos, textoEsperadoPopUp, MetodoComparacao.CONTEM);
        }
        salvarEvidencia("Validar mensagem exibida de email de vaquinha enviado com sucesso");
        return this;
    }

    /**
     * Validar mensagem exibida do número máximo de vaquinhas criadas
     *
     * @param textoEsperadoPopUp
     * @return PopUpTela
     * @throws Exception
     */
    @Step("Validar mensagem exibida do número máximo de vaquinhas criadas")
    public PopUpTela validarNumeroMaximoDeVaquinhas(String textoEsperadoPopUp) throws Exception {
        aguardarCarregamentoElemento(mensagemNumeroMaximoDeVaquinhas);
        validarCondicaoBooleana(verificarPresencaElemento(mensagemNumeroMaximoDeVaquinhas), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a mensagem do número máximo de vaquinhas criadas");
        salvarEvidencia("Validar mensagem exibida do número máximo de vaquinhas criadas");
        return this;
    }

    /**
     * Validar mensagem exibida do contato atualizado com sucesso
     *
     * @param textoEsperadoPopUp
     * @return PopUpTela
     * @throws Exception
     */
    public PopUpTela validarContatoAtualizadoComSucesso(String textoEsperadoPopUp) throws Exception {
        if (android) {
            aguardarCarregamentoElemento(mensagemContatoAtualizadoComSucesso);
            validarCondicaoBooleana(verificarPresencaElemento(mensagemContatoAtualizadoComSucesso), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a mensagem do contato atualizado com sucesso");
        } else {
            By mensagemPopUpIos = By.xpath(String.format("//*[contains(@value, '%s')]", textoEsperadoPopUp));
            aguardarCarregamentoElemento(mensagemPopUpIos);
            compararElementoTexto(mensagemPopUpIos, textoEsperadoPopUp, MetodoComparacao.CONTEM);
        }
        salvarEvidencia("Validar mensagem exibida do contato atualizado com sucesso");
        return this;
    }

    /**
     * Validar mensagem exibida do convite recusado
     *
     * @param textoEsperadoPopUp
     * @return PopUpTela
     * @throws Exception
     */
    public PopUpTela validarRecusaDeConvite(String textoEsperadoPopUp) throws Exception {
        if (android) {
            aguardarCarregamentoElemento(mensagemConviteRecusado);
            validarCondicaoBooleana(verificarPresencaElemento(mensagemConviteRecusado), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a mensagem do convite recusado");
        } else {
            By mensagemPopUpIos = By.xpath(String.format("//*[contains(@value, '%s')]", textoEsperadoPopUp));
            aguardarCarregamentoElemento(mensagemPopUpIos);
            compararElementoTexto(mensagemPopUpIos, textoEsperadoPopUp, MetodoComparacao.CONTEM);
        }
        salvarEvidencia("Validar mensagem exibida do convite recusado");
        return this;
    }

    /**
     * Validar Popup 'Pode terminar outra hora'
     *
     * @return PopUpTela
     * @throws Exception
     */
    @Step("Validar Popup 'Pode terminar outra hora'")
    public PopUpTela validarPopupPodeTerminarOutraHora() throws Exception {
        salvarEvidencia("Validar Popup 'Pode terminar outra hora'");
        validarCondicaoBooleana(verificarPresencaElemento(mensagemPodeTerminarOutraHora), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a mensagem do Popup: 'Pode terminar outra hora'");
        return this;
    }

    /**
     * Tocar no botão: 'Sair do Next'
     *
     * @return PopUpTela
     * @throws Exception
     */
    @Step("Tocar no botão: 'Sair do Next'")
    public PopUpTela tocarBotaoSairDoNext() throws Exception {
        salvarEvidencia("Tocar no botão: 'Sair do Next'");
        tocarElemento(botaoSairDoNext, "Tocar no botão: 'Sair do Next'");
        return this;
    }

    /**
     * Tocar botão 'Continuar' do popup
     *
     * @return PopUpTela
     * @throws Exception
     */
    @Step("Tocar botão 'Continuar'")
    public PopUpTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("Tocar no botão 'Continuar'");
        tocarElemento(botaoContinuar, "Não foi possível tocar no botão 'Continuar'");
        return this;
    }
}

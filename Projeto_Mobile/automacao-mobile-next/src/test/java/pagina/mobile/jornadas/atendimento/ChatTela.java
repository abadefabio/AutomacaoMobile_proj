package pagina.mobile.jornadas.atendimento;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.atendimento.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.List;

import static java.util.Objects.isNull;

public class ChatTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @AndroidFindBy(accessibility = "CHAT")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,'CHAT')]")
    private MobileElement tituloTelaChat;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(accessibility = "Voltar, Botão")
    @iOSXCUITFindBy(accessibility = "Voltar para o Menu")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Voltar para o Menu']")
    private MobileElement botaoVoltarAoMenu;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_msg")
    @AndroidFindBy(accessibility = "Digite sua mensagem")
    @iOSXCUITFindBy(accessibility = "Digite sua mensagem")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Digite sua mensagem\"`]")
    private MobileElement campoMensagem;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_send")
    @AndroidFindBy(accessibility = "Enviar mensagem")
    @iOSXCUITFindBy(iOSClassChain = "Enviar")
    @iOSXCUITFindBy(xpath = "**/XCUIElementTypeButton[`label == 'Enviar'`]")
    private MobileElement iconeEnviar;

    //ToDo: Não foi feito o mapeamento no iOS pois temos um bug aberto para o código do Deeplink que não esta aparecendo o link.
    //ToDo: Não foi feito o mapeamento no Android, existe um locator mas ele não é especifico para o link.
    private MobileElement linkCartaoDeCredito;

    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/nl_message\" and @text = \"Oi, eu sou a BIA, a inteligência artificial do next. Pra te ajudar, eu preciso que você me envie o número da opção que quer tratar :) 1 - Pix 2 - Cartão next 3 - Crédito e limites 4 - Serviços bancários 5 - Investimentos 6 - Nenhuma acima\"]")
    @iOSXCUITFindBy(accessibility = "Oi, eu sou a BIA, a inteligência artificial do next. Pra te ajudar, eu preciso que você me envie o número da opção que quer tratar :) 1 - Pix 2 - Cartão next 3 - Crédito e limites 4 - Serviços bancários 5 - Investimentos 6 - Nenhuma acima")
    private MobileElement chatApresentacaoBia;

    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/nl_message\" and @text = \"Sem problemas! Digita então, resumidamente e em apenas uma mensagem, o que você precisa. Ah! Eu consigo entender melhor se você esperar eu responder antes de enviar outra mensagem ;)\"]")
    @iOSXCUITFindBy(accessibility = "Sem problemas! Digita então, resumidamente e em apenas uma mensagem, o que você precisa. Ah! Eu consigo entender melhor se você esperar eu responder antes de enviar outra mensagem ;)")
    private MobileElement chatSemProblemas;

    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/nl_message\" and @text = \"Escolha um NÚMERO: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ou 11.\"]")
    @iOSXCUITFindBy(accessibility = "Escolha um NÚMERO: 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 ou 11.")
    private MobileElement chatEscolhaUmNumero;

    @AndroidFindBy(xpath = "//*[@resource-id = \"br.com.bradesco.next:id/toolbar_subtitle\" and @text = \"Conversando com BIA\"]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label == \"CHAT ? Conversando com BIA\"`]")
    private MobileElement conversandoComBia;

    // botao INICIAR CHAT
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_start_chat")
    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc,\"INICIAR CHAT\")]")
    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"SIM, IR PARA O CHAT\"]")
    @iOSXCUITFindBy(accessibility = "INICIAR CHAT\n")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"INICIAR CHAT\"]")
    private MobileElement botaoIniciarChat;

    @AndroidFindBy(id = "br.com.bradesco.next:id/lav_loading")
    private MobileElement ampulheta;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_positive")
    private MobileElement botaoVerHistorico;

    @AndroidFindBy(xpath = "(//android.widget.Button)[last()]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"Outros assuntosBotão\"])[last()]")
    private MobileElement botaoOutrosAssuntos;

    public ChatTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar presença da tela 'Chat'
     *
     * @return ChatTela
     * @throws Exception
     */
    @Step("Validar presença da tela 'Chat'")
    public ChatTela validarTelaChat() throws Exception {
        aguardarCarregamentoElemento(tituloTelaChat);
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CHAT), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Chat' não está presente na tela!");
        salvarEvidencia("Validada presença da tela 'Chat'");
        return this;
    }

    /**
     * Tocar botão 'Voltar ao Menu'
     *
     * @return ChatTela
     * @throws Exception
     */
    @Step("Tocar botão 'Voltar ao Menu'")
    public ChatTela tocarBotaoVoltarAoMenu() throws Exception {
        salvarEvidencia("Tocar botão 'Voltar ao Menu'");
        tocarElemento(botaoVoltarAoMenu, "Não foi possivel tocar no botão 'Voltar ao Menu'");
        return this;
    }

    /**
     * Tocar botao "INICIAR CHAT"
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao \"INICIAR CHAT\"")
    public ChatTela tocarIniciarChat() throws Exception {
        aguardarOcultacaoElemento(ampulheta);
        salvarEvidencia("Tocar no botao \"INICIAR CHAT\"");
        tocarElemento(botaoIniciarChat, "Não foi possível tocar no botao \"INICIAR CHAT\"");
        return this;
    }

    /**
     * Tocar icone 'Enviar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar icone 'Enviar'")
    public ChatTela tocarIconeEnviar() throws Exception {
        salvarEvidencia("Tocar icone 'Enviar'");
        // o elemento abaixo foi empacotado no retornaElemento() para evitar um problema de stale reference
        // que poderia ocorrer com este elemento específico
        tocarElemento(retornaElemento(iconeEnviar), "Não foi possível tocar no icone 'Enviar'");
        return this;
    }

    /**
     * Preencher o campo 'Mensagem'
     *
     * @param mensagem
     * @return
     * @throws Exception
     */
    @Step("Preencher o campo 'Mensagem'")
    public ChatTela preencherCampoMensagem(String mensagem) throws Exception {
        tocarElemento(campoMensagem, "Não foi possível tocar no campo 'Mensagem'");
        escreverTexto(campoMensagem, mensagem, "Não foi possivel preencher o campo 'Mensagem' com: " + mensagem);
        salvarEvidencia("Preenchido campo 'Mensagem' com : " + mensagem);
        return this;
    }

    /**
     * Retorna elemento do chat com texto solicitado (exemplo, para retornar deeplink)
     * @param textoLink
     * @throws Exception
     */
    private MobileElement retornaElementoChatDeeplinkAndroid(String textoLink) throws Exception {
        MobileElement chatRetornado = null;
        List<MobileElement> chats;
        int maxRolagensChat = 10;
        externo: while (maxRolagensChat > 0) {
            chats = retornarLista(By.id("br.com.bradesco.next:id/nl_message"),
                    "Não deve haver nenhuma mensagem de chat nesta tela.");
            for (MobileElement chat : chats) {
                String textoChat = chat.getText();
                if (isNull(textoChat))
                    break;
                if (textoChat.trim().equals(textoLink.trim())) {
                    chatRetornado = chat;
                    break externo;
                }
            }
            rolarTela(0.4, 0.7);
            maxRolagensChat--;
        }
        return chatRetornado;
    }

    /**
     * Tocar deeplink
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar deeplink'")
    public ChatTela tocarDeeplink(String textoLink) throws Exception {
        By locator = null;
        if(ios) {
            //TODO Não foi realizado o mapeamento do elemento em IOS, pois  o deeplink não está aparecendo ao informar o código, aguardando instruções do focal para definir se é um erro em IOS
        } else {
            locator = new By.ByXPath("//android.view.View[@content-desc=\"usuário\"]/..//me.next.uikit.NextLabel[@resource-id = \"br.com.bradesco.next:id/nl_message\" and contains(@text, '"+textoLink+"')]");
        }
        rolarTelaParaCimaAosPoucosAteEncontrarElemento(locator, "Não foi possível encontrar a mensagem com o deeplink: " + textoLink);
        salvarEvidencia("Tocar no link: "  + textoLink);
        aguardarCarregamentoElemento(locator);
        tocarElemento(locator, "Não foi possível tocar no link: " + textoLink);
        return this;
    }

    /**
     * Validar chat 'Apresentacao Bia'
     *
     * @throws Exception
     */
    @Step("Validar chat 'Apresentacao Bia'")
    public ChatTela validarChatApresentacaoBia() throws Exception{
        aguardarCarregamentoElemento(chatApresentacaoBia);
        salvarEvidencia("Validando chat 'Apresentacao Bia'");
        return this;
    }

    /**
     * Validar chat 'Sem problemas'
     *
     * @throws Exception
     */
    @Step("Validar chat 'Sem problemas'")
    public ChatTela validarChatSemProblemas() throws Exception{
        aguardarCarregamentoElemento(chatSemProblemas);
        salvarEvidencia("Validando chat 'Sem problemas'");
        return this;
    }

    /**
     * Validar chat 'Escolha um numero'
     *
     * @throws Exception
     */
    @Step("Validar chat 'Escolha um numero'")
    public ChatTela validarChatEscolhaUmNumero() throws Exception{
        aguardarCarregamentoElemento(chatEscolhaUmNumero);
        salvarEvidencia("Validando chat 'Escolha um numero'");
        return this;
    }

    /**
     * Validar 'Conversando com Bia'
     *
     * @throws Exception
     */
    @Step("Validar 'Conversando com Bia'")
    public ChatTela validarConversandoComBia() throws Exception{
        aguardarCarregamentoElemento(conversandoComBia);
        salvarEvidencia("Validando 'Conversando com Bia'");
        return this;
    }

    /**
     *
     * @return
     * @throws NextException
     */
    @Step("Validar ''Ver Histórico'")
    public ChatTela tocarBotaoVerHistoricoSeExistir() throws NextException {
        aguardarOcultacaoElemento(ampulheta);
        if(aguardarCarregamentoElemento(botaoVerHistorico)){
            salvarEvidencia("tocar botão: 'Ver Historico'");
            tocarElemento(botaoVerHistorico,"Erro ao tocar no botão 'Ver Historico'");
        }
        return this;
    }

    /**
     * Tocar botao 'Outros Assuntos'
     *
     *
     * @throws Exception
     */
    @Step("Tocar botao 'Outros Assuntos'")
    public ChatTela tocarOutrosAssuntos() throws Exception {
        salvarEvidencia("Tocar no botao 'Outros Assuntos'");
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoOutrosAssuntos, "Não foi possível encontrar o botao 'Outros Assuntos'");
        tocarElemento(botaoOutrosAssuntos, "Não foi possível tocar no botao 'Outros Assuntos'");
        return this;
    }
}



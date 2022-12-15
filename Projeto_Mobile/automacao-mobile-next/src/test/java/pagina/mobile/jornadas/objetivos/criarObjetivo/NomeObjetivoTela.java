package pagina.mobile.jornadas.objetivos.criarObjetivo;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class NomeObjetivoTela extends PaginaBase {

    //campo nome do objetivo  - OBS para este caso especifico teve que deixar 3 mapeamentos p/ IOS
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_goal")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField")
    @iOSXCUITFindBy(xpath = "//*[@name=\"Agora, dê um nome pra ele.\"]/following-sibling::XCUIElementTypeTextField")
    private MobileElement nomeObjetivo;

    //botao Continuar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_continue")
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_continue_value")
    @iOSXCUITFindBy(accessibility = "Continuar")
    private MobileElement botaoContinuar;


    //texto Tela De um nome para objetivo
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_goal")
    @AndroidFindBy(xpath = "//*[@text=\"Agora, dê um nome pra ele.\"]")
    @iOSXCUITFindBy(accessibility = "Agora, dê um nome pra ele.")
    private MobileElement textoTelaDeUmNome;

    // msg de alerta campo nome
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_msg_alert")
    @iOSXCUITFindBy(accessibility = "Ops, caractere inválido!")
    private MobileElement msgAlertaNomeInvalido;

    public NomeObjetivoTela(AppiumDriver driver) {
        super(driver);
    }


    /**
     * Preencher nome do objetivo
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher nome  \"Objetivo\"")
    public NomeObjetivoTela preencherNomeObjetivo(String nome) throws Exception {
        OperadorEvidencia.logarPasso("preenchendo o nome do objetivo: " + nome);
        aguardarCarregamentoElemento(nomeObjetivo);
        apagarCampoTexto(nomeObjetivo,"erro ao tentar apagar o texto");
        escreverTexto(nomeObjetivo, nome, "Erro ao preenher nome do objetivo.");
        salvarEvidencia("'Preencheu o nome do objetivo': "+ nome);
        return this;
    }

    /**
     * Tocar botao Continuar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Continuar\"")
    public NomeObjetivoTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        salvarEvidencia("'clicar botao continuar'");
        tocarElemento(botaoContinuar, "Erro ao clicar botao continuar");
        return this;
    }

    /**
     * validar texto da tela De um nome
     *
     * @return
     * @throws Exception
     */
    @Step("validar texto de um \"Nome\"")
    public NomeObjetivoTela validarTextoTelaNome(String texto) throws Exception {
        aguardarCarregamentoElemento(textoTelaDeUmNome);
        salvarEvidencia("'Validando texto da tela: Agora, dê um nome pra ele.'");
        esconderTeclado();
        validarAtributoTexto(textoTelaDeUmNome, texto,"erro ao validar o texto em tela Agora, de um nome pra ele." );
        return this;
    }

    /**
     * validar Alerta da tela em nome
     *
     * @return
     * @throws Exception
     */
    @Step("validar alerta \"Nome\"")
    public NomeObjetivoTela validarAlertaNomeInvalido(String alerta) throws Exception {
        aguardarCarregamentoElemento(msgAlertaNomeInvalido);
        salvarEvidencia("'Validando alerta de caracter invalido no nome:'");
        validarAtributoTexto(msgAlertaNomeInvalido, alerta,"erro ao validar alerta no nome." );
        return this;
    }

}

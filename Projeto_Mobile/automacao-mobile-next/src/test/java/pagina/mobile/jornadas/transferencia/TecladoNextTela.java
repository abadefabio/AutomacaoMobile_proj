package pagina.mobile.jornadas.transferencia;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import java.util.Arrays;

public class TecladoNextTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_prosseguir")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"IR PARA AJUSTES\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@contains(@text,'AJUSTES')]")
    private MobileElement okTecladoNext;

    @AndroidFindBy(id = "br.com.bradesco.next:id/textView1")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage/following-sibling::XCUIElementTypeStaticText")
    private MobileElement textoTecladoNext;

    @AndroidFindBy(id = "android:id/content")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"Ajustes\"]")
    private MobileElement elementoTelaTecladoVirtual;

    @AndroidFindBy(accessibility = "Navegar para")
    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navegar para\"]")
    private MobileElement botaoHeaderVoltarEmGerenciarTeclados;


    public TecladoNextTela(AppiumDriver driver) {
        super(driver);
    }

    public MobileElement getOkTecladoNext() {
        return okTecladoNext;
    }

    @Step("Passar tela de seleção do teclado next")
    public TecladoNextTela aceitarTecladoNext () throws Exception {

        String[] textosBotoes = new String[]{"mim", "Outra"};
        esperarCarregando();
        String textoEncontrado = aguardarPaginaConterQualquerTexto(textosBotoes[0], textosBotoes[1], "Ajustes", "Teclado Next", "AJUSTES");
        if (Arrays.asList(textosBotoes).contains(textoEncontrado))
            return this;

        if(aguardarCarregamentoElemento(okTecladoNext)){
            tocarElemento( okTecladoNext, "não foi possível aceitar o teclado next" );
            aguardarCarregamentoElemento(elementoTelaTecladoVirtual);

            textoEncontrado = aguardarPaginaConterQualquerTexto(textosBotoes[0], textosBotoes[1]);
            if (!Arrays.asList(textosBotoes).contains(textoEncontrado)) {
                if (android) {
                    voltarTelaAnterior();
                } else {
                    voltarAppIos();
                }
            }
            tocarElementoSeExistir(botaoHeaderVoltarEmGerenciarTeclados,"Erro ao tocar no Botão Voltar (Header)");
        }
        return this;
    }

    public Integer obterElementoCarregado(MobileElement... elementos) {
        return verificarPresencaQualquerElemento(elementos);
    }

}

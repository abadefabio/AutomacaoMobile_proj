package pagina.mobile.jornadas.depositos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ConferenciaTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/ic_pen_date_value")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"DATA\"]/parent::XCUIElementTypeOther/following-sibling::XCUIElementTypeButton")
    private MobileElement botaoEditarData;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ll_date")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[not(contains(@name, \"Fechar\") or contains(@name, \"Confirmar\"))]")
    private MobileElement botaoDataEdicao;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id = \"br.com.bradesco.next:id/title_month_current\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"mês\")]")
    private MobileElement labelMesAgenda;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_confirm")
    @iOSXCUITFindBy(accessibility = "Tudo certo")
    private MobileElement botaoTudoCerto;

    public ConferenciaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botão editar data
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Editar data\"")
    public ConferenciaTela tocarBotaoEditarData() throws Exception {
        aguardarCarregamentoElemento(botaoEditarData);
        salvarEvidencia("Clicar botão 'Editar Data'");
        tocarElemento(botaoEditarData,"Não foi possível clicar botão 'Editar data'");
        return this;
    }

    /**
     * Clicar botão 'Tudo Certo'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Tudo Certo\"")
    public ConferenciaTela tocarBotaoTudoCerto() throws Exception {
        aguardarCarregamentoElemento(botaoTudoCerto);
        salvarEvidencia("Clicar botão 'Tudo Certo'");
        tocarElemento(botaoTudoCerto,"Não foi possível clicar botão 'Tudo Certo'");
        return this;
    }
}

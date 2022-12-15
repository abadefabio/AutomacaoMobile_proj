package pagina.mobile.jornadas.investimentos.aplicacao;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class EditarAplicacaoTela extends AplicacaoTela {

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_remove")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='Remover']")
    private MobileElement botaoExcluir;

    public EditarAplicacaoTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar no botão 'Excluir' aplicação
     *
     * @return EditarAplicacaoTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Excluir' aplicação")
    public EditarAplicacaoTela tocarBotaoExcluirAplicacao() throws Exception {
        aguardarElementoHabilitado(botaoExcluir);
        salvarEvidencia( "Tocar no botão 'Excluir' aplicação");
        tocarElemento(botaoExcluir, "Nao foi possivel tocar no botão 'Excluir' aplicação");
        return this;
    }
}

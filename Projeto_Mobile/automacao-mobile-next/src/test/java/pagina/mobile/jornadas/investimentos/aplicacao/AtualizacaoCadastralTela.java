package pagina.mobile.jornadas.investimentos.aplicacao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class AtualizacaoCadastralTela extends PaginaBase {

    public AtualizacaoCadastralTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_my_data_remains")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Meus dados continuam iguais']")
    private MobileElement botaoMeusDadosContinuamIguais;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_update_my_data")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Atualizar meus dados']")
    private MobileElement botaoAtualizarMeusDados;

    /**
     * Tocar no botão 'Meus dados continuam iguais'
     *
     * @return AtualizacaoCadastralTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Meus dados continuam iguais'")
    public AtualizacaoCadastralTela tocarBotaoMeusDadosContinuamIguais() throws Exception {
        salvarEvidencia( "Tocar botão 'Meus dados continuam iguais'");
        tocarElemento(botaoMeusDadosContinuamIguais, "Não foi possivel tocar no botao 'Meus dados continuam iguais'");
        return this;
    }
}

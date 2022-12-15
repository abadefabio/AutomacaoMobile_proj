package pagina.mobile.jornadas.pix.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CpfCnpjTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(className = "android.widget.EditText")
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_pix_cpf_cnpj")
    @iOSXCUITFindBy(iOSNsPredicate = "type == \"XCUIElementTypeTextField\"")
    private MobileElement campoCpfCnpj;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_continue_keyboard")
    @iOSXCUITFindBy(accessibility = "OK")
    private MobileElement botaoOk;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nbt_advance")
    @iOSXCUITFindBy(accessibility = "AVAN�AR")
    private MobileElement botaoAvancar;

    public CpfCnpjTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Preencher o campo 'CPF/CNPJ'
     *
     * @param valor valor a ser preenchido
     * @return
     * @throws Exception
     */
    @Step("Preencher o campo CPF/CNPJ")
    public CpfCnpjTela preencherCpfCnpj(String valor) throws Exception {
        if(ios)
            escreverTexto(campoCpfCnpj, valor,false,"N�o foi poss�vel preencher a chave PIX " + valor + ".");
        else
            digitarTexto(campoCpfCnpj, valor);
        salvarEvidencia("Informada a chave Pix para transfer�ncia.");
        return this;
    }

    /**
     * Tocar no bot�o OK ap�s preencher a chave
     *
     * @return CpfCnpjTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'OK'")
    public CpfCnpjTela tocarBotaoOk() throws NextException {
        aguardarCarregamentoElemento(botaoOk);
        salvarEvidencia("Tocar no bot�o 'OK'.");
        tocarElemento(botaoOk, "N�o foi poss�vel tocar no bot�o 'OK'.");
        return this;
    }

    /**
     * Tocar no bot�o 'Avan�ar'
     *
     * @return CpfCnpjTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Avan�ar'")
    public CpfCnpjTela tocarBotaoAvancar() throws NextException {
        salvarEvidencia("Tocar bot�o 'Avan�ar'");
        tocarElemento(botaoAvancar, "N�o foi poss�vel tocar no bot�o 'Avan�ar'");
        return this;
    }
}

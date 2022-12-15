package pagina.mobile.jornadas.recarga.resumo;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.recarga.ValorRecarga;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class EscolhaValorTela extends PaginaBase {

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"Escolha o valor\"])[2]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Escolha o valor\"]")
    private MobileElement tituloEscolhaOValor;

    @AndroidFindBy( id = "br.com.bradesco.next:id/tv_value")
    @iOSXCUITFindBy(xpath= "//XCUIElementTypeApplication[@name=\"next\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypePicker/XCUIElementTypePickerWheel")
    private MobileElement recarga;

    public EscolhaValorTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Selecionar Valor da Recarga
     * @return
     * @throws Exception
     */
    @Step("Selecionar Valor da Recarga")
    public EscolhaValorTela selecionarValorRecarga(String valor) throws Exception {
        MobileElement valorDaRecarga = retornarElemento((android ?
                        By.xpath("//android.view.View[contains(@content-desc,\"" + valor + "\")]") :
                        By.xpath("//XCUIElementTypeStaticText[contains(@name,\"" + valor + "\")]"))
                ,"Erro ao retornar o de Valor da Recarga");
        tocarElemento(valorDaRecarga,"Erro ao tocar no valor : '" + valor + "' (Valor da Recarga)");
        salvarEvidencia("Tocou no valor '" + valor + "' (Valor da Recarga)");
        return this;
    }

    /**
     * Selecionar Valor da Recarga
     * @return
     * @throws Exception
     */
    @Step("Selecionar Valor da Recarga")
    public EscolhaValorTela selecionarValorRecarga(ValorRecarga valorRecarga) throws Exception {
        By elemento = null;
        if (android) {
            elemento = By.xpath("//android.view.View[contains(@content-desc, '" + valorRecarga +"')]");
        } else {
            elemento = By.xpath("//XCUIElementTypeStaticText[contains(@name, '" + valorRecarga +"')]");
        }
        salvarEvidencia( "Selecionar Valor Recarga" + valorRecarga);
        tocarElemento( elemento, "Não foi possível selecionar Valor da Recarga" + valorRecarga);
        return this;
    }

    /**
     * Validar a exibição ta tela 'Escolha o valor'
     * @return
     */
    @Step("Validar a exibição ta tela 'Escolha o Valor'")
    public EscolhaValorTela validarExibicaoEscolherValorTela(){
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloEscolhaOValor),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar a exibição da tela de Escolha o Valor");
        salvarEvidencia("validar exibição da tela de Escolha o Valor");
        return this;
    }

}

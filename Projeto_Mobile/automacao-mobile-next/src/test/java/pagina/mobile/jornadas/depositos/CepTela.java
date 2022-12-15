package pagina.mobile.jornadas.depositos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import constantes.depositos.saques.DepositosSaques;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class CepTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_cep")
    @iOSXCUITFindBy(accessibility = "Buscar")
    private MobileElement textoCep;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_apply")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_cep")
    @iOSXCUITFindBy(accessibility = "CEP")
    private MobileElement botaoCep;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_apply")
    @iOSXCUITFindBy(accessibility = "Confirmar")
    private MobileElement botaoConfirmarCantoSuperior;

    public CepTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar em Confirmar
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Confirmar\"")
    public CepTela tocarBotaoConfirmar() throws Exception {
        aguardarCarregamentoElemento(botaoConfirmar);
        salvarEvidencia("Clicar em 'Confirmar'");
        tocarElemento(botaoConfirmar, "Não foi possível clicar  em Confirmar");
        return this;
    }

    /**
     * Método para escrever o CEP - Padrão
     *
     * @return CepTela
     * @throws Exception
     */
    @Step("Escrever  \"CEP\"")
    public CepTela escreverCep() throws Exception {
        escreverCep(DepositosSaques.CEP.toString());
        return this;
    }

    /**
     * Método para escrever o CEP
     *
     * @param cep via Json
     * @return CepTela
     * @throws Exception
     */
    @Step("Escrever  \"CEP\"")
    public CepTela escreverCep(String cep) throws Exception {
        escreverTexto(textoCep, cep, "Não foi possível escrever o cep");
        salvarEvidencia("Escrever campo 'CEP' com: " + cep);
        return this;
    }

    /**
     * Clicar botão 'Cep'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Cep\"")
    public CepTela tocarBotaoCep() throws Exception {
        aguardarCarregamentoElemento(botaoCep);
        salvarEvidencia("Clicar botão 'Cep'");
        tocarElemento(botaoCep, "Não foi possível clicar botão 'Cep'");
        return this;
    }

    /**
     * Clicar em Confirmar no canto superior direito tela
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Confirmar no canto superior direito\"")
    public CepTela tocarBotaoConfirmarCantoSuperior() throws Exception {
        aguardarCarregamentoElemento(botaoConfirmarCantoSuperior);
        salvarEvidencia("Clicar em 'Confirmar'");
        tocarElemento(botaoConfirmarCantoSuperior, "Não foi possível clicar  em confirmar no canto superior da tela");
        return this;
    }
}

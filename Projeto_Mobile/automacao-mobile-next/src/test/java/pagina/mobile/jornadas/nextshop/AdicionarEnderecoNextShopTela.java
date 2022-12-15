package pagina.mobile.jornadas.nextshop;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class AdicionarEnderecoNextShopTela extends PaginaBase {

    public AdicionarEnderecoNextShopTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"CEP, \"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"CEP\")]")
    @iOSXCUITFindBy(accessibility = "CEP\\nCEP")
    private MobileElement inserirCep;

    @AndroidFindBy(accessibility = "Endere\u00e7o, ")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Endere\u00E7o\")]")
    @iOSXCUITFindBy(accessibility = "Endereço\\nEndereço")
    private MobileElement inserirEndereco;

    @AndroidFindBy(accessibility = "N\u00famero, ")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"N\u00FAmero\")]")
    @iOSXCUITFindBy(accessibility = "Número\\nNúmero")
    private MobileElement inserirNumero;

    @AndroidFindBy(accessibility = "Complemento, ")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Complemento\")]")
    @iOSXCUITFindBy(accessibility = "Complemento\\nComplemento")
    private MobileElement inserirComplemento;

    @AndroidFindBy(accessibility = "Bairro, ")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Bairro\")]")
    @iOSXCUITFindBy(accessibility = "Bairro\\nBairro")
    private MobileElement inserirBairro;

    @AndroidFindBy(accessibility = "Nome do destinat\u00e1rio, ")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"NOme do destinat\u00E1rio\")]")
    @iOSXCUITFindBy(accessibility = "Destinatário\\nDestinatário")
    private MobileElement inserirDestinatario;

    @AndroidFindBy(accessibility = "Telefone, ")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains(@name,\"Telefone\")]")
    @iOSXCUITFindBy(accessibility = "Telefone\\nTelefone")
    private MobileElement inserirTelefone;

    @AndroidFindBy(accessibility = "salvar Bot\u00e3o")
    @iOSXCUITFindBy(accessibility = "salvar Bot\u00e3o")
    private MobileElement botaoSalvar;

    @AndroidFindBy(accessibility = "\"cancelar Bot\\u00e3o\"")
    @iOSXCUITFindBy(accessibility = "\"cancelar Bot\\u00e3o\"")
    private MobileElement botaoCancelar;

    /**
     * Preencher campo CEP
     *
     * @return AdicionarEnderecoMarketplace
     * @throws Exception
     */
    @Step("Preencher campo \"CEP\"")
    public AdicionarEnderecoNextShopTela preencheCampoCEP(String cep) throws Exception {
        aguardarCarregamentoElemento(inserirCep);
        tocarElemento(inserirCep, "Não possível tocar no elemento" + inserirCep);
        inserirCep.setValue(cep);
        salvarEvidencia("Preencher campo 'CEP' com: " + cep);
        return this;
    }

    /**
     * Preencher campo Endereço
     *
     * @return AdicionarEnderecoMarketplace
     * @throws Exception
     */
    @Step("Preencher campo \"Endereço\"")
    public AdicionarEnderecoNextShopTela preencheCampoEnderco(String endereco) throws Exception {
        tocarElemento(inserirEndereco, "Não possível tocar no elemento" + inserirEndereco);
        inserirEndereco.sendKeys(endereco);
        if (android){
            ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        }
        else if(ios){
            tocarBotaoENTERTeclado(inserirCep, "Não foi possível encerrar o teclado iOS.");
        }
        salvarEvidencia("Preencher campo 'Endereço' com: " + endereco);
        return this;
    }

    /**
     * Preencher campo Número
     *
     * @return AdicionarEnderecoMarketplace
     * @throws Exception
     */
    @Step("Preencher campo \"Número\"")
    public AdicionarEnderecoNextShopTela preencheCampoNumero(String numero) throws Exception {
        tocarElemento(inserirNumero, "Não possível tocar no elemento" + inserirNumero);
        inserirNumero.sendKeys(numero);
        if (android){
            ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        }
        else if(ios){
            tocarBotaoENTERTeclado(inserirCep, "Não foi possível encerrar o teclado iOS.");
        }
        salvarEvidencia("Preencher campo 'Número' com: " + numero);
        return this;
    }

    /**
     * Preencher campo Complemento
     *
     * @return AdicionarEnderecoMarketplace
     * @throws Exception
     */
    @Step("Preencher campo \"Complemento\"")
    public AdicionarEnderecoNextShopTela preencheCampoComplemento(String complemento) throws Exception {
        tocarElemento(inserirComplemento, "Não possível tocar no elemento" + inserirComplemento);
        inserirComplemento.sendKeys(complemento);
        if (android){
            ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        }
        else if(ios){
            tocarBotaoENTERTeclado(inserirCep, "Não foi possível encerrar o teclado iOS.");
        }
        salvarEvidencia("Preencher campo 'Complemento' com: " + complemento);
        return this;
    }

    /**
     * Preencher campo Bairro
     *
     * @return AdicionarEnderecoMarketplace
     * @throws Exception
     */
    @Step("Preencher campo \"Bairro\"")
    public AdicionarEnderecoNextShopTela preencheCampoBairro(String bairro) throws Exception {
        tocarElemento(inserirBairro, "Não possível tocar no elemento" + inserirBairro);
        inserirBairro.sendKeys(bairro);
        if (android){
            ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        }
        else if(ios){
            tocarBotaoENTERTeclado(inserirCep, "Não foi possível encerrar o teclado iOS.");
        }
        salvarEvidencia("Preencher campo 'Bairro' com: " + bairro);
        return this;
    }

    /**
     * Preencher campo Destinatario
     *
     * @return AdicionarEnderecoMarketplace
     * @throws Exception
     */
    @Step("Preencher campo \"Destinatario\"")
    public AdicionarEnderecoNextShopTela preencheCampoDestinatario(String destinatario) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(inserirDestinatario, "Não foi possível encontrar o campo de Destinatário.");
        tocarElemento(inserirDestinatario, "Não possível tocar no elemento" + inserirDestinatario);
        inserirDestinatario.sendKeys(destinatario);
        if (android){
            ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        }
        else if(ios){
            tocarBotaoENTERTeclado(inserirCep, "Não foi possível encerrar o teclado iOS.");
        }
        salvarEvidencia("Preencher campo 'Destinatario' com: " + destinatario);
        return this;
    }

    /**
     * Preencher campo Telefone
     *
     * @return AdicionarEnderecoMarketplace
     * @throws Exception
     */
    @Step("Preencher campo \"Telefone\"")
    public AdicionarEnderecoNextShopTela preencheCampoTelefone(String telefone) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(inserirTelefone, "Não foi possível encontrar o campo de Telefone.");
        tocarElemento(inserirTelefone, "Não possível tocar no elemento" + inserirTelefone);
        inserirTelefone.sendKeys(telefone);
        if (android){
            ((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
        }
        else if(ios){
            tocarBotaoENTERTeclado(inserirCep, "Não foi possível encerrar o teclado iOS.");
        }
        salvarEvidencia("Preencher campo 'Telefone' com: " + telefone);
        return this;
    }

    /**
     * Realiza o toque no botão salvar.
     *
     * @return AdicionarEnderecoMarketplace
     * @throws Exception
     */
    @Step("Tocar botão \"Salvar\"")
    public AdicionarEnderecoNextShopTela tocarBotaoSalvar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoSalvar, "Não foi possível encontrar o botão Salvar.");
        aguardarCarregamentoElemento(botaoSalvar);
        tocarElemento(botaoSalvar, "Houve um erro ao executar a acao de tocar o elemento botao \"Salvar\"");
        salvarEvidencia("Tocar botão 'Salvar'");
        return this;
    }

    /**
     * Realiza o toque no botão cancelar.
     *
     * @return AdicionarEnderecoMarketplace
     * @throws Exception
     */
    @Step("Tocar botão \"Cancelar\"")
    public AdicionarEnderecoNextShopTela tocarBotaoCancelar() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoCancelar, "Não foi possível encontrar o botão Cancelar.");
        aguardarCarregamentoElemento(botaoCancelar);
        tocarElemento(botaoCancelar, "Houve um erro ao executar a acao de tocar o elemento botao \"Cancelar\"");
        salvarEvidencia("Tocar botão 'Cancelar'");
        return this;
    }
}

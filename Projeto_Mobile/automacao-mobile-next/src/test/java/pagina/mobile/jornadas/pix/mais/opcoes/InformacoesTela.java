package pagina.mobile.jornadas.pix.mais.opcoes;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.AtributoElemento;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.Utilitarios;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class InformacoesTela extends PaginaBase {

    //Botao menu Limite maior
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[@text=\"Minhas contas e Contatos Pix com limite maior\"]")
    @iOSXCUITFindBy(xpath = "//*[@name=\"Minhas contas e Contatos Pix com limite maior\"]")
    private MobileElement botaoMinhasContasContatosPixComLimiteMaior;

    //botão Voltar
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(accessibility = "Voltar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"MEUS LIMITES PIX\"]/XCUIElementTypeButton[1]")
    private MobileElement botaoVoltar;

    @AndroidFindBy(xpath = "//*[contains(@text,'Empresas')]/..")
    @iOSXCUITFindBy(accessibility = "Empresas")
    private MobileElement botaoEmpresas;

    public InformacoesTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Tocar botão 'Limite Maior'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Minhas Contas e Contatos Pix Com Limite Maior'")
    public InformacoesTela tocarBotaoMinhasContasContatosPixComLimiteMaior() throws Exception {
        aguardarCarregamentoElemento(botaoMinhasContasContatosPixComLimiteMaior);
        salvarEvidencia("Tocar no botão 'Minhas Contas e Contatos Pix Com Limite Maior'");
        tocarElemento(botaoMinhasContasContatosPixComLimiteMaior, "Não foi possível Tocar no botão 'Minhas Contas e Contatos Pix Com Limite Maior'");
        return this;
    }

    /**
     * Validar limites
     */
    @Step("Validar limites")
    public InformacoesTela validarLimite(String valorPix) {
        if (valorPix.endsWith("00")) {
            valorPix = Utilitarios.normalizaStringNumero(valorPix);
        } else {
            valorPix = Utilitarios.normalizaStringNumero(valorPix+"00");
        }
        salvarEvidencia("Valor do limite normliza string numero: " + valorPix);
        valorPix = Utilitarios.reformatarValorMonetario(valorPix);
        salvarEvidencia("Validado novo valor do limite: R$ " + valorPix);
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(valorPix), MetodoComparacaoBooleano.VERDADEIRO, "O valor de limite esperado não está presente na tela!");
        salvarEvidencia("Validado novo valor do limite: R$ " + valorPix);

        return this;
    }

    /**
     * Tocar no Botão Voltar aos meus limites
     */
    @Step("Tocar no Botão Voltar aos meus limites")
    public InformacoesTela tocarBotaoVoltar() throws NextException {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Tocar no botão Voltar");
        tocarElemento(botaoVoltar, "Não foi possível Tocar no botão Voltar");
        return this;
    }

    /**
     * Tocar Botão 'Empresas'
     *
     * @return InformacoesTela
     * @throws Exception
     */
    @Step("Tocar no Botão Empresas")
    public InformacoesTela tocarBotaoEmpresas() throws Exception{
        if (!verificarPresencaElemento(botaoEmpresas)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoEmpresas, "Não foi possível encontrar o botão 'Empresas'");
        }
        salvarEvidencia("Tocar no botão 'Empresas'");
        tocarElemento(botaoEmpresas, "Não foi possível tocar no botão 'Empresas'");
        return this;
    }

    /**
     * Validar Limite Atual
     * @param valorEsperado
     * @return InformacoesTela
     * @throws Exception
     */
    @Step("Validar Limite Atual")
    public InformacoesTela validarLimiteAtual(String valorEsperado) throws Exception{
        By campoValorLimite;
        if(ios) {
            campoValorLimite = By.xpath("(//XCUIElementTypeStaticText[@value='Limite diurno']/following-sibling::*[contains(@value,'Limite conta-corrente')])");
        } else {
            campoValorLimite = By.xpath("(//*[@text='Limite diurno']/following::*[contains(@text,'Limite conta-corrente')])[1]");
        }
        AtributoElemento attribute;
        if (android) {
            attribute = AtributoElemento.TEXTO;
        } else {
            attribute = AtributoElemento.NAME;
        }

        String valorEncontrado = retornarAtributoElemento(campoValorLimite, attribute,"Não foi possível extrair o valor do limite");
        valorEncontrado = valorEncontrado.replace("\u00a0","").replace(" ","");
        valorEsperado = valorEsperado.replace("\u00a0","").replace(" ","");
        validarCondicaoBooleana(valorEncontrado.contains(valorEsperado),MetodoComparacaoBooleano.VERDADEIRO,"Não foi possível extrair o valor do limite atual");
        salvarEvidencia("Valor do limite conta corrente: " + valorEsperado);
        return this;
    }
}

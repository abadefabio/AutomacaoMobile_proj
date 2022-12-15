package pagina.mobile.jornadas.open.finance;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.open.finance.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class OpenFinanceTela extends PaginaBase {
    public OpenFinanceTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "br.com.bradesco.next:id/ll_btn_transmitter_list")
    @iOSXCUITFindBy(accessibility = "DADOS QUE EU ENVIEI")
    private MobileElement botaoDadosQueEuEnviei;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_system")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,'Voltar')]")
    private MobileElement botaoVoltar;

    /**
     * Validar presen�a tela 'Open Finance'
     *
     * @return OpenFinanceTela
     * @throws Exception
     */
    @Step("Validar presen�a tela 'Open Finance'")
    public OpenFinanceTela validarPresencaTelaOpenFinance() throws Exception {
        validarCondicaoBooleana(!aguardarPaginaConterQualquerTexto(
                TituloTela.OPEN_FINANCE.toString()).equals("") , MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Open Finance' n�o est� presente na tela!");
        salvarEvidencia("Validada presen�a da tela Open Finance");
        return this;
    }

    /**
     * Tocar bot�o 'Dados que eu enviei'
     *
     * @return OpenFinanceTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Dados que eu enviei'")
    public OpenFinanceTela tocarBotaoDadosQueEuEnviei() throws Exception {
        if (!verificarPresencaElemento(botaoDadosQueEuEnviei)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoDadosQueEuEnviei, "N�o foi poss�vel encontrar o bot�o 'Dados que eu enviei'" );
        }
        salvarEvidencia("Tocar bot�o 'Dados que eu enviei'");
        tocarElemento(botaoDadosQueEuEnviei, "N�o foi poss�vel tocar no bot�o 'Dados que eu enviei'");
        return this;
    }

    /**
     * Tocar bot�o 'Voltar'
     *
     * @return OpenFinanceTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Voltar'")
    public OpenFinanceTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Tocar bot�o 'Voltar'");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar'");
        return this;
    }

}

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
     * Validar presença tela 'Open Finance'
     *
     * @return OpenFinanceTela
     * @throws Exception
     */
    @Step("Validar presença tela 'Open Finance'")
    public OpenFinanceTela validarPresencaTelaOpenFinance() throws Exception {
        validarCondicaoBooleana(!aguardarPaginaConterQualquerTexto(
                TituloTela.OPEN_FINANCE.toString()).equals("") , MetodoComparacaoBooleano.VERDADEIRO, "Título 'Open Finance' não está presente na tela!");
        salvarEvidencia("Validada presença da tela Open Finance");
        return this;
    }

    /**
     * Tocar botão 'Dados que eu enviei'
     *
     * @return OpenFinanceTela
     * @throws Exception
     */
    @Step("Tocar botão 'Dados que eu enviei'")
    public OpenFinanceTela tocarBotaoDadosQueEuEnviei() throws Exception {
        if (!verificarPresencaElemento(botaoDadosQueEuEnviei)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoDadosQueEuEnviei, "Não foi possível encontrar o botão 'Dados que eu enviei'" );
        }
        salvarEvidencia("Tocar botão 'Dados que eu enviei'");
        tocarElemento(botaoDadosQueEuEnviei, "Não foi possível tocar no botão 'Dados que eu enviei'");
        return this;
    }

    /**
     * Tocar botão 'Voltar'
     *
     * @return OpenFinanceTela
     * @throws Exception
     */
    @Step("Tocar botão 'Voltar'")
    public OpenFinanceTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Tocar botão 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar'");
        return this;
    }

}

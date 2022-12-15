package pagina.mobile.jornadas.credito.limite.flex;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ConfigurarLimiteTela extends PaginaBase {


    @AndroidFindBy(id="br.com.bradesco.next:id/only_chk_emergency_cash_flexlimitconfigact")
    @iOSXCUITFindBy(id = "Grana de Emergência")
    private MobileElement checkboxGranaEmergencia;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/only_chk_loan_flexlimitconfigact")
    @AndroidFindBy(xpath = "//*[@text='Empréstimo']")
    @iOSXCUITFindBy(id = "Empréstimo")
    private MobileElement checkboxEmprestimo;

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_ok_flex_limit_config_act")
    @iOSXCUITFindBy(xpath = "//*[@name='CONFIRMAR']")
    private MobileElement botaoConfirmar;


    public ConfigurarLimiteTela(AppiumDriver driver) {super(driver);}


    /**
     * Tocar no checkbox 'Grana de Emergencia'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar Checkbox 'Grana de Emergencia'")
    public ConfigurarLimiteTela tocarCheckboxGranaEmergencia() throws Exception {
        aguardarCarregamentoElemento(checkboxGranaEmergencia);
        salvarEvidencia("Tocar no checkbox 'Grana de Emergencia'");
        tocarElemento(checkboxGranaEmergencia,"Nao foi possivel tocar no checkbox 'Grana Emergencia'");
        return this;
    }

    /**
     * Tocar no checkbox 'Emprestimo'
     *
     * @return
     * @throws Exception
     */

    @Step("Tocar botão 'Voltar'")
    public ConfigurarLimiteTela tocarCheckboxEmprestimo() throws Exception {
        salvarEvidencia("Tocar no checkbox 'Emprestimo'");
        tocarElemento(checkboxEmprestimo,"Nao foi possivel tocar no checkbox 'Emprestimo'");
        return this;
    }

    /**
     * Tocar no checkbox 'Emprestimo'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão 'Confirmar'")
    public ConfigurarLimiteTela tocarBotaoConfirmar() throws Exception {
        salvarEvidencia("Tocar no botao 'Confirmar'");
        tocarElemento(botaoConfirmar,"Nao foi possivel tocar botao 'Confirmar'");
        return this;
    }
}

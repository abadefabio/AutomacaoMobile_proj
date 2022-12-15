package pagina.mobile.jornadas.objetivos.criarObjetivo;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static br.com.next.automacao.core.tools.Utilitarios.numeroAleatorio;

public class OlharPrazoParcelaTela extends PaginaBase {

    private static ThreadLocal<String> valor = new ThreadLocal<>();

    public OlharPrazoParcelaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Armazena valor informado no objeto thread-safe valorObjetivo
     * @param vvalor
     */
    public static void setValorObjetivo(String vvalor){
        valor.set(vvalor);
    }

    //botao continuar
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_continue_suggestion")
    @iOSXCUITFindBy(accessibility = "Continuar")
    private MobileElement botaoContinuar;

    // campo valor
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_goal_suggestion")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`value == \"R$ 50,00\"`]")
    @iOSXCUITFindBy(iOSNsPredicate = "value == \"R$ 50,00\"")
    private MobileElement valorObj;

    /**
     * Tocar botao Continuar
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botao  \"Continuar\"")
    public OlharPrazoParcelaTela tocarBotaoContinuar() throws Exception {
        aguardarElementoHabilitado(botaoContinuar);
        salvarEvidencia("'tocar botao continuar'");
        tocarElemento(botaoContinuar, "Erro ao tocar botao continuar");
        return this;
    }

    /**
     * Preencher valor do objetivo
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher campo  \"Valor\"")
    public OlharPrazoParcelaTela preencherValorObjetivo() throws Exception {
        aguardarCarregamentoElemento(valorObj);
        String valor = String.valueOf(numeroAleatorio(100,5000));
        setValorObjetivo(valor);
        escreverTexto(valorObj,valor, "Erro ao preenher Valor do objetivo.");
        salvarEvidencia("'Preenher valor do objetivo': "+ valor);
        return this;
    }

    /**
     * Preencher valor do objetivo
     *
     * @return
     * @throws Exception
     */
    @Step("Preencher campo  \"Valor\"")
    public OlharPrazoParcelaTela validarCampoValor() throws Exception {
        verificarPresencaElemento(valorObj);
        salvarEvidencia("'Campo valor do objetivo em tela': ");
        return this;
    }
}

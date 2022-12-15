package pagina.mobile.jornadas.vaquinha;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ConclusaoVaquinhaTela extends PaginaBase {

    @AndroidFindBy(xpath = "//*[contains(@text, 'R$')]")
    @iOSXCUITFindBy(accessibility = "//*[contains(@value, 'R$')]")
    private MobileElement labelValorPorPessoa;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ll_bt_send_by_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Enviar por e-mail']")
    private MobileElement botaoEnviarPorEmail;

    public ConclusaoVaquinhaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar Valor Vaquinha
     *
     * @param valor
     * @return ConclusaoVaquinhaTela
     * @throws Exception
     */
    @Step("Validar Valor da Vaquinha")
    public ConclusaoVaquinhaTela validarValorVaquinha(String  valor) throws Exception {
        compararElementoTexto(labelValorPorPessoa, valor, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar Valor da Vaquinha.");
        return this;
    }

    /**
     * Validar Data Vaquinha
     *
     * @param data
     * @return ConclusaoVaquinhaTela
     * @throws Exception
     */
    @Step("Validar Data da Vaquinha")
    public ConclusaoVaquinhaTela validarDataVaquinha(String data) throws Exception {
        if(android){
            String dia = data.substring(0,2) + " de ";
            String ano = " de " + data.substring(6,10);
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(dia, ano), MetodoComparacaoBooleano.VERDADEIRO, "A data da vaquinha nao esta presente na tela!");
        } else{
            validarCondicaoBooleana(aguardarPaginaConterTodosTextos(data), MetodoComparacaoBooleano.VERDADEIRO, "A data da vaquinha nao esta presente na tela!");
        }

        salvarEvidencia("Validar Data da Vaquinha.");
        return this;
    }

    /**
     * Tocar em 'Enviar por Email'
     *
     * @return ConclusaoVaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botão 'Enviar por Email'")
    public ConclusaoVaquinhaTela tocarEnviarPorEmail() throws Exception {
        aguardarCarregamentoElemento(botaoEnviarPorEmail);
        salvarEvidencia("Tocar no botão 'Enviar por Email'");
        tocarElemento(botaoEnviarPorEmail, "Não foi possível tocar no botão 'Enviar por Email'");
        return this;
    }
}

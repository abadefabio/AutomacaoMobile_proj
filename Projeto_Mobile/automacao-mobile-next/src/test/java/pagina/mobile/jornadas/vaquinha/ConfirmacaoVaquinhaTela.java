package pagina.mobile.jornadas.vaquinha;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.comprovantes.MensagensComprovantes;
import constantes.portabilidade.PortabilidadeDados;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import pagina.mobile.jornadas.portabilidade.TrazerMeuSalarioTela;

public class ConfirmacaoVaquinhaTela  extends PaginaBase {


    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_pay_vaquinha")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='Agendar Vaquinha']")
    private MobileElement botaoAgendarPagamento;

    @AndroidFindBy(xpath = "//*[contains(@text, 'R$')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value, 'R$')]")
    private MobileElement labelValorPorPessoa;

    public ConfirmacaoVaquinhaTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * "Validar Nome da Vaquinha
     *
     * @param nomeVaquinha
     * @return ConfirmacaoVaquinhaTela
     * @throws Exception
     */
    @Step("\"Validar Nome da Vaquinha")
    public ConfirmacaoVaquinhaTela validarNomeVaquinha(String nomeVaquinha) throws Exception {

        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(nomeVaquinha), MetodoComparacaoBooleano.VERDADEIRO, "O nome da vaquinha nao esta presente na tela!");
        salvarEvidencia("Validar Nome da Vaquinha.");
        return this;
    }

    /**
     * Validar Valor Vaquinha
     *
     * @param valor
     * @return ConfirmacaoVaquinhaTela
     * @throws Exception
     */
    @Step("Validar Valor da Vaquinha")
    public ConfirmacaoVaquinhaTela validarValorVaquinha(String  valor) throws Exception {

        compararElementoTexto(labelValorPorPessoa, valor, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar Valor da Vaquinha.");
        return this;
    }

    /**
     * Validar Data Vaquinha
     *
     * @param data
     * @return ConfirmacaoVaquinhaTela
     * @throws Exception
     */
    @Step("Validar Data da Vaquinha")
    public ConfirmacaoVaquinhaTela validarDataVaquinha(String data) throws Exception {
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
     * Tocar em 'Agendar Pagamento'
     *
     * @return ConfirmacaoVaquinhaTela
     * @throws Exception
     */
    @Step("Tocar botão 'Agendar Pagamento'")
    public ConfirmacaoVaquinhaTela tocarBotaoAgendarPagamento() throws Exception {

        salvarEvidencia("Tocar botão 'Agendar Pagamento'");
        tocarElemento(botaoAgendarPagamento, "Não foi possível tocar no botão 'Agendar Pagamento'");
        return this;
    }
}

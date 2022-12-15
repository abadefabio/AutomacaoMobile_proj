package pagina.web.fnext.n1;

import base.pagina.web.fnext.PaginaBaseWebFNext;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CardConclusaoAnaliseN1Tela extends PaginaBaseWebFNext {

    @FindBy(id = "step-result")
    private WebElement comboResultadoEtapa;

    @FindBy(id = "decision-analyst")
    private WebElement comboDecisaoAnalista;

    @FindBy(id = "description")
    private WebElement campoDescricaoDoAnalista;

    @FindBy(xpath = "//span[text()='0 caracter(es) restante(s)']")
    private WebElement mensagemCaractereExcedidaDescricaoDaAnaliseN2;

    @FindBy(xpath = "//button[text()=' Voltar ']")
    private WebElement botaoVoltar;


    public CardConclusaoAnaliseN1Tela(WebDriver driver) {
        super(driver);
    }

    /**
     * Método para selecionar combo Resultado da Etapa
     *
     * @param combo
     * @throws Exception
     * @return CardConclusaoAnaliseN1Tela
     */
    @Step("Selecionar combo Resultado da Etapa em N1")
    public CardConclusaoAnaliseN1Tela selecionarCombo(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboResultadoEtapa);
        selecionarTextoComboboxFnext(comboResultadoEtapa, combo,"Não foi possível selecionar opção no combo do resultado da etapa em N1");
        salvarEvidencia("Selecionando combo Resultado da Etapa em N1");
        return this;
    }

    /**
     * Método para selecionar combo Decisão do Analista
     *
     * @param combo
     * @throws Exception
     * @return CardConclusaoAnaliseN1Tela
     */
    @Step("Selecionar combo Decisão do Analista em N1")
    public CardConclusaoAnaliseN1Tela selecionarDecisao(String combo) throws Exception{
        rolarParaBaixoAteElemento(comboDecisaoAnalista);
        selecionarTextoComboboxFnext(comboDecisaoAnalista, combo,"Não foi possível selecionar opção no combo do decisão do analista em N1");
        salvarEvidencia("Selecionando combo Decisão do Analista em N1");
        return this;
    }

    /**
     * Método para Execeder o Limite de Caracteres no Campo "Descrição do Analista"
     *
     * @param descricaoDoAnalista
     * @throws Exception
     * @return CardConclusaoAnaliseN1Tela
     */
    @Step("Selecionar o campo Descrição do Analista em N1")
    public CardConclusaoAnaliseN1Tela digitarDescricaoDoAnalista(String descricaoDoAnalista) throws Exception{
        digitarTexto(campoDescricaoDoAnalista, descricaoDoAnalista, "O campo Descrição da Análise de N2 não foi encontrado");
        aguardarCarregamentoElemento(mensagemCaractereExcedidaDescricaoDaAnaliseN2);
        salvarEvidencia("Selecionando combo Decisão do Analista em N1");
        return this;
    }

}

package pagina.web.sistemadegestao.Mimos.Card;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static br.com.next.automacao.core.tools.Utilitarios.normalizaString;


public class SistemaDeGestaoCardTela extends PaginaBaseWeb {

    @FindBy(xpath = "//*[@id=\"formCadastro:texto\"]")
    private WebElement textoCard;

    @FindBy(xpath = "//a[contains(.,'Alterar')]")
    private WebElement botaoAlterar;

    @FindBy(xpath = "//button[contains(.,'Sim')]")
    private WebElement botaoSim;

    @FindBy(xpath = "//button[contains(.,'OK')]")
    private WebElement botaoOk;

    @FindBy(id = "formCadastro:descricaoTopo")
    private WebElement descricaoTopo;

    @FindBy(xpath = "//a[contains(.,'Aprovar')]")
    private WebElement botaoAprovar;

    public SistemaDeGestaoCardTela(WebDriver driver) {
        super(driver);
    }

    /**
     * Editar texto card
     *
     * @return
     * @throws Exception
     */
    @Step("Digitar no campo \"Texto Card\"")
    public SistemaDeGestaoCardTela preencherCampoTexto(String texto) throws Exception{
        /*
        Aqui aplicamos toda a digita��o, com limpeza (END + backspace) de uma s� vez.
        Outros modos de fazer isto n�o demonstraram funcionar,
        embora seja poss�vel que problemas posteriores tenham contribu�do,
        como o clique nos bot�es de Aprovar ou Alterar.
        De qualquer modo, a entrada total usando Selenium sem executor
        demonstrou alterar a descri��o tamb�m no card mobile representado � direita,
        o que � bom para as evid�ncias.
         */
        String textoEfetivo = Keys.END.toString();
        for (int i=0; i<= texto.length()*2; i++) {
            textoEfetivo = textoEfetivo.concat(Keys.BACK_SPACE.toString());
        }
        textoEfetivo += texto;
        aguardarElementoHabilitado(textoCard);
        digitarTexto(textoCard, textoEfetivo, "N�o foi poss�vel escrever o texto do card");
        salvarEvidencia("Digitar no campo \"Texto Card\"");
        return this;
    }

    /**
     * Verificar texto card
     *
     * @return
     * @throws Exception
     */
    @Step("Verificar texto do campo \"Texto Card\"")
    public SistemaDeGestaoCardTela validarCampoTextoCard(String texto) throws Exception {
        aguardarCarregamentoElemento(textoCard);
        // O framework n�o possui um atributo para resgatar o 'value' como abaixo
        String textoEncontrado = textoCard.getAttribute("value");
        validarCondicaoBooleana(
                normalizaString(textoEncontrado).equals(normalizaString(texto)),
                MetodoComparacaoBooleano.VERDADEIRO,
                "N�o foi poss�vel validar que o texto do card corresponde com o texto esperado: " + texto
        );
        salvarEvidencia("Verificar texto do campo \"Texto Card\"");
        return this;
    }

    /**
     * Clicar bot�o Alterar (salvar)
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no \"Bot�o Alterar\"")
    public SistemaDeGestaoCardTela clicarBotaoAlterar() throws Exception {
        rolarParaBaixoAteElemento(botaoAlterar);
        aguardarElementoHabilitado(botaoAlterar);
        salvarEvidencia("Clicar no bot�o \"ALTERAR\"");
        clicarElemento(botaoAlterar, "N�o foi poss�vel clicar no bot�o 'ALTERAR'");
        return this;
    }

    /**
     * Clicar bot�o Aprovar
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no \"Bot�o Aprovar\"")
    public SistemaDeGestaoCardTela clicarBotaoAprovar() throws Exception {
        rolarParaBaixoAteElemento(botaoAprovar);
        aguardarElementoHabilitado(botaoAprovar);
        salvarEvidencia("Clicar no bot�o \"APROVAR\"");
        clicarElemento(botaoAprovar, "N�o foi poss�vel clicar no bot�o 'APROVAR'");
        return this;
    }

    /**
     * Clicar bot�o sim
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no \"Bot�o Sim\"")
    public SistemaDeGestaoCardTela clicarBotaoSim() throws Exception {
        aguardarElementoHabilitado(botaoSim);
        salvarEvidencia("Clicar no bot�o \"Sim\"");
        clicarElemento(botaoSim, "N�o foi poss�vel clicar no bot�o 'Sim'");
        return this;
    }


    /**
     * Clicar bot�o Ok
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no \"Bot�o OK\"")
    public SistemaDeGestaoCardTela clicarBotaoOK() throws Exception {
        aguardarElementoHabilitado(botaoOk);
        salvarEvidencia("Clicar no bot�o \"OK\"");
        clicarElemento(botaoOk, "N�o foi poss�vel clicar no bot�o 'OK'");
        return this;
    }
}

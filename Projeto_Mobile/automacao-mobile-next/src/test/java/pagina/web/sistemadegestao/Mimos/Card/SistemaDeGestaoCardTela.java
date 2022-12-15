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
        Aqui aplicamos toda a digitação, com limpeza (END + backspace) de uma só vez.
        Outros modos de fazer isto não demonstraram funcionar,
        embora seja possível que problemas posteriores tenham contribuído,
        como o clique nos botões de Aprovar ou Alterar.
        De qualquer modo, a entrada total usando Selenium sem executor
        demonstrou alterar a descrição também no card mobile representado à direita,
        o que é bom para as evidências.
         */
        String textoEfetivo = Keys.END.toString();
        for (int i=0; i<= texto.length()*2; i++) {
            textoEfetivo = textoEfetivo.concat(Keys.BACK_SPACE.toString());
        }
        textoEfetivo += texto;
        aguardarElementoHabilitado(textoCard);
        digitarTexto(textoCard, textoEfetivo, "Não foi possível escrever o texto do card");
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
        // O framework não possui um atributo para resgatar o 'value' como abaixo
        String textoEncontrado = textoCard.getAttribute("value");
        validarCondicaoBooleana(
                normalizaString(textoEncontrado).equals(normalizaString(texto)),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar que o texto do card corresponde com o texto esperado: " + texto
        );
        salvarEvidencia("Verificar texto do campo \"Texto Card\"");
        return this;
    }

    /**
     * Clicar botão Alterar (salvar)
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no \"Botão Alterar\"")
    public SistemaDeGestaoCardTela clicarBotaoAlterar() throws Exception {
        rolarParaBaixoAteElemento(botaoAlterar);
        aguardarElementoHabilitado(botaoAlterar);
        salvarEvidencia("Clicar no botão \"ALTERAR\"");
        clicarElemento(botaoAlterar, "Não foi possível clicar no botão 'ALTERAR'");
        return this;
    }

    /**
     * Clicar botão Aprovar
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no \"Botão Aprovar\"")
    public SistemaDeGestaoCardTela clicarBotaoAprovar() throws Exception {
        rolarParaBaixoAteElemento(botaoAprovar);
        aguardarElementoHabilitado(botaoAprovar);
        salvarEvidencia("Clicar no botão \"APROVAR\"");
        clicarElemento(botaoAprovar, "Não foi possível clicar no botão 'APROVAR'");
        return this;
    }

    /**
     * Clicar botão sim
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no \"Botão Sim\"")
    public SistemaDeGestaoCardTela clicarBotaoSim() throws Exception {
        aguardarElementoHabilitado(botaoSim);
        salvarEvidencia("Clicar no botão \"Sim\"");
        clicarElemento(botaoSim, "Não foi possível clicar no botão 'Sim'");
        return this;
    }


    /**
     * Clicar botão Ok
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar no \"Botão OK\"")
    public SistemaDeGestaoCardTela clicarBotaoOK() throws Exception {
        aguardarElementoHabilitado(botaoOk);
        salvarEvidencia("Clicar no botão \"OK\"");
        clicarElemento(botaoOk, "Não foi possível clicar no botão 'OK'");
        return this;
    }
}

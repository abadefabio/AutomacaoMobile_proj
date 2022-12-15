package pagina.web.fnext.n1;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardReceitaFederalTela extends PaginaBaseWeb {

    @FindBy(id = "confereCustomerName")
    private WebElement confereCampoNome;

    @FindBy(id = "notConfereCustomerName")
    private WebElement naoConfereCampoNome;

    @FindBy(id = "confereMotherName")
    private WebElement confereCampoNomeMae;

    @FindBy(id = "notConfereMotherName")
    private WebElement naoConfereCampoNomeMae;

    @FindBy(id = "ConfereBirthDt")
    private WebElement confereDataNascimento;

    @FindBy(id = "notConfereBirthDt")
    private WebElement naoConfereDataNascimento;

    public CardReceitaFederalTela(WebDriver driver) {
        super(driver);
    }


    /**
     * Clicar Confere campo Nome
     *
     * @return
     * @throws Exception
     */
    @Step("Clica Confere no campo Nome no Card Receita Federal")
    public CardReceitaFederalTela clicarConfereNome() throws Exception {
        rolarAteElemento(confereCampoNome, "Op��o Confere do campo Nome n�o encontrado");
        aguardarElementoClicavel(confereCampoNome);
        clicarElemento(confereCampoNome, "Erro ao clicar Confere campo Nome");
        salvarEvidencia("Clicar Confere campo Nome");
        return this;
    }


    /**
     * Clicar N�o Confere campo Nome
     *
     * @return
     * @throws Exception
     */
    @Step("Clica N�o Confere no campo Nome no Card Receita Federal")
    public CardReceitaFederalTela clicarNaoConfereNome() throws Exception {
        rolarAteElemento(naoConfereCampoNome, "Op��o N�o Confere do campo Nome n�o encontrado");
        aguardarElementoClicavel(naoConfereCampoNome);
        clicarElemento(naoConfereCampoNome, "Erro ao clicar N�o Confere campo Nome.");
        salvarEvidencia("Clicar N�o Confere campo Nome");
        return this;
    }

    /**
     * Clicar Confere campo Nome M�e
     *
     * @return
     * @throws Exception
     */
    @Step("Clica Confere no campo Nome M�e no Card Receita Federal")
    public CardReceitaFederalTela clicarConfereNomeMae() throws Exception {
        rolarAteElemento(confereCampoNomeMae, "Op��o Confere do campo Nome M�e n�o encontrado");
        aguardarElementoClicavel(confereCampoNomeMae);
        clicarElemento(confereCampoNomeMae, "Erro ao clicar Confere campo Nome M�e");
        salvarEvidencia("Clicar Confere campo Nome M�e");
        return this;
    }

    /**
     * Clicar N�o Confere campo Nome M�e
     *
     * @return
     * @throws Exception
     */
    @Step("Clica N�o Confere no campo Nome M�e no Card Receita Federal")
    public CardReceitaFederalTela clicarNaoConfereNomeMae() throws Exception {
        rolarAteElemento(naoConfereCampoNomeMae, "Op��o N�o Confere do campo Nome M�e n�o encontrado");
        aguardarElementoClicavel(naoConfereCampoNomeMae);
        clicarElemento(naoConfereCampoNomeMae, "Erro ao clicar N�o Confere campo Nome M�e.");
        salvarEvidencia("Clicar N�o Confere campo Nome M�e");
        return this;
    }


    /**
     * Clicar Confere campo Data Nascimento
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere no campo Data Nascimento no Card Receita Federal")
    public CardReceitaFederalTela clicarConfereDataNascimento() throws Exception {
        rolarAteElemento(confereDataNascimento, "Op��o Confere do campo Data de Nascimento n�o encontrado");
        aguardarElementoClicavel(confereDataNascimento);
        clicarElemento(confereDataNascimento, "Erro ao clicar Confere campo Data Nascimento");
        salvarEvidencia("Clicar Confere campo Data Nascimento");
        return this;
    }

    /**
     * Clicar N�o Confere campo Data Nascimento
     *
     * @return
     * @throws Exception
     */
    public CardReceitaFederalTela clicarNaoConfereDataNascimento() throws  Exception {
        rolarAteElemento(naoConfereDataNascimento, "Op��o N�o Confere do campo Data de Nascimento n�o encontrado");
        aguardarElementoClicavel(naoConfereDataNascimento);
        clicarElemento(naoConfereDataNascimento, "Erro ao clicar N�o Confere campo Data Nascimento");
        salvarEvidencia("Clicar N�o Confere campo Data Nascimento");
        return this;
    }
}

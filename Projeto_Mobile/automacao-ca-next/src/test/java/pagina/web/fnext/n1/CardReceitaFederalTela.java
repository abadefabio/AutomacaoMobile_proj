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
        rolarAteElemento(confereCampoNome, "Opção Confere do campo Nome não encontrado");
        aguardarElementoClicavel(confereCampoNome);
        clicarElemento(confereCampoNome, "Erro ao clicar Confere campo Nome");
        salvarEvidencia("Clicar Confere campo Nome");
        return this;
    }


    /**
     * Clicar Não Confere campo Nome
     *
     * @return
     * @throws Exception
     */
    @Step("Clica Não Confere no campo Nome no Card Receita Federal")
    public CardReceitaFederalTela clicarNaoConfereNome() throws Exception {
        rolarAteElemento(naoConfereCampoNome, "Opção Não Confere do campo Nome não encontrado");
        aguardarElementoClicavel(naoConfereCampoNome);
        clicarElemento(naoConfereCampoNome, "Erro ao clicar Não Confere campo Nome.");
        salvarEvidencia("Clicar Não Confere campo Nome");
        return this;
    }

    /**
     * Clicar Confere campo Nome Mãe
     *
     * @return
     * @throws Exception
     */
    @Step("Clica Confere no campo Nome Mãe no Card Receita Federal")
    public CardReceitaFederalTela clicarConfereNomeMae() throws Exception {
        rolarAteElemento(confereCampoNomeMae, "Opção Confere do campo Nome Mãe não encontrado");
        aguardarElementoClicavel(confereCampoNomeMae);
        clicarElemento(confereCampoNomeMae, "Erro ao clicar Confere campo Nome Mãe");
        salvarEvidencia("Clicar Confere campo Nome Mãe");
        return this;
    }

    /**
     * Clicar Não Confere campo Nome Mãe
     *
     * @return
     * @throws Exception
     */
    @Step("Clica Não Confere no campo Nome Mãe no Card Receita Federal")
    public CardReceitaFederalTela clicarNaoConfereNomeMae() throws Exception {
        rolarAteElemento(naoConfereCampoNomeMae, "Opção Não Confere do campo Nome Mãe não encontrado");
        aguardarElementoClicavel(naoConfereCampoNomeMae);
        clicarElemento(naoConfereCampoNomeMae, "Erro ao clicar Não Confere campo Nome Mãe.");
        salvarEvidencia("Clicar Não Confere campo Nome Mãe");
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
        rolarAteElemento(confereDataNascimento, "Opção Confere do campo Data de Nascimento não encontrado");
        aguardarElementoClicavel(confereDataNascimento);
        clicarElemento(confereDataNascimento, "Erro ao clicar Confere campo Data Nascimento");
        salvarEvidencia("Clicar Confere campo Data Nascimento");
        return this;
    }

    /**
     * Clicar Não Confere campo Data Nascimento
     *
     * @return
     * @throws Exception
     */
    public CardReceitaFederalTela clicarNaoConfereDataNascimento() throws  Exception {
        rolarAteElemento(naoConfereDataNascimento, "Opção Não Confere do campo Data de Nascimento não encontrado");
        aguardarElementoClicavel(naoConfereDataNascimento);
        clicarElemento(naoConfereDataNascimento, "Erro ao clicar Não Confere campo Data Nascimento");
        salvarEvidencia("Clicar Não Confere campo Data Nascimento");
        return this;
    }
}

package pagina.web.fnext.n1;

import base.pagina.web.fnext.PaginaBaseWebFNext;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardInformacoesEnderecoTela extends PaginaBaseWebFNext {

    @FindBy(id = "confereCep")
    private WebElement confereCep;

    @FindBy(id = "confereLogradouro")
    private WebElement confereLogradouro;

    @FindBy(id = "confereNumero")
    private WebElement confereNumero;

    @FindBy(id = "confereComplemento")
    private WebElement confereComplemento;

    @FindBy(id = "confereUf")
    private WebElement confereUf;

    @FindBy(id = "confereCidade")
    private WebElement confereCidade;

    @FindBy(id = "naoConfereCep")
    private WebElement naoConfereCep;

    @FindBy(id = "naoConfereLogradouro")
    private WebElement naoConfereLogradouro;

    @FindBy(id = "naoConfereNumero")
    private WebElement naoConfereNumero;

    @FindBy(id = "naoConfereComplemento")
    private WebElement naoConfereComplemento;

    @FindBy(id = "naoConfereUf")
    private WebElement naoConfereUf;

    @FindBy(id = "naoConfereCidade")
    private WebElement naoConfereCidade;

    @FindBy(id="correcaoCep")
    private WebElement correcaoCep;

    @FindBy(id="correcaoLogradouro")
    private WebElement correcaoLogradouro;

    @FindBy(id="correcaoNumero")
    private WebElement correcaoNumero;

    @FindBy(id="correcaoComplemento")
    private WebElement correcaoComplemento;

    @FindBy(xpath = "//mat-select[@id='correcaoUF']/div[1]/div[1]")
    private WebElement correcaoUf;

    @FindBy(xpath = "//mat-select[@id='correcaoCidade']/div[1]/div[1]")
    private WebElement correcaoCidade;


    public CardInformacoesEnderecoTela(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicar Confere do campo CEP
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere do campo CEP")
    public CardInformacoesEnderecoTela clicarConfereCep() throws Exception {
        rolarAteElemento(confereCep, "Op��o Confere do campo CEP n�o encontrado.");
        aguardarElementoClicavel(confereCep);
        salvarEvidencia("Clicar Confere para o campo CEP");
        clicarElemento(confereCep, "Erro para clicar Confere no campo CEP");
        return this;
    }

    /**
     * Clicar Confere do campo Logradouro
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere do campo Logradouro")
    public CardInformacoesEnderecoTela clicarConfereLogradouro() throws Exception {
        rolarAteElemento(confereLogradouro, "Op��o Confere do campo Logradouro n�o encontrado.");
        aguardarElementoClicavel(confereLogradouro);
        clicarElemento(confereLogradouro, "Erro para clicar Confere do campo Logradouro");
        return this;
    }

    /**
     * Clicar Confere do campo N�mero do endere�o
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere do campo N�mero do endere�o")
    public CardInformacoesEnderecoTela clicarConfereNumero() throws Exception {
        rolarAteElemento(confereNumero, "Op��o Confere do campo N�mero do endere�o n�o encontrado.");
        aguardarElementoClicavel(confereNumero);
        clicarElemento(confereNumero, "Erro para clicar Confere do campo N�mero do endere�o");
        return this;
    }

    /**
     * Clicar Confere do campo Complemento de Endere�o
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere do campo Complemento de Endere�o")
    public CardInformacoesEnderecoTela clicarConfereComplemento() throws Exception {
        rolarAteElemento(confereComplemento, "Op��o Confere do campo Complemento de Endere�o n�o encontrado.");
        aguardarElementoClicavel(confereComplemento);
        clicarElemento(confereComplemento, "Erro para clicar Confere do campo Complemento de Endere�o");
        return this;
    }

    /**
     * Clicar Confere do campo UF
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere do campo UF")
    public CardInformacoesEnderecoTela clicarConfereUf() throws Exception {
        rolarAteElemento(confereUf, "Op��o Confere do campo UF n�o encontrado.");
        aguardarElementoClicavel(confereUf);
        clicarElemento(confereUf, "Erro para clicar Confere do campo UF");
        return this;
    }

    /**
     * Clicar Confere do campo Cidade
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere do campo Cidade")
    public CardInformacoesEnderecoTela clicarConfereCidade() throws Exception {
        rolarAteElemento(confereCidade, "Op��o Confere do campo Cidade n�o encontrado");
        aguardarElementoClicavel(confereCidade);
        salvarEvidencia("Clicar Confere do campo Cidade");
        clicarElemento(confereCidade, "Erro para clicar Confere do campo Cidade");
        return this;
    }

    /**
     * Clicar N�o Confere no campo Cep
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Nao Confere no campo Cep")
    public CardInformacoesEnderecoTela clicarNaoConfereCep() throws Exception {
        rolarAteElemento(naoConfereCep,"Op��o N�o Confere do campo CEP n�o encontrado");
        aguardarElementoClicavel(naoConfereCep);
        salvarEvidencia("Clicar N�o Confere do campo CEP");
        clicarElemento(naoConfereCep,"Erro para clicar N�o Confere no campo CEP");
        return this;
    }

    /**
     * Clicar N�o Confere no campo Logradouro
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Nao Confere no campo Logradouro")
    public CardInformacoesEnderecoTela clicarNaoConfereLogradouro() throws Exception {
        rolarAteElemento(naoConfereLogradouro,"Op��o N�o Confere do campo Logradouro n�o encontrado");
        aguardarElementoClicavel(naoConfereLogradouro);
        salvarEvidencia("Clicar N�o Confere do campo Logradouro");
        clicarElemento(naoConfereLogradouro,"Erro para clicar N�o Confere no campo Logradouro");
        return this;
    }

    /**
     * Clicar N�o Confere no campo N�mero
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Nao Confere no campo N�mero")
    public CardInformacoesEnderecoTela clicarNaoConfereNumero() throws Exception {
        rolarAteElemento(naoConfereNumero,"Op��o N�o Confere do campo N�mero n�o encontrado");
        aguardarElementoClicavel(naoConfereNumero);
        salvarEvidencia("Clicar N�o Confere do campo N�mero");
        clicarElemento(naoConfereNumero,"Erro para clicar N�o Confere no campo N�mero");
        return this;
    }

    /**
     * Clicar N�o Confere do campo Complemento
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Nao Confere no campo Complemento")
    public CardInformacoesEnderecoTela clicarNaoConfereComplemento() throws Exception {
        rolarAteElemento(naoConfereComplemento,"Op��o N�o Confere do campo Complemento n�o encontrado");
        aguardarElementoClicavel(naoConfereComplemento);
        salvarEvidencia("Clicar N�o Confere do campo Complemento");
        clicarElemento(naoConfereComplemento,"Erro para clicar N�o Confere no campo Complemento");
        return this;
    }

    /**
     * Clicar N�o Confere no campo UF
     *
     * @retur
     * @throws Exception
     */
    @Step("Clicar Nao Confere no campo UF")
    public CardInformacoesEnderecoTela clicarNaoConfereUf() throws Exception {
        rolarAteElemento(naoConfereUf,"Op��o N�o Confere do campo UF n�o encontrado");
        aguardarElementoClicavel(naoConfereUf);
        salvarEvidencia("Clicar N�o Confere do campo UF");
        clicarElemento(naoConfereUf,"Erro para clicar N�o Confere no campo UF");
        return this;
    }

    /**
     * Clicar N�o Confere no campo Cidade
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Nao Confere no campo Cidade")
    public CardInformacoesEnderecoTela clicarNaoConfereCidade() throws Exception {
        rolarAteElemento(naoConfereCidade,"Op��o N�o Confere do campo Cidade n�o encontrado");
        aguardarElementoClicavel(naoConfereCidade);
        salvarEvidencia("Clicar N�o Confere do campo Cidade");
        clicarElemento(naoConfereCidade,"Erro para clicar N�o Confere no campo Cidade");
        return this;
    }

    /**
     * Clicar no campo de Corre��o do Cep e informar Corre��o
     *
     * @param CorrecaoCep
     * @return clicarCampoCorrecaoCepInformarCorrecao
     * @throws Exception
     */
    @Step("Clicar no campo de Corre��o do Cep e informar Corre��o")
    public CardInformacoesEnderecoTela clicarCampoCorrecaoCepInformarCorrecao(String CorrecaoCep) throws Exception {
        rolarAteElemento(correcaoCep,"Campo Corre��o Cep n�o encontrado");
        aguardarElementoClicavel(correcaoCep);
        salvarEvidencia("Clicar no campo de Corre��o do Cep");
        clicarElemento(correcaoCep,"Erro para clicar no campo de Corre��o do Cep");
        digitarTexto(correcaoCep,CorrecaoCep,"N�o foi poss�vel digitar no campo de Corre��o do Cep");
        return this;
    }

    /**
     * Verificar campo Corre��o do Cep e validar Corre��o
     *
     * @param Cep
     * @throws Exception
     * @return CardInformacoesEnderecoTela
     */
    @Step("Verificar campo Corre��o do Cep e validar corre��o")
    public CardInformacoesEnderecoTela verificarCampoCorrecaoCepValidarCorrecao(String Cep) throws Exception {
        rolarAteElemento(correcaoCep,"Campo Corre��o Cep n�o encontrado");
        validarCondicaoBooleana((correcaoCep.getAttribute("value").toString().equals(Cep)),MetodoComparacaoBooleano.VERDADEIRO,"A corre��o n�o foi acatada pelo FNEXT"+Cep);
        salvarEvidencia("Corre��o do campo Cep acatada com sucesso");
        return this;
    }

    /**
     * Clicar no campo Corre��o do Logradouro e informar Corre��o
     *
     * @param CorrecaoLogradouro
     * @return
     * @throws Exception
     */
    @Step("Clicar no campo Corre��o do Logradouro e informar corre��o")
    public CardInformacoesEnderecoTela clicarCampoCorrecaoLogradouroInformarCorrecao(String CorrecaoLogradouro) throws Exception {
        rolarAteElemento(correcaoLogradouro,"Campo Corre��o Logradouro n�o encontrado");
        aguardarElementoClicavel(correcaoLogradouro);
        salvarEvidencia("Clicar no campo de Corre��o do Logradouro");
        clicarElemento(correcaoLogradouro,"Erro para clicar no campo de Corre��o do Logradouro");
        digitarTexto(correcaoLogradouro,CorrecaoLogradouro,"N�o foi poss�vel digitar no campo de Corre��o do Logradouro");
        return this;
    }

    /**
     * Verificar campo Corre��o do Logradouro e validar Corre��o
     *
     * @param Logradouro
     * @throws Exception
     * @return CardInformacoesEnderecoTela
     */
    @Step("Verificar campo Corre��o do Logradouro e validar corre��o")
    public CardInformacoesEnderecoTela verificarCampoCorrecaoLogradouroValidarCorrecao(String Logradouro) throws Exception {
        rolarAteElemento(correcaoLogradouro,"Campo Corre��o Logradouro n�o encontrado");
        validarCondicaoBooleana((correcaoLogradouro.getAttribute("value").toString().equals(Logradouro)),MetodoComparacaoBooleano.VERDADEIRO,"A corre��o n�o foi acatada pelo FNEXT"+Logradouro);
        salvarEvidencia("Corre��o do Campo Logradouro acatada com sucesso");
        return this;
    }

    /**
     * Clicar no campo Corre��o do N�mero e informar corre��o
     *
     * @param CorrecaoNumero
     * @return CardInformacoesEnderecoTela
     * @throws Exception
     */
    @Step("Clicar no campo Corre��o do N�mero e informar Corre��o")
    public CardInformacoesEnderecoTela clicarCampoCorrecaoNumeroInformarCorrecao(String CorrecaoNumero) throws Exception {
        rolarAteElemento(correcaoNumero,"Campo Corre��o N�mero n�o encontrado");
        aguardarElementoClicavel(correcaoNumero);
        salvarEvidencia("Clicar no campo de Corre��o do N�mero");
        clicarElemento(correcaoNumero,"Erro para clicar no campo de Corre��o do N�mero");
        digitarTexto(correcaoNumero,CorrecaoNumero,"N�o foi poss�vel digitar no campo de Corre��o do N�mero");
        return this;
    }

    /**
     * Verificar campo Corre��o do Numero e validar Corre��o
     *
     * @return
     * @param Numero
     * @throws Exception
     */
    @Step("Verificar campo Corre��o do Numero e validar corre��o")
    public CardInformacoesEnderecoTela verificarCampoCorrecaoNumeroValidarCorrecao(String Numero) throws Exception {
        rolarAteElemento(correcaoNumero,"Campo Corre��o Numero n�o encontrado");
        validarCondicaoBooleana((correcaoNumero.getAttribute("value").toString().equals(Numero)),MetodoComparacaoBooleano.VERDADEIRO,"A corre��o n�o foi acatada pelo FNEXT"+Numero);
        salvarEvidencia("Corre��o do Campo N�mero acatada com sucesso");
        return this;
    }

    /**
     * Clicar no campo Corre��o do Complemento e informar Corre��o
     *
     * @param CorrecaoComplemento
     * @throws Exception
     * @return CardInformacoesEnderecoTela
     */
    @Step("Clicar no campo Corre��o do Complemento e informar corre��o")
    public CardInformacoesEnderecoTela clicarCampoCorrecaoComplementoInformarCorrecao(String CorrecaoComplemento) throws Exception {
        rolarAteElemento(correcaoComplemento,"Campo Corre��o Complemento n�o encontrado");
        aguardarElementoClicavel(correcaoComplemento);
        salvarEvidencia("Clicar no campo de Corre��o do Complemento");
        clicarElemento(correcaoComplemento,"Erro para clicar no campo de Corre��o do Complemento");
        digitarTexto(correcaoComplemento,CorrecaoComplemento,"N�o foi poss�vel digitar no campo de Corre��o do Complemento");
        return this;
    }

    /**
     * Verificar campo Corre��o do Complemento e validar Corre��o
     *
     * @return CardInformacoesEnderecoTela
     * @param Complemento
     * @throws Exception
     */
    @Step("Verificar campo Corre��o do Complemento e validar corre��o")
    public CardInformacoesEnderecoTela verificarCampoCorrecaoComplementoValidarCorrecao(String Complemento) throws Exception {
        rolarAteElemento(correcaoComplemento,"Campo Corre��o Complemento n�o encontrado");
        validarCondicaoBooleana((correcaoComplemento.getAttribute("value").toString().equals(Complemento)),MetodoComparacaoBooleano.VERDADEIRO,"A corre��o n�o foi acatada pelo FNEXT"+Complemento);
        salvarEvidencia("Corre��o do Campo Complemento acatada com sucesso");
        return this;
    }

    /**
     * Selecionar Corre��o de UF
     *
     * @param combo
     * @throws Exception
     * @return CardInformacoesEnderecoTela
     */
    @Step("Selecionar Corre��o de UF")
    public CardInformacoesEnderecoTela selecionarComboCorrecaoUf(String combo) throws Exception  {
        rolarAteElemento(correcaoUf,"Combo de Corre��o da UF n�o encontrado");
        selecionarTextoComboboxFnext(correcaoUf,combo,"Erro ao tentar selecionar campo de corre��o UF");
        return this;
    }

    /**
     * Verificar campo Corre��o do Uf e validar Corre��o
     *
     * @param Uf
     * @throws Exception
     * @return CardInformacoesEnderecoTela
     */
    @Step("Verificar campo Corre��o do Uf e validar corre��o")
    public CardInformacoesEnderecoTela verificarCampoCorrecaoUfValidarCorrecao(String Uf) throws Exception {
        rolarAteElemento(correcaoUf,"Campo Corre��o Uf n�o encontrado");
        validarCondicaoBooleana((correcaoUf.getText().toString().equals(Uf)),MetodoComparacaoBooleano.VERDADEIRO,"A corre��o n�o foi acatada pelo FNEXT"+Uf);
        salvarEvidencia("Corre��o do Campo Uf acatada com sucesso");
        return this;
    }

    /**
     * Selecionar Corre��o da Cidade
     *
     * @param combo
     * @throws Exception
     * @return CardInformacoesEnderecoTela
      */
    @Step("Selecionar Corre��o da Cidade")
    public CardInformacoesEnderecoTela selecionarComboCorrecaoCidade(String combo) throws Exception {
        rolarAteElemento(correcaoCidade,"Combo de Corre��o da Cidade n�o encontrado");
        aguardarElementoClicavel(correcaoCidade);
        salvarEvidencia("Clicar combo de Corre��o da Cidade");
        selecionarTextoComboboxFnext(correcaoCidade,combo,"Erro ao tentar selecionar campo de corre��o Cidade");
        return this;
    }

    /**
     * Verificar campo Corre��o do Cidade e validar Corre��o
     *
     * @param Cidade
     * @throws Exception
     * @return CardInformacoesEnderecoTela
     */
    @Step("Verificar campo Corre��o do Cidade e validar corre��o")
    public CardInformacoesEnderecoTela verificarCampoCorrecaoCidadeValidarCorrecao(String Cidade) throws Exception {
        rolarAteElemento(correcaoCidade,"Campo Corre��o Cidade n�o encontrado");
        validarCondicaoBooleana((correcaoCidade.getText().toString().equals(Cidade)),MetodoComparacaoBooleano.VERDADEIRO,"A corre��o n�o foi acatada pelo FNEXT"+Cidade);
        salvarEvidencia("Corre��o do Campo Cidade acatada com sucesso");
        return this;
    }
}

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
        rolarAteElemento(confereCep, "Opção Confere do campo CEP não encontrado.");
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
        rolarAteElemento(confereLogradouro, "Opção Confere do campo Logradouro não encontrado.");
        aguardarElementoClicavel(confereLogradouro);
        clicarElemento(confereLogradouro, "Erro para clicar Confere do campo Logradouro");
        return this;
    }

    /**
     * Clicar Confere do campo Número do endereço
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere do campo Número do endereço")
    public CardInformacoesEnderecoTela clicarConfereNumero() throws Exception {
        rolarAteElemento(confereNumero, "Opção Confere do campo Número do endereço não encontrado.");
        aguardarElementoClicavel(confereNumero);
        clicarElemento(confereNumero, "Erro para clicar Confere do campo Número do endereço");
        return this;
    }

    /**
     * Clicar Confere do campo Complemento de Endereço
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Confere do campo Complemento de Endereço")
    public CardInformacoesEnderecoTela clicarConfereComplemento() throws Exception {
        rolarAteElemento(confereComplemento, "Opção Confere do campo Complemento de Endereço não encontrado.");
        aguardarElementoClicavel(confereComplemento);
        clicarElemento(confereComplemento, "Erro para clicar Confere do campo Complemento de Endereço");
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
        rolarAteElemento(confereUf, "Opção Confere do campo UF não encontrado.");
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
        rolarAteElemento(confereCidade, "Opção Confere do campo Cidade não encontrado");
        aguardarElementoClicavel(confereCidade);
        salvarEvidencia("Clicar Confere do campo Cidade");
        clicarElemento(confereCidade, "Erro para clicar Confere do campo Cidade");
        return this;
    }

    /**
     * Clicar Não Confere no campo Cep
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Nao Confere no campo Cep")
    public CardInformacoesEnderecoTela clicarNaoConfereCep() throws Exception {
        rolarAteElemento(naoConfereCep,"Opção Não Confere do campo CEP não encontrado");
        aguardarElementoClicavel(naoConfereCep);
        salvarEvidencia("Clicar Não Confere do campo CEP");
        clicarElemento(naoConfereCep,"Erro para clicar Não Confere no campo CEP");
        return this;
    }

    /**
     * Clicar Não Confere no campo Logradouro
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Nao Confere no campo Logradouro")
    public CardInformacoesEnderecoTela clicarNaoConfereLogradouro() throws Exception {
        rolarAteElemento(naoConfereLogradouro,"Opção Não Confere do campo Logradouro não encontrado");
        aguardarElementoClicavel(naoConfereLogradouro);
        salvarEvidencia("Clicar Não Confere do campo Logradouro");
        clicarElemento(naoConfereLogradouro,"Erro para clicar Não Confere no campo Logradouro");
        return this;
    }

    /**
     * Clicar Não Confere no campo Número
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Nao Confere no campo Número")
    public CardInformacoesEnderecoTela clicarNaoConfereNumero() throws Exception {
        rolarAteElemento(naoConfereNumero,"Opção Não Confere do campo Número não encontrado");
        aguardarElementoClicavel(naoConfereNumero);
        salvarEvidencia("Clicar Não Confere do campo Número");
        clicarElemento(naoConfereNumero,"Erro para clicar Não Confere no campo Número");
        return this;
    }

    /**
     * Clicar Não Confere do campo Complemento
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Nao Confere no campo Complemento")
    public CardInformacoesEnderecoTela clicarNaoConfereComplemento() throws Exception {
        rolarAteElemento(naoConfereComplemento,"Opção Não Confere do campo Complemento não encontrado");
        aguardarElementoClicavel(naoConfereComplemento);
        salvarEvidencia("Clicar Não Confere do campo Complemento");
        clicarElemento(naoConfereComplemento,"Erro para clicar Não Confere no campo Complemento");
        return this;
    }

    /**
     * Clicar Não Confere no campo UF
     *
     * @retur
     * @throws Exception
     */
    @Step("Clicar Nao Confere no campo UF")
    public CardInformacoesEnderecoTela clicarNaoConfereUf() throws Exception {
        rolarAteElemento(naoConfereUf,"Opção Não Confere do campo UF não encontrado");
        aguardarElementoClicavel(naoConfereUf);
        salvarEvidencia("Clicar Não Confere do campo UF");
        clicarElemento(naoConfereUf,"Erro para clicar Não Confere no campo UF");
        return this;
    }

    /**
     * Clicar Não Confere no campo Cidade
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar Nao Confere no campo Cidade")
    public CardInformacoesEnderecoTela clicarNaoConfereCidade() throws Exception {
        rolarAteElemento(naoConfereCidade,"Opção Não Confere do campo Cidade não encontrado");
        aguardarElementoClicavel(naoConfereCidade);
        salvarEvidencia("Clicar Não Confere do campo Cidade");
        clicarElemento(naoConfereCidade,"Erro para clicar Não Confere no campo Cidade");
        return this;
    }

    /**
     * Clicar no campo de Correção do Cep e informar Correção
     *
     * @param CorrecaoCep
     * @return clicarCampoCorrecaoCepInformarCorrecao
     * @throws Exception
     */
    @Step("Clicar no campo de Correção do Cep e informar Correção")
    public CardInformacoesEnderecoTela clicarCampoCorrecaoCepInformarCorrecao(String CorrecaoCep) throws Exception {
        rolarAteElemento(correcaoCep,"Campo Correção Cep não encontrado");
        aguardarElementoClicavel(correcaoCep);
        salvarEvidencia("Clicar no campo de Correção do Cep");
        clicarElemento(correcaoCep,"Erro para clicar no campo de Correção do Cep");
        digitarTexto(correcaoCep,CorrecaoCep,"Não foi possível digitar no campo de Correção do Cep");
        return this;
    }

    /**
     * Verificar campo Correção do Cep e validar Correção
     *
     * @param Cep
     * @throws Exception
     * @return CardInformacoesEnderecoTela
     */
    @Step("Verificar campo Correção do Cep e validar correção")
    public CardInformacoesEnderecoTela verificarCampoCorrecaoCepValidarCorrecao(String Cep) throws Exception {
        rolarAteElemento(correcaoCep,"Campo Correção Cep não encontrado");
        validarCondicaoBooleana((correcaoCep.getAttribute("value").toString().equals(Cep)),MetodoComparacaoBooleano.VERDADEIRO,"A correção não foi acatada pelo FNEXT"+Cep);
        salvarEvidencia("Correção do campo Cep acatada com sucesso");
        return this;
    }

    /**
     * Clicar no campo Correção do Logradouro e informar Correção
     *
     * @param CorrecaoLogradouro
     * @return
     * @throws Exception
     */
    @Step("Clicar no campo Correção do Logradouro e informar correção")
    public CardInformacoesEnderecoTela clicarCampoCorrecaoLogradouroInformarCorrecao(String CorrecaoLogradouro) throws Exception {
        rolarAteElemento(correcaoLogradouro,"Campo Correção Logradouro não encontrado");
        aguardarElementoClicavel(correcaoLogradouro);
        salvarEvidencia("Clicar no campo de Correção do Logradouro");
        clicarElemento(correcaoLogradouro,"Erro para clicar no campo de Correção do Logradouro");
        digitarTexto(correcaoLogradouro,CorrecaoLogradouro,"Não foi possível digitar no campo de Correção do Logradouro");
        return this;
    }

    /**
     * Verificar campo Correção do Logradouro e validar Correção
     *
     * @param Logradouro
     * @throws Exception
     * @return CardInformacoesEnderecoTela
     */
    @Step("Verificar campo Correção do Logradouro e validar correção")
    public CardInformacoesEnderecoTela verificarCampoCorrecaoLogradouroValidarCorrecao(String Logradouro) throws Exception {
        rolarAteElemento(correcaoLogradouro,"Campo Correção Logradouro não encontrado");
        validarCondicaoBooleana((correcaoLogradouro.getAttribute("value").toString().equals(Logradouro)),MetodoComparacaoBooleano.VERDADEIRO,"A correção não foi acatada pelo FNEXT"+Logradouro);
        salvarEvidencia("Correção do Campo Logradouro acatada com sucesso");
        return this;
    }

    /**
     * Clicar no campo Correção do Número e informar correção
     *
     * @param CorrecaoNumero
     * @return CardInformacoesEnderecoTela
     * @throws Exception
     */
    @Step("Clicar no campo Correção do Número e informar Correção")
    public CardInformacoesEnderecoTela clicarCampoCorrecaoNumeroInformarCorrecao(String CorrecaoNumero) throws Exception {
        rolarAteElemento(correcaoNumero,"Campo Correção Número não encontrado");
        aguardarElementoClicavel(correcaoNumero);
        salvarEvidencia("Clicar no campo de Correção do Número");
        clicarElemento(correcaoNumero,"Erro para clicar no campo de Correção do Número");
        digitarTexto(correcaoNumero,CorrecaoNumero,"Não foi possível digitar no campo de Correção do Número");
        return this;
    }

    /**
     * Verificar campo Correção do Numero e validar Correção
     *
     * @return
     * @param Numero
     * @throws Exception
     */
    @Step("Verificar campo Correção do Numero e validar correção")
    public CardInformacoesEnderecoTela verificarCampoCorrecaoNumeroValidarCorrecao(String Numero) throws Exception {
        rolarAteElemento(correcaoNumero,"Campo Correção Numero não encontrado");
        validarCondicaoBooleana((correcaoNumero.getAttribute("value").toString().equals(Numero)),MetodoComparacaoBooleano.VERDADEIRO,"A correção não foi acatada pelo FNEXT"+Numero);
        salvarEvidencia("Correção do Campo Número acatada com sucesso");
        return this;
    }

    /**
     * Clicar no campo Correção do Complemento e informar Correção
     *
     * @param CorrecaoComplemento
     * @throws Exception
     * @return CardInformacoesEnderecoTela
     */
    @Step("Clicar no campo Correção do Complemento e informar correção")
    public CardInformacoesEnderecoTela clicarCampoCorrecaoComplementoInformarCorrecao(String CorrecaoComplemento) throws Exception {
        rolarAteElemento(correcaoComplemento,"Campo Correção Complemento não encontrado");
        aguardarElementoClicavel(correcaoComplemento);
        salvarEvidencia("Clicar no campo de Correção do Complemento");
        clicarElemento(correcaoComplemento,"Erro para clicar no campo de Correção do Complemento");
        digitarTexto(correcaoComplemento,CorrecaoComplemento,"Não foi possível digitar no campo de Correção do Complemento");
        return this;
    }

    /**
     * Verificar campo Correção do Complemento e validar Correção
     *
     * @return CardInformacoesEnderecoTela
     * @param Complemento
     * @throws Exception
     */
    @Step("Verificar campo Correção do Complemento e validar correção")
    public CardInformacoesEnderecoTela verificarCampoCorrecaoComplementoValidarCorrecao(String Complemento) throws Exception {
        rolarAteElemento(correcaoComplemento,"Campo Correção Complemento não encontrado");
        validarCondicaoBooleana((correcaoComplemento.getAttribute("value").toString().equals(Complemento)),MetodoComparacaoBooleano.VERDADEIRO,"A correção não foi acatada pelo FNEXT"+Complemento);
        salvarEvidencia("Correção do Campo Complemento acatada com sucesso");
        return this;
    }

    /**
     * Selecionar Correção de UF
     *
     * @param combo
     * @throws Exception
     * @return CardInformacoesEnderecoTela
     */
    @Step("Selecionar Correção de UF")
    public CardInformacoesEnderecoTela selecionarComboCorrecaoUf(String combo) throws Exception  {
        rolarAteElemento(correcaoUf,"Combo de Correção da UF não encontrado");
        selecionarTextoComboboxFnext(correcaoUf,combo,"Erro ao tentar selecionar campo de correção UF");
        return this;
    }

    /**
     * Verificar campo Correção do Uf e validar Correção
     *
     * @param Uf
     * @throws Exception
     * @return CardInformacoesEnderecoTela
     */
    @Step("Verificar campo Correção do Uf e validar correção")
    public CardInformacoesEnderecoTela verificarCampoCorrecaoUfValidarCorrecao(String Uf) throws Exception {
        rolarAteElemento(correcaoUf,"Campo Correção Uf não encontrado");
        validarCondicaoBooleana((correcaoUf.getText().toString().equals(Uf)),MetodoComparacaoBooleano.VERDADEIRO,"A correção não foi acatada pelo FNEXT"+Uf);
        salvarEvidencia("Correção do Campo Uf acatada com sucesso");
        return this;
    }

    /**
     * Selecionar Correção da Cidade
     *
     * @param combo
     * @throws Exception
     * @return CardInformacoesEnderecoTela
      */
    @Step("Selecionar Correção da Cidade")
    public CardInformacoesEnderecoTela selecionarComboCorrecaoCidade(String combo) throws Exception {
        rolarAteElemento(correcaoCidade,"Combo de Correção da Cidade não encontrado");
        aguardarElementoClicavel(correcaoCidade);
        salvarEvidencia("Clicar combo de Correção da Cidade");
        selecionarTextoComboboxFnext(correcaoCidade,combo,"Erro ao tentar selecionar campo de correção Cidade");
        return this;
    }

    /**
     * Verificar campo Correção do Cidade e validar Correção
     *
     * @param Cidade
     * @throws Exception
     * @return CardInformacoesEnderecoTela
     */
    @Step("Verificar campo Correção do Cidade e validar correção")
    public CardInformacoesEnderecoTela verificarCampoCorrecaoCidadeValidarCorrecao(String Cidade) throws Exception {
        rolarAteElemento(correcaoCidade,"Campo Correção Cidade não encontrado");
        validarCondicaoBooleana((correcaoCidade.getText().toString().equals(Cidade)),MetodoComparacaoBooleano.VERDADEIRO,"A correção não foi acatada pelo FNEXT"+Cidade);
        salvarEvidencia("Correção do Campo Cidade acatada com sucesso");
        return this;
    }
}

package pagina.web.cockpit.atendimento.dadosCadastrais;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContatoTela extends PaginaBaseWeb {

    public ContatoTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Contato')]")
    private WebElement abaContato;

    @FindBy(xpath = "//*[@class='nt-c-grid__row nt-c-grid__row--mt-20']/div/div[2]")
    private WebElement valorCampoCelular;

    @FindBy(xpath = "//*[@class='nt-c-grid__column nt-c-grid__column--size-100']/div[1]/div/div[2]")
    private WebElement valorCampoResidencial;

    @FindBy(xpath = "//div[text() = 'E-mail*:']//following-sibling::div")
    private WebElement valorCampoEmail;

    @FindBy(xpath = "(//div[text() = 'Tipo*:']//following-sibling::div)[1]")
    private WebElement valorCampoTipo;

    @FindBy(xpath = "(//div[text() = 'CEP']//following-sibling::div)[1]")
    private WebElement valorCampoCep;

    @FindBy(xpath = "(//div[text() = 'Logradouro']//following-sibling::div)[1]")
    private WebElement valorCampoLogradouro;

    @FindBy(xpath = "(//div[text() = 'N�mero']//following-sibling::div)[1]")
    private WebElement valorCampoNumero;

    @FindBy(xpath = "(//div[text() = 'Complemento']//following-sibling::div)[1]")
    private WebElement valorCampoComplemento;

    @FindBy(xpath = "(//div[text() = 'Bairro']//following-sibling::div)[1]")
    private WebElement valorCampoBairro;

    @FindBy(xpath = "(//div[text() = 'Cidade']//following-sibling::div)[1]")
    private WebElement valorCampoCidade;

    @FindBy(xpath = "(//div[text() = 'UF']//following-sibling::div)[1]")
    private WebElement valorCampoUF;

    /**
     * Clicar na aba contato
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela clicarAbaContato() throws Exception {
        clicarElemento(abaContato, "N�o foi poss�vel clicar na aba contatos");
        salvarEvidencia("Clicado aba contato");
        return this;
    }

    /**
     * Validar campo Celular est� preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoCelularEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoCelular, "N�o foi poss�vel recuperar o texto do campo Celular");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Celular est� vazio");
        salvarEvidencia("Validar campo Celular n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Residencial est� preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoResidencialEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoResidencial, "N�o foi poss�vel recuperar o texto do campo Residencial");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Residencial est� vazio");
        salvarEvidencia("Validar campo Residencial n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Email est� preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoEmailEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoEmail, "N�o foi poss�vel recuperar o texto do campo Email");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Email est� vazio");
        salvarEvidencia("Validar campo Email n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Tipo est� preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoTipoEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoTipo, "N�o foi poss�vel recuperar o texto do campo Tipo");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Tipo est� vazio");
        salvarEvidencia("Validar campo Tipo n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo CEP est� preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoCepEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoCep, "N�o foi poss�vel recuperar o texto do campo CEP");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo CEP est� vazio");
        salvarEvidencia("Validar campo CEP n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Logradouro est� preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoLogradouroEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoLogradouro, "N�o foi poss�vel recuperar o texto do campo Logradouro");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Logradouro est� vazio");
        salvarEvidencia("Validar campo Logradouro n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo N�mero est� preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoNumeroEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoNumero, "N�o foi poss�vel recuperar o texto do campo N�mero");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo N�mero est� vazio");
        salvarEvidencia("Validar campo N�mero n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Complemento est� preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoComplementoEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoComplemento, "N�o foi poss�vel recuperar o texto do campo Complemento");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Complemento est� vazio");
        salvarEvidencia("Validar campo Complemento n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Bairro est� preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoBairroEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoBairro, "N�o foi poss�vel recuperar o texto do campo Bairro");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Bairro est� vazio");
        salvarEvidencia("Validar campo Bairro n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Cidade est� preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoCidadeEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoCidade, "N�o foi poss�vel recuperar o texto do campo Cidade");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Cidade est� vazio");
        salvarEvidencia("Validar campo Cidade n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo UF est� preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoUfEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoUF, "N�o foi poss�vel recuperar o texto do campo UF");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo UF est� vazio");
        salvarEvidencia("Validar campo UF n�o est� vazio!");
        return this;
    }
}

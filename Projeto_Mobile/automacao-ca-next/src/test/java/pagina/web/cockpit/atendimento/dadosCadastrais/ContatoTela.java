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

    @FindBy(xpath = "(//div[text() = 'Número']//following-sibling::div)[1]")
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
        clicarElemento(abaContato, "Não foi possível clicar na aba contatos");
        salvarEvidencia("Clicado aba contato");
        return this;
    }

    /**
     * Validar campo Celular está preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoCelularEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoCelular, "Não foi possível recuperar o texto do campo Celular");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Celular está vazio");
        salvarEvidencia("Validar campo Celular não está vazio!");
        return this;
    }

    /**
     * Validar campo Residencial está preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoResidencialEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoResidencial, "Não foi possível recuperar o texto do campo Residencial");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Residencial está vazio");
        salvarEvidencia("Validar campo Residencial não está vazio!");
        return this;
    }

    /**
     * Validar campo Email está preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoEmailEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoEmail, "Não foi possível recuperar o texto do campo Email");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Email está vazio");
        salvarEvidencia("Validar campo Email não está vazio!");
        return this;
    }

    /**
     * Validar campo Tipo está preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoTipoEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoTipo, "Não foi possível recuperar o texto do campo Tipo");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Tipo está vazio");
        salvarEvidencia("Validar campo Tipo não está vazio!");
        return this;
    }

    /**
     * Validar campo CEP está preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoCepEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoCep, "Não foi possível recuperar o texto do campo CEP");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo CEP está vazio");
        salvarEvidencia("Validar campo CEP não está vazio!");
        return this;
    }

    /**
     * Validar campo Logradouro está preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoLogradouroEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoLogradouro, "Não foi possível recuperar o texto do campo Logradouro");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Logradouro está vazio");
        salvarEvidencia("Validar campo Logradouro não está vazio!");
        return this;
    }

    /**
     * Validar campo Número está preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoNumeroEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoNumero, "Não foi possível recuperar o texto do campo Número");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Número está vazio");
        salvarEvidencia("Validar campo Número não está vazio!");
        return this;
    }

    /**
     * Validar campo Complemento está preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoComplementoEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoComplemento, "Não foi possível recuperar o texto do campo Complemento");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Complemento está vazio");
        salvarEvidencia("Validar campo Complemento não está vazio!");
        return this;
    }

    /**
     * Validar campo Bairro está preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoBairroEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoBairro, "Não foi possível recuperar o texto do campo Bairro");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Bairro está vazio");
        salvarEvidencia("Validar campo Bairro não está vazio!");
        return this;
    }

    /**
     * Validar campo Cidade está preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoCidadeEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoCidade, "Não foi possível recuperar o texto do campo Cidade");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Cidade está vazio");
        salvarEvidencia("Validar campo Cidade não está vazio!");
        return this;
    }

    /**
     * Validar campo UF está preenchido
     *
     * @return ContatoTela
     * @throws Exception
     */
    public ContatoTela validarValorCampoUfEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoUF, "Não foi possível recuperar o texto do campo UF");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo UF está vazio");
        salvarEvidencia("Validar campo UF não está vazio!");
        return this;
    }
}

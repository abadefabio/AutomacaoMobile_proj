package pagina.web.cockpit.atendimento.dadosCadastrais;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DadosCadastraisTela extends PaginaBaseWeb {

    public DadosCadastraisTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[contains(text(),'Dados')]")
    private WebElement menuDadosCadastrais;

    @FindBy(xpath = "//img[@alt='Imagem do Cliente']")
    private WebElement fotoUsuario;

    @FindBy(xpath = "//div[@class='nt-c-grid__item__value test_karma-customer-name']")
    private WebElement valorCampoNome;

    @FindBy(xpath = "//div[text() = 'Apelido*:']//following-sibling::div")
    private WebElement valorCampoApelido;

    @FindBy(xpath = "//div[text() = 'Idade:']//following-sibling::div")
    private WebElement valorCampoIdade;

    @FindBy(xpath = "//div[text() = 'Data de Nascimento*:']//following-sibling::div")
    private WebElement valorCampoDataNascimento;

    @FindBy(xpath = "//div[text() = 'Gênero*:']//following-sibling::div")
    private WebElement valorCampoGenero;

    @FindBy(xpath = "//div[text() = 'Estado Civil*:']//following-sibling::div")
    private WebElement valorCampoEstadoCivil;

    @FindBy(xpath = "//div[text() = 'Mãe*:']//following-sibling::div")
    private WebElement valorCampoMae;

    @FindBy(xpath = "//div[text() = 'Pai*:']//following-sibling::div")
    private WebElement valorCampoPai;

    @FindBy(xpath = "//div[text() = 'CPF*:']//following-sibling::div")
    private WebElement valorCampoCpf;

    @FindBy(xpath = "//div[text() = 'Tipo*:']//following-sibling::div")
    private WebElement valorCampoTipo;

    @FindBy(xpath = "//div[text() = 'Número*:']//following-sibling::div")
    private WebElement valorCampoNumero;

    @FindBy(xpath = "//div[text() = 'Órgão emissor*:']//following-sibling::div")
    private WebElement valorCampoOrgaoEmissor;

    @FindBy(xpath = "//div[text() = 'UF*:']//following-sibling::div")
    private WebElement valorCampoUf;

    @FindBy(xpath = "//div[text() = 'Data de emissão*:']//following-sibling::div")
    private WebElement valorCampoDataEmissao;

    @FindBy(xpath = "//*[@class='other-nationalities']")
    private WebElement elementoOutrasNacionalidades;

    @FindBy(xpath = "//*[@class='other-nationalities__has-nif']")
    private WebElement elementoNif;

    /**
     * Clicar na menu Dados cadastrais
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela clicarMenuDadosCadastrais() throws Exception {
        aguardarElementoHabilitado(By.id("frame-container"));
        aguardarCarregamentoElemento(By.cssSelector("div.dependentsNameContainer"));
        aguardarElementoClicavel(menuDadosCadastrais);
        clicarElemento(menuDadosCadastrais, "Não foi possível clicar no menu Dados cadastrais");
        salvarEvidencia("Clicado no menu Dados cadastrais");
        return this;
    }

    /**
     * Validar campo Foto usuário está vísivel
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarElementoFotoUsuarioEstaVisivel() throws Exception {
        validarCondicaoBooleana(aguardarCarregamentoElemento(fotoUsuario), MetodoComparacaoBooleano.VERDADEIRO, "O elemento Foto usuário não está vísivel");
        salvarEvidencia("Validar elemento Foto usuário está vísivel");
        return this;
    }

    /**
     * Validar campo nome está preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarCampoNomeEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoCpf, "Não foi possível recuperar o texto do campo Nome");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Nome está vazio");
        salvarEvidencia("Validar campo Nome não está vazio!");
        return this;
    }

    /**
     * Validar campo Apelido está preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarCampoApelidoEstaPreenchido() throws Exception {
        String apelido = retornarTexto(valorCampoApelido, "Não foi possível recuperar o texto do campo Apelido");
        validarCondicaoBooleana(apelido.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Apelido está vazio");
        salvarEvidencia("Validar campo Apelido não está vazio!");
        return this;
    }

    /**
     * Validar campo Idade está preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarCampoIdadeEstaPreenchido() throws Exception {
        String idade = retornarTexto(valorCampoIdade, "Não foi possível recuperar o texto do campo Idade");
        validarCondicaoBooleana(idade.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Idade está vazio");
        salvarEvidencia("Validar campo Idade não está vazio!");
        return this;
    }

    /**
     * Validar campo Data de Nascimento está preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarCampoDataNascimentoEstaPreenchido() throws Exception {
        String dataNascimento = retornarTexto(valorCampoDataNascimento, "Não foi possível recuperar o texto do campo Data de Nascimento");
        validarCondicaoBooleana(dataNascimento.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Data de Nascimento está vazio");
        salvarEvidencia("Validar campo Data de Nascimento não está vazio!");
        return this;
    }

    /**
     * Validar campo Genero está preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarValorCampoGeneroEstaPreenchido() throws Exception {
        String genero = retornarTexto(valorCampoGenero, "Não foi possível recuperar o texto do campo Genero");
        validarCondicaoBooleana(genero.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Genero está vazio");
        salvarEvidencia("Validar campo Genero não está vazio!");
        return this;
    }

    /**
     * Validar campo Estado Civil está preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarValorCampoEstadoCivilEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoEstadoCivil, "Não foi possível recuperar o texto do campo Estado Civil");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Estado Civil está vazio");
        salvarEvidencia("Validar campo Estado Civil não está vazio!");
        return this;
    }

    /**
     * Validar campo Mãe está preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarValorCampoMaeEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoMae, "Não foi possível recuperar o texto do campo Mãe");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Mãe está vazio");
        salvarEvidencia("Validar campo Mãe não está vazio!");
        return this;
    }

    /**
     * Validar campo Pai está preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarValorCampoPaiEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoPai, "Não foi possível recuperar o texto do campo Pai");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Pai está vazio");
        salvarEvidencia("Validar campo Pai não está vazio!");
        return this;
    }

    /**
     * Validar campo Cpf está preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarValorCampoCpfEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoCpf, "Não foi possível recuperar o texto do campo Cpf");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Cpf está vazio");
        salvarEvidencia("Validar campo Cpf não está vazio!");
        return this;
    }

    /**
     * Validar campo Tipo está preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarValorCampoTipoEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoTipo, "Não foi possível recuperar o texto do campo Tipo");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Tipo está vazio");
        salvarEvidencia("Validar campo Tipo não está vazio!");
        return this;
    }

    /**
     * Validar campo Número está preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarValorCampoNumeroEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoNumero, "Não foi possível recuperar o texto do campo Número");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Número está vazio");
        salvarEvidencia("Validar campo Número não está vazio!");
        return this;
    }

    /**
     * Validar campo Orgão Emissor está preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarValorCampoOrgaoEmissorEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoOrgaoEmissor, "Não foi possível recuperar o texto do campo Orgão Emissor");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Orgão Emissor está vazio");
        salvarEvidencia("Validar campo Orgão Emissor não está vazio!");
        return this;
    }

    /**
     * Validar campo UF está preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarValorCampoUfEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoUf, "Não foi possível recuperar o texto do campo UF");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo UF está vazio");
        salvarEvidencia("Validar campo UF não está vazio!");
        return this;
    }

    /**
     * Validar campo Data Emissão está preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarValorCampoDataEmissaoEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoDataEmissao, "Não foi possível recuperar o texto do campo Data Emissão");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Data Emissão está vazio");
        salvarEvidencia("Validar campo Data Emissão não está vazio!");
        return this;
    }

    /**
     * Validar campo Outras Nacionalidades está vísivel
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela ValidarCampoOutrasNacionalidadesEstaPresente() throws Exception {
        validarCondicaoBooleana(aguardarCarregamentoElemento(elementoOutrasNacionalidades), MetodoComparacaoBooleano.VERDADEIRO, "O elemento Outras Nacionalidades não está vísivel");
        salvarEvidencia("Validar elemento Outras Nacionalidades está vísivel");
        return this;
    }
}


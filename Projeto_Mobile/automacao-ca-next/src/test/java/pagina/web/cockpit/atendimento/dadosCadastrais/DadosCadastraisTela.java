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

    @FindBy(xpath = "//div[text() = 'G�nero*:']//following-sibling::div")
    private WebElement valorCampoGenero;

    @FindBy(xpath = "//div[text() = 'Estado Civil*:']//following-sibling::div")
    private WebElement valorCampoEstadoCivil;

    @FindBy(xpath = "//div[text() = 'M�e*:']//following-sibling::div")
    private WebElement valorCampoMae;

    @FindBy(xpath = "//div[text() = 'Pai*:']//following-sibling::div")
    private WebElement valorCampoPai;

    @FindBy(xpath = "//div[text() = 'CPF*:']//following-sibling::div")
    private WebElement valorCampoCpf;

    @FindBy(xpath = "//div[text() = 'Tipo*:']//following-sibling::div")
    private WebElement valorCampoTipo;

    @FindBy(xpath = "//div[text() = 'N�mero*:']//following-sibling::div")
    private WebElement valorCampoNumero;

    @FindBy(xpath = "//div[text() = '�rg�o emissor*:']//following-sibling::div")
    private WebElement valorCampoOrgaoEmissor;

    @FindBy(xpath = "//div[text() = 'UF*:']//following-sibling::div")
    private WebElement valorCampoUf;

    @FindBy(xpath = "//div[text() = 'Data de emiss�o*:']//following-sibling::div")
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
        clicarElemento(menuDadosCadastrais, "N�o foi poss�vel clicar no menu Dados cadastrais");
        salvarEvidencia("Clicado no menu Dados cadastrais");
        return this;
    }

    /**
     * Validar campo Foto usu�rio est� v�sivel
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarElementoFotoUsuarioEstaVisivel() throws Exception {
        validarCondicaoBooleana(aguardarCarregamentoElemento(fotoUsuario), MetodoComparacaoBooleano.VERDADEIRO, "O elemento Foto usu�rio n�o est� v�sivel");
        salvarEvidencia("Validar elemento Foto usu�rio est� v�sivel");
        return this;
    }

    /**
     * Validar campo nome est� preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarCampoNomeEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoCpf, "N�o foi poss�vel recuperar o texto do campo Nome");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Nome est� vazio");
        salvarEvidencia("Validar campo Nome n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Apelido est� preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarCampoApelidoEstaPreenchido() throws Exception {
        String apelido = retornarTexto(valorCampoApelido, "N�o foi poss�vel recuperar o texto do campo Apelido");
        validarCondicaoBooleana(apelido.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Apelido est� vazio");
        salvarEvidencia("Validar campo Apelido n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Idade est� preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarCampoIdadeEstaPreenchido() throws Exception {
        String idade = retornarTexto(valorCampoIdade, "N�o foi poss�vel recuperar o texto do campo Idade");
        validarCondicaoBooleana(idade.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Idade est� vazio");
        salvarEvidencia("Validar campo Idade n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Data de Nascimento est� preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarCampoDataNascimentoEstaPreenchido() throws Exception {
        String dataNascimento = retornarTexto(valorCampoDataNascimento, "N�o foi poss�vel recuperar o texto do campo Data de Nascimento");
        validarCondicaoBooleana(dataNascimento.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Data de Nascimento est� vazio");
        salvarEvidencia("Validar campo Data de Nascimento n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Genero est� preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarValorCampoGeneroEstaPreenchido() throws Exception {
        String genero = retornarTexto(valorCampoGenero, "N�o foi poss�vel recuperar o texto do campo Genero");
        validarCondicaoBooleana(genero.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Genero est� vazio");
        salvarEvidencia("Validar campo Genero n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Estado Civil est� preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarValorCampoEstadoCivilEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoEstadoCivil, "N�o foi poss�vel recuperar o texto do campo Estado Civil");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Estado Civil est� vazio");
        salvarEvidencia("Validar campo Estado Civil n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo M�e est� preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarValorCampoMaeEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoMae, "N�o foi poss�vel recuperar o texto do campo M�e");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo M�e est� vazio");
        salvarEvidencia("Validar campo M�e n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Pai est� preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarValorCampoPaiEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoPai, "N�o foi poss�vel recuperar o texto do campo Pai");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Pai est� vazio");
        salvarEvidencia("Validar campo Pai n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Cpf est� preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarValorCampoCpfEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoCpf, "N�o foi poss�vel recuperar o texto do campo Cpf");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Cpf est� vazio");
        salvarEvidencia("Validar campo Cpf n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Tipo est� preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarValorCampoTipoEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoTipo, "N�o foi poss�vel recuperar o texto do campo Tipo");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Tipo est� vazio");
        salvarEvidencia("Validar campo Tipo n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo N�mero est� preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarValorCampoNumeroEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoNumero, "N�o foi poss�vel recuperar o texto do campo N�mero");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo N�mero est� vazio");
        salvarEvidencia("Validar campo N�mero n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Org�o Emissor est� preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarValorCampoOrgaoEmissorEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoOrgaoEmissor, "N�o foi poss�vel recuperar o texto do campo Org�o Emissor");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Org�o Emissor est� vazio");
        salvarEvidencia("Validar campo Org�o Emissor n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo UF est� preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarValorCampoUfEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoUf, "N�o foi poss�vel recuperar o texto do campo UF");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo UF est� vazio");
        salvarEvidencia("Validar campo UF n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Data Emiss�o est� preenchido
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela validarValorCampoDataEmissaoEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoDataEmissao, "N�o foi poss�vel recuperar o texto do campo Data Emiss�o");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Data Emiss�o est� vazio");
        salvarEvidencia("Validar campo Data Emiss�o n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Outras Nacionalidades est� v�sivel
     *
     * @return DadosCadastraisTela
     * @throws Exception
     */
    public DadosCadastraisTela ValidarCampoOutrasNacionalidadesEstaPresente() throws Exception {
        validarCondicaoBooleana(aguardarCarregamentoElemento(elementoOutrasNacionalidades), MetodoComparacaoBooleano.VERDADEIRO, "O elemento Outras Nacionalidades n�o est� v�sivel");
        salvarEvidencia("Validar elemento Outras Nacionalidades est� v�sivel");
        return this;
    }
}


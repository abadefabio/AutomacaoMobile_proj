package pagina.web.cockpit.atendimento.dadosCadastrais;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContaNextTela extends PaginaBaseWeb {

    public ContaNextTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Conta Next')]")
    private WebElement abaContaNext;

    @FindBy(xpath = "//div[text() = 'Agência:']//following-sibling::div")
    private WebElement valorCampoAgencia;

    @FindBy(xpath = "//div[text() = 'Número da conta:']//following-sibling::div")
    private WebElement valorCampoNumeroConta;

    @FindBy(xpath = "//div[text() = 'Data da adesão:']//following-sibling::div")
    private WebElement valorCampoDataAdesao;

    @FindBy(xpath = "//div[text() = 'Tipo:']//following-sibling::div")
    private WebElement valorCampoTipo;

    @FindBy(xpath = "//div[text() = 'Modalidade da conta']//following-sibling::div")
    private WebElement valorCampoModalidadeConta;

    @FindBy(xpath = "//div[text() = 'Segmento']//following-sibling::div")
    private WebElement valorCampoSegmento;

    @FindBy(xpath = "//div[text() = 'Parentesco']//following-sibling::div")
    private WebElement valorCampoParentesco;

    @FindBy(xpath = "//div[text() = 'Número do cartão']//following-sibling::div")
    private WebElement valorCampoNumeroCartao;

    /**
     * Clicar na aba Conta Next
     */
    public ContaNextTela clicarAbaContaNext() throws Exception {
        clicarElemento(abaContaNext, "Não foi possível clicar na aba Conta Next");
        salvarEvidencia("Clicado aba Conta Next");
        return this;
    }

    /**
     * Validar campo Agência está preenchido
     *
     * @return ContaNextTela
     * @throws Exception
     */
    public ContaNextTela validarValorCampoAgenciaEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoAgencia, "Não foi possível recuperar o texto do campo Agência");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Agência está vazio");
        salvarEvidencia("Validar campo Agência não está vazio!");
        return this;
    }

    /**
     * Validar campo Número Conta está preenchido
     *
     * @return ContaNextTela
     * @throws Exception
     */
    public ContaNextTela validarValorCampoNumeroContaEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoNumeroConta, "Não foi possível recuperar o texto do campo Número Conta");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Número Conta está vazio");
        salvarEvidencia("Validar campo Número Conta não está vazio!");
        return this;
    }

    /**
     * Validar campo Data Adesão está preenchido
     *
     * @return ContaNextTela
     * @throws Exception
     */
    public ContaNextTela validarValorCampoDataAdesaoEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoDataAdesao, "Não foi possível recuperar o texto do campo Data Adesão");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Data Adesão está vazio");
        salvarEvidencia("Validar campo Data Adesão não está vazio!");
        return this;
    }

    /**
     * Validar campo Tipo está preenchido
     *
     * @return ContaNextTela
     * @throws Exception
     */
    public ContaNextTela validarValorCampoTipoEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoTipo, "Não foi possível recuperar o texto do campo Tipo");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Tipo está vazio");
        salvarEvidencia("Validar campo Tipo não está vazio!");
        return this;
    }

    /**
     * Validar campo Mobalidade Conta está preenchido
     *
     * @return ContaNextTela
     * @throws Exception
     */
    public ContaNextTela validarValorCampoModalidadeContaEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoModalidadeConta, "Não foi possível recuperar o texto do campo Mobalidade Conta");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Mobalidade Conta está vazio");
        salvarEvidencia("Validar campo Mobalidade Conta não está vazio!");
        return this;
    }

    /**
     * Validar campo Segmento está preenchido
     *
     * @return ContaNextTela
     * @throws Exception
     */
    public ContaNextTela validarValorCampoSegmentoEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoSegmento, "Não foi possível recuperar o texto do campo Segmento");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Segmento está vazio");
        salvarEvidencia("Validar campo Segmento não está vazio!");
        return this;
    }

    /**
     * Validar campo Parentesco está preenchido
     *
     * @return ContaNextTela
     * @throws Exception
     */
    public ContaNextTela validarValorCampoParentescoEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoParentesco, "Não foi possível recuperar o texto do campo Parentesco");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Parentesco está vazio");
        salvarEvidencia("Validar campo Parentesco não está vazio!");
        return this;
    }

    /**
     * Validar campo Número Cartão está preenchido
     *
     * @return ContaNextTela
     * @throws Exception
     */
    public ContaNextTela validarValorCampoNumeroCartaoEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoNumeroCartao, "Não foi possível recuperar o texto do campo Número Cartão");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Número Cartão está vazio");
        salvarEvidencia("Validar campo Número Cartão não está vazio!");
        return this;
    }
}

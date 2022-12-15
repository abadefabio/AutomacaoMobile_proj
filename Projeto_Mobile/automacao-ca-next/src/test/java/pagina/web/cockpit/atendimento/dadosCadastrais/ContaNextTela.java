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

    @FindBy(xpath = "//div[text() = 'Ag�ncia:']//following-sibling::div")
    private WebElement valorCampoAgencia;

    @FindBy(xpath = "//div[text() = 'N�mero da conta:']//following-sibling::div")
    private WebElement valorCampoNumeroConta;

    @FindBy(xpath = "//div[text() = 'Data da ades�o:']//following-sibling::div")
    private WebElement valorCampoDataAdesao;

    @FindBy(xpath = "//div[text() = 'Tipo:']//following-sibling::div")
    private WebElement valorCampoTipo;

    @FindBy(xpath = "//div[text() = 'Modalidade da conta']//following-sibling::div")
    private WebElement valorCampoModalidadeConta;

    @FindBy(xpath = "//div[text() = 'Segmento']//following-sibling::div")
    private WebElement valorCampoSegmento;

    @FindBy(xpath = "//div[text() = 'Parentesco']//following-sibling::div")
    private WebElement valorCampoParentesco;

    @FindBy(xpath = "//div[text() = 'N�mero do cart�o']//following-sibling::div")
    private WebElement valorCampoNumeroCartao;

    /**
     * Clicar na aba Conta Next
     */
    public ContaNextTela clicarAbaContaNext() throws Exception {
        clicarElemento(abaContaNext, "N�o foi poss�vel clicar na aba Conta Next");
        salvarEvidencia("Clicado aba Conta Next");
        return this;
    }

    /**
     * Validar campo Ag�ncia est� preenchido
     *
     * @return ContaNextTela
     * @throws Exception
     */
    public ContaNextTela validarValorCampoAgenciaEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoAgencia, "N�o foi poss�vel recuperar o texto do campo Ag�ncia");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Ag�ncia est� vazio");
        salvarEvidencia("Validar campo Ag�ncia n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo N�mero Conta est� preenchido
     *
     * @return ContaNextTela
     * @throws Exception
     */
    public ContaNextTela validarValorCampoNumeroContaEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoNumeroConta, "N�o foi poss�vel recuperar o texto do campo N�mero Conta");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo N�mero Conta est� vazio");
        salvarEvidencia("Validar campo N�mero Conta n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Data Ades�o est� preenchido
     *
     * @return ContaNextTela
     * @throws Exception
     */
    public ContaNextTela validarValorCampoDataAdesaoEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoDataAdesao, "N�o foi poss�vel recuperar o texto do campo Data Ades�o");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Data Ades�o est� vazio");
        salvarEvidencia("Validar campo Data Ades�o n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Tipo est� preenchido
     *
     * @return ContaNextTela
     * @throws Exception
     */
    public ContaNextTela validarValorCampoTipoEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoTipo, "N�o foi poss�vel recuperar o texto do campo Tipo");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Tipo est� vazio");
        salvarEvidencia("Validar campo Tipo n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Mobalidade Conta est� preenchido
     *
     * @return ContaNextTela
     * @throws Exception
     */
    public ContaNextTela validarValorCampoModalidadeContaEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoModalidadeConta, "N�o foi poss�vel recuperar o texto do campo Mobalidade Conta");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Mobalidade Conta est� vazio");
        salvarEvidencia("Validar campo Mobalidade Conta n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Segmento est� preenchido
     *
     * @return ContaNextTela
     * @throws Exception
     */
    public ContaNextTela validarValorCampoSegmentoEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoSegmento, "N�o foi poss�vel recuperar o texto do campo Segmento");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Segmento est� vazio");
        salvarEvidencia("Validar campo Segmento n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo Parentesco est� preenchido
     *
     * @return ContaNextTela
     * @throws Exception
     */
    public ContaNextTela validarValorCampoParentescoEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoParentesco, "N�o foi poss�vel recuperar o texto do campo Parentesco");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo Parentesco est� vazio");
        salvarEvidencia("Validar campo Parentesco n�o est� vazio!");
        return this;
    }

    /**
     * Validar campo N�mero Cart�o est� preenchido
     *
     * @return ContaNextTela
     * @throws Exception
     */
    public ContaNextTela validarValorCampoNumeroCartaoEstaPreenchido() throws Exception {
        String nome = retornarTexto(valorCampoNumeroCartao, "N�o foi poss�vel recuperar o texto do campo N�mero Cart�o");
        validarCondicaoBooleana(nome.isEmpty(), MetodoComparacaoBooleano.FALSO, "O campo N�mero Cart�o est� vazio");
        salvarEvidencia("Validar campo N�mero Cart�o n�o est� vazio!");
        return this;
    }
}

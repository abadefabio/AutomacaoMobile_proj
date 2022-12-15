package pagina.web.cockpit.atendimento.dadosCadastrais;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DocumentosTela extends PaginaBaseWeb {

    public DocumentosTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Documentos ')]")
    private WebElement abaDocumentos;

    @FindBy(xpath = "//*[@class='mat-icon-button mat-button-base']")
    private WebElement campoCalendarioInicio;

    @FindBy(xpath = "//*[@class='mat-icon-button mat-button-base']")
    private WebElement campoCalendarioFinal;

    @FindBy(id = "mat-input-2")
    private WebElement campoAnoAtual;

    @FindBy(id = "mat-input-3")
    private WebElement campoMesAtual;

    /**
     * Clicar na aba Documentos
     *
     * @return DocumentosTela
     * @throws Exception
     */
    public DocumentosTela clicarAbaDocumentos() throws Exception {
        clicarElemento(abaDocumentos, "N�o foi poss�vel clicar na aba Documentos");
        salvarEvidencia("Clicado aba Documentos");
        return this;
    }

    /**
     * Validar campo Calend�rio In�cio est� v�sivel
     *
     * @return DocumentosTela
     * @throws Exception
     */
    public DocumentosTela ValidarCampoCalendarioInicioEstaPresente() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(campoCalendarioInicio), MetodoComparacaoBooleano.VERDADEIRO, "O elemento Calend�rio In�cio n�o est� v�sivel");
        salvarEvidencia("Validar elemento Calend�rio In�cio est� v�sivel");
        return this;
    }

    /**
     * Validar campo Calend�rio Final est� v�sivel
     *
     * @return DocumentosTela
     * @throws Exception
     */
    public DocumentosTela ValidarCampoCalendarioFinalEstaPresente() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(campoCalendarioFinal), MetodoComparacaoBooleano.VERDADEIRO, "O elemento Calend�rio Final n�o est� v�sivel");
        salvarEvidencia("Validar elemento Calend�rio Final est� v�sivel");
        return this;
    }

    /**
     * Validar campo Ano Atual est� v�sivel
     *
     * @return DocumentosTela
     * @throws Exception
     */
    public DocumentosTela ValidarCampoAnoAtualEstaPresente() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(campoAnoAtual), MetodoComparacaoBooleano.VERDADEIRO, "O elemento Ano Atual n�o est� v�sivel");
        salvarEvidencia("Validar elemento Ano Atual est� v�sivel");
        return this;
    }

    /**
     * Validar campo Mes Atual est� v�sivel
     *
     * @return DocumentosTela
     * @throws Exception
     */
    public DocumentosTela ValidarCampoMesAtualEstaPresente() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(campoMesAtual), MetodoComparacaoBooleano.VERDADEIRO, "O elemento Mes Atual n�o est� v�sivel");
        salvarEvidencia("Validar elemento Mes Atual est� v�sivel");
        return this;
    }
}

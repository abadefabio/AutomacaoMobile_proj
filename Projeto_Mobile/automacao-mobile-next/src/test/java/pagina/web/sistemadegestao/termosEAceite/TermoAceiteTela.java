package pagina.web.sistemadegestao.termosEAceite;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import framework.WebUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class TermoAceiteTela extends PaginaBaseWeb {

    @FindAll({
            @FindBy(id = "formFilter:documentTypeId"),
            @FindBy(name = "formFilter:documentTypeId")
    })
    private WebElement inputCampoTipoDocumento;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement botaoConsultar;

    @FindBy(xpath = "//script[@src='/next_gestao/javax.faces.resource/jsf.js.xhtml?ln=javax.faces']/following-sibling::a[1]")
    private WebElement botaoDetalhe;

    @FindBy(xpath = "//div[@class='card-header']//h3[1]")
    private WebElement tituloTela;

    @FindBy(xpath = "//label[text()='Tipo de Documento']")
    private WebElement campoTipoDocumento;

    @FindBy(xpath = "//label[text()='Preview da mensagem']")
    private WebElement campoPreview;

    public TermoAceiteTela(WebDriver driver) {
        super(driver);
    }


    /** Clicar no botão detalhe para acessar os detalhes do tipo de documento
     * @return
     * @throws Exception
     */
    @Step("Preencher Tipo Documento no campo 'Tipo Documento'")
    public TermoAceiteTela preencherCampoTipoDocumento(String tipoDocumento) throws Exception{
        WebUtils.aguardarCarregamentoDaPagina(driver);
        salvarEvidencia("Preencher Tipo Documento no campo 'Tipo Documento'");
        digitarTexto(inputCampoTipoDocumento, tipoDocumento,"Nao foi possivel preecher campo Tipo Documento");
        salvarEvidencia("Preencheu o campo: 'Tipo Documento': [" + tipoDocumento + "]");
        return this;
    }

    /** Clicar no botão consultar
     * @return
     * @throws Exception
     */
    @Step("Clicar no botao Consultar")
    public TermoAceiteTela clicarBotaoConsultar() throws Exception {
        salvarEvidencia("Clicar no botao 'CONSULTAR'");
        aguardarElementoClicavel(botaoConsultar);
        aguardarElementoHabilitado(botaoConsultar);
        clicarElemento(botaoConsultar,"Nao foi possivel clicar no botao Consultar");
        WebUtils.aguardarCarregamentoDaPagina(driver);
        return this;
    }

    /** Clicar no botão detalhe para acessar os detalhes do tipo de documento
     * @return
     * @throws Exception
     */
    @Step("Clicar no botao 'Detalhe'")
    public TermoAceiteTela clicarBotaoDetalhe() throws Exception {
        WebUtils.aguardarCarregamentoDaPagina(driver);
        aguardarElementoClicavel(botaoDetalhe);
        aguardarElementoHabilitado(botaoDetalhe);
        salvarEvidencia("Clicar no botao 'DETALHE'");
        clicarElemento(botaoDetalhe,"Nao foi possivel clicar no botao 'Detalhe'");
        return this;
    }

    /** validar texto do titulo da pagina
     * @param texto
     * @return
     * @throws Exception
     */
    @Step("validar texto do titulo da pagina.")
    public TermoAceiteTela validarTituloTelaDetalhe(String texto) throws Exception {
        WebUtils.aguardarCarregamentoDaPagina(driver);
        aguardarCarregamentoElemento(tituloTela);
        validarAtributoTexto(tituloTela, texto,"Nao foi possivel validar o texto.");
        salvarEvidencia("Validar o titulo da pagina: '" + texto + "'");
        return this;
    }

    /** validar texto do campo Tipo de Documento
     * @param texto
     * @return
     * @throws Exception
     */
    @Step("validar texto do Tipo de Documento")
    public TermoAceiteTela validarCampoDetalhe(String texto) throws Exception {
        aguardarCarregamentoElemento(campoTipoDocumento);
        validarAtributoTexto(campoTipoDocumento, texto,"Nao foi possivel validar o texto.");
        salvarEvidencia("Validar campo da pagina: '" + texto + "'");
        return this;
    }

    /** validar texto 'Preview'
     * @param texto
     * @return
     * @throws Exception
     */
    @Step("validar texto 'Preview'")
    public TermoAceiteTela validarCampoPrivew(String texto) throws Exception {
        validarAtributoTexto(campoPreview,texto,"Nao foi possivel validar o texto 'Preview'");
        salvarEvidencia("validar texto do Preview");
        return this;
    }
}

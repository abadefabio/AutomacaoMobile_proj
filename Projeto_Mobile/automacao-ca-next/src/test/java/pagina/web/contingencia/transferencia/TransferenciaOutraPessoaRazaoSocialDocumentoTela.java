package pagina.web.contingencia.transferencia;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TransferenciaOutraPessoaRazaoSocialDocumentoTela extends TransferenciaTela {

    public TransferenciaOutraPessoaRazaoSocialDocumentoTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "recipientName")
    private WebElement campoRazaoSocialNome;

    @FindBy(id = "recipientCpfCnpj")
    private WebElement campoDocumentoCpfCnpj;

    /**
     * Metódo para informar razão social ou nome do destinatário
     * @return
     * @throws Exception
     */
    @Step("Informar razão social ou nome do destinatário")
    public TransferenciaOutraPessoaRazaoSocialDocumentoTela informarRazaoSocialNome(String nome) throws Exception {
        rolarParaBaixoAteElemento(campoRazaoSocialNome);
        aguardarCarregamentoElemento(campoRazaoSocialNome);
        salvarEvidencia("Informado razão social ou nome: " + nome);
        digitarTexto(campoRazaoSocialNome, nome, "Não foi possível informar a razão social ou nome do destinatário " + nome);
        return this;
    }

    /**
     * Metódo para informar cpf ou cnpj destinatário
     * @throws Exception
     * @return
     */
    @Step("Informar CPF ou CNPJ destinatário")
    public TransferenciaOutraPessoaRazaoSocialDocumentoTela informarCpfCnpj(String cpfcnpj) throws Exception {
        rolarParaBaixoAteElemento(campoDocumentoCpfCnpj);
        aguardarCarregamentoElemento(campoDocumentoCpfCnpj);
        salvarEvidencia("Informado CPF ou CNPJ: " + cpfcnpj);
        digitarTexto(campoDocumentoCpfCnpj, cpfcnpj, "Não foi possível informar o CPF ou CNPJ do destinatário " + cpfcnpj);
        return this;
    }
}

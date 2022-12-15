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
     * Met�do para informar raz�o social ou nome do destinat�rio
     * @return
     * @throws Exception
     */
    @Step("Informar raz�o social ou nome do destinat�rio")
    public TransferenciaOutraPessoaRazaoSocialDocumentoTela informarRazaoSocialNome(String nome) throws Exception {
        rolarParaBaixoAteElemento(campoRazaoSocialNome);
        aguardarCarregamentoElemento(campoRazaoSocialNome);
        salvarEvidencia("Informado raz�o social ou nome: " + nome);
        digitarTexto(campoRazaoSocialNome, nome, "N�o foi poss�vel informar a raz�o social ou nome do destinat�rio " + nome);
        return this;
    }

    /**
     * Met�do para informar cpf ou cnpj destinat�rio
     * @throws Exception
     * @return
     */
    @Step("Informar CPF ou CNPJ destinat�rio")
    public TransferenciaOutraPessoaRazaoSocialDocumentoTela informarCpfCnpj(String cpfcnpj) throws Exception {
        rolarParaBaixoAteElemento(campoDocumentoCpfCnpj);
        aguardarCarregamentoElemento(campoDocumentoCpfCnpj);
        salvarEvidencia("Informado CPF ou CNPJ: " + cpfcnpj);
        digitarTexto(campoDocumentoCpfCnpj, cpfcnpj, "N�o foi poss�vel informar o CPF ou CNPJ do destinat�rio " + cpfcnpj);
        return this;
    }
}

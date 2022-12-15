package pagina.web.cockpit.login;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class LoginWebTela extends PaginaBaseWeb {


    public LoginWebTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "func")
    private WebElement inputFuncionalidade;

    @FindBy(id = "coreIp")
    private WebElement inputCoreIp;

    @FindBy(id = "cpf")
    private WebElement inputCPF;

    @FindBy(id = "proposalId")
    private WebElement inputProposalId;

    @FindBy(id = "prospectProposalId")
    private WebElement inputProspectId;

    @FindBy(id = "textAreaToken")
    private WebElement textAreaToken;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement btnRedirecionar;

    @FindBy(id = "operador")
    private WebElement inputOperador;

    @FindBy(id = "nomeOperador")
    private WebElement inputNomeOperador;



    /**
     * Fechar aviso de sessão inválida ao acessar o emulador
     */
    public LoginWebTela fecharAlertSessaoInvalida() throws InterruptedException {
        long incio = System.currentTimeMillis();
        while (System.currentTimeMillis() - incio < 10000) {
            try {
                getWebDriver().switchTo().alert().accept();
                break;
            } catch (Exception e) {
                Thread.sleep(100);
            }
        }
        return this;
    }

    /**
     * Preencher campo Funcionalidade
     */
    public LoginWebTela informarFuncionalidade(String funcionalidade) throws Exception {
        aguardarCarregamentoElemento(inputFuncionalidade);
        digitarTexto(inputFuncionalidade, funcionalidade, "Não foi possível digitar o texto " + funcionalidade + ". No campo Funcionalidade.");
        salvarEvidencia("Informar funcionalidade");
        return this;
    }

    /**
     * Preencher campo CoreIp
     */
    public LoginWebTela informarCoreIp(String coreIp) throws Exception {
        aguardarCarregamentoElemento(inputCoreIp);
        digitarTexto(inputCoreIp, coreIp, "Não foi possível digitar o texto: " + coreIp + ". No campo CoreIP");
        salvarEvidencia("Informar CoreIP");
        return this;
    }

    /**
     * Preencher campo CPF
     */
    public LoginWebTela informarCpf(String cpf) throws Exception {
        aguardarCarregamentoElemento(inputCPF);
        digitarTexto(inputCPF, cpf, "Não foi possível digitar o texto: " + cpf + ". No campo CPF");
        salvarEvidencia("Informar CPF");
        return this;
    }

    /**
     * Preencher campo ProposalId
     */
    public LoginWebTela informarProposalId(String proposalId) throws Exception {
        aguardarCarregamentoElemento(inputProposalId);
        digitarTexto(inputProposalId, proposalId, "Não foi possível digitar o texto: " + proposalId + ". No campo Proposal Id");
        salvarEvidencia("Informar Proposal Id");
        return this;
    }

    /**
     * Preencher campo ProspectId
     */
    public LoginWebTela informarProspectId(String prospectId) throws Exception {
        aguardarCarregamentoElemento(inputProspectId);
        digitarTexto(inputProspectId, prospectId, "Não foi possível digitar o texto: " + prospectId + ". No campo Prospect Id");
        salvarEvidencia("Informar Prospect Id");
        return this;
    }

    /**
     * Preencher campo Token
     */
    public LoginWebTela informarToken(String token) throws Exception {
        aguardarCarregamentoElemento(textAreaToken);
        digitarTexto(textAreaToken, token, "Não foi possível digitar o texto: " + token + ". No campo Token");
        salvarEvidencia("Informar Token");
        return this;
    }

    /**
     * Clicar no botão redirecionar
     */
    public LoginWebTela clicarBotaoRedirecionar() throws Exception {
        salvarEvidencia("Clicar botão redirecionar");
        clicarElemento(btnRedirecionar, "Não foi possível tocar no botão redirecionar");
        return this;
    }

    /**
     * Preencher campo inputOperador
     */
    public LoginWebTela informarIdOperador(String operador) throws Exception {
        aguardarCarregamentoElemento(inputOperador);
        digitarTexto(inputOperador, operador, "Não foi possível digitar o texto: " + operador + ". No campo inputOperador ");
        salvarEvidencia("Informar inputOperador");
        return this;
    }



    /**
     * Preencher campo nomeOperador
     */
    public LoginWebTela informarNomeOperador(String nomeOperador) throws Exception {
        aguardarCarregamentoElemento(inputNomeOperador);
        digitarTexto(inputNomeOperador, nomeOperador, "Não foi possível digitar o texto: " + nomeOperador + ". No campo inputNomeOperador ");
        salvarEvidencia("Informar inputNomeOperador");
        return this;
    }





}


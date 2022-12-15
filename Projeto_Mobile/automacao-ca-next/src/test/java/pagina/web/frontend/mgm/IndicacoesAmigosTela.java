package pagina.web.frontend.mgm;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndicacoesAmigosTela extends PaginaBaseWeb {

    public IndicacoesAmigosTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "td.mat-cell.cdk-column-invitedName.mat-column-invitedName.ng-star-inserted div.next-text")
    private WebElement columnConvidado;

    @FindBy(css = "td.mat-cell.cdk-column-invitedCpf.mat-column-invitedCpf.ng-star-inserted div.next-text")
    private WebElement columnCpfConvidado;

    @FindBy(css = "td.mat-cell.cdk-column-inviteAcceptedDate.mat-column-inviteAcceptedDate.ng-star-inserted div.next-text")
    private WebElement columnDataAceite;

    @FindBy(css = "td.mat-cell.cdk-column-openAccountStatus.mat-column-openAccountStatus.ng-star-inserted div.next-text")
    private WebElement columnStatusConta;

    @FindBy(css = "td.mat-cell.cdk-column-openAccountDate.mat-column-openAccountDate.ng-star-inserted div.next-text")
    private WebElement columnDataAbertura;

    @FindBy(css = "td.mat-cell.cdk-column-previsionBonus.mat-column-previsionBonus.ng-star-inserted div.next-text")
    private WebElement columnPrevisaoBonus;

    /**
     * Validar texto da coluna Convidado da tabela Indique Amigos
     *
     * @param texto
     * @throws Exception
     * @return IndicacoesAmigosCpfTela
     */
    @Step("Validar texto da coluna Convidado")
    public IndicacoesAmigosTela validarTextoColunaConvidado(String texto) throws Exception {
        aguardarCarregamentoElemento(columnConvidado);
        rolarAteElemento(columnConvidado, "Não foi possível rolar a página até o elemento: " + columnConvidado);
        validarAtributoTexto(columnConvidado, texto, "Não foi possível validar o texto: " + texto + " da coluna Convidado.");
        salvarEvidencia("Validar texto da Coluna Convidado");
        return this;
    }

    /**
     * Validar texto da coluna CPF Convidado da tabela Indique Amigos
     *
     * @param texto
     * @throws Exception
     * @return IndicacoesAmigosCpfTela
     */
    @Step("Validar texto da coluna CPF Convidado")
    public IndicacoesAmigosTela validarTextoColunaCpfConvidado(String texto) throws Exception {
        validarAtributoTexto(columnCpfConvidado, texto, "Não foi possível validar o texto: " + texto + " da coluna CPF Convidado.");
        salvarEvidencia("Validar texto da Coluna CPF Convidado");
        return this;
    }

    /**
     * Validar texto da coluna Data do Aceite da tabela Indique Amigos
     *
     * @param texto
     * @throws Exception
     * @return IndicacoesAmigosCpfTela
     */
    @Step("Validar texto da coluna Data do Aceite")
    public IndicacoesAmigosTela validarTextoColunaDataAceite(String texto) throws Exception {
        validarAtributoTexto(columnDataAceite, texto, "Não foi possível validar o texto: " + texto + " da coluna Data do Aceite.");
        salvarEvidencia("Validar texto da Coluna Data do Aceite");
        return this;
    }

    /**
     * Validar texto da coluna Status da Conta da tabela Indique Amigos
     *
     * @param texto
     * @throws Exception
     * @return IndicacoesAmigosCpfTela
     */
    @Step("Validar texto da coluna Status da Conta")
    public IndicacoesAmigosTela validarTextoColunaStatusConta(String texto) throws Exception {
        validarAtributoTexto(columnStatusConta, texto, "Não foi possível validar o texto: " + texto + " da coluna Status da Conta.");
        salvarEvidencia("Validar texto da Coluna Status da Conta");
        return this;
    }

    /**
     * Validar texto da coluna Data de Abertura da tabela Indique Amigos
     *
     * @param texto
     * @throws Exception
     * @return IndicacoesAmigosCpfTela
     */
    @Step("Validar texto da coluna Data de Abertura")
    public IndicacoesAmigosTela validarTextoColunaDataAbertura(String texto) throws Exception {
        validarAtributoTexto(columnDataAbertura, texto, "Não foi possível validar o texto: " + texto + " da coluna Data de Abertura.");
        salvarEvidencia("Validar texto da Coluna Data de Abertura");
        return this;
    }

    /**
     * Validar texto da coluna Previsão do Bônus da tabela Indique Amigos
     *
     * @param texto
     * @throws Exception
     * @return IndicacoesAmigosCpfTela
     */
    @Step("Validar texto da coluna Previsão do Bônus")
    public IndicacoesAmigosTela validarTextoColunaPrevisaoBonus(String texto) throws Exception {
        validarAtributoTexto(columnPrevisaoBonus, texto, "Não foi possível validar o texto: " + texto + " da coluna Previsão do Bônus.");
        salvarEvidencia("Validar texto da Coluna Previsão do Bônus");
        return this;
    }
}

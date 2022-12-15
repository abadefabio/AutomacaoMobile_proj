package pagina.web.frontend.mgm;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndicacoesAmigosCpfIndicadorTela extends IndicacoesAmigosCpfTela {

    public IndicacoesAmigosCpfIndicadorTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[name='convidado'][placeholder='Convidado'][type='text']")
    private WebElement inputNomeConvidado;

    @FindBy(css = "ng-select[bindlabel='label'][formcontrolname='status'][role='listbox']")
    private WebElement selectStatusConta;

    @FindBy(css = "input[formcontrolname='invitedCpf'][name='CPF'][type='text']")
    private WebElement inputCpfConvidado;

    @FindBy(css = "input[formcontrolname='startDate']")
    private WebElement inputDataInicio;

    @FindBy(css = "input[formcontrolname='endDate']")
    private WebElement inputDataFim;

    /**
     * Informar o Nome do Convidado nos filtros do CPF Indicador da tela de Indica��es de Amigos
     *
     * @param nomeConvidado
     * @throws Exception
     * @return IndicacoesAmigosCpfTela
     */
    @Step("Entrar com CPF Indicador")
    public IndicacoesAmigosCpfIndicadorTela informarNomeConvidado(String nomeConvidado) throws Exception {
        aguardarCarregamentoQualquerElemento(inputNomeConvidado);
        digitarTexto(inputNomeConvidado, nomeConvidado, "N�o foi poss�vel informar o Nome do Convidado: " + nomeConvidado);
        salvarEvidencia("Informar o Nome do Convidado");
        return this;
    }

    /**
     * Selecionar a op��o do Status da Conta nos filtros do CPF Indicador da tela de Indica��es de Amigos
     *
     * @param opcaoStatusConta
     * @throws Exception
     * @return IndicacoesAmigosCpfTela
     */
    @Step("Selecionar op��o de Status da Conta")
    public IndicacoesAmigosCpfIndicadorTela selecionarOpcaoStatusConta(String opcaoStatusConta) throws Exception {
        aguardarCarregamentoQualquerElemento(selectStatusConta);
        selecionarTextoCombobox(selectStatusConta, opcaoStatusConta, "N�o foi poss�vel selecionar a op��o do Status da Conta: " + opcaoStatusConta);
        salvarEvidencia("Selecionar a op��o do Status da Conta");
        return this;
    }

    /**
     * Informar o CPF do Convidado nos filtros do CPF Indicador da tela de Indica��es de Amigos
     *
     * @param cpfConvidado
     * @throws Exception
     * @return IndicacoesAmigosCpfTela
     */
    @Step("Entrar com CPF Convidado")
    public IndicacoesAmigosCpfIndicadorTela informarCpfConvidado(String cpfConvidado) throws Exception {
        aguardarCarregamentoQualquerElemento(inputCpfConvidado);
        digitarTexto(inputCpfConvidado, cpfConvidado, "N�o foi poss�vel informar o CPF Convidado: " + cpfConvidado);
        salvarEvidencia("Informar o CPF Convidado");
        return this;
    }

    /**
     * Informar a Data In�cio nos filtros do CPF Indicador da tela de Indica��es de Amigos
     *
     * @param dataInicio
     * @throws Exception
     * @return IndicacoesAmigosCpfTela
     */
    @Step("Entrar com Data In�cio")
    public IndicacoesAmigosCpfIndicadorTela informarDataInicio(String dataInicio) throws Exception {
        aguardarCarregamentoQualquerElemento(inputDataInicio);
        digitarTexto(inputDataInicio, dataInicio, "N�o foi poss�vel informar a Data In�cio: " + dataInicio);
        salvarEvidencia("Informar a Data In�cio");
        return this;
    }

    /**
     * Informar a Data Fim nos filtros do CPF Indicador da tela de Indica��es de Amigos
     *
     * @param dataFim
     * @throws Exception
     * @return IndicacoesAmigosCpfTela
     */
    @Step("Entrar com Data Fim")
    public IndicacoesAmigosCpfIndicadorTela informarDataFim(String dataFim) throws Exception {
        aguardarCarregamentoQualquerElemento(inputDataFim);
        digitarTexto(inputDataFim, dataFim, "N�o foi poss�vel informar a Data Fim: " + dataFim);
        salvarEvidencia("Informar a Data Fim");
        return this;
    }
}

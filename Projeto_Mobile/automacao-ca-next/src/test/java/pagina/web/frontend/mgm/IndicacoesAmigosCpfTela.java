package pagina.web.frontend.mgm;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pagina.web.frontend.base.GestaoOcorrenciasTela;

public class IndicacoesAmigosCpfTela extends GestaoOcorrenciasTela {

    public IndicacoesAmigosCpfTela(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "input[name='indicador']")
    private WebElement inputCpfIndicador;

    @FindBy(css = "input[name='convidado']")
    private WebElement inputCpfConvidado;

    @FindBy(xpath = "//button[text()='Limpar']")
    private WebElement btnLimpar;

    @FindBy(xpath = "//button[text()='Buscar']")
    private WebElement btnBuscar;

    /**
     * Informar o CPF Indicador na p�gina de Indica��es de Amigos do menu Hamburguer
     *
     * @param cpfIndicador
     * @throws Exception
     * @return IndicacoesAmigosCpfTela
     */
    @Step("Entrar com CPF Indicador")
    public IndicacoesAmigosCpfTela informarCpfIndicador(String cpfIndicador) throws Exception {
        aguardarCarregamentoQualquerElemento(btnBuscar);
        digitarTexto(inputCpfIndicador, cpfIndicador, "N�o foi poss�vel informar o CPF Indicador: " + cpfIndicador);
        salvarEvidencia("Informar o CPF Indicador");
        return this;
    }

    /**
     * Informar o CPF Convidado na p�gina de Indica��es de Amigos do menu Hamburguer
     *
     * @param cpfConvidado
     * @throws Exception
     * @return IndicacoesAmigosCpfTela
     */
    @Step("Entrar com CPF Convidado")
    public IndicacoesAmigosCpfTela informarCpfConvidado(String cpfConvidado) throws Exception {
        aguardarCarregamentoQualquerElemento(btnBuscar);
        digitarTexto(inputCpfConvidado, cpfConvidado, "N�o foi poss�vel informar o CPF Convidado: " + cpfConvidado);
        salvarEvidencia("Informar o CPF Convidado");
        return this;
    }

    /**
     * Clicar no bot�o Buscar para abrir a tela de Indica��es de Amigos
     *
     * @throws Exception
     * @return IndicacoesAmigosCpfTela
     */
    @Step("Clicar no bot�o Buscar")
    public IndicacoesAmigosCpfTela clicarBotaoBuscar() throws Exception {
        clicarElemento(btnBuscar, "N�o foi poss�vel clicar no bot�o Buscar");
        aguardarContainerCarregamentoPaginaDesaparecer();
        salvarEvidencia("Clicar no bot�o Buscar");
        return this;
    }

    /**
     * Clicar no bot�o Limpar para limpar os campos de pesquisa da tela de Indica��es de Amigos
     *
     * @throws Exception
     * @return IndicacoesAmigosCpfTela
     */
    @Step("Clicar no bot�o Limpar")
    public IndicacoesAmigosCpfTela clicarBotaoLimpar() throws Exception {
        clicarElemento(btnLimpar, "N�o foi poss�vel clicar no bot�o Limpar");
        salvarEvidencia("Clicar no bot�o Limpar");
        return this;
    }
}

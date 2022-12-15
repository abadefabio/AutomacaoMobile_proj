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
     * Informar o CPF Indicador na página de Indicações de Amigos do menu Hamburguer
     *
     * @param cpfIndicador
     * @throws Exception
     * @return IndicacoesAmigosCpfTela
     */
    @Step("Entrar com CPF Indicador")
    public IndicacoesAmigosCpfTela informarCpfIndicador(String cpfIndicador) throws Exception {
        aguardarCarregamentoQualquerElemento(btnBuscar);
        digitarTexto(inputCpfIndicador, cpfIndicador, "Não foi possível informar o CPF Indicador: " + cpfIndicador);
        salvarEvidencia("Informar o CPF Indicador");
        return this;
    }

    /**
     * Informar o CPF Convidado na página de Indicações de Amigos do menu Hamburguer
     *
     * @param cpfConvidado
     * @throws Exception
     * @return IndicacoesAmigosCpfTela
     */
    @Step("Entrar com CPF Convidado")
    public IndicacoesAmigosCpfTela informarCpfConvidado(String cpfConvidado) throws Exception {
        aguardarCarregamentoQualquerElemento(btnBuscar);
        digitarTexto(inputCpfConvidado, cpfConvidado, "Não foi possível informar o CPF Convidado: " + cpfConvidado);
        salvarEvidencia("Informar o CPF Convidado");
        return this;
    }

    /**
     * Clicar no botão Buscar para abrir a tela de Indicações de Amigos
     *
     * @throws Exception
     * @return IndicacoesAmigosCpfTela
     */
    @Step("Clicar no botão Buscar")
    public IndicacoesAmigosCpfTela clicarBotaoBuscar() throws Exception {
        clicarElemento(btnBuscar, "Não foi possível clicar no botão Buscar");
        aguardarContainerCarregamentoPaginaDesaparecer();
        salvarEvidencia("Clicar no botão Buscar");
        return this;
    }

    /**
     * Clicar no botão Limpar para limpar os campos de pesquisa da tela de Indicações de Amigos
     *
     * @throws Exception
     * @return IndicacoesAmigosCpfTela
     */
    @Step("Clicar no botão Limpar")
    public IndicacoesAmigosCpfTela clicarBotaoLimpar() throws Exception {
        clicarElemento(btnLimpar, "Não foi possível clicar no botão Limpar");
        salvarEvidencia("Clicar no botão Limpar");
        return this;
    }
}

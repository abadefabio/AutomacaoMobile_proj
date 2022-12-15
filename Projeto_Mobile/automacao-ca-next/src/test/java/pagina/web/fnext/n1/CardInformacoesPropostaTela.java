package pagina.web.fnext.n1;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardInformacoesPropostaTela extends PaginaBaseWeb {


    @FindBy(xpath = "'//div[@class=\"card m-3 \"]/./div[@class=\"card-header card-title\"]'")
    private WebElement tituloCardInformacoesDaProposta;

    @FindBy(xpath = "(//td[text()='Bureau de Face']/..//label[@class=\"fa fa-circle fa-2x color-check\"])[2]")
    private WebElement campoBureauDeFacePositivoTelaConsulta;

    @FindBy(xpath = "//td[text() = \"Bureau de Face\"]/..//label[@class=\"fa fa-circle fa-2x color-check\"]")
    private WebElement campoBureauDeFacePositivoTelaEdicao;

    @FindBy(xpath = "//td[text() = \"Bureau de Face\"]/..//label[@class=\"fa fa-circle fa-2x cor-not-conference\"]")
    private WebElement campoBureauDeFaceNegativo;

    @FindBy(xpath = "(//td[text()='Liveness']/..//label[@class=\"fa fa-circle fa-2x color-check\"])[1]")
    private WebElement campoLivenessPositivo;

    public CardInformacoesPropostaTela(WebDriver driver) {
        super(driver);
    }


    /**
     * Validar Título do Card Informações da Proposta
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Título do Card Informações da Proposta")
    public CardInformacoesPropostaTela validarTituloCardInformacoesDaProposta(String tituloCardInformacoesDaProposta) throws Exception{
        aguardarCarregamentoElemento(this.tituloCardInformacoesDaProposta);
        compararElementoTexto(this.tituloCardInformacoesDaProposta, tituloCardInformacoesDaProposta, MetodoComparacao.CONTEM);
        salvarEvidencia("Validar título do card Informacoes da Proposta");
        return this;
    }

    /**
     * Validar campo Bureau de Face Positivo na tela de Consulta da Proposta N1
     *
     * @return
     */
    @Step("Validar campo Bureau de Face Positivo na tela de Consulta da Proposta N1")
    public CardInformacoesPropostaTela validarCampoBureauDeFacePositivoTelaConsultaN1() {
        validarCondicaoBooleana(verificarPresencaElemento(campoBureauDeFacePositivoTelaConsulta), MetodoComparacaoBooleano.VERDADEIRO,"Campo Bureau de Face com match Positivo não encontrado");
        salvarEvidencia("Campo Bureau de Face com match Positivo na tela de Consulta da Proposta N1");
        return this;
    }

    /**
     * Validar campo Bureau de Face Positivo na tela de Edição da Proposta
     *
     * @return
     */
    @Step("Validar campo Bureau de Face Positivo na tela de Edição da Proposta")
    public CardInformacoesPropostaTela validarCampoBureauDeFacePositivoTelaEdicao() {
        validarCondicaoBooleana(verificarPresencaElemento(campoBureauDeFacePositivoTelaEdicao), MetodoComparacaoBooleano.VERDADEIRO,"Campo Bureau de Face com match Positivo não encontrado");
        salvarEvidencia("Campo Bureau de Face com match Positivo na tela de Edição da Proposta");
        return this;
    }

    /**
     * Validar campo Bureau de Face Negativo
     *
     * @return
     */
    @Step("Validar campo Bureau de Face Negativo")
    public CardInformacoesPropostaTela validarCampoBureauDeFaceNegativo() {
        verificarPresencaElemento(campoBureauDeFaceNegativo);
        salvarEvidencia("Campo Bureau de Face com match Negativo");
        return this;
    }

    /**
     * Validar campo Liveness Positivo na tela de Consulta da Proposta N1
     *
     * @return
     */
    @Step("Validar campo Liveness Positivo na tela de Consulta da Proposta N1")
    public CardInformacoesPropostaTela validarCampoLivenessPositivoTelaConsultaN1() {
        validarCondicaoBooleana(verificarPresencaElemento(campoLivenessPositivo), MetodoComparacaoBooleano.VERDADEIRO, "Campo Liveness com match Positivo não encontrado");
        salvarEvidencia("Campo Liveness com match Positivo na tela de Consulta da Proposta N1");
        return this;
    }
}

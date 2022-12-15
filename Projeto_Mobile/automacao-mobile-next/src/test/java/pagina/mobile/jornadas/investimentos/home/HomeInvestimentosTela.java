package pagina.mobile.jornadas.investimentos.home;

import org.openqa.selenium.By;
import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.investimentos.Segmento;
import constantes.investimentos.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class HomeInvestimentosTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_title")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"INVESTIMENTOS\"]")
    private MobileElement tituloTela;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_my_investments")
    @iOSXCUITFindBy(accessibility = "Meus investimentos")
    private MobileElement botaoMeusInvestimentos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_discovery_profile")
    @iOSXCUITFindBy(accessibility = "DESCUBRA SEU PERFIL")
    private MobileElement botaoDescubraSeuPerfil;

    @AndroidFindBy(id = "br.com.bradesco.next:id/cl_investor_profile")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[starts-with(@name, 'Seu perfil é')]")
    private MobileElement blocoPerfilDeInvestidor;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_profile_text")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[starts-with(@name, 'Seu perfil é')]")
    private MobileElement nomePerfilDeInvestidor;

    public HomeInvestimentosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar o título da tela Home de Investimentos
     * @return HomeInvestimentosTela
     * @throws Exception
     */
    @Step("Validar título tela Home de Investimentos")
    public HomeInvestimentosTela validarTituloTela() throws Exception {
        aguardarCarregamentoElemento(tituloTela);
        compararElementoTexto(tituloTela, TituloTela.INVESTIMENTOS, MetodoComparacao.IGUAL);
        salvarEvidencia("Validado o título tela Home de Investimentos");
        return this;
    }

    /**
     * Tocar em 'Meus investimentos'
     * @return HomeInvestimentosTela
     * @throws Exception
     */
    @Step("Tocar em 'Meus investimentos'")
    public HomeInvestimentosTela tocarBotaoMeusInvestimentos() throws Exception {
        aguardarCarregamentoElemento(botaoMeusInvestimentos);
        salvarEvidencia("Tocar em 'Meus investimentos'");
        tocarElemento(botaoMeusInvestimentos, "Não foi possível tocar em 'Meus investimentos'");
        return this;
    }

    /**
     * Tocar no botão 'Descubra o seu perfil'
     * @return HomeInvestimentosTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Descubra o seu perfil'")
    public HomeInvestimentosTela tocarBotaoDescubraSeuPerfil() throws Exception {
        if(!verificarPresencaElemento(botaoDescubraSeuPerfil)) {
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoDescubraSeuPerfil, "Não foi possível localizar o botão 'Descubra o seu perfil'");
        }
        salvarEvidencia("Tocar no botão 'Descubra o seu perfil'");
        tocarElemento(botaoDescubraSeuPerfil, "Não foi possível tocar no no botão 'Descubra o seu perfil'");
        return this;
    }

    /**
     * Tocar no botão 'Perfil de Investidor'
     * @return HomeInvestimentosTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Perfil de Investidor'")
    public HomeInvestimentosTela tocarBotaoPerfilDeInvestidor() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Tocar no botão 'Perfil de Investidor'");
        tocarElemento(blocoPerfilDeInvestidor, "Não foi possível tocar no botão 'Perfil de Investidor'");
        return this;
    }

    /**
     * Validar o texto do 'Perfil de Investidor'
     * @return HomeInvestimentosTela
     * @throws Exception
     */
    @Step("Validar o texto do 'Perfil de Investidor'")
    public HomeInvestimentosTela validarTextoPerfilDeInvestidor(String perfil) throws Exception {
        rolarTelaAteFinal();
        compararElementoTexto(nomePerfilDeInvestidor, perfil, MetodoComparacao.CONTEM);
        salvarEvidencia("Validado o texto do 'Perfil de Investidor'");
        return this;
    }

    /**
     * Selecionar um segmento
     *
     * @param segmento Segmento a ser selecionado (CDB, Fundos, Poupança ou Ágora)
     * @return HomeInvestimentosTela
     * @throws Exception
     */
    @Step("Selecionar um segmento")
    public HomeInvestimentosTela selecionarSegmento(Segmento segmento) throws Exception {
        By elemento;
        if(android) {
            elemento = By.xpath("//*[contains(@text,'"+segmento+"')]");
        } else {
            elemento = By.xpath("//*[contains(@name,'"+segmento+"')]");
        }
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(elemento, "Não foi possível encontrar o segmento " + segmento);
        aguardarCarregamentoElemento(elemento);
        salvarEvidencia("Selecionar o segmento " + segmento);
        tocarElemento(elemento, "Não foi possível selecionar o segmento " + segmento);
        return this;
    }

    /**
     * Validar ausência do botão 'Meus investimentos'
     *
     * @return HomeInvestimentosTela
     */
    @Step("Validar ausência do botão 'Meus investimentos'")
    public HomeInvestimentosTela validarAusenciaBotaoMeusInvestimentos() {
        OperadorEvidencia.logarPasso("Iniciada a validação da ausência do botão 'Meus investimentos'");
        validarCondicaoBooleana(verificarPresencaElemento(botaoMeusInvestimentos), MetodoComparacaoBooleano.FALSO, "Não foi possível validar a ausência do botão 'Meus investimentos'");
        salvarEvidencia("Validada a ausência do botão 'Meus investimentos'");
        return this;
    }

    /**
     * Validar presença tela 'Investimentos'
     *
     * @return HomeInvestimentosTela
     */
    @Step("Validar presença tela 'Investimentos'")
    public HomeInvestimentosTela validarPresencaTelaInvestimentos() {
        validarCondicaoBooleana(aguardarPaginaConterQualquerTexto(
                TituloTela.INVESTIMENTOS.toString(),
                "Detalhes do produto","Detalhes","Aplicar") != "", MetodoComparacaoBooleano.VERDADEIRO, "Título 'Investimentos' não está presente na tela!");
        salvarEvidencia("Validada presença da tela Investimentos");
        return this;
    }
}

package pagina.mobile.jornadas.open.finance;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.constantes.Normaliza;
import constantes.open.finance.Mensagens;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ConfirmarTela extends PaginaBase {

    public ConfirmarTela(AppiumDriver driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/nb_confirm")
    @iOSXCUITFindBy(xpath = "//*[contains(@name,\"CONFIRMAR\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,\"CONFIRMAR\")]")
    private MobileElement botaoConfirmar;

    /**
     * Validar tela "Cormirme Dados compartilhados com Next"
     * fr
     * @return
     * @throws Exception
     */
    @Step("Validar tela \"Cormirme Dados compartilhados com Next\"")
    public ConfirmarTela validarTelaConfirmarDadosCompartilhamento() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagens.CONFIRME_OS_DADOS_QUE_VAO_SER_COMPARTILHADO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Validar Confirme Dados compartilhados com Next");
        salvarEvidencia("Validar tela \"Confirme Dados compartilhados com Next\"");
        return this;
    }

    /**
     * Validar tela "Resumo CPF"
     * fr
     * @return
     * @throws Exception
     */
    @Step("Validar \"Resumo CPF\"")
    public ConfirmarTela validarResumoCpf(String cpf) throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Normaliza.String,cpf), MetodoComparacaoBooleano.VERDADEIRO, "Validar  Resumo 'CPF'");
        salvarEvidencia("Validar  Resumo 'CPF'");
        return this;
    }

    /**
     * Validar "Resumo Instituicao Next"
     * fr
     * @return
     * @throws Exception
     */
    @Step("Validar \"Resumo Instituicao Next\"")
    public ConfirmarTela validarResumoInstituicaoNext() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagens.INSTITUICAO_NEXT.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Validar Resumo - Instituicao Next");
        salvarEvidencia("Validar \"Resumo - Instituicao Next\"");
        return this;
    }

    /**
     * Tocar botão "Confirmar"
     * fr
     * @return TutorialOpenFinanceTela
     * @throws Exception
     */
    @Step("Tocar botão \"Confirmar\"")
    public ConfirmarTela tocarBotaoConfirmar() throws Exception {
        rolarTelaAteFinal();
        salvarEvidencia("Tocar botão \"Confirmar\"");
        tocarElemento(botaoConfirmar, "Não foi possivel tocar botão \"Confirmar\"");
        return this;
    }
}

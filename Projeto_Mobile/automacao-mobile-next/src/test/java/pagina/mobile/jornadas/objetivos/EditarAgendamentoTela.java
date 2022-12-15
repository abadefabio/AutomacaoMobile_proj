package pagina.mobile.jornadas.objetivos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.objetivos.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import static java.time.Duration.ofSeconds;

public class EditarAgendamentoTela extends PaginaBase {

    @AndroidFindBy(accessibility = "EDITAR AGENDAMENTO")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"EDITAR AGENDAMENTO\"]")
    private MobileElement tituloEditarAgendamento;

    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_confirm_contribution")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Confirmar edição\"]")
    private MobileElement botaoConfirmarEdicao;

    public EditarAgendamentoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Valida a tela: 'Editar Agendamento'
     * @return
     */
    @Step("Valida a tela: 'Editar Agendamento'")
    public EditarAgendamentoTela validarTituloEditarAgendamento(){
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.EDITAR_AGENDAMENTO.toString()),
                MetodoComparacaoBooleano.VERDADEIRO,"Erro ao validar a Tela: 'Editar Agendamento'");
        salvarEvidencia("Validou a tela: 'Editar Agendamento'");
        return this;
    }

    /**
     * Tocar no botão: 'Confirmar Edição'
     * @return
     * @throws NextException
     */
    @Step("Tocar botao 'Confirmar Edição'")
    public EditarAgendamentoTela tocarBotaoConfirmarEdicao() throws NextException {
        tocarElemento(botaoConfirmarEdicao,"Erro ao Tocar no botão : 'Confirmar Edição'");
        salvarEvidencia("Tocar no botão : 'Confirmar Edição'");
        return this;
    }

}

package pagina.mobile.jornadas.depositos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.depositos.saques.DepositosSaques;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class InformacaoSaqueTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Fechar")
    private MobileElement botaoVoltar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_line_one")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeStaticText\" and value contains \"Sempre que precisar\"")
    private MobileElement mensagemInformacao;

    public InformacaoSaqueTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Clicar em Voltar
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Voltar\"")
    public InformacaoSaqueTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Clicar em 'voltar'");
        tocarElemento(botaoVoltar, "Não foi possível clicar  em Voltar");
        return this;
    }

    /**
     * Validar mensagem da tela Informção
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Informação")
    public InformacaoSaqueTela validarMensagemInformacao() throws Exception {
        aguardarCarregamentoElemento(mensagemInformacao);
        compararElementoTexto(mensagemInformacao, DepositosSaques.MENSAGEM_INFORMACAO, MetodoComparacao.CONTEM);
        salvarEvidencia("Comprovante Agendamento de Saque validado");
        return this;
    }
}

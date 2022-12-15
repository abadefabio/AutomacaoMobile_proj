package pagina.mobile.jornadas.depositos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import constantes.depositos.saques.DepositosSaques;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class TransferirOutrosBancosTela extends PaginaBase {

    @AndroidFindBy(xpath = "//*[contains(@text,'Você só tem que usar')]")
    @iOSXCUITFindBy(xpath = "//*[contains(@text,'Você só tem que usar')]")
    private MobileElement informativoOutrosBancos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    public TransferirOutrosBancosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar Mensagem informativo de tranferencia de Outros Bancos
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Informativo Outros Bancos")
    public TransferirOutrosBancosTela validarInformativoOutrosBancos() throws Exception {
        compararElementoTexto(informativoOutrosBancos, DepositosSaques.INFORMATIVO_OUTROS_BANCOS, MetodoComparacao.CONTEM);
        salvarEvidencia("Informativo Outros Bancos validado!");
        return this;
    }

    /**
     * Clicar botão 'Voltar'
     *
     * @return
     * @throws Exception
     */
    @Step("Clicar botão \"Voltar\"")
    public TransferirOutrosBancosTela tocarBotaoVoltar() throws Exception {
        aguardarCarregamentoElemento(botaoVoltar);
        salvarEvidencia("Clicar no botão 'Voltar'");
        tocarElemento(botaoVoltar, "Não foi possível clicar no botão 'Voltar'");
        return this;
    }
}

package pagina.mobile.jornadas.investimentos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.tools.Utilitarios;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class ComprovantePoupancaTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Fechar")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoFechar;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ll_send_by_email")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Enviar comprovante por e-mail\"]")
    private MobileElement botaoEnviarComprovanteEmail;

    public ComprovantePoupancaTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Tocar no bot�o 'Fechar' (x)
     *
     * @return ComprovantePoupancaTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Fechar' (x)")
    public ComprovantePoupancaTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar no bot�o 'Fechar' (x)");
        tocarElemento(botaoFechar, "N�o foi poss�vel tocar no bot�o 'Fechar' (x)");
        return this;
    }

    /**
     * Tocar no bot�o 'Enviar comprovante por e-mail'
     *
     * @return ComprovantePoupancaTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Enviar comprovante por e-mail'")
    public ComprovantePoupancaTela tocarBotaoEnviarComprovantePorEmail() throws Exception {
        aguardarCarregamentoElemento(botaoEnviarComprovanteEmail);
        salvarEvidencia("Tocar no bot�o 'Enviar comprovante por e-mail'");
        tocarElemento(botaoEnviarComprovanteEmail, "N�o foi poss�vel tocar no bot�o 'Enviar comprovante por e-mail'");
        return this;
    }

    /**
     * Validar informa��es do comprovante
     *
     * @param valor        Valor da solicita��o (Aplica��o ou Resgate)
     * @param validarDados Map que cont�m campos e valores a serem validados no comprovante
     * @param campoTela    Array que cont�m os campos a serem percorridos em tela
     * @return ComprovantePoupancaTela
     * @throws Exception
     */
    @Step("Validar informa��es do comprovante")
    public ComprovantePoupancaTela validarInformacoesComprovante(
            String valor,
            Map<String,String> validarDados,
            String[] campoTela) throws Exception {

        String valorFormatado = Utilitarios.reformatarValorMonetario(valor);

        salvarEvidencia("Iniciada a valida��o das informa��es do comprovante");
        List<MobileElement> campos = new ArrayList<>(), valores = new ArrayList<>();
        By campo;
        if (android) {
            for (int i=0; i<campoTela.length; i++) {
                campo = new ByXPath("//*[@text='"+campoTela[i]+"']");
                rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campo, "N�o foi poss�vel encontrar o campo: " + campo);
                campos.add(retornarElemento(campo, "N�o foi poss�vel encontrar o elemento referente ao campo: " + campo));
                valores.add(retornarElemento(new By.ByXPath(campo.toString().substring(10) + "/../following-sibling::*[@class='android.widget.TextView']"),
                        "N�o foi poss�vel encontrar o valor referente ao campo: " + campo));
            }
        } else {
            for (int i=0; i<campoTela.length; i++) {
                campo = new ByXPath("//*[@name='"+campoTela[i]+"']");
                rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campo, "N�o foi poss�vel encontrar o campo: " + campo);
                campos.add(retornarElemento(campo, "N�o foi poss�vel encontrar o elemento referente ao campo: " + campo));
                valores.add(retornarElemento(new By.ByXPath(campo.toString().substring(10) + "/../XCUIElementTypeStaticText[2]"),
                        "N�o foi poss�vel encontrar o valor referente ao campo: " + campo));
            }
        }
        validarCondicaoBooleana(
                aguardarPaginaConterTodosTextos(valorFormatado),
                MetodoComparacaoBooleano.VERDADEIRO,
                "N�o foi poss�vel validar o valor da solicita��o " + valorFormatado
        );
        validarCamposValor(campos, valores, validarDados);
        salvarEvidencia("Finalizada a valida��o das informa��es do comprovante");

        return this;
    }
}

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
     * Tocar no botão 'Fechar' (x)
     *
     * @return ComprovantePoupancaTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Fechar' (x)")
    public ComprovantePoupancaTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar no botão 'Fechar' (x)");
        tocarElemento(botaoFechar, "Não foi possível tocar no botão 'Fechar' (x)");
        return this;
    }

    /**
     * Tocar no botão 'Enviar comprovante por e-mail'
     *
     * @return ComprovantePoupancaTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Enviar comprovante por e-mail'")
    public ComprovantePoupancaTela tocarBotaoEnviarComprovantePorEmail() throws Exception {
        aguardarCarregamentoElemento(botaoEnviarComprovanteEmail);
        salvarEvidencia("Tocar no botão 'Enviar comprovante por e-mail'");
        tocarElemento(botaoEnviarComprovanteEmail, "Não foi possível tocar no botão 'Enviar comprovante por e-mail'");
        return this;
    }

    /**
     * Validar informações do comprovante
     *
     * @param valor        Valor da solicitação (Aplicação ou Resgate)
     * @param validarDados Map que contêm campos e valores a serem validados no comprovante
     * @param campoTela    Array que contêm os campos a serem percorridos em tela
     * @return ComprovantePoupancaTela
     * @throws Exception
     */
    @Step("Validar informações do comprovante")
    public ComprovantePoupancaTela validarInformacoesComprovante(
            String valor,
            Map<String,String> validarDados,
            String[] campoTela) throws Exception {

        String valorFormatado = Utilitarios.reformatarValorMonetario(valor);

        salvarEvidencia("Iniciada a validação das informações do comprovante");
        List<MobileElement> campos = new ArrayList<>(), valores = new ArrayList<>();
        By campo;
        if (android) {
            for (int i=0; i<campoTela.length; i++) {
                campo = new ByXPath("//*[@text='"+campoTela[i]+"']");
                rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campo, "Não foi possível encontrar o campo: " + campo);
                campos.add(retornarElemento(campo, "Não foi possível encontrar o elemento referente ao campo: " + campo));
                valores.add(retornarElemento(new By.ByXPath(campo.toString().substring(10) + "/../following-sibling::*[@class='android.widget.TextView']"),
                        "Não foi possível encontrar o valor referente ao campo: " + campo));
            }
        } else {
            for (int i=0; i<campoTela.length; i++) {
                campo = new ByXPath("//*[@name='"+campoTela[i]+"']");
                rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campo, "Não foi possível encontrar o campo: " + campo);
                campos.add(retornarElemento(campo, "Não foi possível encontrar o elemento referente ao campo: " + campo));
                valores.add(retornarElemento(new By.ByXPath(campo.toString().substring(10) + "/../XCUIElementTypeStaticText[2]"),
                        "Não foi possível encontrar o valor referente ao campo: " + campo));
            }
        }
        validarCondicaoBooleana(
                aguardarPaginaConterTodosTextos(valorFormatado),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Não foi possível validar o valor da solicitação " + valorFormatado
        );
        validarCamposValor(campos, valores, validarDados);
        salvarEvidencia("Finalizada a validação das informações do comprovante");

        return this;
    }
}

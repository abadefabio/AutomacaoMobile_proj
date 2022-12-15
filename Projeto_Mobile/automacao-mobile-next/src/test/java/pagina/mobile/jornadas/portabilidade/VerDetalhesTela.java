package pagina.mobile.jornadas.portabilidade;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.ParentescoElemento;
import constantes.portabilidade.DetalhesPortabilidade;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;

import java.util.List;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static pagina.mobile.jornadas.portabilidade.TrazerMeuSalarioTela.cpfCnpj;

public class VerDetalhesTela  extends PaginaBase {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"COMPROVANTE\"]")
    @AndroidFindBy(id= "br.com.bradesco.next:id/toolbar_title")
    private MobileElement headerDetalhesTrazerMeuSalario;

    //texto tela TRAZER MEU SAL�RIO (Ver Detahes - Pedido em Andamento)
    @AndroidFindBy(id = "br.com.bradesco.next.account_portability:id/ntv_message")
    @iOSXCUITFindBy(iOSNsPredicate = "type = \"XCUIElementTypeStaticText\" and name contains \"Seu pedido est� sendo processado.\"")
    private MobileElement textoVerDetalhesPedidoAndamento;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='FECHAR']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[1]")
    private MobileElement headerDetalhesFechar;

    @iOSXCUITFindBy(accessibility = "Seu pedido est� sendo processado. A conclus�o leva at� 10 dias �teis")
    @AndroidFindBy(xpath = "br.com.bradesco.next:id/ntv_message")
    private MobileElement detalhesMensagem;

    public VerDetalhesTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Validar texto Trazer Meu Sal�rio (Ver Detalhes - Pedido em Andamento)
     *
     * @return VerDetalhesTela
     * @throws Exception
     */
    @Step("Validar texto tela \"TRAZER MEU SALARIO\"")
    public VerDetalhesTela validartextoVerDetalhesPedidoEmAndamento() throws Exception {
        aguardarCarregamentoElemento(textoVerDetalhesPedidoAndamento);
        if(getDriver() instanceof AndroidDriver){
            cpfCnpj.set(getDriver().findElement(By.id("br.com.bradesco.next:id/nl_right")).getText());
        }else{
            cpfCnpj.set(getDriver().findElement(By.xpath("//XCUIElementTypeOther[@value='CPF/CNPJ']//preceding-sibling::XCUIElementTypeOther")).getText());
        }
        salvarEvidencia("Tocar no bot�o 'Detalhes'");
        return this;
    }

    /**
     * Validar ver detalhes 'Trazer meu salario' pedido em andamento
     *
     * @return VerDetalhesTela
     * @throws Exception
     */
    @Step("Validar ver detalhes \"Trazer meu salario\" pedido em andamento")
    public VerDetalhesTela validarInformacoesVerDetalhes(DetalhesPortabilidade portabilidade) throws Exception {
        List<MobileElement> campos, valores;
        if(getDriver() instanceof  AndroidDriver){
            campos = retornarLista(new By.ById("br.com.bradesco.next:id/tv_item"), "N�o foi poss�vel montar lista com os elementos contendos os campos");
            valores = retornarLista(new By.ById("br.com.bradesco.next:id/tv_description"), "N�o foi poss�vel montar lista com os elementos contendos os valores");
        } else {
            MobileBy status, banco, dataSolicitacao;
            //CPF/CNPJ
            campos = retornarLista(new MobileBy.ByAccessibilityId("CPF/CNPJ"), "N�o foi poss�vel montar lista com os elementos contendos os campos");
            valores = retornarLista(new By.ByXPath("//*[@name = \"CPF/CNPJ\"]/following-sibling::XCUIElementTypeStaticText"), "N�o foi poss�vel montar lista com os elementos contendos os valores");
            //Status
            status = new MobileBy.ByAccessibilityId("Status");
            campos.add(retornarElemento(status, "N�o foi poss�vel encontrar o elemento referente ao campo status"));
            valores.add(retornarElementoParente(status, "XCUIElementTypeStaticText", ParentescoElemento.PROXIMO_IRMAO));
            //Banco
            banco = new MobileBy.ByAccessibilityId("Banco");
            campos.add(retornarElemento(banco, "N�o foi poss�vel encontrar o elemento referente ao campo banco"));
            valores.add(retornarElementoParente(banco, "XCUIElementTypeStaticText", ParentescoElemento.PROXIMO_IRMAO));
            //Data da Solicita��o
            dataSolicitacao = new MobileBy.ByAccessibilityId("Data da solicita��o");
            campos.add(retornarElemento(dataSolicitacao, "N�o foi poss�vel encontrar o elemento referente ao campo Data da solicita��o"));
            valores.add(retornarElementoParente(dataSolicitacao, "XCUIElementTypeStaticText", ParentescoElemento.PROXIMO_IRMAO));
        }
        validarCamposValor(campos,valores, portabilidade.retornaDadosPortabilidade());
        salvarEvidencia("Validar Informa��es tela Ver Detalhes");
        return this;
    }

    /**
     * Validar ver detalhes 'Trazer meu salario' pedido em andamento
     *
     * @return VerDetalhesTela
     * @throws Exception
     */
    @Step("Validar ver detalhes \"Trazer meu salario\" pedido em andamento")
    public VerDetalhesTela validarInformacoesVerDetalhes(JSONObject portabilidade) throws Exception {

        List<MobileElement> campos, valores;
        if(getDriver() instanceof  AndroidDriver){
            campos = retornarLista(new By.ById("br.com.bradesco.next:id/nl_left"), "N�o foi poss�vel montar lista com os elementos contendos os campos");
            valores = retornarLista(new By.ById("br.com.bradesco.next:id/nl_right"), "N�o foi poss�vel montar lista com os elementos contendos os valores");
            valores.remove(0);
        } else {
            campos = retornarLista(new By.ByXPath("//*/XCUIElementTypeCell/XCUIElementTypeOther[@index=\"1\"]"),"N�o foi poss�vel montar lista com os elementos contendos os campos");
            valores = retornarLista(new By.ByXPath("//*/XCUIElementTypeCell/XCUIElementTypeOther[@index=\"0\"]"),"N�o foi poss�vel montar lista com os elementos contendos os campos");
          }
        validarCamposValor(campos,valores, portabilidade);
        salvarEvidencia("Validar Informa��es tela Ver Detalhes");
        return this;
    }
    /**
     * Tocar bot�o Fechar
     * @return
     * @throws Exception
     */
    @Step("Tocar bot�o fechar")
    public VerDetalhesTela tocarBotaoFechar() throws Exception {
        aguardarCarregamentoElemento(headerDetalhesFechar);
        tocarElemento(headerDetalhesFechar, "Durante a a��o de tocar o bot�o fechar, aconteceu um erro");
        esperarCarregando();
        salvarEvidencia("Tocar bot�o Fechar");
        return this;
    }

}

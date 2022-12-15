package pagina.mobile.jornadas.recarga.meusContatos;

import java.time.temporal.ChronoUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.time.temporal.ChronoUnit;
import java.util.List;


public class MeusContatosTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/group")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"next teste\"]")
    private MobileElement botaoContato;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Next Teste\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"next teste\"]")
    private MobileElement selecionaContato;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_save")
    @iOSXCUITFindBy(accessibility = "Salvar")
    private MobileElement botaoSalvar;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell/XCUIElementTypeButton[1]")
    private MobileElement botaoEditar;

    @iOSXCUITFindBy(accessibility = "OK")
    private MobileElement botaoOk;

    @WithTimeout(time = 60, chronoUnit = ChronoUnit.SECONDS)
    @iOSXCUITFindBy(className = "XCUIElementTypeCell")
    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().resourceId(\"br.com.bradesco.next:id/txtTitulo\"));")
    private MobileElement listaNomeDeslizante;

    public MeusContatosTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Retornar o elemento na lista de nomes que contém o nome requisitado'
     * @param nome
     * @return
     * @throws Exception
     */
    private MobileElement nomeContatoListaDeslizante(String nome) throws Exception {
        By locator = null;
        MobileElement element = null;

        if (android) {
            locator = By.xpath("//android.widget.TextView[@resource-id='br.com.bradesco.next:id/txtTitulo']");
            MobileElement raiz = retornarElemento(locator, "Não foi possível carregar o elemento");
            aguardarCarregamentoElemento(raiz);
        } else {
            locator = By.className("XCUIElementTypeCell");
            aguardarCarregamentoElemento(listaNomeDeslizante);
        }

        List<MobileElement> lista = retornarLista(locator, "Não foi possível encontrar o nome '" + nome + "'");
        for (MobileElement elementoLista : lista) {
            try {
                if (retornarTexto(elementoLista, "").equals(nome)) {
                    element = elementoLista;
                    break;
                }
            } catch (Exception | AssertionError ignore) {
                /*
                É possível que o locator retorne algo mas ainda não seja
                possível recuperar o texto, então ignoramos e verificamos
                o próximo elemento.
                 */
            }
        }
        return element;
    }

    /**
     * Clicar no nome do contato
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Contato\"")
    public MeusContatosTela tocarBotaoContato() throws Exception {
        salvarEvidencia("Clicar no nome do contato");
        tocarElemento(botaoContato, "Não foi possível clicar no nome do contato");
        return this;
    }

    /**
     * Clicar no nome do contato
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Contato\"")
    public MeusContatosTela selecionarContato() throws Exception {
        salvarEvidencia("Clicar no nome do contato");
        tocarElemento(selecionaContato, "Não foi possível clicar no nome do contato");
        return this;
    }

    /**
     * Clicar no botão 'Salvar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Salvar\"")
    public MeusContatosTela tocarBotaoSalvar() throws Exception {
        esconderTeclado();
        rolaTelaBaixo();
        salvarEvidencia("Clicar no botão 'Salvar'");
        tocarElemento(botaoSalvar, "Não foi possível clicar no botão 'Salvar'");
        if (verificarPresencaElemento(new MobileBy.ByAccessibilityId("OK"))) {
            tocarElemento(botaoOk, "Não foi possivel clicar no botão 'Ok'");
        }
        return this;
    }

    /**
     * Clicar botão 'Editar'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Editar\"")
    public MeusContatosTela tocarBotaoEditar(String nome) throws Exception {
        salvarEvidencia("Clicar no botão 'Editar'");
        if (ios) {
            aguardarCarregamentoElemento(botaoEditar);
            tocarElemento(botaoEditar, "Não foi possível clicar no botão 'Editar'");
        } else {
            int y = nomeContatoListaDeslizante(nome).getCenter().y;
            Dimension dimensao = retornaDimensaoTela();
            int yProporcional = (int) (y / dimensao.height * 100);
            tocarCoordenadaProporcional(60, yProporcional);
        }
        return this;
    }

    /**
     * Selecinar Contato existente em 'Meus Contatos'
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar Contato")
    public MeusContatosTela selecionarContato(String nome) throws Exception {
        if (ios) {
            salvarEvidencia("Selecionar Contato'");
            retornaElemento(new By.ByClassName("XCUIElementTypeSearchField")).sendKeys(nome);
            tocarElemento(botaoContato, "Não foi possível clicar no nome do contato");
        }
        return this;
    }
}



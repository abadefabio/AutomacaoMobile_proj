package pagina.mobile.jornadas.recarga.resumo;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class ResumoTela extends PaginaBase {

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Resumo\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"Resumo\"]")
    private MobileElement tituloResumo;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(accessibility = "Deseja salvar o contato?")
    @iOSXCUITFindBy(accessibility = "Deseja salvar o contato?")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@name=\"Deseja salvar o contato?\"]")
    private MobileElement switchDesejaSalvarOContato;

    @AndroidFindBy(xpath = "//android.view.View[contains(@content-desc, 'Para salvar o contato')]")
    @iOSXCUITFindBy(accessibility = "Deseja salvar o contato?")
    private MobileElement labelSalvarContato;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.RadioButton[contains(@content-desc,\"Conta-corrente\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[contains(@name,\"corrente\")]")
    private MobileElement radioButtonContaCorrente;

    @AndroidFindBy(xpath = "//android.widget.RadioButton[contains(@content-desc,\"Conta-poupança\")]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[contains(@name,\"poupança\")]")
    private MobileElement radioButtonContaPoupanca;

    @AndroidFindBy(accessibility = "CONFIRMAR")
    @iOSXCUITFindBy(accessibility = "CONFIRMAR")
    private MobileElement botaoConfimar;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Conta a ser debitada\"]/preceding-sibling::android.widget.EditText[1]")
    @iOSXCUITFindBy(accessibility = "Nome completo")
    private MobileElement nomeCompleto;


    @AndroidFindBy(accessibility = "Nome e Sobrenome")
    @iOSXCUITFindBy(accessibility = "Nome e Sobrenome")
    private MobileElement labelNomeESobrenome;

    public ResumoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Seleciona o switch 'Deseja salvar o contato?'
     *
     * @return
     * @throws NextException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Step("Seleciona o switch 'Deseja salvar o contato?'")
    public ResumoTela tocarSwitchSalvarContato() throws Exception {
        rolaTelaBaixo();
        tocarElemento(switchDesejaSalvarOContato, "Erro ao tocar no swtch 'Deseja Salvar O Contato?'");
        salvarEvidencia("Tocou no Switch 'Deseja Salvar O Contato?");
        if (android) {
            tocarElemento(labelSalvarContato, "Não foi possível tocar na label 'Salvar contato'");
            esconderTeclado();
        }
        return this;
    }

    /**
     * Edita o campo 'Nome completo'
     * @param nome
     * @return
     * @throws NextException
     */
    @Step("Edita o campo 'Nome completo'")
    public ResumoTela informarNomeContato(String nome) throws Exception {
        rolarTela(0.9, 0.2);
        tocarElemento(nomeCompleto, "Não foi possível tocar no campo nome!");
        if (android) {
            apagarCampoTexto(nomeCompleto, "Não foi possível apagar o nome");
        }
        escreverTexto(nomeCompleto, nome, "Erro ao informar 'Nome Completo'");
        salvarEvidencia("Informar: '" + nome + "' no campo 'Nome Completo'");
        return this;
    }

    /**
     * Seleciona o radio button 'Conta-Corrente'
     *
     * @return
     * @throws NextException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Step("Seleciona o radio button 'Conta-Corrente'")
    public ResumoTela selecionaContaCorrente() throws NextException, IOException, NoSuchAlgorithmException {
        esconderTeclado();
        tocarElemento(radioButtonContaCorrente, "Erro ao tocar no radio button: 'Conta-Corrente'");
        salvarEvidencia("Tocou no Radio Button: 'Conta-Corrente'");
        return this;
    }

    /**
     * Seleciona o radio button 'Conta-Poupança'
     *
     * @return
     * @throws NextException
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @Step("Seleciona o radio button 'Conta-Poupança'")
    public ResumoTela selecionaContaPoupanca() throws NextException, IOException, NoSuchAlgorithmException {
        esconderTeclado();
        tocarElemento(radioButtonContaPoupanca, "Erro ao tocar no radio button: 'Conta-Poupança'");
        salvarEvidencia("Tocou no Radio Button: 'Conta-Poupança'");
        return this;
    }

    /**
     * Tocar no botão 'Confirmar'
     * @return
     * @throws NextException
     * @throws InterruptedException
     */
    @Step("Tocar no botão 'Confirmar'")
    public ResumoTela tocarBotaoConfirmar() throws Exception {
        rolarTela(0.9, 0.2);
        salvarEvidencia("Tocar no botão 'Confirmar'");
        tocarElemento(botaoConfimar, "Erro ao tocar no botão 'Confirmar'");
        return this;
    }

    /**
     * Valida a exibição da tela Resumo
     * @return
     */
    @Step("Valida a exibição da tela Resumo")
    public ResumoTela validarExibicaoTelaResumo() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(tituloResumo), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a exibição da tela de recarga");
        salvarEvidencia("Validar exibição da tela de Resumo");
        return this;
    }

    /**
     * Validar a label 'Nome e Sobrenome'
     * @return
     */
    @Step("Validar a label 'Nome e Sobrenome'")
    public ResumoTela validarLabelNomeESobrenome() {
        validarCondicaoBooleana(aguardarCarregamentoElemento(labelNomeESobrenome), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a label 'NomeESobrenome'");
        salvarEvidencia("Validou a label 'Nome e Sobrenome'");
        return this;
    }
}
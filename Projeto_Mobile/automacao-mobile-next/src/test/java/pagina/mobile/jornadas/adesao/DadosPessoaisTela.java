package pagina.mobile.jornadas.adesao;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.adesao.DadosPessoais;
import constantes.adesao.LocalNascimento;
import constantes.adesao.PaisNascimento;
import constantes.adesao.TipoDocumento;
import constantes.adesao.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.util.List;

import static java.time.Duration.ofSeconds;

public class DadosPessoaisTela extends PaginaBase {

    public DadosPessoaisTela(AppiumDriver driver) {
        super(driver);
    }

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_finish_later")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'TERMINAR MAIS TARDE')]")
    private MobileElement botaoTerminarMaisTarde;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_next")
    @iOSXCUITFindBy(accessibility = "CONTINUAR")
    @iOSXCUITFindBy(xpath = "**/XCUIElementTypeButton[`label == \"CONTINUAR\"`]")
    private MobileElement botaoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_birthday")
    @iOSXCUITFindBy(accessibility = "Data de nascimento")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Data de nascimento\"`]")
    private MobileElement campoDataNascimento;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_born_country")
    @iOSXCUITFindBy(accessibility = "País de nascimento")
    private MobileElement comboboxPaisNascimento;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_search")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@visible='true']")
    private MobileElement campoPaisNascimento;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ll_value_dialog_picker")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell")
    private MobileElement registroPaisNascimento;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_born_location_box")
    @iOSXCUITFindBy(accessibility = "Local de nascimento")
    private MobileElement comboboxLocalNascimento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/et_search")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@visible='true']")
    private MobileElement campoLocalNascimento;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ll_value_dialog_picker")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell")
    private MobileElement registroLocalNascimento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/container_marital_status")
    @iOSXCUITFindBy(accessibility = "Estado civil")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Estado civil\"`]")
    private MobileElement campoEstadoCivil;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_document_type")
    @iOSXCUITFindBy(accessibility = "Selecione o documento")
    private MobileElement comboboxTipoDocumento;


    @AndroidFindBy(xpath = "(//*[@resource-id=\"br.com.bradesco.next:id/ll_value_dialog_picker\"])[1]")
    @iOSXCUITFindBy(accessibility = "Registro Geral")
    private MobileElement opcaoRG;


    @AndroidFindBy(xpath = "(//*[@resource-id=\"br.com.bradesco.next:id/ll_value_dialog_picker\"])[2]")
    @iOSXCUITFindBy(accessibility = "Carteira Nacional de Habilitação")
    private MobileElement opcaoCNH;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/ntf_document_number")
    @iOSXCUITFindBy(accessibility = "Número do documento")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Número do documento\"`]")
    private MobileElement campoNumeroDocumento;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "(//*[@resource-id=\"br.com.bradesco.next:id/ntf_partner_name\"])[2]")
    @iOSXCUITFindBy(accessibility = "Nome do cônjuge")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeTextField[`label == \"Nome do cônjuge\"`]")
    private MobileElement campoNomeConjuge;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_no")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Não\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Não\"]")
    private MobileElement botaoNaoUniversitario;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_yes")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"Sim\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Sim\"]")
    private MobileElement botaoSimUniversitario;


    /**
     * Tocar botao 'Terminar Mais Tarde'
     * fr
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("Tocar botao  \"Terminar Mais Tarde\"")
    public DadosPessoaisTela tocarTerminarMaisTarde() throws Exception {
        salvarEvidencia("'Tocar botao Terminar Mais Tarde'");
        tocarElemento(botaoTerminarMaisTarde, "Erro ao Tocar botao Terminar Mais Tarde");
        return this;
    }

    /**
     * validar titulo da tela 'Passo 1 - Agora, a gente vai precisar de uns dados pessoais
     * fr
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("validar tela  \"Agora a gente vai precisar de uns dados pessoais\"")
    public DadosPessoaisTela validarTituloCompleteSeuCadastro() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.AGORA_AGENTE_VAI_PRECISAR_DADOS_PESSOAIS.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Agora, a gente vai precisar de uns dados pessoais' não está presente na tela!");
        salvarEvidencia("validar que esta na tela de 'Agora, a gente vai precisar de uns dados pessoais'");
        return this;
    }

    /**
     * validar titulo da tela 'Você é universitário?'
     * fr
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("validar tela  \"Você é universitário?\"")
    public DadosPessoaisTela validarTituloVoceUniversitario() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.VOCE_E_UNIVERSITARIO.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Voce é universitario?' não está presente na tela!");
        salvarEvidencia("validar que esta na tela de 'Voce é universitario?'");
        return this;
    }

    /**
     * Preencher data Nascimento
     * FR
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("Preencher \"Data Nascimento\"")
    public DadosPessoaisTela preencherDataNascimento(String dataNascimento) throws Exception {
        if (android) {
            digitarTexto(campoDataNascimento, dataNascimento + Keys.ENTER);
        } else {
            escreverTexto(campoDataNascimento, dataNascimento, "Nao foi possivel informar 'Data de Nascimento'");
            digitarTexto(campoDataNascimento, Keys.ENTER);
        }

        salvarEvidencia("'Preencher campo Data Nascimento'");
        return this;
    }

    /**
     * Tocar combobox 'Pais Nascimento'
     * FR
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("Tocar combobox \"Pais Nascimento\"")
    public DadosPessoaisTela tocarComboboxPaisNascimento() throws Exception {
        tocarElemento(comboboxPaisNascimento, "Não foi possível tocar no campo 'Pais Nascimento'");
        salvarEvidencia("Tocar combobox campo 'Pais Nascimento'");
        return this;
    }

    /**
     * Preencher 'Pais Nascimento'
     * FR
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("Preencher \"Pais Nascimento\"")
    public DadosPessoaisTela preencherPaisNascimento(PaisNascimento pais) throws Exception {
        escreverTexto(campoPaisNascimento, pais.toString(), "Erro ao preencher campo Pais Nascimento");
        salvarEvidencia("Preencher campo 'Pais Nascimento'");
        return this;
    }

    /**
     * Selecionar 'Pais Nascimento'
     * FR
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("Selecionar \"Pais Nascimento\"")
    public DadosPessoaisTela selecionarPaisNascimento() throws Exception {
        tocarElemento(registroPaisNascimento, "Não foi possível tocar no registro de Pais Nascimento");
        salvarEvidencia("Selecionar 'Pais Nascimento'");
        return this;
    }

    /**
     * Tocar Combobox 'Local Nascimento'
     * FR
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("Tocar combobox \"Local Nascimento\"")
    public DadosPessoaisTela tocarComboboxLocalNascimento() throws Exception {
        tocarElemento(comboboxLocalNascimento, "Não foi possível tocar no campo 'Local Nascimento'");
        salvarEvidencia("Tocar combobox 'Local Nascimento'");
        return this;
    }


    /**
     * Preencher Local Nascimento
     * FR
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("Preencher \"Local Nascimento\"")
    public DadosPessoaisTela preencherLocalNascimento(LocalNascimento local) throws Exception {
        escreverTexto(campoLocalNascimento, local.toString(), "Erro ao preencher campo Local Nascimento");
        salvarEvidencia("Preencher 'Local Nascimento'");
        return this;
    }

    /**
     * Selecionar Local Nascimento
     * FR
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("Selecionar \"Local Nascimento\"")
    public DadosPessoaisTela selecionarLocalNascimento() throws Exception {
        tocarElemento(registroLocalNascimento, "Não foi possível tocar no registro de local Nascimento");
        salvarEvidencia("Selecionar 'Local Nascimento'");
        return this;
    }

    /**
     * preencher Estado Civil
     * FR
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("Tocar \"Estado Civil\"")
    public DadosPessoaisTela tocarComboboxEstadoCivil() throws Exception {
        tocarElemento(campoEstadoCivil, "Não foi possível tocar no campo 'Estado Civil'");
        aguardarCarregamentoElemento(DadosPessoais.TEXTO_CAMPO_PESQUISA_LISTA_ESTADO_CIVIL);
        salvarEvidencia("'Selecionar opção no campo Estado Civil'");
        return this;
    }

    /**
     * Selecionar Estado Civil
     * FR
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("Selecionar \"Estado Civil\"")
    public DadosPessoaisTela selecionarEstadoCivil(DadosPessoais dadosPessoais) throws Exception {
        List<MobileElement> lista = android ?
                retornarLista(By.id("br.com.bradesco.next:id/tv_value"), "Nao foi possivel listar os Estados Civis") :
                retornarLista(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell"), "Nao foi possivel listar os Estados Civis");

        for (MobileElement element : lista) {
            if (element.getText().equals(dadosPessoais.toString()) || element.getAttribute("name").contains(dadosPessoais.toString())) {
                element.click();
                break;
            }
        }
        salvarEvidencia("Selecionar 'Estado Civil'");
        return this;
    }

    /**
     * Validar opções do campo "Estado Civil"
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("Validar opções do campo \"Estado Civil\"")
    public DadosPessoaisTela validarOpcoesCampoEstadoCivil() throws Exception {
        tocarElemento(campoEstadoCivil, "Não foi possível tocar no campo 'Estado Civil'");
        aguardarCarregamentoElemento(DadosPessoais.TEXTO_CAMPO_PESQUISA_LISTA_ESTADO_CIVIL);

        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(DadosPessoais.OPCAO_SOLTEIRO_ESTADO_CIVIL.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar opção 'Solteiro'");
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(DadosPessoais.OPCAO_CASADO_UNIAO_UNIVERSAL_BENS_ESTADO_CIVIL.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a opção 'Casado com união universal de bens'");
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(DadosPessoais.OPCAO_CASADO_UNIAO_PARCIAL_BENS_ESTADO_CIVIL.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a opção 'Casado com união parcial de bens'");
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(DadosPessoais.OPCAO_CASADO_SEPARACAO_BENS_ESTADO_CIVIL.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a opção 'Casado com separação de bens'");
        rolarTelaAteFinal();
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(DadosPessoais.OPCAO_SEPARADO_JUDICIALMENTE_ESTADO_CIVIL.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a opção 'Separado judicialmente'");
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(DadosPessoais.OPCAO_DIVORCIADO_ESTADO_CIVIL.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a opção 'Divorciado'");
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(DadosPessoais.OPCAO_VIUVO_ESTADO_CIVIL.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a opção 'Viúvo'");
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(DadosPessoais.OPCAO_UNIAO_ESTAVEL.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a opção 'União estável'");
        salvarEvidencia("Validar opções no campo 'Estado Civil'");
        return this;
    }

    /**
     * Tocar combobox Documento
     * FR
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("Tocar combobox \"Documento\"")
    public DadosPessoaisTela tocarComboboxDocumento() throws Exception {
        tocarElemento(comboboxTipoDocumento, "Não foi possível tocar no combobox 'Documento'");
        salvarEvidencia("'Tocar combobox Documento'");
        return this;
    }

    /**
     * preencher selecionar Documento
     * FR
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("Selecionar \"Documento\"")
    public DadosPessoaisTela selecionarDocumento(TipoDocumento tipo) throws Exception {
        if (tipo == TipoDocumento.OPCAO_RG) {
            tocarElemento(opcaoRG, "Não foi possível tocar na opcao 'RG'");
        } else {
            tocarElemento(opcaoCNH, "Não foi possível tocar na opcao 'CNH'");
        }

        salvarEvidencia("'Selecionar Documento'");
        return this;
    }

    /**
     * preencher numero documento
     * FR
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("Preencher \"numero documento\"")
    public DadosPessoaisTela preencherNumeroDocumento(String numDoc) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(campoNumeroDocumento, "Nao foi possivel rolar ate o campode Numero de Documento");
        digitarTexto(campoNumeroDocumento, numDoc);
        esconderTeclado();
        salvarEvidencia("'Preencher numero documento'");
        return this;
    }

    /**
     * preencher conjuge
     * FR
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("Preencher \"conjuge\"")
    public DadosPessoaisTela preencherConjuge(String nomeConjuge) throws Exception {
        escreverTexto(campoNomeConjuge, nomeConjuge, "Erro ao preencher conjuge");
        salvarEvidencia("'preencher conjuge'");
        return this;
    }

    /**
     * tocar botao Nao.
     * FR
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("Tocar \" botao Nao.\"")
    public DadosPessoaisTela tocarBoataoNao() throws Exception {
        salvarEvidencia("'tocar botao Nao.'");
        tocarElemento(botaoNaoUniversitario, "Erro ao tocar botao Nao.");
        return this;
    }

    /**
     * tocar botao Sim.
     * FR
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("Tocar \" botao Sim.\"")
    public DadosPessoaisTela tocarBoataoSim() throws Exception {
        salvarEvidencia("'tocar botao Sim.'");
        tocarElemento(botaoSimUniversitario, "Erro ao tocar botao Sim.");
        return this;
    }

    /**
     * Validar título tela Dados Pessoais
     * FR
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("Validar título tela 'Dados Pessoais'")
    public DadosPessoaisTela validarTituloTelaDadosPessoais() throws Exception {
        salvarEvidencia("Validar título tela 'Dados Pessoais'");
        aguardarPaginaConterTodosTextos(TituloTela.DADOS_PESSOAIS.toString());
        return this;
    }

    /**
     * Validar mensagem 'Verifique sua data de nascimento'.
     * FR
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("Validar mensagem 'Verifique sua data de nascimento.'")
    public DadosPessoaisTela validarMensagemVerifiqueDataNascimento() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos("Verifique sua data de nascimento."),
                MetodoComparacaoBooleano.VERDADEIRO,
                "Mensagem 'Verifique sua data de nascimento.' não está presente na tela!"
        );
        salvarEvidencia("Mensagem 'Verifique sua data de nascimento.' validada");
        return this;
    }

    /**
     * Tocar botao 'Continuar'
     * FR
     *
     * @return DadosPessoaisTela
     * @throws Exception
     */
    @Step("Tocar botao 'Continuar'")
    public DadosPessoaisTela tocarBotaoContinuar() throws Exception {
        rolarTelaAteFinal();
        tocarElemento(botaoContinuar, "Erro ao tocar no botao 'Continuar'");
        salvarEvidencia("Tocar botao 'Continuar'");
        return this;
    }
}

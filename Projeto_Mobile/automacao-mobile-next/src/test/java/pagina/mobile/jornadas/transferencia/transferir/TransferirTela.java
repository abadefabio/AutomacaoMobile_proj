package pagina.mobile.jornadas.transferencia.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.constantes.massa.contato.Contato;
import br.com.next.automacao.core.massa.contato.DadosContato;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static br.com.next.automacao.core.tools.Utilitarios.*;
import static pagina.mobile.jornadas.transferencia.para.mim.MinhasContasTela.retornaInstituicao;
import static pagina.mobile.jornadas.transferencia.para.outra.MeusContatosTela.retornaNomeContato;
import static pagina.mobile.jornadas.transferencia.para.outra.NovoContatoTela.*;

public class TransferirTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//*[@name = \"TRANSFERIR\"]")
    @AndroidFindBy(accessibility = "TRANSFERIR")
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"TRANSFERIR\"]")
    private MobileElement headerTituloTransferir;

    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @AndroidFindBy(accessibility = "Menu, Bot�o")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Menu, Bot�o\"]")
    private MobileElement headerBotaoMenu;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_info")
    @AndroidFindBy(accessibility = "Informa��es, Bot�o")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Informa��es, Bot�o\"]")
    private MobileElement headerBotaoInformacoes;

    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_transfer_icon")
    private MobileElement iconeTransferir;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ctv_transfer_come_on")
    private MobileElement textoTituloTela;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.TextView[2]")
    private MobileElement textoDescricaoTela;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_for_me")
    private MobileElement botaoPraMin;

    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_for_others")
    private MobileElement botaoOutraPessoa;

    /* tela Tranferir - Mensagem Aviso - A gente reparou que voc� fez uma transa��o igualzinha a essa hoje. Tem certeza que vai fazer de novo? */

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/imgBgPhoto")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView")
    public MobileElement iconeExclamacao;

    // A gente reparou que voc� fez uma transa��o igualzinha a essa hoje. Tem certeza que vai fazer de novo?
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/text_similar_transaction_desc")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.TextView")
    public MobileElement textoMensagem;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/bt_prosseguir")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Butto")
    public MobileElement botaoAvisoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidBy(id = "br.com.bradesco.next:id/rb_type_current")
    private MobileElement radioContaCorrente;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidBy(id = "br.com.bradesco.next:id/rb_type_savings")
    private MobileElement radioPoupanca;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidBy(id = "br.com.bradesco.next:id/tv_choose")
    private MobileElement selecaoData;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidBy(id = "br.com.bradesco.next:id/bt_continue")
    private MobileElement botaoContinuar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidBy(id = "br.com.bradesco.next:id/et_qnt")
    private MobileElement valorTransferencia;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidBy(id = "br.com.bradesco.next:id/et_name_transfer")
    private MobileElement nomeTransferencia;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/animated_view")
    @iOSXCUITFindBy(accessibility = "Fechar")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton[1]")
    private MobileElement botaoFechar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidBy(id = "br.com.bradesco.next:id/bt_transfer")
    private MobileElement botaoTransferir;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidBy(id = "br.com.bradesco.next:id/rl_view_receipt")
    private MobileElement botaoVisualizar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/btn_new_transfer")
    @AndroidFindBy(xpath = "//*[@text=\"Nova transfer�ncia\"]")
    @iOSXCUITFindBy(id = "Nova transfer�ncia")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Nova transfer�ncia\"]")
    private MobileElement botaoNovaTransferencia;

    @iOSXCUITFindBy(xpath = "//*[@name = \"TRANSFERIR\"]")
    @AndroidFindBy(accessibility = "TRANSFERIR")
    private MobileElement tituloTelaTransferir;

    @AndroidFindBy(id = "br.com.bradesco.next:id/et_qnt")
    private MobileElement campoValorTranferir;


    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_item")
    private MobileElement raizNomeCampoCortinaConfirmacao;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_description")
    private MobileElement raizValorCampoCortinaConfirmacao;

    public TransferirTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Verifica a exibi��o do t�tulo da tela "Transferir"
     *
     * @return
     * @throws Exception
     */
    public TransferirTela validarExibicaoTelaTransferir() throws Exception {
        validarCondicaoBooleana(verificarPresencaElemento(tituloTelaTransferir), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a exibi��o do t�tulo da tela \"TRANSFERIR\"");
        salvarEvidencia("Visualizar tela \"TRANSFERIR\"");
        return this;
    }

    /**
     * Tocar bot�o "Continuar"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Continuar\"")
    public TransferirTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        tocarElemento(botaoContinuar, "Erro ao executar a a��o de tocar bot�o \"Continuar\"");
        salvarEvidencia("Tocar bot�o \"Continuar\"");
        return this;
    }

    /**
     * Retorna um dicion�rio com o de-para da tabela da cortina de valida��o
     *
     * @return
     * @throws Exception
     */
    private Map<String, String> retornaCortinaValidacaoNormalizada() throws Exception {

        Map<String, String> dicionario = new HashMap<>();
        By locatorCampo, locatorValor;

        if (android) {
            locatorCampo = By.id("br.com.bradesco.next:id/tv_item");
            aguardarCarregamentoElemento(raizNomeCampoCortinaConfirmacao);
            locatorValor = By.id("br.com.bradesco.next:id/tv_description");
            aguardarCarregamentoElemento(raizValorCampoCortinaConfirmacao);
            List<MobileElement> elementosCampo = retornarLista(locatorCampo, "N�o foi poss�vel encontrar um campo para valida��o");
            List<MobileElement> elementosValor = retornarLista(locatorValor, "N�o foi poss�vel encontrar um valor de campo para valida��o");

            for (int i = 0; i < elementosCampo.size(); i++) {
                String campo = retornarTexto(elementosCampo.get(i), "").trim().toUpperCase();
                String valor = normalizaString(retornarTexto(elementosValor.get(i), ""));
                dicionario.put(campo, valor);
            }
        }

        return dicionario;
    }

    /**
     * Tocar bot�o "Fechar(x)"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no bot�o fechar (X)")
    public TransferirTela tocarFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar no bot�o fechar (X)");
        tocarElemento(botaoFechar, "Nao foi possivel tocar no bot�o fechar");
        return this;
    }

    /**
     * Tocar tocar no campo valor a transferir
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar tocar no campo valor a transferir")
    public TransferirTela tocarValorTransferencia(Enum valor) throws Exception {
        aguardarCarregamentoElemento(campoValorTranferir);
        salvarEvidencia("campo valor a transferir zerado");
        escreverTexto(campoValorTranferir, valor.toString(), "N�o foi possivel preenher campo valor a transferir");
        salvarEvidencia("campo valor preenchido.");
        return this;
    }

    /**
     * Tocar bot�o "Transferir"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Transferir\"")
    public TransferirTela tocarBotaoTransferir() throws Exception {
        aguardarCarregamentoElemento(botaoTransferir);
        tocarElemento(botaoTransferir, "Erro ao tocar bot�o \"Transferir\"");
        salvarEvidencia("Tocar bot�o \"Transferir\"");
        return this;
    }

    /**
     * Tocar radio-button "Conta-Corrente"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar radio-button \"Conta-Corrente\"")
    public TransferirTela tocarRadioButtonContaCorrente() throws Exception {
        aguardarCarregamentoElemento(radioContaCorrente);
        tocarElemento(radioContaCorrente, "Erro ao tocar radio-button \"Conta-Corrente\"");
        salvarEvidencia("Tocar radio-button \"Conta-Corrente\"");
        return this;
    }

    /**
     * Tocar radio-button "Poupan�a"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar radio-button \"Poupan�a\"")
    public TransferirTela tocarRadioButtonPoupanca() throws Exception {
        aguardarCarregamentoElemento(radioPoupanca);
        tocarElemento(radioPoupanca, "Erro ao tocar radio-button \"Poupan�a\"");
        salvarEvidencia("Tocar radio-button \"Poupan�a\"");
        return this;
    }

    /**
     * Preencher campo "Valor Transfer�ncia"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Preencher campo \"Valor Transfer�ncia\"")
    public TransferirTela preencherValorTransferencia() throws Exception {
        aguardarCarregamentoElemento(valorTransferencia);
        escreverTexto(valorTransferencia, String.valueOf(numeroAleatorio(1, 499999)), "Erro ao preencher valor transfer�ncia");
        salvarEvidencia("Preencher valor transfer�ncia com " + retornarTexto(valorTransferencia, "Erro ao recuperar atributo texto"));
        return this;
    }

    /**
     * Preencher campo "Nome Transfer�ncia" com nome aleat�rio
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Preencher campo \"Nome Transfer�ncia\"")
    public TransferirTela preencherNomeTransferencia() throws Exception {
        aguardarCarregamentoElemento(nomeTransferencia);
        escreverTexto(nomeTransferencia, gerarNomeAleatorio(), "Erro ao preencher campo \"Nome Transferência\"");
        salvarEvidencia("Preencher campo Nome Transferência com \"" + gerarNomeAleatorio() + "\"");
        return this;
    }

    /**
     * Realizar o swipe da cortina de confirma��o de contato novo
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Validar mensagem popup")
    public TransferirTela deslizarCortinaConfirmacao() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        rolaTelaCima();
        return this;
    }

    /**
     * Validar campos da cortina onde se fez swipe depois da inclus�o de novo contato
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Validar campos e valores respectivos na cortina dropdown de confirma��o do contato")
    public TransferirTela validarCamposCortinaConfirmacao(String... campos) throws Exception {

        // Cuidar com
        final int DE = 0; // De
        final int PARA = 1; // Para
        final int CPF = 2; // CPF
        final int BANCO = 3; // Banco/institui��o
        final int AGENCIA = 4; // Ag�ncia
        final int CONTA = 5; // Conta

        String para = normalizaString(retornaNomeContato());
        String cpf = normalizaString(retornaCpf());
        String banco = normalizaString(retornaInstituicao());
        String agencia = normalizaString(retornaAgenciaContato());
        String conta = normalizaString(retornaContaContato());

        Map<String, String> dicionario = retornaCortinaValidacaoNormalizada();

        for (int i = 0; i < campos.length; i++) campos[i] = campos[i].toUpperCase().trim();

        /*
        Validar campos exatamente
        com exce��o do banco, que � validado com contains()
         */

        validarCondicaoBooleana(dicionario.get(campos[DE]).equals(normalizaString("Voc�")), MetodoComparacaoBooleano.VERDADEIRO, "");
        validarCondicaoBooleana(dicionario.get(campos[PARA]).equals(para), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar o contato.");
        validarCondicaoBooleana(dicionario.get(campos[CPF]).equals(cpf), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar o CPF.");
        validarCondicaoBooleana(dicionario.get(campos[BANCO]).contains(banco), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar o banco.");
        validarCondicaoBooleana(dicionario.get(campos[AGENCIA]).equals(agencia), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a ag�ncia.");
        validarCondicaoBooleana(dicionario.get(campos[CONTA]).equals(conta), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a conta.");

        salvarEvidencia("Valida��o dos campos da cortina de contato novo");
        return this;
    }

    /**
     * Validar campos da cortina onde se fez swipe depois da inclus�o de novo contato
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Validar campos e valores respectivos na cortina dropdown de confirma��o do contato")
    public TransferirTela validarCamposCortinaConfirmacaoInformada() throws Exception {

        String nomeSobreNome = DadosContato.recuperarDadosContato(Contato.NOME) + " " + DadosContato.recuperarDadosContato(Contato.SOBRENOME);


        String voce = android ? "Voc�" : "Voc� - next";
        String para = normalizaString(nomeSobreNome);
        String cpf = normalizaString(DadosContato.recuperarDadosContato(Contato.CPF));
        String banco = normalizaString(DadosContato.recuperarDadosContato(Contato.BANCO));
        String agencia = normalizaString(DadosContato.recuperarDadosContato(Contato.AGENCIA));
        String conta = normalizaString(DadosContato.recuperarDadosContato(Contato.CONTA));

        Map<String, String> dicionario = retornaCortinaValidacaoNormalizada();


        /*
        Validar campos exatamente
        com exce��o do banco, que � validado com contains()
         */

        validarCondicaoBooleana(dicionario.get("DE").equals(normalizaString(voce)), MetodoComparacaoBooleano.VERDADEIRO, "");
        validarCondicaoBooleana(dicionario.get("PARA").equals(para), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar o contato.");
        validarCondicaoBooleana(dicionario.get("CPF").equals(cpf), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar o CPF.");
        validarCondicaoBooleana(dicionario.get("BANCO").contains(banco), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar o banco.");
        validarCondicaoBooleana(dicionario.get("AG�NCIA").equals(agencia), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a ag�ncia.");
        validarCondicaoBooleana(dicionario.get("CONTA").equals(conta), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a conta.");

        salvarEvidencia("Valida��o dos campos da cortina de contato novo");
        return this;
    }

    /**
     * Validar campos da cortina onde se fez swipe depois da inclus�o de novo contato
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Validar campos e valores respectivos na cortina dropdown de confirma��o do contato")
    public TransferirTela ValidarCamposCortinaConfirmacaoInformada(String nome, String sobreNome, String cpf, String banco, String agencia, String conta) throws Exception {

        String nomeSobreNome = nome + " " + sobreNome;
        salvarEvidencia("Valida��o dos campos da cortina de contato novo");

        String voce = android ? "Voc�" : "Voc� - next";
        String para = normalizaString(nomeSobreNome);
        cpf = normalizaString(cpf);
        banco = normalizaString(banco);
        agencia = normalizaString(agencia);
        conta = normalizaString(conta);

        Map<String, String> dicionario = retornaCortinaValidacaoNormalizada();

        /*
        Validar campos exatamente
        com exce��o do banco, que � validado com contains()
         */

        validarCondicaoBooleana(dicionario.get("DE").equals(normalizaString(voce)), MetodoComparacaoBooleano.VERDADEIRO, "");
        validarCondicaoBooleana(dicionario.get("PARA").equals(para), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar o contato.");
        validarCondicaoBooleana(dicionario.get("CPF").equals(cpf), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar o CPF.");
        validarCondicaoBooleana(dicionario.get("BANCO").contains(banco), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar o banco.");
        validarCondicaoBooleana(dicionario.get("AG�NCIA").equals(agencia), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a ag�ncia.");
        validarCondicaoBooleana(dicionario.get("CONTA").equals(conta), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a conta.");

        return this;
    }

    /**
     * Exibir faixa dropdown
     *
     * @return
     * @throws Exception
     */
    @Step("Exibir faixa dropdown")
    public TransferirTela exibirFaixaDropDown() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        if (ios) {
            rolarTela(0.2, 0.6);
        } else {
            rolaTelaCima();
        }
        salvarEvidencia("Exibir faixa dropdown");
        return this;
    }

    /**
     * Ocultar faixa dropdown
     *
     * @return
     * @throws Exception
     */
    @Step("Ocultar faixa dropdown")
    public TransferirTela ocultarFaixaDropdown() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        if (ios) {
            rolarTela(0.6, 0.2);
        } else {
            rolaTelaBaixo();
        }
        salvarEvidencia("Ocultar faixa dropdown");
        return this;
    }

    /**
     * Validar campos da cortina onde se fez swipe depois da inclus?o de novo contato
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Validar campos e valores respectivos na cortina dropdown de confirma??o do contato")
    public TransferirTela validarCamposCortinaConfirmacao() throws Exception {
        return validarCamposCortinaConfirmacao("De", "Para", "CPF", "Banco", "Ag�ncia", "Conta");

    }

    /**
     * Tocar bot�o "Nova Transfer�ncia"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar bot�o \"Nova Transfer�ncia\"")
    public TransferirTela tocarBotaoNovaTransferencia() throws Exception {
        aguardarCarregamentoElemento(botaoNovaTransferencia);
        salvarEvidencia("Tocar bot�o \"Nova Transfer�ncia\"");
        tocarElemento(botaoNovaTransferencia, "Erro ao tocar bot�o \"Nova Transfer�ncia\"");
        return this;
    }
}

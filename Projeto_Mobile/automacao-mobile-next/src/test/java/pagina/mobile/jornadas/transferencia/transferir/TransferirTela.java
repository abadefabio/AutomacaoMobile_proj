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
    @AndroidFindBy(accessibility = "Menu, Botão")
    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Menu, Botão\"]")
    private MobileElement headerBotaoMenu;

    @AndroidFindBy(id = "br.com.bradesco.next:id/item_info")
    @AndroidFindBy(accessibility = "Informações, Botão")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Informações, Botão\"]")
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

    /* tela Tranferir - Mensagem Aviso - A gente reparou que você fez uma transação igualzinha a essa hoje. Tem certeza que vai fazer de novo? */

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/imgBgPhoto")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ImageView")
    public MobileElement iconeExclamacao;

    // A gente reparou que você fez uma transação igualzinha a essa hoje. Tem certeza que vai fazer de novo?
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
    @AndroidFindBy(xpath = "//*[@text=\"Nova transferência\"]")
    @iOSXCUITFindBy(id = "Nova transferência")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Nova transferência\"]")
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
     * Verifica a exibição do título da tela "Transferir"
     *
     * @return
     * @throws Exception
     */
    public TransferirTela validarExibicaoTelaTransferir() throws Exception {
        validarCondicaoBooleana(verificarPresencaElemento(tituloTelaTransferir), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a exibição do título da tela \"TRANSFERIR\"");
        salvarEvidencia("Visualizar tela \"TRANSFERIR\"");
        return this;
    }

    /**
     * Tocar botão "Continuar"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar botão \"Continuar\"")
    public TransferirTela tocarBotaoContinuar() throws Exception {
        aguardarCarregamentoElemento(botaoContinuar);
        tocarElemento(botaoContinuar, "Erro ao executar a ação de tocar botão \"Continuar\"");
        salvarEvidencia("Tocar botão \"Continuar\"");
        return this;
    }

    /**
     * Retorna um dicionário com o de-para da tabela da cortina de validação
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
            List<MobileElement> elementosCampo = retornarLista(locatorCampo, "Não foi possível encontrar um campo para validação");
            List<MobileElement> elementosValor = retornarLista(locatorValor, "Não foi possível encontrar um valor de campo para validação");

            for (int i = 0; i < elementosCampo.size(); i++) {
                String campo = retornarTexto(elementosCampo.get(i), "").trim().toUpperCase();
                String valor = normalizaString(retornarTexto(elementosValor.get(i), ""));
                dicionario.put(campo, valor);
            }
        }

        return dicionario;
    }

    /**
     * Tocar botão "Fechar(x)"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar no botão fechar (X)")
    public TransferirTela tocarFechar() throws Exception {
        aguardarCarregamentoElemento(botaoFechar);
        salvarEvidencia("Tocar no botão fechar (X)");
        tocarElemento(botaoFechar, "Nao foi possivel tocar no botão fechar");
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
        escreverTexto(campoValorTranferir, valor.toString(), "Não foi possivel preenher campo valor a transferir");
        salvarEvidencia("campo valor preenchido.");
        return this;
    }

    /**
     * Tocar botão "Transferir"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar botão \"Transferir\"")
    public TransferirTela tocarBotaoTransferir() throws Exception {
        aguardarCarregamentoElemento(botaoTransferir);
        tocarElemento(botaoTransferir, "Erro ao tocar botão \"Transferir\"");
        salvarEvidencia("Tocar botão \"Transferir\"");
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
     * Tocar radio-button "Poupança"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar radio-button \"Poupança\"")
    public TransferirTela tocarRadioButtonPoupanca() throws Exception {
        aguardarCarregamentoElemento(radioPoupanca);
        tocarElemento(radioPoupanca, "Erro ao tocar radio-button \"Poupança\"");
        salvarEvidencia("Tocar radio-button \"Poupança\"");
        return this;
    }

    /**
     * Preencher campo "Valor Transferência"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Preencher campo \"Valor Transferência\"")
    public TransferirTela preencherValorTransferencia() throws Exception {
        aguardarCarregamentoElemento(valorTransferencia);
        escreverTexto(valorTransferencia, String.valueOf(numeroAleatorio(1, 499999)), "Erro ao preencher valor transferência");
        salvarEvidencia("Preencher valor transferência com " + retornarTexto(valorTransferencia, "Erro ao recuperar atributo texto"));
        return this;
    }

    /**
     * Preencher campo "Nome Transferência" com nome aleatório
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Preencher campo \"Nome Transferência\"")
    public TransferirTela preencherNomeTransferencia() throws Exception {
        aguardarCarregamentoElemento(nomeTransferencia);
        escreverTexto(nomeTransferencia, gerarNomeAleatorio(), "Erro ao preencher campo \"Nome TransferÃªncia\"");
        salvarEvidencia("Preencher campo Nome TransferÃªncia com \"" + gerarNomeAleatorio() + "\"");
        return this;
    }

    /**
     * Realizar o swipe da cortina de confirmação de contato novo
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
     * Validar campos da cortina onde se fez swipe depois da inclusão de novo contato
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Validar campos e valores respectivos na cortina dropdown de confirmação do contato")
    public TransferirTela validarCamposCortinaConfirmacao(String... campos) throws Exception {

        // Cuidar com
        final int DE = 0; // De
        final int PARA = 1; // Para
        final int CPF = 2; // CPF
        final int BANCO = 3; // Banco/instituição
        final int AGENCIA = 4; // Agência
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
        com exceção do banco, que é validado com contains()
         */

        validarCondicaoBooleana(dicionario.get(campos[DE]).equals(normalizaString("Você")), MetodoComparacaoBooleano.VERDADEIRO, "");
        validarCondicaoBooleana(dicionario.get(campos[PARA]).equals(para), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar o contato.");
        validarCondicaoBooleana(dicionario.get(campos[CPF]).equals(cpf), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar o CPF.");
        validarCondicaoBooleana(dicionario.get(campos[BANCO]).contains(banco), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar o banco.");
        validarCondicaoBooleana(dicionario.get(campos[AGENCIA]).equals(agencia), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a agência.");
        validarCondicaoBooleana(dicionario.get(campos[CONTA]).equals(conta), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a conta.");

        salvarEvidencia("Validação dos campos da cortina de contato novo");
        return this;
    }

    /**
     * Validar campos da cortina onde se fez swipe depois da inclusão de novo contato
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Validar campos e valores respectivos na cortina dropdown de confirmação do contato")
    public TransferirTela validarCamposCortinaConfirmacaoInformada() throws Exception {

        String nomeSobreNome = DadosContato.recuperarDadosContato(Contato.NOME) + " " + DadosContato.recuperarDadosContato(Contato.SOBRENOME);


        String voce = android ? "Você" : "Você - next";
        String para = normalizaString(nomeSobreNome);
        String cpf = normalizaString(DadosContato.recuperarDadosContato(Contato.CPF));
        String banco = normalizaString(DadosContato.recuperarDadosContato(Contato.BANCO));
        String agencia = normalizaString(DadosContato.recuperarDadosContato(Contato.AGENCIA));
        String conta = normalizaString(DadosContato.recuperarDadosContato(Contato.CONTA));

        Map<String, String> dicionario = retornaCortinaValidacaoNormalizada();


        /*
        Validar campos exatamente
        com exceção do banco, que é validado com contains()
         */

        validarCondicaoBooleana(dicionario.get("DE").equals(normalizaString(voce)), MetodoComparacaoBooleano.VERDADEIRO, "");
        validarCondicaoBooleana(dicionario.get("PARA").equals(para), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar o contato.");
        validarCondicaoBooleana(dicionario.get("CPF").equals(cpf), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar o CPF.");
        validarCondicaoBooleana(dicionario.get("BANCO").contains(banco), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar o banco.");
        validarCondicaoBooleana(dicionario.get("AGÊNCIA").equals(agencia), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a agência.");
        validarCondicaoBooleana(dicionario.get("CONTA").equals(conta), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a conta.");

        salvarEvidencia("Validação dos campos da cortina de contato novo");
        return this;
    }

    /**
     * Validar campos da cortina onde se fez swipe depois da inclusão de novo contato
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Validar campos e valores respectivos na cortina dropdown de confirmação do contato")
    public TransferirTela ValidarCamposCortinaConfirmacaoInformada(String nome, String sobreNome, String cpf, String banco, String agencia, String conta) throws Exception {

        String nomeSobreNome = nome + " " + sobreNome;
        salvarEvidencia("Validação dos campos da cortina de contato novo");

        String voce = android ? "Você" : "Você - next";
        String para = normalizaString(nomeSobreNome);
        cpf = normalizaString(cpf);
        banco = normalizaString(banco);
        agencia = normalizaString(agencia);
        conta = normalizaString(conta);

        Map<String, String> dicionario = retornaCortinaValidacaoNormalizada();

        /*
        Validar campos exatamente
        com exceção do banco, que é validado com contains()
         */

        validarCondicaoBooleana(dicionario.get("DE").equals(normalizaString(voce)), MetodoComparacaoBooleano.VERDADEIRO, "");
        validarCondicaoBooleana(dicionario.get("PARA").equals(para), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar o contato.");
        validarCondicaoBooleana(dicionario.get("CPF").equals(cpf), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar o CPF.");
        validarCondicaoBooleana(dicionario.get("BANCO").contains(banco), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar o banco.");
        validarCondicaoBooleana(dicionario.get("AGÊNCIA").equals(agencia), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a agência.");
        validarCondicaoBooleana(dicionario.get("CONTA").equals(conta), MetodoComparacaoBooleano.VERDADEIRO, "Não foi possível validar a conta.");

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
        return validarCamposCortinaConfirmacao("De", "Para", "CPF", "Banco", "Agência", "Conta");

    }

    /**
     * Tocar botão "Nova Transferência"
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Tocar botão \"Nova Transferência\"")
    public TransferirTela tocarBotaoNovaTransferencia() throws Exception {
        aguardarCarregamentoElemento(botaoNovaTransferencia);
        salvarEvidencia("Tocar botão \"Nova Transferência\"");
        tocarElemento(botaoNovaTransferencia, "Erro ao tocar botão \"Nova Transferência\"");
        return this;
    }
}

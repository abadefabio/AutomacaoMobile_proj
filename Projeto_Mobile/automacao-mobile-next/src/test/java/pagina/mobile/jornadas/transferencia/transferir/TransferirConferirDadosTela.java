package pagina.mobile.jornadas.transferencia.transferir;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.constantes.massa.contato.Contato;
import br.com.next.automacao.core.constantes.transferencia.TransferirPara;
import br.com.next.automacao.core.massa.contato.DadosContato;
import br.com.next.automacao.core.tools.Utilitarios;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.transferencia.ContaPagamento;
import constantes.transferencia.NomeTransferencia;
import constantes.transferencia.TipoDeConta;
import constantes.transferencia.TipoDeInstituicaoFinanceira;
import constantes.transferencia.TipoTransferencia;
import constantes.transferencia.TransferenciaMotivo;
import framework.AcoesGerais;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static br.com.next.automacao.core.tools.Utilitarios.normalizaString;
import static pagina.mobile.comum.next.CalendarioTela.retornaAno;
import static pagina.mobile.comum.next.CalendarioTela.retornaDia;
import static pagina.mobile.comum.next.CalendarioTela.retornaNomeMes;
import static pagina.mobile.jornadas.login.LoginTela.retornaCpfLogin;
import static pagina.mobile.jornadas.transferencia.transferir.TransferirValorTela.retornaValorTransferencia;

public class TransferirConferirDadosTela extends PaginaBase {

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_item")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText['label == \"De\"']")
    @iOSXCUITFindBy(accessibility = "De")
    private MobileElement raizNomeCampoCortinaConfirmacao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_description")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText['label CONTAINS \"Voc�\"']")
    @iOSXCUITFindBy(accessibility = "Voc� - next")
    private MobileElement raizValorCampoCortinaConfirmacao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text,'Transferir') OR @content-desc='Transferir']")
    @AndroidFindBy(xpath = "//android.widget.Button[@resource-id='br.com.bradesco.next:id/bt_transfer']")
    @AndroidFindBy(accessibility = "Transferir")
    @iOSXCUITFindBy(accessibility = "TRANSFERIR")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == 'TRANSFERIR'`]")
    private MobileElement botaoTransferir;

    @AndroidFindBy(xpath = "//*[contains(@text, \"R$\")]")
    @iOSXCUITFindBy(xpath = "//*[contains(@value, \"R$\")]")
    private MobileElement valorDaTransferencia;

    public TransferirConferirDadosTela(AppiumDriver driver) {
        super(driver);
    }

    private enum TipoCampoValor {
        CAMPO,
        VALOR
    }

    /**
     * Retorna a lista de campos vis�veis da tela de confirma��o de transfer�ncia
     *
     * @return
     * @throws Exception
     */
    private List<MobileElement> retornarListaDeCampos() throws Exception {
        return retornaListaFaixaValidacao(TipoCampoValor.CAMPO);
    }

    /**
     * Retorna a lista de valore vis�veis relativos a cada campo da tela de confirma��o de transfer�ncia
     *
     * @return
     * @throws Exception
     */
    private List<MobileElement> retornarListaDeValores() throws Exception {
        return retornaListaFaixaValidacao(TipoCampoValor.VALOR);
    }


    /**
     * Retorna os elementos do mesmo tipo relativos � tela de confirma��o de transfer�ncia
     *
     * @param tipo elementos do tipo campo ou valor
     * @return
     * @throws Exception
     */
    private List<MobileElement> retornaListaFaixaValidacao(TipoCampoValor tipo) throws Exception {

        List<MobileElement> lista = new ArrayList<>();

        if (ios) {
            int indiceCampoValor = tipo == TipoCampoValor.CAMPO ? 1 : 2;
            int linhas = retornarLista(By.xpath("//XCUIElementTypeCell"), "").size();
            for (int i = 1; i <= linhas; i++) {
                MobileElement elemento = retornarElemento(By.xpath("//XCUIElementTypeCell[" + i + "]//XCUIElementTypeStaticText[" + indiceCampoValor + "]"), "");
                lista.add(elemento);
            }
        } else {
            By locator = tipo.equals(TipoCampoValor.CAMPO) ?
                    By.id("br.com.bradesco.next:id/tv_item") : By.id("br.com.bradesco.next:id/tv_description");
            aguardarCarregamentoElemento(locator);

            lista = retornarLista(locator, "N�o foi poss�vel encontrar um campo/valor para valida��o");
        }

        return lista;
    }

    /**
     * Validar a tela 'Confere os Dados'
     *
     * @return
     */
    @Step("Validar a tela 'Confere os Dados'")
    public TransferirConferirDadosTela validarExibicaotelaConfereOsDados() {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos("CONFERE OS DADOS"), MetodoComparacaoBooleano.VERDADEIRO,
                "Erro ao validar a tela 'Confere os Dados'");
        salvarEvidencia("Validou a tela 'Confere os Dados'");
        return this;
    }


    /**
     * Tocar bot�o "Transferir"
     *
     * @return TransferirConferirDados
     * @throws Exception
     */
    @Step("Tocar bot�o \"Transferir\"")
    public TransferirConferirDadosTela tocarBotaoTransferir() throws Exception {
        esperarCarregando();
        rolarTelaAteFinal();
        salvarEvidencia("Tocar bot�o \"Transferir\"");
        tocarElemento(botaoTransferir, "Erro ao executar a a��o de tocar bot�o \"Transferir\"");
        return this;
    }

    /**
     * Validar campos da cortina antes da confirma��o da transfer�ncia
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Validar campos e valores respectivos na cortina dropdown de confirma��o da transfer�ncia")
    public TransferirConferirDadosTela validarCamposCortinaConfirmacaoAgendamento(ContaPagamento contaPagamento) throws Exception {
        Map<String, String> camposValoresEsperados = gerarListaDeCamposValoresEsperado(contaPagamento);

        esperarCarregando();

        aguardarCarregamentoElemento(camposValoresEsperados);

        aguardarCarregamentoElemento(raizNomeCampoCortinaConfirmacao);

        OperadorEvidencia.logarPasso("Recuperar lista de campos");

        List<MobileElement> listaDeCampos = retornarListaDeCampos();
        aguardarCarregamentoElemento(listaDeCampos);

        OperadorEvidencia.logarPasso("Recuperar lista de valores");

        List<MobileElement> listaDeValores = retornarListaDeValores();
        aguardarCarregamentoElemento(listaDeValores);

        tratarIndicesInvertidos(listaDeCampos, listaDeValores, camposValoresEsperados);

        OperadorEvidencia.logarPasso("Validar campos e valores");

        new AcoesGerais((AppiumDriver) driver).
                validarCamposValor(listaDeCampos, listaDeValores, camposValoresEsperados);

        salvarEvidencia("Valida��o dos campos da cortina com resumo da transfer�ncia");
        return this;
    }

    /**
     * Gera um dicion�rio de campos com os respectivos valores esperados conforme os par�metros da transfer�ncia
     *
     * @param contaPagamento Par�metros da transfer�ncia, como nome do contato e dados banc�rios
     * @return
     * @throws Exception
     */
    private Map<String, String> gerarListaDeCamposValoresEsperado(ContaPagamento contaPagamento) throws Exception {
        Map<String, String> camposValoresEsperados = new HashMap<>(montarDicionarioBasico(contaPagamento)); // adiciona campos e valores b�sicos

        if (contaPagamento.recuperarTipoInstituicao().equals(TipoDeInstituicaoFinanceira.INSTITUICAO_DE_PAGAMENTO)) {
            camposValoresEsperados.putAll(montarDicionarioTipoContasOrigemContaPagamento(contaPagamento)); // adiciona quando a conta destino � Conta Pagamento
        } else {
            camposValoresEsperados.putAll(montarDicionarioTipoContasOrigemDestino(contaPagamento)); // adiciona CC ou CP
        }

        camposValoresEsperados.putAll(montarDicionarioMimOutraPessoa(contaPagamento));       // adiciona CPF se for "para mim"

        if (ios) { // valida ap�nas em IOS conforme modelagens de alguns casos de testes
            camposValoresEsperados.putAll(montarDicionarioTipoTransferencia(contaPagamento)); // adiciona DOC, TED  se n�o for para Bradesco/Next
        }

        if (!contaPagamento.recuperarNomeTransferencia().equals(NomeTransferencia.NAO_PREENCHER)) {
            camposValoresEsperados.putAll(montarDicionarioDescricao(contaPagamento)); // adiciona descri��o, valida se o campo n�o for vazio.
        }

        return camposValoresEsperados;
    }

    /**
     * Tratamento para alguns apps iOS que apresenta �ndice invertido
     *
     * @param camposLista
     * @param valoresLista
     * @param camposValoresEsperados
     */
    private void tratarIndicesInvertidos(List<MobileElement> camposLista, List<MobileElement> valoresLista, Map<String, String> camposValoresEsperados) {
        camposValoresEsperados.forEach((campo, valor) -> {
            MobileElement elementoAuxiliar;
            for (int i = 0; i < camposLista.size(); i++) {
                if (camposLista.get(i).getText().contains(valor) && valoresLista.get(i).getText().contains(campo)) {
                    elementoAuxiliar = camposLista.get(i);
                    camposLista.set(i, valoresLista.get(i));
                    valoresLista.set(i, elementoAuxiliar);
                }
            }
        });
    }

    /**
     * Validar campos da cortina antes da confirma��o da transfer�ncia
     * FR
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Validar campos e valores respectivos na cortina dropdown de confirma��o da transfer�ncia")
    public TransferirConferirDadosTela validarCamposCortinaConfirmacaoAgendamento(JSONObject contaPagamento) throws Exception {
        Map<String, String> dicionarioEsperado = new HashMap<>();
        dicionarioEsperado.putAll(montarDicionarioBasico(contaPagamento)); // adiciona campos e valores b�sicos
        dicionarioEsperado.putAll(montarDicionarioTipoContasOrigemDestino(contaPagamento)); // adiciona CC ou CP
        dicionarioEsperado.putAll(montarDicionarioMimOutraPessoa(contaPagamento));       // adiciona CPF se for "para mim"
        dicionarioEsperado.putAll(montarDicionarioTipoTransferencia(contaPagamento)); // adiciona DOC, TED  se n�o for para Bradesco/Next

        esperarCarregando();
        aguardarCarregamentoElemento(raizNomeCampoCortinaConfirmacao); // estabilidade

        validarCamposValor(retornaListaFaixaValidacao(TipoCampoValor.CAMPO), retornaListaFaixaValidacao(TipoCampoValor.VALOR), dicionarioEsperado);

        salvarEvidencia("Valida��o dos campos da cortina com resumo da transfer�ncia");

        return this;
    }

    /**
     * Validar campos da cortina antes da confirma��o da transfer�ncia
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Validar campos e valores respectivos na cortina dropdown de confirma��o da transfer�ncia")
    public TransferirConferirDadosTela validarCamposCortinaConfirmacaoAgendamento(ContaPagamento contaPagamento, TransferenciaMotivo motivo) throws Exception {

        Map<String, String> dicionarioEsperado = new HashMap<>();
        dicionarioEsperado.putAll(montarDicionarioBasico(contaPagamento)); // adiciona campos e valores b�sicos
        if (contaPagamento.recuperarTipoInstituicao().equals(TipoDeInstituicaoFinanceira.INSTITUICAO_DE_PAGAMENTO))
            dicionarioEsperado.putAll(montarDicionarioTipoContasOrigemContaPagamento(contaPagamento)); // adiciona quando a conta destino � Conta Pagamento
        else
            dicionarioEsperado.putAll(montarDicionarioTipoContasOrigemDestino(contaPagamento)); // adiciona CC ou CP
        dicionarioEsperado.putAll(montarDicionarioMimOutraPessoa(contaPagamento));       // adiciona CPF se for "para mim"
        if (ios)
            dicionarioEsperado.putAll(montarDicionarioTipoTransferencia(contaPagamento)); // adiciona DOC, TED  se n�o for para Bradesco/Next
        dicionarioEsperado.putAll(montarDicionarioMotivoTransferencia(motivo)); // adiciona motivo - ou finalidade
        esperarCarregando();
        aguardarCarregamentoElemento(raizNomeCampoCortinaConfirmacao); // estabilidade
        List<MobileElement> listaCampo = retornaListaFaixaValidacao(TipoCampoValor.CAMPO);
        List<MobileElement> listaValor = retornaListaFaixaValidacao(TipoCampoValor.VALOR);
        // tratamento para alguns apps iOS que apresenta �ndice invertido
        tratarIndicesInvertidos(listaCampo, listaValor, dicionarioEsperado);
        validarCamposValor(listaCampo, listaValor, dicionarioEsperado);
        salvarEvidencia("Valida��o dos campos da cortina com resumo da transfer�ncia");

        return this;
    }

    /**
     * Montar dicion�rio esperado com base nos par�metros informados
     *
     * @return hashmap
     * @throws Exception
     */
    public Map<String, String> montarDicionarioBasico(ContaPagamento contaPagamento) throws Exception {
        Map<String, String> dicionarioBasico = new HashMap<>();
        boolean isInstituicao = contaPagamento.recuperarTipoInstituicao().equals(TipoDeInstituicaoFinanceira.INSTITUICAO_DE_PAGAMENTO);

        dicionarioBasico.put(ios && !isInstituicao ? "Banco" : "Banco ou Institui��o", contaPagamento.recuperarBancoValidacaoTransf());
        dicionarioBasico.put("De", ios ? "Voc� - next" : "Voc�");
        dicionarioBasico.put("Ag�ncia", contaPagamento.recuperarAgencia());
        dicionarioBasico.put(isInstituicao ? "Conta pagamento" : "Conta", contaPagamento.recuperarConta());
        dicionarioBasico.put("Valor", "R$ " + retornaValorTransferencia());
        dicionarioBasico.put("Quando", retornaDia() + retornaNomeMes().substring(0, 3) + retornaAno());

        return dicionarioBasico;
    }

    /**
     * Montar dicion�rio esperado com base nos par�metros informados
     * FR
     *
     * @return hashmap
     * @throws Exception
     */
    public Map<String, String> montarDicionarioBasico(JSONObject contaPagamento) throws Exception {
        Map<String, String> dicionarioBasico = new HashMap<>();

        salvarEvidencia("Inicio da valida��o dos campos da transfer�ncia");
        dicionarioBasico.put(ios ? "Banco" : "Banco ou institui��o", contaPagamento.get("numeroBanco").toString());
        dicionarioBasico.put("De", ios ? "Voc� - next" : "Voc�");
        dicionarioBasico.put("Ag�ncia", contaPagamento.get("agencia").toString());
        dicionarioBasico.put("Conta", contaPagamento.get("conta").toString());
        dicionarioBasico.put("Valor", "R$ " + retornaValorTransferencia());
        return dicionarioBasico;
    }

    /**
     * Montar campos do dicionar�rio esperado relacionados com tipos de conta de origem e destino
     *
     * @return hashmap
     * @throws Exception
     */
    public Map<String, String> montarDicionarioTipoContasOrigemDestino(ContaPagamento contaPagamento) throws Exception {
        Map<String, String> dicionarioTipoContasOrigemDestino = new HashMap<>();
        String valorTipoDeContaOrigem = "";
        String valorTipoDeContaDestino = "";

        TipoDeConta origem = contaPagamento.recuperarTipoContaOrigem();
        TipoDeConta destino = contaPagamento.recuperarTipoContaDestino();

        if (ios) {
            valorTipoDeContaOrigem = origem.equals(TipoDeConta.CONTA_CORRENTE) ? "Conta-Corrente" : "Poupan�a";
            switch (destino) {
                case CONTA_CORRENTE:
                    valorTipoDeContaDestino = "Conta-corrente";
                    break;
                case CONTA_POUPANCA:
                    valorTipoDeContaDestino = "Poupan�a";
                    break;
                case CONTA_PAGAMENTO:
                    valorTipoDeContaDestino = "Conta pagamento";
                    break;
            }
        } else {
            valorTipoDeContaOrigem = origem.equals(TipoDeConta.CONTA_CORRENTE) ? "Conta-corrente" : "Conta-Poupan�a";
            switch (destino) {
                case CONTA_CORRENTE:
                    valorTipoDeContaDestino = "Conta-corrente";
                    break;
                case CONTA_POUPANCA:
                    valorTipoDeContaDestino = "Conta-Poupan�a";
                    break;
                case CONTA_PAGAMENTO:
                    valorTipoDeContaDestino = "Conta de pagamento";
                    break;
            }
        }

        dicionarioTipoContasOrigemDestino.put("Tipo de conta (origem)", valorTipoDeContaOrigem);
        dicionarioTipoContasOrigemDestino.put("Tipo de conta (destino)", valorTipoDeContaDestino);

        return dicionarioTipoContasOrigemDestino;
    }

    /**
     * Montar campos do dicionar�rio esperado relacionados com tipos de conta de origem e destino
     * FR
     *
     * @return hashmap
     * @throws Exception
     */
    public Map<String, String> montarDicionarioTipoContasOrigemDestino(JSONObject contaPagamento) throws Exception {
        Map<String, String> dicionarioTipoContasOrigemDestino = new HashMap<>();
        String valorTipoDeContaOrigem = null;
        String valorTipoDeContaDestino = null;

        String origem = contaPagamento.get("TipoContaOrigem").toString();
        String destino = contaPagamento.get("TipoContaDestino").toString();


        if (ios)
            valorTipoDeContaOrigem = origem.equals(TipoDeConta.CONTA_CORRENTE.toString()) ? "Conta-corrente" : "Poupan�a";
        else
            valorTipoDeContaOrigem = origem.equals(TipoDeConta.CONTA_CORRENTE.toString()) ? "Conta-corrente" : "Conta-Poupan�a";

        if (ios)
            valorTipoDeContaDestino = destino.equals(TipoDeConta.CONTA_CORRENTE.toString()) ? "Conta-corrente" : "Poupan�a";
        else
            valorTipoDeContaDestino = destino.equals(TipoDeConta.CONTA_CORRENTE.toString()) ? "Conta-corrente" : "Conta-Poupan�a";

        dicionarioTipoContasOrigemDestino.put("Tipo de conta (origem)", valorTipoDeContaOrigem);
        dicionarioTipoContasOrigemDestino.put("Tipo de conta (destino)", valorTipoDeContaDestino);

        return dicionarioTipoContasOrigemDestino;
    }

    /**
     * Montar campos do dicionar�rio esperado relacionados com tipos de conta de origem e destino
     *
     * @return hashmap
     * @throws Exception
     */
    public Map<String, String> montarDicionarioMimOutraPessoa(ContaPagamento contaPagamento) throws Exception {
        Map<String, String> dicionarioMimOutraPessoa = new HashMap<>();

        if (contaPagamento.recuperarTransferirPara().equals(TransferirPara.MIM)) {
            dicionarioMimOutraPessoa.put(ios ? "CPF/CNPJ" : "CPF", normalizaString(retornaCpfLogin()));
        }

        return dicionarioMimOutraPessoa;
    }

    /**
     * Montar campos do dicionar�rio esperado relacionados com tipos de conta de origem e destino
     * FR
     *
     * @return hashmap
     * @throws Exception
     */
    public Map<String, String> montarDicionarioMimOutraPessoa(JSONObject contaPagamento) throws Exception {
        Map<String, String> dicionarioMimOutraPessoa = new HashMap<>();

        if (contaPagamento.get("transferirPara").equals(TransferirPara.OUTRA_PESSOA.toString())) {
            dicionarioMimOutraPessoa.put(ios ? "CPF/CNPJ" : "CPF", normalizaString(retornaCpfLogin()));
        }

        return dicionarioMimOutraPessoa;
    }

    /**
     * Montar campos do dicionar�rio esperado relacionados com tipos de conta de origem e destino
     *
     * @return hashmap
     * @throws Exception
     */
    public Map<String, String> montarDicionarioTipoTransferencia(ContaPagamento contaPagamento) throws Exception {
        Map<String, String> dicionarioMeioTransferencia = new HashMap<>();
        String tipo = "Tipo de transfer�ncia";

        switch (contaPagamento.recuperarTipoTransferencia()) {
            case DOC:
                dicionarioMeioTransferencia.put(tipo, "DOC");
                break;
            case TED:
                dicionarioMeioTransferencia.put(tipo, "TED");
                break;

            default:
                /*
                Sem implementa��o para transfer�ncia interna para banco Bradesco ou Next
                 */
        }

        return dicionarioMeioTransferencia;
    }

    /**
     * Montar campos do dicionar�rio esperado relacionados com tipos de conta de origem e destino
     *
     * @return hashmap
     * @throws Exception
     */
    public Map<String, String> montarDicionarioTipoTransferencia(JSONObject contaPagamento) throws Exception {
        Map<String, String> dicionarioMeioTransferencia = new HashMap<>();
        String tipo = "Tipo de transfer�ncia";
        String tipoTransferenciaDocTed = contaPagamento.get("tipoTransferencia").toString();


        if (tipoTransferenciaDocTed.equals(TipoTransferencia.DOC.toString())) {
            dicionarioMeioTransferencia.put(tipo, "DOC");
        }

        if (tipoTransferenciaDocTed.equals(TipoTransferencia.TED.toString())) {
            dicionarioMeioTransferencia.put(tipo, "TED");
        }

        if (tipoTransferenciaDocTed.equals(TipoTransferencia.INTERNA.toString())) {
            dicionarioMeioTransferencia.put(tipo, "Interno");
        }

        return dicionarioMeioTransferencia;
    }

    /**
     * Montar campos do dicionar�rio esperado relacionados com tipos de conta de origem e destino
     *
     * @return hashmap
     * @throws Exception
     */
    public Map<String, String> montarDicionarioMotivoTransferencia(TransferenciaMotivo motivo) throws Exception {
        Map<String, String> dicionarioMotivoTransferencia = new HashMap<>();
        String finalidade = "Finalidade";

        dicionarioMotivoTransferencia.put(finalidade, motivo.toString());

        return dicionarioMotivoTransferencia;
    }

    /**
     * Montar campos do dicionar�rio esperado relacionados a Descri��o (Nome da Transferencia)
     * Validar campos da cortina antes da confirma��o da transfer�ncia
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Validar campos e valores respectivos na cortina dropdown de confirma��o da transfer�ncia")
    public TransferirConferirDadosTela validarCamposCortinaConfirmacaoAgendamentoPf(ContaPagamento contaPagamento) throws Exception {
        Map<String, String> dicionarioEsperado = new HashMap<>();
        dicionarioEsperado.putAll(montarDicionarioBasico(contaPagamento)); // adiciona campos e valores b�sicos
        dicionarioEsperado.putAll(montarDicionarioTipoContasOrigemDestino(contaPagamento)); // adiciona CC ou CP
        dicionarioEsperado.putAll(montarDicionarioMimOutraPessoa(contaPagamento));       // adiciona CPF se for "para mim"
        dicionarioEsperado.putAll(montarDicionarioTipoTransferencia(contaPagamento)); // adiciona DOC, TED  se n�o for para Bradesco/Next

        aguardarCarregamentoElemento(raizNomeCampoCortinaConfirmacao); // estabilidade
        validarCamposValor(retornaListaFaixaValidacao(TipoCampoValor.CAMPO),
                retornaListaFaixaValidacao(TipoCampoValor.VALOR),
                dicionarioEsperado);
        salvarEvidencia("Valida��o dos campos da cortina com resumo da transfer�ncia");

        return this;
    }

    /**
     * Montar dicion�rio esperado com base nos par�metros informados
     *
     * @return hashmap
     * @throws Exception
     */
    public Map<String, String> montarDicionarioTipoContasOrigemContaPagamento(ContaPagamento contaPagamento) throws Exception {
        Map<String, String> dicionarioTipoContasOrigemDestino = new HashMap<>();
        String valorTipoDeContaOrigem = null;
        String valorTipoDeContaDestino = null;

        TipoDeConta origem = contaPagamento.recuperarTipoContaOrigem();

        if (ios)
            valorTipoDeContaOrigem = origem.equals(TipoDeConta.CONTA_CORRENTE) ? "Conta-corrente" : "Poupan�a";
        else
            valorTipoDeContaOrigem = origem.equals(TipoDeConta.CONTA_CORRENTE) ? "Conta-corrente" : "Conta-Poupan�a";

        if (ios)
            valorTipoDeContaDestino = "Conta pagamento";
        else
            valorTipoDeContaDestino = "Conta de Pagamento";

        dicionarioTipoContasOrigemDestino.put("Tipo de Conta (origem)", valorTipoDeContaOrigem);
        dicionarioTipoContasOrigemDestino.put("Tipo de Conta (destino)", valorTipoDeContaDestino);

        return dicionarioTipoContasOrigemDestino;
    }

    public Map<String, String> montarDicionarioPf(ContaPagamento contaPagamento) throws Exception {
        String nomeSobreNome = DadosContato.recuperarDadosContato(Contato.NOME) + " " + DadosContato.recuperarDadosContato(Contato.SOBRENOME);
        Map<String, String> dicionarioBasico = new HashMap<>();

        dicionarioBasico.put(ios ? "Banco" : "Banco ou institui��o", contaPagamento.recuperarBancoValidacaoTransf());
        dicionarioBasico.put("De", ios ? "Voc� - next" : "Voc�");
        dicionarioBasico.put("Ag�ncia", DadosContato.recuperarDadosContato(Contato.AGENCIA));
        dicionarioBasico.put("Conta", DadosContato.recuperarDadosContato(Contato.BANCO));
        dicionarioBasico.put("Valor", "R$ " + retornaValorTransferencia());
        dicionarioBasico.put("Quando", retornaDia() + retornaNomeMes().substring(0, 3) + retornaAno());

        return dicionarioBasico;
    }

    /**
     * Retorna um dicion�rio com o de-para da tabela da cortina de valida��o
     * FR
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
     * Validar campos da cortina onde se fez swipe depois da inclus�o de novo contato
     * FR
     *
     * @return TransferirTela
     * @throws Exception
     */
    @Step("Validar campos e valores respectivos na cortina dropdown de confirma��o do contato")
    public TransferirConferirDadosTela ValidarCamposCortinaConfirmacaoAgendamento(String nome, String sobreNome, String cpf, String banco, String agencia, String conta, String tipoConta, String tipoTransferencia, String finalidade) throws Exception {

        String nomeSobreNome = nome + " " + sobreNome;
        salvarEvidencia("Inicio Valida��o para conferir os dados.");

        String voce = android ? "Voc�" : "Voc� - next";
        String para = normalizaString(nomeSobreNome);
        cpf = normalizaString(cpf);
        banco = normalizaString(banco);
        agencia = normalizaString(agencia);
        conta = normalizaString(conta);
        tipoConta = normalizaString(tipoConta);
        tipoTransferencia = normalizaString(tipoTransferencia);
        finalidade = normalizaString(finalidade);
        String dataAgendamento = normalizaString(retornaDia() + retornaNomeMes().substring(0, 3) + retornaAno());

        Map<String, String> dicionario = retornaCortinaValidacaoNormalizada();
        Map<String, String> dicionario1 = (Map<String, String>) retornaListaFaixaValidacao(TipoCampoValor.CAMPO);

        /*
        Validar campos exatamente
        com exce��o do banco, que � validado com contains()
         */

        validarCondicaoBooleana(dicionario.get("DE").equals(normalizaString(voce)), MetodoComparacaoBooleano.VERDADEIRO, "");
        validarCondicaoBooleana(dicionario.get("PARA").equals(para), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar o contato.");
        validarCondicaoBooleana(dicionario.get("CPF/CNPJ").equals(cpf), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar o CPF.");
        validarCondicaoBooleana(dicionario.get("BANCO OU INSTITUI��O").contains(banco), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar o banco.");
        validarCondicaoBooleana(dicionario.get("AG�NCIA").equals(agencia), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a ag�ncia.");
        validarCondicaoBooleana(dicionario.get("CONTA").equals(conta), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a conta.");
        validarCondicaoBooleana(dicionario.get("TIPO DE CONTA (ORIGEM)").equals(tipoConta), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a conta.");
        validarCondicaoBooleana(dicionario.get("TIPO DE TRANSFER�NCIA").equals(tipoTransferencia), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a conta.");
        validarCondicaoBooleana(dicionario.get("FINALIDADE").equals(finalidade), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a conta.");
        validarCondicaoBooleana(dicionario.get("VALOR").contains(retornaValorTransferencia()), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar a conta.");
        validarCondicaoBooleana(dicionario.get("QUANDO").contains(dataAgendamento), MetodoComparacaoBooleano.VERDADEIRO, "N�o foi poss�vel validar o adendamento.");

        salvarEvidencia("Valida��o - Confere dados dos campos do agendamento. ");
        return this;
    }

    /**
     * Montar dicion�rio esperado com base nos par�metros informados
     *
     * @return hashmap
     * @throws Exception
     */
    public Map<String, String> montarDicionarioDescricao(ContaPagamento contaPagamento) throws Exception {
        Map<String, String> dicionarioDescricao = new HashMap<>();
        dicionarioDescricao.put("Descri��o", contaPagamento.recuperarNomeTransferencia().recuperarNome());
        return dicionarioDescricao;
    }

    /**
     * Montar dicion�rio esperado com base nos par�metros informados
     *
     * @return hashmap
     * @throws Exception
     */
    public Map<String, String> montarDicionarioBasicoNV(String nomeCompleto, String cpf, String banco, String agencia, String conta, String tipoConta, String tipoTransferencia, String finalidade) throws Exception {
        Map<String, String> dicionarioBasico = new HashMap<>();
        //String nomeSobreNome = nome + " " + sobreNome;

        dicionarioBasico.put(ios ? "Banco" : "Banco ou institui��o", banco);
        dicionarioBasico.put("De", ios ? "Voc� - next" : "Voc�");
        dicionarioBasico.put("Para", nomeCompleto);
        dicionarioBasico.put("Ag�ncia", agencia);
        dicionarioBasico.put("Conta", conta);
        dicionarioBasico.put("Tipo de conta (origem)", tipoConta);
        dicionarioBasico.put("tipo de transfer�ncia", tipoTransferencia);
        dicionarioBasico.put("Valor", "R$ " + retornaValorTransferencia());
        dicionarioBasico.put("Quando", retornaDia() + retornaNomeMes().substring(0, 3) + retornaAno());


        return dicionarioBasico;
    }

    private List<MobileElement> retornaListaFaixaValidacao() throws Exception {

        Map<String, String> dicionario = new HashMap<>();


        List<MobileElement> lista = new ArrayList<>();

        if (ios) {

            int linhas = retornarLista(By.xpath("//XCUIElementTypeCell"), "").size();
            for (int i = 1; i <= linhas; i++) {
                MobileElement elemento = retornarElemento(By.xpath("//XCUIElementTypeCell[" + i + "]//XCUIElementTypeStaticText[" + TipoCampoValor.CAMPO + "]"), "");
                lista.add(elemento);
            }
        } else {
            By locatorCampo = By.id("br.com.bradesco.next:id/tv_item");
            aguardarCarregamentoElemento(raizNomeCampoCortinaConfirmacao);
            By locatorValor = By.id("br.com.bradesco.next:id/tv_description");
            aguardarCarregamentoElemento(raizValorCampoCortinaConfirmacao);
            List<MobileElement> elementosCampo = retornarLista(locatorCampo, "N�o foi poss�vel encontrar um campo para valida��o");
            List<MobileElement> elementosValor = retornarLista(locatorValor, "N�o foi poss�vel encontrar um valor de campo para valida��o");
            for (int i = 0; i < elementosCampo.size(); i++) {
                String campo = retornarTexto(elementosCampo.get(i), "").trim().toUpperCase();
                String valor = normalizaString(retornarTexto(elementosValor.get(i), ""));
                dicionario.put(campo, valor);
            }
        }

        return lista;
    }

    /**
     * Rolar tela para baixo e para cima para poder mapear os elementos antes de montar o dicionario
     *
     * @return hashmap
     * @throws Exception
     */
    public void rolaTelaBaixoCimaParaMontarDicionario() throws Exception {
        rolarTelaAteFinal();
        rolarTelaAteInicio();
    }

    /**
     * Obter o valor a ser transferido
     *
     * @return hashmap
     * @throws Exception
     */
    public TransferirConferirDadosTela obterValorDaTransferencia(ThreadLocal valor) throws Exception {
        aguardarCarregamentoElemento(valorDaTransferencia);
        if (valor != null) {
            valor.set(Utilitarios.normalizaStringNumero(retornarTexto(valorDaTransferencia, "N�o foi poss�vel retornar valor a ser transferido")));
            OperadorEvidencia.logarPasso("Valor contido na thread: " + valor.get());
        }
        return this;
    }
}

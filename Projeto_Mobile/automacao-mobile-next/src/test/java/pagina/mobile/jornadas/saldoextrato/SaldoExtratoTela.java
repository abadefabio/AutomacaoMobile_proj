package pagina.mobile.jornadas.saldoextrato;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.constantes.recarga.FormaPagamento;
import br.com.next.automacao.core.exception.NextException;
import  br.com.next.automacao.core.tools.Utilitarios;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.saldoextrato.CategoriaTransacao;
import constantes.saldoextrato.Mensagem;
import constantes.saldoextrato.TipoTransacao;
import constantes.saldoextrato.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.testng.util.Strings;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static pagina.mobile.comum.next.CalendarioTela.retornaAno;
import static pagina.mobile.comum.next.CalendarioTela.retornaDia;
import static pagina.mobile.comum.next.CalendarioTela.retornaMes;
import static pagina.mobile.jornadas.transferencia.transferir.TransferirValorTela.retornaValorTransferencia;

public class SaldoExtratoTela extends PaginaBase {

    public static ThreadLocal<String> transacaoValidar = new ThreadLocal<String>();

    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_icon")
    @iOSXCUITFindBy(xpath = "\t//XCUIElementTypeButton[@name=\"icon vs all\"]")
    private MobileElement botaoTodasMovimentacoes;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_name")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeApplication[@name=\"next\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeTable/XCUIElementTypeCell")
    private MobileElement botaoTransacao;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='POUPANÇA']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"POUPANÇA\"]")
    private MobileElement botaoPoupanca;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text = \"CONTA-CORRENTE\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"CONTA-CORRENTE\"]")
    private MobileElement botaoContaCorrente;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_name")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[-1]")
    private MobileElement botaoExpandir;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_info")
    //@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[-1]")
    private MobileElement botaoOutrosPeriodos;

    @AndroidFindBy(id = "br.com.bradesco.next:id/tv_name")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell[-1]")
    private MobileElement transacaoRecarga;

    //icone Futuro - Não foi usado
    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,\"FUTUROS\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton['label == \"FUTUROS\"']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"FUTUROS\"]")
    private MobileElement iconeFuturos;

    //botao Deletar transação futura
    @AndroidFindBy(xpath = "//*[contains(@text,\"DELETAR\")]")
    private MobileElement botaoDeletar;

    //botao Editar transação futura
    @AndroidFindBy(id = "br.com.bradesco.next:id/iv_gv_edit")
    private MobileElement botaoEditar;

    //card tranferencia
    @iOSXCUITFindBy(xpath = "//*[@name=\"icon-cell-collapsed\"]/..")
    private MobileElement cardTransferencia;

    //Elemento que representa o fundo do card de uma transferencia
    @iOSXCUITFindBy(xpath = "//*[@name=\"icon-cell-collapsed\"]/../XCUIElementTypeOther[last()]")
    private MobileElement finalDoCardTranferencia;

    //Ícone (v) Cancelar Agendamento
    @AndroidFindBy(id = "br.com.bradesco.next:id/done")
    private MobileElement iconeConfirmar;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Hoje\"]")
    private MobileElement marcadorDiaHoje;

    @iOSXCUITFindBy(accessibility = "Não tem movimentações na sua conta nesse período.")
    private MobileElement mensagemSemMovimentacoes;

    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView")
    private MobileElement boxVisaoTransacoes;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(accessibility = "SAÍDA")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='SAÍDA']")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='SAÍDA']")
    private MobileElement abaSaida;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains (upper-case(@text), 'TODAS')]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"TODAS\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"TODAS\"]")
    private MobileElement abaTodas;

    @iOSXCUITFindBy(accessibility = "icon-cell-collapsed")
    @AndroidFindBy(id = "br.com.bradesco.next:id/arrow_expand_imageview")
    private MobileElement setaExpandirTransacao;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text, \"7 DIAS\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"7 DIAS\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"7 DIAS\"]")
    private MobileElement botaoFiltroSeteDias;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text, \"15 DIAS\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"15 DIAS\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"15 DIAS\"]")
    private MobileElement botaoFiltroQuinzeDias;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains(@text, \"30 DIAS\")]")
    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeButton[`label == \"30 DIAS\"`]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"30 DIAS\"]")
    private MobileElement botaoFiltroTrintaDias;

    @HowToUseLocators(iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"icon-cell-collapsed\"]/ancestor::XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    @iOSXCUITFindBy(xpath = "//*[@name='PIX AGENDADO']/following-sibling::XCUIElementTypeOther[1]")
    private MobileElement botaoDeletarAgendamento;

    //ToDo: Falta mapear a movimentação com 7, 15 e 30 dias, porem, precisa gerar a massa.
    private MobileElement movimentacaoPoupanca;

    private By elementoValorTransacao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(id = "br.com.bradesco.next:id/toolbar_title")
    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"SALDO E EXTRATO\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"SALDO E EXTRATO\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"SALDO E EXTRATO\"]")
    private MobileElement tituloSaldoExtrato;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Menu, Botão\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Voltar\"]")
    private MobileElement botaoHeaderVoltar;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains (upper-case(@text), 'ENTRADA')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"ENTRADA\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"ENTRADA\"]")
    private MobileElement abaEntrada;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//*[contains (upper-case(@text), 'FUTUROS')]")
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"FUTUROS\"]")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"FUTUROS\"]")
    private MobileElement abaFuturos;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/arrow_expand_imageview")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeImage[@name=\"icon-cell-collapsed\"]")
    private MobileElement expandirDetalhes;

    @iOSXCUITFindBy(xpath = "//*/XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    private MobileElement elementoDetalhesDaTransacao;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell")
    @AndroidFindBy(xpath = "//android.view.ViewGroup/android.widget.ImageView[2]")
    private MobileElement conteudoExtrato;

    @HowToUseLocators(androidAutomation = LocatorGroupStrategy.ALL_POSSIBLE, iOSXCUITAutomation = LocatorGroupStrategy.ALL_POSSIBLE)
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"EXIBIR FILTROS\"]")
    @AndroidFindBy(xpath = "//*[contains (upper-case(@text), 'EXIBIR FILTROS')]")
    private MobileElement botaoExibirFiltros;

    public SaldoExtratoTela(AppiumDriver driver) {
        super(driver);
    }

    /**
     * Retorna o localizador do elemento contendo o valor em reais procurado
     *
     * @return
     * @throws Exception
     */
    public String transferenciaValorLocator(String valor) throws Exception {
        String locator = null;

        /*
        Esta funcionalidade de formatação do número, de, por exemplo, "100000"
        para número 1000.00 e depois para string "1.000,00"
        pode ser adicionada ao framework.
         */
        Double valorNumerico = Double.parseDouble(valor) / 100;
        DecimalFormat df = new DecimalFormat("###,###.00");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        valor = df.format(valorNumerico);

        if (getDriver() instanceof IOSDriver) {
            locator = "//XCUIElementTypeStaticText[contains(@name,'" + valor + "')]";
        } else {
            aguardarCarregamentoElemento(boxVisaoTransacoes); // para estabilidade
            locator = "//android.widget.TextView[contains(@text,'R$ " + valor + "')]";
        }

        return locator;
    }

    /**
     * Retorna o elemento contendo o valor em reais procurado
     *
     * @return
     * @throws Exception
     */
    public MobileElement transferenciaValor(String valor) throws Exception {
        MobileElement elementoValorTransferencia = null;
        By locator = By.xpath(transferenciaValorLocator(valor));

        /*
        Este método simplemesmente retornaria um elemento, mas
        incluimos aqui a rolagem de tela para que isto seja
        possível.
         */
        int tentativas = 0;
        while (elementoValorTransferencia == null && tentativas < 5) {
            try {
                tentativas++;
                elementoValorTransferencia = retornarElemento(locator, "");
            } catch (Exception | AssertionError error) {
                rolarTela(0.9, 0.7);
            }

        }

        return elementoValorTransferencia;
    }

    /**
     * Retorna o elemento contendo o valor em reais procurado no Android
     *
     * @return
     * @throws Exception
     */
    public SaldoExtratoTela tocarTransferenciaValorAndroid(String valor) throws Exception {
        MobileElement elementoValorTransferencia = null;
        String locator = transferenciaValorLocator(valor);

        int tentativas = 0;
        while (tentativas < 5) {
            try {
                tentativas++;
                tocarElementoOculto(locator, "Não foi possível encontrar Valor da Transferência");
                break;
            } catch (Exception | AssertionError error) {
                rolarTela(0.9, 0.7);
            }
        }

        return this;
    }

    /**
     * Retorna o elemento contendo o valor em reais procurado, do tipo Transferência e na data esperada
     *
     * @return
     * @throws Exception
     */
    public MobileElement faixaValidacaoTransferenciaDataValor(String data, String valor) throws Exception {
        MobileElement elementoDataTransferenciaValor = null;
        Double valorNumerico = Double.parseDouble(valor) / 100; // ex. "2154" -> 21.54
        DecimalFormat df = new DecimalFormat("###,###.00");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        valor = df.format(valorNumerico); // "21,54"

        String locatorXpath = "//android.widget.TextView[@text='TRANSFERÊNCIA']/../../../..//android.widget.TextView[@text='" + data + "']";
        if (ios) {
            By locator = By.xpath(locatorXpath);
            elementoDataTransferenciaValor = retornarElemento(locator, "Não foi possível localizar a transferência com o valor R$ " + valor);
        } else {
            Assert.assertTrue("Não foi possível localizar a transferência com o valor R$ " + valor, verificarPresencaElementoOculto(locatorXpath));
        }
        rolarTela(0.9, 0.7);

        return elementoDataTransferenciaValor;
    }

    /**
     * Tocar item de transferência selecionado pelo valor
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar transferência")
    public SaldoExtratoTela tocarUltimaTransferenciaAgendada() throws Exception {
        salvarEvidencia("Selecionar transferência com o valor " + retornaValorTransferencia());
        if (ios) {
            MobileElement transferenciaValor = transferenciaValor(retornaValorTransferencia());
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(transferenciaValor, "Erro ao rolar até o valor " + retornaValorTransferencia());
            tocarElemento(transferenciaValor, "Não foi possível tocar na transferência de valor " + retornaValorTransferencia());
        } else {
            tocarTransferenciaValorAndroid(retornaValorTransferencia());
        }
        salvarEvidencia("Valor da transferência é mostrado na tela");
        return this;
    }

    /**
     * Validar que é transferência no valor especificado e a data
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar a transferência com data e valores procurados")
    public SaldoExtratoTela validarTipoTransferenciaDataValor() throws Exception {
        String dataEsperada = retornaDia() + "/" + retornaMes() + "/" + retornaAno();   // ex. 06/04/2021
        if (ios) {
            MobileElement tipoTransferenciaDataValor = (transferenciaValor(retornaValorTransferencia()));
            validarCondicaoBooleana(tipoTransferenciaDataValor != null, MetodoComparacaoBooleano.VERDADEIRO,
                    "Não foi possível validar a transferência com data " + dataEsperada + " e valor " + retornaValorTransferencia());
            aguardarCarregamentoElemento(tipoTransferenciaDataValor);
        } else {
            faixaValidacaoTransferenciaDataValor(dataEsperada, retornaValorTransferencia());
        }
        salvarEvidencia("Validação do tipo de transação e data com o valor " + retornaValorTransferencia());
        return this;
    }

    /**
     * Validar a presença do botão Editar na faixa de detalhes da transferência selecionada
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botão \"Editar\"")
    public SaldoExtratoTela validarBotaoEditarVisivel() {
        String mensagem = "Não foi possível encontrar Botão Editar";
        if (ios) {
            Assert.assertTrue(mensagem, aguardarCarregamentoElemento(botaoEditar));
        } else {
            Assert.assertTrue(mensagem, verificarPresencaElementoOculto("//*[@resource-id='br.com.bradesco.next:id/iv_gv_edit']"));
        }
        salvarEvidencia("Validação da presença do botão \"Editar\"");
        return this;
    }

    /**
     * Tocar botão Editar na faixa de detalhes da transação visível
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar botão \"Editar\"")
    public SaldoExtratoTela tocarBotaoEditar() throws Exception {
        if (getDriver() instanceof AndroidDriver) {
            aguardarCarregamentoElemento(botaoEditar);
            salvarEvidencia("Tocar botão 'Editar");
            String mensagem = "Não foi possível tocar no botão 'Editar'";
            if (ios){
                tocarElemento(botaoEditar, mensagem);
            }else {
                tocarElementoOculto("//*[@resource-id='br.com.bradesco.next:id/iv_gv_edit']", mensagem);
            }
        } else {
            aguardarCarregamentoElemento(expandirDetalhes);
            salvarEvidencia("Tocar botão 'Editar");
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(finalDoCardTranferencia, "Não foi possível encontar limite do card de transação");
            MobileElement cardTransacao = (MobileElement)this.retornaElemento(cardTransferencia);
            int y = (int) (cardTransacao.getRect().y + cardTransacao.getRect().height * 0.85);
            this.tocarCoordenada(retornaDimensaoTela().width / 2, y);
        }
        return this;
    }

    /**
     * Validar a presença do botão Deletar na faixa de detalhes da transferência selecionada
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença do botão \"Deletar\"")
    public SaldoExtratoTela validarBotaoDeletarVisivel() {
        String mensagem = "Não foi possível encontrar Botão Deletar";
        if (ios) {
            Assert.assertTrue(mensagem, aguardarCarregamentoElemento(botaoDeletar));
        } else {
            Assert.assertTrue(mensagem, verificarPresencaElementoOculto("//*[@resource-id='br.com.bradesco.next:id/iv_gv_remove']"));
        }
        salvarEvidencia("Validação da presença do botão \"Deletar\"");
        return this;
    }

    /**
     * Clicar em 'Todas Movimentações'
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar Todas as Movimentações")
    public SaldoExtratoTela tocarBotaoTodasMovimentacoes() throws Exception {
        aguardarCarregamentoElemento(botaoTodasMovimentacoes);
        salvarEvidencia("Clicar botão 'Todas Movimentações");
        tocarElemento(botaoTodasMovimentacoes, "Não foi possível selecionar 'Todas Movimentações'");
        return this;
    }

    /**
     * Retorna elemento da útima transação da tela
     *
     * @return Mobile Element
     * @throws Exception
     */
    protected MobileElement retornarElementoUltimaTransacao(String classe, String texto) throws Exception {
        try {
            List<MobileElement> todosElementos = retornarLista(new By.ByClassName(classe), "Transação não encontrada");
            List<MobileElement> elementosTexto = new ArrayList<MobileElement>();
            for (MobileElement element : todosElementos) {
                if (element.getText().contains(texto)) {
                    elementosTexto.add(element);
                }
            }
            transacaoRecarga = elementosTexto.get(elementosTexto.size() - 1);
            return this.transacaoRecarga;
        } catch (Exception var) {
            throw new NextException("Transação não encontrada", var);
        }
    }

    /**
     * Retorna elemento da útima transação da tela
     *
     * @return Mobile Element
     * @throws Exception
     */
    //TODO Ajustar metodo pois a validacao esta fraca, nao se pode garantir
    // que estamos realmente vendo a transacao correta, também o metodo nao esta funcionando (android)
    protected MobileElement retornarElementoUltimaTransacao(String xpath, String texto1, String texto2) throws Exception {
        List<MobileElement> todosElementos = retornarLista(new By.ByXPath(xpath + "[contains(@name,\"" + texto1 + "\") or contains(@name,\"" + texto2 + "\")]"), "Transação não encontrada");
        transacaoRecarga = todosElementos.get(todosElementos.size() - 1);
        //transacaoRecarga = retornarElemento(new By.ByXPath(xpath+"[contains(@name,\""+texto1+"\") or contains(@name,\""+texto2+"\")][-1]"),"Transação não encontrada");
        return this.transacaoRecarga;
    }

    /**
     * Expandir transação 'Recarga de Celular'
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar Transição de 'Recarga de Celular'")
    public SaldoExtratoTela tocarBotaoTransacaoRecarga() throws Exception {
        MobileElement ultimoElemento;
        if (getDriver() instanceof IOSDriver) {
            ultimoElemento = retornarElementoUltimaTransacao("XCUIElementTypeStaticText", "PAGUE FACIL BRADESCO");
        } else {
            ultimoElemento = retornarElementoUltimaTransacao("br.com.bradesco.next:id/tv_name", "PAGUE FACIL BRADESCO");
        }
        ultimoElemento.click();
        OperadorEvidencia.logarPasso("Transação Recarga de Celular expandida !");
        return this;
    }

    /**
     * Validar Recarga realizada pela conta corrente ou pela poupanca
     *
     * @throws Exception
     */
    @Step("Validar Recarga realizada pela Poupanca ou pela Conta Corrente")
    public void validarRecarga(FormaPagamento formaPagamento) throws Exception {

        List<MobileElement> transacoes = new ArrayList<MobileElement>();

        if (getDriver() instanceof IOSDriver) {
            aguardarCarregamentoElemento(marcadorDiaHoje);
            transacoes = retornarLista(new By.ByXPath("//XCUIElementTypeCell"), "NÃO FORAM ENCONTRADAS TRANSACOES");
            //VERIFICAR COMO TIRAR A SEGUNDA LINHA DO VALOR DA RECARGA
            //compararElementoTexto(transacoes.get(transacoes.size()-1).findElement(By.xpath("//XCUIElementTypeStaticText[2]")), valorRecarga.get().replace("LINHA1", "").replace("VALIDADE10DIAS", ""));
            //Assert.assertTrue(valorRecarga.get().contains(transacoes.get(transacoes.size()-1).findElement(By.xpath("//XCUIElementTypeStaticText[2]")).getText()));
        } else {
            //REALIZAR O MAPEAMENTO PARA ANDROID.
            //String valorUltimaTransacao = transacoes.get(transacoes.size()-1).findElement(By.xpath("//XCUIElementTypeStaticText[2]")).getText();
            //retorno do valorRecarga.get "R$10,00\nLINHA1"
            //transacoes = retornarLista(new By.ByXPath("android.view.ViewGroup[2]"), "NÃO FORAM ENCONTRADAS TRANSACOES");
            //compararElementoTexto(transacoes.get(transacoes.size()-1).findElement(new By.ById("br.com.bradesco.next:id/tv_value[2]")), valorRecarga.get().replace("LINHA1", ""));
        }
        if (formaPagamento == FormaPagamento.CONTA_CORRENTE) {
            salvarEvidencia("A recarga foi realizada pela conta corrente");
        } else {
            salvarEvidencia("A recarga foi realizada pela poupanca");
        }
    }

    /**
     * Selecionar Poupança
     * co
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar Poupança")
    public SaldoExtratoTela tocarBotaoPoupanca() throws Exception {
        aguardarCarregamentoElemento(mensagemSemMovimentacoes);
        String mensagem = "Não foi possível selecionar 'Poupança'";
        if (getDriver() instanceof IOSDriver) {
            tocarElemento(botaoPoupanca, mensagem);
        } else {
            tocarElementoOculto("(//android.widget.HorizontalScrollView)[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]", mensagem);
        }
        salvarEvidencia("Clicar botão 'Poupança");
        return this;
    }

    /**
     * Selecionar Conta Corrente
     * co
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar Conta Corrente")
    public SaldoExtratoTela tocarBotaoContaCorrente() throws Exception {
        if (aguardarCarregamentoElemento(botaoContaCorrente)) {
            tocarElemento(botaoContaCorrente, "Não foi possível selecionar 'Conta-Corrente'");
        } else {
            tocarCoordenadaProporcional(25, 17);
        }
        salvarEvidencia("Clicar botão 'Conta Corrente'");
        return this;
    }

    /**
     * Selecionar icone "Futuras"
     *
     * @return
     * @throws Exception
     */
    @Step("Selecionar Transações Futuras")
    public SaldoExtratoTela tocarIconeTransacoesFuturas() throws Exception {
        String mensagem = "Não foi possível selecionar 'Futuras'";
        if (ios) {
            aguardarCarregamentoElemento(iconeFuturos);
            tocarElemento(iconeFuturos, mensagem);
        } else {
            tocarElementoOculto("//android.widget.TextView[contains(@text,\"FUTUROS\")]", mensagem);
        }
        salvarEvidencia("Tocar icone 'Futuro'");
        return this;
    }

    /**
     * Expandir transação em 'Saldo e Extrato'
     *
     * @return
     * @throws Exception
     */
    @Step("Expandir transação")
    public SaldoExtratoTela expandirTransacao() throws Exception {
        salvarEvidencia("Expandir Transação");
        try {
            if (getDriver() instanceof IOSDriver) {
                tocarElemento(botaoExpandir, "Não foi possivel expandir transação");
            } else {
                getDriver().findElement(By.id("br.com.bradesco.next:id/tv_name")).click();
            }
        } catch (WebDriverException e) {
            e.getMessage();
        }
        return this;
    }

    /**
     * Tocar botão "Deletar Agendamento"
     *
     * @return SaldoExtratoTela
     * @throws Exception
     */
    @Step("Tocar botão 'DeletarAgendamento'")
    public SaldoExtratoTela tocarBotaoDeletarAgendamento() throws Exception {
        rolarTelaAteFinal(1);
        salvarEvidencia("Tocar no botão 'Deletar Agendamento'");
        if (ios) {
            tocarCoordenadaProporcional(botaoDeletarAgendamento, 50, 50);
        } else {
            tocarElementoOculto("//*[@resource-id='br.com.bradesco.next:id/iv_gv_remove']", "Não foi possível tocar no botão 'Deletar Agendamento'");
        }
        return this;
    }

    /**
     * Tocar icone "(v)" em "CANCELAR AGENDAMENTO"
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar ícone \"Confirmar\"")
    public SaldoExtratoTela tocarIconeConfirmar() throws Exception {
        aguardarCarregamentoElemento(iconeConfirmar);
        tocarElemento(iconeConfirmar, "Não foi possível tocar ícone '(v)'");
        salvarEvidencia("Tocar ícone '(v)'");
        return this;
    }

    /**
     * Expandir transação Futura desejada em 'Saldo e Extrato'
     *
     * @return
     * @throws Exception
     */
    @Step("Expandir transação")
    public SaldoExtratoTela expandirTransacaoFuturos(String transacao) throws Exception {
        transacaoValidar.set(transacao);
        if (getDriver() instanceof AndroidDriver) {
            MobileElement janelaTransacao = getDriver().findElementByXPath("//android.widget.TextView[contains(@text,\"" + transacao + "\")]/parent::android.view.ViewGroup");
            aguardarCarregamentoElemento(janelaTransacao);
            tocarElemento(janelaTransacao, "Não foi possível expandir trasação");
            while (!aguardarCarregamentoElemento(botaoDeletar)) {
                rolaTelaBaixo();
            }
        } else {

        }
        salvarEvidencia("Expandir Transação");
        return this;
    }

    /**
     * Validar Transação Futura foi Excluída
     *
     * @return
     * @throws Exception
     */
    @Step("Validar Transação Excluída")
    public SaldoExtratoTela validarTransacaoFuturosExcluida() throws Exception {
        if (getDriver() instanceof AndroidDriver) {
            if (aguardarCarregamentoElemento(getDriver().findElementByXPath("//android.widget.TextView[contains(@text,\"" + transacaoValidar.get() + "\")]/parent::android.view.ViewGroup"))) {
                throw new Exception("Transação não Excluída");
            }
        } else {

        }
        salvarEvidencia("Validar Exclusão Transação");
        return this;
    }

    /**
     * Expandir transação em 'Saldo e Extrato'
     *
     * @return
     * @throws Exception
     */
    @Step("Expandir transação")
    public SaldoExtratoTela expandirTransacaoSeta() throws Exception {
        tocarElemento(setaExpandirTransacao, "Não foi possivel expandir transação");
        salvarEvidencia("Transação Expandida");
        return this;
    }

    /**
     * Validar presença da tela 'Saldo e Extrato'
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença da tela 'Saldo e Extrato'")
    public SaldoExtratoTela validarPresencaTelaSaldoExtrato() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.SALDO_EXTRATO.toString(), Mensagem.SALDO_ATUAL.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Saldo Extrato' e label 'Saldo Atual' não estão presentes na tela!");
        salvarEvidencia("Validada presença da tela 'Saldo e Extrato'");
        return this;
    }

    /**
     * Validar dados da transação
     *
     * @param valor
     * @param categoria
     * @param tipo
     * @param data
     * @return
     * @throws Exception
     */
    @Step("Validar dados da transação")
    public SaldoExtratoTela validarDadosTransacao(String valor, CategoriaTransacao categoria, TipoTransacao tipo, String data) {
        if (valor.contains(",")) {
            valor.replace(",", "");
        }
        rolarTelaAteFinal();
        valor = Utilitarios.reformatarValorMonetario(valor);
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(valor), MetodoComparacaoBooleano.VERDADEIRO, String.format("O valor '%s' da transação não está presente na tela", valor));
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(categoria.toString()), MetodoComparacaoBooleano.VERDADEIRO, String.format("A categoria '%s' da transação não está presente na tela", categoria));
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(tipo.toString()), MetodoComparacaoBooleano.VERDADEIRO, String.format("O tipo '%s' da transação não está presente na tela", tipo));
        salvarEvidencia("Validados dados da transação");
        return this;
    }

    /**
     * Validar dados da transação
     *
     * @param valor
     * @return
     * @throws Exception
     */
    @Step("Validar dados da transação")
    public SaldoExtratoTela validarDadosTransacao(String valor, CategoriaTransacao categoria) throws Exception {
        String tituloTransacao = android ? (TipoTransacao.APLICACAO_EM_INVESTIMENTO.toString().toUpperCase()) : (TipoTransacao.APLICACAO_EM_INVESTIMENTO.toString());
        valor = Utilitarios.reformatarValorMonetario(valor);
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(valor), MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar o 'Valor' da transação'");
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(categoria.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Erro ao validar a 'Categoria' da transação");
        rolarTelaAteFinal();
        salvarEvidencia("Validados dados da transação");
        return this;
    }

    /**
     * Expandir transação pelo valor em 'Saldo e Extrato'
     *
     * @param valor Valor a ser expandido
     * @return SaldoExtratoTela
     * @throws Exception
     */
    @Step("Expandir transação pelo valor")
    public SaldoExtratoTela expandirTransacaoPeloValor(String valor) throws Exception {
        valor = Utilitarios.reformatarValorMonetario(valor);
        String mensagem = "Não foi possível encontrar a transação com o valor: " + valor;
        if (ios) {
            By locator = By.xpath("//*[contains(@name,'"+valor+"')]");
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(locator, mensagem);
            tocarElemento(locator, "Não foi possivel expandir a transação");
        }
        else {
            tocarElementoOculto("//android.widget.TextView[contains(@text,'"+ valor+"')]", mensagem);
        }
        salvarEvidencia("Transação Expandida");
        return this;
    }

    /**
     * Tocar filtro '7 Dias'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar filtro '7 Dias'")
    public SaldoExtratoTela tocarFiltroSeteDias() throws Exception {
        salvarEvidencia("Tocar filtro  '7 Dias'");
        String mensagem = "Não foi possível Tocar no filtro de '7 Dias'";
        if (ios){
            tocarElemento(botaoFiltroSeteDias, mensagem);
        }else {
            tocarElementoOculto("(//android.widget.HorizontalScrollView)[3]/android.widget.LinearLayout/android.widget.LinearLayout[2]", mensagem);
        }
        return this;
    }

    /**
     * Tocar filtro '15 Dias'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar filtro '15 Dias'")
    public SaldoExtratoTela tocarFiltroQuinzeDias() throws Exception {
        salvarEvidencia("Tocar filtro  '15 Dias'");
        String mensagem = "Não foi possível Tocar no filtro de '15 Dias'";
        if (ios){
            tocarElemento(botaoFiltroQuinzeDias, mensagem);
        }else {
            tocarElementoOculto("(//android.widget.HorizontalScrollView)[3]/android.widget.LinearLayout/android.widget.LinearLayout[2]", mensagem);
        }
        return this;
    }

    /**
     * Tocar filtro '30 Dias'
     *
     * @return
     * @throws Exception
     */
    @Step("Tocar filtro '30 Dias'")
    public SaldoExtratoTela tocarFiltroTrintaDias() throws Exception {
        salvarEvidencia("Tocar filtro  '30 Dias'");
        String mensagem = "Não foi possível Tocar no filtro de '30 Dias'";
        if (ios){
            tocarElemento(botaoFiltroTrintaDias, mensagem);
        }else {
            tocarElementoOculto("(//android.widget.HorizontalScrollView)[3]/android.widget.LinearLayout/android.widget.LinearLayout[3]", mensagem);
        }
        return this;
    }

    /**
     * Validar presença de Movimentação em Poupança
     *
     * @return
     * @throws Exception
     */
    @Step("Validar presença de Movimentação em Poupança")
    public SaldoExtratoTela validarPresencaDeMovimentacao() throws Exception {
        validarCondicaoBooleana(aguardarCarregamentoElemento(movimentacaoPoupanca), MetodoComparacaoBooleano.VERDADEIRO, "Validada presença de Movimentação em Poupança");
        salvarEvidencia("Validado presença de Movimentação em Poupança");
        return this;
    }

    /**
     * Validar exibição da tela de 'Saldo e Extrato'
     * @return
     */
    @Step("Validar exibição da tela de 'Saldo e Extrato'")
    public SaldoExtratoTela validarTelaSaldoExtrato(){
        verificarPresencaElemento(tituloSaldoExtrato);
        salvarEvidencia("Validou exibição da tela de 'Saldo e Extrato'");
        return this;
    }

    /**
     * Tocar no botão header 'Voltar' (=)
     * @return
     * @throws NextException
     */
    @Step("Tocar no botão header 'Voltar' (=)")
    public SaldoExtratoTela tocarBotaoHeaderVoltar() throws NextException {
        salvarEvidencia("Tocar no botão header 'Voltar' (=)");
        tocarElemento(botaoHeaderVoltar,"Erro ao tocar no botão header 'Voltar' (=)");
        return this;
    }

    /**
     * Tocar na Aba 'Todas'
     * @return
     * @throws NextException
     */
    @Step("Tocar na Aba 'Todas'")
    public SaldoExtratoTela tocarAbaTodas() throws NextException {
        aguardarCarregamentoElemento(abaTodas);
        salvarEvidencia("Tocar na Aba 'Todas'");
        String mensagem = "Erro ao tocar no botão header 'Todas'";
        if (ios) {
            tocarElemento(abaTodas, mensagem);
        } else {
            tocarElementoOculto("//*[contains(@text, \"TODAS\")]", mensagem);
        }
        return this;
    }

    /**
     * Tocar na Aba 'Entrada'
     * @return
     * @throws NextException
     */
    @Step("Tocar na Aba 'Entrada'")
    public SaldoExtratoTela tocarAbaEntrada() throws NextException {
        salvarEvidencia("Tocar na Aba 'Entrada'");
        String mensagem = "Erro ao tocar na Aba 'Entrada'";
        if (ios){
            tocarElemento(abaEntrada, mensagem);
        }else {
            String xpath = "//*[contains (translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz'), 'entrada')]";
            tocarElementoOculto(xpath, mensagem);
            esconderExibirFiltrosSeExistirAndroid();
        }
        return this;
    }

    /**
     * Tocar na Aba 'Saida'
     * @return
     * @throws NextException
     */
    @Step("Tocar na Aba 'Saida'")
    public SaldoExtratoTela tocarAbaSaida() throws NextException {
        salvarEvidencia("Tocar na Aba 'Saida'");
        String mensagem = "Erro ao tocar na Aba 'Saida'";
        if (ios){
            tocarElemento(abaSaida, mensagem);
        }else {
            String xpath = "//*[@text = 'SAÍDA']";
            tocarElementoOculto(xpath, mensagem);
            esconderExibirFiltrosSeExistirAndroid();
        }
        return this;
    }

    /**
     * Esconder exibir filtros se existir no Android
     *
     * @return
     * @throws NextException
     */
    private void esconderExibirFiltrosSeExistirAndroid() throws NextException {
        if(aguardarPaginaConterTodosTextos("EXIBIR FILTROS")){
            String exibirFiltros = "//*[contains (translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz'), 'exibir filtros')]";
            tocarElementoOculto(exibirFiltros, "Erro ao tocar 'Exibir Filtros");
        }
    }

    /**
     * Tocar na Aba 'Futuros'
     * @return
     * @throws NextException
     */
    @Step("Tocar na Aba 'Futuros'")
    public SaldoExtratoTela tocarAbaFuturos() throws NextException {
        salvarEvidencia("Tocar na Aba 'Futuros'");
        String mensagem = "Erro ao tocar na Aba 'Futuros'";
        if (ios){
            tocarElemento(abaFuturos, mensagem);
        }else {
            String xpath = "//*[contains (translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz'), 'futuros')]";
            tocarElementoOculto(xpath, mensagem);
        }
        return this;
    }

    /**
     * Tocar na seta 'Expandir Detalhes (v)' e encontrar Exibir Filtros
     * @return
     * @throws NextException
     */
    @Step("Tocar na seta 'Expandir Detalhes (v)'")
    public SaldoExtratoTela tocarSetaExpandirDetalhesExibirFiltros() throws Exception {
        salvarEvidencia("Tocar na seta 'Expandir Detalhes (v)'");
        String mensagem = "Erro ao tocar na Aba 'Expandir Detalhes (v)'";
        if (android) {
            tocarElementoOculto("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[1]", mensagem);
            rolarTelaAteFinal();
        }else {
            tocarElemento(expandirDetalhes, mensagem);
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoExibirFiltros,"Erro ao rolar até botão 'Exibir Filtros'");
        }
        salvarEvidencia("Expandiu os detalhes do Extrato");
        return this;
    }

    /**
     * Tocar na seta 'Expandir Detalhes (v)'
     * @return
     * @throws NextException
     */
    @Step("Tocar na seta 'Expandir Detalhes (v)'")
    public SaldoExtratoTela tocarSetaExpandirDetalhes() throws Exception {
        validarPresencaTelaSaldoExtrato();
        salvarEvidencia("Tocar na seta 'Expandir Detalhes (v)'");
        tocarElemento(expandirDetalhes,"Erro ao tocar na Aba 'Expandir Detalhes (v)'");
        return this;
    }

    /**
     * Tocar botão 'Exibir Filtros'
     * @return
     * @throws NextException
     */
    @Step("Tocar botão 'Exibir Filtros")
    public SaldoExtratoTela tocarBotaoExibirFiltros() throws NextException {

        if(aguardarPaginaConterTodosTextos("EXIBIR FILTROS")){
            salvarEvidencia("Tocar botão 'Exibir Filtros'");
            String mensagem = "Erro ao tocar botão 'Exibir Filtros'";
            if (ios) {
                tocarElemento(botaoExibirFiltros, mensagem);
            } else {
                String xpath = "//*[contains (translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ','abcdefghijklmnopqrstuvxxyz'), 'exibir filtros')]";
                tocarElementoOculto(xpath, mensagem);
            }
        }
        return this;
    }


    /**
     * Validar conteúdo do extrato
     * @return
     */
    @Step("Validar conteúdo do extrato")
    public SaldoExtratoTela validarExibicaoConteudoExtrato(){
        String mensagem = "Erro ao validar o Conteúdo do Extrato";
        if (ios){
            validarCondicaoBooleana(aguardarCarregamentoElemento(conteudoExtrato), MetodoComparacaoBooleano.VERDADEIRO, mensagem);
        }else {
            String xpath = "//*[contains (translate(@text, 'ABCDEFGHIJKLMNOPQRSTUVWXYZÍ','abcdefghijklmnopqrstuvxxyzí'), 'outros períodos')]";
            Assert.assertTrue(mensagem, verificarPresencaElementoOculto(xpath));
        }
        salvarEvidencia("Validou conteúdo do extrato");
        return this;
    }

    /**
     * Validar conteúdo do extrato
     * @return
     */
    @Step("Validar conteúdo do extrato")
    public SaldoExtratoTela validarExibicaoConteudoExtrato(String tituloExtrato, String valorExtrato) throws Exception {
        aguardarCarregamentoElemento(conteudoExtrato); // Estabilidade
        String locator;
        valorExtrato = Utilitarios.normalizaStringNumero(valorExtrato);
        valorExtrato = Utilitarios.reformatarValorMonetario(valorExtrato);
        if (ios) {
            locator = "//XCUIElementTypeStaticText[contains(@name,'" + tituloExtrato + "  " + valorExtrato + "')]";
        } else {
            locator = "//android.widget.TextView[contains(@text,'" + tituloExtrato.toUpperCase() + "')]/../android.widget.TextView[contains(@text,'" + valorExtrato + "')]";
        }
        elementoValorTransacao = By.xpath(locator);
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(elementoValorTransacao, "Não foi possível encontrar a transação com o valor: " + valorExtrato);
        salvarEvidencia("Validou conteúdo do extrato com o titulo: '" + tituloExtrato +  "' e valor: 'R$ " + valorExtrato + "'");
        return this;
    }

    /**
     *
     * @param tituloExtrato
     * @param valorExtrato
     * @return
     */
    @Step("Validar o extrato")
    public SaldoExtratoTela validarExtrato(String tituloExtrato, String valorExtrato){
        String valorExtratoFormatado = Utilitarios.reformatarValorMonetario(valorExtrato);
        Boolean extratoPresente = Boolean.logicalAnd(
                Strings.isNotNullAndNotEmpty(aguardarPaginaConterQualquerTexto(tituloExtrato)),
                Strings.isNotNullAndNotEmpty(aguardarPaginaConterQualquerTexto(valorExtratoFormatado)));
        validarCondicaoBooleana(extratoPresente,
                MetodoComparacaoBooleano.VERDADEIRO,
                "Erro ao validar na tela o extrato: [" + tituloExtrato + "," + valorExtratoFormatado + "]");
        salvarEvidencia("Validou na tela o extrato: [" + tituloExtrato + "," + valorExtratoFormatado + "]");

        return this;
    }

}

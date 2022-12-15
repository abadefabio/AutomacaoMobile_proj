package pagina.mobile.jornadas.investimentos.meus.investimentos;

import org.openqa.selenium.By;
import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacao;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.Utilitarios;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.investimentos.Segmento;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class MeusInvestimentosTela extends PaginaBase {

    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_processing_subtitle")
    @iOSXCUITFindBy(accessibility = "processingTitleLabelId")
    private MobileElement blocoEmProcessamento;

    @AndroidFindBy(id = "br.com.bradesco.next:id/ni_navigation")
    @iOSXCUITFindBy(accessibility = "Voltar")
    private MobileElement botaoVoltar;

    @iOSXCUITFindBy(xpath = "//*[contains(@name,'SALDO')]/following-sibling::XCUIElementTypeOther[last()]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nsi_balance")
    private MobileElement botaoVerOcultarSaldoInvestido;

    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[contains(@name,'R$')])[1]")
    @AndroidFindBy(id = "br.com.bradesco.next:id/nl_my_patrimony")
    private MobileElement campoSaldoInvestido;

    public MeusInvestimentosTela(AppiumDriver driver) {

        super(driver);
    }

    /**
     * Selecionar segmento
     *
     * @param segmento Segmento a ser selecionado (CDB, Fundos, Poupan�a ou �gora)
     * @return MeusInvestimentosTela
     * @throws Exception
     */
    @Step("Selecionar segmento")
    public MeusInvestimentosTela selecionarSegmento(Segmento segmento) throws Exception {
        By elemento;
        if(android) {
            elemento = By.xpath("//*[@text='Por produtos']/following::*[@text='"+segmento+"']");
        } else {
            elemento = By.xpath("//*[@name='Por produtos']/../following::*[@name='"+segmento+"']");
        }
        esperarCarregando();
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(elemento, "N�o foi poss�vel encontrar o segmento " + segmento);
        salvarEvidencia("Selecionar o segmento " + segmento);
        tocarElemento(elemento, "N�o foi poss�vel selecionar o segmento " + segmento);
        return this;
    }

    /**
     * Tocar bot�o 'Investir' do produto
     *
     * @param produto Produto a ser selecionado (CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @return MeusInvestimentosTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Investir' do produto")
    public MeusInvestimentosTela tocarBotaoInvestir(String produto) throws Exception {
        By elemento;
        if(android) {
            elemento = By.xpath("//*[contains(@text,'"+produto+"')]/following-sibling::*[@resource-id='br.com.bradesco.next:id/nb_invest']");
        } else {
            elemento = By.xpath("//*[contains(@name,'"+produto+"')]/preceding-sibling::*[@name='INVESTIR' or @name='Investir']");
        }
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(elemento, "N�o foi poss�vel encontrar o bot�o 'Investir' do produto " + produto);
        salvarEvidencia("Tocar no bot�o 'Investir' do produto " + produto);
        tocarElemento(elemento, "N�o foi poss�vel tocar no bot�o 'Investir' do produto " + produto);
        return this;
    }

    /**
     * Tocar bot�o 'Resgatar' do produto
     *
     * @param produto Produto a ser selecionado (CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @return MeusInvestimentosTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Resgatar' do produto")
    public MeusInvestimentosTela tocarBotaoResgatar(String produto) throws Exception {
        By elemento;
        if(android) {
            elemento = By.xpath("//*[contains(@text,'"+produto+"')]/following-sibling::*[@resource-id='br.com.bradesco.next:id/nb_retrivial']");
        } else {
            elemento = By.xpath("//*[contains(@name,'"+produto+"')]/preceding-sibling::*[@name='RESGATAR' or @name='Resgatar']");
        }
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(elemento, "N�o foi poss�vel encontrar o bot�o 'Resgatar' do produto " + produto);
        salvarEvidencia("Tocar no bot�o 'Resgatar' do produto " + produto);
        tocarElemento(elemento, "N�o foi poss�vel tocar no bot�o 'Resgatar' do produto " + produto);
        return this;
    }

    /**
     * Tocar bot�o 'Ver Mais' do produto
     *
     * @param produto Produto a ser selecionado (CDB, next Ibov, next Aloca��o Arrojada, etc)
     * @return MeusInvestimentosTela
     * @throws Exception
     */
    @Step("Tocar no bot�o 'Ver Mais' do produto")
    public MeusInvestimentosTela tocarBotaoVerMais(String produto) throws Exception {
        By elemento;
        if(android) {
            elemento = By.xpath("//*[contains(@text,'"+produto+"')]/following-sibling::*[@resource-id='br.com.bradesco.next:id/nb_see_more']");
        } else {
            elemento = By.xpath("//*[contains(@name,'"+produto+"')]/preceding-sibling::*[@name='VER MAIS' or @name='Ver mais']");
        }
        esperarCarregando();
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(elemento, "N�o foi poss�vel encontrar o bot�o 'Ver Mais' do produto " + produto);
        salvarEvidencia("Tocar no bot�o 'Ver Mais' do produto " + produto);
        tocarElemento(elemento, "N�o foi poss�vel tocar no bot�o 'Ver Mais' do produto " + produto);
        return this;
    }

    /**
     * Tocar no bloco 'Em processamento'
     *
     * @return MeusInvestimentosTela
     * @throws Exception
     */
    @Step("Tocar no bloco 'Em processamento'")
    public MeusInvestimentosTela tocarBlocoEmProcessamento() throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(blocoEmProcessamento, "N�o foi poss�vel encontrar o bloco Em Processamento");
        salvarEvidencia("Tocar no bloco 'Em processamento'");
        tocarElemento(blocoEmProcessamento, "N�o foi poss�vel tocar no bloco 'Em Processamento'");
        return this;
    }

    /**
     * Tocar no bot�o 'Voltar' (<)
     *
     * @return MeusInvestimentosTela
     * @throws NextException
     */
    @Step("Tocar no bot�o voltar (<)")
    public MeusInvestimentosTela tocarBotaoVoltar() throws NextException {
        aguardarElementoHabilitado(botaoVoltar);
        salvarEvidencia("Tocar no bot�o 'Voltar' (<)");
        tocarElemento(botaoVoltar, "N�o foi poss�vel tocar no bot�o 'Voltar' (<)");
        return this;
    }

    /**
     * Extrair a quantidade de solicita��es em aberto no bloco "Em processamento"
     *
     * @param solicitacoes Quantidade de solicita��es que ser�o atribu�das no par�metro
     * @return MeusInvestimentosTela
     * @throws Exception
     */
    @Step("Extrair solicita��es em aberto")
    public MeusInvestimentosTela extrairSolicitacoesEmAberto(ThreadLocal <Integer> solicitacoes) throws Exception {
        aguardarElementoHabilitado(botaoVerOcultarSaldoInvestido);
        OperadorEvidencia.logarPasso("Iniciada a verifica��o da presen�a do bloco 'Em Processamento'");
        rolarTelaAteFinal(2);
        if (verificarPresencaElemento(blocoEmProcessamento)) {
            OperadorEvidencia.logarPasso("Iniciada a extra��o da quantidade de solicita��es em aberto");
            String texto = retornarTexto(blocoEmProcessamento, "N�o foi poss�vel extrair o texto do bloco 'Em processamento'");
            String [] textEmProcessamento = texto.split(" ");
            texto = textEmProcessamento[2].replace("(", "").replace(")", "");
            //Quando tem 1 solicita��o em processamento, o seu mapeamento fica como "uma" em texto e n�o como "1" num�rico
            //Foi inclu�do uma valida��o para setar o valor 1 num�rico quando retornado o texto "uma"
            if (texto.contains("uma")) {
                texto = "1";
            }
            solicitacoes.set(Integer.parseInt(texto));
            salvarEvidencia("Extra�da " + solicitacoes.get() + " solicita��es em aberto");
        }
        else {
            solicitacoes.set(0);
            salvarEvidencia("N�o foram encontradas solicita��es em aberto");
        }
        rolarTelaAteInicio(2);
        return this;
    }

    /**
     * Validar n�mero de solicita��es em aberto no bloco 'Em processamento'
     *
     * @param solicitacoesAbertas Quantidade de solicita��es em aberto
     * @return MeusInvestimentosTela
     * @throws Exception
     */
    @Step("Validar n�mero de solicita��es em aberto no bloco 'Em processamento'")
    public MeusInvestimentosTela validarSolicitacoesEmAberto(ThreadLocal<Integer> solicitacoesAbertas) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(blocoEmProcessamento, "N�o foi poss�vel encontrar o bloco 'Em processamento'");
        if (ios) {
            if (solicitacoesAbertas.get() == 1) {
                compararElementoTexto(blocoEmProcessamento, "Em processamento uma solicita��o", MetodoComparacao.CONTEM);
            } else {
                compararElementoTexto(blocoEmProcessamento, solicitacoesAbertas.get() + "solicita", MetodoComparacao.CONTEM);
            }
        } else {
            compararElementoTexto(blocoEmProcessamento, "EMPROCESSAMENTO" + solicitacoesAbertas.get(), MetodoComparacao.CONTEM);
        }
        salvarEvidencia("Validado o n�mero de " +solicitacoesAbertas.get()+ " solicita��es em aberto no bloco 'Em processamento'");
        return this;
    }

    /**
     * Validar a aus�ncia do bloco 'Em processamento'
     *
     * @return MeusInvestimentosTela
     */
    @Step("Validar aus�ncia do bloco 'Em processamento'")
    public MeusInvestimentosTela validarAusenciaBlocoEmProcessamento() {
        aguardarCarregamentoElemento(botaoVerOcultarSaldoInvestido);
        OperadorEvidencia.logarPasso("Iniciada a valida��o da aus�ncia do bloco 'Em processamento'");
        rolarTelaAteFinal(2);
        validarCondicaoBooleana(verificarPresencaElemento(blocoEmProcessamento), MetodoComparacaoBooleano.FALSO, "N�o foi poss�vel validar a aus�ncia do bloco 'Em processamento'");
        salvarEvidencia("Validada a aus�ncia do bloco 'Em processamento'");
        return this;
    }

    /**
     * Tocar no bot�o 'Ver/Ocultar' saldo investido
     *
     * @return MeusInvestimentosTela
     * @throws NextException
     */
    @Step("Tocar no bot�o 'Ver/Ocultar' saldo investido")
    public MeusInvestimentosTela tocarBotaoVerOcultarSaldoInvestido() throws NextException {
        tocarElemento(botaoVerOcultarSaldoInvestido, "N�o foi poss�vel tocar no bot�o 'Ver/Ocultar' saldo investido");
        salvarEvidencia("Tocar no bot�o 'Ver/Ocultar' saldo investido");
        return this;
    }

    /**
     * Extrair saldo investido
     *
     * @param saldoInvestido Par�metro a ser preenchido com o valor do saldo investido
     * @return MeusInvestimentosTela
     * @throws Exception
     */
    @Step("Extrair saldo investido")
    public MeusInvestimentosTela extrairSaldoInvestido(ThreadLocal<String> saldoInvestido) throws Exception {
        aguardarElementoHabilitado(campoSaldoInvestido);
        saldoInvestido.set(Utilitarios.normalizaStringNumero(retornarTexto(campoSaldoInvestido,"N�o foi poss�vel retornar o texto do elemento saldo")));
        salvarEvidencia("Extra�do saldo investido");
        return this;
    }
}

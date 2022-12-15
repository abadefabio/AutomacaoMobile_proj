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
     * @param segmento Segmento a ser selecionado (CDB, Fundos, Poupança ou Ágora)
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
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(elemento, "Não foi possível encontrar o segmento " + segmento);
        salvarEvidencia("Selecionar o segmento " + segmento);
        tocarElemento(elemento, "Não foi possível selecionar o segmento " + segmento);
        return this;
    }

    /**
     * Tocar botão 'Investir' do produto
     *
     * @param produto Produto a ser selecionado (CDB, next Ibov, next Alocação Arrojada, etc)
     * @return MeusInvestimentosTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Investir' do produto")
    public MeusInvestimentosTela tocarBotaoInvestir(String produto) throws Exception {
        By elemento;
        if(android) {
            elemento = By.xpath("//*[contains(@text,'"+produto+"')]/following-sibling::*[@resource-id='br.com.bradesco.next:id/nb_invest']");
        } else {
            elemento = By.xpath("//*[contains(@name,'"+produto+"')]/preceding-sibling::*[@name='INVESTIR' or @name='Investir']");
        }
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(elemento, "Não foi possível encontrar o botão 'Investir' do produto " + produto);
        salvarEvidencia("Tocar no botão 'Investir' do produto " + produto);
        tocarElemento(elemento, "Não foi possível tocar no botão 'Investir' do produto " + produto);
        return this;
    }

    /**
     * Tocar botão 'Resgatar' do produto
     *
     * @param produto Produto a ser selecionado (CDB, next Ibov, next Alocação Arrojada, etc)
     * @return MeusInvestimentosTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Resgatar' do produto")
    public MeusInvestimentosTela tocarBotaoResgatar(String produto) throws Exception {
        By elemento;
        if(android) {
            elemento = By.xpath("//*[contains(@text,'"+produto+"')]/following-sibling::*[@resource-id='br.com.bradesco.next:id/nb_retrivial']");
        } else {
            elemento = By.xpath("//*[contains(@name,'"+produto+"')]/preceding-sibling::*[@name='RESGATAR' or @name='Resgatar']");
        }
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(elemento, "Não foi possível encontrar o botão 'Resgatar' do produto " + produto);
        salvarEvidencia("Tocar no botão 'Resgatar' do produto " + produto);
        tocarElemento(elemento, "Não foi possível tocar no botão 'Resgatar' do produto " + produto);
        return this;
    }

    /**
     * Tocar botão 'Ver Mais' do produto
     *
     * @param produto Produto a ser selecionado (CDB, next Ibov, next Alocação Arrojada, etc)
     * @return MeusInvestimentosTela
     * @throws Exception
     */
    @Step("Tocar no botão 'Ver Mais' do produto")
    public MeusInvestimentosTela tocarBotaoVerMais(String produto) throws Exception {
        By elemento;
        if(android) {
            elemento = By.xpath("//*[contains(@text,'"+produto+"')]/following-sibling::*[@resource-id='br.com.bradesco.next:id/nb_see_more']");
        } else {
            elemento = By.xpath("//*[contains(@name,'"+produto+"')]/preceding-sibling::*[@name='VER MAIS' or @name='Ver mais']");
        }
        esperarCarregando();
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(elemento, "Não foi possível encontrar o botão 'Ver Mais' do produto " + produto);
        salvarEvidencia("Tocar no botão 'Ver Mais' do produto " + produto);
        tocarElemento(elemento, "Não foi possível tocar no botão 'Ver Mais' do produto " + produto);
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
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(blocoEmProcessamento, "Não foi possível encontrar o bloco Em Processamento");
        salvarEvidencia("Tocar no bloco 'Em processamento'");
        tocarElemento(blocoEmProcessamento, "Não foi possível tocar no bloco 'Em Processamento'");
        return this;
    }

    /**
     * Tocar no botão 'Voltar' (<)
     *
     * @return MeusInvestimentosTela
     * @throws NextException
     */
    @Step("Tocar no botão voltar (<)")
    public MeusInvestimentosTela tocarBotaoVoltar() throws NextException {
        aguardarElementoHabilitado(botaoVoltar);
        salvarEvidencia("Tocar no botão 'Voltar' (<)");
        tocarElemento(botaoVoltar, "Não foi possível tocar no botão 'Voltar' (<)");
        return this;
    }

    /**
     * Extrair a quantidade de solicitações em aberto no bloco "Em processamento"
     *
     * @param solicitacoes Quantidade de solicitações que serão atribuídas no parâmetro
     * @return MeusInvestimentosTela
     * @throws Exception
     */
    @Step("Extrair solicitações em aberto")
    public MeusInvestimentosTela extrairSolicitacoesEmAberto(ThreadLocal <Integer> solicitacoes) throws Exception {
        aguardarElementoHabilitado(botaoVerOcultarSaldoInvestido);
        OperadorEvidencia.logarPasso("Iniciada a verificação da presença do bloco 'Em Processamento'");
        rolarTelaAteFinal(2);
        if (verificarPresencaElemento(blocoEmProcessamento)) {
            OperadorEvidencia.logarPasso("Iniciada a extração da quantidade de solicitações em aberto");
            String texto = retornarTexto(blocoEmProcessamento, "Não foi possível extrair o texto do bloco 'Em processamento'");
            String [] textEmProcessamento = texto.split(" ");
            texto = textEmProcessamento[2].replace("(", "").replace(")", "");
            //Quando tem 1 solicitação em processamento, o seu mapeamento fica como "uma" em texto e não como "1" numérico
            //Foi incluído uma validação para setar o valor 1 numérico quando retornado o texto "uma"
            if (texto.contains("uma")) {
                texto = "1";
            }
            solicitacoes.set(Integer.parseInt(texto));
            salvarEvidencia("Extraída " + solicitacoes.get() + " solicitações em aberto");
        }
        else {
            solicitacoes.set(0);
            salvarEvidencia("Não foram encontradas solicitações em aberto");
        }
        rolarTelaAteInicio(2);
        return this;
    }

    /**
     * Validar número de solicitações em aberto no bloco 'Em processamento'
     *
     * @param solicitacoesAbertas Quantidade de solicitações em aberto
     * @return MeusInvestimentosTela
     * @throws Exception
     */
    @Step("Validar número de solicitações em aberto no bloco 'Em processamento'")
    public MeusInvestimentosTela validarSolicitacoesEmAberto(ThreadLocal<Integer> solicitacoesAbertas) throws Exception {
        rolarTelaParaBaixoAosPoucosAteEncontrarElemento(blocoEmProcessamento, "Não foi possível encontrar o bloco 'Em processamento'");
        if (ios) {
            if (solicitacoesAbertas.get() == 1) {
                compararElementoTexto(blocoEmProcessamento, "Em processamento uma solicitação", MetodoComparacao.CONTEM);
            } else {
                compararElementoTexto(blocoEmProcessamento, solicitacoesAbertas.get() + "solicita", MetodoComparacao.CONTEM);
            }
        } else {
            compararElementoTexto(blocoEmProcessamento, "EMPROCESSAMENTO" + solicitacoesAbertas.get(), MetodoComparacao.CONTEM);
        }
        salvarEvidencia("Validado o número de " +solicitacoesAbertas.get()+ " solicitações em aberto no bloco 'Em processamento'");
        return this;
    }

    /**
     * Validar a ausência do bloco 'Em processamento'
     *
     * @return MeusInvestimentosTela
     */
    @Step("Validar ausência do bloco 'Em processamento'")
    public MeusInvestimentosTela validarAusenciaBlocoEmProcessamento() {
        aguardarCarregamentoElemento(botaoVerOcultarSaldoInvestido);
        OperadorEvidencia.logarPasso("Iniciada a validação da ausência do bloco 'Em processamento'");
        rolarTelaAteFinal(2);
        validarCondicaoBooleana(verificarPresencaElemento(blocoEmProcessamento), MetodoComparacaoBooleano.FALSO, "Não foi possível validar a ausência do bloco 'Em processamento'");
        salvarEvidencia("Validada a ausência do bloco 'Em processamento'");
        return this;
    }

    /**
     * Tocar no botão 'Ver/Ocultar' saldo investido
     *
     * @return MeusInvestimentosTela
     * @throws NextException
     */
    @Step("Tocar no botão 'Ver/Ocultar' saldo investido")
    public MeusInvestimentosTela tocarBotaoVerOcultarSaldoInvestido() throws NextException {
        tocarElemento(botaoVerOcultarSaldoInvestido, "Não foi possível tocar no botão 'Ver/Ocultar' saldo investido");
        salvarEvidencia("Tocar no botão 'Ver/Ocultar' saldo investido");
        return this;
    }

    /**
     * Extrair saldo investido
     *
     * @param saldoInvestido Parâmetro a ser preenchido com o valor do saldo investido
     * @return MeusInvestimentosTela
     * @throws Exception
     */
    @Step("Extrair saldo investido")
    public MeusInvestimentosTela extrairSaldoInvestido(ThreadLocal<String> saldoInvestido) throws Exception {
        aguardarElementoHabilitado(campoSaldoInvestido);
        saldoInvestido.set(Utilitarios.normalizaStringNumero(retornarTexto(campoSaldoInvestido,"Não foi possível retornar o texto do elemento saldo")));
        salvarEvidencia("Extraído saldo investido");
        return this;
    }
}

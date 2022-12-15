package pagina.mobile.jornadas.configuracoes.perfil.configuracoes.da.conta;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import constantes.configuracoes.perfil.Mensagens;
import constantes.configuracoes.perfil.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class EncerrarContaTela extends PaginaBase {
    public EncerrarContaTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(xpath = "//*[contains(@text, 'QUERO ENCERRAR CONTA')]")
    @iOSXCUITFindBy(accessibility = "QUERO ENCERRAR CONTA")
    private MobileElement botaoQueroEncerrarConta;

    @AndroidFindBy(xpath = "//*[contains(@text, 'Meu cart�o n�o chegou')]")
    @iOSXCUITFindBy(xpath = "(//*[contains(@name,'Meu cart�o n�o chegou')])[2]")
    private MobileElement radioButtonMeuCartaoNaoChegou;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nc_agreement_terms")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'Selecionar')]")
    private MobileElement checkBoxLiEConcordoComOsTermosECondi��esAcimaListados;

    /**
     * Validar presen�a da tela 'Encerrar Conta'
     *
     * @return EncerrarContaTela
     * @throws Exception
     */
    @Step("Validar tela 'Encerrar Conta'")
    public EncerrarContaTela validarTelaEncerrarConta() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.ENCERRAR_CONTA.toString()), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Encerrar Conta' n�o est� presente na tela!");
        salvarEvidencia("Validar presen�a da na tela 'Encerrar Conta'");
        return this;
    }

    /**
     * Tocar no Bot�o 'Quero Encerrar Conta'
     *
     * @return EncerrarContaTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Encerrar Conta'")
    public EncerrarContaTela tocarBotaoQueroEncerrarConta() throws Exception {
        if(!verificarPresencaElemento((botaoQueroEncerrarConta))){
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoQueroEncerrarConta, "N�o foi poss�vel encontrar o bot�o 'Quero Encerrar Conta'!");
        }
        salvarEvidencia("Tocar no bot�o 'Quero Encerrar Conta'");
        tocarElemento(botaoQueroEncerrarConta, "N�o foi poss�vel tocar no bot�o 'Quero Encerrar Conta'!");
        return this;
    }

    /**
     * Selecionar motivo encerrar conta
     *
     * @return EncerrarContaTela
     * @throws Exception
     */
    @Step("Selecionar motivo 'Encerrar Conta'")
    public EncerrarContaTela selecionarMotivoEncerrarConta() throws Exception {
        aguardarCarregamentoElemento(radioButtonMeuCartaoNaoChegou);
        salvarEvidencia("Tocar no bot�o 'Meu Cartao N�o Chegou'");
        tocarElemento(radioButtonMeuCartaoNaoChegou, "N�o foi poss�vel tocar no bot�o 'Meu Cartao N�o Chegou'!");
        return this;
    }

    /**
     * Tocar botao 'Li e concordo com os Termos e Condi��es acima listados'
     *
     * @return EncerrarContaTela
     * @throws Exception
     */
    @Step("Tocar botao 'Li e concordo com os Termos e Condi��es acima listados'")
    public EncerrarContaTela tocarBotaoLiEConcordoComOsTermosECondi��esAcimaListados() throws Exception {
        if(!verificarPresencaElemento(checkBoxLiEConcordoComOsTermosECondi��esAcimaListados)){
           rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkBoxLiEConcordoComOsTermosECondi��esAcimaListados, "N�o foi poss�vel encontrar o bot�o 'Li e concordo com os Termos e Condi��es acima listados'!");
        }
        salvarEvidencia("Tocar no bot�o 'Li e concordo com os Termos e Condi��es acima listados'");
        tocarElemento(checkBoxLiEConcordoComOsTermosECondi��esAcimaListados, "N�o foi poss�vel tocar no bot�o 'Li e concordo com os Termos e Condi��es acima listados'!");
        return this;
    }

    /**
     * Validar mensagem encerramento de conta
     *
     * @return EncerrarContaTela
     * @throws Exception
     */
    @Step("Validar  mensagem encerramento de conta")
    public EncerrarContaTela validarMensagemEncerramentoDeConta() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagens.MENSAGEM_ENCERRAMENTO_DE_CONTA), MetodoComparacaoBooleano.VERDADEIRO, "Mensagem de 'Encerraramento de Conta' n�o est� presente na tela!");
        salvarEvidencia("Validar presen�a mensagem de encerramento de conta");
        return this;
    }

    /**
     * Validar mensagem antes de encerrar conta
     *
     * @return EncerrarContaTela
     * @throws Exception
     */
    public EncerrarContaTela validarMensagemAntesDeEncerrarConta() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagens.MENSAGEM_ANTES_DE_ENCERRAR_CONTA), MetodoComparacaoBooleano.VERDADEIRO, "Mensagem 'Antes de encerrar sua conta verifique se h� pend�ncias' n�o est� presente na tela!");
        salvarEvidencia("Validar presen�a mensagem 'Antes de encerrar sua conta verifique se h� pend�ncias'");
        return this;
    }
}

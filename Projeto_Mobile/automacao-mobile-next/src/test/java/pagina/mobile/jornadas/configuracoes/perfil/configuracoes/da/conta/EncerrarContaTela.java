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

    @AndroidFindBy(xpath = "//*[contains(@text, 'Meu cartão não chegou')]")
    @iOSXCUITFindBy(xpath = "(//*[contains(@name,'Meu cartão não chegou')])[2]")
    private MobileElement radioButtonMeuCartaoNaoChegou;

    @AndroidFindBy(id = "br.com.bradesco.next:id/nc_agreement_terms")
    @iOSXCUITFindBy(xpath = "//*[contains(@value,'Selecionar')]")
    private MobileElement checkBoxLiEConcordoComOsTermosECondiçõesAcimaListados;

    /**
     * Validar presença da tela 'Encerrar Conta'
     *
     * @return EncerrarContaTela
     * @throws Exception
     */
    @Step("Validar tela 'Encerrar Conta'")
    public EncerrarContaTela validarTelaEncerrarConta() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.ENCERRAR_CONTA.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Encerrar Conta' não está presente na tela!");
        salvarEvidencia("Validar presença da na tela 'Encerrar Conta'");
        return this;
    }

    /**
     * Tocar no Botão 'Quero Encerrar Conta'
     *
     * @return EncerrarContaTela
     * @throws Exception
     */
    @Step("Tocar botão 'Encerrar Conta'")
    public EncerrarContaTela tocarBotaoQueroEncerrarConta() throws Exception {
        if(!verificarPresencaElemento((botaoQueroEncerrarConta))){
            rolarTelaParaBaixoAosPoucosAteEncontrarElemento(botaoQueroEncerrarConta, "Não foi possível encontrar o botão 'Quero Encerrar Conta'!");
        }
        salvarEvidencia("Tocar no botão 'Quero Encerrar Conta'");
        tocarElemento(botaoQueroEncerrarConta, "Não foi possível tocar no botão 'Quero Encerrar Conta'!");
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
        salvarEvidencia("Tocar no botão 'Meu Cartao Não Chegou'");
        tocarElemento(radioButtonMeuCartaoNaoChegou, "Não foi possível tocar no botão 'Meu Cartao Não Chegou'!");
        return this;
    }

    /**
     * Tocar botao 'Li e concordo com os Termos e Condições acima listados'
     *
     * @return EncerrarContaTela
     * @throws Exception
     */
    @Step("Tocar botao 'Li e concordo com os Termos e Condições acima listados'")
    public EncerrarContaTela tocarBotaoLiEConcordoComOsTermosECondiçõesAcimaListados() throws Exception {
        if(!verificarPresencaElemento(checkBoxLiEConcordoComOsTermosECondiçõesAcimaListados)){
           rolarTelaParaBaixoAosPoucosAteEncontrarElemento(checkBoxLiEConcordoComOsTermosECondiçõesAcimaListados, "Não foi possível encontrar o botão 'Li e concordo com os Termos e Condições acima listados'!");
        }
        salvarEvidencia("Tocar no botão 'Li e concordo com os Termos e Condições acima listados'");
        tocarElemento(checkBoxLiEConcordoComOsTermosECondiçõesAcimaListados, "Não foi possível tocar no botão 'Li e concordo com os Termos e Condições acima listados'!");
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
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagens.MENSAGEM_ENCERRAMENTO_DE_CONTA), MetodoComparacaoBooleano.VERDADEIRO, "Mensagem de 'Encerraramento de Conta' não está presente na tela!");
        salvarEvidencia("Validar presença mensagem de encerramento de conta");
        return this;
    }

    /**
     * Validar mensagem antes de encerrar conta
     *
     * @return EncerrarContaTela
     * @throws Exception
     */
    public EncerrarContaTela validarMensagemAntesDeEncerrarConta() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(Mensagens.MENSAGEM_ANTES_DE_ENCERRAR_CONTA), MetodoComparacaoBooleano.VERDADEIRO, "Mensagem 'Antes de encerrar sua conta verifique se há pendências' não está presente na tela!");
        salvarEvidencia("Validar presença mensagem 'Antes de encerrar sua conta verifique se há pendências'");
        return this;
    }
}

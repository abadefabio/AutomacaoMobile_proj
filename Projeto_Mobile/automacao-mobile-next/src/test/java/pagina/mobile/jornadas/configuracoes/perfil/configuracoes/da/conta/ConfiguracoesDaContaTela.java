package pagina.mobile.jornadas.configuracoes.perfil.configuracoes.da.conta;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.constantes.MetodoComparacaoBooleano;
import br.com.next.automacao.core.exception.NextException;
import constantes.configuracoes.perfil.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;
import io.appium.java_client.pagefactory.LocatorGroupStrategy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;
import pagina.mobile.jornadas.configuracoes.perfil.meus.dados.MeusDadosTela;
import pagina.mobile.jornadas.configuracoes.perfil.meus.dados.editarDados.EnderecoResidencialTela;

public class ConfiguracoesDaContaTela extends PaginaBase {
    public ConfiguracoesDaContaTela(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "br.com.bradesco.next:id/ac_account_closing")
    @iOSXCUITFindBy(xpath = "//*[contains(@name, 'Encerrar conta')]/..")
    private MobileElement botaoEncerrarConta;

    /**
     * Validar presen�a da tela 'Configura��es da Conta'
     *
     * @return ConfiguracoesDaContaTela
     * @throws Exception
     */
    @Step("Validar tela 'Configura��es da Conta'")
    public ConfiguracoesDaContaTela validarTelaConfigura��esDaConta() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CONFIGURACOES_DA_CONTA.toString()), MetodoComparacaoBooleano.VERDADEIRO, "T�tulo 'Configura��es da Conta' n�o est� presente na tela!");
        salvarEvidencia("Validar presen�a da na tela 'Configura��es da Conta'");
        return this;
    }

    /**
     * Tocar no Bot�o 'Encerrar Conta'
     *
     * @return ConfiguracoesDaContaTela
     * @throws Exception
     */
    @Step("Tocar bot�o 'Encerrar Conta'")
    public ConfiguracoesDaContaTela tocarBotaoEncerrarConta() throws Exception {
        salvarEvidencia("Tocar no bot�o 'Encerrar Conta'");
        tocarElemento(botaoEncerrarConta, "N�o foi poss�vel tocar no bot�o 'Encerrar Conta'!");
        return this;
    }
}

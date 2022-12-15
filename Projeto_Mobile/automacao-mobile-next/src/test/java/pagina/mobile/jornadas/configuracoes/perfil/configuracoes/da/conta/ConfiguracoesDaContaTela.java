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
     * Validar presença da tela 'Configurações da Conta'
     *
     * @return ConfiguracoesDaContaTela
     * @throws Exception
     */
    @Step("Validar tela 'Configurações da Conta'")
    public ConfiguracoesDaContaTela validarTelaConfiguraçõesDaConta() throws Exception {
        validarCondicaoBooleana(aguardarPaginaConterTodosTextos(TituloTela.CONFIGURACOES_DA_CONTA.toString()), MetodoComparacaoBooleano.VERDADEIRO, "Título 'Configurações da Conta' não está presente na tela!");
        salvarEvidencia("Validar presença da na tela 'Configurações da Conta'");
        return this;
    }

    /**
     * Tocar no Botão 'Encerrar Conta'
     *
     * @return ConfiguracoesDaContaTela
     * @throws Exception
     */
    @Step("Tocar botão 'Encerrar Conta'")
    public ConfiguracoesDaContaTela tocarBotaoEncerrarConta() throws Exception {
        salvarEvidencia("Tocar no botão 'Encerrar Conta'");
        tocarElemento(botaoEncerrarConta, "Não foi possível tocar no botão 'Encerrar Conta'!");
        return this;
    }
}

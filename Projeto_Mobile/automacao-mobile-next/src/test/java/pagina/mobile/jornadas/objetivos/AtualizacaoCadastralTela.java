package pagina.mobile.jornadas.objetivos;

import br.com.next.automacao.core.base.mobile.PaginaBase;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import constantes.objetivos.TituloTela;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.qameta.allure.Step;

public class AtualizacaoCadastralTela extends PaginaBase{

    public AtualizacaoCadastralTela(AppiumDriver driver) {
        super(driver);
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Atualizar meus dados\"]")
    private MobileElement botaoAtualizarMeusDados;

    private boolean apresentouTela = false;

    public boolean isApresentouTela() {
        return apresentouTela;
    }

    /**
     * Verificar Titulo da Tela: 'Atualização Cadastral'
     * @return
     */
    @Step("Verificar Titulo da Tela: 'Atualização Cadastral'")
    public AtualizacaoCadastralTela verificarTituloAtualizacaoCadastral(){
        apresentouTela = aguardarPaginaConterTodosTextos(TituloTela.ATUALIZACAO_CADASTRAL.toString());
        OperadorEvidencia.logarPasso(apresentouTela ? "OK - A tela 'Atualização Cadastral' foi Carregada." : "");
        if(apresentouTela) salvarEvidencia("Verificou o carregamento da tela 'Atualização Cadastral'");
        return this;
    }

    /**
     * Tocar no botão 'Atualizar Meus Dados'.
     * @return
     * @throws NextException
     */
    @Step("Tocar no botão 'Atualizar Meus Dados'.")
    public AtualizacaoCadastralTela tocarBotaoAtualizarMeusDados() throws NextException {
        if(apresentouTela) {
            tocarElemento(botaoAtualizarMeusDados, "Erro ao tocar no botão 'Atualizar Meus Dados'.");
            salvarEvidencia("Tocar no botão 'Atualizar Meus Dados'.");
        }
        return this;
    }


}

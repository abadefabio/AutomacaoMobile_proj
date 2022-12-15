package funcionalidade.frontend.menu;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.frontend.menu.MenuHamburguerTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class MenuHamburguerFunc extends FuncionalidadeBase {

    /**
     * Acessar Indicações de Amigos
     * @throws Exception
     */
    public void acessarIndicacoesAmigos() throws Exception {
        new MenuHamburguerTela(getWebDriver())
                .clicarBotaoIndicacoesAmigos();
    }
}

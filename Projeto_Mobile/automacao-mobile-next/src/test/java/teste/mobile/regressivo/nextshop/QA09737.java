package teste.mobile.regressivo.nextshop;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.nextshop.NextShopFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import br.com.next.automacao.core.constantes.massa.JSON;

;

@Jornada(Jornadas.NEXTSHOP)
public class QA09737 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    NextShopFunc nextShopFunc = new NextShopFunc();

    @Test(description = "Realiza a Jornada de compra alternando entre produtos de diferentes Sellers.")
    @Description("1) Usuario ira realizar a selecao de um produto em uma Loja 1" +
            "2) Usuario ira realizar a selecao de um produto em uma Loja 2" +
            "3) Usuario ira visualizar a mensagem de troca de Loja" +
            "4) Usuario ira selecionar a opcao de trocar o produto para o produto da Loja 2, retirando do carrinho o produto da Loja 1")

    @Severity(SeverityLevel.NORMAL)
    public void QA09737() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarNextShop();

        nextShopFunc.buscaProdutoParaCompra(recuperarMassa("nomeProdutoVtex"));

        nextShopFunc.retornaParaTelaDeBuscaELimpaCampoDePesquisa();

        nextShopFunc.buscaProdutoParaCompraAlterandoLoja(recuperarMassa("nomeProduto"));
    }
}

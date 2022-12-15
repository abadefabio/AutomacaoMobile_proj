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
public class QA10837 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    NextShopFunc nextShopFunc = new NextShopFunc();

    @Test(description = "Realiza a Jornada de compra utilizando o metodo de pagamento: Boleto.")
    @Description("1) Usuario ira realizar a selecao de um produto na Home do NextShop e prosseguir para a PDP e Carrinho.\n" +
            "2) Usuario ira selecionar o endereco cadastrado next para entrega.\n" +
            "3) Usuario ira selecionar a opcao de frete padrao\n" +
            "4) Usuario ira selecionar o pagamento Boleto.\n" +
            "5) Usuario ira confirmar a compra na tela de Resumo do Pedido.\n" +
            "6) Usuario ira validar as informacões de confirmacao de compra para pagamento com Boleto.")

    @Severity(SeverityLevel.NORMAL)
    public void QA10837() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarNextShop();

        nextShopFunc.buscaProdutoParaCompra(recuperarMassa("nomeProduto"));

        nextShopFunc.comprarAgoraConfirmarAtePagamento();

        nextShopFunc.selecionaPagamentoBoleto();

        nextShopFunc.finalizaCompraNextShopBoleto();
    }
}

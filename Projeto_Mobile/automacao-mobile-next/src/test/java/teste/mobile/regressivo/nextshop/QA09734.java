package teste.mobile.regressivo.nextshop;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.nextshop.NextShopFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import br.com.next.automacao.core.constantes.massa.JSON;

@Jornada(Jornadas.NEXTSHOP)
public class QA09734 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    NextShopFunc nextShopFunc = new NextShopFunc();

    @Test(description = "Realiza a Jornada de compra com um produto específico encontrado via Busca.")
    @Description("1) Usuario ira utilizar a barra de busca para encontrar um produto específico de acordo com a massa de dados definida.\n" +
            "2) Usuario ira realizar a selecao do produto e adicao ao carrinho do mesmo.\n" +
            "3) Usuario ira realizar a selecao do endereco next previamente cadastrado.\n" +
            "4) Usuario ira realizar a selecao do modo padrao de frete.\n" +
            "5) Usuario ira realizar o pagamento atraves da opcao padrao, selecionando parcelamento em 1x.\n" +
            "6) Usuario ira preencher o CVV do cartao seleciona e ira prossefuir para a finalizacao da compra.")

    @Severity(SeverityLevel.NORMAL)
    public void QA09734() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarNextShop();

        nextShopFunc.buscaProdutoParaCompra(recuperarMassa("nomeProduto"));

        nextShopFunc.comprarAgoraConfirmarAtePagamento();

        nextShopFunc.selecionaPagamentoPadraoCartao();

        nextShopFunc.finalizaCompraNextShop(recuperarMassa("cvv"));
    }
}

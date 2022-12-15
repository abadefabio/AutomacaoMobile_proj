package teste.mobile.regressivo.nextshop;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.nextshop.AdicionarCartaoNextShopFunc;
import funcionalidade.mobile.nextshop.NextShopFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import br.com.next.automacao.core.constantes.massa.JSON;

;

@Jornada(Jornadas.NEXTSHOP)
public class QA09735 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    NextShopFunc nextShopFunc = new NextShopFunc();
    AdicionarCartaoNextShopFunc adicionarCartaoNextShopFunc = new AdicionarCartaoNextShopFunc();

    @Test(description = "Realiza a Jornada de compra adicionando um cartao novo para realizacao da mesma.")
    @Description("1) Usuario ira realizar a selecao de um produto na Home do NextShop e prosseguir para a PDP e Carrinho.\n" +
            "2) Usuario ira selecionar o endereco cadastrado next para entrega.\n" +
            "3) Usuario ira selecionar a opcao de frete padrao.\n" +
            "4) Usuario ira selecionar adicionar um novo cartao para pagamento e selecionar uma parcela para pagamento.\n" +
            "5) Usuario ira preencher o CVV do cartao selecionado e ira prosseguir para a finalizacao da compra.")

    @Severity(SeverityLevel.NORMAL)
    public void QA09735() throws Exception {

        login.efetuarLoginUsuarioPrimeiroAcesso(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarNextShop();

        nextShopFunc.buscaProdutoParaCompra(recuperarMassa("nomeProduto"));
        nextShopFunc.comprarAgoraConfirmarAtePagamento();

        adicionarCartaoNextShopFunc.adicionaNovoCartaoValido(
                recuperarMassa("numeroCartaoCredito"),
                recuperarMassa("nomeCartaoCredito"),
                recuperarMassa("dataExpiracaoCartaoCredito"),
                recuperarMassa("cpf"));

        nextShopFunc.selecionaParcelasViaBotaoContinuar();
        nextShopFunc.finalizaCompraNextShop(recuperarMassa("cvv"));

    }
}

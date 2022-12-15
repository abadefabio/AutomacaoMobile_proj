package teste.mobile.regressivo.cartao.configuracoes;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import funcionalidade.mobile.configuracoes.perfil.ConfiguracoesPerfilFunc;
import funcionalidade.mobile.configuracoes.perfil.configuracoes.pagamento.ConfiguracoesPagamentoFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static funcionalidade.mobile.login.LoginFunc.retornaCpfCartaoDeCreditoPeloDiaVencDaFatura;

@Jornada(Jornadas.CARTOES)
public class QA04071 extends TesteBase {

    LoginFunc loginFunc = new LoginFunc();
    MenuFunc menuFunc = new MenuFunc();
    ConfiguracoesPerfilFunc configuracoesPerfilFunc = new ConfiguracoesPerfilFunc();
    ConfiguracoesPagamentoFunc configuracoesPagamentoFunc = new ConfiguracoesPagamentoFunc();

    @Test(description = "PBI-67355.70682.001 - Alterar forma de pagamento para cartões cancelado ou bloqueado")
    @Description("Pré-requisito\n" +
            "\n" +
            "Eu enquanto cliente quero visualizar a nova notificação do Visa Causas no lugar da atual notificação do Disney + no app")
    @Severity(SeverityLevel.NORMAL)

    public void QA04071() throws Exception {

        loginFunc.efetuarLoginUsuarioExistente(retornaCpfCartaoDeCreditoPeloDiaVencDaFatura(), recuperarMassa("senha"));
        configuracoesPerfilFunc.tocarPerfilConfiguracoesPagamento();
        configuracoesPagamentoFunc.alteraFormaPagamentoProdutosContratados();
        menuFunc.validarTelaMenu();
    }
}

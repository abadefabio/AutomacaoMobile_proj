package teste.mobile.regressivo.transferencia.transferencia.outra;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.transferencia.ContaPagamento;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.transferencia.TransferenciaFunc;
import funcionalidade.mobile.transferencia.TransferirFunc;
import funcionalidade.mobile.transferencia.para.outra.MeusContatosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA14367 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MeusContatosFunc outraPessoa = new MeusContatosFunc();
    private TransferirFunc transferir = new TransferirFunc();

    @Test(description = "PBI-124912.001.012 - Validar exclusão de uma conta tipo instituição de pagamento")
    @Description("Descrição (Objetivo):\n" +
            "Eu enquanto Product Owner das transações cotidianas quero refinar a jornada de contatos de transferências com gestão dos delay do cadastros para melhor informação, segurança e experiência do cliente.\n" +
            "Ser cliente Next\n" +
            "Ter acesso ao APP Next\n" +
            "Estar logado no APP Next\n" +
            "Ter um contato já cadastrado com conta tipo instituição de pagamento")
    @Severity(SeverityLevel.NORMAL)
    public void QA14367() throws Exception{

        ContaPagamento dadosTransf = ContaPagamento.CONTA_BANCO_SANTANDER;

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.selecionarTransferirPara(dadosTransf.recuperarTransferirPara());

        outraPessoa.selecionarPrimeiroContato();

        outraPessoa.excluirContaDoContato();

        outraPessoa.excluirContato();

    }
}

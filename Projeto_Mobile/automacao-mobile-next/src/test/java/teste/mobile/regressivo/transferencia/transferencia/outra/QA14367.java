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

    @Test(description = "PBI-124912.001.012 - Validar exclus�o de uma conta tipo institui��o de pagamento")
    @Description("Descri��o (Objetivo):\n" +
            "Eu enquanto Product Owner das transa��es cotidianas quero refinar a jornada de contatos de transfer�ncias com gest�o dos delay do cadastros para melhor informa��o, seguran�a e experi�ncia do cliente.\n" +
            "Ser cliente Next\n" +
            "Ter acesso ao APP Next\n" +
            "Estar logado no APP Next\n" +
            "Ter um contato j� cadastrado com conta tipo institui��o de pagamento")
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

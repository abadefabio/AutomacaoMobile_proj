package teste.mobile.regressivo.transferencia.cadastro;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.transferencia.TransferirPara;
import constantes.transferencia.ContaPagamento;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.transferencia.TransferenciaFunc;
import funcionalidade.mobile.transferencia.TransferirFunc;
import funcionalidade.mobile.transferencia.para.mim.MinhasContasFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA14366 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private TransferirFunc transferir = new TransferirFunc();
    private MinhasContasFunc minhasContas = new MinhasContasFunc();

    @Test(description = "PBI-124912.001.011 - Validar cadastro de conta diferente de 237 (PRA MIM)")
    @Description("Eu enquanto Product Owner das transações cotidianas quero refinar a jornada de contatos de transferências com gestão dos delay do cadastros para melhor informação, segurança e experiência do cliente.\n" +
            "Ser cliente Next\n" +
            "Ter acesso ao APP Next\n" +
            "Estar logado no APP Next\n" +
            "Ter um contato já cadastrado\n" +
            "Cadastrar um conta de banco diferente de next e bradesco")
    @Severity(SeverityLevel.NORMAL)
    public void QA14366() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.selecionarTransferirPara(TransferirPara.MIM);

        minhasContas.realizarCadastroNovaConta(ContaPagamento.CONTA_BANCO_CAIXA_ECONOMICA);

        transferir.fecharTelaTransferir();

        minhasContas.fecharTelaMinhasContas();

    }

    @AfterMethod()
    public void deletarContaCadastrada() throws Exception{
        minhasContas.excluirContaAdicionada();
    }
}

package teste.mobile.regressivo.transferencia.transferencia.mim;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.transferencia.TransferirPara;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.transferencia.TransferenciaFunc;
import funcionalidade.mobile.transferencia.TransferirFunc;
import funcionalidade.mobile.transferencia.para.mim.MinhasContasFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

import static constantes.transferencia.ContaPagamento.CADASTRO_TRANSFERENCIA_OUTRA_CC_CC_BRADESCARD_1;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA14365 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MinhasContasFunc minhasContas = new MinhasContasFunc();
    private TransferirFunc transferirFunc = new TransferirFunc();


    @Test(description = "PBI-124912.001.010 - Validar cadastro instituição de pagamento (PRA MIM)")
    @Description("Eu enquanto Product Owner das transações cotidianas quero refinar a jornada de contatos de transferências com gestão dos delay do cadastros para melhor informação, segurança e experiência do cliente.\n" +
            "Ser cliente Next\n" +
            "Ter acesso ao APP Next\n" +
            "Estar logado no APP Next\n" +
            "Ter um contato já cadastrado\n" +
            "Ter cadastrado uma nova conta")
    @Severity(SeverityLevel.NORMAL)
    public void QA14365() throws Exception {


        String cpf = recuperarMassa(JSON.CPF);

        login.efetuarLoginUsuarioExistente(cpf, recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.aceitarTecladoNext();

        transferencia.selecionarTransferirPara(TransferirPara.MIM);

        transferencia.adicionarNovaConta(CADASTRO_TRANSFERENCIA_OUTRA_CC_CC_BRADESCARD_1);

        transferirFunc.exibirFaixaDropdown();

        transferirFunc.ocultarFaixaDropdown();

        transferirFunc.fecharTelaTransferir();

        transferencia.selecionarTransferirPara(TransferirPara.MIM);

        transferirFunc.validarCadastroConta(CADASTRO_TRANSFERENCIA_OUTRA_CC_CC_BRADESCARD_1);


    }
}

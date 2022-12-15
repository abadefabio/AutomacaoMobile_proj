package teste.mobile.regressivo.transferencia.cadastro;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
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

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00315 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private TransferirFunc transferir = new TransferirFunc();
    private MinhasContasFunc minhasContas = new MinhasContasFunc();

    @Test(description = "REG.TRF.01.07 - Efetivar Cadastro de Contato - Para mim - Bradesco")
    @Description("Objetivos: \n" +
            " Efetivar cadastro de contato Bradesco - Para Mim.\n" +
            " \n" +
            "Pré-Requisitos:\n" +
            " Obter aparelho android e/ou IOS;\n" +
            "Obter aplicativo instalado;\n" +
            "Obter conta ativa no NEXT.\n" +
            " \n" +
            "Pós-Condições:\n" +
            " Obter cadastro de contato Bradesco - Para Mim, com sucesso.\n" +
            " \n" +
            "Evidencias necessárias:\n" +
            "Todo o fluxo até as telas.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00315() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.selecionarTransferirPara(TransferirPara.MIM);

        minhasContas.realizarCadastroNovaConta(ContaPagamento.CONTA_BANCO_BRADESCO_1);

        transferir.fecharTelaTransferir();

        minhasContas.fecharTelaMinhasContas();

        transferencia.selecionarTransferirPara(TransferirPara.MIM);

        minhasContas.validarContaEmTela();
    }

    @AfterMethod()
    public void deletarContaCadastrada() throws Exception{
        minhasContas.excluirContaAdicionada();
    }
}

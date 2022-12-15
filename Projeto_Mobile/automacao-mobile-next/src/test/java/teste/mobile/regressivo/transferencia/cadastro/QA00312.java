package teste.mobile.regressivo.transferencia.cadastro;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.transferencia.TransferirPara;
import constantes.transferencia.InstituicaoFinanceira;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.transferencia.TransferenciaFunc;
import funcionalidade.mobile.transferencia.para.mim.MinhasContasFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00312 extends TesteBase {

    @AfterMethod
    public void recadastrarContato() throws Exception{
        minhasContas.realizarRecadastroContaExcluida();
    }

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MinhasContasFunc minhasContas = new MinhasContasFunc();

    @Test(description = "REG.TRF.01.04 - Excluir Contato - Para mim - Bradesco")
    @Description("Objetivos: \n" +
            "Efetuar exclusão de contato Bradesco - Para Mim. \n" +
            " \n" +
            "Pré-Requisitos:\n" +
            "Obter aparelho android e/ou IOS;\n" +
            "Obter aplicatilhio instalado;\n" +
            "Obter conta ativa no NEXT;\n" +
            "Ter contatos Cadastrados (Bradesco).\n" +
            " \n" +
            "Pós-Condições:\n" +
            " Efetuar exclusão de contato Bradesco - Para Mim, com sucesso. \n" +
            " \n" +
            "Evidencias necessárias:\n" +
            "Todo o fluxo até as telas.\n" +
            "Obs.: O sistema permite salvar apenas alguns contatos do Bradesco. Por isso, não alterar a massa")

    @Severity(SeverityLevel.NORMAL)
    public void QA00312() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.selecionarTransferirPara(TransferirPara.MIM);

        minhasContas.excluirContatoSemConfirmar(InstituicaoFinanceira.BRADESCO);

        minhasContas.validarConfirmarExclusaoContato();
    }
}

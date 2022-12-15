package teste.mobile.regressivo.transferencia.cadastro;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.transferencia.TransferirPara;
import constantes.transferencia.InstituicaoFinanceira;
import constantes.transferencia.MensagensEsperadas;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.transferencia.TransferenciaFunc;
import funcionalidade.mobile.transferencia.TransferirFunc;
import funcionalidade.mobile.transferencia.para.outra.MeusContatosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00329 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MeusContatosFunc outraPessoa = new MeusContatosFunc();
    private TransferirFunc operacaoTransferencia = new TransferirFunc();

    @Test(description = "REG.TRF.15.01.13 - Excluir Cadastro de Institui��o de Pagamento que tenha uma ou mais contas no mesmo contato - Outra Pessoa")
    @Description("Objetivos:\n" +
            "Realizar a exclus�o de um cadastro de institui��o de pagamento outra pessoa, com uma ou mais contas.\n" +
            "Pr�-Requisitos:\n" +
            "Obter aplicativo instalado;\n" +
            "Possuir conta ativa no NEXT;\n" +
            "Possuir contato de Institui��o de Pagamento cadastrado com uma ou mais contas, para excluir o cadastro.\n" +
            "P�s-Condi��es:\n" +
            "Excluir o cadastro de Institui��o de Pagamento que tenha uma ou mais contas outra pessoa com sucesso.\n" +
            "Evidencias necess�rias:\n" +
            "Todo o fluxo at� as telas.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00329() throws Exception {
        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.aceitarTecladoNext();

        transferencia.selecionarTransferirPara(TransferirPara.OUTRA_PESSOA);

        outraPessoa.cadastrarNovoContato(InstituicaoFinanceira.SANTANDER, MensagensEsperadas.CONFIRMACAO_CRIACAO_CONTATO);

        outraPessoa.excluirContatoComConfirmacao(MensagensEsperadas.ACAO_EXCLUSAO_CONTATO);

    }
}

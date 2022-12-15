package teste.mobile.regressivo.transferencia.cadastro;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.transferencia.TransferirPara;
import constantes.transferencia.MensagensEsperadas;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.transferencia.TransferenciaFunc;
import funcionalidade.mobile.transferencia.para.outra.MeusContatosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


@Jornada(Jornadas.TRANSFERENCIA)
public class QA00313 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MeusContatosFunc outraPessoa = new MeusContatosFunc();

    @Test(description = "REG.TRF.15.01.11 - Excluir Contato - Outra Pessoa - Outros Bancos")
    @Description("Objetivos: \n" +
            "Efetuar exclusão de contato - Outra Pessoa - Outros Bancos. \n" +
            " \n" +
            "Pré-Requisitos:\n" +
            "Obter aparelho android e/ou IOS;\n" +
            "Obter aplicatilhio instalado;\n" +
            "Obter conta ativa no NEXT;\n" +
            "Ter contatos Cadastrados (Outros Bancos - PF). \n" +
            " \n" +
            "Pós-Condições:\n" +
            " Efetuar exclusão de contato - Outra Pessoa - Outros Bancos com sucesso.\n" +
            " \n" +
            "Evidencias necessárias:\n" +
            "Todo o fluxo até as telas.")

    @Severity(SeverityLevel.NORMAL)
    public void QA00313() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.selecionarTransferirPara(TransferirPara.OUTRA_PESSOA);

        transferencia.buscarContatoParaExcluir(recuperarMassa("nome"), recuperarMassa("sobrenome"));

        outraPessoa.validarConfirmacaoExclusao(MensagensEsperadas.CONFIRMACAO_EXCLUSAO);
    }
}

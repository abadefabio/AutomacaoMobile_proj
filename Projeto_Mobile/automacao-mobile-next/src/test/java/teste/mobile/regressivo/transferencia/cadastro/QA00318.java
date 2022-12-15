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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00318 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MeusContatosFunc outraPessoa = new MeusContatosFunc();
    private TransferirFunc operacaoTransferencia = new TransferirFunc();

    @Test(description = "REG.TRF.01.10 - Efetivar Cadastro de Contato - Outra Pessoa - Outros Bancos")
    @Description("Objetivos: \n" +
            "Efetuar cadastro de contato - Outra Pessoa - Outros Bancos. \n" +
            "\n" +
            "Pré-Requisitos:\n" +
            " Necessário ter pelo menos 1 contato já cadastrado;\n" +
            " Obter aparelho android e/ou IOS;\n" +
            "Obter aplicatilhio instalado;\n" +
            "Obter conta ativa no NEXT.\n" +
            "\n" +
            "Pós-Condições:\n" +
            " Cadastrar contato com sucesso.\n" +
            "\n" +
            "Evidencias necessárias:\n" +
            "Todo o fluxo até as telas.")
    @Severity(SeverityLevel.NORMAL)
    public void QA00318() throws Exception {

        login.efetuarLoginUsuarioExistente( recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.aceitarTecladoNext();

        transferencia.selecionarTransferirPara(TransferirPara.OUTRA_PESSOA);

        outraPessoa.cadastrarNovoContato(InstituicaoFinanceira.SANTANDER, MensagensEsperadas.CONFIRMACAO_CRIACAO_CONTATO);

        outraPessoa.validarNovoContatoSalvo(true);
    }

    @AfterMethod
    public void excluirContato() throws Exception {
        /*
        Este passo não é essencial
        mas ajuda a manter um pequeno número de contatos na massa
         */
        outraPessoa.excluirContatoSemConfirmacao();
        outraPessoa.validarConfirmacaoExclusao(MensagensEsperadas.CONFIRMACAO_EXCLUSAO);
    }

}

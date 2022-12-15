package teste.mobile.regressivo.transferencia.cadastro;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.constantes.transferencia.TransferirPara;
import constantes.transferencia.ContaPagamento;
import constantes.transferencia.InstituicaoFinanceira;
import constantes.transferencia.MensagensEsperadas;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.transferencia.TransferenciaFunc;
import funcionalidade.mobile.transferencia.TransferirFunc;
import funcionalidade.mobile.transferencia.para.mim.MinhasContasFunc;
import funcionalidade.mobile.transferencia.para.mim.NovasContasFunc;
import funcionalidade.mobile.transferencia.para.outra.MeusContatosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA00331 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MinhasContasFunc minhasContas = new MinhasContasFunc();
    private MeusContatosFunc outraPessoa = new MeusContatosFunc();
    private TransferirFunc operacaoTransferencia = new TransferirFunc();
    private NovasContasFunc novaContas = new NovasContasFunc();


    @AfterMethod
    public void deletarContato() throws Exception{
        outraPessoa.excluirContatoSemConfirmacao();
        minhasContas.tocarBotaoConfirmarPopup();
    }

    @Test(description = "REG.TRF.15.01.14 - Validar aba Novo contato autorizado com edição para não autorizado")
    @Description("Objetivos: \n" +
            " Validar comportamento do sistema ao realizar transferência salvando o contato.\n" +
            " \n" +
            "Pré-Requisitos:\n" +
            "Possuir o aplicativo do Next instalado no celular;\n" +
            "Possuir CPF válido;\n" +
            "Possuir saldo na conta corrente.\n" +
            " \n" +
            "Pós-Condições:\n" +
            " Realizar edição não autorizada, com sucesso. \n" +
            " \n" +
            "Evidencias necessárias:\n" +
            "Todo o fluxo até as telas.")

    @Severity(SeverityLevel.NORMAL)
    public void QA00331() throws Exception{

        String agencia =  ContaPagamento.CONTA_BANCO_SANTANDER_1.recuperarAgencia();

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.selecionarTransferirPara(TransferirPara.OUTRA_PESSOA);

        outraPessoa.cadastrarNovoContatoParaTransferir(InstituicaoFinanceira.SANTANDER, MensagensEsperadas.CONFIRMACAO_CRIACAO_CONTATO, agencia);

        operacaoTransferencia.PreencherValorEMotivoTransferencia(agencia);

        transferencia.novaTransferencia();

        outraPessoa.validarNovoContatoSalvoNv();

        novaContas.validarSituacaoSwitchContaAutorizadaTed();

        novaContas.salvarAlteracaoSwitchValidarContato(MensagensEsperadas.CONFIRMACAO_EDICAO);
    }
}

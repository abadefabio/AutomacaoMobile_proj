package teste.mobile.regressivo.transferencia.cadastro;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.transferencia.*;
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
public class QA00332 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private TransferenciaFunc transferencia = new TransferenciaFunc();
    private MeusContatosFunc meusContatos = new MeusContatosFunc();
    private TransferirFunc transferirFunc = new TransferirFunc();

    @Test(description = "REG.TRF.15.01.15 - Validar aba Novo contato sem salvar o contato validando CPF inv�lido")
    @Description("Objetivos: \n" +
            "  Validar transferencia sem salvar contato.\n" +
            " \n" +
            "Pr�-Requisitos:\n" +
            "Possuir o aplicativo do Next instalado no celular;\n" +
            "Possuir CPF v�lido.\n" +
            " \n" +
            "P�s-Condi��es:\n" +
            " N�o possuir nenhum contato Salvo.\n" +
            " \n" +
            "Evidencias necess�rias:\n" +
            "Todo o fluxo at� as telas.")

    @Severity(SeverityLevel.NORMAL)
    public void QA00332() throws Exception {

        /*
        Dados de cadastro devem incluir um banco com ag�ncia e conta reais
        de banco terceiro (porque cadastramos CPF) para a realiza��o da transfer�ncia (sem agendar)
        Portanto, para este CT, usamos o Banco do Brasil com ag�ncia e contas espec�ficas.
         */
        CadastroContatoTransferencia cadastro = CadastroContatoTransferencia.CADASTRO_SEM_SALVAR_TRANSFERENCIA_BANCO_TERCEIRO_CADASTRADO;
        ContaPagamento dadosTransf = cadastro.recuperarContaPagamento();
        TransferenciaMotivo motivo = TransferenciaMotivo.CREDITO_EM_CONTA; // fluxo n�o especifica motivo ent�o escolhemos este

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarTransferencia();

        transferencia.aceitarTecladoNext();

        transferencia.selecionarTransferirPara(dadosTransf.recuperarTransferirPara()); // outra pessoa

        meusContatos.informarCpfCnpjInvalidoContinuar(GeradorNumeros.CPF_INVALIDO, MensagensEsperadas.CADASTRO_CPF_INVALIDO);

        meusContatos.cadastrarContato(cadastro); // objeto 'cadastro' teve ter flag para n�o salvar contato

        transferirFunc.selecionarTipoDeContaOrigem(dadosTransf.recuperarTipoContaOrigem()); // padr�o (CC)

        transferirFunc.iniciarTransferencia(dadosTransf);

        transferirFunc.selecionarTipoDeContaDestino(dadosTransf.recuperarTipoContaDestino()); // padr�o (CC)

        transferirFunc.selecionarTipoTransferencia(dadosTransf.recuperarTipoTransferencia()); // padr�o (TED)

        transferirFunc.selecionarMotivoTransferencia(motivo); // qualquer motivo, ent�o usamos "cr�dito em conta"

        transferirFunc.validarTransferir(cadastro.recuperarContaPagamento(), motivo);

        /*
        Ao transferir de conta cadastrada sem salvar, a mensagem da transfer�ncia � diferente de quando j� existe um contato salvo.
         */
        transferirFunc.validarMensagemSucesso(MensagensEsperadas.CONFIRMACAO_CADASTRO_SEM_SALVAR_TRANSFERENCIA);

        transferencia.iniciarNovaTransferencia(); // tocar bot�o Nova Transfer�ncia

        transferencia.selecionarTransferirPara(dadosTransf.recuperarTransferirPara()); // outra pessoa

        meusContatos.validarContatoNaoSalvoAposTransferencia();

    }
}

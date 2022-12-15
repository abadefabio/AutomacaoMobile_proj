package funcionalidade.mobile.ajuda;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.ajuda.EsqueciMinhaSenha;
import pagina.mobile.comum.next.PopUpTela;
import pagina.mobile.jornadas.ajuda.EsqueciMinhaSenhaTela;
import pagina.web.email.EmailWebTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getDriver;
import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class EsqueciMinhaSenhaFunc extends FuncionalidadeBase {

    /**
     * Processo de Recuperação de Senha tocando no botão de reenviar código
     */
    public void iniciarRecuperacaodeSenhaReenviandoCodigo(String cpf) throws Exception {
        iniciarRecuperacaodeSenha(cpf);
        new EsqueciMinhaSenhaTela(getDriver())
                .tocarBotaoReenviarCodigo();
        new PopUpTela(getDriver())
                .validarMensagem(EsqueciMinhaSenha.REENVIO_DE_CODIGO.toString())
                .tocarBotaoOk();
    }

    /**
     * Processo de Recuperação de Senha
     */
    public void iniciarRecuperacaodeSenha(String cpf) throws Exception {
        new EsqueciMinhaSenhaTela(getDriver())
                .validarMensagemDigiteSeuCPF()
                .preencherCampoCPFRecuperaSenha(cpf)
                .tocarBotaoContinuar()
                .validarMensagemAposBotaoContinuar();
    }

    /**
     * Processo de Recuperação do Código de Segurança no Email
     */
    public void recuperarCodigoSegurancaNoEmail(String dominioUsuarioEmail, String senhaEmail, ThreadLocal<String> codigo) throws Exception {
        getWebDriver().navigate().refresh();
        new EmailWebTela(getWebDriver())
                .preencherCampoDominioeUsuarioEmail(dominioUsuarioEmail)
                .preencherCampoSenhaEmail(senhaEmail)
                .tocarBotaoEntrar()
                .buscarEmailComCodigoDeSeguranca()
                .recuperaCodigoSeguranca(codigo);
    }

    /**
     * Processo para criação da nova Senha
     */
    public void criarNovaSenha(String novaSenha, ThreadLocal<String> codigo) throws Exception {
        new EsqueciMinhaSenhaTela(getDriver())
                .preencherCampoCodigodeSeguranca(codigo.get())
                .tocarBotaoContinuar()
                .preencherCampoNovaSenha(novaSenha)
                .preencherCampoConfirmarSenha(novaSenha)
                .tocarBotaoProximoOUContinuar()
                .validarMensagemTelaTudoCerto()
                .tocarBotaoLogin();
    }
}


package funcionalidade.web.email;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.email.EmailWebTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class EmailWebFunc extends FuncionalidadeBase {

    /**
     * Método que fará a recuperação do código para Mudança de Aparelho
     *
     * @param dominioUsuarioEmail
     * @param senhaEmail
     * @param codigo
     * @throws Exception
     */
    public void recuperarCodigoParaMudancaDeAparelho(String dominioUsuarioEmail, String senhaEmail, ThreadLocal<String> codigo) throws Exception {

        getWebDriver().navigate().refresh();
        new EmailWebTela(getWebDriver())
                .clicarCheckBox()
                .preencherCampoDominioeUsuarioEmail(dominioUsuarioEmail)
                .preencherCampoSenhaEmail(senhaEmail)
                .tocarBotaoEntrar()
                .buscarEmailComCodigoPraMudancaDeAparelho()
                .recuperaCodigoSeguranca(codigo);
    }

    /**
     * Método que fará a consulta se o comprovante do resgate da Poupança foi efetuado
     * Busca no email pelo assunto 'Recibo de transferência'
     *
     * @param dominioUsuarioEmail
     * @param senhaEmail
     * @throws Exception
     */
    public void recuperarComprovanteResgatePoupanca(String dominioUsuarioEmail, String senhaEmail) throws Exception {

        getWebDriver().navigate().refresh();
        new EmailWebTela(getWebDriver())
                .preencherCampoDominioeUsuarioEmail(dominioUsuarioEmail)
                .preencherCampoSenhaEmail(senhaEmail)
                .tocarBotaoEntrar()
                .buscarEmailComAssuntoReciboDeTransferencia();
    }

    /**
     * Método que fará a consulta se o comprovante de aplicação em Poupança foi efetuado
     * Busca no email pelo assunto 'Recibo de transferência'
     *
     * @param dominioUsuarioEmail
     * @param senhaEmail
     * @throws Exception
     */
    public void recuperarComprovanteAplicacaoPoupanca(String dominioUsuarioEmail, String senhaEmail) throws Exception {

        getWebDriver().navigate().refresh();
        new EmailWebTela(getWebDriver())
                .preencherCampoDominioeUsuarioEmail(dominioUsuarioEmail)
                .preencherCampoSenhaEmail(senhaEmail)
                .tocarBotaoEntrar()
                .buscarEmailComAssuntoReciboDeTransferencia();
    }
}

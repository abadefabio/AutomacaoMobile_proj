package funcionalidade.web.email;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import pagina.web.email.EmailWebTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class EmailWebFunc extends FuncionalidadeBase {

    /**
     * M�todo que far� a recupera��o do c�digo para Mudan�a de Aparelho
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
     * M�todo que far� a consulta se o comprovante do resgate da Poupan�a foi efetuado
     * Busca no email pelo assunto 'Recibo de transfer�ncia'
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
     * M�todo que far� a consulta se o comprovante de aplica��o em Poupan�a foi efetuado
     * Busca no email pelo assunto 'Recibo de transfer�ncia'
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

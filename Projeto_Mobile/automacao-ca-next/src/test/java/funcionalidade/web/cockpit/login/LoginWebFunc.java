package funcionalidade.web.cockpit.login;

import br.com.next.automacao.core.base.FuncionalidadeBase;
import constantes.cockpit.Url;
import pagina.web.cockpit.login.LoginWebTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;
import static br.com.next.automacao.core.tools.ReadProperties.getEsteira;

public class LoginWebFunc extends FuncionalidadeBase {

    private void navegar(String url) {
        getWebDriver().navigate().to(url);
    }

    /**
     * Realizar login no Emulador de Telas para um fluxo da TPA
     *
     * @param coreIp
     * @param funcionalidade
     * @param token
     * @throws Exception
     */
    public void realizarLoginEmuladorTPA(String funcionalidade, String coreIp, String token) throws Exception {
        new LoginWebTela(getWebDriver())
                .fecharAlertSessaoInvalida()
                .informarFuncionalidade(funcionalidade)
                .informarCoreIp(coreIp)
                .informarToken(token)
                .clicarBotaoRedirecionar();
    }


    /**
     * Realizar login no Emulador de Telas para um fluxo de adesão
     *
     * @param token
     * @param funcionalidade
     * @param cpf
     * @param idOperador
     * @param nomeOperador
     * @param proposalID
     * @param prospectID
     * @throws Exception
     */
    public void realizarLoginEmuladorADESAO(String funcionalidade,String cpf, String token,String proposalID,String prospectID,String idOperador, String nomeOperador) throws Exception {
        navegar(Url.TELA_MOLDURA);
        new LoginWebTela(getWebDriver())
                .fecharAlertSessaoInvalida()
                .informarFuncionalidade(funcionalidade)
                .informarCoreIp(getEsteira())
                .informarCpf(cpf)
                .informarProposalId(proposalID)
                .informarProspectId(prospectID)
                .informarIdOperador(idOperador)
                .informarNomeOperador(nomeOperador)
                .informarToken(token)
                .clicarBotaoRedirecionar();
    }
}

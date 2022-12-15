package funcionalidade.web.contingencia.perfil;

import constantes.perfil.PerfilCliente;
import funcionalidade.web.contingencia.login.mobile.LoginFunc;
import pagina.web.contingencia.views.base.ContingenciaBaseTela;
import pagina.web.contingencia.views.perfil.MeusDadosTela;

import static br.com.next.automacao.core.drivers.OperadorDriver.getWebDriver;

public class PerfilFunc extends LoginFunc {

    /**
     * Validar campos da tela Meus Dados (Perfil).
     * @throws Exception
     * @param perfil
     * @param cpf
         */
    public void validarPerfilCliente(PerfilCliente perfil, String cpf) throws Exception {
        ContingenciaBaseTela contingenciaBaseTela = new ContingenciaBaseTela(getWebDriver());
        contingenciaBaseTela.clicarBotaoPerfil();
        new MeusDadosTela(getWebDriver())
                .validarCampo("Banco", perfil.recuperarBancoNome())
                .validarCampo("Agência e Dígito", perfil.recuperarAgenciaDigito())
                .validarCampo("Conta e Dígito", perfil.recuperarContaDigito())
                .validarCampo("CPF", cpf);
        contingenciaBaseTela.clicarBotaoPerfil();
    }

}

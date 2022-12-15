package teste.mobile.regressivo.adesao;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.adesao.CompleteSeuCadastroFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;


@Jornada(Jornadas.ADESAO)
public class QA03783 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private CompleteSeuCadastroFunc completeSeuCadastro = new CompleteSeuCadastroFunc();

    @Test(description = "REG.ADS.01.01.63 - Validar banner Complete Seu Cadastro e botão SAIR com a adesão processo de retomada\t\n")
    @Description("Objetivo: Validar banner Complete Seu Cadastro com a adesão processo de retomada" +
            "1 Possuir o aplicativo do Next instalado no device\n" +
            "2 Possuir um CPF válido em processo de adesão\n" +
            "3 Solicitar o QA de Pré-Sit as telas do abstract para fazer o depara com o app")

    @Severity(SeverityLevel.NORMAL)
    public void QA03783() throws Exception{

        login.efetuarLoginCadastroIncompleto(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        completeSeuCadastro.validarTelaCompleteSeuCadastro();
    }
}

package teste.mobile.regressivo.seguros;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.seguros.TipoProtecao;
import constantes.seguros.TipoSeguro;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.seguros.SegurosDebitoAdesaoFunc;
import funcionalidade.mobile.seguros.SegurosHomeFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.SEGUROS)
public class QA12904 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    SegurosHomeFunc segurosHome = new SegurosHomeFunc();
    SegurosDebitoAdesaoFunc segurosDebitoAdesao = new SegurosDebitoAdesaoFunc();

    @Test(description = "QA12904 - Validar informações das Condições Gerais - DÉBITO")
    @Description("Eu enquanto cliente\n" +
            "Quero acessar a Jornada de Seguros no App do next\n" +
            "Para validar informações das Condições Gerais - DÉBITO")

    @Severity(SeverityLevel.NORMAL)
    public void QA12904() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        menu.selecionarSeguros();
        segurosHome.simularSeguroComDeslizeDeTela(TipoSeguro.PARA_O_SEU_CARTAO, TipoProtecao.CARTAO_PROTECAO_CONTRA_TRANSACOES_INDEVIDAS);
        segurosDebitoAdesao.validarCondicoesGerais();

    }
}

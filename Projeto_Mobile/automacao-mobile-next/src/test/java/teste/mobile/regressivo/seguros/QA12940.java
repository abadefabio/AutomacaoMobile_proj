package teste.mobile.regressivo.seguros;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.seguros.TipoProtecao;
import constantes.seguros.TipoSeguro;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.seguros.SegurosHomeFunc;
import funcionalidade.mobile.seguros.SegurosResidencialAdesaoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.SEGUROS)
public class QA12940 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    SegurosHomeFunc segurosHome = new SegurosHomeFunc();
    SegurosResidencialAdesaoFunc segurosResidencialAdesaoFunc = new SegurosResidencialAdesaoFunc();

    @Test(description = "QA12940 - Apresentar tela SALDO INSUFICIENTE ao tentar contratar - RESIDENCIAL")
    @Description("Eu enquanto cliente\n" +
            "Quero acessar a Jornada de Seguros no App do next\n" +
            "Para apresentar tela SALDO INSUFICIENTE ao tentar contratar - RESIDENCIAL")

    @Severity(SeverityLevel.NORMAL)
    public void QA12940() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        menu.selecionarSeguros();
        segurosHome.simularSeguro(TipoSeguro.PARA_O_SEU_DIA_A_DIA, TipoProtecao.DIA_DIA_SEU_LAR_PROTEGIDO_COM_ASSISTENCIAS_24H);
        segurosResidencialAdesaoFunc.validarSaldoInsuficiente();
        segurosResidencialAdesaoFunc.tocarBtnOKSaldoInsuficiente();

    }
}

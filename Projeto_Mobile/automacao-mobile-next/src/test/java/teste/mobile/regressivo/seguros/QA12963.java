package teste.mobile.regressivo.seguros;

import org.testng.annotations.Test;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;

import constantes.seguros.TipoProtecao;
import constantes.seguros.TipoSeguro;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.seguros.SegurosHomeFunc;
import funcionalidade.mobile.seguros.SegurosVidaAdesaoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Jornada(Jornadas.SEGUROS)
public class QA12963 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    SegurosHomeFunc segurosHome = new SegurosHomeFunc();
    SegurosVidaAdesaoFunc segurosVidaAdesao = new SegurosVidaAdesaoFunc();

    @Test(description = "QA12963 - Validar informações das Indenizações - VIDA")
    @Description("Eu enquanto cliente\n" +
            "Quero acessar a Jornada de Seguros no App do next\n" +
            "Para validar informações das Indenizações - VIDA")

    @Severity(SeverityLevel.NORMAL)
    public void QA12963() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        menu.selecionarSeguros();
        segurosHome.simularSeguro(TipoSeguro.PARA_O_SEU_DIA_A_DIA, TipoProtecao.DIA_DIA_TRANQUILIDADE_PARA_QUEM_VOCE_AMA);
        segurosVidaAdesao.validarDetalhesProduto();

    }
}

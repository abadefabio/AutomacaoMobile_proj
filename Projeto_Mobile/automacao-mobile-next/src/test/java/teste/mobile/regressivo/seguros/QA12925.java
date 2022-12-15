package teste.mobile.regressivo.seguros;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.seguros.TipoProtecao;
import constantes.seguros.TipoSeguro;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.seguros.SegurosDentalAdesaoFunc;
import funcionalidade.mobile.seguros.SegurosHomeFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.SEGUROS)
public class QA12925 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    SegurosHomeFunc segurosHome = new SegurosHomeFunc();
    SegurosDentalAdesaoFunc segurosDentalAdesao = new SegurosDentalAdesaoFunc();

    @Test(description = "QA12925 - Contratar Produto - DENTAL")
    @Description("Eu enquanto cliente\n" +
            "Quero acessar a Jornada de Seguros no App do next\n" +
            "Para contratar Produto - DENTAL")

    @Severity(SeverityLevel.NORMAL)
    public void QA12925() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        menu.selecionarSeguros();
        segurosHome.simularSeguro(TipoSeguro.PARA_O_SEU_DIA_A_DIA, TipoProtecao.DIA_DIA_TENHA_MAIS_MOTIVOS_PARA_SORRIR);
        segurosDentalAdesao.contratarProdutoDental();
        segurosDentalAdesao.tocarBtnConcluirContratacaoDental();

    }
}

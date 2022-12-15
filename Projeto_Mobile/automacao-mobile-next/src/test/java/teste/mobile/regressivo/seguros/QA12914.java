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
import funcionalidade.mobile.seguros.SegurosCreditoAdesaoFunc;
import funcionalidade.mobile.seguros.SegurosHomeFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Jornada(Jornadas.SEGUROS)
public class QA12914 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    SegurosHomeFunc segurosHome = new SegurosHomeFunc();
    SegurosCreditoAdesaoFunc segurosCreditoAdesao = new SegurosCreditoAdesaoFunc();

    @Test(description = "QA12914 - Validar informações do Parceiro - CRÉDITO")
    @Description("Eu enquanto cliente\n" +
            "Quero acessar a Jornada de Seguros no App do next\n" +
            "Para validar informações do Parceiro - CRÉDITO")

    @Severity(SeverityLevel.NORMAL)
    public void QA12914() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        menu.selecionarSeguros();
        segurosHome.simularSeguroComDeslizeDeTela(TipoSeguro.PARA_O_SEU_CARTAO, TipoProtecao.CARTAO_PROTECAO_CONTRA_GASTOS_E_IMPREVISTOS);
        segurosCreditoAdesao.validarInformacoesParceiro();

    }
}

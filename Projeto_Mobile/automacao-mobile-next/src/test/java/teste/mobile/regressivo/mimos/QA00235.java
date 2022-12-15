package teste.mobile.regressivo.mimos;

import org.testng.annotations.Test;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;

import constantes.mimos.Oferta;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.mimos.MimosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

;

@Jornada(Jornadas.MIMOS)
public class QA00235 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    MimosFunc mimos = new MimosFunc();

    @Test(description = "REG.MIMO.01.05 - Validação de: Geração de Voucher - Loja Física e Erro- Limite de Cupons Atingidos")
    @Description("Validação da Geração de Voucher - Loja Física;\n" +
            "Validação do Erro: \"Limite de Cupons Atingidos\".")
    @Severity(SeverityLevel.NORMAL)

    public void QA00235() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarMimos();

        mimos.avancarTutorialCasoExista();

        mimos.selecionarOfertaPorBusca(recuperarMassa("oferta"), recuperarMassa("texto"), false);

        mimos.tocarIconeComoUsar();

        mimos.tocarBotaoGerarCupomDeDesconto(true);

        mimos.voltarMenuPrincipalMimosApartirTelaCupons();

        mimos.selecionarOfertaPorBusca(recuperarMassa("oferta"), recuperarMassa("texto"), false);

        mimos.tocarBotaoGerarCupomDeDesconto(false);

        mimos.validarMensagemPopup(Oferta.NUMERO_MAXIMO_CUPONS_UM.toString());
    }
}

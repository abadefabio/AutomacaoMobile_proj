package teste.mobile.regressivo.mimos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.mimos.MimosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.MIMOS)
public class QA00242 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    MimosFunc mimos = new MimosFunc();

    @Test(description = "REG.MIMO.01.12 - Validação de: acesso a campanha via Card e acesso campanha via Carrossel")
    @Description("Validar acesso de campanha via Card -" +
                 "Validar acesso de campanha via Carrossel.")
    @Severity(SeverityLevel.NORMAL)

    public void QA00242() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarMimos();

        mimos.deslizarCarrosselAteAcharCategoria(recuperarMassa("oferta"));

        mimos.acessarOferta(recuperarMassa("promocao"), recuperarMassa("descricaoPromocao"));

        mimos.retornarCarrossel();

        mimos.validarExibicaoCarrossel();

    }
}

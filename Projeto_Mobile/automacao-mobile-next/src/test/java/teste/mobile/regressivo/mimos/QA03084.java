package teste.mobile.regressivo.mimos;

import org.testng.annotations.Test;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;

import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.mimos.MimosFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

;

@Jornada(Jornadas.MIMOS)
public class QA03084 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    MimosFunc mimos = new MimosFunc();

    @Test(description = "REG.MIM.08.12 - Validação do Favoritar e Desfavoritar Mimo")
    @Description("Realizar validação das funcionalidades com sucesso (\"Favoritar\" e \"Desfavoritar\").")
    @Severity(SeverityLevel.NORMAL)

    public void QA03084() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarMimos();

        mimos.selecionarOfertaPorBusca(recuperarMassa("oferta"), recuperarMassa("texto"), false);

        mimos.tocarBotaoFavoritar();

        mimos.retornarCarrossel();

        mimos.validarOfertaNaCategoria(recuperarMassa("categoria"),recuperarMassa("oferta"));

        mimos.selecionarOfertaCategoria(recuperarMassa("oferta"));

        mimos.selecionarDesfavoritar();

        mimos.retornarCarrossel();

        mimos.validarOfertaNaoPresenteNaCategoria(recuperarMassa("categoria"),recuperarMassa("oferta"));

    }
}

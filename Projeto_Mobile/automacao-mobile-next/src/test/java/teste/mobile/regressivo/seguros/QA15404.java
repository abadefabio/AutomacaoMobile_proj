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
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.SEGUROS)
public class QA15404 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    SegurosHomeFunc segurosHome = new SegurosHomeFunc();

    @Test(description = "QA15404 - Validar oferta de produtos - Não exibir Seguro de Débito para massa superior a 75 anos")
    @Description("Eu enquanto cliente next com mais de 75 anos" +
            "Quero acessar a Jornada de Seguros no App do next" +
            "Para tentar contratar o produto SEGURO DÉBITO e visualizar a tela de ERRO DE CONTRATAÇÃO.")

    @Severity(SeverityLevel.NORMAL)
    public void QA15404() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));
        menu.selecionarSeguros();
        segurosHome.procurarCard(TipoSeguro.PARA_O_SEU_CARTAO, TipoProtecao.CARTAO_PROTECAO_CONTRA_TRANSACOES_INDEVIDAS);

    }
}

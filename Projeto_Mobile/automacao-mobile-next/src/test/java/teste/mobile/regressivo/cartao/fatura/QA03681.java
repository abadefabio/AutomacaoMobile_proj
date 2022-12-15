package teste.mobile.regressivo.cartao.fatura;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import funcionalidade.mobile.cartao.fatura.FaturaFunc;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.CARTOES)
public class QA03681 extends TesteBase {

    private LoginFunc login = new LoginFunc();
    private MenuFunc menu = new MenuFunc();
    private FaturaFunc fatura = new FaturaFunc();

    @Test(description = "REG.CAR.04.07.24 - Visualizar Fatura")
    @Description("Pré condição: Possuir Cartão de credito ativo." +
                 "Objetivo: Validar apresentação do botão Fatura em PDF.")

    @Severity(SeverityLevel.NORMAL)
    public void QA03681() throws Exception{

        login.efetuarLoginUsuarioExistente(recuperarMassa("cpf"), recuperarMassa("senha"));

        menu.selecionarCartao();

        fatura.visualizarFatura();

    }

}

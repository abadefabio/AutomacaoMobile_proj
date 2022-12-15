package teste.mobile.regressivo.nextJoy;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import constantes.nextJoy.MensagemEsperadas;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.nextjoy.ExcluirMesadaFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.JOY)
public class QA04258 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ExcluirMesadaFunc excluirMesada = new ExcluirMesadaFunc();

    @Test(description = "REG.MES.01.01 - Validar mesada cadastrada e sem cadastro.")
    @Description("Eu enquanto cliente quero excluir uma mesada para meu dependente na opção “Home \"NextJoy\"” no menu de opçõesObjetivo: Validar mesada cadastrada e excluir transaçao.\n" +
            "\n" +
            "Pré-Condições:\n" +
            "Ter acesso ao Next\n" +
            "Ter acesso ao módulo de Home \"NextJoy\"\n" +
            "Possuir mesada previamente cadastrada.\n" +
            "\n" +
            "Referência : PB901 - US-PB-1003-MAGIA-Mesada\n" +
            "\n" +
            "Pós-Condições: Disponibilizar no Next o serviço de Home \"NextJoy\" para que os clientes possam cadastrar seus dependentes.")
    @Severity(SeverityLevel.NORMAL)

    public void QA04258() throws Exception {

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.selecionarNextJoy();

        excluirMesada.excluirMesadaAgendada(MensagemEsperadas.MESADA_EXCLUIDA,MensagemEsperadas.MESADAS_NAO_CRIADAS, recuperarMassa("nomeDependente"));

    }
}

package teste.mobile.regressivo.objetivos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import br.com.next.automacao.core.tools.Utilitarios;
import funcionalidade.mobile.login.LoginFunc;
import funcionalidade.mobile.menu.MenuFunc;
import funcionalidade.mobile.objetivos.ObjetivosFunc;
import funcionalidade.mobile.objetivos.resgate.RealizarResgateFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.OBJETIVOS)
public class QA03182 extends TesteBase {

    LoginFunc login = new LoginFunc();
    MenuFunc menu = new MenuFunc();
    ObjetivosFunc objetivo = new ObjetivosFunc();
    RealizarResgateFunc resgate = new RealizarResgateFunc();

    private ThreadLocal<String> valorDisponivelSaldo = new ThreadLocal<>();

    @Test(description = "REG.OBJ.09.08.01 - Validar restate parcial de objetivo abatendo no valor da meta pelo botão DETALHES do card")
    @Description("Descrição: Validar restate parcial de objetivo em andamento abatendo no valor da meta\n" +
            "Pré-Requisitos:\n" +
            "\n" +
            "CPF e senha Válidos")

    @Severity(SeverityLevel.NORMAL)
    public void QA03182() throws Exception{

        login.efetuarLoginUsuarioExistente(recuperarMassa(JSON.CPF), recuperarMassa(JSON.SENHA));

        menu.tocarExibirSaldoConta(valorDisponivelSaldo);

        menu.selecionarObjetivos();

        objetivo.acessarDetalhesObjetivo();

        resgate.realizarResgateParcial(recuperarMassa("valorResgateParcial"));

        Integer valorInicial = Integer.parseInt(Utilitarios.normalizaStringNumero(valorDisponivelSaldo.get()));
        Integer valorResgate = Integer.parseInt(Utilitarios.normalizaStringNumero(recuperarMassa("valorResgateParcial")));

        Integer valorSaldoFinal = valorInicial + valorResgate;
        menu.validaSaldoFinal(valorSaldoFinal.toString());

    }
}

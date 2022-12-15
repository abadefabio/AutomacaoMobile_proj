package teste.web.regressivo.mimos;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.tools.ReadProperties;
import br.com.next.automacao.core.tools.Utilitarios;
import funcionalidade.web.sistemadegestao.login.SistemaDeGestaoLoginFunc;
import funcionalidade.web.sistemadegestao.menu.SistemaDeGestaoMenuFunc;
import funcionalidade.web.sistemadegestao.mimos.card.SistemaDeGestaoCardFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;

import static br.com.next.automacao.core.tools.ReadProperties.getEsteira;

@Jornada(Jornadas.MIMOS)
public class QA00244 extends TesteBase {

    SistemaDeGestaoLoginFunc loginSistemaDeGestao = new SistemaDeGestaoLoginFunc();
    SistemaDeGestaoMenuFunc menuMimosSistemaDeGestao = new SistemaDeGestaoMenuFunc();
    SistemaDeGestaoCardFunc sistemaDeGestaoCardFunc = new SistemaDeGestaoCardFunc();

    @Test(description = "REG.MIMO.01.18 - Valida��o de: altera��o de Card de oferta, feito pelo sistema de gest�o")
    @Description("Objetivos: \n" +
            "\n" +
            "Validar altera��o no Card de oferta.\n" +
            " \n" +
            "\n" +
            "Pr�-Requisitos:\n" +
            "\n" +
            "Ter acesso a internet\n" +
            "Ter acesso ao APP Next\n" +
            "Ter categoria e oferta para aplicar a altera��o\n" +
            " \n" +
            "\n" +
            "P�s-Condi��es:\n" +
            "\n" +
            "Realizar altera��o com sucesso.")
    @Severity(SeverityLevel.NORMAL)


    public void QA00244() throws Exception{

        /*
         * Se o teste n�o terminar com �xito, ser� necess�rio aprovar ou rejeitar uma altera��o
         * em andamento antes da pr�xima execu��o.
         * Qualquer idCard existente na tabela serve para verificar a altera��o.
         */

        String idCard = recuperarMassa("idCard");

        loginSistemaDeGestao.realizarLogin(ReadProperties.getGestaoUser(),ReadProperties.getGestaoPass(), ReadProperties.getAmbiente());

        menuMimosSistemaDeGestao.clicarLinkMIMOS();

        menuMimosSistemaDeGestao.clicarLinkCARD();

        sistemaDeGestaoCardFunc.clicarLinkEditarCard(idCard);

        String novoTextoCard = Utilitarios.geradorPalavra(6);
        sistemaDeGestaoCardFunc.editarTextoCard(novoTextoCard);

        sistemaDeGestaoCardFunc.clicarLinkEditarCard(idCard);

        sistemaDeGestaoCardFunc.verificarTextoCard(novoTextoCard);

    }
}

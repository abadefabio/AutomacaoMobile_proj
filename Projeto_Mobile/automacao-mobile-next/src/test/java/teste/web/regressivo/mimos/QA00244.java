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

    @Test(description = "REG.MIMO.01.18 - Validação de: alteração de Card de oferta, feito pelo sistema de gestão")
    @Description("Objetivos: \n" +
            "\n" +
            "Validar alteração no Card de oferta.\n" +
            " \n" +
            "\n" +
            "Pré-Requisitos:\n" +
            "\n" +
            "Ter acesso a internet\n" +
            "Ter acesso ao APP Next\n" +
            "Ter categoria e oferta para aplicar a alteração\n" +
            " \n" +
            "\n" +
            "Pós-Condições:\n" +
            "\n" +
            "Realizar alteração com sucesso.")
    @Severity(SeverityLevel.NORMAL)


    public void QA00244() throws Exception{

        /*
         * Se o teste não terminar com êxito, será necessário aprovar ou rejeitar uma alteração
         * em andamento antes da próxima execução.
         * Qualquer idCard existente na tabela serve para verificar a alteração.
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

package teste.api.regressivo.transferencia;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.transferencia.EditarAgendamentoFunc;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA21304 extends TesteBase {

    private EditarAgendamentoFunc editarAgendamentoFunc = new EditarAgendamentoFunc();

    @Test(description = "Atualização de categoria para uma transferência agendada, invalida.")
    @Description("VALIDAR MENSAGEM DE RETORNO")


    @Severity(SeverityLevel.NORMAL)
    public void QA21304 () throws Exception {
        editarAgendamentoFunc.atualizarCategoriaTransferenciaAgendada(
                        recuperarMassa(JSON.CPF),
                        recuperarMassa("transferId"), "30"
                )
                .validarAtualizacaoCategoriaInvalidaParaTransferenciaAgendada();
    }

}

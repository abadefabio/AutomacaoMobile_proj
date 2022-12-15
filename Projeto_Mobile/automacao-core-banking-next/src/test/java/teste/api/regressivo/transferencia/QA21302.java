package teste.api.regressivo.transferencia;


import br.com.next.automacao.core.constantes.massa.JSON;
import funcionalidade.transferencia.EditarAgendamentoFunc;
import funcionalidade.transferencia.ListarTransferenciasFunc;
import org.testng.annotations.Test;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import java.util.Random;

@Jornada(Jornadas.TRANSFERENCIA)
public class QA21302 extends TesteBase {

    private EditarAgendamentoFunc editarAgendamentoFunc = new EditarAgendamentoFunc();
    String categoryId =  String.valueOf(new Random().nextInt(15 - (1 - 1)) + 1);

    @Test(description = "Atualização de categoria para uma transferência agendada")
    @Description("VALIDAR MENSAGEM DE RETORNO")

    @Severity(SeverityLevel.NORMAL)
    public void QA21302() throws Exception {
        editarAgendamentoFunc.atualizarCategoriaTransferenciaAgendada(
                recuperarMassa(JSON.CPF),
                recuperarMassa("transferId"), categoryId
        )
                .validarAtualizacaoCategoriaTransferenciaAgendada();
    }

}

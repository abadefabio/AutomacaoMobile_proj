package br.com.next.automacao.core.error;

import br.com.next.automacao.core.tools.evidencia.OperadorEvidenciaInterface;
import br.com.next.automacao.core.tools.evidencia.relatorio.GeradorLogTxtReport;
import org.testng.Assert;
import org.testng.Reporter;


public class NextError extends Error {

    public NextError(OperadorEvidenciaInterface operador, String message, Error ex) {
        operador.salvarEvidencia("CAPTURA DE IMAGEM DO ERRO");
        GeradorLogTxtReport.geradorLogFontePagina(operador.recuperarFonteTela());
        Assert.fail(message, ex.getCause());
    }

    public NextError(String message, Error ex){
        Reporter.log(ex.getMessage());
        Assert.fail(message, ex.getCause());
    }

}

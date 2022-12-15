package br.com.next.automacao.core.exception;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidenciaInterface;
import br.com.next.automacao.core.tools.evidencia.relatorio.GeradorLogTxtReport;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.Reporter;

public class NextException extends Exception {
    
   public NextException (OperadorEvidenciaInterface operador, String message, Exception ex) {
       operador.salvarEvidencia("CAPTURA DE IMAGEM DO ERRO");
       GeradorLogTxtReport.geradorLogFontePagina(operador.recuperarFonteTela());
       Assert.fail(message, ex.getCause());
    }

    public NextException (String message, Exception ex) {
        Reporter.log("\n\n");
        Reporter.log(message);
        Reporter.log(ex.getMessage());
        Assert.fail(message, ex.getCause());
    }

    public NextException(NoSuchElementException cause, String reason){
       throw new NoSuchElementException(reason, cause);
    }
}

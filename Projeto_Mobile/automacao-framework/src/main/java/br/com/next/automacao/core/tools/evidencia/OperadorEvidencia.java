package br.com.next.automacao.core.tools.evidencia;

import br.com.next.automacao.core.base.TesteNext;
import org.testng.Reporter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.util.Objects.isNull;

public interface OperadorEvidencia {

    /**
     * M�todo registra passo no log da execu��o
     * @param texto
     */
    static void logarPasso(String texto) {
        String suiteXmlTest = TesteNext.getSuiteXmlTest();
        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        if (TesteNext.paralelo) {
            Reporter.log(String.format("%s | %s %s", suiteXmlTest, data, texto), true);
        } else {
            Reporter.log(String.format("%s %s", data, texto), true);
        }
    }


    /**
     * M�todo registra passo no log da execu��o
     * @param step Nome do Passo principal
     * @param operacao Nome da opera��o espec�fica
     * @param time tempo em milissegundos da dura��o da a��o
     */
    static void logarPassoCompleto(String step, String operacao, float time) {
        String suiteXmlTest = TesteNext.getSuiteXmlTest();
        String data = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        step = isNull(step) || step.equals("") ? "" : step;

        if (TesteNext.paralelo) {
            Reporter.log(String.format("%s | %s    %s > %s (%.3f seg)", suiteXmlTest, data, step, operacao, time/1000.0), true);
        } else {
            Reporter.log(String.format("%s    %s > %s (%.3f seg)", data, step, operacao, time/1000.0), true);
        }
    }
}

package br.com.next.automacao.core.tools.dados;


import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.ITestResult;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import static br.com.next.automacao.core.base.TesteNext.getCasoTeste;

public class DadosScript implements ResumoScript {
    protected String idJira;
    protected String jornada;
    protected LocalDateTime tempoExecucao;
    protected String resultado;
    protected String detalhesFalha;
    protected String nomeBloco;
    protected String tipoFalha = "";

   public DadosScript(ITestResult result){
       this.idJira = "QA-" + StringUtils.substringAfter(result.getMethod().getMethodName(),"QA");
       this.jornada = getCasoTeste().getJornadaCt();
       this.resultado = result.isSuccess() ? "SUCESSO" : result.getSkipCausedBy().isEmpty() ? "FALHA" : "IGNORADO";
       this.detalhesFalha = this.resultado == "FALHA" ? ExceptionUtils.getStackTrace(result.getThrowable()) : "";
       long duracaoMilis = result.getEndMillis() - result.getStartMillis();
       this.tempoExecucao = new Date(duracaoMilis + 3*3600000).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
       this.nomeBloco = result.getTestContext().getName();
   }

    @Override
    public String retornaNomeBloco() {
        return this.nomeBloco;
    }

    @Override
    public Object[] retornarValores() {
        return new Object[]{
                this.idJira,
                this.jornada,
                this.nomeBloco,
                this.tempoExecucao.toLocalTime(),
                this.resultado,
                this.tipoFalha,
                this.detalhesFalha
        };
    }
}

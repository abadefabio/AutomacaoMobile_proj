package br.com.next.automacao.core.tools.dados;

import br.com.next.automacao.core.constantes.driver.mobile.TipoMobileDriver;
import br.com.next.automacao.core.constantes.driver.web.TipoWebDriver;
import org.testng.ITestContext;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

public class DadosTestes implements ResumoTestes{

    protected String nomeTeste;
    protected Map<String, String> parametros;
    protected LocalDateTime inicio;
    protected LocalDateTime fim;
    protected ResumoScript[] listaResumoExecucoes;
    private int ultimaExecucaoListada = 0;

    public DadosTestes(ITestContext blocoTestes){
        this.nomeTeste = blocoTestes.getName();
        this.parametros = blocoTestes.getCurrentXmlTest().getAllParameters();
        listaResumoExecucoes = new ResumoScript[blocoTestes.getAllTestMethods().length];
    }

    public String obterNomeTestes(){
        return this.nomeTeste;
    }

    @Override
    public void consolidarInformacoesTestes(ITestContext context) {
        this.inicio = context.getStartDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        this.fim = context.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    @Override
    public void incluirResumoTeste(ResumoScript resumoScript) {
        listaResumoExecucoes[ultimaExecucaoListada] = resumoScript;
        ultimaExecucaoListada++;
    }

    @Override
    public Object[] retornarValores() {
        Date fimEmDate = Date.from(fim.atZone(ZoneId.systemDefault()).toInstant());
        Date inicioEmDate = Date.from(inicio.atZone(ZoneId.systemDefault()).toInstant());
        long duracao = fimEmDate.getTime() - inicioEmDate.getTime();
        return new Object[]{
                nomeTeste,
                parametros.get("plataforma"),
                parametros.get("navegador"),
                parametros.get("segundoNavegador"),
                parametros.get("udid"),
                inicio,
                fim,
                new Date(duracao + 3*3600000).toInstant().atZone(ZoneId.systemDefault()).toLocalTime()};
    }
}

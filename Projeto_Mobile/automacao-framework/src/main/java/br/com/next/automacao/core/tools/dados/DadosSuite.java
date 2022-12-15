package br.com.next.automacao.core.tools.dados;

import org.testng.IResultMap;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class DadosSuite implements ResumoSuite{

    protected int numeroThreads;
    protected String nomeSuite;
    protected LocalDateTime duracao;
    protected LocalDateTime inicio;
    protected LocalDateTime fim;
    protected int sucessos = 0;
    protected LocalDateTime duracaoSucessos;
    protected int falhas = 0;
    protected LocalDateTime duracacaoFalhas;
    protected int ignorados = 0;
    protected LocalDateTime duracaoThread;
    protected Map<String, ResumoTestes> dicionarioBlocosTeste;

    public DadosSuite(String nomeSuite, int numeroThreads){
        this.nomeSuite = nomeSuite;
        this.numeroThreads = numeroThreads;
        inicio = LocalDateTime.now();
        fim = inicio;
        dicionarioBlocosTeste = new HashMap<>();
    }

   @Override
    public synchronized void adicionarNovoBlocoTeste(ResumoTestes resumo){
        dicionarioBlocosTeste.put(resumo.obterNomeTestes(),resumo);
    }

    @Override
    public synchronized void atualizarDadosConjuntoTestes(ITestContext context) {
        ResumoTestes resumo = dicionarioBlocosTeste.get(context.getName());
        resumo.consolidarInformacoesTestes(context);
        LocalDateTime fimBloco = context.getEndDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        if(fim.isBefore(fimBloco)){
            fim = fimBloco;

        }
    }

    @Override
    public void atualizarDadosTeste(ResumoScript resumo) {
        dicionarioBlocosTeste.get(resumo.retornaNomeBloco()).incluirResumoTeste(resumo);
    }

    @Override
    public Object[] recuperarResumoTestes() {
        return dicionarioBlocosTeste.values().toArray();
    }

    @Override
    public Object[] recuperarResumoScripts() {
        Collection<ResumoTestes> testes = dicionarioBlocosTeste.values();
        List<ResumoScript> listaResumoScripts = new ArrayList<>();
        for(ResumoTestes bloco : testes)
            listaResumoScripts.addAll(Arrays.asList(((DadosTestes)bloco).listaResumoExecucoes));
        return listaResumoScripts.toArray();
    }

    @Override
    public void registrarResultadosSuite(Map<String, ISuiteResult> resultados){
        ITestContext infoTestes;
        long duracaoMilis = 0,duracoSucessosMilis =0,duracaoFalhasMilis = 0;
        for(ISuiteResult resultado : resultados.values()){
            infoTestes = resultado.getTestContext();
            this.falhas += infoTestes.getFailedTests().size();
            this.sucessos += infoTestes.getPassedTests().size();
            duracoSucessosMilis += calcularTempoDuracaoResultado(infoTestes.getPassedTests());
            this.ignorados += infoTestes.getSkippedTests().size();
            duracaoFalhasMilis += calcularTempoDuracaoResultado(infoTestes.getFailedTests());
            duracaoMilis += infoTestes.getEndDate().getTime() - infoTestes.getStartDate().getTime();
        }
        this.duracaoSucessos = new Date(duracoSucessosMilis + 3*3600000).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        this.duracacaoFalhas = new Date(duracaoFalhasMilis + 3*3600000).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        this.duracaoThread = new Date(duracaoMilis + 3*3600000).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    private long calcularTempoDuracaoResultado(IResultMap resultados){
        Set<ITestResult> todosResultados =  resultados.getAllResults();
        long inicio,fim,duracao = 0;
        for(ITestResult resultado : todosResultados){
            inicio = resultado.getStartMillis();
            fim = resultado.getEndMillis();
            duracao += (fim-inicio);
        }
        return duracao;
    }

    public Object[] retornarValores(){
        long timeInicio = Date.from(inicio.atZone(ZoneId.systemDefault()).toInstant()).getTime();
        long timeFim = Date.from(fim.atZone(ZoneId.systemDefault()).toInstant()).getTime();
        this.duracao = new Date((timeFim - timeInicio) + 3*3600000).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return new Object[]{ nomeSuite,
                numeroThreads,
                duracao.toLocalTime(),
                inicio,
                fim,
                sucessos,
                duracaoSucessos.toLocalTime(),
                falhas,
                duracacaoFalhas.toLocalTime(),
                ignorados,
                duracaoThread.toLocalTime()
        };
    }

}

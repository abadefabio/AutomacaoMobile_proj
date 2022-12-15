package br.com.next.automacao.core.tools.evidencia.relatorio;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static br.com.next.automacao.core.base.TesteNext.getCasoTeste;
import static br.com.next.automacao.core.tools.evidencia.relatorio.GeradorRelatorioEvidencia.criarDiretorioEvidencia;

/**
 * Classe responsável por gerar o log de execução dos testes de servi
 */
public class GeradorLogTxtReport {

    public static void geradorLogFontePagina(String fontePagina){
        String nomeArquivoCompleto = getCasoTeste().getCaminhoEvidenciaCt()+ getCasoTeste().getNomeArquivoEvidencia() + "_FontePagina_Falha.txt";
        criarDiretorio();
        FileWriter writer = iniciarArquivoNovo(nomeArquivoCompleto);
        if(writer == null) {
            System.out.println("Não foi possível escrever o arquivo com o fonte da pagina");
            return;
        }
        escreverArquivo(writer, fontePagina);
        encerrarArquivoNovo(writer, nomeArquivoCompleto);
    }

    public static void geradorLogApi(List<String> log) {
        String nomeArquivoCompleto = getCasoTeste().getCaminhoEvidenciaCt()+ getCasoTeste().getNomeArquivoEvidencia() + ".txt";
        criarDiretorio();
        FileWriter writer = iniciarArquivoNovo(nomeArquivoCompleto);
        if(writer == null) return;

        for (String str : log) {
            escreverArquivo(writer, str + System.lineSeparator());
        }

        encerrarArquivoNovo(writer, nomeArquivoCompleto);
    }

    private static void escreverArquivo(FileWriter writer, String texto){
        try {
            writer.write( texto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void encerrarArquivoNovo(FileWriter writer, String nomeArquivoCompleto){
        try {
            writer.close();
            getCasoTeste().adicionarArquivoEvidencia(nomeArquivoCompleto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static FileWriter iniciarArquivoNovo(String nomeArquivoCompleto){
        FileWriter writer = null;

        try {
            writer = new FileWriter(nomeArquivoCompleto);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return writer;
    }

    protected static void criarDiretorio(){
        criarDiretorioEvidencia(getCasoTeste().getCaminhoEvidencia());
        criarDiretorioEvidencia(getCasoTeste().getCaminhoJornada());
        criarDiretorioEvidencia(getCasoTeste().getCaminhoEvidenciaCt());
    }
}

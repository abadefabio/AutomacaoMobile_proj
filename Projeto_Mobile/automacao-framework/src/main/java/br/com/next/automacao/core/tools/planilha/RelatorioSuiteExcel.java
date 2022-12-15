package br.com.next.automacao.core.tools.planilha;

import br.com.next.automacao.core.tools.dados.ResumoSuite;
import org.apache.poi.ss.usermodel.*;

public class RelatorioSuiteExcel extends RelatorioExcel implements RelatorioSuite{

    private Excel relatorio;
    private String nomeAbaSuite;
    private String nomeAbaScripts;

    public RelatorioSuiteExcel(Excel relatorio, String nomeAbaSuite, String nomeAbaScripts){
        this.relatorio = relatorio;
        this.nomeAbaSuite = nomeAbaSuite;
        this.nomeAbaScripts = nomeAbaScripts;
    }


    public static RelatorioTestes escreverRelatorioExcel(String nomeArquivo, ResumoSuite resumo){
        RelatorioExcel relatorio = new RelatorioExcel(nomeArquivo);
        int quantidadeAbas = relatorio.recuperarWorkbook().getNumberOfSheets();
        String nomeAbaSuite = "Dados Suite";
        String nomeAbaScripts = quantidadeAbas < 2 ? "Dados Testes - Execu��o 1" : "Dados Testes - Execu��o " + String.valueOf(quantidadeAbas);
        return new RelatorioSuiteExcel(relatorio, nomeAbaSuite, nomeAbaScripts)
                .escreverResultadosSuite(resumo);
    }

    @Override
    public Sheet abrirAba(String nomeAba){
        Sheet aba = relatorio.recuperarWorkbook().getSheet(nomeAba);
        if(aba == null){
            aba = relatorio.recuperarWorkbook().createSheet(nomeAba);
            Row linha = aba.createRow(0);
            Object[] titulos ={"Nome Suite",
                    "Numero Threads",
                    "Dura��o",
                    "In�cio",
                    "Fim",
                    "Sucessos",
                    "Tempo Execu��o Sucessos",
                    "Falhas",
                    "Tempo Execu��o Falhas",
                    "Ignorados",
                    "Tempo Execu��o Thread",
                    "Falhas Massa",
                    "Tempo Falhas Massa",
                    "Falhas Ambiente",
                    "Tempo Falhas Ambiente",
                    "Falhas Bug",
                    "Tempo Falhas Bug",
                    "Falhas Script",
                    "Tempo Falhas Script",
                    "Falhas Outros",
                    "Tempo Falhas Outros"};
            escreverLinha(linha, titulos);
        }
        return aba;
    }

    @Override
    public RelatorioTestes escreverResultadosSuite(ResumoSuite resumo) {
        Sheet aba = abrirAba(nomeAbaSuite);
        int contagemLinha = aba.getLastRowNum() + 1;
        Row linha = aba.createRow(contagemLinha++);
        escreverLinha(linha, resumo.retornarValores());
        escreverFormulasLinha(linha, 12,montarFormulasLinha());
        return new RelatorioTestesExcel(relatorio, nomeAbaScripts);
    }

    private String[] montarFormulasLinha(){
        return new String[]{ "SUM('"+ nomeAbaScripts + "'!$B9:$XFD9)",
                "SUM('"+ nomeAbaScripts + "'!$B10:$XFD10)",
                "SUM('"+ nomeAbaScripts + "'!$B11:$XFD11)",
                "SUM('"+ nomeAbaScripts + "'!$B12:$XFD12)",
                "SUM('"+ nomeAbaScripts + "'!$B13:$XFD13)",
                "SUM('"+ nomeAbaScripts + "'!$B14:$XFD14)",
                "SUM('"+ nomeAbaScripts + "'!$B15:$XFD15)",
                "SUM('"+ nomeAbaScripts + "'!$B16:$XFD16)",
                "SUM('"+ nomeAbaScripts + "'!$B17:$XFD17)",
                "SUM('"+ nomeAbaScripts + "'!$B18:$XFD18)"
        };
    }
}

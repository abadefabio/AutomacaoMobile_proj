package br.com.next.automacao.core.tools.planilha;

import br.com.next.automacao.core.tools.dados.ResumoScript;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


public class RelatorioScriptExcel extends RelatorioExcel implements RelatorioScript, Excel{

    protected Excel relatorioExcel;
    protected String nomeAba;

    RelatorioScriptExcel(Excel relatorio, String nomeAba){
        relatorioExcel = relatorio;
        this.nomeAba = nomeAba;
    }


    @Override
    public Sheet abrirAba(String nomeAba){
        Sheet aba = relatorioExcel.recuperarWorkbook().getSheet(nomeAba);
        if(aba == null){
            aba = relatorioExcel.recuperarWorkbook().createSheet(nomeAba);
            aba.createRow(1);
        }
        if(aba.getLastRowNum() < 18){
            Row linha = aba.createRow(18);
            Object[] titulos ={"Id Jira",
                    "Jornada",
                    "Bloco Teste",
                    "Tempo Execução",
                    "Resultado",
                    "Tipo de Falha",
                    "Detalhes Falha"};
            escreverLinha(linha, titulos);
        }
        return aba;
    }

    @Override
    public synchronized Relatorio escreverResultadosScript(ResumoScript resumo) {
        Sheet aba = abrirAba(nomeAba);
        int contagemLinha = aba.getLastRowNum() + 1;
        Row linha = aba.createRow(contagemLinha++);
        escreverLinha(linha, resumo.retornarValores());
        return relatorioExcel;
    }

    @Override
    public Relatorio escreverResultadosScripts(Object[] resumos) {
        for(Object resumo : resumos){
            escreverResultadosScript((ResumoScript)resumo);
        }
        return relatorioExcel;
    }
}

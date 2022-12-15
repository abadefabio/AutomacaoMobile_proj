package br.com.next.automacao.core.tools.planilha;

import br.com.next.automacao.core.tools.dados.ResumoTestes;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellReference;

public class RelatorioTestesExcel extends RelatorioExcel implements RelatorioTestes, Excel{

    private Excel relatorio;
    private String nomeAba;
    private int indiceColuna;

    public RelatorioTestesExcel(Excel relatorio, String nomeAba){
        this.relatorio = relatorio;
        this.nomeAba = nomeAba;
    }

    @Override
    public Sheet abrirAba(String nomeAba){
        Sheet aba = relatorio.recuperarWorkbook().getSheet(nomeAba);
        if(aba == null){
            aba = relatorio.recuperarWorkbook().createSheet(nomeAba);
            aba.createRow(0);
        }
         if(aba.getRow(0).getLastCellNum() < 0){
            Object[] titulos ={"Conjunto Testes",
                    "Plataforma Mobile",
                    "Navegador Principal",
                    "Navegador Secundario",
                    "Device",
                    "Início Execução Bloco Testes",
                    "Fim Execução Bloco Testes",
                    "Duração da Thread",
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
            escreverColuna(aba,0, titulos);
            this.indiceColuna = 1;
         }
        return aba;
    }

    @Override
    public RelatorioScript escreverResumoConjuntoTestes(ResumoTestes resumo) {
        Sheet aba = abrirAba(nomeAba);
        escreverColuna(aba,0, resumo.retornarValores());
        escreverFormulaColuna(aba,8,this.indiceColuna,montarFormulasCalculoFalhas());
        return new RelatorioScriptExcel(relatorio, nomeAba);
    }

    @Override
    public RelatorioScript escreverResumoConjuntosTestes(Object[] resumos) {
        for(Object resumo : resumos){
            this.indiceColuna++;
            escreverResumoConjuntoTestes((ResumoTestes)resumo);
        }
        return new RelatorioScriptExcel(relatorio, nomeAba);
    }

    private String[] montarFormulasCalculoFalhas(){
        String coluna = CellReference.convertNumToColString(indiceColuna);
        return new String[]{ "COUNTIFS(F20:F232,\"Massa\",C20:C232," + coluna + "1)",
                "SUMIFS(D20:D232,C20:C232," + coluna + "1,F20:F232,\"Massa\")",
                "COUNTIFS(F20:F232,\"Ambiente\",C20:C232," + coluna + "1)",
                "SUMIFS(D20:D232,C20:C232," + coluna + "1,F20:F232,\"Ambiente\")",
                "COUNTIFS(F20:F232,\"Bug\",C20:C232," + coluna + "1)",
                "SUMIFS(D20:D232,C20:C232," + coluna + "1,F20:F232,\"Bug\")",
                "COUNTIFS(F20:F232,\"Script\",C20:C232," + coluna + "1)",
                "SUMIFS(D20:D232,C20:C232," + coluna + "1,F20:F232,\"Script\")",
                "COUNTIFS(F20:F232,\"Outros\",C20:C232," + coluna + "1)",
                "SUMIFS(D20:D232,C20:C232," + coluna + "1,F20:F232,\"Outros\")"
        };
    }
}

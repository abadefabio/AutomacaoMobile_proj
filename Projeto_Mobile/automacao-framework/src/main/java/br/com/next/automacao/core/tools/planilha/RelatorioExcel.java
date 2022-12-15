package br.com.next.automacao.core.tools.planilha;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;

import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static br.com.next.automacao.core.tools.ReadProperties.getProperty;

public class RelatorioExcel implements Excel {

    private Workbook workbook;
    private FileInputStream streamArquivoEntrada;
    private String nomeArquivo;
    private Sheet aba;

    public RelatorioExcel(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
        try {
            this.streamArquivoEntrada = new FileInputStream(new File(obterCaminhoArquivo(nomeArquivo)));
            if(workbook == null)
                workbook = WorkbookFactory.create(streamArquivoEntrada);
        } catch(FileNotFoundException e){
            Reporter.log("Não foi possível encontrar o arquivo " + nomeArquivo + " na máquina. Iniciando um novo Workbook!", true);
            if(workbook == null)
                workbook = new XSSFWorkbook();
        }catch (IOException ex) {
            Reporter.log("Não foi possível abrir o arquivo " + nomeArquivo, true);
            ex.printStackTrace();
        }
    }

    public RelatorioExcel(){
        this.nomeArquivo = "Relatório Execução-" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) +".xlsx";
        if(workbook == null)
            workbook = new XSSFWorkbook();
    }

    @Override
    public String obterCaminhoArquivo(String nomeArquivo) {
        String caminhoBase;
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            caminhoBase = getProperty("path.base.windows");
        } else {
            caminhoBase = getProperty("path.base.mac");
        }

        String caminhoEvidencia = (caminhoBase + getProperty("path.evidencia")).toLowerCase();
        return caminhoEvidencia + nomeArquivo;
    }

    @Override
    public Relatorio finalizar() {
        if(streamArquivoEntrada != null){
            try {
                streamArquivoEntrada.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }

    protected void escreverColuna(Sheet aba, int numeroPrimeiraLinha, Object... arrayValores){
        Row linha;
        if(aba.getLastRowNum() == -1)
            linha = aba.createRow(numeroPrimeiraLinha);
        else
            linha = aba.getRow(numeroPrimeiraLinha);
        Cell celula;
        int indiceLinha = numeroPrimeiraLinha - 1;
        int indiceColuna = linha.getLastCellNum();
        if(indiceColuna == -1) indiceColuna++;
        for(Object valor : arrayValores){
            indiceLinha++;
            linha = aba.getRow(indiceLinha);
            linha = linha == null ? aba.createRow(indiceLinha) : linha;
            celula = linha.createCell(indiceColuna);
            definirValorCelula(celula, valor);
        }
    }

    protected void escreverFormulaColuna(Sheet aba, int numeroPrimeiraLinha, int indiceColuna, String... arrayFormulas){
        Row linha;
        Cell celula;
        int indiceLinha = numeroPrimeiraLinha - 1;
        for(String formula : arrayFormulas){
            indiceLinha++;
            linha = aba.getRow(indiceLinha);
            linha = linha == null ? aba.createRow(indiceLinha) : linha;
            celula = linha.createCell(indiceColuna);
            celula.setCellFormula(formula);
        }
    }

    protected void escreverLinha(Row linha, Object... arrayValores){
        Cell celula;
        int contagemColuna = 0;
        for(Object valor : arrayValores){
            celula = linha.createCell(contagemColuna++);
            definirValorCelula(celula, valor);
        }
    }

    protected void escreverFormulasLinha(Row linha, int contagemColuna, String... arrayFormulas){
        Cell celula;
        contagemColuna -= 1;
        for(String formula : arrayFormulas){
            celula = linha.createCell(contagemColuna++);
            celula.setCellFormula(formula);
        }
    }

    @Override
    public synchronized void salvar() {
        try (FileOutputStream outputStream = new FileOutputStream(obterCaminhoArquivo(nomeArquivo))) {
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Workbook recuperarWorkbook() {
        return this.workbook;
    }

    @Override
    public Sheet abrirAba(String nomeAba) {
        aba = this.workbook.getSheet(nomeAba);
        return aba;
    }

    private void definirValorCelula(Cell celula, Object valor){
        if(valor == null){
            celula.setCellValue("");
        }else if(valor instanceof String){
            celula.setCellValue((String) valor);
        }else if(valor instanceof Integer){
            celula.setCellValue((Integer) valor);
        }else if(valor instanceof LocalDateTime){
            celula.setCellValue((LocalDateTime)valor);
        }else if(valor instanceof LocalTime){
            CreationHelper ajudaCriacao = workbook.getCreationHelper();
            CellStyle configuracaoCelula = workbook.createCellStyle();
            configuracaoCelula.setDataFormat(ajudaCriacao.createDataFormat().getFormat("HH:MM:SS"));
            String valorInformado = ((LocalTime) valor).format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            celula.setCellValue(DateUtil.convertTime(valorInformado));
            celula.getCellStyle().cloneStyleFrom(configuracaoCelula);
        }
    }
}

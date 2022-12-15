package br.com.next.automacao.core.tools.planilha;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public interface Excel extends Relatorio{

    Workbook recuperarWorkbook();

    Sheet abrirAba(String nomeAba);
}

package br.com.next.automacao.core.tools.pdf;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

/**
 * Classe para leitura de documentos emformato PDF
 *
 * @author Lucas Santos
 * @since 02-2020
 */
public class LeitorPdf {

    /**
     * Abre e lê documento PDF e retorna o texto encontrado
     *
     * @param path caminho do arquivo
     * @return texto do arquivo em formato String
     * @throws IOException
     */
    public String lerDocumento(String path) throws IOException {

        //Carregando documento existente
        File file = new File( path );
        PDDocument document = PDDocument.load( file );

        //Instanciando a classe PDFTextStripper
        PDFTextStripper pdfTextStripper = new PDFTextStripper();

        //Recuperando o texto do documento PDF
        String texto = pdfTextStripper.getText( document );

        //Fechando o documento
        document.close();

        return texto;
    }
}

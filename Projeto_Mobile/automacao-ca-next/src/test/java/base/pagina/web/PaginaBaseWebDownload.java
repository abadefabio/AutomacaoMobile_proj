package base.pagina.web;

import br.com.next.automacao.core.base.web.PaginaBaseWeb;
import br.com.next.automacao.core.drivers.OperadorDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tools.Tempo;
import java.io.File;
import java.util.*;

public class PaginaBaseWebDownload extends PaginaBaseWeb {

    public PaginaBaseWebDownload(WebDriver driver) {
        super(driver);
    }

    /**
     * Método responsável por fazer downloads de arquivos
     *
     * @param link            Link dos arquivos
     * @param partialFileName Nome parcial dos arquivos
     * @return Retorna uma coleção de arquivos
     * @throws Exception
     */
    protected Set<File> download(WebElement link, String partialFileName) throws Exception {
        return download(link, partialFileName, 1, 0);
    }

    /**
     * Método responsável por fazer downloads de arquivos
     *
     * @param link             Link dos arquivos
     * @param partialFileName  Nome parcial dos arquivos
     * @param qtyExpectedFiles Quantidade esperada de arquivos
     * @return Retorna uma coleção de arquivos
     * @throws Exception
     */
    protected Set<File> download(WebElement link, String partialFileName, int qtyExpectedFiles) throws Exception {
        return download(link, partialFileName, qtyExpectedFiles, 0);
    }

    /**
     * Método responsável por fazer downloads de arquivos
     *
     * @param link              Link dos arquivos
     * @param partialFileName   Nome parcial dos arquivos
     * @param qtyExpectedFiles  Quantidade esperada de arquivos
     * @param additionalTimeout Tempo adicional para aguardar o download dos arquivos
     * @return Retorna uma coleção de arquivos
     * @throws Exception
     */
    protected Set<File> download(WebElement link, String partialFileName, int qtyExpectedFiles, int additionalTimeout) throws Exception {

        File downloadFolder = OperadorDriver.getPastaDownloadBrowser();
        additionalTimeout = Math.max(0, additionalTimeout);

        List<File> filesBefore = getFilesInDirectory(downloadFolder, partialFileName);

        clicarElemento(link,"Erro ao clicar no elemento para o download");

        // Aguardamos o download finalizar ou até expirar o tempo
        Set<File> filesAfter = new HashSet<>();
        Tempo tempo = new Tempo((30 + additionalTimeout)*1000L);
        while(tempo.resta()) {
            filesAfter.addAll(getFilesInDirectory(downloadFolder, partialFileName));
            if (filesAfter.size() > filesBefore.size() + qtyExpectedFiles) {
                break;
            }
            tempo.dormir(1000);
        }

        filesBefore.forEach(filesAfter::remove);
        return filesAfter;
    }

    /**
     * Método responsável por retornar arquivos de determinado diretório
     *
     * @param directory       Caminho do diretório
     * @param partialFileName Nome parcial dos arquivos
     * @return Retorna uma lista de arquivos
     */
    protected List<File> getFilesInDirectory(File directory, String partialFileName) {

        if (!directory.isDirectory())
            return new ArrayList<>();

        List<File> matchingFiles = new ArrayList<>();
        List<File> files = new ArrayList<>(Arrays.asList(Objects.requireNonNull(directory.listFiles())));

        for (File file : files) {
            String fileName = file.getName().toLowerCase(Locale.ROOT);
            if (fileName.contains(partialFileName.toLowerCase(Locale.ROOT))) {
                if (!fileName.endsWith(".crdownload"))
                    matchingFiles.add(file);
            }
        }

        return matchingFiles;
    }

    /**
     * Método responsável por deletar arquivos
     *
     * @param files        Lista contendo os arquivos a ser deletados
     * @param ignoreErrors Booleano (true/false) responsável por ignorar ou não a apresentação de erros
     * @return Retorna uma lista de arquivos
     */
    protected List<File> deleteFiles(List<File> files, boolean ignoreErrors) {
        for (File file : files) {
            try {
                file.delete();
            } catch (Exception e) {
                if (!ignoreErrors)
                    System.out.println(e.getMessage());
            }
        }
        return files;
    }
}

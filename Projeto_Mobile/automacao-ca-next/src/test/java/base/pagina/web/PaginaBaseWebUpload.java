package base.pagina.web;

import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.exception.NextException;
import org.openqa.selenium.WebDriver;
import tools.Tempo;

import java.io.*;
import java.util.Base64;

public class PaginaBaseWebUpload extends PaginaBaseWebDownload {

    public PaginaBaseWebUpload(WebDriver driver) {
        super(driver);
    }

    /**
     * M�todo para criar e salvar um arquivo em pasta tempor�ria do sistema operacional Windows,
     * que recebe uma string de Base64 que representa o conte�do do arquivo, e uma extens�o de arquivo.
     * O nome do arquivo a ser criado e salvo ser� determinado automaticamente na pasta tempor�ria.
     * e ser� �nico, contendo o seguinte formato:
     * Exemplo: 50000-88349584855 (n�mero do caso de teste - timestamp em nano-segundos)
     * @param arquivoBase64
     * @param extensao
     * @throws NextException
     */
    protected synchronized void informarArquivoUploadDialogWindows(String arquivoBase64, String extensao) throws NextException, IOException, InterruptedException {
        informarArquivoUploadDialogWindows(
                arquivoBase64,
                extensao,
                TesteBase.getCasoTeste().getCasoId() + "-" +
                        System.nanoTime());
    }

    /**
     * M�todo para criar e salvar um arquivo em pasta tempor�ria do sistema operacional Windows,
     * que recebe uma string de Base64 que representa o conte�do do arquivo, uma extens�o de arquivo e
     * o nome simples do arquivo sem a extens�o.
     * A string de Base64 � convertida, e o arquivo � salvo na pasta tempor�ria.
     * @param arquivoBase64
     * @param extensao
     * @param nomeArquivo
     * @throws NextException
     */
    protected synchronized void informarArquivoUploadDialogWindows(String arquivoBase64, String extensao, String nomeArquivo) throws NextException, IOException, InterruptedException {

        if (!System.getProperty("os.name").toLowerCase().contains("win")) {
            throw new NextException("Este m�todo requer a plataforma Windows!", new Exception());
        }

        String nomeArquivoCompleto = System.getProperty("java.io.tmpdir") + nomeArquivo + "." + extensao;
        informarArquivoUploadDialogWindows(salvarString64Arquivo(arquivoBase64, nomeArquivoCompleto));
    }

    /**
     * M�todo para informar um nome completamente qualificado de arquivo existente para
     * efetuar o upload.
     * @param nomeCompletoArquivo
     * @throws NextException
     * @throws IOException
     */
    public void informarArquivoUploadDialogWindows(String nomeCompletoArquivo) throws NextException, IOException, InterruptedException {
        informarArquivoUploadDialogWindows(new File(nomeCompletoArquivo));

    }

    /**
     * M�todo para fazer upload de um arquivo de tamanho e extens�o espec�ficos
     * O m�todo cria o arquivo com o tamanho informado em KB em executa o upload.
     * @throws NextException
     * @throws IOException
     */
    public void informarArquivoDummyUploadDialogWindows(String extensao, long sizeKB) throws NextException, IOException, InterruptedException {
    informarArquivoUploadDialogWindows(criarArquivoTemporarioParaUpload(extensao,sizeKB));
    }

    /**
     * M�todo que efetua o upload de um arquivo File informado.
     * @param file
     * @throws NextException
     * @throws IOException
     */
    public void informarArquivoUploadDialogWindows(File file) throws NextException, IOException, InterruptedException {

        if (!System.getProperty("os.name").toLowerCase().contains("win")) {
            throw new NextException("Este m�todo requer a plataforma Windows!", new Exception());
        }

        String nomeArquivoCompletoScriptVbs = file.getCanonicalPath().toString() + ".vbs";

        String vbScript =   "Set WshShell = WScript.CreateObject(\"WScript.Shell\")\n" +
                            "WshShell.SendKeys \""+ file.getCanonicalPath() + "\"\n" +
                            "WshShell.SendKeys \"{ENTER}\"\n";
        try (OutputStream stream = new FileOutputStream(nomeArquivoCompletoScriptVbs)) {
            stream.write(vbScript.getBytes());
        } catch (Exception e) {
            throw new NextException("N�o foi poss�vel criar o arquivo de script para execu��o.", e);
        }
        Thread.sleep(5000);
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("cscript " + nomeArquivoCompletoScriptVbs);
        } catch (IOException e) {
            throw new NextException("Houve um problema ao executar o script de buffer de teclado!",
                    new Exception());
        }
    }

    /**
     * M�todo para converter uma String de base 64 diretamente para arquivo no sistema de
     * arquivos, tomando como base a string de base 64 e o nome completamente qualificado do arquivo.
     * @param base64
     * @param nomeArquivoCompleto
     * @return
     * @throws NextException
     */
    private File salvarString64Arquivo(String base64, String nomeArquivoCompleto) throws NextException {

        byte[] data = Base64.getDecoder().decode(base64);
        boolean arquivoCriado = false;
        Tempo tempo = new Tempo(10000);
        while (!arquivoCriado && tempo.resta()) {
            try (OutputStream stream = new FileOutputStream(nomeArquivoCompleto)) {
                stream.write(data);
                arquivoCriado = true;
            } catch (Exception ignore) {

            }
            tempo.dormir(200);
        }

        if (!arquivoCriado) {
            throw new NextException("Houve uma falha com a prepara��o do arquivo de upload!",
                    new Exception());
        }

        return new File(nomeArquivoCompleto);
    }

    /**
     * Cria um arquivo com tamanho dinamico
     *
     * @param extensao
     * @param sizeInKb
     * @return S
     * @throws IOException
     */
    public String criarArquivoTemporarioParaUpload(final String extensao, final long sizeInKb) throws IOException {
        String filename = TesteBase.getCasoTeste().getCasoId() + "-" + System.nanoTime() + "." + extensao;

        File file = new File(System.getProperty("java.io.tmpdir"),filename);
        file.createNewFile();

        if(sizeInKb>0) {
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            raf.setLength(sizeInKb*1024);
            raf.close();
        }
        return file.getAbsoluteFile().toString();
    }

}

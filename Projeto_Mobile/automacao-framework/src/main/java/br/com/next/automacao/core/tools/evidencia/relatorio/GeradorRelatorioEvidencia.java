package br.com.next.automacao.core.tools.evidencia.relatorio;

import br.com.next.automacao.core.drivers.OperadorDriver;
import br.com.next.automacao.core.tools.evidencia.NextEvidencia;
import br.com.next.automacao.core.tools.evidencia.RelatorioEvidencia;
import br.com.next.automacao.core.tools.evidencia.TipoEvidencia;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.testng.Reporter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static br.com.next.automacao.core.base.TesteBase.getCasoTeste;
import static br.com.next.automacao.core.tools.ReadProperties.getProperty;

/**
 * Gera o arquivo com as evidências de teste
 *
 * @author Lucas Santos
 * @version 1.0
 * @since 2020-02
 */

public class GeradorRelatorioEvidencia {

    /**
     * Gera o documento de evidência (PDF ou HTML)
     *
     * @param relatorioEvidencia objeto de relatório
     * @param tipoEvidencia      tipo de arquivo a ser gerado
     * @throws IOException em caso de falha com arquivos ou diretórios
     */
    public static void gerarRelatorioEvidencia(RelatorioEvidencia relatorioEvidencia, TipoEvidencia tipoEvidencia, String nomeArquivo) throws IOException {

        List<NextEvidencia> data = relatorioEvidencia.getEvidenceList();

        String caminhoEvidencia = getCasoTeste().getCaminhoEvidencia();
        String caminhoJornada = getCasoTeste().getCaminhoJornada();
        String caminhoEvidenciaCt = getCasoTeste().getCaminhoEvidenciaCt();

        criarDiretorioEvidencia(caminhoEvidencia);
        criarDiretorioEvidencia(caminhoJornada);
        criarDiretorioEvidencia(caminhoEvidenciaCt);

        try {

            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            BufferedImage imagemNext = ImageIO.read(classLoader.getResourceAsStream(getProperty("path.logo")));

            String reportName = relatorioEvidencia.getCasoTeste();
            if (reportName == null) {
                reportName = "";
            }

            String tester = relatorioEvidencia.getTester();
            if (tester == null) {
                tester = "";
            }

            String nomeCt = relatorioEvidencia.getNomeCt();
            if (nomeCt == null) {
                nomeCt = "";
            }

            String objetivoCt = relatorioEvidencia.getObjetivoCt();
            if (objetivoCt == null) {
                objetivoCt = "";
            }

            String jornada = relatorioEvidencia.getJornada();
            if (jornada == null) {
                jornada = "";
            }

            String excecao = relatorioEvidencia.getExceptionString();
            if (excecao == null) {
                excecao = "";
            }

            Map<String, Object> parameters = new HashMap<String, Object>();

            parameters.put("NEXT_EXCEPTION", excecao); // pode aceitar nulo porque Jasper Report file trata

            String tempoExecucaoCt = relatorioEvidencia.getTempoExecucaoCt();
            if (tempoExecucaoCt == null) {
                tempoExecucaoCt = "";
            }

            String plataforma = relatorioEvidencia.getPlataformaCt();
            if (plataforma == null) {
                plataforma = "";
            }

            String nomeAparelho = relatorioEvidencia.getNomeDispositivo();
            if (nomeAparelho == null) {
                nomeAparelho = "";
            }

            String udid = relatorioEvidencia.getUdidDispositivo();
            if (udid == null) {
                udid = "";
            }

            parameters.put("NEXT_COMPANY_LOGO", imagemNext);
            parameters.put("NEXT_PROJECT", " " + jornada.toLowerCase());
            parameters.put("NEXT_TESTER", " " + tester);

            parameters.put("NEXT_LABEL_EVIDENCE_TITLE", "Evidência de Teste");
            parameters.put("NEXT_LABEL_PROJECT", " Jornada:");
            parameters.put("NEXT_LABEL_TESTER", " Executor:");
            parameters.put("NEXT_LABEL_STATUS", " Resultado:");
            parameters.put("NEXT_LABEL_PASS", "SUCESSO");
            parameters.put("NEXT_LABEL_FAILED", "FALHA");
            parameters.put("NEXT_LABEL_EVIDENCE_REPORT", reportName);
            parameters.put("NEXT_LABEL_DATE", " Data:");
            parameters.put("NEXT_LABEL_FOOTER", "Automação de Testes - Banco next");
            parameters.put("NEXT_LABEL_ERROR_DETAIL", "Detalhes do Erro:");
            parameters.put("NEXT_LABEL_PAGE", "Página");
            parameters.put("NEXT_LABEL_COMPANY_NAME", "QA-" + reportName);
            parameters.put("NEXT_LABEL_CT_NAME", nomeCt);
            parameters.put("NEXT_TEMPO_EXECUCAO", tempoExecucaoCt);
            parameters.put("NEXT_LABEL_EXEC_TIME", "T. Execução:");
            parameters.put("NEXT_PLATAFORMA", plataforma);
            parameters.put("NEXT_LABEL_PLATAFORMA", "Plataforma:");
            parameters.put("NEXT_APARELHO", nomeAparelho);
            parameters.put("NEXT_LABEL_DEVICE", "Dispositivo:");
            parameters.put("NEXT_UDID", udid);
            parameters.put("NEXT_LABEL_UDID", "UDID:");
            if (OperadorDriver.isDeviceEmulador())
                // pode não ser definido, sem problema, porque o campo do arquivo Jasper trata
                parameters.put("DEVICE_EMULADOR","TESTE EXECUTADO EM DISPOSITIVO EMULADO, NÃO VÁLIDO PARA GARANTIA DE QUALIDADE FINAL DA FEATURE");

            JasperPrint jasperPrint = JasperFillManager
                    .fillReport(classLoader.getResourceAsStream(getProperty("path.modelo")),
                            parameters,
                            new JRBeanCollectionDataSource(data)
                    );


            Reporter.log("===============================================", true);
            switch (tipoEvidencia) {
                case PDF:
                    String arquivoEvidenciaPdf = caminhoEvidenciaCt + nomeArquivo + ".pdf";
                    JasperExportManager.exportReportToPdfFile(jasperPrint, arquivoEvidenciaPdf);
                    Reporter.log("Evidência gerada em: " + arquivoEvidenciaPdf, true);
                    getCasoTeste().adicionarArquivoEvidencia(arquivoEvidenciaPdf);
                    break;
                case HTML:
                    String arquivoEvidenciaHtml = caminhoEvidenciaCt + nomeArquivo + ".html";
                    JasperExportManager.exportReportToHtmlFile(jasperPrint, arquivoEvidenciaHtml);
                    Reporter.log("Evidência gerada em: " + arquivoEvidenciaHtml, true);
                    getCasoTeste().adicionarArquivoEvidencia(arquivoEvidenciaHtml);
                    break;
                default:
                    break;
            }

        } catch (SecurityException | JRException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Cria o diretório para armazenar as evidências
     *
     * @param diretorio caminho do diretório
     * @return existência ou não do diretório
     */
    public static boolean criarDiretorioEvidencia(String diretorio) {
        boolean dirExiste = false;

        try {
            File dir = new File(diretorio);
            boolean existe = dir.exists();

            if (!existe) {
                dir.mkdir();
                dirExiste = false;
            } else {
                dirExiste = true;
            }
        } catch (SecurityException se) {
            se.printStackTrace();
        }
        return dirExiste;
    }
}

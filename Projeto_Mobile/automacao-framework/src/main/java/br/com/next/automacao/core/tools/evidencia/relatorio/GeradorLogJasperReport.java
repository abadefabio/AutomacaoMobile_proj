package br.com.next.automacao.core.tools.evidencia.relatorio;

import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.tools.evidencia.NextEvidencia;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static br.com.next.automacao.core.base.TesteNext.getCasoTeste;
import static br.com.next.automacao.core.tools.evidencia.relatorio.GeradorRelatorioEvidencia.criarDiretorioEvidencia;

/**
 * Classe responsável por gerar o log ao final das demais evidências de teste
 */
public class GeradorLogJasperReport {

    // Menor imagem PNG possível em Base64 (1x1 com 8 bits)
    final static String menorImagemPngPossivel = "iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HA" +
                                          "wCAAAAC0lEQVQYV2NgYAAAAAMAAWgmWQ0AAAAASUVORK5CYII=";

    /**
     * Gera páginas adicionais de evidência para comportar o log de execução
     * no relatório final pdf
     * @param log
     */
    public static void gerarLogRelatorio(List<String> log) {

        /*
        Este gerador:
        1. Obtém o log total do TestNG recebido por parâmetro;
        2. Calcula o número de páginas que o log deverá ocupar
        baseado na fonte monospace e no tamanho do campo texto
        disponível no layout do Jasper Reports em uso.
        3. Para cada página, adiciona uma linha na lista NextEvidencia utilizada pelo Jasper,
        produzindo assim, as páginas que forem necessárias para imprimir todoo o log
         */

        int maxCols = 100;

        // Cria log detalhado final com quebras de linha \n existentes
        List<String> logQuebrasLinha = new ArrayList<>();
        {
            for (String item : log) {
                logQuebrasLinha.addAll(
                        Arrays.asList(
                                item.split("\n")
                        )
                );
            }
        }

        // Para cada linha, verificar se é maior que maxCols e quebrar novamente
        List<String> logFinal = new ArrayList<>();
        for (String item : logQuebrasLinha) {
            if (item.length() <= maxCols) {
                logFinal.add(item);
            } else {
               String[] itensQuebrados = item.split("(?<=\\G.{" + maxCols + "})");
               logFinal.addAll(
                       Arrays.asList(
                               itensQuebrados
                       )
               );
            }
        }

        final int maxLinhas = 63;
        int maxLog = logFinal.size();

        // Separa em páginas
        int contadorLinhas = 0;
        String pagina = "";
        List<String> paginas = new ArrayList<>();
        int indiceGeralLog = 0;
        for (String linha : logFinal) {
            pagina = pagina.concat(linha).concat("\n");
            indiceGeralLog++;
            contadorLinhas++;
            if (maxLog <= indiceGeralLog) {
                // última página incompleta
                paginas.add(pagina);
                break;
            }
            if (contadorLinhas >= maxLinhas) {
                // quando a página tem mais de maxLinhas e continua
                paginas.add(pagina);
                pagina = "";
                contadorLinhas = 0;
            }
        }

        // Para cada página, adicionar um NextEvidencia com título (PASSO) e log (LOG)
        // Tags PASSO e LOG são utilizadas nas expressões do arquivo .jasper
        int totalPaginas = paginas.size();
        for (int numPaginaAtual = 1; numPaginaAtual <= totalPaginas; numPaginaAtual++) {
            String titulo = "|PASSO|Log - Parte " + numPaginaAtual + " de " + totalPaginas + "|/PASSO|";
            String textoEvidencia = titulo + "|LOG|" + paginas.get(numPaginaAtual-1) + "|/LOG|";
            NextEvidencia nextEvidencia = new NextEvidencia(textoEvidencia, menorImagemPngPossivel);
            TesteBase.getEvidencia().add(nextEvidencia);
        }

    }

}

package br.com.next.automacao.core.tools;

import br.com.next.automacao.core.tools.Utilitarios;
import org.junit.jupiter.api.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ValueRange;
import java.util.Random;

import static br.com.next.automacao.core.tools.Utilitarios.proximoFeriado;

public class TestarUtilitarios {
    @RepeatedTest(value = 10, name = RepeatedTest.LONG_DISPLAY_NAME)
    void numeroAleatorio_NumeroEntreMinimoEtMaximo(TestInfo testInfo) throws InterruptedException {
        /*
        Foi verificado que n?o ? poss?vel gerar um n?mero no intervalo
        se for <= 0. Recomenda-se alterar o m?todo para testar
        toda a faixa de valores int do Java.
         */
        Random randMinimo = new Random();
        Random randMaximo = new Random();
        for (int i=9; i>=0; i--) {
            // Loop para gerar n?meros com diferentes quantidades de casas inteiras
            double faixa = (double) (2147483647 / Math.pow(10, i));
            int maximo = randMaximo.nextInt((int)faixa);
            if (maximo == 0) maximo++; // m?todo sob teste n?o aceita <=0
            int minimo = randMinimo.nextInt(maximo);
            if (minimo == 0) minimo++; // m?todo sob teste n?o aceita <=0
            minimo = Math.min(minimo, maximo);
            int numeroAleatorio = br.com.next.automacao.core.tools.Utilitarios.numeroAleatorio(minimo, maximo);
            Assertions.assertTrue(ValueRange.of(minimo, maximo).isValidIntValue(numeroAleatorio));
        }
    }

    /**
     * Valida se o m?todo dataAtual() retorna a data atual
     * no formato "yyyy-MM-dd"
     */
    @RepeatedTest(value = 1, name = RepeatedTest.LONG_DISPLAY_NAME)
    void dataAtual_RetornaDataHojeYYYYMMDD() {
        String dataAtualRetornada = br.com.next.automacao.core.tools.Utilitarios.dataAtual();

        LocalDate dataAtual = LocalDate.now();
        Assertions.assertEquals(dataAtual.getYear(),
                Integer.parseInt(dataAtualRetornada.split("-")[0])); // expected, actual
        Assertions.assertEquals(dataAtual.getMonthValue(),
                Integer.parseInt(dataAtualRetornada.split("-")[1])); // expected, actual
        Assertions.assertEquals(dataAtual.getDayOfMonth(),
                Integer.parseInt(dataAtualRetornada.split("-")[2])); // expected, actual
    }

    /**
     * Valida se o pr?ximo feriado ? retornado para cada data do
     * ano, partindo de "hoje" at? a data anterior ao ?ltimo feriado cadastrado.
     */
    @Test
    @DisplayName("Testar proximoFeriado() todos os dias at? antes do ?ltimo feriado cadastrado.")
    void proximoFeriado_HojeSeFeriadoOuProximoFeriadoDepoisDeHoje() {

        LocalDate[] feriados = {LocalDate.of(2021, 1, 1),
                LocalDate.of(2021, 2, 15),
                LocalDate.of(2021, 2, 16),
                LocalDate.of(2021, 4, 2),
                LocalDate.of(2021, 4, 21),
                LocalDate.of(2021, 5, 1),
                LocalDate.of(2021, 6, 3),
                LocalDate.of(2021, 9, 7),
                LocalDate.of(2021, 10, 12),
                LocalDate.of(2021, 11, 2),
                LocalDate.of(2021, 11, 15),
                LocalDate.of(2021, 12, 25)};

        /*
        Testa todas as datas desde 2 de janeiro do ano do primeiro feriado registrado
        at? o dia anterior do ?ltimo feriado registrado.
         */
        LocalDate ultimoFeriadoCadastrado = feriados[feriados.length - 1];
        LocalDate dataAtual = LocalDate.of(feriados[0].getYear(), 1, 2);
        int indiceOrdemFeriado = 0;
        while (dataAtual.isBefore(ultimoFeriadoCadastrado)) {
            while (dataAtual.isAfter(feriados[indiceOrdemFeriado])) {
                // ignorar datas cujo feriado j? passou.
                indiceOrdemFeriado++;
            }
            String proximoFeriado = proximoFeriado(dataAtual);       // ex. 10/04/2021
            LocalDate proximoFeriadoLocalDate = LocalDate.of(
                    Integer.parseInt(proximoFeriado.split("/")[2]), // 2021
                    Integer.parseInt(proximoFeriado.split("/")[1]), // 4
                    Integer.parseInt(proximoFeriado.split("/")[0])  // 10
            );
            System.out.println("Hoje: " + dataAtual.getDayOfMonth() + "." + dataAtual.getMonthValue() + " Pr?ximo feriado " + proximoFeriado);
            Assertions.assertEquals(proximoFeriadoLocalDate, feriados[indiceOrdemFeriado]);

            dataAtual = dataAtual.plusDays(1);
        }
    }

    /**
     * Valida se o pr?ximo feriado ? retornado para cada data do
     * ano, partindo de "hoje" at? a data anterior ao ?ltimo feriado cadastrado.
     */
    @Test
    @DisplayName("Testar retornarPrimeiroNome()")
    void retornarPrimeiroNome_PrimeiraPalavraAntesPrimeiraVirgula() {
        /*
        Bug: se o nome n?o contiver um sobrenome (ver 'Aninha'), ent?o o teste ir? falhar.
         */

        String[][] nomes =  {
                {"Fulano de Tal", "Fulano"},
                {"Beltrano dos Santos", "Beltrano"},
                {"Jose    Penteado", "Jose"},
                {"Ana  Silva", "Ana"},
                {"Aninha", "Aninha"} // sem sobrenome
        };

        for (int i=0; i<nomes.length; i++) {
            String nomeCompleto = nomes[i][0];
            String primeiroNomeEsperado = nomes[i][1];
            Assertions.assertEquals(primeiroNomeEsperado, br.com.next.automacao.core.tools.Utilitarios.retornarPrimeiroNome(nomeCompleto));
        }
    }

    /**
     * Valida m?todo proximoDiaUtil()
     * Objetivo do teste:
     * Obter o pr?ximo dia ?til ap?s o dia de hoje, variando o dia
     * e, para cada dia, variando o n?mero de dias a pular.
     * O dia come?a "hoje" e vai at? 30 dias ap?s
     */
    @Test
    @DisplayName("Testar proximoDiaUtil() todos os dias a partir de hoje at? +30 dias, pulando 0 at? 30 dias")
    void proximoDiaUtil_ProximoDiaUtil() {
        /*
        Detectado bug em que, no dia 4/9, ao pular 1 dia para o pr?ximo dia ?til,
        ? retornado o dia 7/9, que ? um feriado.
         */
        final LocalDate hoje = LocalDate.now();

        for (int pular = 1; pular <= 30; pular++) {
            LocalDate dataBase = LocalDate.now();

            while (dataBase.isBefore(hoje.plusDays(31))) {
                String proximoDiaUtil = br.com.next.automacao.core.tools.Utilitarios.proximoDiaUtil(dataBase, pular);
                LocalDate proximoDiaUtilLocalDate = LocalDate.of(
                        Integer.parseInt(proximoDiaUtil.split("/")[2]), // 2021
                        Integer.parseInt(proximoDiaUtil.split("/")[1]), // 4
                        Integer.parseInt(proximoDiaUtil.split("/")[0])  // 10
                );
                // O pr?ximo dia ?til n?o pode ser feriado
                String proximoFeriado = proximoFeriado(dataBase);
                System.out.println("Data base " + dataBase + " Proximo Dia Util " + proximoDiaUtil + " Proximo Feriado " + proximoFeriado(dataBase) + " Pular " + pular);
                Assertions.assertNotEquals(proximoDiaUtil, proximoFeriado);
                // O pr?ximo dia ?til n?o pode ser s?bado nem domingo
                Assertions.assertNotEquals(proximoDiaUtilLocalDate.getDayOfWeek(), DayOfWeek.SATURDAY);
                Assertions.assertNotEquals(proximoDiaUtilLocalDate.getDayOfWeek(), DayOfWeek.SUNDAY);
                dataBase = dataBase.plusDays(1);
            }

        }
    }

//    @Test
//    @DisplayName("Testar reformatarValorMonetario() com valores variando de centavos a bilh?es.")
//    void reformatarValorMonetario_ValorComVirgulasEtPontosDeMilhar() {
//        String[][] valores =  {
//                {"00", "0,00"},
//                {"01", "0,01"},
//                {"014", "0,14"},
//                {"1014", "10,14"},
//                {"99914", "999,14"},
//                {"100014", "1.000,14"},
//                {"123456714", "1.234.567,14"},
//                {"12345678914", "123.456.789,14"}
//        };
//        for (int i=0; i<valores.length; i++) {
//            String valorRetornado = br.com.next.automacao.core.tools.Utilitarios.reformatarValorMonetario(valores[i][0]);
//            String valorEsperado = valores[i][1];
//            Assertions.assertEquals(valorEsperado, valorRetornado);
//        }
//    }
}

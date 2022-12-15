package br.com.next.automacao.core.tools;

import br.com.next.automacao.core.constantes.tools.geradores.agencia.BancoInstituicao;
import br.com.next.automacao.core.constantes.tools.geradores.agencia.TipoDeContaCaixaEconomicaFederal;
import br.com.next.automacao.core.constantes.tools.geradores.agencia.TipoDeContaSantander;
import br.com.next.automacao.core.exception.NextException;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import br.com.next.automacao.core.tools.geradores.agencia.AgenciaConta;
import br.com.next.automacao.core.tools.geradores.agencia.GerarAgenciaConta;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static com.google.common.math.IntMath.mod;

public class Utilitarios {

    /**
     * @return Retorna a data atual em Epoch Millis
     */
    public static String pegarDataAtualEpoch() {
        return String.valueOf(Instant.now().toEpochMilli());
    }

    /**
     * Gera um CPF válido aleatório
     *
     * @return Retorna CPF válido como String
     */
    public static String gerarCpf() {
        String iniciais = "";
        Integer numero;
        for (int i = 0; i < 9; i++) {
            numero = new Integer((int) (Math.random() * 10));
            iniciais += numero.toString();
        }
        return iniciais + calcDigVerif(iniciais);
    }

    /**
     * Método de suporte para geração de dígitos válidos
     * para CPF
     *
     * @param numero
     * @return
     */
    private static String calcDigVerif(String numero) {
        Integer primDig, segDig;
        int soma = 0, peso = 10;
        for (int i = 0; i < numero.length(); i++)
            soma += Integer.parseInt(numero.substring(i, i + 1)) * peso--;
        if (soma % 11 == 0 | soma % 11 == 1)
            primDig = new Integer(0);
        else
            primDig = new Integer(11 - (soma % 11));

        soma = 0;
        peso = 11;
        for (int i = 0; i < numero.length(); i++)
            soma += Integer.parseInt(numero.substring(i, i + 1)) * peso--;

        soma += primDig.intValue() * 2;
        if (soma % 11 == 0 | soma % 11 == 1)
            segDig = new Integer(0);
        else
            segDig = new Integer(11 - (soma % 11));
        return primDig.toString() + segDig.toString();
    }

    /**
     * Método retorna número aleatório maior que o valor mínimo informado e menor que o valor máximo
     * @param minimo
     * @param maximo
     * @return
     */
    public static int numeroAleatorio(int minimo, int maximo) {
        return (int) Math.floor(Math.random() * (maximo - minimo + 1)) + minimo;
    }


    /**
     * Recupera a data atual no padrão americano
     *
     * @return Data atual no formato americano
     */
    public static String dataAtual() {
        Date data = Calendar.getInstance().getTime();

        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strData = sdf.format(data);
        return strData;
    }

    /**
     * Método para encontrar o próximo feriado
     *
     * @return próximo feriado no formato "dd/MM/yyyy"
     */
    private static LocalDate proximoFeriadoLocalDate(LocalDate data) {
        //ATUALIZAR A LISTA DE FERIADOS NO COMEÇO DE CADA ANO
        LocalDate proximoFeriado = null;
        int anoAtual = data.getYear();
        Set<LocalDate> feriadosFixosAnoAtual = retornaFeriadosFixos(anoAtual);
        Set<LocalDate> feriadosFixosAnoProximo = retornaFeriadosFixos(anoAtual + 1);
        Set<LocalDate> feriadosvariaveisAnoAtual = retornaFeriadosVariaveis(anoAtual);
        Set<LocalDate> feriadosvariaveisAnoProximo = retornaFeriadosVariaveis(anoAtual + 1);

        Set<LocalDate> feriados = new HashSet<>();
        feriados.addAll(feriadosFixosAnoAtual);
        feriados.addAll(feriadosvariaveisAnoAtual);
        feriados.addAll(feriadosFixosAnoProximo);
        feriados.addAll(feriadosvariaveisAnoProximo);

        List<LocalDate> listaFeriados = new ArrayList<LocalDate>(feriados);
        Collections.sort(listaFeriados);
        Iterator<LocalDate> iterator = listaFeriados.iterator();

        while(iterator.hasNext()) {
            LocalDate feriado = (LocalDate)iterator.next();
            if (data.isBefore(feriado) || data.equals(feriado)) {
                proximoFeriado = feriado;
                break;
            }
        }
        if (proximoFeriado == null) {
            OperadorEvidencia.logarPasso("ERRO! Não existe um feriado após a data de hoje");
        }
        return proximoFeriado;
    }

    /**
     * Método para retornar o próximo feriado em dia da semama
     *
     * @return feriado em dia da semama no formato: dd/MM/yyyy
     */
    public static String proximoFeriadoDiaDaSemama(){
        return proximoFeriadoDiaDaSemama("dd/MM/yyyy");
    }

    /**
     * Método para retornar o próximo feriado em dia da semama
     * @param formato - formato (pattern) ex: dd/MM/yyyy
     * @return feriado em dia da semama no formato string.
     */
    public static String proximoFeriadoDiaDaSemama(String formato){
        Locale lc = new Locale("pt","BR");
        LocalDate ld = proximoFeriadoDiaDaSemama(LocalDate.now());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formato,lc);
        return dtf.format(ld);
    }

    /**
     * Método para retornar o próximo feriado em dia da semama
     * @param data parâmetro LocalDate
     * @return feriado em dia da semama no formato LocalDate.
     */
    public static LocalDate proximoFeriadoDiaDaSemama(LocalDate data) {
        LocalDate dataFeriado = proximoFeriadoLocalDate(data);
        if(Boolean.logicalOr(dataFeriado.getDayOfWeek().equals(DayOfWeek.SATURDAY), dataFeriado.getDayOfWeek().equals(DayOfWeek.SUNDAY))) {
            dataFeriado = dataFeriado.plusDays(1L);
            return proximoFeriadoDiaDaSemama(dataFeriado);
        }
        return dataFeriado;
    }

    /**
     * Método para retornar o próximo feriado em dia de fim de semama.
     * @return feriado em dia de fim de semama no formato: dd/MM/yyyy
     */
    public static String proximoFeriadoEmDiaDeFimDeSemama(){
        return proximoFeriadoEmDiaDeFimDeSemama("dd/MM/yyyy");
    }

    /**
     * Método para retornar o próximo feriado em dia de fim de semama.
     * @param formato
     * @return feriado em dia de fim de semama no formato string.
     */
    public static String proximoFeriadoEmDiaDeFimDeSemama(String formato){
        Locale lc = new Locale("pt","BR");
        LocalDate ld = proximoFeriadoEmDiaDeFimDeSemama(LocalDate.now());
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formato,lc);
        return dtf.format(ld);
    }

    /**
     * Método para retornar o próximo feriado em dia de fim de semama.
     * @param data LocalDate
     * @return feriado em dia de fim de semama no formato LocalDate
     */
    public static LocalDate proximoFeriadoEmDiaDeFimDeSemama(LocalDate data) {
        LocalDate dataFeriado = proximoFeriadoLocalDate(data);
        while(!Boolean.logicalOr(dataFeriado.getDayOfWeek().equals(DayOfWeek.SATURDAY), dataFeriado.getDayOfWeek().equals(DayOfWeek.SUNDAY))) {
            dataFeriado = dataFeriado.plusDays(1L);
            dataFeriado = proximoFeriadoLocalDate(dataFeriado);
        }
        return dataFeriado;
    }


    /**
     * Método retorna Set com as datas de feriados fixos do Brasil no ano informado
     * @param ano
     * @return
     */
    private static Set<LocalDate> retornaFeriadosFixos(int ano){
        Set<LocalDate> datas = new HashSet<>();
        datas.add(LocalDate.of(ano, 1, 1));
        datas.add(LocalDate.of(ano, 4, 21));
        datas.add(LocalDate.of(ano, 5, 01));
        datas.add(LocalDate.of(ano, 9, 07));
        datas.add(LocalDate.of(ano, 10, 12));
        datas.add(LocalDate.of(ano, 11, 02));
        datas.add(LocalDate.of(ano, 11, 15));
        datas.add(LocalDate.of(ano, 12, 25));
        return datas;
    }

    /**
     * Método retorna Set com as datas de feriados variáveis do Brasil no ano informado
     * @param ano
     * @return
     */
    private static Set<LocalDate> retornaFeriadosVariaveis(int ano){
        Set<LocalDate> datas = new HashSet<>();

        LocalDate pascoa;
        LocalDate carnaval;
        LocalDate corpusChristi;
        LocalDate sextaFeiraSanta;

        int a = ano % 19;
        int b = ano / 100;
        int c = ano % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b -d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int n = h + l - 7 * m + 114;
        int mes = n / 31;
        int dia = (n % 31) + 1;

        pascoa = LocalDate.of(ano, mes, dia);
        carnaval = pascoa.minusDays(47);
        corpusChristi = pascoa.plusDays(60);
        sextaFeiraSanta = pascoa.minusDays(2);

        datas.add(carnaval.minusDays(1));
        datas.add(carnaval);
        datas.add(carnaval.plusDays(1));
        datas.add(sextaFeiraSanta);
        datas.add(pascoa);
        datas.add(corpusChristi);

        return datas;
    }

    /**
     * Método retorna próximo feriado a partir de data informada
     * @param data
     * @return
     */
    public static String proximoFeriado(LocalDate data) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return proximoFeriadoLocalDate(data).format(formatter);
    }

    /**
     * Método retorna próxima feriado a partir da data atual
     * @return
     */
    public static String proximoFeriado() {
        return proximoFeriado(LocalDate.now());
    }

    /**
     * Método retorna data e hora atual no formato dd/MM/yyy HH:mm:ss
     * @return
     */
    public static String retornarDataHoraAtual(){
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return  dtf2.format(LocalDateTime.now());

    }

    /**
     * Método para retornar o próximo dia útil
     *
     * @param pular - quantidade de dias a serem pulados a partir de amanhã, deixar 0 para nenhum
     * @return data no formato dd/MM/yyyy
     */
    protected static String proximoDiaUtil(LocalDate data, int pular) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        data = data.plusDays(pular);
        while(data.getDayOfWeek().equals(DayOfWeek.SATURDAY) || data.getDayOfWeek().equals(DayOfWeek.SUNDAY)
                    || data.equals(proximoFeriadoLocalDate(data))) {

            data = data.plusDays(1);
        }
        return data.format(formatter);
    }

    /**
     * Método retorna próximo dia útil a partir da data atual
     * @param pular - Quantidade de dias a serem pulados entre a data atual e o próximo dia útil retornado
     * @return
     */
    public static String proximoDiaUtil(int pular) {
        pular = Math.min(1, pular);
        return proximoDiaUtil(LocalDate.now(), pular);
    }

    /**
     * Método retorna o próxima dia útil
     * @return
     */
    public static String proximoDiaUtil() {
        return proximoDiaUtil(LocalDate.now(), 1);

    }
    /**
     * Função para retornar um dia util
     * @param diasAdicao - adiciona dias para retorno da data
     * @param formato - recebe o formato da data Ex: "yyyy-MM-dd, EEEE"
     * @return
     */
    public static String retornaDataDiaUtil(int diasAdicao, String formato){
        LocalDateTime localDateTime = LocalDateTime.now().plusDays(diasAdicao);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(formato);
        if(localDateTime.getDayOfWeek().equals(DayOfWeek.SATURDAY))
            return dateTimeFormatter.format(localDateTime.plusDays(2L));
        if(localDateTime.getDayOfWeek().equals(DayOfWeek.SUNDAY))
            return dateTimeFormatter.format(localDateTime.plusDays(1L));
        return dateTimeFormatter.format(localDateTime);

    }

    /**
     * Função para retornar um dia util
     * @param diasAdicao - adiciona dias para retorno da data
     * @return
     */
    public static String retornaDataDiaUtil(int diasAdicao){
        return retornaDataDiaUtil(diasAdicao, "dd/MM/yyyy");
    }


    /**
     * Retorna nome aleatório de uma lista, somente com letras
     *
     * @return nome
     * @throws Exception
     */
    public static String gerarNomeAleatorio() throws Exception {
        Map<Integer, String> listaNome = new HashMap();
        listaNome.put(0, "ABCWERICSON");
        listaNome.put(1, "FULANOFGY");
        listaNome.put(2, "MATMEGSON");
        listaNome.put(3, "QWRTAUNAY");
        listaNome.put(4, "VBYUHOBERTSON");
        listaNome.put(5, "POULOCTRO");
        return listaNome.get((int) (Math.random() * 5));
    }

    /**
     * Remove caracteres não numéricos de String contendo número
     *
     * @param numero
     * @return
     */
    public static String normalizaStringNumero(String numero) {
        return numero.replaceAll("[^0-9]", "").replace(" ", "");

    }

    /**
     * Normaliza String, deixando todas as letras maiúsculas e mantendo apenas caracteres alphanuméricos
     *
     * @param texto
     * @return
     */
    public static String normalizaString(String texto) {
        return texto.toUpperCase().replace("&#10;", " ").replaceAll("[^A-Z0-9]+", "");
    }

    /**
     * Gerar número de celular valido
     *
     * @return
     */
    public static String gerarNumeroCelular() {
        Random gerador = new Random();
        String celular = "";

        for (int i = 0; i < 8; i++) {
            celular += gerador.nextInt(9);

        }
        return "9" + celular;
    }

    /**
     * Gerador de Palavras pronunciáveis
     *
     * @param tamanho
     * @return
     */
    public static String geradorPalavra(int tamanho) {
        String[] consoantes = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "r", "s", "t", "v", "w", "x", "z"};
        String[] vogais = {"a", "e", "i", "o", "u"};
        String palavra = "";

        for (int i = 0; i <= tamanho / 2; i++) {
            palavra += vogais[(int) Math.round(Math.random() * 4)] + consoantes[(int) Math.round(Math.random() * 18)];
        }

        return palavra.substring(0, 1).toUpperCase() + palavra.substring(1, tamanho - 1);
    }

    /**
     * Gerador de Nome Completo, no formato 'Nome Sobrenome'
     *
     * @param tamanhoNome
     * @param tamanhoSobrenome
     * @return
     */
    public static String geradorNomeCompleto(int tamanhoNome, int tamanhoSobrenome) {
        return geradorPalavra(tamanhoNome) + " " + geradorPalavra(tamanhoSobrenome);
    }

    /**
     * Gerador de Telefone válido
     *
     * @param tipo - celular ou fixo
     * @return
     */
    public static String geradorTelefone(String tipo) {
        String[] ddds = {"61", "62", "64", "65", "66", "67", "82", "71", "73",
                "74", "75", "77", "85", "88", "98", "99", "83", "81", "87",
                "86", "89", "84", "79", "68", "96", "92", "97", "91", "93",
                "94", "69", "95", "63", "27", "28", "31", "32", "33", "34",
                "35", "37", "38", "21", "22", "24", "11", "12", "13", "14",
                "15", "16", "17", "18", "19", "41", "42", "43", "44", "45",
                "46", "51", "53", "54", "55", "47", "48", "49"};
        long random1 = Math.round(ddds.length * (Math.random()));
        long random2;
        do {
            random2 = Math.round(100000000 * (Math.random()));
        } while (random2 <= 9999999);
        String tel = null, ddd;
        ddd = ddds[(int) random1 - 1];
        tel = String.valueOf(random2);
        return (tipo.contains("celular") ? (ddd + "9" + tel) : (ddd + "2" + tel));
    }

    /**
     * Gerador de código aletarorio de Bancos Operandes para transferencias outros bancos
     *
     * @param
     * @return
     */
    public static int geradorBancosOperantes() {
        int bancos[] = new int[]{341, 33};
        int num = (int) (Math.random()*2);
        return bancos[num];
    }

    /**
     * Gerador de Agencia aletarorio de Bancos Operandes para transferencias outros bancos
     *
     * @param
     * @return
     */
    public static String geradorAgencia() {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String agencia = "";

        for (int i = 1; i <= 4; i++) {
            agencia += numeros[(int) Math.round(Math.random() * 5)];
        }

        return agencia;
    }

    /**
     * Gerador de Conta aletarorio de Bancos Operandes para transferencias outros bancos
     *
     * @param
     * @return
     */
    public static String geradorConta() {
        int[] numeros = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String conta = "";

        for (int i = 1; i <= 6; i++) {
            conta += numeros[(int) Math.round(Math.random() * 5)];
        }

        return conta;
    }

    /**
     * Gerador de e-mail aleatorio com dominios pre definidos num array
     *
     * @param
     * @return
     */
    public static String geradorDeEmail() throws Exception {
        String dominio[] = new String[]{"@next.com", "@bradesco.com.br", "@uol.com", "@terra.com", "@gmail.com", "@icloud.com"};
        int num = (int) (Math.random() * 6);
        return gerarNomeAleatorio() + dominio[num];
    }

    /**
     * Gerador de Conta next atravez de contas pre definidas Metodo provisorio
     * Estudando metodo de captura do digito* no banco de dados
     *
     * @param
     * @return
     */
    public static String geradorContaNext() {
        String conta[] = new String[]{"126896", "126918", "126942", "126926", "126934", "126950", "126969", "126977", "127132", "91111", "61034", "89397", "66060", "87580", "87602", "87610"};
        int num = (int) (Math.random() * 15);
        return conta[num];
    }

    /**
     * Gerador de Conta Bradesco atravez de contas pre definidas Metodo provisorio
     * Estudando implatar a função no TDM para consulta do DB2 - Clie
     *
     * @param
     * @return
     */
    public static String geradorContaBradesco() {
        String conta[] = new String[]{"000019", "0000027", "000663", "001104", "003050", "004146", "004308", "005401", "005517", "005606", "006009", "007811", "008060", "008192", "010030", "010154"};
        int num = (int) (Math.random() * 15);
        return conta[num];
    }

    /**
     * Gerador de CNPJ valido
     *
     * @param
     * @return Retorna CNPJ somente números sem mascara.
     */
    public static String geradorCnpj() {
        int n = 9;
        int n1 = (int) (Math.random() * n);
        int n2 = (int) (Math.random() * n);
        int n3 = (int) (Math.random() * n);
        int n4 = (int) (Math.random() * n);
        int n5 = (int) (Math.random() * n);
        int n6 = (int) (Math.random() * n);
        int n7 = (int) (Math.random() * n);
        int n8 = (int) (Math.random() * n);
        int n9 = 0; //randomiza(n);
        int n10 = 0; //randomiza(n);
        int n11 = 0; //randomiza(n);
        int n12 = 1; //randomiza(n);
        int d1 = n12 * 2 + n11 * 3 + n10 * 4 + n9 * 5 + n8 * 6 + n7 * 7 + n6 * 8 + n5 * 9 + n4 * 2 + n3 * 3 + n2 * 4 + n1 * 5;

        d1 = 11 - (mod(d1, 11));

        if (d1 >= 10)
            d1 = 0;

        int d2 = d1 * 2 + n12 * 3 + n11 * 4 + n10 * 5 + n9 * 6 + n8 * 7 + n7 * 8 + n6 * 9 + n5 * 2 + n4 * 3 + n3 * 4 + n2 * 5 + n1 * 6;

        d2 = 11 - (mod(d2, 11));

        if (d2 >= 10)
            d2 = 0;

        String numeroCnpj = null;

        numeroCnpj = "" + n1 + n2 + n3 + n4 + n5 + n6 + n7 + n8 + n9 + n10 + n11 + n12 + d1 + d2;

        return numeroCnpj;
    }


    /**
     * Calcular data relativa à data de hoje, mais ou menos dias, e retornar no formato solicitado.
     * O parâmtro dias pode ser negativo ou positivo, indicando a data a calcular relativa a hoje.
     * O formato é no padrão do formatter do Java. Exemplo: ****
     *
     * @param dias
     * @param formato
     * @return
     * @throws Exception
     */
    public static String calcularDataRelativaHoje(int dias, String formato) {
        LocalDate hoje = LocalDate.now();
        LocalDate dataRelativa = hoje.plusDays(dias);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return dataRelativa.format(formatter);
    }

    /**
     * Calcular data relativa à data de hoje, mais ou menos dias, e retornar no formato solicitado.
     * O parâmtro dias pode ser negativo ou positivo, indicando a data a calcular relativa a hoje.
     *
     * @param dias
     * @return
     * @throws Exception
     */
    public static String calcularDataRelativaHoje(int dias) {
        return calcularDataRelativaHoje(dias, "dd/MM/yyyy"); // formato padrão em caso de ausência
    }

    /**
     * Retorna apenas o primeiro nome
     *
     * @param nomeCompleto
     * @return
     */
    public static String retornarPrimeiroNome(String nomeCompleto) {
        return StringUtils.substringBefore(nomeCompleto, " ");
    }

    /**
     * Método deixa string com valor monetário na formatação ###.###,##
     * @param valor
     * @return
     */
    public static String reformatarValorMonetario(String valor){
        Double valorNumerico = Double.parseDouble(normalizaStringNumero(valor))/100;
        DecimalFormat df = new DecimalFormat("###,###.00");
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setDecimalSeparator(',');
        dfs.setGroupingSeparator('.');
        return df.format(valorNumerico);
    }

    /**
     * Método: retornaAgenciaContaAleatoria(BancoInstituicao bancoInstituicao)
     * @param bancoInstituicao - String "BRADESCO", "ITAU", "SANTANDER", "BANCO_DO_BRASIL", "CAIXA ECONOMICA FEDERAL"
     * @return
     */
    public static AgenciaConta retornaAgenciaContaAleatoria(String bancoInstituicao) throws NextException {
        return GerarAgenciaConta.retornaAgenciaContaAleatoria(bancoInstituicao);
    }

    /**
     * Método: retornaAgenciaContaAleatoria(BancoInstituicao bancoInstituicao)
     * @param bancoInstituicao - Enum: BRADESCO, ITAU, SANTANDER, BANCO_DO_BRASIL, CAIXA_ECONOMICA_FEDERAL
     * @return AgenciaConta
     */
    public static AgenciaConta retornaAgenciaContaAleatoria(BancoInstituicao bancoInstituicao){
        return GerarAgenciaConta.retornaAgenciaContaAleatoria(bancoInstituicao);

    }

    /**
     * Gerar conta válida Bradesco.
     * Método: gerarContaBradesco();
     * Formato: CCCCCCCC-D  (C - Numero da conta / D - Digito verificador)
     * @return String (conta)
     */
    public static String gerarContaBradesco() {
        return GerarAgenciaConta.gerarContaBradesco();
    }

    /**
     * Gerar agência válida Bradesco.
     * Método gerarAgenciaBradesco();
     * Formato: AAAA-D  (A - Numero da Agência / D - Digito verificador)
     * @return String (agência)
     */
    public static String gerarAgenciaBradesco() {
        return GerarAgenciaConta.gerarAgenciaBradesco();
    }

    /**
     * Gerar agência e conta válida Itau.
     * Médodo: gerarAgenciaContaItau()
     * Formato AAAACCCCC-D (A - Numero da Agência / C - Numero da conta / D - Digito verificador)
     * @return String (Agência e conta)
     */
    public static String gerarAgenciaContaItau() {
        return GerarAgenciaConta.gerarAgenciaContaItau();
    }

    /**
     * Gerar agência e conta válida Santander.
     * Médodo: gerarAgenciaContaSantander(TipoDeContaSantander tipoDeContaSantander)
     * Formato AAAATTCCCCCCCC-D (A - Numero da Agência / T - Tipo de Conta /C - Numero da conta / D - Digito verificador)
     * Tipo de contas vélidas: 01,02,03,05,07,09,13,27,35,37,43,45,46,48,50,53,60,92.
     * @return String (Agência e conta)
     */
    public static String gerarAgenciaContaSantander(TipoDeContaSantander tipoDeContaSantander) {
        return GerarAgenciaConta.gerarAgenciaContaSantander(tipoDeContaSantander);
    }

    /**
     * Gerar agência e conta válida Santander, tipo de conta 01 por padrão.
     * Médodo: gerarAgenciaContaSantander()
     * Formato AAAATTCCCCCCCC-D (A - Numero da Agência / T - Tipo de Conta /C - Numero da conta / D - Digito verificador)
     * @return String (Agência e conta)
     */
    public static String gerarAgenciaContaSantander() {
        /*
        Definido o tipo arbitrário 01 na ausência de parâmetro de tipo de conta Santander.
         */
        return GerarAgenciaConta.gerarAgenciaContaSantander(TipoDeContaSantander.TIPO_01);
    }

    /**
     * Gerar agência válida Banco do Brasil.
     * Método gerarAgenciaBancoDoBrasil();
     * Formato: AAAA-D  (A - Numero da Agência / D - Digito verificador)
     * @return String (agência)
     */
    public static String gerarAgenciaBancoDoBrasil() {
        return GerarAgenciaConta.gerarAgenciaBancoDoBrasil();
    }

    /**
     * Gerar conta válida Banco do Brasil.
     * Método: gerarContaBancoDoBrasil();
     * Formato: CCCCCCCC-D  (C - Numero da conta / D - Digito verificador)
     * @return String (conta)
     */
    public static String gerarContaBancoDoBrasil() {
        return GerarAgenciaConta.gerarContaBancoDoBrasil();
    }

    /**
     * Gerar agência conta válida Caixa Econômica Federal.
     * Método: gerarAgenciaContaCaixaEconomicaFederal(TipoDeContaCaixaEconomicaFederal tipoDeContaCaixaEconomicaFederal);
     * Formato: AAAATTTCCCCCCCC-D  (A - Numero da Agência / T - Tipo de Conta /C - Numero da conta / D - Digito verificador)
     * Tipo de contas válidas: 001,002,003,006,007,013,022,023,028,032,034,037,043,131.
     * OBS: Não é permitido débito em contas com o tipo de conta = 013, 023, 003 (conta poupançaa, conta salário e conta PJ)
     * @return String (agência e conta)
     */
    public static String gerarAgenciaContaCaixaEconomicaFederal(TipoDeContaCaixaEconomicaFederal tipoDeContaCaixaEconomicaFederal) {
        return GerarAgenciaConta.gerarAgenciaContaCaixaEconomicaFederal(tipoDeContaCaixaEconomicaFederal);
    }

    /**
     * Gerar agência conta válida Caixa Econômica Federal.
     * Método: gerarAgenciaContaCaixaEconomicaFederal();
     * Formato: AAAATTTCCCCCCCC-D  (A - Numero da Agência / T - Tipo de Conta /C - Numero da conta / D - Digito verificador)
     * O tipo arbitrório retornado é 001 - conta-corrente para movimentação de saldos.
     * @return String (agência e conta)
     */
    public static String gerarAgenciaContaCaixaEconomicaFederal() {
        return GerarAgenciaConta.gerarAgenciaContaCaixaEconomicaFederal();
    }

    /**
     * Retorna primeiro dia do mês
     * @return
     */
    public static int retornaNumeroDiasDesdePrimeiroDiaMes(){
        LocalDate localDate = LocalDate.now();
        int dia = Math.abs(1 - localDate.getDayOfMonth());
        dia = -dia;
        return dia;
    }

}

package br.com.next.automacao.core.tools.geradores.agencia;

import br.com.next.automacao.core.constantes.tools.geradores.agencia.BancoInstituicao;
import br.com.next.automacao.core.constantes.tools.geradores.agencia.TipoDeContaCaixaEconomicaFederal;
import br.com.next.automacao.core.constantes.tools.geradores.agencia.TipoDeContaSantander;
import br.com.next.automacao.core.exception.NextException;

import java.util.Locale;


public class GerarAgenciaConta {

    private static TipoDeContaSantander tipoDeContaSantander = null;
    private static TipoDeContaCaixaEconomicaFederal tipoDeContaCaixaEconomicaFederal = null;

    /**
     * Método: retornaAgenciaContaAleatoria(BancoInstituicao bancoInstituicao)
     * @param bancoInstituicao - String "BRADESCO", "ITAU", "SANTANDER", "BANCO_DO_BRASIL", "CAIXA ECONOMICA FEDERAL"
     * @return
     */
    public static AgenciaConta retornaAgenciaContaAleatoria(String bancoInstituicao) throws NextException {
        bancoInstituicao = bancoInstituicao.toUpperCase(Locale.ROOT).trim();

        for (BancoInstituicao banco : BancoInstituicao.values()) {
            if (bancoInstituicao.contains(banco.toString())) {
                return retornaAgenciaContaAleatoria(banco);
            }
        }

        try {
            throw new Exception("O banco informado não foi encontrado.");
        } catch (Exception exception) {
            throw new NextException(exception.getMessage(), exception);
        }
    }

    /**
     * Método: retornaAgenciaContaAleatoria(BancoInstituicao bancoInstituicao)
     * @param bancoInstituicao - Enum: BRADESCO, ITAU, SANTANDER, BANCO_DO_BRASIL, CAIXA_ECONOMICA_FEDERAL
     * @return AgenciaConta
     */
    public static AgenciaConta retornaAgenciaContaAleatoria(BancoInstituicao bancoInstituicao){

        AgenciaConta agenciaConta = new AgenciaConta();
        agenciaConta.setBanco(bancoInstituicao.toString());
        String agencia = "";

        switch (bancoInstituicao){
            case BRADESCO:
                agencia = gerarAgenciaBradesco();
                agenciaConta.setAgencia(agencia.substring(0,4));
                agenciaConta.setDigitoAgencia(agencia.substring(4));
                agenciaConta.setConta(gerarContaBradesco());
                return agenciaConta;
            case ITAU: {
                String strAgenciaConta = gerarAgenciaContaItau();
                agenciaConta.setAgencia(strAgenciaConta.substring(0, 4));
                agenciaConta.setConta(strAgenciaConta.substring(4));
            }
                return agenciaConta;
            case SANTANDER: {
                String strAgenciaConta = tipoDeContaSantander == null ? gerarAgenciaContaSantander() : gerarAgenciaContaSantander(tipoDeContaSantander);
                agenciaConta.setAgencia(strAgenciaConta.substring(0, 4));
                agenciaConta.setTipoDeContaSantander(strAgenciaConta.substring(4, 6));
                agenciaConta.setConta(strAgenciaConta.substring(6));
            }
                return agenciaConta;
            case BANCO_DO_BRASIL:
                agencia = gerarAgenciaBancoDoBrasil();
                agenciaConta.setAgencia(agencia.substring(0,4));
                agenciaConta.setDigitoAgencia(agencia.substring(4));
                agenciaConta.setConta(gerarContaBancoDoBrasil());
                return agenciaConta;
            case CAIXA_ECONOMICA_FEDERAL: {
                String strAgenciaConta = tipoDeContaCaixaEconomicaFederal == null ? gerarAgenciaContaCaixaEconomicaFederal() : gerarAgenciaContaCaixaEconomicaFederal(tipoDeContaCaixaEconomicaFederal);
                agenciaConta.setAgencia(strAgenciaConta.substring(0, 4));
                agenciaConta.setTipoDeContaCaixaEconomicaFederal(strAgenciaConta.substring(4, 7));
                agenciaConta.setConta(strAgenciaConta.substring(7));
            }
                return agenciaConta;
        }
        return agenciaConta;

    }

    /**
     * Gerar conta válida Bradesco.
     * Método: gerarContaBradesco();
     * Formato: CCCCCCCC-D  (C - Numero da conta / D - Digito verificador)
     * @return String (conta)
     */
    public static String gerarContaBradesco() {

        class Geracao {
            String gerarContaBradesco() {
                int[] pesoConta = {3,2,7,6,5,4,3,2};
                String conta = "0000" + gerarNumeros(1111,1999);
                int	somaTotal = 0;
                for(int i = 0; i < 8; i++) {
                    somaTotal = somaTotal + Integer.parseInt(String.valueOf(conta.charAt(i))) * pesoConta[i];
                }
                int resto = somaTotal % 11;
                int digito = 11 - resto;
                String digitoFinal = "";
                if(resto == 1) {
                    digitoFinal = "P";
                }
                else if(resto == 0) {
                    digitoFinal = "0";
                }
                else {
                    digitoFinal = String.valueOf(digito);
                }
                return conta + digitoFinal;
            }
        }

        String conta = new Geracao().gerarContaBradesco();
        while (conta.contains("P")) {
            conta = new Geracao().gerarContaBradesco();
        }

        return conta;
    }

    /**
     * Gerar agência válida Bradesco.
     * Método gerarAgenciaBradesco();
     * Formato: AAAA-D  (A - Numero da Agência / D - Digito verificador)
     * @return String (agência)
     */
    public static String gerarAgenciaBradesco() {

        class Geracao {
            String gerarAgenciaBradesco() {
                int[] pesoAgencia = {5,4,3,2};
                String agencia = gerarNumeros(1,9999);
                int	somaTotal = 0;
                for(int i = 0; i < 4; i++) {
                    somaTotal = somaTotal + Integer.parseInt(String.valueOf(agencia.charAt(i))) * pesoAgencia[i];
                }
                int resto = somaTotal % 11;
                int digito = 11 - resto;
                String digitoFinal = "";
                if(digito == 10) {
                    digitoFinal = "P";
                }
                else if(digito == 11) {
                    digitoFinal = "0";
                }
                else {
                    digitoFinal = String.valueOf(digito);
                }
                return agencia + digitoFinal;
            }
        }

        String agencia = new Geracao().gerarAgenciaBradesco();
        while (agencia.contains("P")) {
            agencia = new Geracao().gerarAgenciaBradesco();
        }
        return agencia;
    }

    /**
     * Gerar agência e conta válida Itau.
     * Médodo: gerarAgenciaContaItau()
     * Formato AAAACCCCC-D (A - Numero da Agência / C - Numero da conta / D - Digito verificador)
     * @return String (Agência e conta)
     */
    public static String gerarAgenciaContaItau() {
        // Agência 0267 fixa para funcionar com a tranfêrencia do next
        String agenciaConta  = "0267" + gerarNumeros(1,99999);
        int somaTotal, mult;
        somaTotal = mult = 0;
        String valorSoma = "";
        for(int i = 0; i < 9; i++) {
            if(i % 2 == 0)
                mult = Integer.parseInt(String.valueOf(agenciaConta.charAt(i))) * 2;
            else
                mult = Integer.parseInt(String.valueOf(agenciaConta.charAt(i))) * 1;
            if(mult > 9) {
                valorSoma = String.valueOf(mult);
                mult = Integer.parseInt(valorSoma.substring(0,1)) + Integer.parseInt(valorSoma.substring(1,2));
            }
            somaTotal = somaTotal + mult;
        }
        int resto = somaTotal % 10;
        int digito = 0;
        if(resto != 0)
            digito = 10 - resto;
        String digitoFinal = String.valueOf(digito);
        return agenciaConta  + digitoFinal;

    }

    /**
     * Gerar agência e conta válida Santander.
     * Médodo: gerarAgenciaContaSantander(TipoDeContaSantander tipoDeContaSantander)
     * Formato AAAATTCCCCCCCC-D (A - Numero da Agência / T - Tipo de Conta /C - Numero da conta / D - Digito verificador)
     * Tipo de contas válidas: 01,02,03,05,07,09,13,27,35,37,43,45,46,48,50,53,60,92.
     * @return String (Agência e conta)
     */
    public static String gerarAgenciaContaSantander(TipoDeContaSantander tipoDeContaSantander) {
        // Agência 1091 fixa para funcionar com a tranfêrencia do next
        String agenciaConta = "1091" + tipoDeContaSantander.recuperarTipoDeConta() + gerarNumeros(1,99999999);
        int[] pesoAgConta = {9,7,3,1,0,0,9,7,1,3,1,9,7,3};
        int somaTotal, mult; somaTotal = mult = 0;
        for(int i = 0; i < 14; i++) {
            mult = (Integer.parseInt(String.valueOf(agenciaConta.charAt(i))) * pesoAgConta[i]);
            if(mult > 9) {
                mult = Integer.parseInt(String.valueOf(mult).substring(1,2));
            }
            somaTotal = somaTotal + mult;
        }
        int digito = Integer.parseInt(String.valueOf(somaTotal).substring(1, 2));
        String digitoFinal = "";
        if(digito == 0)
            digitoFinal = "0";
        else
            digitoFinal = String.valueOf(10 - digito);
        return agenciaConta + digitoFinal;

    }

    /**
     * Gerar agência e conta válida Santander, tipo de conta 01 por padrão.
     * Médodo: gerarAgenciaContaSantander()
     * Formato AAAATTCCCCCCCC-D (A - Numero da Agência / T - Tipo de Conta /C - Numero da conta / D - Digito verificador)
     * @return String (Agência e conta)
     */
    public static String gerarAgenciaContaSantander() {
        /*
        Na ausência do parâmetro de tipo de conta, utilizamos o tipo 01 por padrão.
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

        class Geracao {
            String gerarAgenciaBancoDoBrasil() {
                String agencia = gerarNumeros(1,9999);
                int[] pesoAgencia = {5,4,3,2};
                int somaTotal = 0;
                for(int i = 0; i < 4; i++) {
                    somaTotal = somaTotal + Integer.parseInt(String.valueOf(agencia.charAt(i))) * pesoAgencia[i];
                }
                int resto = somaTotal % 11;
                int digito = 11 - resto;
                String digitoFinal = "";
                if(digito == 10) {
                    digitoFinal = "X";
                }
                else if(digito == 11) {
                    digitoFinal = "0";
                }
                else {
                    digitoFinal = String.valueOf(digito);
                }
                return agencia + digitoFinal;
            }
        }

        String agencia = new Geracao().gerarAgenciaBancoDoBrasil();
        while (agencia.contains("X")) {
            agencia = new Geracao().gerarAgenciaBancoDoBrasil();
        }

        return agencia;
    }

    /**
     * Gerar conta válida Banco do Brasil.
     * Método: gerarContaBancoDoBrasil();
     * Formato: CCCCCCCC-D  (C - Numero da conta / D - Digito verificador)
     * @return String (conta)
     */
    public static String gerarContaBancoDoBrasil() {

        class Geracao {
            String gerarContaBancoDoBrasil() {
                String conta = gerarNumeros(1,99999999);
                int[] pesoConta = {9,8,7,6,5,4,3,2};
                int	somaTotal = 0;
                for(int i = 0; i < 8; i++) {
                    somaTotal = somaTotal + Integer.parseInt(String.valueOf(conta.charAt(i))) * pesoConta[i];
                }
                int resto = somaTotal % 11;
                int digito = 11 - resto;
                String digitoFinal = "";
                if(digito == 10) {
                    digitoFinal = "X";
                }
                else if(digito == 11) {
                    digitoFinal = "0";
                }
                else {
                    digitoFinal = String.valueOf(digito);
                }
                return conta + digitoFinal;
            }
        }

        String conta = new Geracao().gerarContaBancoDoBrasil();
        while (conta.contains("X")) {
            conta = new Geracao().gerarContaBancoDoBrasil();
        }

        return conta;
    }
    /**
     * Gerar agência conta válida Caixa Econômica Federal.
     * Método: gerarAgenciaContaCaixaEconomicaFederal(TipoDeContaCaixaEconomicaFederal tipoDeContaCaixaEconomicaFederal);
     * Formato: AAAATTTCCCCCCCC-D  (A - Numero da Agência / T - Tipo de Conta /C - Numero da conta / D - Digito verificador)
     * Tipo de contas válidas: 001,002,003,006,007,013,022,023,028,032,034,037,043,131.
     * OBS: Não é permitido débito em contas com o tipo de conta = 013, 023, 003 (conta poupança, conta salário e conta PJ)
     * @return String (agência e conta)
     */
    public static String gerarAgenciaContaCaixaEconomicaFederal(TipoDeContaCaixaEconomicaFederal tipoDeContaCaixaEconomicaFederal) {

        int[] pesoAgConta = {8,7,6,5,4,3,2,9,8,7,6,5,4,3,2};
        String agenciaConta = gerarNumeros(1,9999) + tipoDeContaCaixaEconomicaFederal.recuperarTipoDeConta() + gerarNumeros(1,99999999);
        int somaTotal = 0;
        for(int i = 0; i < pesoAgConta.length; i++) {
            somaTotal = somaTotal + Integer.parseInt(String.valueOf(agenciaConta.charAt(i))) * pesoAgConta[i];
        }
        int multiplicacao1 = 10 * somaTotal;
        int divisao = multiplicacao1 / 11;
        int multiplicacao2 = divisao * 11;
        int resto = multiplicacao1 - multiplicacao2;
        String digitoFinal = "";
        if(resto == 10) {
            digitoFinal = "0";
        }
        else {
            digitoFinal = String.valueOf(resto);
        }

        return agenciaConta + digitoFinal;
    }

    /**
     * Gerar agência conta válida Caixa Econômica Federal.
     * Método: gerarAgenciaContaCaixaEconomicaFederal();
     * Formato: AAAATTTCCCCCCCC-D  (A - Numero da Agência / T - Tipo de Conta /C - Numero da conta / D - Digito verificador)
     * O tipo arbitrário retornado é 001 - conta-corrente para movimentação de saldos.
     * @return String (agência e conta)
     */
    public static String gerarAgenciaContaCaixaEconomicaFederal() {
        /*
        Na ausência do parâmetro de tipo de conta, utilizamos o tipo 001 por padrão.
         */
        return GerarAgenciaConta.gerarAgenciaContaCaixaEconomicaFederal(TipoDeContaCaixaEconomicaFederal.TIPO_001);
    }

    /**
     * Gerar números Randomicamente
     * @param minimo  - 'Range' número minimo
     * @param maximo  - 'Range' número máximo
     * @return String (Numero aleatório)
     * Ex:
     *      String num = gerarNumeros(100,200); //O valor em 'num' terá entre 100 e 200
     *  OBS:
     *      Função retorna número com string completando com 0 Zeros a esquerda para efeito de cálculo.
     */
    private static String gerarNumeros(int minimo, int maximo) {

        String numero = String.valueOf(Math.round((Math.random() * ((maximo - minimo) + 1)) + minimo));
        String zeros = "";
        for(int i = 0; i < Math.abs((numero.length() - String.valueOf(maximo).length())); i++)
            zeros += "0";
        return zeros.concat(numero);

    }


}

package constantes.recarga;

public enum NumerosEOperadoras {

    VIVO_BA_DDD_71("71996009999", "VIVO - BA", 100.00),
    VIVO_SE_DDD_79("79996009999", "VIVO - SE", 10000.00),
    VIVO_DDD_11_1("11997136666", "VIVO", 5000.00),
    VIVO_DDD_13("13096442225", "VIVO", 5000.00),
    VIVO_DDD_11_2("11971019999", "VIVO", 5000.00),
    TIM_MAXITEL_DDD_31("31991019999", "TIM MAXITEL", 100.00),
    CLARO_DDD_11_1("11993201088", "CLARO - SP", 1000.00),
    CLARO_DDD_11_2("11991009999", "CLARO - SP", 1000.00),
    CLARO_DDD_11_3("11993895333", "CLARO - SP", 1000.00),
    CLARO_DDD_11_4("11994645847", "CLARO - SP", 1000.00),
    AMAZONIA_DDD_91("91962209999", "AMAZONIA CELULAR", 5000.00),
    NUMERO_INVALIDO("11111111111","INVALIDO",null),
    NUMERO_UTILIZADO(null,null, null);

    private final String dddENumero;
    private final String operadora;
    private final Double limiteDiario;
    private static ThreadLocal<String> telefone;

    NumerosEOperadoras(String dddENumero, String operadora, Double limiteDiario) {
        this.dddENumero = dddENumero;
        this.operadora = operadora;
        this.limiteDiario = limiteDiario;
        definirTelefone();
    }

    public String dddENumero() {
        switch(this){
            case NUMERO_UTILIZADO:
                return retornarTelefone();
            default:
                return dddENumero;
        }
    }

    public String operadora()
    {
        return operadora;
    }

    public Double limiteDiario()
    {
        return limiteDiario;
    }

    /**
     * Armazena valor na variável thread safe telefone
     */
    private static void definirTelefone(){
        if(telefone == null){
            telefone = new ThreadLocal<>();
        }
    }

    /**
     * Armazena valor na variável thread safe telefone
     *
     * @param numeroTelefone
     */
    public static void definirTelefone(String numeroTelefone){
        definirTelefone();
        telefone.set(numeroTelefone);
    }

    /**
     * Retorna valor armazenado na variável thread-safe telefone
     *
     * @return valor telefone
     */
    public static String retornarTelefone(){
        return telefone.get();
    }
}

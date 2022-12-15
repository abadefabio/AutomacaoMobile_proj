package constantes.recarga;

public class ContatosRecarga {

    ContatosRecarga(String nome, String cpf, String email, NumerosEOperadoras celular){
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.celular = celular;
        definirNomeCompleto();
        definirCelular();
    }

    private String nome;
    private String cpf;
    private String email;
    private NumerosEOperadoras celular;
    private static ThreadLocal<String> nomeCompleto;
    private static ThreadLocal<NumerosEOperadoras> celularUtilizado;

    /**
     * Armazena valor na variável thread safe nome
     */
    public static void definirNomeCompleto(){
        if(nomeCompleto == null){
            nomeCompleto = new ThreadLocal<>();
        }
    }

    /**
     * Armazena valor na variável thread safe nome
     *
     * @param nome
     */
    public static void definirNomeCompleto(String nome){
        definirNomeCompleto();
        nomeCompleto.set(nome);
    }

    /**
     * Retorna valor armazenado na variável thread-safe nomeCompleto
     *
     * @return valor nome
     */
    public static String retornarNomeCompleto(){
        return nomeCompleto.get();
    }


    /**
     * Armazena valor na variável thread safe nome
     */
    public static void definirCelular(){
        if(celularUtilizado == null){
            celularUtilizado = new ThreadLocal<>();
        }
    }

    /**
     * Armazena valor na variável thread safe nome
     *
     * @param celular
     */
    public static void definirCelular(NumerosEOperadoras celular){
        definirCelular();
        celularUtilizado.set(celular);
    }

    /**
     * Retorna valor armazenado na variável thread-safe nomeCompleto
     *
     * @return valor nome
     */
    public static NumerosEOperadoras retornarCelular(){
        return celularUtilizado.get();
    }


}

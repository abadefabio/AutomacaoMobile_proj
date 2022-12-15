package constantes.parcerias;

import static br.com.next.automacao.core.tools.Utilitarios.geradorNomeCompleto;
import static br.com.next.automacao.core.tools.Utilitarios.geradorTelefone;

public enum AmigoParcerias {

    AMIGO_ALEATORIO(geradorNomeCompleto(4,5), geradorTelefone("celular")),
    AMIGO_PALAVRAO("Puta Merda", geradorTelefone("celular")),
    AMIGO_TELEFONE_INCOMPLETO(geradorNomeCompleto(4,5), "119710543"),
    AMIGO_JA_UTILIZADO(null, null);

    private String nomeAmigo;
    private String numeroCelularAmigo;
    private static ThreadLocal<String> numeroCelular;
    private static ThreadLocal<String> nome;

    AmigoParcerias(String nomeAmigo, String numeroCelularAmigo) {
        definirNome();
        definirNumeroCelular();
        this.nomeAmigo = nomeAmigo;
        this.numeroCelularAmigo = numeroCelularAmigo;
    }

    public String recuperarNomeAmigo(){
        switch(this){
            case AMIGO_JA_UTILIZADO:
                return recuperarNome();
            default:
                return this.nomeAmigo;
        }
    }

    public String recuperarCelularAmigo(){
        switch(this){
            case AMIGO_JA_UTILIZADO:
                return recuperarNumeroCelular();
            default:
                return this.numeroCelularAmigo;
        }
    }

    public static void definirNumeroCelular(){
        if (numeroCelular == null){
            numeroCelular = new ThreadLocal<>();
        }
    }

    public static void definirNumeroCelular(String numero){
        definirNumeroCelular();
        numeroCelular.set(numero);
    }

    public static String recuperarNumeroCelular(){
        return numeroCelular.get();
    }

    public static void definirNome(){
        if (nome == null){
            nome = new ThreadLocal<>();
        }
    }

    public static void definirNome(String nome){
        definirNome();
        AmigoParcerias.nome.set(nome);
    }

    public static String recuperarNome(){
        return nome.get();
    }
}

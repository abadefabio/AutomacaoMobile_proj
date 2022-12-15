package constantes.parcerias;


public enum ConviteIndiqueAmigos {

    APENAS_UM,
    MAIS_AMIGOS,
    CONVITE_ENVIADO_APENAS_UM("Convite Enviado!", APENAS_UM),
    CONVITE_ENVIADO_MAIS_AMIGOS("Convite Enviado!", MAIS_AMIGOS),
    CONVITE_JEQUETI_APENAS_UM("Como a gente ama te mimar, você receberá um produto Jequiti no seu próximo pedido assim que a pessoa indicada abrir a conta e movimentar.", APENAS_UM),
    CONVITE_JEQUETI_MAIS_AMIGOS("Como a gente ama te mimar, você receberá um produto Jequiti no seu próximo pedido assim que a pessoa indicada abrir a conta e movimentar.", MAIS_AMIGOS),
    CONVITE_FUNCIONARIO_APENAS_UM("Agora é só esperar seu amigo abrir a conta e começar a fazer acontecer com a gente :)", APENAS_UM),
    CONVITE_FUNCIONARIO_MAIS_AMIGOS("Agora é só esperar seu amigo abrir a conta e começar a fazer acontecer com a gente :)", MAIS_AMIGOS);


    private String mensagemEsperada;
    private ConviteIndiqueAmigos quantidadeAmigos;

    ConviteIndiqueAmigos(){
    }

    ConviteIndiqueAmigos(String mensagemEsperada, ConviteIndiqueAmigos quantidadeAmigos ){
        this.mensagemEsperada = mensagemEsperada;
        this.quantidadeAmigos = quantidadeAmigos;
    }

    @Override
    public String toString(){
        return this.mensagemEsperada;
    }

    public ConviteIndiqueAmigos retornaQuantidadeAmigos(){
        return this.quantidadeAmigos;
    }

}

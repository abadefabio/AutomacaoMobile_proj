package constantes.comprovantes;

public enum ConsultaServico {

    PAGAMENTOS("PAGAMENTOS"),
    TRANSFERENCIAS("TRANSFER�NCIAS"),
    OBJETIVOS("OBJETIVOS");


    private String value;

    ConsultaServico(String value){
        this.value = value;

    }

    @Override
    public String toString(){
        return this.value;

    }

}

package constantes.comprovantes;

public enum MensagensComprovantes {

    EXTRATO_ENVIADO_PARA("Extrato enviado para:"),
    SEM_COMPROVANTES("não temos comprovante"),
    PARA_ESSA_BUSCA("pra essa busca que você fez."),
    EXTRATO_ENVIADO("Extrato enviado");

    private String value;

    MensagensComprovantes(String value){
        this.value = value;

    }

    @Override
    public String toString(){
        return this.value;

    }
}

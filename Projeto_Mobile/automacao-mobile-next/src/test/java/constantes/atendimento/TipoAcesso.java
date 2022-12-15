package constantes.atendimento;

public enum TipoAcesso {

    COM_DEPENDENTE ("Com Dependente"),
    SEM_DEPENDENTE ("Sem Dependente"),
    BUBBLE_CHAT("BubbleChat");

    private String valor;

    TipoAcesso(String valor){
        this.valor = valor;
    }

    @Override
    public String toString(){
        return this.valor;
    }
}

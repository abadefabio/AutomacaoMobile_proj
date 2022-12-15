package constantes.atendimento;

public enum TipoArquivoEnum {
    IMAGEM("IMAGEM"),
    VIDEO("VIDEO"),
    PDF("PDF");


    private String value;

    TipoArquivoEnum(String value){
        this.value = value;

    }

    @Override
    public String toString(){
        return this.value;

    }
}

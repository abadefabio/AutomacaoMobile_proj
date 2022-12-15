package br.com.next.automacao.core.constantes;

public enum AtributoElemento {

    TEXTO("text"),
    LABEL("label"),
    CONTENT_DESC("content-desc"),
    NAME("name"),
    BASE("base"),
    HEAD("head"),
    TITULO("title");



    private String value;

    AtributoElemento(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

}

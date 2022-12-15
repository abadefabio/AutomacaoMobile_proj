package constantes.web;

public enum TituloTela {

    OUTLOOK_WEB("Outlook Web App");

    private String value;

    TituloTela(String value) { this.value = value; }

    @Override
    public String toString(){ return value;}
}

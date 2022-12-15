package br.com.next.automacao.core.constantes.driver.web;

public enum TipoWebDriver {
    CHROME("chrome"),
    FIREFOX("firefox"),
    IE("ie"),
    EDGE("edge"),
    SAFARI("safari");

    private String navegador;
    TipoWebDriver(String navegador){
        this.navegador = navegador;
    }

    public static TipoWebDriver setTipoWebDriver(String navegador){
        switch (navegador.toLowerCase()){
            case "chrome":
                return CHROME;
            case "firefox":
                return FIREFOX;
            case "ie":
                return IE;
            case "edge":
                return EDGE;
            case "safari":
                return SAFARI;
            default:
                return null;
        }
    }

    public String getNavegador(){
        return this.navegador;
    }
}

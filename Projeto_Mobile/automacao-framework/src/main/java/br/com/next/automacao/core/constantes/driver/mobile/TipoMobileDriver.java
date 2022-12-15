package br.com.next.automacao.core.constantes.driver.mobile;

import static br.com.next.automacao.core.base.TesteNext.getCasoTeste;

public enum TipoMobileDriver {
    ANDROID("android"),
    IOS("ios");

    private String plataforma;
    TipoMobileDriver(String plataforma){
        this.plataforma = plataforma;
    }

    public static TipoMobileDriver setTipoMobileDriver(){
        String plataforma = getCasoTeste().getParametrosTeste().get("plataforma");
        switch(plataforma.toLowerCase()){
            case "android":
                return ANDROID;
            case "ios":
                return IOS;
            default:
                return null;
        }
    }

    public String getPlataforma(){
        return this.plataforma;
    }
}

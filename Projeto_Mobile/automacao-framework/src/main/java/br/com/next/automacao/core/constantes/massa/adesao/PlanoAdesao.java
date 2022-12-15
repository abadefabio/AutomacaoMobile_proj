package br.com.next.automacao.core.constantes.massa.adesao;

public enum PlanoAdesao {

    CESTA_NEXT_LIGHT(7044, "Cesta Next Light",0),
    CESTA_NEXT(5990, "Cesta Next",0),
    PACOTE_PADRONIZADO_I(4056, "Pacote Padronizado I",11),
    PACOTE_PADRONIZADO_II(5680, "Pacote Padronizado II",18),
    PACOTE_PADRONIZADO_III(5681, "Pacote Padronizado III",22),
    PACOTE_PADRONIZADO_IV(5682, "Pacote Padronizado IV",33),
    SERVICOS_ESSENCIAIS(4025, "Serviços Essenciais",0);

    private int codigoPlano;
    private String descricaoPlano;
    private int valorPlano;

    private PlanoAdesao(int codigoPlano,String descricaoPlano,int valorPlano) {
        this.codigoPlano = codigoPlano;
        this.descricaoPlano = descricaoPlano;
        this.valorPlano = valorPlano;
    }

    public int getCodigoPlano() {
        return codigoPlano;
    }
    public String getDescricaoPlano() {
        return descricaoPlano;
    }
    public int getValorPlano() {
        return valorPlano;
    }
}

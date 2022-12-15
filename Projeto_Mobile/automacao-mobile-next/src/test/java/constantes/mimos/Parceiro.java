package constantes.mimos;

public enum Parceiro {
    AUTOMACAO_DE_TESTE_LTDA("Automação de teste LTDA"),
    CABANA_BURGUER("Cabana Burger"),
    CARTOES("Cartões"),
    CASAS_BAHIA("Casas Bahia"),
    CHEFSCLUB("ChefsClub"),
    CHOCOLATES_BRASIL("Chocolates Brasil"),
    CNA("CNA"),
    CUPONEIRA("Cuponeira"),
    DISNEY_PLUS("disney+"),
    EXCLUIR("EXCLUIR"),
    EXTRA("Extra"),
    HOTEL_URBANO("Hotel Urbano"),
    IFOOD("ifood"),
    INGRESSO_RAPIDO("Ingresso Rápido"),
    LAFA_TOYS("LAFFA TOYS"),
    LACO("LAÇO"),
    LIVRARIA_CULTURA("Livraria Cultura"),
    NOVO_PARCEIRO("NOVO PARCEIRO"),
    OMELETE("Omelete"),
    PARAFUSO("Parafuzo"),
    PARCEIRO_ENDERECO("Parceiro Endereço"),
    PONTO_FRIO("Ponto Frio"),
    SAMSUNG("Samsung"),
    TESTE_JULIANO("Teste Juliano"),
    TESTE_NUMERO("Teste Numero"),
    TESTE_PB_120("Teste PB-120"),
    UBER("Uber"),
    XBOX("Xbox"),
    ZAP_PARCEIRO_1("ZAP Parceiro 1"),
    ZAP_PARCEIRO_2("Zap Parceiro 2");

    private String value;

    Parceiro(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}

package constantes.adesao;

public enum DadosPessoais {

    TEXTO_CAMPO_PESQUISA_LISTA_ESTADO_CIVIL("Busque por estado civil"),
    OPCAO_SOLTEIRO_ESTADO_CIVIL("Solteiro"),
    OPCAO_CASADO_UNIAO_UNIVERSAL_BENS_ESTADO_CIVIL("Casado com união universal de bens"),
    OPCAO_CASADO_UNIAO_PARCIAL_BENS_ESTADO_CIVIL("Casado com união parcial de bens"),
    OPCAO_CASADO_SEPARACAO_BENS_ESTADO_CIVIL("Casado com separação de bens"),
    OPCAO_SEPARADO_JUDICIALMENTE_ESTADO_CIVIL("Separado judicialmente"),
    OPCAO_DIVORCIADO_ESTADO_CIVIL("Divorciado"),
    OPCAO_VIUVO_ESTADO_CIVIL("Viúvo"),
    OPCAO_UNIAO_ESTAVEL("União estável");


    private String value;

    DadosPessoais(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

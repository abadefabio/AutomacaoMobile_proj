package br.com.next.automacao.core.constantes.jira;

public enum ExecucaoStatus {

    PASS( "1" ),
    FAIL( "2" ),
    WIP( "3" ),
    BLOCKED( "4" );

    private String value;

    private ExecucaoStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

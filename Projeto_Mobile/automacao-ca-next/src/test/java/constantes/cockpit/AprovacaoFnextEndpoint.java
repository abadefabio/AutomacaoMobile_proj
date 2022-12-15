package constantes.cockpit;

public interface AprovacaoFnextEndpoint {

    String CAPTURAR_TOKEN_INTERNAL_FNEXT = "next-service-proxy/v1/login/internal";
    String VALIDAR_NOME_COMPLETO  = "next-service-proxy/v1/proposal-data/validateName";
    String CAPTURAR_PROPOSAL_ID_FNEXT   = "next-service-proxy/v1/engine-data/generalSearch";
    String CAPTURAR_PROSPECT_ID_FNEXT = "next-service-proxy/v1/engine-data/proposalStages";
    String N1_APROVAR_SEM_PENDENCIA = "next-service-proxy/v1/proposal/conclude";
    String URI_TI = "https://staff.stf.ti.aznxt.local/";
    String URI_TU = "https://staff.stf.tu.aznxt.local/";
    String URI_LOGOUT_TU = "https://api.int.tu.aznxt.local/v1/logoff/internal";
    String URI_LOGOUT_TI = "https://api.int.ti.aznxt.local/v1/logoff/internal";
}

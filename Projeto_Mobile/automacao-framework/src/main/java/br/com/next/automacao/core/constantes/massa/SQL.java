package br.com.next.automacao.core.constantes.massa;

public enum SQL {

    CPF_ONBOARDING_STATUS_ID_4("SELECT\n" +
            "    c.cpf,\n" +
            "    pp.prod_code,\n" +
            "    c.CUSTOMER_TYPE_UID,\n" +
            "    p.INVOICE_DAY,\n" +
            "    pp.CREATE_DT\n" +
            "FROM\n" +
            "    nextbank.proposal_product pp,\n" +
            "    nextbank.proposal p,\n" +
            "    nextbank.customer c\n" +
            "WHERE\n" +
            "        c.customer_uid = p.customer_uid\n" +
            "    AND\n" +
            "        p.proposal_uid = pp.proposal_id\n" +
            "    AND\n" +
            "        p.offers_maintained_ind = 'Y'\n" +
            "    AND\n" +
            "        c.onboarding_status_id = 4\n" +
            "    AND\n" +
            "        pp.prod_code IN (5990)\n" +
            "    AND\n" +
            "        proposal_id IN (\n" +
            "            SELECT\n" +
            "                proposal_uid\n" +
            "            FROM\n" +
            "                nextbank.proposal\n" +
            "            WHERE\n" +
            "                customer_uid IN (\n" +
            "                    SELECT\n" +
            "                        customer_uid\n" +
            "                    FROM\n" +
            "                        nextbank.customer\n" +
            "                       \n" +
            "                )\n" +
            "        )\n" +
            "ORDER BY pp.CREATE_DT DESC"),

    CARTAO_CREDITO_VISA_PLATINUM_BLOQUEADO("SELECT c.cpf FROM nextbank.proposal_product pp, nextbank.proposal p, nextbank.customer c WHERE c.customer_uid = p.customer_uid " +
            "AND p.proposal_uid = pp.proposal_id AND p.offers_maintained_ind = 'Y' AND c.onboarding_status_id IN (4) AND pp.prod_code IN (6380) AND proposal_id IN " +
            "( SELECT proposal_uid FROM nextbank.proposal WHERE customer_uid IN (SELECT customer_uid FROM nextbank.customer)) ORDER BY pp.CREATE_DT DESC;"),

    CARTAO_CREDITO_VISA_INTERNACIONAL_BLOQUEADO("SELECT c.cpf FROM nextbank.proposal_product pp, nextbank.proposal p, nextbank.customer c " +
            "WHERE c.customer_uid = p.customer_uid AND p.proposal_uid = pp.proposal_id AND p.offers_maintained_ind = 'Y' AND c.onboarding_status_id " +
            "IN (4) AND pp.prod_code IN (6382) AND proposal_id IN (SELECT proposal_uid FROM nextbank.proposal WHERE customer_uid " +
            "IN (SELECT customer_uid FROM nextbank.customer)) ORDER BY pp.CREATE_DT DESC;"),

    CARTAO_DEBITO_VISA_BLOQUEADO("SELECT c.cpf FROM nextbank.proposal_product pp, nextbank.proposal p, nextbank.customer c WHERE c.customer_uid = p.customer_uid " +
            "AND p.proposal_uid = pp.proposal_id AND p.offers_maintained_ind = 'Y' AND c.onboarding_status_id IN (4) AND pp.prod_code IN (0) AND proposal_id " +
            "IN (SELECT proposal_uid FROM nextbank.proposal WHERE customer_uid IN (SELECT customer_uid FROM nextbank.customer)) ORDER BY pp.CREATE_DT DESC;"),

    CLIENTE_CREDITO_APROVADO("SELECT  B.CPF FROM   NEXTBANK.PROPOSAL A, NEXTBANK.CUSTOMER B WHERE  A.APPROVED_CREDIT_AMT >= 1010 AND A.APPROVED_CREDIT_AMT <= 5020 AND A.CUSTOMER_UID = B.CUSTOMER_UID;"),

    CPF_AG_INFORMAR_CONTA_SEM_DIGITO("SELECT C.CPF, B.BRANCH_ID, B.BANK_ACCOUNT_ID FROM NEXTBANK.CUSTOMER_BANK_ACCOUNT B, NEXTBANK.CUSTOMER C WHERE B.CUSTOMER_UID = C.CUSTOMER_UID AND B.CUSTOMER_UID IN (SELECT CUSTOMER_UID FROM NEXTBANK.CUSTOMER  WHERE BANK_ACCOUNT_ID IN (171));"),

    CPF_ONBOARDING_STATUS_5_CONTINGENCIA("SELECT \n" +
            "    c.customer_uid,\n" +
            "    c.cpf,\n" +
            "    c.onboarding_status_id,\n" +
            "    c.customer_type_uid,\n" +
            "    p.offers_maintained_ind,\n" +
            "    d.DEVICE_ID \n" +
            "FROM NEXTBANK.CUSTOMER c,\n" +
            "     NEXTBANK.DEVICE d, \n" +
            "     NEXTBANK.PROPOSAL p,\n" +
            "     NEXTBANK.USER_PASSWORD up,\n" +
            "     NEXTBANK.DEVICE_REGISTRATION dr\n" +
            "WHERE (c.customer_uid = p.customer_uid\n" +
            "AND c.onboarding_status_id = 5\n" +
            "AND (p.offers_maintained_ind IS NULL OR p.offers_maintained_ind = 'Y') \n" +
            "AND (c.customer_type_uid = 1 OR c.customer_type_uid IS NULL))\n" +
            "AND (up.user_password_uid = dr.user_password_uid\n" +
            "AND dr.device_uid = d.device_uid\n" +
            "AND up.status_id = 1 \n" +
            "AND dr.risk_score_status_id = 0 \n" +
            "AND dr.status_id = 1 \n" +
            "AND dr.device_registration_uid = ( \n" +
            "    SELECT MAX(dr2.device_registration_uid)\n" +
            "    FROM NEXTBANK.USER_PASSWORD up2,\n" +
            "         NEXTBANK.DEVICE_REGISTRATION dr2,\n" +
            "         NEXTBANK.DEVICE d2\n" +
            "    WHERE  up2.user_password_uid = dr2.user_password_uid\n" +
            "    AND dr2.device_uid = d2.device_uid\n" +
            "    AND up2.login_cd = c.CPF));\n");

    private String value;

    private SQL(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

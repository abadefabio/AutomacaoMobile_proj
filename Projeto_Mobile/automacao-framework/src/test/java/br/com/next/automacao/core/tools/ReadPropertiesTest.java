package br.com.next.automacao.core.tools;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReadPropertiesTest {

    @Test
    void getCaminho() {
        assertEquals(ReadProperties.getCaminho().isEmpty(),false);
    }

    @Test
    void getFuncionalPass() {
        assertEquals(ReadProperties.getFuncionalPass().isEmpty(),false);
    }

    @Test
    void getFuncionalUser() {
        assertEquals(ReadProperties.getFuncionalUser().isEmpty(),false);
    }

    @Test
    void getAuthUserId() {
        assertEquals(ReadProperties.getAuthUserId().isEmpty(),false);
    }

    @Test
    void getAuthUserPass() {
        assertEquals(ReadProperties.getAuthUserPass().isEmpty(),false);
    }

    @Test
    void getMcUrl() {
        assertEquals(ReadProperties.getMcUrl().isEmpty(),false);
    }

    @Test
    void getJiraUser() {
        assertEquals(ReadProperties.getJiraUser().isEmpty(),false);
    }

    @Test
    void getJiraPass() {
        assertEquals(ReadProperties.getJiraPass().isEmpty(),false);
    }

    @Test
    void getJiraUrl() {
        assertEquals(ReadProperties.getJiraUrl().isEmpty(),false);
    }

    @Test
    void getDataBaseUser() {
        assertEquals(ReadProperties.getDataBaseUser().isEmpty(),false);
    }

    @Test
    void getDataBasePass() {
        assertEquals(ReadProperties.getDataBasePass().isEmpty(),false);
    }

    @Test
    void getDataBaseUrl() {
        assertEquals(ReadProperties.getDataBaseUrl().isEmpty(),false);
    }

    @Test
    void getCoreBankingUrl() {
        assertEquals(ReadProperties.getCoreBankingUrl().isEmpty(),false);
    }

    @Test
    void getCaUrl() {
        assertEquals(ReadProperties.getFuncionalUser().isEmpty(),false);
    }

    @Test
    void getEmuladorUser() {
        assertEquals(ReadProperties.getEmuladorUser().isEmpty(),false);
    }

    @Test
    void getEmuladorPass() {
        assertEquals(ReadProperties.getEmuladorPass().isEmpty(),false);
    }

    @Test
    void getCredenciaisEmulador() {
        assertEquals(ReadProperties.getCredenciaisEmulador().isEmpty(),false);
    }

    @Test
    void getAmbiente() {
        assertEquals(ReadProperties.getAmbiente().isEmpty(),false);
    }

    @Test
    void getEsteira() {
        assertEquals(ReadProperties.getEsteira().isEmpty(),false);
    }

    @Test
    void getTdmUrl() {
        assertEquals(ReadProperties.getTdmUrl().isEmpty(),false);
    }

    @Test
    void getGestaoUser() {
        assertEquals(ReadProperties.getGestaoUser().isEmpty(),false);
    }

    @Test
    void getGestaoPass() {
        assertEquals(ReadProperties.getGestaoPass().isEmpty(),false);
    }
}
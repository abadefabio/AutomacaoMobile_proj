package constantes.adesao.multibank;

public interface Config {
    
    String STATUS_ONBOARDING_ESPERADO = "1"; // Status de onboarding do Joy esperado ap�s a ades�o
    int TIMEOUT_MINIMO_ESPERA_ONBOARDING = 60; // Tempo m�ximo m�nimo que se pode esperar para que o status seja atualizado
    int TIMEOUT_MAXIMO_ESPERA_ONBOARDING = 5*60; // Tempo m�ximo que se pode esperar para o status seja atualizado
    int TIMEOUT_PADRAO_ESPERA_ONBOARDING = 2*60; // Tempo padr�o sugerido a ser utilizado nas chamadas de espera do status
    int MAX_REGISTROS_RETORNADOS_API_CONSULTA_CPFS = 10000; // N�mero m�ximo de CPFs a serem pr�-selecionados para a ades�o
    int TEMPO_ENTRE_TENTATIVAS_VERIFICACAO_ONBOARDING_SEGS = 3; // Intervalo entre as tentativas de efetuar uma consulta no banco
    int MAX_TENTATIVAS_TESTE = 5; // N�mero m�ximo de tentativas de ades�o devido a CPFs potencialmente inv�lidos

}

package constantes.adesao.multibank;

public interface Config {
    /*
    Status de onboarding do Joy esperado após a adesão
     */
    String STATUS_ONBOARDING_ESPERADO = "1";

    /*
    Tempo máximo mínimo que se pode esperar para que o status seja atualizado
     */
    int TIMEOUT_MINIMO_ESPERA_ONBOARDING = 60;

    /*
    Tempo m·ximo m·ximo que se pode esperar para o status seja atualizado
     */
    int TIMEOUT_MAXIMO_ESPERA_ONBOARDING = 5*60;

    /*
    Tempo padrão sugerido a ser utilizado nas chamadas de espera do status
    Este tempo ser· corrigido a maior ou menor sem aviso para que esteja
    sempre entre os tempos máximo mínimo e máximo máximo
     */
    int TIMEOUT_PADRAO_ESPERA_ONBOARDING = 2*60;

    /*
    Número máximo de CPFs a serem pré-selecionados para a adesão
     */
    int MAX_REGISTROS_RETORNADOS_API_CONSULTA_CPFS = 10000;

    /*
    Intervalo entre as tentativas de efetuar uma consulta no banco
    para a verificação do status de onboarding do dependente.
     */
    int TEMPO_ENTRE_TENTATIVAS_VERIFICACAO_ONBOARDING_SEGS = 3;

    /*
    Número máximo de tentativas de adesão devido a CPFs potencialmente inválidos
     */
    int MAX_TENTATIVAS_TESTE = 5;
}

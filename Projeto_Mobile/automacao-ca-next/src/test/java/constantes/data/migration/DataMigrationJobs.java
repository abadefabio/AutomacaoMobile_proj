package constantes.data.migration;

import java.time.LocalDateTime;

public enum DataMigrationJobs {

    DATAMIGRATIONTABLEUSERPASSWORDJOB("DATAMIGRATIONTABLEUSERPASSWORDJOB"),
    DATAMIGRATIONTABLECUSTOMERBANKACCOUNTTYPEJOB("DATAMIGRATIONTABLECUSTOMERBANKACCOUNTTYPEJOB"),
    DATAMIGRATIONSECURITYOFFBOARDINGJOB("DATAMIGRATIONSECURITYOFFBOARDINGJOB"),
    DATAMIGRATIONCUSTOMEROFFBOARDINGJOB("DATAMIGRATIONCUSTOMEROFFBOARDINGJOB"),
    DATAMIGRATIONSECURITYJOB("DATAMIGRATIONSECURITYJOB"),
    DATAMIGRATIONTABLECORECUSTOMERJOB("DATAMIGRATIONTABLECORECUSTOMERJOB"),
    DATAMIGRATIONTABLEDEVICEJOB("DATAMIGRATIONTABLEDEVICEJOB"),
    DATAMIGRATIONTABLEPROPOSALJOB("DATAMIGRATIONTABLEPROPOSALJOB"),
    DATAMIGRATIONTABLECUSTOMERJOB("DATAMIGRATIONTABLECUSTOMERJOB"),
    DATAMIGRATIONPARAMETERJOB("DATAMIGRATIONPARAMETERJOB"),
    DATAMIGRATIONTABLEDEVICEREGISTRATIONJOB("DATAMIGRATIONTABLEDEVICEREGISTRATIONJOB"),
    DATAMIGRATIONTABLECUSTOMERBANKACCOUNTJOB("DATAMIGRATIONTABLECUSTOMERBANKACCOUNTJOB"),
    DATAMIGRATIONCUSTOMERJOB("DATAMIGRATIONCUSTOMERJOB"),
    DATAMIGRATIONCONTACTJOB("DATAMIGRATIONCONTACTJOB"),

    PARAMETROS_JOBS(LocalDateTime.now().minusWeeks(2), LocalDateTime.now(), false),
    TIMEOUT_FINALIZACAO(120); // segundos

    String value;
    LocalDateTime startDateTime;
    LocalDateTime endDateTime;
    boolean isDeltaMigration;
    int tempoLimiteFinalizarJobs;

    DataMigrationJobs(String value){
        this.value = value;
    }

    DataMigrationJobs(LocalDateTime startDateTime, LocalDateTime endDateTime, boolean isDeltaMigration){
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.isDeltaMigration = isDeltaMigration;
    }

    DataMigrationJobs(int tempoLimiteFinalizarJobs) {
        this.tempoLimiteFinalizarJobs = tempoLimiteFinalizarJobs;
    }

    public LocalDateTime obterHoraInicial() {
        return startDateTime;
    }

    public LocalDateTime obterHoraFinal() {
        return endDateTime;
    }

    public boolean isDeltaMigration() {
        return isDeltaMigration;
    }

    public int timeoutTerminoJobs() {
        return tempoLimiteFinalizarJobs;
    }

    @Override
    public String toString(){
        return this.value;
    }
}

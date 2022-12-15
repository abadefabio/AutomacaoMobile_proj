package tools;

import static java.util.Objects.isNull;

public class Tempo {
    Long tempo;
    Long horaInicio;
    public Tempo(long tempo) {
        this.tempo = tempo;
    }

    public Boolean resta() {
        if (isNull(horaInicio)) {
            horaInicio = System.currentTimeMillis();
            return true;
        }

        if (getTempoDecorrido() >= tempo) {
            return false;
        }

        return true;
    }

    public Long getTempoDecorrido() {
        return System.currentTimeMillis() - horaInicio;
    }

    public void dormir(long dormir) {
        try {
            Thread.sleep(dormir);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

package teste;

import br.com.next.automacao.core.annotations.Jornada;
import br.com.next.automacao.core.base.TesteBase;
import br.com.next.automacao.core.constantes.Jornadas;
import br.com.next.automacao.core.massa.portal.qualidade.CasoDeTesteMassa;
import br.com.next.automacao.core.tools.ProcuraClasses;
import br.com.next.automacao.core.tools.evidencia.OperadorEvidencia;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static br.com.next.automacao.core.tools.ReadProperties.getAmbiente;

@Jornada(Jornadas.ADESAO)
public class GeradorMassaOffline extends TesteBase {

    @Test(description = "Gerador de Massa")
    @Description("Gera massa para todo MassaQA que existir.")

    @Severity(SeverityLevel.NORMAL)
    public void gerarMassa() {

        // Obtem as classes dentro do pacote funcionalidade
        List<Class> listaClassesDeMassa = null;
        try {
            listaClassesDeMassa = ProcuraClasses.getClasses("funcionalidade");
        } catch (ClassNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        //Class<?> clazzz = MassaQA16066.class;


        // Filtra a lista de classes
        // 1 - Filtra quais classes tem a interface CasoDeTesteMassa
        var listaClassesFiltradas = listaClassesDeMassa.stream()
                .filter(clazz -> Arrays.asList(clazz.getInterfaces()).contains(CasoDeTesteMassa.class))
                .collect(Collectors.toList());

        for (var clazz : listaClassesFiltradas) {

            var nomeCasoDeTesteMassa = clazz.getSimpleName();

            if (!nomeCasoDeTesteMassa.equals("MassaQA02808"))
                continue;

            OperadorEvidencia.logarPasso(nomeCasoDeTesteMassa);
            OperadorEvidencia.logarPasso("=============================================");
            OperadorEvidencia.logarPasso("\n\n");
            Constructor<?>[] constructors = clazz.getDeclaredConstructors();
            CasoDeTesteMassa casoDeTesteMassa = null;
            try {
                casoDeTesteMassa = (CasoDeTesteMassa) constructors[0].newInstance();
            } catch (InstantiationException | InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }

            StringBuilder jsonTudo = new StringBuilder();
            String jsonInicialInstancia = "{\"instancia\":[";
            jsonTudo.append(jsonInicialInstancia);

            // repetir criacao de itens do array de instancias
            boolean erroCriacaoInstancia = false;
            for (int i=0; i<=2; i++) {

                String tag = "@offline-" +
                        clazz.getSimpleName().replace("Massa", "").toUpperCase() + "-" +
                        getAmbiente().trim().toLowerCase() + "-" +
                        System.getProperty("user.name").trim().toLowerCase() + "-" +
                        System.nanoTime() + "-R/" + RandomStringUtils.randomAlphanumeric(4);
                JSONObject dados = null;
                try {
                    dados = casoDeTesteMassa.criar();
                } catch (Exception e) {
                    OperadorEvidencia.logarPasso("Erro com " + clazz.getSimpleName() +
                            "na iteração " + i);
                    erroCriacaoInstancia = true;
                    break;
                }
                String jsonArray = i > 0 ? "," : "";
                jsonArray += "{\"squad\": \"@nucleo\",\n" +
                        "        \"tags\": \"" + tag + "\"," +
                        "\"" + getAmbiente().toLowerCase().trim() + "\":" +
                        dados + // fecha ambiente // fecha instancia
                        "}";// fecha array instancia
                jsonTudo.append(jsonArray);

            } // end arrays do mesmo MassaQA

            jsonTudo.append("]}"); // finaliza json


            if (!erroCriacaoInstancia) {
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                JsonElement je = JsonParser.parseString(jsonTudo.toString());
                String prettyJsonString = gson.toJson(je);
                criarJsonOffline(prettyJsonString, clazz.getSimpleName());
            }

        } // end total do MassaQA

    }

    public void adicionarTagEmArquivo(String tag) {
            try {
                String nomeArq = System.getProperty("os.name").toLowerCase().contains("win") ?
                        "C:\\Users\\Public\\Documents\\automacao\\next\\tags-usadas.txt" :
                        "/Users/Shared/automacao/next/tags-usadas.txt";
                File f1 = new File(nomeArq);
                if(!f1.exists()) {
                    f1.createNewFile();
                }

                FileWriter fileWritter = new FileWriter(f1.getName(),true);
                BufferedWriter bw = new BufferedWriter(fileWritter);
                bw.write("\n" + tag);
                bw.close();
                System.out.println("Done");
            } catch(IOException e){
                e.printStackTrace();
            }
    }

    public void criarJsonOffline(String json, String nomeArq) {
        try {
            String nomeArqCompleto = System.getProperty("os.name").toLowerCase().contains("win") ?
                    "C:\\Users\\Public\\Documents\\next\\automacao\\offline\\" + nomeArq:
                    "/Users/Shared/next/automacao/offline/" + nomeArq;
            File file = new File(nomeArqCompleto + "-" + System.currentTimeMillis() + "-" + RandomStringUtils.randomAlphanumeric(3) + ".json");
            file.createNewFile();
            FileUtils.writeStringToFile(file, json, true);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}

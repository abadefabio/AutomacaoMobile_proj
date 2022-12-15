package br.com.next.automacao.core.base.cucumber.runners;


import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.apiguardian.api.API;
import org.testng.annotations.*;

@API(status = API.Status.STABLE)
@Test
public abstract class TestNGRunner extends FrameworkRunner {

        private TestNGCucumberRunner testNGCucumberRunner;

        @BeforeClass(alwaysRun = true, dependsOnMethods = {"criarCasoTeste", "definirParametrosTeste"})
        public void setUpClass() {
            testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        }

        @SuppressWarnings("unused")
        @Test(groups = "cucumber", description = "Runs Cucumber Scenarios", dataProvider = "scenarios")
        public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
            // the 'featureWrapper' parameter solely exists to display the feature
            // file in a test report
            testNGCucumberRunner.runScenario(pickleWrapper.getPickle());

        }

        /**
         * Returns two dimensional array of {@link PickleWrapper}s with their
         * associated {@link FeatureWrapper}s.
         *
         * @return a two dimensional array of scenarios features.
         */
        @DataProvider
        public Object[][] scenarios() {
            if (testNGCucumberRunner == null) {
                return new Object[0][0];
            }
            return testNGCucumberRunner.provideScenarios();
        }

        @AfterClass(alwaysRun = true)
        public void tearDownClass() {
            if (testNGCucumberRunner == null) {
                return;
            }
            testNGCucumberRunner.finish();
        }

}

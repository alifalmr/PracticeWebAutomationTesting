package starter;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@Main" +
                "Test"},
        features = {"classpath:features/"},
        glue = {"classpath:starter"},
        plugin = {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"}
)
public class cucumbertestsuite {}

package mine.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
  plugin = {
    "pretty",
  },
  glue = {
    "mine.stepdefs",
    "mine.support"
  },
  features = {
    "src/test/resources/"
  }
)
public class CucumberRunnerTest {}
